package com.tencent.mm.plugin.recordvideo.activity;

import a.f.b.j;
import a.l;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView.b;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.p.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.w;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MMRecordUI$c
  implements Runnable
{
  MMRecordUI$c(MMRecordUI paramMMRecordUI, com.tencent.mm.media.widget.camerarecordview.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(150539);
    MMRecordUI.a(this.qaJ, 3);
    MMRecordUI.a(this.qaJ, (BasePluginLayout)MMRecordUI.b(this.qaJ));
    EditorVideoPluginLayoutNew localEditorVideoPluginLayoutNew = MMRecordUI.b(this.qaJ);
    Object localObject1;
    if (localEditorVideoPluginLayoutNew != null)
    {
      com.tencent.mm.media.widget.camerarecordview.a.b localb = this.qaK;
      j.q(localb, "info");
      ab.i("MicroMsg.EditorVideoPluginLayoutNew", "info ".concat(String.valueOf(localb)));
      localEditorVideoPluginLayoutNew.qbS = localb;
      long l = bo.yB();
      localObject1 = localEditorVideoPluginLayoutNew.qdU;
      Object localObject2 = localEditorVideoPluginLayoutNew.qaF;
      if (localObject2 == null) {
        break label795;
      }
      i = ((RecordConfigProvider)localObject2).qbx;
      j.q(localb, "info");
      ab.i("MicroMsg.EditVideoPlayPlugin", "start preview ".concat(String.valueOf(localb)));
      ((p)localObject1).qbS = localb;
      ((p)localObject1).qcA = i;
      ((p)localObject1).gaP = new com.tencent.mm.compatible.util.b(((p)localObject1).oKC.getContext());
      localObject2 = ((p)localObject1).gaP;
      if (localObject2 != null) {
        ((com.tencent.mm.compatible.util.b)localObject2).requestFocus();
      }
      ((p)localObject1).oKC.setVisibility(0);
      ((p)localObject1).oKC.setAlpha(0.0F);
      ((p)localObject1).oKC.setVideoPath(localb.fbn);
      ((p)localObject1).oKC.setForceScaleFullScreen(true);
      ((p)localObject1).oKC.setVideoCallback((e.a)((p)localObject1).qcE);
      ((p)localObject1).startTime = localb.startTime;
      ((p)localObject1).endTime = localb.endTime;
      localObject2 = ((p)localObject1).qcF;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((p)localObject1).qcF;
      if ((localObject2 != null) && (bp.dud())) {
        i.O((Runnable)new p.c((TextView)localObject2, (p)localObject1));
      }
      ab.d("MicroMsg.EditorVideoPluginLayoutNew", "previewPlugin " + bo.av(l));
      localObject1 = localEditorVideoPluginLayoutNew.qee;
      localObject2 = localEditorVideoPluginLayoutNew.qaF;
      if (localObject2 == null) {
        j.ebi();
      }
      j.q(localb, "info");
      j.q(localObject2, "configProvider");
      ((w)localObject1).oQp = localb;
      ((w)localObject1).qaF = ((RecordConfigProvider)localObject2);
      ab.d("MicroMsg.EditorVideoPluginLayoutNew", "reMuxPlugin " + bo.av(l));
      localObject1 = localEditorVideoPluginLayoutNew.qed;
      localObject2 = localEditorVideoPluginLayoutNew.qbS;
      if (localObject2 == null) {
        j.ebi();
      }
      RecordConfigProvider localRecordConfigProvider = localEditorVideoPluginLayoutNew.qaF;
      if (localRecordConfigProvider == null) {
        j.ebi();
      }
      j.q(localObject2, "info");
      j.q(localRecordConfigProvider, "configProvider");
      ((a)localObject1).qdm = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2);
      ((a)localObject1).qaF = localRecordConfigProvider;
      EditVideoSeekBarView localEditVideoSeekBarView = ((a)localObject1).qdl;
      Object localObject3 = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).fbn;
      i = a.fm(localRecordConfigProvider.qbx, ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).endTime);
      j.q(localObject3, "path");
      if (!localEditVideoSeekBarView.hasInit)
      {
        localEditVideoSeekBarView.hasInit = true;
        localEditVideoSeekBarView.oQL.Ub((String)localObject3);
        localObject3 = new VideoTransPara();
        ((VideoTransPara)localObject3).duration = (i / 1000);
        localEditVideoSeekBarView.oQL.setVideoTransPara((VideoTransPara)localObject3);
        localEditVideoSeekBarView.oQL.setOnPreparedListener((c.a)EditVideoSeekBarView.b.qds);
      }
      ((a)localObject1).qdl.setThumbBarSeekListener((c.b)localObject1);
      ((a)localObject1).qdo = (a.fm(localRecordConfigProvider.qbx, ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).endTime) * 1.0F / ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).endTime);
      ab.d("MicroMsg.EditorVideoPluginLayoutNew", "cropVideoPlugin " + bo.av(l));
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MEDIA_TYPE_INT", Integer.valueOf(2));
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      localObject1 = localEditorVideoPluginLayoutNew.qbS;
      if (localObject1 == null) {
        break label802;
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).endTime);
      label685:
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", localObject1);
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      if (!localb.fbp)
      {
        localObject1 = localEditorVideoPluginLayoutNew.qaF;
        if (localObject1 == null) {
          break label811;
        }
      }
    }
    label795:
    label802:
    label811:
    for (int i = ((RecordConfigProvider)localObject1).scene;; i = 0)
    {
      if (i > 0)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(150539);
      return;
      i = 10000;
      break;
      localObject1 = Integer.valueOf(-1);
      break label685;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI.c
 * JD-Core Version:    0.7.0.1
 */