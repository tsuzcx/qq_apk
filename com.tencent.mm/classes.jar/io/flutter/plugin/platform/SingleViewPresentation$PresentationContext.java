package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SingleViewPresentation$PresentationContext
  extends ContextWrapper
{
  private final Context flutterAppWindowContext;
  private WindowManager windowManager;
  private final SingleViewPresentation.WindowManagerHandler windowManagerHandler;
  
  SingleViewPresentation$PresentationContext(Context paramContext1, SingleViewPresentation.WindowManagerHandler paramWindowManagerHandler, Context paramContext2)
  {
    super(paramContext1);
    this.windowManagerHandler = paramWindowManagerHandler;
    this.flutterAppWindowContext = paramContext2;
  }
  
  private WindowManager getWindowManager()
  {
    AppMethodBeat.i(189878);
    if (this.windowManager == null) {
      this.windowManager = this.windowManagerHandler.getWindowManager();
    }
    WindowManager localWindowManager = this.windowManager;
    AppMethodBeat.o(189878);
    return localWindowManager;
  }
  
  private boolean isCalledFromAlertDialog()
  {
    AppMethodBeat.i(189890);
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    while ((i < arrayOfStackTraceElement.length) && (i < 11))
    {
      if ((arrayOfStackTraceElement[i].getClassName().equals(AlertDialog.class.getCanonicalName())) && (arrayOfStackTraceElement[i].getMethodName().equals("<init>")))
      {
        AppMethodBeat.o(189890);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(189890);
    return false;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(9933);
    if ("window".equals(paramString))
    {
      if (isCalledFromAlertDialog())
      {
        paramString = this.flutterAppWindowContext.getSystemService(paramString);
        AppMethodBeat.o(9933);
        return paramString;
      }
      paramString = getWindowManager();
      AppMethodBeat.o(9933);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(9933);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.PresentationContext
 * JD-Core Version:    0.7.0.1
 */