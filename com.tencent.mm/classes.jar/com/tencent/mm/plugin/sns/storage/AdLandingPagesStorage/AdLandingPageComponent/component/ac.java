package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;
import org.json.JSONObject;

public final class ac
  extends q
  implements Serializable
{
  protected AdLandingPagesProxy.e Een;
  protected m EfB;
  protected String EfC;
  protected String goe;
  protected com.tencent.mm.ui.base.q gxX;
  
  public ac(Context paramContext, m paramm, ViewGroup paramViewGroup)
  {
    super(paramContext, paramm, paramViewGroup);
    AppMethodBeat.i(202992);
    this.Een = new AdLandingPagesProxy.e()
    {
      public final void bn(Object paramAnonymousObject)
      {
        AppMethodBeat.i(202990);
        if ((paramAnonymousObject instanceof String)) {
          try
          {
            paramAnonymousObject = new JSONObject((String)paramAnonymousObject);
            ac.this.goe = paramAnonymousObject.optString("username");
            ac.this.EfC = paramAnonymousObject.optString("aliasname");
            AppMethodBeat.o(202990);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "parse username exp=" + paramAnonymousObject.toString());
          }
        }
        AppMethodBeat.o(202990);
      }
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(202989);
        Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if (((ac.this.context instanceof Activity)) && (((Activity)ac.this.context).isFinishing()))
        {
          Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, isFinishing return");
          AppMethodBeat.o(202989);
          return;
        }
        MMHandlerThread.postToMainThread(new ac.2(ac.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (!(paramAnonymousObject instanceof byte[])))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202988);
              u.makeText(ac.this.context, 2131765979, 0).show();
              AppMethodBeat.o(202988);
            }
          });
          AppMethodBeat.o(202989);
          return;
        }
        Object localObject = new Intent(ac.this.context, SnsAdProxyUI.class);
        ((Intent)localObject).putExtra("action_type", 3);
        ((Intent)localObject).putExtra("searchContactResponseByte", (byte[])paramAnonymousObject);
        ((Intent)localObject).putExtra("searchWord", Util.nullAsNil(ac.this.EfC));
        paramAnonymousObject = ac.this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousObject, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousObject, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(202989);
      }
    };
    this.EfB = paramm;
    this.Edn.kv("wxGroupInfo", paramm.DYi);
    AppMethodBeat.o(202992);
  }
  
  protected final void fde()
  {
    AppMethodBeat.i(202993);
    String str = Util.nullAsNil(fds().uxInfo);
    if (!TextUtils.isEmpty(this.EfB.DYi))
    {
      Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, btnInfo=" + this.EfB + ", uxinfo=" + str);
      try
      {
        if (this.gxX == null) {
          this.gxX = h.a(this.context, this.context.getString(2131762446), true, null);
        }
        if (!this.gxX.isShowing()) {
          this.gxX.show();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "showLoading exp=" + localThrowable.toString());
        }
      }
      AdLandingPagesProxy.getInstance().getBtnPersonalWxUserName(str, this.EfB.DYi, this.Een);
    }
    for (;;)
    {
      fdf();
      AppMethodBeat.o(202993);
      return;
      Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, wxGroupInfo==null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */