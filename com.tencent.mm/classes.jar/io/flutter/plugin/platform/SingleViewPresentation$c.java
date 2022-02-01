package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SingleViewPresentation$c
  extends ContextWrapper
{
  private final InputMethodManager KiQ;
  
  SingleViewPresentation$c(Context paramContext)
  {
    this(paramContext, null);
  }
  
  private SingleViewPresentation$c(Context paramContext, InputMethodManager paramInputMethodManager)
  {
    super(paramContext);
    AppMethodBeat.i(214865);
    if (paramInputMethodManager != null) {}
    for (;;)
    {
      this.KiQ = paramInputMethodManager;
      AppMethodBeat.o(214865);
      return;
      paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    }
  }
  
  public final Context createDisplayContext(Display paramDisplay)
  {
    AppMethodBeat.i(214867);
    paramDisplay = new c(super.createDisplayContext(paramDisplay), this.KiQ);
    AppMethodBeat.o(214867);
    return paramDisplay;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(214866);
    if ("input_method".equals(paramString))
    {
      paramString = this.KiQ;
      AppMethodBeat.o(214866);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(214866);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.c
 * JD-Core Version:    0.7.0.1
 */