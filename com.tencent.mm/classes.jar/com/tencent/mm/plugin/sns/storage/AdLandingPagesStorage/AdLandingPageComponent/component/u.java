package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.js.a;
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.Serializable;

public final class u
  extends q
  implements Serializable
{
  protected g Eel;
  protected boolean Eem;
  protected AdLandingPagesProxy.e Een;
  private IListener<js> Eeo;
  
  public u(Context paramContext, g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    AppMethodBeat.i(96577);
    this.Eem = false;
    this.Een = new AdLandingPagesProxy.e()
    {
      public final void bn(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = u.this.Eel.dOD + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            Log.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new js();
          paramAnonymousObject.dOC.dOD = u.this.Eel.dOD;
          paramAnonymousObject.dOC.state = i;
          EventCenter.instance.publish(paramAnonymousObject);
        }
        AppMethodBeat.o(96573);
      }
    };
    this.Eeo = new IListener()
    {
      private boolean a(js paramAnonymousjs)
      {
        AppMethodBeat.i(96575);
        try
        {
          Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramAnonymousjs.dOC.dOD + ", state=" + paramAnonymousjs.dOC.state);
          if ((u.this.Eel.dOD.equals(paramAnonymousjs.dOC.dOD)) && (paramAnonymousjs.dOC.state == 0)) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96574);
                u.this.Edp.setText(u.this.Eel.DXZ);
                u.this.fdB();
                AppMethodBeat.o(96574);
              }
            });
          }
          AppMethodBeat.o(96575);
          return false;
        }
        catch (Exception paramAnonymousjs)
        {
          for (;;)
          {
            Log.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramAnonymousjs.toString());
          }
        }
      }
    };
    this.Eel = paramg;
    this.Eeo.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean YU(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96581);
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 16) {
        if (paramInt != 2) {
          break label66;
        }
      }
    }
    label66:
    for (bool1 = bool2;; bool1 = false)
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(96581);
      return bool1;
    }
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96580);
    super.eWT();
    if (!YU(fds().source))
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      fdB();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.Eel.dOD + AdLandingPagesProxy.getInstance().getUin();
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    for (;;)
    {
      boolean bool = "0".equals(str1);
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      this.Edp.setText(this.Eel.DXZ);
      fdB();
      AppMethodBeat.o(96580);
      return;
      str1 = MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      Log.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.Eel.isExpired())
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.Eel.dOD, this.Een);
    }
    AppMethodBeat.o(96580);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96579);
    super.eWZ();
    if (this.Eem)
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.Eem = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.Eel.dOD, this.Een);
    }
    AppMethodBeat.o(96579);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96583);
    super.eXd();
    this.Eeo.dead();
    Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  public final void fdB()
  {
    AppMethodBeat.i(96582);
    this.Edp.setEnabled(false);
    this.Edp.setTextColor(Color.parseColor("#33000000"));
    this.Edp.setBackgroundColor(Color.parseColor("#0d000000"));
    f.a(this.context, fdx(), this.Edp);
    AppMethodBeat.o(96582);
  }
  
  protected final void fde()
  {
    AppMethodBeat.i(96578);
    super.fde();
    this.Eem = true;
    AppMethodBeat.o(96578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */