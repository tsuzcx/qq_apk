package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Proxy;

final class SingleViewPresentation$d
  extends ContextWrapper
{
  private final SingleViewPresentation.f KPS;
  private WindowManager windowManager;
  
  SingleViewPresentation$d(Context paramContext, SingleViewPresentation.f paramf)
  {
    super(paramContext);
    this.KPS = paramf;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(9933);
    if ("window".equals(paramString))
    {
      if (this.windowManager == null)
      {
        paramString = this.KPS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.d
 * JD-Core Version:    0.7.0.1
 */