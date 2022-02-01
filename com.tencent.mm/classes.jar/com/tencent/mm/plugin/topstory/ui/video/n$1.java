package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements f
{
  n$1(n paramn, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(126121);
    if (((paramn instanceof e)) && (paramn.equals(this.BNe)))
    {
      g.ajj().b(this.BNe.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(126121);
        return;
      }
      paramString = (csq)((e)paramn).rr.hQE.hQJ;
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "requestVideoUrlResultParse";
        }
        
        public final void run()
        {
          AppMethodBeat.i(126120);
          ArrayList localArrayList = new ArrayList();
          ??? = paramString.HDQ.FQQ.iterator();
          Object localObject4;
          Object localObject3;
          Object localObject5;
          Object localObject6;
          while (((Iterator)???).hasNext())
          {
            localObject4 = (dwu)((Iterator)???).next();
            localObject3 = new dpa();
            if (!bu.isNullOrNil(((dwu)localObject4).IbT.oxM))
            {
              ((dpa)localObject3).udb = ((dwu)localObject4).IbT.oxM;
              if ((((dwu)localObject4).IbV != null) && (((dwu)localObject4).IbV.IbA == 1)) {
                if ((((dwu)localObject4).IbV.IbC != null) && (!bu.ht(((dwu)localObject4).IbV.IbC.GkW)))
                {
                  ((dpa)localObject3).HWp.clear();
                  ((dpa)localObject3).HWu = ((dwu)localObject4).IbV.IbD;
                  localObject4 = ((dwu)localObject4).IbV.IbC.GkW.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (dul)((Iterator)localObject4).next();
                    localObject6 = new dpc();
                    ((dpc)localObject6).url = ((dul)localObject5).Iaa.fjO();
                    ((dpc)localObject6).HWy = 0;
                    ((dpa)localObject3).HWp.add(localObject6);
                    ((dpa)localObject3).HWo = ((dul)localObject5).Iac;
                  }
                  localObject4 = com.tencent.mm.plugin.topstory.a.h.gH(((dpa)localObject3).HWp);
                  if (localObject4 != null)
                  {
                    ((dpa)localObject3).videoUrl = ((dpc)localObject4).url;
                    ((dpa)localObject3).HWy = ((dpc)localObject4).HWy;
                  }
                }
              }
              for (;;)
              {
                localArrayList.add(localObject3);
                break;
                if ((((dwu)localObject4).IbV != null) && (((dwu)localObject4).IbV.IbA == 2))
                {
                  if ((((dwu)localObject4).IbV.IbB != null) && (!bu.ht(((dwu)localObject4).IbV.IbB.GkW)))
                  {
                    ((dpa)localObject3).HWp.clear();
                    ((dpa)localObject3).HWu = ((dwu)localObject4).IbV.IbD;
                    localObject4 = ((dwu)localObject4).IbV.IbB.GkW.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (dul)((Iterator)localObject4).next();
                      localObject6 = new dpc();
                      ((dpc)localObject6).url = ((dul)localObject5).Iaa.fjO();
                      ((dpc)localObject6).HWy = 0;
                      ((dpa)localObject3).HWp.add(localObject6);
                      ((dpa)localObject3).HWo = ((dul)localObject5).Iac;
                    }
                    localObject4 = com.tencent.mm.plugin.topstory.a.h.gH(((dpa)localObject3).HWp);
                    if (localObject4 != null)
                    {
                      ((dpa)localObject3).videoUrl = ((dpc)localObject4).url;
                      ((dpa)localObject3).HWy = ((dpc)localObject4).HWy;
                    }
                  }
                }
                else if (!bu.isNullOrNil(((dwu)localObject4).IbW))
                {
                  ((dpa)localObject3).HWp.clear();
                  n.b((dpa)localObject3, ((dwu)localObject4).IbW, "");
                  localObject5 = com.tencent.mm.plugin.topstory.a.h.gH(((dpa)localObject3).HWp);
                  if (localObject5 != null)
                  {
                    ((dpa)localObject3).videoUrl = ((dpc)localObject5).url;
                    ((dpa)localObject3).HWy = ((dpc)localObject5).HWy;
                    if (((dwu)localObject4).IbV != null) {
                      ((dpa)localObject3).HWu = ((dwu)localObject4).IbV.IbD;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            int i;
            synchronized (n.1.this.BNf)
            {
              localObject3 = n.1.this.BNf.cPU();
              if (bu.ht((List)localObject3))
              {
                AppMethodBeat.o(126120);
                return;
              }
              i = 0;
              if (i >= ((List)localObject3).size()) {
                break;
              }
              localObject4 = (dpa)((List)localObject3).get(i);
              localObject5 = localArrayList.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (dpa)((Iterator)localObject5).next();
                if (!((dpa)localObject4).udb.equals(((dpa)localObject6).udb)) {
                  continue;
                }
                ((dpa)localObject4).HWp = ((dpa)localObject6).HWp;
                ((dpa)localObject4).HWo = ((dpa)localObject6).HWo;
                ((dpa)localObject4).videoUrl = ((dpa)localObject6).videoUrl;
                ((dpa)localObject4).HWu = ((dpa)localObject6).HWu;
                ae.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((dpa)localObject4).title, ((dpa)localObject4).videoUrl });
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