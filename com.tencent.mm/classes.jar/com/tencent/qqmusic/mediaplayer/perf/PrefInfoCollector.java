package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
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
import java.util.Comparator;
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
  private static final String NAMESPACE = null;
  private static final String ROOT = "root";
  private static final String TAG = PrefInfoCollector.class.getSimpleName();
  private static PrefInfoCollector instance;
  private HandlerThread mHandlerThread;
  private Handler mReportHandler;
  private FileOutputStream outputStream;
  private HashMap<String, Long> prefInfos = null;
  private String reportFilePath;
  private XmlSerializer xmlSerializer = null;
  
  /* Error */
  private void createOutputs()
  {
    // Byte code:
    //   0: new 85	java/io/File
    //   3: dup
    //   4: invokestatic 91	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: ldc 15
    //   12: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 101	java/io/File:exists	()Z
    //   20: ifeq +13 -> 33
    //   23: aload_1
    //   24: invokevirtual 104	java/io/File:delete	()Z
    //   27: pop
    //   28: aload_1
    //   29: invokevirtual 107	java/io/File:createNewFile	()Z
    //   32: pop
    //   33: getstatic 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   36: new 109	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 111
    //   42: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 126	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: putfield 128	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:reportFilePath	Ljava/lang/String;
    //   63: aload_0
    //   64: new 130	java/io/FileOutputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: putfield 135	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:outputStream	Ljava/io/FileOutputStream;
    //   75: getstatic 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   78: new 109	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 137
    //   84: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: getfield 128	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:reportFilePath	Ljava/lang/String;
    //   91: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 126	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 54	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   104: ldc 142
    //   106: iconst_1
    //   107: invokeinterface 148 3 0
    //   112: aload_0
    //   113: getfield 54	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   116: aload_0
    //   117: getfield 135	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:outputStream	Ljava/io/FileOutputStream;
    //   120: ldc 12
    //   122: invokeinterface 152 3 0
    //   127: aload_0
    //   128: getfield 54	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   131: ldc 12
    //   133: iconst_1
    //   134: invokestatic 158	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   137: invokeinterface 162 3 0
    //   142: return
    //   143: astore_1
    //   144: getstatic 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   147: ldc 164
    //   149: aload_1
    //   150: invokestatic 168	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: new 170	java/lang/RuntimeException
    //   156: dup
    //   157: new 109	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 172
    //   163: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 175	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   170: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aload_1
    //   177: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: athrow
    //   181: astore_1
    //   182: getstatic 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   185: ldc 180
    //   187: aload_1
    //   188: invokestatic 168	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: new 170	java/lang/RuntimeException
    //   194: dup
    //   195: new 109	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 182
    //   201: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload_1
    //   205: invokevirtual 183	java/io/IOException:getMessage	()Ljava/lang/String;
    //   208: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: aload_1
    //   215: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: athrow
    //   219: astore_1
    //   220: getstatic 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   223: ldc 185
    //   225: aload_1
    //   226: invokestatic 168	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: new 170	java/lang/RuntimeException
    //   232: dup
    //   233: new 109	java/lang/StringBuilder
    //   236: dup
    //   237: ldc 187
    //   239: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_1
    //   243: invokevirtual 183	java/io/IOException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload_1
    //   253: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	PrefInfoCollector
    //   15	54	1	localFile	java.io.File
    //   143	34	1	localFileNotFoundException	java.io.FileNotFoundException
    //   181	34	1	localIOException1	java.io.IOException
    //   219	34	1	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	33	143	java/io/FileNotFoundException
    //   33	100	143	java/io/FileNotFoundException
    //   0	33	181	java/io/IOException
    //   33	100	181	java/io/IOException
    //   100	142	219	java/io/IOException
  }
  
  public static PrefInfoCollector getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new PrefInfoCollector();
      }
      PrefInfoCollector localPrefInfoCollector = instance;
      return localPrefInfoCollector;
    }
    finally {}
  }
  
  private void printPrefInfos(AudioInformation paramAudioInformation)
  {
    Object localObject = new ArrayList(this.prefInfos.entrySet());
    Collections.sort((List)localObject, new Comparator()
    {
      public int compare(Map.Entry<String, Long> paramAnonymousEntry1, Map.Entry<String, Long> paramAnonymousEntry2)
      {
        if (((String)paramAnonymousEntry1.getKey()).charAt(0) > ((String)paramAnonymousEntry2.getKey()).charAt(0)) {
          return 1;
        }
        if (((String)paramAnonymousEntry1.getKey()).charAt(0) == ((String)paramAnonymousEntry2.getKey()).charAt(0)) {
          return 0;
        }
        return -1;
      }
    });
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
  }
  
  private void printProperty(String paramString1, String paramString2)
  {
    this.xmlSerializer.startTag(NAMESPACE, paramString1);
    this.xmlSerializer.text(paramString2);
    this.xmlSerializer.endTag(NAMESPACE, paramString1);
  }
  
  private void upLoadByCommonPost()
  {
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
    Logger.i(TAG, "upload result:" + (String)localObject2);
    localDataOutputStream.close();
    ((InputStream)localObject1).close();
  }
  
  public void printAudioInfomation(AudioInformation paramAudioInformation)
  {
    printProperty("audio.format", paramAudioInformation.getAudioType());
    printProperty("audio.sampleRate", paramAudioInformation.getSampleRate());
    printProperty("audio.PlaySample", paramAudioInformation.getPlaySample());
    printProperty("audio.bitDepth", paramAudioInformation.getBitDept());
    printProperty("audio.channels", paramAudioInformation.getChannels());
    printProperty("audio.duration", paramAudioInformation.getDuration());
    printProperty("audio.bitRate", paramAudioInformation.getBitrate());
  }
  
  public void putBoolean(String paramString, boolean paramBoolean) {}
  
  public void putInt(String paramString, int paramInt) {}
  
  public void putLong(String paramString, long paramLong)
  {
    this.prefInfos.put(paramString, Long.valueOf(paramLong));
  }
  
  public void putString(String paramString1, String paramString2) {}
  
  public void putUri(String paramString, Uri paramUri) {}
  
  public void upLoadPrefInfos(AudioInformation paramAudioInformation)
  {
    if ((this.prefInfos == null) || (this.prefInfos.isEmpty())) {
      return;
    }
    if ((this.mHandlerThread == null) || (this.mReportHandler == null))
    {
      this.mHandlerThread = new HandlerThread("PrefInfoCollector");
      this.mHandlerThread.start();
      this.mReportHandler = new Handler(this.mHandlerThread.getLooper());
    }
    this.mReportHandler.post(new PrefInfoCollector.2(this, paramAudioInformation));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector
 * JD-Core Version:    0.7.0.1
 */