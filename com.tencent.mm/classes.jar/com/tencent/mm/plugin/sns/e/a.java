package com.tencent.mm.plugin.sns.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult.a;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.b;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.ap.a;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  com.tencent.mm.ui.base.p mbX;
  public volatile boolean xMj;
  com.tencent.mm.ak.g xMk;
  
  public a()
  {
    AppMethodBeat.i(179077);
    this.xMj = false;
    this.mbX = null;
    this.xMk = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(179067);
        ac.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        try
        {
          Object localObject;
          g.b localb;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g))
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)paramAnonymousn;
            localb = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).ysm;
            if (localb != null)
            {
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                bs.nullAsNil(paramAnonymousString);
                localb.c(null);
                com.tencent.mm.kernel.g.agi().b(paramAnonymousn.getType(), a.this.xMk);
                AppMethodBeat.o(179067);
                return;
              }
              localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).getReqResp();
              if ((localObject instanceof com.tencent.mm.ak.b))
              {
                localObject = (com.tencent.mm.ak.b)localObject;
                if ((((com.tencent.mm.ak.b)localObject).hvs.hvw instanceof dfj)) {
                  localObject = (dfj)((com.tencent.mm.ak.b)localObject).hvs.hvw;
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
            locala = SubscribeMsgRequestResult.igU;
            ac.i("HalfSubscribeController", SubscribeMsgRequestResult.a.a((dfj)localObject));
            bs.nullAsNil(paramAnonymousString);
            paramAnonymousString = SubscribeMsgRequestResult.igU;
            localb.c(SubscribeMsgRequestResult.a.a((dfj)localObject));
            com.tencent.mm.kernel.g.agi().b(paramAnonymousn.getType(), a.this.xMk);
            AppMethodBeat.o(179067);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ac.e("HalfSubscribeController", paramAnonymousString.toString());
          }
          paramAnonymousString = paramAnonymousString;
          ac.e("HalfSubscribeController", paramAnonymousString.toString());
          AppMethodBeat.o(179067);
          return;
        }
      }
    };
    AppMethodBeat.o(179077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */