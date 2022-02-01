package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b STI;
  
  static
  {
    AppMethodBeat.i(264135);
    STI = new b();
    AppMethodBeat.o(264135);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(264127);
    s.u(paramContext, "context");
    Object localObject = com.tencent.mm.dynamicbackground.a.b.mbC;
    s.t(paramContext, "context");
    localObject = new File(com.tencent.mm.dynamicbackground.a.b.dq(paramContext));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "scene_shaderf.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "scene_shaderf.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "scene_shaderv.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "scene_shaderv.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "frag_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "frag_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "vertex_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "vertex_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "texture_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "texture_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "texture_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "texture_fragment_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "bg_gradient_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "bg_gradient_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.n(paramContext, "bg_gradient_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.dq(paramContext) + "bg_gradient_fragment_shader.glsl");
    AppMethodBeat.o(264127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.b
 * JD-Core Version:    0.7.0.1
 */