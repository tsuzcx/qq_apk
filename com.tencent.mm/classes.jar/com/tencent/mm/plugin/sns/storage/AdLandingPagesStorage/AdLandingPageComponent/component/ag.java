package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;
import java.io.Serializable;

public final class ag
  extends q
  implements Serializable
{
  AdLandingPagesProxy.e zVC;
  protected n zYj;
  
  public ag(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    AppMethodBeat.i(96736);
    this.zVC = new AdLandingPagesProxy.e()
    {
      public final void be(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96735);
        ae.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96734);
              t.makeText(ag.this.context, 2131763758, 0).show();
              AppMethodBeat.o(96734);
            }
          });
          AppMethodBeat.o(96735);
          return;
        }
        bdj localbdj = new bdj();
        try
        {
          localbdj.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localbdj.GSL;
          ae.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localbdj.GSM);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)ag.this.context, paramAnonymousObject);
          AppMethodBeat.o(96735);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          ae.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", bu.o(paramAnonymousObject));
          AppMethodBeat.o(96735);
        }
      }
    };
    this.zYj = paramn;
    paramContext = eaD();
    this.zYj.zQo = bu.aSC(paramContext.zMk);
    this.zYj.zot = paramContext.dGD;
    this.zYj.jWi = paramContext.jWi;
    ae.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.zYj);
    this.zVg.bm("smartphoneID", paramn.zQm);
    AppMethodBeat.o(96736);
  }
  
  protected final void eap()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.zYj.zQo, this.zYj.zQn, this.zYj.jWi, this.zYj.zot, this.zYj.zQm, this.zVC);
    eaq();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag
 * JD-Core Version:    0.7.0.1
 */