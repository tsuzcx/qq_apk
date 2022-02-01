package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-taskbar_release"})
public final class b
{
  public static final b FVa;
  
  static
  {
    AppMethodBeat.i(238471);
    FVa = new b();
    AppMethodBeat.o(238471);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(238470);
    p.h(paramContext, "context");
    Object localObject = com.tencent.mm.dynamicbackground.a.b.gRt;
    p.h(paramContext, "context");
    localObject = new File(com.tencent.mm.dynamicbackground.a.b.cF(paramContext));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "scene_shaderf.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "scene_shaderf.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "scene_shaderv.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "scene_shaderv.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "frag_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "frag_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "vertex_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "vertex_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "texture_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "texture_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "texture_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "texture_fragment_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "bg_gradient_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "bg_gradient_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.j(paramContext, "bg_gradient_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cF(paramContext) + "bg_gradient_fragment_shader.glsl");
    AppMethodBeat.o(238470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.b
 * JD-Core Version:    0.7.0.1
 */