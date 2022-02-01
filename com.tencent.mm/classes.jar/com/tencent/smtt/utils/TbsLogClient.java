package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient
{
  static TbsLogClient a = null;
  static File c = null;
  static String d = null;
  static byte[] e = null;
  private static boolean i = true;
  TextView b;
  private SimpleDateFormat f;
  private Context g;
  private StringBuffer h;
  
  public TbsLogClient(Context paramContext)
  {
    AppMethodBeat.i(53929);
    this.f = null;
    this.g = null;
    this.h = new StringBuffer();
    try
    {
      this.g = paramContext.getApplicationContext();
      this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
      AppMethodBeat.o(53929);
      return;
    }
    catch (Exception paramContext)
    {
      this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
      AppMethodBeat.o(53929);
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(53930);
    try
    {
      if (c == null) {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          String str = f.a(this.g, 6);
          if (str == null)
          {
            c = null;
            AppMethodBeat.o(53930);
            return;
          }
          c = new File(str, "tbslog.txt");
          d = LogFileUtils.createKey();
          e = LogFileUtils.createHeaderText(c.getName(), d);
          AppMethodBeat.o(53930);
          return;
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      AppMethodBeat.o(53930);
      return;
      c = null;
      AppMethodBeat.o(53930);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(53930);
    }
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2) {}
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    AppMethodBeat.i(53933);
    if (this.b != null) {
      this.b.post(new TbsLogClient.a(this, paramString));
    }
    AppMethodBeat.o(53933);
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    AppMethodBeat.i(53931);
    try
    {
      String str = this.f.format(Long.valueOf(System.currentTimeMillis()));
      this.h.append(str).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(paramString).append("\n");
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) || (i)) {
        writeLogToDisk();
      }
      if (this.h.length() > 524288) {
        this.h.delete(0, this.h.length());
      }
      AppMethodBeat.o(53931);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(53931);
    }
  }
  
  public void writeLogToDisk()
  {
    AppMethodBeat.i(53932);
    try
    {
      a();
      if (c != null)
      {
        LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
        this.h.delete(0, this.h.length());
      }
      AppMethodBeat.o(53932);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(53932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient
 * JD-Core Version:    0.7.0.1
 */