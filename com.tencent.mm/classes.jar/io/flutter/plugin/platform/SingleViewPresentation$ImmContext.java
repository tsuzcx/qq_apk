package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SingleViewPresentation$ImmContext
  extends ContextWrapper
{
  private final InputMethodManager inputMethodManager;
  
  SingleViewPresentation$ImmContext(Context paramContext)
  {
    this(paramContext, null);
  }
  
  private SingleViewPresentation$ImmContext(Context paramContext, InputMethodManager paramInputMethodManager)
  {
    super(paramContext);
    AppMethodBeat.i(189877);
    if (paramInputMethodManager != null) {}
    for (;;)
    {
      this.inputMethodManager = paramInputMethodManager;
      AppMethodBeat.o(189877);
      return;
      paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    }
  }
  
  public Context createDisplayContext(Display paramDisplay)
  {
    AppMethodBeat.i(189897);
    paramDisplay = new ImmContext(super.createDisplayContext(paramDisplay), this.inputMethodManager);
    AppMethodBeat.o(189897);
    return paramDisplay;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(189888);
    if ("input_method".equals(paramString))
    {
      paramString = this.inputMethodManager;
      AppMethodBeat.o(189888);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(189888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.ImmContext
 * JD-Core Version:    0.7.0.1
 */