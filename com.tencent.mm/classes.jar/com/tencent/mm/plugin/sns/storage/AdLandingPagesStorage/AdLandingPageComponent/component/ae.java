package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.io.Serializable;
import org.json.JSONObject;

public final class ae
  extends r
  implements Serializable
{
  protected AdLandingPagesProxy.e QQp;
  protected n QRe;
  protected String QRf;
  protected w lKp;
  protected String luk;
  
  public ae(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    AppMethodBeat.i(306914);
    this.QQp = new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(307070);
        Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if (((ae.this.context instanceof Activity)) && (((Activity)ae.this.context).isFinishing()))
        {
          Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, isFinishing return");
          AppMethodBeat.o(307070);
          return;
        }
        MMHandlerThread.postToMainThread(new ae.2(ae.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (!(paramAnonymousObject instanceof byte[])))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307290);
              aa.makeText(ae.this.context, b.j.sns_ad_open_service_chat_failed, 0).show();
              AppMethodBeat.o(307290);
            }
          });
          AppMethodBeat.o(307070);
          return;
        }
        Object localObject = new Intent(ae.this.context, SnsAdProxyUI.class);
        ((Intent)localObject).putExtra("action_type", 3);
        ((Intent)localObject).putExtra("searchContactResponseByte", (byte[])paramAnonymousObject);
        ((Intent)localObject).putExtra("searchWord", Util.nullAsNil(ae.this.QRf));
        paramAnonymousObject = ae.this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousObject, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousObject, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(307070);
      }
      
      public final void onCallback(Object paramAnonymousObject)
      {
        AppMethodBeat.i(307074);
        if ((paramAnonymousObject instanceof String)) {
          try
          {
            paramAnonymousObject = new JSONObject((String)paramAnonymousObject);
            ae.this.luk = paramAnonymousObject.optString("username");
            ae.this.QRf = paramAnonymousObject.optString("aliasname");
            AppMethodBeat.o(307074);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "parse username exp=" + paramAnonymousObject.toString());
          }
        }
        AppMethodBeat.o(307074);
      }
    };
    this.QRe = paramn;
    this.QPl.mx("wxGroupInfo", paramn.QJI);
    AppMethodBeat.o(306914);
  }
  
  protected final void hiZ()
  {
    AppMethodBeat.i(306916);
    String str = Util.nullAsNil(hjn().uxInfo);
    if (!TextUtils.isEmpty(this.QRe.QJI))
    {
      Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, btnInfo=" + this.QRe + ", uxinfo=" + str);
      try
      {
        if (this.lKp == null) {
          this.lKp = k.a(this.context, this.context.getString(b.j.loading_tips), true, null);
        }
        if (!this.lKp.isShowing()) {
          this.lKp.show();
        }
      }
      finally
      {
        for (;;)
        {
          Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "showLoading exp=" + localObject.toString());
        }
      }
      AdLandingPagesProxy.getInstance().getBtnPersonalWxUserName(str, this.QRe.QJI, this.QQp);
    }
    for (;;)
    {
      hja();
      AppMethodBeat.o(306916);
      return;
      Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, wxGroupInfo==null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */