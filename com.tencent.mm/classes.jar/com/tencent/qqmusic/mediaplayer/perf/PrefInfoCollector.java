package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlSerializer;

public class PrefInfoCollector
  implements PlayerInfoCollector
{
  private static final String ENCODING_UTF_8 = "utf-8";
  private static final String FILE_NAME = "pref_infos.xml";
  private static final String NAMESPACE;
  private static final String ROOT = "root";
  private static final String TAG;
  private static PrefInfoCollector instance;
  private HandlerThread mHandlerThread;
  private Handler mReportHandler;
  private FileOutputStream outputStream;
  private HashMap<String, Long> prefInfos;
  private String reportFilePath;
  private XmlSerializer xmlSerializer;
  
  static
  {
    AppMethodBeat.i(114213);
    TAG = PrefInfoCollector.class.getSimpleName();
    NAMESPACE = null;
    AppMethodBeat.o(114213);
  }
  
  private PrefInfoCollector()
  {
    AppMethodBeat.i(114201);
    this.prefInfos = null;
    this.xmlSerializer = null;
    this.prefInfos = new HashMap();
    this.xmlSerializer = Xml.newSerializer();
    AppMethodBeat.o(114201);
  }
  
  /* Error */
  private void createOutputs()
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 100	java/io/File
    //   8: dup
    //   9: invokestatic 106	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   12: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15: ldc 15
    //   17: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 116	java/io/File:exists	()Z
    //   25: ifeq +13 -> 38
    //   28: aload_1
    //   29: invokevirtual 119	java/io/File:delete	()Z
    //   32: pop
    //   33: aload_1
    //   34: invokevirtual 122	java/io/File:createNewFile	()Z
    //   37: pop
    //   38: getstatic 51	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   41: ldc 124
    //   43: aload_1
    //   44: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokevirtual 134	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 139	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: putfield 141	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:reportFilePath	Ljava/lang/String;
    //   61: aload_0
    //   62: new 143	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: putfield 148	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:outputStream	Ljava/io/FileOutputStream;
    //   73: getstatic 51	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   76: new 150	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 152
    //   82: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 141	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:reportFilePath	Ljava/lang/String;
    //   89: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 139	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: getfield 65	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   102: ldc 164
    //   104: iconst_1
    //   105: invokeinterface 170 3 0
    //   110: aload_0
    //   111: getfield 65	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   114: aload_0
    //   115: getfield 148	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:outputStream	Ljava/io/FileOutputStream;
    //   118: ldc 12
    //   120: invokeinterface 174 3 0
    //   125: aload_0
    //   126: getfield 65	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   129: ldc 12
    //   131: getstatic 180	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   134: invokeinterface 184 3 0
    //   139: ldc 98
    //   141: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: return
    //   145: astore_1
    //   146: getstatic 51	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   149: ldc 186
    //   151: aload_1
    //   152: invokestatic 190	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: new 192	java/lang/RuntimeException
    //   158: dup
    //   159: new 150	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 194
    //   165: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload_1
    //   169: invokevirtual 197	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: aload_1
    //   179: invokespecial 200	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: astore_1
    //   183: ldc 98
    //   185: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: getstatic 51	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   194: ldc 202
    //   196: aload_1
    //   197: invokestatic 190	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: new 192	java/lang/RuntimeException
    //   203: dup
    //   204: new 150	java/lang/StringBuilder
    //   207: dup
    //   208: ldc 204
    //   210: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: aload_1
    //   224: invokespecial 200	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: astore_1
    //   228: ldc 98
    //   230: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: getstatic 51	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   239: ldc 207
    //   241: aload_1
    //   242: invokestatic 190	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: new 192	java/lang/RuntimeException
    //   248: dup
    //   249: new 150	java/lang/StringBuilder
    //   252: dup
    //   253: ldc 209
    //   255: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload_1
    //   259: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   262: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: aload_1
    //   269: invokespecial 200	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: astore_1
    //   273: ldc 98
    //   275: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_1
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	PrefInfoCollector
    //   20	47	1	localFile	java.io.File
    //   145	34	1	localFileNotFoundException	java.io.FileNotFoundException
    //   182	7	1	localRuntimeException1	java.lang.RuntimeException
    //   190	34	1	localIOException1	java.io.IOException
    //   227	7	1	localRuntimeException2	java.lang.RuntimeException
    //   235	34	1	localIOException2	java.io.IOException
    //   272	7	1	localRuntimeException3	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   5	38	145	java/io/FileNotFoundException
    //   38	98	145	java/io/FileNotFoundException
    //   5	38	190	java/io/IOException
    //   38	98	190	java/io/IOException
    //   98	139	235	java/io/IOException
  }
  
  public static PrefInfoCollector getInstance()
  {
    try
    {
      AppMethodBeat.i(114202);
      if (instance == null) {
        instance = new PrefInfoCollector();
      }
      PrefInfoCollector localPrefInfoCollector = instance;
      AppMethodBeat.o(114202);
      return localPrefInfoCollector;
    }
    finally {}
  }
  
  private void printPrefInfos(AudioInformation paramAudioInformation)
  {
    AppMethodBeat.i(114207);
    Object localObject = new ArrayList(this.prefInfos.entrySet());
    Collections.sort((List)localObject, new PrefInfoCollector.1(this));
    if (!((List)localObject).isEmpty())
    {
      this.xmlSerializer.startTag(NAMESPACE, "root");
      printProperty("device.manufacturer", Build.MANUFACTURER);
      printProperty("device.model", Build.MODEL);
      printProperty("device.apiLevel", String.valueOf(Build.VERSION.SDK_INT));
      printAudioInfomation(paramAudioInformation);
      paramAudioInformation = ((List)localObject).iterator();
      while (paramAudioInformation.hasNext())
      {
        localObject = (Map.Entry)paramAudioInformation.next();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        printProperty((String)((Map.Entry)localObject).getKey(), String.valueOf(l));
      }
      this.xmlSerializer.endTag(NAMESPACE, "root");
      this.xmlSerializer.endDocument();
      this.xmlSerializer.flush();
    }
    AppMethodBeat.o(114207);
  }
  
  private void printProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114206);
    this.xmlSerializer.startTag(NAMESPACE, paramString1);
    this.xmlSerializer.text(paramString2);
    this.xmlSerializer.endTag(NAMESPACE, paramString1);
    AppMethodBeat.o(114206);
  }
  
  private void upLoadByCommonPost()
  {
    AppMethodBeat.i(114208);
    Logger.i(TAG, "upLoadByCommonPost");
    Object localObject1 = (HttpURLConnection)new URL(" http://musict.proxy.music.qq.com/qmtm2/PlayPerformanceReport.fcg").openConnection();
    ((HttpURLConnection)localObject1).setDoInput(true);
    ((HttpURLConnection)localObject1).setDoOutput(true);
    ((HttpURLConnection)localObject1).setUseCaches(false);
    ((HttpURLConnection)localObject1).setRequestMethod("POST");
    ((HttpURLConnection)localObject1).setRequestProperty("Connection", "Keep-Alive");
    ((HttpURLConnection)localObject1).setRequestProperty("Charset", "UTF-8");
    ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "text/xml");
    DataOutputStream localDataOutputStream = new DataOutputStream(((HttpURLConnection)localObject1).getOutputStream());
    Object localObject2 = new FileInputStream(this.reportFilePath);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = ((FileInputStream)localObject2).read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localDataOutputStream.write(arrayOfByte, 0, i);
    }
    ((FileInputStream)localObject2).close();
    localDataOutputStream.writeBytes("\r\n");
    localDataOutputStream.flush();
    localObject1 = ((HttpURLConnection)localObject1).getInputStream();
    localObject2 = new BufferedReader(new InputStreamReader((InputStream)localObject1, "UTF-8")).readLine();
    Logger.i(TAG, "upload result:".concat(String.valueOf(localObject2)));
    localDataOutputStream.close();
    ((InputStream)localObject1).close();
    AppMethodBeat.o(114208);
  }
  
  public void printAudioInfomation(AudioInformation paramAudioInformation)
  {
    AppMethodBeat.i(114205);
    printProperty("audio.format", paramAudioInformation.getAudioType());
    printProperty("audio.sampleRate", paramAudioInformation.getSampleRate());
    printProperty("audio.PlaySample", paramAudioInformation.getPlaySample());
    printProperty("audio.bitDepth", paramAudioInformation.getBitDepth());
    printProperty("audio.channels", paramAudioInformation.getChannels());
    printProperty("audio.duration", paramAudioInformation.getDuration());
    printProperty("audio.bitRate", paramAudioInformation.getBitrate());
    AppMethodBeat.o(114205);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean) {}
  
  public void putInt(String paramString, int paramInt) {}
  
  public void putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(114203);
    this.prefInfos.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(114203);
  }
  
  public void putString(String paramString1, String paramString2) {}
  
  public void putUri(String paramString, Uri paramUri) {}
  
  public void upLoadPrefInfos(final AudioInformation paramAudioInformation)
  {
    AppMethodBeat.i(114209);
    if ((this.prefInfos == null) || (this.prefInfos.isEmpty()))
    {
      AppMethodBeat.o(114209);
      return;
    }
    if ((this.mHandlerThread == null) || (this.mReportHandler == null))
    {
      this.mHandlerThread = new HandlerThread("PrefInfoCollector");
      this.mHandlerThread.start();
      this.mReportHandler = new Handler(this.mHandlerThread.getLooper());
    }
    this.mReportHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(114185);
        try
        {
          PrefInfoCollector.access$000(PrefInfoCollector.this);
          PrefInfoCollector.access$100(PrefInfoCollector.this, paramAudioInformation);
          PrefInfoCollector.access$200(PrefInfoCollector.this);
          AppMethodBeat.o(114185);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(PrefInfoCollector.TAG, localException);
          AppMethodBeat.o(114185);
        }
      }
    });
    AppMethodBeat.o(114209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector
 * JD-Core Version:    0.7.0.1
 */