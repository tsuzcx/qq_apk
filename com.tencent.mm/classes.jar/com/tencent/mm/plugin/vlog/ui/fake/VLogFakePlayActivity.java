package com.tencent.mm.plugin.vlog.ui.fake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.duz;
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
import kotlin.g.b.q;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"})
public final class VLogFakePlayActivity
  extends MMActivity
{
  public static final a NtG;
  private VideoCompositionPlayView AJS;
  private EffectManager AJU;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.f NtF;
  
  static
  {
    AppMethodBeat.i(248014);
    NtG = new a((byte)0);
    AppMethodBeat.o(248014);
  }
  
  public VLogFakePlayActivity()
  {
    AppMethodBeat.i(248012);
    this.AJU = new EffectManager();
    AppMethodBeat.o(248012);
  }
  
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
    d.ue(true);
    Object localObject1 = getIntent().getByteArrayExtra("composition_proto");
    paramBundle = new acu();
    Object localObject2 = (com.tencent.mm.cd.a)paramBundle;
    try
    {
      ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject1);
      localObject1 = i.d(paramBundle, this.AJU);
      new com.tencent.mm.plugin.vlog.model.f().a(paramBundle, (b)new b(this));
      localObject2 = new Rect();
      localObject3 = paramBundle.NkX.SoD;
      p.j(localObject3, "compositionInfo.outputConfig.originRect");
      i.a((duz)localObject3, (Rect)localObject2);
      ((ac)localObject1).x((Rect)localObject2);
      localObject3 = e.HGz;
      localObject3 = paramBundle.NkY.Sor;
      p.j(localObject3, "compositionInfo.editData.baseItemData");
      localObject4 = MMApplicationContext.getContext();
      p.j(localObject4, "MMApplicationContext.getContext()");
      localObject3 = e.a((LinkedList)localObject3, (Context)localObject4);
      localObject4 = paramBundle.NkY.Soq.TDA;
      p.j(localObject4, "compositionInfo.editData.drawingRect.values");
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
      Object localObject4 = j.r((Collection)localObject4);
      Object localObject5 = paramBundle.NkY.Sot;
      if (localObject5 != null)
      {
        localObject5 = ((duz)localObject5).TDA;
        p.j(localObject5, "rectProto.values");
        Object localObject6 = (Iterable)localObject5;
        localObject5 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Float.valueOf(((Integer)((Iterator)localObject6).next()).intValue()));
        }
        j.r((Collection)localObject5);
      }
      this.NtF = new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject4, (List)localObject3, paramBundle.NkX.BXA, paramBundle.NkX.BXB);
      paramBundle = this.NtF;
      if (paramBundle == null) {
        p.iCn();
      }
      localException.aa((b)paramBundle);
      paramBundle = this.NtF;
      if (paramBundle != null) {
        paramBundle.start();
      }
      this.AJS = ((VideoCompositionPlayView)findViewById(a.f.vlog_fake_play_view));
      paramBundle = this.AJS;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
      {
        paramBundle = (ConstraintLayout.LayoutParams)paramBundle;
        if (paramBundle != null)
        {
          paramBundle.Fx = String.valueOf(((Rect)localObject2).width() * 1.0F / ((Rect)localObject2).height());
          localObject2 = this.AJS;
          if (localObject2 != null) {
            ((VideoCompositionPlayView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
          }
        }
        paramBundle = this.AJS;
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
    com.tencent.mm.plugin.recordvideo.ui.editor.b.f localf = this.NtF;
    if (localf != null) {
      localf.destroy();
    }
    this.AJU.destroy();
    AppMethodBeat.o(110882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity$Companion;", "", "()V", "KEY_COMPOSITION_PROTO", "", "TAG", "plugin-vlog_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.vlog.model.l, x>
  {
    b(VLogFakePlayActivity paramVLogFakePlayActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity
 * JD-Core Version:    0.7.0.1
 */