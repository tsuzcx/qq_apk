package com.tencent.mm.plugin.recordvideo.activity;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.a.a;
import com.tencent.mm.api.s.b;
import com.tencent.mm.api.s.c;
import com.tencent.mm.bs.a;
import com.tencent.mm.bs.a.c;
import com.tencent.mm.e.b.a;
import com.tencent.mm.media.i.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.f.c;
import com.tencent.mm.plugin.recordvideo.plugin.f.d;
import com.tencent.mm.plugin.recordvideo.plugin.f.e;
import com.tencent.mm.plugin.recordvideo.plugin.f.f;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MMRecordUI$b
  implements Runnable
{
  MMRecordUI$b(MMRecordUI paramMMRecordUI, com.tencent.mm.media.widget.camerarecordview.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(150538);
    MMRecordUI.a(this.qaJ, 1);
    MMRecordUI.a(this.qaJ, (BasePluginLayout)MMRecordUI.c(this.qaJ));
    Object localObject1 = MMRecordUI.c(this.qaJ);
    if (localObject1 != null)
    {
      com.tencent.mm.media.widget.camerarecordview.a.b localb = this.qaK;
      j.q(localb, "info");
      ((EditPhotoPluginLayout)localObject1).qbS = localb;
      Object localObject2 = ((EditPhotoPluginLayout)localObject1).qdN;
      Object localObject3 = ((EditPhotoPluginLayout)localObject1).qaF;
      if (localObject3 == null) {
        j.ebi();
      }
      j.q(localObject3, "configProvider");
      j.q(localb, "captureInfo");
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qaF = ((RecordConfigProvider)localObject3);
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbS = localb;
      localObject2 = ((EditPhotoPluginLayout)localObject1).qdN;
      localObject3 = localb.fbq;
      j.q(localObject3, "path");
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbX.setVisibility(0);
      Object localObject4 = s.bWe.Ab();
      j.p(localObject4, "MMPhotoEditor.mFactory.get()");
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).oOG = ((s)localObject4);
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).oOG;
      s.a.a locala = new s.a.a();
      Object localObject5 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qaF;
      if ((localObject5 == null) || (((RecordConfigProvider)localObject5).scene != 291))
      {
        localObject5 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qaF;
        if ((localObject5 == null) || (((RecordConfigProvider)localObject5).scene != 293))
        {
          bool = true;
          locala = locala.bm(bool).Aw().i(new Rect(((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbX.getLeft(), ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbX.getTop(), ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbX.getRight(), ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbX.getBottom())).a(s.c.bWm);
          localObject5 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbS;
          if ((localObject5 == null) || (((com.tencent.mm.media.widget.camerarecordview.a.b)localObject5).fbp != true)) {
            break label369;
          }
        }
      }
      label369:
      for (boolean bool = true;; bool = false)
      {
        ((s)localObject4).a(locala.bn(bool).dm((String)localObject3).Ax());
        localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).oOG.aV(((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).context);
        if (localObject4 != null) {
          break label374;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(150538);
        throw ((Throwable)localObject1);
        bool = false;
        break;
      }
      label374:
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbT = ((com.tencent.mm.view.b)localObject4);
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbT;
      if (localObject4 != null)
      {
        localObject4 = (com.tencent.mm.view.footer.b)((com.tencent.mm.view.b)localObject4).getBaseFooterView();
        if (localObject4 != null) {
          ((com.tencent.mm.view.footer.b)localObject4).setHideFooter(true);
        }
      }
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbT;
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(150538);
        throw ((Throwable)localObject1);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbU = ((com.tencent.mm.view.b)localObject4).getPresenter();
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbU;
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(150538);
        throw ((Throwable)localObject1);
      }
      ((a)localObject4).whi = ((a.c)new f.c((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2));
      localObject4 = new FrameLayout.LayoutParams(-1, -1);
      ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbX.addView((View)((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbT, (ViewGroup.LayoutParams)localObject4);
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbT;
      if (localObject4 != null) {
        ((com.tencent.mm.view.b)localObject4).setSelectedFeatureListener((r)new f.d((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2));
      }
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbU;
      if (localObject4 != null)
      {
        localObject4 = (com.tencent.mm.e.d)((com.tencent.mm.bs.b)localObject4).c(e.bVW);
        if (localObject4 != null) {
          ((com.tencent.mm.e.d)localObject4).a((b.a)new f.e((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2));
        }
      }
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2).qbU;
      if (localObject4 != null)
      {
        localObject4 = (com.tencent.mm.e.f)((com.tencent.mm.bs.b)localObject4).c(e.bVZ);
        if (localObject4 != null) {
          ((com.tencent.mm.e.f)localObject4).a((b.a)new f.f((com.tencent.mm.plugin.recordvideo.plugin.f)localObject2));
        }
      }
      localObject2 = com.tencent.mm.sdk.platformtools.d.aoT((String)localObject3);
      localObject3 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject2).outWidth));
      localObject3 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject2).outHeight));
      localObject2 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject2 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject2 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!localb.fbp)
      {
        localObject1 = ((EditPhotoPluginLayout)localObject1).qaF;
        if (localObject1 == null) {
          break label827;
        }
      }
    }
    label827:
    for (int i = ((RecordConfigProvider)localObject1).scene;; i = 0)
    {
      if (i > 0)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      localObject1 = c.eZC;
      c.VQ();
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(150538);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI.b
 * JD-Core Version:    0.7.0.1
 */