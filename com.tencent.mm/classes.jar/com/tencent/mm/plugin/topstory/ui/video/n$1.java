package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements f
{
  n$1(n paramn, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(126121);
    if (((paramn instanceof e)) && (paramn.equals(this.BvG)))
    {
      g.aiU().b(this.BvG.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(126121);
        return;
      }
      paramString = (crw)((e)paramn).rr.hNL.hNQ;
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "requestVideoUrlResultParse";
        }
        
        public final void run()
        {
          AppMethodBeat.i(126120);
          ArrayList localArrayList = new ArrayList();
          ??? = paramString.Hkq.Fys.iterator();
          Object localObject4;
          Object localObject3;
          Object localObject5;
          Object localObject6;
          while (((Iterator)???).hasNext())
          {
            localObject4 = (dvz)((Iterator)???).next();
            localObject3 = new dod();
            if (!bt.isNullOrNil(((dvz)localObject4).HIh.orq))
            {
              ((dod)localObject3).tSk = ((dvz)localObject4).HIh.orq;
              if ((((dvz)localObject4).HIj != null) && (((dvz)localObject4).HIj.HHN == 1)) {
                if ((((dvz)localObject4).HIj.HHP != null) && (!bt.hj(((dvz)localObject4).HIj.HHP.FSx)))
                {
                  ((dod)localObject3).HCC.clear();
                  ((dod)localObject3).HCH = ((dvz)localObject4).HIj.HHQ;
                  localObject4 = ((dvz)localObject4).HIj.HHP.FSx.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (dto)((Iterator)localObject4).next();
                    localObject6 = new dof();
                    ((dof)localObject6).url = ((dto)localObject5).HGn.ffY();
                    ((dof)localObject6).HCL = 0;
                    ((dod)localObject3).HCC.add(localObject6);
                    ((dod)localObject3).HCB = ((dto)localObject5).HGp;
                  }
                  localObject4 = com.tencent.mm.plugin.topstory.a.h.gy(((dod)localObject3).HCC);
                  if (localObject4 != null)
                  {
                    ((dod)localObject3).videoUrl = ((dof)localObject4).url;
                    ((dod)localObject3).HCL = ((dof)localObject4).HCL;
                  }
                }
              }
              for (;;)
              {
                localArrayList.add(localObject3);
                break;
                if ((((dvz)localObject4).HIj != null) && (((dvz)localObject4).HIj.HHN == 2))
                {
                  if ((((dvz)localObject4).HIj.HHO != null) && (!bt.hj(((dvz)localObject4).HIj.HHO.FSx)))
                  {
                    ((dod)localObject3).HCC.clear();
                    ((dod)localObject3).HCH = ((dvz)localObject4).HIj.HHQ;
                    localObject4 = ((dvz)localObject4).HIj.HHO.FSx.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (dto)((Iterator)localObject4).next();
                      localObject6 = new dof();
                      ((dof)localObject6).url = ((dto)localObject5).HGn.ffY();
                      ((dof)localObject6).HCL = 0;
                      ((dod)localObject3).HCC.add(localObject6);
                      ((dod)localObject3).HCB = ((dto)localObject5).HGp;
                    }
                    localObject4 = com.tencent.mm.plugin.topstory.a.h.gy(((dod)localObject3).HCC);
                    if (localObject4 != null)
                    {
                      ((dod)localObject3).videoUrl = ((dof)localObject4).url;
                      ((dod)localObject3).HCL = ((dof)localObject4).HCL;
                    }
                  }
                }
                else if (!bt.isNullOrNil(((dvz)localObject4).HIk))
                {
                  ((dod)localObject3).HCC.clear();
                  n.b((dod)localObject3, ((dvz)localObject4).HIk, "");
                  localObject5 = com.tencent.mm.plugin.topstory.a.h.gy(((dod)localObject3).HCC);
                  if (localObject5 != null)
                  {
                    ((dod)localObject3).videoUrl = ((dof)localObject5).url;
                    ((dod)localObject3).HCL = ((dof)localObject5).HCL;
                    if (((dvz)localObject4).HIj != null) {
                      ((dod)localObject3).HCH = ((dvz)localObject4).HIj.HHQ;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            int i;
            synchronized (n.1.this.BvH)
            {
              localObject3 = n.1.this.BvH.cNm();
              if (bt.hj((List)localObject3))
              {
                AppMethodBeat.o(126120);
                return;
              }
              i = 0;
              if (i >= ((List)localObject3).size()) {
                break;
              }
              localObject4 = (dod)((List)localObject3).get(i);
              localObject5 = localArrayList.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (dod)((Iterator)localObject5).next();
                if (!((dod)localObject4).tSk.equals(((dod)localObject6).tSk)) {
                  continue;
                }
                ((dod)localObject4).HCC = ((dod)localObject6).HCC;
                ((dod)localObject4).HCB = ((dod)localObject6).HCB;
                ((dod)localObject4).videoUrl = ((dod)localObject6).videoUrl;
                ((dod)localObject4).HCH = ((dod)localObject6).HCH;
                ad.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((dod)localObject4).title, ((dod)localObject4).videoUrl });
              }
            }
            i += 1;
          }
          AppMethodBeat.o(126120);
        }
      });
    }
    AppMethodBeat.o(126121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.1
 * JD-Core Version:    0.7.0.1
 */