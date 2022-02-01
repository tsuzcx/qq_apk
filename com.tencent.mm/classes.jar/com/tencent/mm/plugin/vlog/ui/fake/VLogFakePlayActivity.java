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
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/background/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"})
public final class VLogFakePlayActivity
  extends MMActivity
{
  public static final VLogFakePlayActivity.a Asn;
  private com.tencent.mm.plugin.recordvideo.background.c Asm;
  private VLogCompositionPlayView rQF;
  
  static
  {
    AppMethodBeat.i(207760);
    Asn = new VLogFakePlayActivity.a((byte)0);
    AppMethodBeat.o(207760);
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
    d.nX(true);
    Object localObject1 = getIntent().getByteArrayExtra("composition_proto");
    paramBundle = new yo();
    Object localObject2 = (com.tencent.mm.bw.a)paramBundle;
    try
    {
      ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
      localObject1 = com.tencent.mm.plugin.vlog.model.c.a(paramBundle);
      new com.tencent.mm.plugin.vlog.model.a().a(paramBundle, (b)new VLogFakePlayActivity.b(this));
      localObject2 = new Rect();
      localObject3 = paramBundle.AmP.Eso;
      k.g(localObject3, "compositionInfo.outputConfig.originRect");
      com.tencent.mm.plugin.vlog.model.c.a((cnb)localObject3, (Rect)localObject2);
      r.a((r)localObject1, paramBundle.AmP.wXZ, paramBundle.AmP.wYa, (Rect)localObject2);
      localObject3 = g.wmx;
      localObject3 = paramBundle.AmQ.Esi;
      k.g(localObject3, "compositionInfo.editData.baseItemData");
      localObject4 = ai.getContext();
      k.g(localObject4, "MMApplicationContext.getContext()");
      localObject3 = g.a((LinkedList)localObject3, (Context)localObject4);
      localObject4 = paramBundle.AmQ.Esh.Fjc;
      k.g(localObject4, "compositionInfo.editData.drawingRect.values");
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
        ac.l("safeParser", "", new Object[] { localException });
      }
      j.p((Collection)localObject4);
      this.Asm = new com.tencent.mm.plugin.recordvideo.background.c((List)localObject3, paramBundle.AmP.wXZ, paramBundle.AmP.wYa);
      paramBundle = this.Asm;
      if (paramBundle == null) {
        k.fOy();
      }
      localException.D((b)paramBundle);
      paramBundle = this.Asm;
      if (paramBundle != null) {
        paramBundle.start();
      }
      this.rQF = ((VLogCompositionPlayView)findViewById(2131308066));
      paramBundle = this.rQF;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
      {
        paramBundle = (ConstraintLayout.LayoutParams)paramBundle;
        if (paramBundle != null)
        {
          paramBundle.dimensionRatio = String.valueOf(((Rect)localObject2).width() * 1.0F / ((Rect)localObject2).height());
          localObject2 = this.rQF;
          if (localObject2 != null) {
            ((VLogCompositionPlayView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
          }
        }
        paramBundle = this.rQF;
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
    com.tencent.mm.plugin.recordvideo.background.c localc = this.Asm;
    if (localc != null)
    {
      localc.destroy();
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