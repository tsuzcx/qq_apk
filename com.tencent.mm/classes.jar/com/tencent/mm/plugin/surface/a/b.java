package com.tencent.mm.plugin.surface.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.surface.core.e;
import com.tencent.mm.plugin.surface.core.i;
import com.tencent.mm.pluginsdk.cmd.a;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/debugger/SurfaceProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final a SKI;
  
  static
  {
    AppMethodBeat.i(265006);
    SKI = new a((byte)0);
    AppMethodBeat.o(265006);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(265011);
    s.u(paramContext, "context");
    s.u(paramArrayOfString, "args");
    s.u(paramString, "username");
    if (!s.p(a.a(paramArrayOfString, 0), "//surface"))
    {
      AppMethodBeat.o(265011);
      return false;
    }
    paramString = a.a(paramArrayOfString, 1);
    if (s.p(paramString, "ui"))
    {
      paramString = new Intent();
      if (paramArrayOfString.length > 2) {
        paramString.putStringArrayListExtra("appIds", com.tencent.luggage.l.c.toArrayList(k.e(paramArrayOfString, 2, paramArrayOfString.length)));
      }
      com.tencent.mm.br.c.b(paramContext, "surface", ".test.TestUI", paramString);
      AppMethodBeat.o(265011);
      return true;
    }
    if (s.p(paramString, "downloadPkg"))
    {
      paramContext = i.SKz;
      i.check();
      e.SKg.bcU("wx9e221f7828fa7482");
      AppMethodBeat.o(265011);
      return true;
    }
    AppMethodBeat.o(265011);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/debugger/SurfaceProcessorCommand$Companion;", "", "()V", "COMMAND", "", "COMMAND_DOWNLOAD_PKG", "COMMAND_TEST_UI", "TAG", "register", "", "register$plugin_surface_app_release", "showToast", "content", "safeGet", "", "index", "", "fallback", "([Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;", "toast", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String a(String[] paramArrayOfString, int paramInt, String paramString)
    {
      if (paramArrayOfString.length > paramInt) {
        paramString = paramArrayOfString[paramInt];
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.a.b
 * JD-Core Version:    0.7.0.1
 */