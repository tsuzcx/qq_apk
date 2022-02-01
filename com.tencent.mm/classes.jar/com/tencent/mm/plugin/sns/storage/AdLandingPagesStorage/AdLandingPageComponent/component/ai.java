package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;

public final class ai
  extends q
  implements Serializable
{
  AdLandingPagesProxy.e EdJ;
  protected o EgA;
  
  public ai(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
    AppMethodBeat.i(96736);
    this.EdJ = new AdLandingPagesProxy.e()
    {
      public final void bn(Object paramAnonymousObject) {}
      
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
              u.makeText(ai.this.context, 2131765979, 0).show();
              AppMethodBeat.o(96734);
            }
          });
          AppMethodBeat.o(96735);
          return;
        }
        box localbox = new box();
        try
        {
          localbox.parseFrom((byte[])paramAnonymousObject);
          paramAnonymousObject = localbox.LWX;
          Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + paramAnonymousObject + ", dial_id=" + localbox.LWY);
          AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)ai.this.context, paramAnonymousObject);
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
    this.EgA = paramo;
    paramContext = fds();
    this.EgA.DYn = Util.safeParseLong(paramContext.aid);
    this.EgA.gTk = paramContext.uxInfo;
    this.EgA.kZe = paramContext.kZe;
    Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.EgA);
    this.Edn.bo("smartphoneID", paramo.DYl);
    AppMethodBeat.o(96736);
  }
  
  protected final void fde()
  {
    AppMethodBeat.i(96737);
    AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.EgA.DYn, this.EgA.DYm, this.EgA.kZe, this.EgA.gTk, this.EgA.DYl, this.EdJ);
    fdf();
    AppMethodBeat.o(96737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai
 * JD-Core Version:    0.7.0.1
 */