package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.plugin.story.f.b;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.ui.view.CaptureView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorView;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "exit", "", "go2Capture", "onEditorPrepared", "prepareEditor", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "plugin-story_release"})
public final class StoryCaptureUI$f
  implements StoryCaptureUI.b
{
  public final void b(com.tencent.mm.plugin.story.e.a parama)
  {
    long l2 = 1L;
    AppMethodBeat.i(110008);
    j.q(parama, "captureInfo");
    ab.i("MicroMsg.StoryCaptureUI", "prepareEditor, captureView:" + StoryCaptureUI.c(this.sHv));
    StoryCaptureUI.a(this.sHv, 2);
    Object localObject = StoryCaptureUI.c(this.sHv);
    if (localObject != null) {
      ((CaptureView)localObject).postDelayed((Runnable)new StoryCaptureUI.f.a(this), 50L);
    }
    localObject = StoryCaptureUI.c(this.sHv);
    if (localObject != null) {
      ((CaptureView)localObject).lyn.stopPreview();
    }
    localObject = StoryCaptureUI.d(this.sHv);
    if (localObject != null) {
      ((EditorView)localObject).setVisibility(0);
    }
    localObject = StoryCaptureUI.d(this.sHv);
    if (localObject != null) {
      ((EditorView)localObject).setAlpha(0.0F);
    }
    localObject = StoryCaptureUI.e(this.sHv);
    if (localObject != null) {
      ((b)localObject).a(parama);
    }
    if (parama.ssp)
    {
      localObject = i.sFa;
      i.FR(19);
    }
    localObject = i.sFa;
    i.cDi().bJ(System.currentTimeMillis());
    localObject = i.sFa;
    localObject = i.cDi();
    if (parama.ssp)
    {
      l1 = 1L;
      ((as)localObject).bU(l1);
      localObject = i.sFa;
      i.cDi().bV(parama.sss.size());
      localObject = i.sFa;
      localObject = i.cDm();
      if (!parama.ssp) {
        break label303;
      }
    }
    label303:
    for (long l1 = l2;; l1 = 2L)
    {
      ((bc)localObject).dd(l1);
      localObject = i.sFa;
      i.cDm().de(parama.sss.size());
      AppMethodBeat.o(110008);
      return;
      l1 = 2L;
      break;
    }
  }
  
  public final void boQ()
  {
    AppMethodBeat.i(110007);
    StoryCaptureUI.a(this.sHv, 0);
    Object localObject = StoryCaptureUI.c(this.sHv);
    if (localObject != null) {
      ((CaptureView)localObject).setVisibility(0);
    }
    localObject = StoryCaptureUI.d(this.sHv);
    if (localObject != null) {
      ((EditorView)localObject).setVisibility(8);
    }
    localObject = StoryCaptureUI.c(this.sHv);
    if (localObject != null)
    {
      ((CaptureView)localObject).resume();
      AppMethodBeat.o(110007);
      return;
    }
    AppMethodBeat.o(110007);
  }
  
  public final void boR()
  {
    AppMethodBeat.i(110009);
    ab.i("MicroMsg.StoryCaptureUI", "onEditorPrepared, captureView:" + StoryCaptureUI.c(this.sHv));
    StoryCaptureUI.a(this.sHv, 1);
    EditorView localEditorView = StoryCaptureUI.d(this.sHv);
    if (localEditorView != null)
    {
      localEditorView.setAlpha(1.0F);
      AppMethodBeat.o(110009);
      return;
    }
    AppMethodBeat.o(110009);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(110010);
    this.sHv.setResult(-1);
    this.sHv.finish();
    AppMethodBeat.o(110010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCaptureUI.f
 * JD-Core Version:    0.7.0.1
 */