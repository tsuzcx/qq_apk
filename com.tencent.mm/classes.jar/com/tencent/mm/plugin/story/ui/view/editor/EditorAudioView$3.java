package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.c;
import com.tencent.mm.plugin.story.model.audio.d;
import com.tencent.mm.plugin.story.ui.a.e;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioView$3
  implements View.OnClickListener
{
  EditorAudioView$3(EditorAudioView paramEditorAudioView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110510);
    paramView = this.sOy;
    if (!EditorAudioView.k(this.sOy)) {}
    for (boolean bool = true;; bool = false)
    {
      EditorAudioView.d(paramView, bool);
      if (EditorAudioView.k(this.sOy)) {
        break;
      }
      paramView = this.sOy.getCallback();
      if (paramView != null) {
        paramView.a(null);
      }
      EditorAudioView.f(this.sOy).setSelection(null);
      EditorAudioView.e(this.sOy).setSelection(null);
      paramView = c.swQ;
      paramView = c.cBC();
      if (paramView != null)
      {
        paramView.swK = false;
        bsp localbsp = new bsp();
        localbsp.xGe = paramView.swI;
        localbsp.xGf = 8;
        localbsp.xGh = ((int)bo.aox());
        paramView.swL.add(localbsp);
        ab.i(c.TAG, "record no bgm " + d.a(localbsp));
      }
      EditorAudioView.m(this.sOy);
      EditorAudioView.n(this.sOy).setImageDrawable(aj.g(this.hEq, 2131232142, -1));
      AppMethodBeat.o(110510);
      return;
    }
    if (EditorAudioView.o(this.sOy) != -1)
    {
      this.sOy.Gg(EditorAudioView.o(this.sOy));
      AppMethodBeat.o(110510);
      return;
    }
    paramView = EditorAudioView.e(this.sOy);
    paramView.Gg(paramView.lK);
    AppMethodBeat.o(110510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.3
 * JD-Core Version:    0.7.0.1
 */