package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Proxy;

final class SingleViewPresentation$d
  extends ContextWrapper
{
  private final SingleViewPresentation.f aawp;
  private final Context aawq;
  private WindowManager windowManager;
  
  SingleViewPresentation$d(Context paramContext1, SingleViewPresentation.f paramf, Context paramContext2)
  {
    super(paramContext1);
    this.aawp = paramf;
    this.aawq = paramContext2;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(9933);
    if ("window".equals(paramString))
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i = 0;
      if ((i < arrayOfStackTraceElement.length) && (i < 11)) {
        if ((!arrayOfStackTraceElement[i].getClassName().equals(AlertDialog.class.getCanonicalName())) || (!arrayOfStackTraceElement[i].getMethodName().equals("<init>"))) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label102;
        }
        paramString = this.aawq.getSystemService(paramString);
        AppMethodBeat.o(9933);
        return paramString;
        i += 1;
        break;
      }
      label102:
      if (this.windowManager == null)
      {
        paramString = this.aawp;
        this.windowManager = ((WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, paramString));
      }
      paramString = this.windowManager;
      AppMethodBeat.o(9933);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(9933);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.d
 * JD-Core Version:    0.7.0.1
 */