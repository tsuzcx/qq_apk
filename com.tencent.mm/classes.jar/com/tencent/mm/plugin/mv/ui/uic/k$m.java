package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-mv_release"})
public final class k$m
  implements a.b
{
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(226658);
    Log.i(this.GjY.TAG, "onPageSelected:".concat(String.valueOf(paramInt)));
    Object localObject1 = (b)j.M((List)this.GjY.mXB, paramInt);
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).GfI;
      if (localObject1 != null)
      {
        Object localObject2 = f.GbD;
        localObject2 = f.a.b((f)localObject1);
        if (localObject2 != null)
        {
          new bid().xkX = 91;
          localObject1 = new emr();
          ((emr)localObject1).xbk = ((FinderObject)localObject2).id;
          ((emr)localObject1).objectNonceId = ((FinderObject)localObject2).objectNonceId;
          ((emr)localObject1).Upj = new mf();
          localObject2 = new ezq();
          ((ezq)localObject2).lzJ = cm.bfE();
          ((ezq)localObject2).UzX = (cm.bfE() + 1000L);
          ((ezq)localObject2).wmw = 1000L;
          ((ezq)localObject2).UzU = 1000L;
          ((ezq)localObject2).UzV = 1000L;
          ((ezq)localObject2).UzT = 1;
          ((ezq)localObject2).KyZ = 1;
          ((ezq)localObject2).UzW = 1000L;
          ((ezq)localObject2).zXq = 1000L;
          ((ezq)localObject2).UzY = 1L;
          ((emr)localObject1).Upk = ((ezq)localObject2);
          localObject2 = new dhb();
          ((dhb)localObject2).TNL = 100;
          ((dhb)localObject2).TNM = 1000;
          ((dhb)localObject2).TNW = 100;
          ((emr)localObject1).Upl = ((dhb)localObject2);
        }
      }
    }
    if ((b)j.M((List)this.GjY.mXB, paramInt) != null)
    {
      this.GjY.GjO = k.ZR(paramInt);
      AppMethodBeat.o(226658);
      return;
    }
    AppMethodBeat.o(226658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.k.m
 * JD-Core Version:    0.7.0.1
 */