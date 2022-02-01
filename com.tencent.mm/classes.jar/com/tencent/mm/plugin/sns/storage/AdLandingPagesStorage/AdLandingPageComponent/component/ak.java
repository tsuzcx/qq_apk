package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.io.Serializable;

public final class ak
  extends r
  implements Serializable
{
  AdLandingPagesProxy.e QPI;
  protected p QRZ;
  
  public ak(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(96736);
    this.QPI = new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
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
              aa.makeText(ak.this.context, b.j.sns_ad_open_service_chat_failed, 0).show();
              AppMethodBeat.o(96734);
            }
          });
          AppMethodBeat.o(96735);
          return;
        }
        clv localclv = new clv();
        try
        {
          localclv.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localclv.aatL;
          Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localclv.aatM);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)ak.this.context, paramAnonymousObject);
          AppMethodBeat.o(96735);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          Log.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", Util.stackTraceToString(paramAnonymousObject));
          AppMethodBeat.o(96735);
        }
      }
      
      public final void onCallback(Object paramAnonymousObject) {}
    };
    this.QRZ = paramp;
    paramContext = hjn();
    this.QRZ.Bee = Util.safeParseLong(paramContext.aid);
    this.QRZ.mdG = paramContext.uxInfo;
    this.QRZ.qTb = paramContext.qTb;
    Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.QRZ);
    this.QPl.bD("smartphoneID", paramp.oeO);
    AppMethodBeat.o(96736);
  }
  
  protected final void hiZ()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.QRZ.Bee, this.QRZ.QJL, this.QRZ.qTb, this.QRZ.mdG, this.QRZ.oeO, this.QPI);
    hja();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak
 * JD-Core Version:    0.7.0.1
 */