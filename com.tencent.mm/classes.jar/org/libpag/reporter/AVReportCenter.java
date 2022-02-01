package org.libpag.reporter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Random;
import java.util.Set;

public class AVReportCenter
{
  private static final String TAG;
  private static final AVReportCenter ourInstance;
  private String app;
  private Boolean auto = Boolean.TRUE;
  private String dir;
  private boolean enable = true;
  private String imei;
  private volatile Handler ioHandler;
  private volatile HandlerThread ioThread;
  private String os;
  private Reporter reporter;
  private boolean shareLooper = true;
  private String tmpDir;
  
  static
  {
    AppMethodBeat.i(195546);
    TAG = "AVReportCenter-" + Integer.toHexString(AVReportCenter.class.hashCode());
    ourInstance = new AVReportCenter();
    AppMethodBeat.o(195546);
  }
  
  public static AVReportCenter getInstance()
  {
    return ourInstance;
  }
  
  private void hibernate(String paramString)
  {
    AppMethodBeat.i(195529);
    hibernate(paramString, "bean");
    AppMethodBeat.o(195529);
  }
  
  private void hibernate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195532);
    if ((this.dir == null) || (this.dir.length() == 0))
    {
      AppMethodBeat.o(195532);
      return;
    }
    try
    {
      File localFile = new File(this.tmpDir + File.separator + paramString2 + "." + System.nanoTime());
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      paramString1 = paramString1.getBytes();
      int i = 0;
      while (i < paramString1.length)
      {
        paramString1[i] = ((byte)(paramString1[i] ^ 0xFFFFFFE9));
        i += 1;
      }
      localFileOutputStream.write(paramString1);
      localFileOutputStream.close();
      localFile.renameTo(new File(this.dir + File.separator + paramString2 + "." + System.nanoTime()));
      AppMethodBeat.o(195532);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(195532);
    }
  }
  
  private void hibernateMap(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(195524);
    hibernate(toUrlParams(paramMap));
    AppMethodBeat.o(195524);
  }
  
  private String md5(String paramString)
  {
    AppMethodBeat.i(195536);
    try
    {
      for (String str = new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes(Charset.forName("UTF-8")))).toString(16); str.length() < 32; str = "0".concat(String.valueOf(str))) {}
      AppMethodBeat.o(195536);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(195536);
    }
    return paramString;
  }
  
  private void putCommonData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(195522);
    paramMap.put("device", DeviceInfo.getBrand() + DeviceInfo.getDeviceName());
    paramMap.put("device_id", this.imei);
    paramMap.put("platform", "and");
    paramMap.put("os", this.os);
    paramMap.put("appid", this.app);
    paramMap.put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
    AppMethodBeat.o(195522);
  }
  
  private static String toUrlParams(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(195535);
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = "attaid=06400000136&token=3598698434";
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        localObject1 = ((Map.Entry)localObject2).getValue();
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        if ((localObject1 instanceof Number)) {
          paramMap = paramMap + "&" + (String)localObject2 + "=" + localObject1.toString();
        } else if (!(localObject1 instanceof String)) {}
      }
      else
      {
        try
        {
          localObject1 = paramMap + "&" + (String)localObject2 + "=" + URLEncoder.encode(localObject1.toString(), "UTF-8");
          paramMap = (Map<String, Object>)localObject1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        AppMethodBeat.o(195535);
        return paramMap;
      }
    }
  }
  
  public void commit(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(195526);
    if ((!this.enable) || (paramMap == null) || (this.ioHandler == null))
    {
      AppMethodBeat.o(195526);
      return;
    }
    this.ioHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195513);
        AVReportCenter localAVReportCenter;
        File localFile;
        Boolean localBoolean;
        if (AVReportCenter.this.reporter == null)
        {
          localAVReportCenter = AVReportCenter.this;
          localFile = new File(AVReportCenter.this.dir);
          localBoolean = AVReportCenter.this.auto;
          if (!AVReportCenter.this.shareLooper) {
            break label121;
          }
        }
        label121:
        for (Object localObject = AVReportCenter.this.ioHandler.getLooper();; localObject = null)
        {
          AVReportCenter.access$202(localAVReportCenter, new Reporter(localFile, localBoolean, (Looper)localObject));
          localObject = new HashMap();
          AVReportCenter.access$600(AVReportCenter.this, (Map)localObject);
          ((Map)localObject).putAll(paramMap);
          AVReportCenter.access$700(AVReportCenter.this, (Map)localObject);
          AppMethodBeat.o(195513);
          return;
        }
      }
    });
    AppMethodBeat.o(195526);
  }
  
  public void flush()
  {
    AppMethodBeat.i(195527);
    if (this.ioHandler == null)
    {
      AppMethodBeat.o(195527);
      return;
    }
    this.ioHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(195514);
        if (AVReportCenter.this.reporter != null) {
          AVReportCenter.this.reporter.flush();
        }
        AppMethodBeat.o(195514);
      }
    });
    AppMethodBeat.o(195527);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"MissingPermission"})
  public void init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 108	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   10: ifnonnull +376 -> 386
    //   13: ldc 2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 108	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   20: ifnull +13 -> 33
    //   23: ldc 2
    //   25: monitorexit
    //   26: ldc_w 343
    //   29: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: return
    //   33: aload_0
    //   34: new 41	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   41: aload_1
    //   42: invokestatic 347	org/libpag/reporter/DeviceInfo:getRomFingerprint	(Landroid/content/Context;)Ljava/lang/String;
    //   45: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokestatic 350	org/libpag/reporter/DeviceInfo:getApiLevelInt	()I
    //   51: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: putfield 253	org/libpag/reporter/AVReportCenter:os	Ljava/lang/String;
    //   60: aload_0
    //   61: ldc_w 355
    //   64: putfield 257	org/libpag/reporter/AVReportCenter:app	Ljava/lang/String;
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 360	android/content/Context:getPackageName	()Ljava/lang/String;
    //   72: putfield 257	org/libpag/reporter/AVReportCenter:app	Ljava/lang/String;
    //   75: aload_1
    //   76: invokevirtual 364	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   79: astore_2
    //   80: aload_2
    //   81: ifnonnull +13 -> 94
    //   84: ldc 2
    //   86: monitorexit
    //   87: ldc_w 343
    //   90: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: new 41	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   101: aload_2
    //   102: invokevirtual 367	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   105: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 143	java/io/File:separator	Ljava/lang/String;
    //   111: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: aload_0
    //   116: invokevirtual 371	java/lang/Object:getClass	()Ljava/lang/Class;
    //   119: invokevirtual 376	java/lang/Class:getName	()Ljava/lang/String;
    //   122: invokespecial 378	org/libpag/reporter/AVReportCenter:md5	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_0
    //   133: new 41	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   140: aload_2
    //   141: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 380
    //   147: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: putfield 91	org/libpag/reporter/AVReportCenter:dir	Ljava/lang/String;
    //   156: new 139	java/io/File
    //   159: dup
    //   160: aload_0
    //   161: getfield 91	org/libpag/reporter/AVReportCenter:dir	Ljava/lang/String;
    //   164: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: astore_3
    //   168: aload_3
    //   169: invokevirtual 383	java/io/File:exists	()Z
    //   172: ifne +8 -> 180
    //   175: aload_3
    //   176: invokevirtual 386	java/io/File:mkdirs	()Z
    //   179: pop
    //   180: aload_0
    //   181: new 41	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   188: aload_2
    //   189: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 388
    //   195: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: putfield 94	org/libpag/reporter/AVReportCenter:tmpDir	Ljava/lang/String;
    //   204: new 139	java/io/File
    //   207: dup
    //   208: aload_0
    //   209: getfield 94	org/libpag/reporter/AVReportCenter:tmpDir	Ljava/lang/String;
    //   212: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: astore_2
    //   216: aload_2
    //   217: invokevirtual 383	java/io/File:exists	()Z
    //   220: ifne +8 -> 228
    //   223: aload_2
    //   224: invokevirtual 386	java/io/File:mkdirs	()Z
    //   227: pop
    //   228: getstatic 394	android/os/Build$VERSION:SDK_INT	I
    //   231: bipush 26
    //   233: if_icmplt +100 -> 333
    //   236: aload_0
    //   237: aload_1
    //   238: invokevirtual 398	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   241: ldc_w 400
    //   244: invokestatic 406	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   247: putfield 246	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   250: aload_0
    //   251: new 408	android/os/HandlerThread
    //   254: dup
    //   255: getstatic 67	org/libpag/reporter/AVReportCenter:TAG	Ljava/lang/String;
    //   258: invokespecial 409	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   261: putfield 411	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   264: aload_0
    //   265: getfield 411	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   268: iconst_1
    //   269: invokevirtual 415	android/os/HandlerThread:setDaemon	(Z)V
    //   272: aload_0
    //   273: getfield 411	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   276: invokevirtual 418	android/os/HandlerThread:start	()V
    //   279: aload_0
    //   280: getfield 411	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   283: invokevirtual 421	android/os/HandlerThread:isAlive	()Z
    //   286: ifeq -7 -> 279
    //   289: aload_0
    //   290: new 327	android/os/Handler
    //   293: dup
    //   294: aload_0
    //   295: getfield 411	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   298: invokevirtual 425	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   301: invokespecial 428	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   304: putfield 108	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   307: aload_0
    //   308: getfield 108	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   311: new 6	org/libpag/reporter/AVReportCenter$1
    //   314: dup
    //   315: aload_0
    //   316: invokespecial 429	org/libpag/reporter/AVReportCenter$1:<init>	(Lorg/libpag/reporter/AVReportCenter;)V
    //   319: invokevirtual 331	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   322: pop
    //   323: ldc 2
    //   325: monitorexit
    //   326: ldc_w 343
    //   329: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: return
    //   333: aload_0
    //   334: aload_1
    //   335: ldc_w 431
    //   338: invokevirtual 435	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   341: checkcast 437	android/telephony/TelephonyManager
    //   344: invokevirtual 440	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   347: putfield 246	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   350: goto -100 -> 250
    //   353: astore_1
    //   354: aload_0
    //   355: ldc 218
    //   357: putfield 246	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   360: goto -110 -> 250
    //   363: astore_1
    //   364: ldc 2
    //   366: monitorexit
    //   367: ldc_w 343
    //   370: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   373: return
    //   374: astore_1
    //   375: ldc 2
    //   377: monitorexit
    //   378: ldc_w 343
    //   381: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload_1
    //   385: athrow
    //   386: ldc_w 343
    //   389: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: return
    //   393: astore_2
    //   394: goto -319 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	AVReportCenter
    //   0	397	1	paramContext	android.content.Context
    //   79	145	2	localObject	Object
    //   393	1	2	localException	Exception
    //   167	9	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   228	250	353	java/lang/Exception
    //   333	350	353	java/lang/Exception
    //   33	67	363	java/lang/Exception
    //   75	80	363	java/lang/Exception
    //   94	180	363	java/lang/Exception
    //   180	228	363	java/lang/Exception
    //   354	360	363	java/lang/Exception
    //   16	26	374	finally
    //   33	67	374	finally
    //   67	75	374	finally
    //   75	80	374	finally
    //   84	87	374	finally
    //   94	180	374	finally
    //   180	228	374	finally
    //   228	250	374	finally
    //   250	279	374	finally
    //   279	326	374	finally
    //   333	350	374	finally
    //   354	360	374	finally
    //   364	367	374	finally
    //   67	75	393	java/lang/Exception
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter
 * JD-Core Version:    0.7.0.1
 */