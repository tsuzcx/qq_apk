package com.tencent.mm.plugin.sns.f;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult.a;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.b;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.ap.a;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class a
{
  com.tencent.mm.ui.base.p lAb;
  public volatile boolean wzP;
  com.tencent.mm.al.g wzQ;
  
  public a()
  {
    AppMethodBeat.i(179077);
    this.wzP = false;
    this.lAb = null;
    this.wzQ = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(179067);
        ad.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        try
        {
          Object localObject;
          g.b localb;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g))
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)paramAnonymousn;
            localb = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).xfy;
            if (localb != null)
            {
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                bt.nullAsNil(paramAnonymousString);
                localb.c(null);
                com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), a.this.wzQ);
                AppMethodBeat.o(179067);
                return;
              }
              localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).getReqResp();
              if ((localObject instanceof com.tencent.mm.al.b))
              {
                localObject = (com.tencent.mm.al.b)localObject;
                if ((((com.tencent.mm.al.b)localObject).gUT.gUX instanceof czx)) {
                  localObject = (czx)((com.tencent.mm.al.b)localObject).gUT.gUX;
                }
              }
            }
          }
          StringBuilder localStringBuilder;
          SubscribeMsgRequestResult.a locala;
          AppMethodBeat.o(179067);
        }
        catch (Throwable paramAnonymousString)
        {
          try
          {
            localStringBuilder = new StringBuilder("rr = ");
            locala = SubscribeMsgRequestResult.hGs;
            ad.i("HalfSubscribeController", SubscribeMsgRequestResult.a.a((czx)localObject));
            bt.nullAsNil(paramAnonymousString);
            paramAnonymousString = SubscribeMsgRequestResult.hGs;
            localb.c(SubscribeMsgRequestResult.a.a((czx)localObject));
            com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), a.this.wzQ);
            AppMethodBeat.o(179067);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("HalfSubscribeController", paramAnonymousString.toString());
          }
          paramAnonymousString = paramAnonymousString;
          ad.e("HalfSubscribeController", paramAnonymousString.toString());
          AppMethodBeat.o(179067);
          return;
        }
      }
    };
    AppMethodBeat.o(179077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.a
 * JD-Core Version:    0.7.0.1
 */