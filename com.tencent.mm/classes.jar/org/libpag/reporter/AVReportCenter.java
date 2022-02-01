package org.libpag.reporter;

import android.content.Context;
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
  private boolean enable = false;
  private String imei;
  private volatile Handler ioHandler;
  private volatile HandlerThread ioThread;
  private String os;
  private Reporter reporter;
  private boolean shareLooper = true;
  private String tmpDir;
  
  static
  {
    AppMethodBeat.i(187520);
    TAG = "AVReportCenter-" + Integer.toHexString(AVReportCenter.class.hashCode());
    ourInstance = new AVReportCenter();
    AppMethodBeat.o(187520);
  }
  
  public static AVReportCenter getInstance()
  {
    return ourInstance;
  }
  
  private void hibernate(String paramString)
  {
    AppMethodBeat.i(187446);
    hibernate(paramString, "bean");
    AppMethodBeat.o(187446);
  }
  
  private void hibernate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187459);
    if ((this.dir == null) || (this.dir.length() == 0))
    {
      AppMethodBeat.o(187459);
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
      AppMethodBeat.o(187459);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(187459);
    }
  }
  
  private void hibernateMap(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(187438);
    hibernate(toUrlParams(paramMap));
    AppMethodBeat.o(187438);
  }
  
  private String md5(String paramString)
  {
    AppMethodBeat.i(187473);
    try
    {
      for (String str = new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes(Charset.forName("UTF-8")))).toString(16); str.length() < 32; str = "0".concat(String.valueOf(str))) {}
      AppMethodBeat.o(187473);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187473);
    }
    return paramString;
  }
  
  private void putCommonData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(187430);
    paramMap.put("device", DeviceInfo.getBrand() + DeviceInfo.getDeviceName());
    paramMap.put("device_id", this.imei);
    paramMap.put("platform", "and");
    paramMap.put("os", this.os);
    paramMap.put("appid", this.app);
    paramMap.put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
    AppMethodBeat.o(187430);
  }
  
  private static String toUrlParams(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(187466);
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
        AppMethodBeat.o(187466);
        return paramMap;
      }
    }
  }
  
  public void commit(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(187531);
    if ((!this.enable) || (paramMap == null) || (this.ioHandler == null))
    {
      AppMethodBeat.o(187531);
      return;
    }
    this.ioHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187412);
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
          AVReportCenter.access$002(localAVReportCenter, new Reporter(localFile, localBoolean, (Looper)localObject));
          localObject = new HashMap();
          AVReportCenter.access$500(AVReportCenter.this, (Map)localObject);
          ((Map)localObject).putAll(paramMap);
          AVReportCenter.access$600(AVReportCenter.this, (Map)localObject);
          AppMethodBeat.o(187412);
          return;
        }
      }
    });
    AppMethodBeat.o(187531);
  }
  
  public void flush()
  {
    AppMethodBeat.i(187534);
    if (this.ioHandler == null)
    {
      AppMethodBeat.o(187534);
      return;
    }
    this.ioHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187409);
        if (AVReportCenter.this.reporter != null) {
          AVReportCenter.this.reporter.flush();
        }
        AppMethodBeat.o(187409);
      }
    });
    AppMethodBeat.o(187534);
  }
  
  public void init(Context paramContext) {}
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter
 * JD-Core Version:    0.7.0.1
 */