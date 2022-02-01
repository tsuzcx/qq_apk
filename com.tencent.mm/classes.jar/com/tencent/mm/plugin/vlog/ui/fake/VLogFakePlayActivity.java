package com.tencent.mm.plugin.vlog.ui.fake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import d.a.j;
import d.g.a.b;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"})
public final class VLogFakePlayActivity
  extends MMActivity
{
  public static final a BMa;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.f BLZ;
  private VideoCompositionPlayView sNf;
  
  static
  {
    AppMethodBeat.i(196096);
    BMa = new a((byte)0);
    AppMethodBeat.o(196096);
  }
  
  public final int getLayoutId()
  {
    return 2131495853;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110878);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    com.tencent.mm.plugin.mmsight.d.or(true);
    Object localObject1 = getIntent().getByteArrayExtra("composition_proto");
    paramBundle = new aan();
    Object localObject2 = (com.tencent.mm.bx.a)paramBundle;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
      localObject1 = com.tencent.mm.plugin.vlog.model.f.a(paramBundle);
      new com.tencent.mm.plugin.vlog.model.d().a(paramBundle, (b)new VLogFakePlayActivity.b(this));
      localObject2 = new Rect();
      localObject3 = paramBundle.BEZ.FZA;
      p.g(localObject3, "compositionInfo.outputConfig.originRect");
      com.tencent.mm.plugin.vlog.model.f.a((cse)localObject3, (Rect)localObject2);
      ((v)localObject1).o((Rect)localObject2);
      localObject3 = e.xuo;
      localObject3 = paramBundle.BFa.FZr;
      p.g(localObject3, "compositionInfo.editData.baseItemData");
      localObject4 = aj.getContext();
      p.g(localObject4, "MMApplicationContext.getContext()");
      localObject3 = e.a((LinkedList)localObject3, (Context)localObject4);
      localObject4 = paramBundle.BFa.FZq.GSD;
      p.g(localObject4, "compositionInfo.editData.drawingRect.values");
      localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((Collection)localObject4).add(Float.valueOf(((Integer)((Iterator)localObject5).next()).intValue()));
      }
    }
    catch (Exception localException)
    {
      Object localObject3;
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
      }
      Object localObject4 = j.q((Collection)localObject4);
      Object localObject5 = paramBundle.BFa.FZt;
      if (localObject5 != null)
      {
        localObject5 = ((cse)localObject5).GSD;
        p.g(localObject5, "rectProto.values");
        Object localObject6 = (Iterable)localObject5;
        localObject5 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Float.valueOf(((Integer)((Iterator)localObject6).next()).intValue()));
        }
        j.q((Collection)localObject5);
      }
      this.BLZ = new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject4, (List)localObject3, paramBundle.BEZ.tJd, paramBundle.BEZ.tJe);
      paramBundle = this.BLZ;
      if (paramBundle == null) {
        p.gfZ();
      }
      localException.E((b)paramBundle);
      paramBundle = this.BLZ;
      if (paramBundle != null) {
        paramBundle.start();
      }
      this.sNf = ((VideoCompositionPlayView)findViewById(2131308066));
      paramBundle = this.sNf;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
      {
        paramBundle = (ConstraintLayout.LayoutParams)paramBundle;
        if (paramBundle != null)
        {
          paramBundle.dimensionRatio = String.valueOf(((Rect)localObject2).width() * 1.0F / ((Rect)localObject2).height());
          localObject2 = this.sNf;
          if (localObject2 != null) {
            ((VideoCompositionPlayView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
          }
        }
        paramBundle = this.sNf;
        if (paramBundle == null) {
          break;
        }
        paramBundle.a(localException.getComposition());
        AppMethodBeat.o(110878);
        return;
      }
      AppMethodBeat.o(110878);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110882);
    super.onDestroy();
    com.tencent.mm.plugin.recordvideo.ui.editor.b.f localf = this.BLZ;
    if (localf != null)
    {
      localf.destroy();
      AppMethodBeat.o(110882);
      return;
    }
    AppMethodBeat.o(110882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity$Companion;", "", "()V", "KEY_COMPOSITION_PROTO", "", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity
 * JD-Core Version:    0.7.0.1
 */