package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$i
  implements a.b
{
  i$i(i parami) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(287616);
    Log.i(this.Mfb.TAG, s.X("onPageSelected:", Integer.valueOf(paramInt)));
    Object localObject1 = (b)p.ae((List)this.Mfb.pUj, paramInt);
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).MaX;
      if (localObject1 != null)
      {
        Object localObject2 = f.LXf;
        localObject2 = f.a.b((f)localObject1);
        if (localObject2 != null)
        {
          new bui().AJo = 91;
          localObject1 = new fhp();
          ((fhp)localObject1).hKN = ((FinderObject)localObject2).id;
          ((fhp)localObject1).objectNonceId = ((FinderObject)localObject2).objectNonceId;
          ((fhp)localObject1).abIh = new ni();
          localObject2 = new fvu();
          ((fvu)localObject2).ork = cn.bDw();
          ((fvu)localObject2).abUa = (cn.bDw() + 1000L);
          ((fvu)localObject2).zIy = 1000L;
          ((fvu)localObject2).abTX = 1000L;
          ((fvu)localObject2).abTY = 1000L;
          ((fvu)localObject2).abTW = 1;
          ((fvu)localObject2).QXQ = 1;
          ((fvu)localObject2).abTZ = 1000L;
          ((fvu)localObject2).FsW = 1000L;
          ((fvu)localObject2).abUb = 1L;
          ah localah = ah.aiuX;
          ((fhp)localObject1).abIi = ((fvu)localObject2);
          localObject2 = new dzj();
          ((dzj)localObject2).abeg = 100;
          ((dzj)localObject2).abeh = 1000;
          ((dzj)localObject2).abeq = 100;
          localah = ah.aiuX;
          ((fhp)localObject1).abIj = ((dzj)localObject2);
        }
      }
    }
    if ((b)p.ae((List)this.Mfb.pUj, paramInt) != null) {
      this.Mfb.MeQ = i.aeh(paramInt);
    }
    AppMethodBeat.o(287616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i.i
 * JD-Core Version:    0.7.0.1
 */