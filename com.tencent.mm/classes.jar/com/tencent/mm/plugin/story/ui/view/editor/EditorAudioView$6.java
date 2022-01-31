package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.c;
import com.tencent.mm.plugin.story.model.audio.d;
import com.tencent.mm.plugin.story.ui.a.e;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioView$6
  implements View.OnClickListener
{
  EditorAudioView$6(EditorAudioView paramEditorAudioView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151202);
    EditorAudioView.f(this.sOy).setSelection(null);
    paramView = this.sOy.getCallback();
    Object localObject;
    if (paramView != null)
    {
      localObject = AudioCacheInfo.swC;
      localObject = new AudioCacheInfo();
      ((AudioCacheInfo)localObject).type = AudioCacheInfo.cBu();
      paramView.a((AudioCacheInfo)localObject);
    }
    EditorAudioView.b(this.sOy, true);
    EditorAudioView.c(this.sOy, false);
    paramView = c.swQ;
    paramView = c.cBC();
    if (paramView != null)
    {
      localObject = new bsp();
      ((bsp)localObject).xGf = 14;
      ((bsp)localObject).xGh = ((int)bo.aox());
      paramView.swL.add(localObject);
      ab.i(c.TAG, "record enter search " + d.a((bsp)localObject));
    }
    paramView = i.sFa;
    i.cDi().Fs();
    paramView = i.sFa;
    i.cDm().FX();
    paramView = i.sFa;
    i.FR(17);
    AppMethodBeat.o(151202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.6
 * JD-Core Version:    0.7.0.1
 */