package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.smtt.utils.TbsLogClient;
import org.xwalk.core.Log;

final class X5WebFactory$a
  extends TbsLogClient
{
  public X5WebFactory$a(X5WebFactory paramX5WebFactory, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void d(String paramString1, String paramString2)
  {
    super.d(paramString1, paramString2);
    Log.d(paramString1, paramString2);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    super.e(paramString1, paramString2);
    Log.e(paramString1, paramString2);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    super.i(paramString1, paramString2);
    Log.i(paramString1, paramString2);
  }
  
  public final void setLogView(TextView paramTextView)
  {
    super.setLogView(paramTextView);
  }
  
  public final void showLog(String paramString)
  {
    super.showLog(paramString);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    super.v(paramString1, paramString2);
    Log.v(paramString1, paramString2);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    super.w(paramString1, paramString2);
    Log.w(paramString1, paramString2);
  }
  
  public final void writeLog(String paramString)
  {
    super.writeLog(paramString);
  }
  
  public final void writeLogToDisk()
  {
    super.writeLogToDisk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory.a
 * JD-Core Version:    0.7.0.1
 */