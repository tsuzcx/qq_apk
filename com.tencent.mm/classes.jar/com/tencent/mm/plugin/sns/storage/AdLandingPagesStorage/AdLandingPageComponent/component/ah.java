package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.io.Serializable;

public final class ah
  extends q
  implements Serializable
{
  AdLandingPagesProxy.e Krn;
  protected p Ktz;
  
  public ah(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(96736);
    this.Krn = new AdLandingPagesProxy.e()
    {
      public final void aH(Object paramAnonymousObject) {}
      
      public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96735);
        Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96734);
              w.makeText(ah.this.context, i.j.sns_ad_open_service_chat_failed, 0).show();
              AppMethodBeat.o(96734);
            }
          });
          AppMethodBeat.o(96735);
          return;
        }
        bws localbws = new bws();
        try
        {
          localbws.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localbws.Tgv;
          Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localbws.Tgw);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)ah.this.context, paramAnonymousObject);
          AppMethodBeat.o(96735);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          Log.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", Util.stackTraceToString(paramAnonymousObject));
          AppMethodBeat.o(96735);
        }
      }
    };
    this.Ktz = paramp;
    paramContext = fRp();
    this.Ktz.KlG = Util.safeParseLong(paramContext.aid);
    this.Ktz.jDL = paramContext.uxInfo;
    this.Ktz.nTp = paramContext.nTp;
    Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.Ktz);
    this.KqQ.br("smartphoneID", paramp.KlE);
    AppMethodBeat.o(96736);
  }
  
  protected final void fRb()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.Ktz.KlG, this.Ktz.KlF, this.Ktz.nTp, this.Ktz.jDL, this.Ktz.KlE, this.Krn);
    fRc();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah
 * JD-Core Version:    0.7.0.1
 */