package com.tencent.mm.plugin.vlog.ui.fake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dlh;
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
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"})
public final class VLogFakePlayActivity
  extends MMActivity
{
  public static final a GFP;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.f GFO;
  private VideoCompositionPlayView wbi;
  private EffectManager wbk;
  
  static
  {
    AppMethodBeat.i(191132);
    GFP = new a((byte)0);
    AppMethodBeat.o(191132);
  }
  
  public VLogFakePlayActivity()
  {
    AppMethodBeat.i(191131);
    this.wbk = new EffectManager();
    AppMethodBeat.o(191131);
  }
  
  public final int getLayoutId()
  {
    return 2131496825;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110878);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.rb(true);
    Object localObject1 = getIntent().getByteArrayExtra("composition_proto");
    paramBundle = new acn();
    Object localObject2 = (com.tencent.mm.bw.a)paramBundle;
    try
    {
      ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
      localObject1 = i.d(paramBundle, this.wbk);
      new com.tencent.mm.plugin.vlog.model.f().a(paramBundle, (b)new VLogFakePlayActivity.b(this));
      localObject2 = new Rect();
      localObject3 = paramBundle.Gxw.Lnm;
      p.g(localObject3, "compositionInfo.outputConfig.originRect");
      i.a((dlh)localObject3, (Rect)localObject2);
      ((ac)localObject1).q((Rect)localObject2);
      localObject3 = e.BKp;
      localObject3 = paramBundle.Gxx.Lna;
      p.g(localObject3, "compositionInfo.editData.baseItemData");
      localObject4 = MMApplicationContext.getContext();
      p.g(localObject4, "MMApplicationContext.getContext()");
      localObject3 = e.a((LinkedList)localObject3, (Context)localObject4);
      localObject4 = paramBundle.Gxx.LmZ.Msu;
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
        Log.printDebugStack("safeParser", "", new Object[] { localException });
      }
      Object localObject4 = j.t((Collection)localObject4);
      Object localObject5 = paramBundle.Gxx.Lnc;
      if (localObject5 != null)
      {
        localObject5 = ((dlh)localObject5).Msu;
        p.g(localObject5, "rectProto.values");
        Object localObject6 = (Iterable)localObject5;
        localObject5 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Float.valueOf(((Integer)((Iterator)localObject6).next()).intValue()));
        }
        j.t((Collection)localObject5);
      }
      this.GFO = new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject4, (List)localObject3, paramBundle.Gxw.xlg, paramBundle.Gxw.xlh);
      paramBundle = this.GFO;
      if (paramBundle == null) {
        p.hyc();
      }
      localException.O((b)paramBundle);
      paramBundle = this.GFO;
      if (paramBundle != null) {
        paramBundle.start();
      }
      this.wbi = ((VideoCompositionPlayView)findViewById(2131309909));
      paramBundle = this.wbi;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
      {
        paramBundle = (ConstraintLayout.LayoutParams)paramBundle;
        if (paramBundle != null)
        {
          paramBundle.dimensionRatio = String.valueOf(((Rect)localObject2).width() * 1.0F / ((Rect)localObject2).height());
          localObject2 = this.wbi;
          if (localObject2 != null) {
            ((VideoCompositionPlayView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
          }
        }
        paramBundle = this.wbi;
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
    com.tencent.mm.plugin.recordvideo.ui.editor.b.f localf = this.GFO;
    if (localf != null) {
      localf.destroy();
    }
    this.wbk.destroy();
    AppMethodBeat.o(110882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity$Companion;", "", "()V", "KEY_COMPOSITION_PROTO", "", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity
 * JD-Core Version:    0.7.0.1
 */