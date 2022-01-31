package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(84864);
    super.d(paramString1, paramString2);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(84864);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84862);
    super.e(paramString1, paramString2);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(84862);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84861);
    super.i(paramString1, paramString2);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(84861);
  }
  
  public final void setLogView(TextView paramTextView)
  {
    AppMethodBeat.i(84860);
    super.setLogView(paramTextView);
    AppMethodBeat.o(84860);
  }
  
  public final void showLog(String paramString)
  {
    AppMethodBeat.i(84859);
    super.showLog(paramString);
    AppMethodBeat.o(84859);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84865);
    super.v(paramString1, paramString2);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(84865);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84863);
    super.w(paramString1, paramString2);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(84863);
  }
  
  public final void writeLog(String paramString)
  {
    AppMethodBeat.i(84857);
    super.writeLog(paramString);
    AppMethodBeat.o(84857);
  }
  
  public final void writeLogToDisk()
  {
    AppMethodBeat.i(84858);
    super.writeLogToDisk();
    AppMethodBeat.o(84858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory.a
 * JD-Core Version:    0.7.0.1
 */