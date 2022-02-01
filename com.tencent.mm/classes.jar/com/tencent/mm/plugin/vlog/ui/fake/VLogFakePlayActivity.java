package com.tencent.mm.plugin.vlog.ui.fake;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.f;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogFakePlayActivity
  extends MMActivity
{
  public static final VLogFakePlayActivity.a UgZ;
  private VideoCompositionPlayView GmD;
  private EffectManager GmF;
  private f Uha;
  
  static
  {
    AppMethodBeat.i(281860);
    UgZ = new VLogFakePlayActivity.a((byte)0);
    AppMethodBeat.o(281860);
  }
  
  public VLogFakePlayActivity()
  {
    AppMethodBeat.i(281855);
    this.GmF = new EffectManager();
    AppMethodBeat.o(281855);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.g.vlog_fake_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110878);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ys(true);
    Object localObject1 = getIntent().getByteArrayExtra("composition_proto");
    paramBundle = new afb();
    Object localObject2 = (com.tencent.mm.bx.a)paramBundle;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
      localObject1 = h.d(paramBundle, this.GmF);
      com.tencent.mm.plugin.vlog.model.e.a(new com.tencent.mm.plugin.vlog.model.e(), paramBundle, (b)new VLogFakePlayActivity.b(this));
      localObject2 = new Rect();
      h.a(paramBundle.TYB.Znp, (Rect)localObject2);
      ((ac)localObject1).F((Rect)localObject2);
      localObject3 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
      localObject3 = paramBundle.TYC.Znd;
      s.s(localObject3, "compositionInfo.editData.baseItemData");
      localObject4 = MMApplicationContext.getContext();
      s.s(localObject4, "getContext()");
      localObject3 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject3, (Context)localObject4);
      localObject4 = paramBundle.TYC.Znc.aaTg;
      s.s(localObject4, "compositionInfo.editData.drawingRect.values");
      localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject5, 10));
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
        Log.printDebugStack("safeParser", "", new Object[] { localException });
      }
      Object localObject4 = p.H((Collection)localObject4);
      Object localObject5 = paramBundle.TYC.Znf;
      if (localObject5 != null)
      {
        localObject5 = ((enx)localObject5).aaTg;
        s.s(localObject5, "rectProto.values");
        Object localObject6 = (Iterable)localObject5;
        localObject5 = (Collection)new ArrayList(p.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Float.valueOf(((Integer)((Iterator)localObject6).next()).intValue()));
        }
        p.H((Collection)localObject5);
      }
      this.Uha = new f((float[])localObject4, (List)localObject3, paramBundle.TYB.HJN, paramBundle.TYB.HJO);
      paramBundle = this.Uha;
      s.checkNotNull(paramBundle);
      localException.aK((b)paramBundle);
      paramBundle = this.Uha;
      if (paramBundle != null) {
        paramBundle.start();
      }
      this.GmD = ((VideoCompositionPlayView)findViewById(a.f.vlog_fake_play_view));
      paramBundle = this.GmD;
      if (paramBundle != null) {}
    }
    for (paramBundle = null;; paramBundle = paramBundle.getLayoutParams())
    {
      paramBundle = (ConstraintLayout.LayoutParams)paramBundle;
      if (paramBundle != null)
      {
        paramBundle.blC = String.valueOf(((Rect)localObject2).width() * 1.0F / ((Rect)localObject2).height());
        localObject2 = this.GmD;
        if (localObject2 != null) {
          ((VideoCompositionPlayView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
        }
      }
      paramBundle = this.GmD;
      if (paramBundle != null) {
        paramBundle.a(localException.getComposition());
      }
      AppMethodBeat.o(110878);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110882);
    super.onDestroy();
    f localf = this.Uha;
    if (localf != null) {
      localf.destroy();
    }
    this.GmF.destroy();
    AppMethodBeat.o(110882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity
 * JD-Core Version:    0.7.0.1
 */