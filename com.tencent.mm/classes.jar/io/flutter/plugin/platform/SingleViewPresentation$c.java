package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SingleViewPresentation$c
  extends ContextWrapper
{
  private final InputMethodManager Dut;
  
  SingleViewPresentation$c(Context paramContext)
  {
    this(paramContext, null);
  }
  
  private SingleViewPresentation$c(Context paramContext, InputMethodManager paramInputMethodManager)
  {
    super(paramContext);
    AppMethodBeat.i(192772);
    if (paramInputMethodManager != null) {}
    for (;;)
    {
      this.Dut = paramInputMethodManager;
      AppMethodBeat.o(192772);
      return;
      paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    }
  }
  
  public final Context createDisplayContext(Display paramDisplay)
  {
    AppMethodBeat.i(192774);
    paramDisplay = new c(super.createDisplayContext(paramDisplay), this.Dut);
    AppMethodBeat.o(192774);
    return paramDisplay;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(192773);
    if ("input_method".equals(paramString))
    {
      paramString = this.Dut;
      AppMethodBeat.o(192773);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(192773);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.c
 * JD-Core Version:    0.7.0.1
 */