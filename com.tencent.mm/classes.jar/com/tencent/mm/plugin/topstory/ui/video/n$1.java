package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foj;
import com.tencent.mm.protocal.protobuf.fuk;
import com.tencent.mm.protocal.protobuf.fxg;
import com.tencent.mm.protocal.protobuf.fxv;
import com.tencent.mm.protocal.protobuf.fxw;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements com.tencent.mm.am.h
{
  n$1(n paramn, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(126121);
    if (((paramp instanceof e)) && (paramp.equals(this.TNf)))
    {
      com.tencent.mm.kernel.h.aZW().b(this.TNf.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(126121);
        return;
      }
      paramString = (enm)c.c.b(((e)paramp).rr.otC);
      com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "requestVideoUrlResultParse";
        }
        
        public final void run()
        {
          AppMethodBeat.i(126120);
          ArrayList localArrayList = new ArrayList();
          ??? = paramString.abrY.YIB.iterator();
          Object localObject4;
          Object localObject3;
          Object localObject5;
          Object localObject6;
          while (((Iterator)???).hasNext())
          {
            localObject4 = (fxw)((Iterator)???).next();
            localObject3 = new foh();
            if (!Util.isNullOrNil(((fxw)localObject4).abVx.vYo))
            {
              ((foh)localObject3).Ido = ((fxw)localObject4).abVx.vYo;
              if ((((fxw)localObject4).abVz != null) && (((fxw)localObject4).abVz.abUT == 1)) {
                if ((((fxw)localObject4).abVz.abUV != null) && (!Util.isNullOrNil(((fxw)localObject4).abVz.abUV.ZeN)))
                {
                  ((foh)localObject3).abOD.clear();
                  ((foh)localObject3).abOI = ((fxw)localObject4).abVz.abUW;
                  localObject4 = ((fxw)localObject4).abVz.abUV.ZeN.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (fuk)((Iterator)localObject4).next();
                    localObject6 = new foj();
                    ((foj)localObject6).url = ((fuk)localObject5).abSD.ZV();
                    ((foj)localObject6).abOL = 0;
                    ((foh)localObject3).abOD.add(localObject6);
                    ((foh)localObject3).abOC = ((fuk)localObject5).abSF;
                  }
                  localObject4 = g.lD(((foh)localObject3).abOD);
                  if (localObject4 != null)
                  {
                    ((foh)localObject3).videoUrl = ((foj)localObject4).url;
                    ((foh)localObject3).abOL = ((foj)localObject4).abOL;
                  }
                }
              }
              for (;;)
              {
                localArrayList.add(localObject3);
                break;
                if ((((fxw)localObject4).abVz != null) && (((fxw)localObject4).abVz.abUT == 2))
                {
                  if ((((fxw)localObject4).abVz.abUU != null) && (!Util.isNullOrNil(((fxw)localObject4).abVz.abUU.ZeN)))
                  {
                    ((foh)localObject3).abOD.clear();
                    ((foh)localObject3).abOI = ((fxw)localObject4).abVz.abUW;
                    localObject4 = ((fxw)localObject4).abVz.abUU.ZeN.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (fuk)((Iterator)localObject4).next();
                      localObject6 = new foj();
                      ((foj)localObject6).url = ((fuk)localObject5).abSD.ZV();
                      ((foj)localObject6).abOL = 0;
                      ((foh)localObject3).abOD.add(localObject6);
                      ((foh)localObject3).abOC = ((fuk)localObject5).abSF;
                    }
                    localObject4 = g.lD(((foh)localObject3).abOD);
                    if (localObject4 != null)
                    {
                      ((foh)localObject3).videoUrl = ((foj)localObject4).url;
                      ((foh)localObject3).abOL = ((foj)localObject4).abOL;
                    }
                  }
                }
                else if (!Util.isNullOrNil(((fxw)localObject4).abVA))
                {
                  ((foh)localObject3).abOD.clear();
                  n.b((foh)localObject3, ((fxw)localObject4).abVA, "");
                  localObject5 = g.lD(((foh)localObject3).abOD);
                  if (localObject5 != null)
                  {
                    ((foh)localObject3).videoUrl = ((foj)localObject5).url;
                    ((foh)localObject3).abOL = ((foj)localObject5).abOL;
                    if (((fxw)localObject4).abVz != null) {
                      ((foh)localObject3).abOI = ((fxw)localObject4).abVz.abUW;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            int i;
            synchronized (n.1.this.TNg)
            {
              localObject3 = n.1.this.TNg.aiJ();
              if (Util.isNullOrNil((List)localObject3))
              {
                AppMethodBeat.o(126120);
                return;
              }
              i = 0;
              if (i >= ((List)localObject3).size()) {
                break;
              }
              localObject4 = (foh)((List)localObject3).get(i);
              localObject5 = localArrayList.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (foh)((Iterator)localObject5).next();
                if (!((foh)localObject4).Ido.equals(((foh)localObject6).Ido)) {
                  continue;
                }
                ((foh)localObject4).abOD = ((foh)localObject6).abOD;
                ((foh)localObject4).abOC = ((foh)localObject6).abOC;
                ((foh)localObject4).videoUrl = ((foh)localObject6).videoUrl;
                ((foh)localObject4).abOI = ((foh)localObject6).abOI;
                Log.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", new Object[] { ((foh)localObject4).title, ((foh)localObject4).videoUrl });
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