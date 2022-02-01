package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements com.tencent.mm.al.g
{
  n$1(n paramn, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(126121);
    if (((paramn instanceof e)) && (paramn.equals(this.yQe)))
    {
      com.tencent.mm.kernel.g.aeS().b(this.yQe.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(126121);
        return;
      }
      paramString = (chq)((e)paramn).rr.gUT.gUX;
      com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "requestVideoUrlResultParse";
        }
        
        public final void run()
        {
          AppMethodBeat.i(126120);
          ArrayList localArrayList = new ArrayList();
          ??? = paramString.Edg.CAD.iterator();
          Object localObject4;
          Object localObject3;
          Object localObject5;
          Object localObject6;
          while (((Iterator)???).hasNext())
          {
            localObject4 = (dkq)((Iterator)???).next();
            localObject3 = new ddb();
            if (!bt.isNullOrNil(((dkq)localObject4).EAe.nlK))
            {
              ((ddb)localObject3).rNP = ((dkq)localObject4).EAe.nlK;
              if ((((dkq)localObject4).EAg != null) && (((dkq)localObject4).EAg.EzT == 1)) {
                if ((((dkq)localObject4).EAg.EzV != null) && (!bt.gL(((dkq)localObject4).EAg.EzV.CSE)))
                {
                  ((ddb)localObject3).EuV.clear();
                  ((ddb)localObject3).Eva = ((dkq)localObject4).EAg.EzW;
                  localObject4 = ((dkq)localObject4).EAg.EzV.CSE.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (dii)((Iterator)localObject4).next();
                    localObject6 = new ddd();
                    ((ddd)localObject6).url = ((dii)localObject5).Eyx.eBA();
                    ((ddd)localObject6).Eve = 0;
                    ((ddb)localObject3).EuV.add(localObject6);
                    ((ddb)localObject3).EuU = ((dii)localObject5).Eyz;
                  }
                  localObject4 = com.tencent.mm.plugin.topstory.a.h.gg(((ddb)localObject3).EuV);
                  if (localObject4 != null)
                  {
                    ((ddb)localObject3).videoUrl = ((ddd)localObject4).url;
                    ((ddb)localObject3).Eve = ((ddd)localObject4).Eve;
                  }
                }
              }
              for (;;)
              {
                localArrayList.add(localObject3);
                break;
                if ((((dkq)localObject4).EAg != null) && (((dkq)localObject4).EAg.EzT == 2))
                {
                  if ((((dkq)localObject4).EAg.EzU != null) && (!bt.gL(((dkq)localObject4).EAg.EzU.CSE)))
                  {
                    ((ddb)localObject3).EuV.clear();
                    ((ddb)localObject3).Eva = ((dkq)localObject4).EAg.EzW;
                    localObject4 = ((dkq)localObject4).EAg.EzU.CSE.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (dii)((Iterator)localObject4).next();
                      localObject6 = new ddd();
                      ((ddd)localObject6).url = ((dii)localObject5).Eyx.eBA();
                      ((ddd)localObject6).Eve = 0;
                      ((ddb)localObject3).EuV.add(localObject6);
                      ((ddb)localObject3).EuU = ((dii)localObject5).Eyz;
                    }
                    localObject4 = com.tencent.mm.plugin.topstory.a.h.gg(((ddb)localObject3).EuV);
                    if (localObject4 != null)
                    {
                      ((ddb)localObject3).videoUrl = ((ddd)localObject4).url;
                      ((ddb)localObject3).Eve = ((ddd)localObject4).Eve;
                    }
                  }
                }
                else if (!bt.isNullOrNil(((dkq)localObject4).EAh))
                {
                  ((ddb)localObject3).EuV.clear();
                  n.b((ddb)localObject3, ((dkq)localObject4).EAh, "");
                  localObject5 = com.tencent.mm.plugin.topstory.a.h.gg(((ddb)localObject3).EuV);
                  if (localObject5 != null)
                  {
                    ((ddb)localObject3).videoUrl = ((ddd)localObject5).url;
                    ((ddb)localObject3).Eve = ((ddd)localObject5).Eve;
                    if (((dkq)localObject4).EAg != null) {
                      ((ddb)localObject3).Eva = ((dkq)localObject4).EAg.EzW;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            int i;
            synchronized (n.1.this.yQf)
            {
              localObject3 = n.1.this.yQf.dPE();
              if (bt.gL((List)localObject3))
              {
                AppMethodBeat.o(126120);
                return;
              }
              i = 0;
              if (i >= ((List)localObject3).size()) {
                break;
              }
              localObject4 = (ddb)((List)localObject3).get(i);
              localObject5 = localArrayList.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (ddb)((Iterator)localObject5).next();
                if (!((ddb)localObject4).rNP.equals(((ddb)localObject6).rNP)) {
                  continue;
                }
                ((ddb)localObject4).EuV = ((ddb)localObject6).EuV;
                ((ddb)localObject4).EuU = ((ddb)localObject6).EuU;
                ((ddb)localObject4).videoUrl = ((ddb)localObject6).videoUrl;
                ((ddb)localObject4).Eva = ((ddb)localObject6).Eva;
                ad.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((ddb)localObject4).title, ((ddb)localObject4).videoUrl });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n.1
 * JD-Core Version:    0.7.0.1
 */