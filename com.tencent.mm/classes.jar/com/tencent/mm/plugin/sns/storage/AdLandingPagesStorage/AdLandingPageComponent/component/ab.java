package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import java.io.Serializable;
import org.json.JSONObject;

public final class ab
  extends q
  implements Serializable
{
  protected AdLandingPagesProxy.e KrT;
  protected n KsG;
  protected String KsH;
  protected String iSn;
  protected s jhZ;
  
  public ab(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    AppMethodBeat.i(201174);
    this.KrT = new AdLandingPagesProxy.e()
    {
      public final void aH(Object paramAnonymousObject)
      {
        AppMethodBeat.i(239466);
        if ((paramAnonymousObject instanceof String)) {
          try
          {
            paramAnonymousObject = new JSONObject((String)paramAnonymousObject);
            ab.this.iSn = paramAnonymousObject.optString("username");
            ab.this.KsH = paramAnonymousObject.optString("aliasname");
            AppMethodBeat.o(239466);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "parse username exp=" + paramAnonymousObject.toString());
          }
        }
        AppMethodBeat.o(239466);
      }
      
      public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(239465);
        Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if (((ab.this.context instanceof Activity)) && (((Activity)ab.this.context).isFinishing()))
        {
          Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, isFinishing return");
          AppMethodBeat.o(239465);
          return;
        }
        MMHandlerThread.postToMainThread(new ab.2(ab.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (!(paramAnonymousObject instanceof byte[])))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209176);
              w.makeText(ab.this.context, i.j.sns_ad_open_service_chat_failed, 0).show();
              AppMethodBeat.o(209176);
            }
          });
          AppMethodBeat.o(239465);
          return;
        }
        Object localObject = new Intent(ab.this.context, SnsAdProxyUI.class);
        ((Intent)localObject).putExtra("action_type", 3);
        ((Intent)localObject).putExtra("searchContactResponseByte", (byte[])paramAnonymousObject);
        ((Intent)localObject).putExtra("searchWord", Util.nullAsNil(ab.this.KsH));
        paramAnonymousObject = ab.this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousObject, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousObject, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(239465);
      }
    };
    this.KsG = paramn;
    this.KqQ.kQ("wxGroupInfo", paramn.KlB);
    AppMethodBeat.o(201174);
  }
  
  protected final void fRb()
  {
    AppMethodBeat.i(201178);
    String str = Util.nullAsNil(fRp().uxInfo);
    if (!TextUtils.isEmpty(this.KsG.KlB))
    {
      Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, btnInfo=" + this.KsG + ", uxinfo=" + str);
      try
      {
        if (this.jhZ == null) {
          this.jhZ = h.a(this.context, this.context.getString(i.j.loading_tips), true, null);
        }
        if (!this.jhZ.isShowing()) {
          this.jhZ.show();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "showLoading exp=" + localThrowable.toString());
        }
      }
      AdLandingPagesProxy.getInstance().getBtnPersonalWxUserName(str, this.KsG.KlB, this.KrT);
    }
    for (;;)
    {
      fRc();
      AppMethodBeat.o(201178);
      return;
      Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, wxGroupInfo==null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */