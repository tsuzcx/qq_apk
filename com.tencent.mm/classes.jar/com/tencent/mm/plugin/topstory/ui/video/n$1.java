package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.protocal.protobuf.eyr;
import com.tencent.mm.protocal.protobuf.faz;
import com.tencent.mm.protocal.protobuf.fbk;
import com.tencent.mm.protocal.protobuf.fbl;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements com.tencent.mm.an.i
{
  n$1(n paramn, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(126121);
    if (((paramq instanceof e)) && (paramq.equals(this.Naw)))
    {
      com.tencent.mm.kernel.h.aGY().b(this.Naw.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(126121);
        return;
      }
      paramString = (duo)d.c.b(((e)paramq).rr.lBS);
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "requestVideoUrlResultParse";
        }
        
        public final void run()
        {
          AppMethodBeat.i(126120);
          ArrayList localArrayList = new ArrayList();
          ??? = paramString.UaR.RLp.iterator();
          Object localObject4;
          Object localObject3;
          Object localObject5;
          Object localObject6;
          while (((Iterator)???).hasNext())
          {
            localObject4 = (fbl)((Iterator)???).next();
            localObject3 = new esy();
            if (!Util.isNullOrNil(((fbl)localObject4).UBo.sSY))
            {
              ((esy)localObject3).Crh = ((fbl)localObject4).UBo.sSY;
              if ((((fbl)localObject4).UBq != null) && (((fbl)localObject4).UBq.UAQ == 1)) {
                if ((((fbl)localObject4).UBq.UAS != null) && (!Util.isNullOrNil(((fbl)localObject4).UBq.UAS.SgM)))
                {
                  ((esy)localObject3).Uvc.clear();
                  ((esy)localObject3).Uvh = ((fbl)localObject4).UBq.UAT;
                  localObject4 = ((fbl)localObject4).UBq.UAS.SgM.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (eyr)((Iterator)localObject4).next();
                    localObject6 = new eta();
                    ((eta)localObject6).url = ((eyr)localObject5).UyT.Ap();
                    ((eta)localObject6).Uvk = 0;
                    ((esy)localObject3).Uvc.add(localObject6);
                    ((esy)localObject3).Uvb = ((eyr)localObject5).UyV;
                  }
                  localObject4 = com.tencent.mm.plugin.topstory.a.h.iy(((esy)localObject3).Uvc);
                  if (localObject4 != null)
                  {
                    ((esy)localObject3).videoUrl = ((eta)localObject4).url;
                    ((esy)localObject3).Uvk = ((eta)localObject4).Uvk;
                  }
                }
              }
              for (;;)
              {
                localArrayList.add(localObject3);
                break;
                if ((((fbl)localObject4).UBq != null) && (((fbl)localObject4).UBq.UAQ == 2))
                {
                  if ((((fbl)localObject4).UBq.UAR != null) && (!Util.isNullOrNil(((fbl)localObject4).UBq.UAR.SgM)))
                  {
                    ((esy)localObject3).Uvc.clear();
                    ((esy)localObject3).Uvh = ((fbl)localObject4).UBq.UAT;
                    localObject4 = ((fbl)localObject4).UBq.UAR.SgM.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (eyr)((Iterator)localObject4).next();
                      localObject6 = new eta();
                      ((eta)localObject6).url = ((eyr)localObject5).UyT.Ap();
                      ((eta)localObject6).Uvk = 0;
                      ((esy)localObject3).Uvc.add(localObject6);
                      ((esy)localObject3).Uvb = ((eyr)localObject5).UyV;
                    }
                    localObject4 = com.tencent.mm.plugin.topstory.a.h.iy(((esy)localObject3).Uvc);
                    if (localObject4 != null)
                    {
                      ((esy)localObject3).videoUrl = ((eta)localObject4).url;
                      ((esy)localObject3).Uvk = ((eta)localObject4).Uvk;
                    }
                  }
                }
                else if (!Util.isNullOrNil(((fbl)localObject4).UBr))
                {
                  ((esy)localObject3).Uvc.clear();
                  n.b((esy)localObject3, ((fbl)localObject4).UBr, "");
                  localObject5 = com.tencent.mm.plugin.topstory.a.h.iy(((esy)localObject3).Uvc);
                  if (localObject5 != null)
                  {
                    ((esy)localObject3).videoUrl = ((eta)localObject5).url;
                    ((esy)localObject3).Uvk = ((eta)localObject5).Uvk;
                    if (((fbl)localObject4).UBq != null) {
                      ((esy)localObject3).Uvh = ((fbl)localObject4).UBq.UAT;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            int i;
            synchronized (n.1.this.Nax)
            {
              localObject3 = n.1.this.Nax.eiH();
              if (Util.isNullOrNil((List)localObject3))
              {
                AppMethodBeat.o(126120);
                return;
              }
              i = 0;
              if (i >= ((List)localObject3).size()) {
                break;
              }
              localObject4 = (esy)((List)localObject3).get(i);
              localObject5 = localArrayList.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (esy)((Iterator)localObject5).next();
                if (!((esy)localObject4).Crh.equals(((esy)localObject6).Crh)) {
                  continue;
                }
                ((esy)localObject4).Uvc = ((esy)localObject6).Uvc;
                ((esy)localObject4).Uvb = ((esy)localObject6).Uvb;
                ((esy)localObject4).videoUrl = ((esy)localObject6).videoUrl;
                ((esy)localObject4).Uvh = ((esy)localObject6).Uvh;
                Log.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((esy)localObject4).title, ((esy)localObject4).videoUrl });
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