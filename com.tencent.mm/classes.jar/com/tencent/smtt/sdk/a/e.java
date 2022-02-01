package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class e
{
  private static String a;
  private static final Object f;
  private static HandlerThread g;
  private static Handler h;
  private String b;
  private String c;
  private String d;
  private Handler e;
  
  static
  {
    AppMethodBeat.i(219692);
    a = "EmergencyManager";
    f = new Object();
    AppMethodBeat.o(219692);
  }
  
  public e(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, "POST");
  }
  
  public e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219681);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = new Handler(paramContext.getMainLooper());
    AppMethodBeat.o(219681);
  }
  
  private static Handler b()
  {
    AppMethodBeat.i(219684);
    synchronized (f)
    {
      if (h == null)
      {
        localObject2 = new HandlerThread("HttpThread");
        g = (HandlerThread)localObject2;
        ((HandlerThread)localObject2).start();
        h = new Handler(g.getLooper());
      }
      Object localObject2 = h;
      AppMethodBeat.o(219684);
      return localObject2;
    }
  }
  
  public String a(String paramString)
  {
    AppMethodBeat.i(219699);
    TbsLog.e(a, "Request url: " + this.b + ",params: " + this.c);
    int i;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramString = (HttpURLConnection)new URL(paramString.trim()).openConnection();
      paramString.setRequestMethod(this.d);
      paramString.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
      paramString.setRequestProperty("Content-Length", this.c.length());
      paramString.setDoOutput(true);
      paramString.getOutputStream().write(this.c.getBytes());
      i = paramString.getResponseCode();
      if (200 == i)
      {
        paramString = paramString.getInputStream();
        localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          i = paramString.read(arrayOfByte);
          if (-1 == i) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
          localByteArrayOutputStream.flush();
        }
        AppMethodBeat.o(219699);
      }
    }
    catch (Exception paramString)
    {
      TbsLog.e(a, "Http exception: " + paramString.getMessage());
    }
    for (;;)
    {
      return null;
      paramString = localByteArrayOutputStream.toString("utf-8");
      AppMethodBeat.o(219699);
      return paramString;
      TbsLog.e(a, "Bad http request, code: ".concat(String.valueOf(i)));
    }
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(219695);
    b().post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(219685);
        final String str = e.this.a(e.a(e.this));
        if (str != null)
        {
          e.b(e.this).post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(219673);
              if (e.1.this.a != null) {
                e.1.this.a.a(str);
              }
              AppMethodBeat.o(219673);
            }
          });
          AppMethodBeat.o(219685);
          return;
        }
        TbsLog.e(e.a(), "Unexpected result for an empty http response: " + e.a(e.this));
        AppMethodBeat.o(219685);
      }
    });
    AppMethodBeat.o(219695);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */