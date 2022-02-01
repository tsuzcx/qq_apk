package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.b;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class ap$1
  implements com.tencent.mm.ak.g
{
  ap$1(ap paramap) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(179159);
    ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    try
    {
      Object localObject;
      g.b localb;
      if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g))
      {
        localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)paramn;
        localb = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).ysm;
        if (localb != null)
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            bs.nullAsNil(paramString);
            localb.c(null);
            com.tencent.mm.kernel.g.agi().b(paramn.getType(), ap.a(this.yFz));
            AppMethodBeat.o(179159);
            return;
          }
          localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).getReqResp();
          if ((localObject instanceof b))
          {
            localObject = (b)localObject;
            if ((((b)localObject).hvs.hvw instanceof dfj)) {
              localObject = (dfj)((b)localObject).hvs.hvw;
            }
          }
        }
      }
      StringBuilder localStringBuilder;
      SubscribeMsgRequestResult.a locala;
      AppMethodBeat.o(179159);
    }
    catch (Throwable paramString)
    {
      try
      {
        localStringBuilder = new StringBuilder("rr = ");
        locala = SubscribeMsgRequestResult.igU;
        ac.i("MicroMsg.SnsAdCardActionBtnCtrl", SubscribeMsgRequestResult.a.a((dfj)localObject));
        bs.nullAsNil(paramString);
        paramString = SubscribeMsgRequestResult.igU;
        localb.c(SubscribeMsgRequestResult.a.a((dfj)localObject));
        com.tencent.mm.kernel.g.agi().b(paramn.getType(), ap.a(this.yFz));
        AppMethodBeat.o(179159);
        return;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.SnsAdCardActionBtnCtrl", paramString.toString());
      }
      paramString = paramString;
      ac.e("MicroMsg.SnsAdCardActionBtnCtrl", paramString.toString());
      AppMethodBeat.o(179159);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap.1
 * JD-Core Version:    0.7.0.1
 */