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
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.background.i;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.a.b;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/background/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"})
public final class VLogFakePlayActivity
  extends MMActivity
{
  public static final VLogFakePlayActivity.a Ltn;
  private VLogCompositionPlayView LbD;
  private i Ltm;
  
  static
  {
    AppMethodBeat.i(201077);
    Ltn = new VLogFakePlayActivity.a((byte)0);
    AppMethodBeat.o(201077);
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
    d.ne(true);
    Object localObject1 = getIntent().getByteArrayExtra("composition_proto");
    paramBundle = new dxw();
    Object localObject2 = (com.tencent.mm.bx.a)paramBundle;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
      localObject1 = m.a(paramBundle);
      new com.tencent.mm.plugin.vlog.model.k().a(paramBundle, (b)new VLogFakePlayActivity.b(this));
      localObject2 = new Rect();
      localObject3 = paramBundle.Lqd.LwW;
      d.g.b.k.g(localObject3, "compositionInfo.outputConfig.originRect");
      m.a((ebn)localObject3, (Rect)localObject2);
      v.a((v)localObject1, paramBundle.Lqd.vNE, paramBundle.Lqd.vNF, (Rect)localObject2);
      localObject3 = f.vdH;
      localObject3 = paramBundle.Lqe.Dde;
      d.g.b.k.g(localObject3, "compositionInfo.editData.baseItemData");
      localObject4 = aj.getContext();
      d.g.b.k.g(localObject4, "MMApplicationContext.getContext()");
      localObject3 = f.a((LinkedList)localObject3, (Context)localObject4);
      localObject4 = paramBundle.Lqe.LwQ.DTM;
      d.g.b.k.g(localObject4, "compositionInfo.editData.drawingRect.values");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((Collection)localObject4).add(Float.valueOf(((Integer)((Iterator)localObject5).next()).intValue()));
      }
    }
    catch (Exception localException)
    {
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
      }
      j.o((Collection)localObject4);
      this.Ltm = new i((List)localObject3, paramBundle.Lqd.vNE, paramBundle.Lqd.vNF);
      paramBundle = this.Ltm;
      if (paramBundle == null) {
        d.g.b.k.fvU();
      }
      localException.K((b)paramBundle);
      paramBundle = this.Ltm;
      if (paramBundle != null) {
        paramBundle.start();
      }
      this.LbD = ((VLogCompositionPlayView)findViewById(2131307923));
      paramBundle = this.LbD;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
      {
        paramBundle = (ConstraintLayout.LayoutParams)paramBundle;
        if (paramBundle != null)
        {
          paramBundle.dimensionRatio = String.valueOf(((Rect)localObject2).width() * 1.0F / ((Rect)localObject2).height());
          localObject2 = this.LbD;
          if (localObject2 != null) {
            ((VLogCompositionPlayView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
          }
        }
        paramBundle = this.LbD;
        if (paramBundle == null) {
          break;
        }
        paramBundle.a(localException);
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
    i locali = this.Ltm;
    if (locali != null)
    {
      locali.destroy();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity
 * JD-Core Version:    0.7.0.1
 */