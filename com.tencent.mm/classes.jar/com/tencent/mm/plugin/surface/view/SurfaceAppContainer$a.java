package com.tencent.mm.plugin.surface.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.surface.c.e;
import com.tencent.mm.plugin.surface.c.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer$Companion;", "", "()V", "TAG", "", "createRoot", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "target", "context", "Landroid/content/Context;", "appId", "path", "query", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SurfaceAppContainer$a
{
  public static f b(Object paramObject, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(265001);
    s.u(paramObject, "target");
    s.u(paramContext, "context");
    s.u(paramString1, "appId");
    s.u(paramString2, "path");
    s.u(paramString3, "query");
    e locale = e.SLi;
    paramObject = e.a(paramObject, paramContext, paramString1, paramString2, paramString3);
    AppMethodBeat.o(265001);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.view.SurfaceAppContainer.a
 * JD-Core Version:    0.7.0.1
 */