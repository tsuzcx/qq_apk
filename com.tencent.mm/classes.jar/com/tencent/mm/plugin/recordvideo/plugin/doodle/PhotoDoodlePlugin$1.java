package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class PhotoDoodlePlugin$1
  implements View.OnClickListener
{
  PhotoDoodlePlugin$1(PhotoDoodlePlugin paramPhotoDoodlePlugin) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75722);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = PhotoDoodlePlugin.d(this.xCL);
    if (paramView != null) {
      d.b.a(paramView, d.c.xFk);
    }
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.1
 * JD-Core Version:    0.7.0.1
 */