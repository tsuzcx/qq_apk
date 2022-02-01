package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ki;
import com.tencent.mm.f.a.ki.a;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
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
  protected h KrR;
  protected boolean KrS;
  protected AdLandingPagesProxy.e KrT;
  private IListener<ki> KrU;
  
  public u(Context paramContext, h paramh, ViewGroup paramViewGroup)
  {
    super(paramContext, paramh, paramViewGroup);
    AppMethodBeat.i(96577);
    this.KrS = false;
    this.KrT = new AdLandingPagesProxy.e()
    {
      public final void aH(Object paramAnonymousObject) {}
      
      public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = u.this.KrR.fHO + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            Log.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new ki();
          paramAnonymousObject.fHN.fHO = u.this.KrR.fHO;
          paramAnonymousObject.fHN.state = i;
          EventCenter.instance.publish(paramAnonymousObject);
        }
        AppMethodBeat.o(96573);
      }
    };
    this.KrU = new IListener()
    {
      private boolean a(ki paramAnonymouski)
      {
        AppMethodBeat.i(96575);
        try
        {
          Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramAnonymouski.fHN.fHO + ", state=" + paramAnonymouski.fHN.state);
          if ((u.this.KrR.fHO.equals(paramAnonymouski.fHN.fHO)) && (paramAnonymouski.fHN.state == 0)) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96574);
                u.this.KqS.setText(u.this.KrR.Kls);
                u.this.fRw();
                AppMethodBeat.o(96574);
              }
            });
          }
          AppMethodBeat.o(96575);
          return false;
        }
        catch (Exception paramAnonymouski)
        {
          for (;;)
          {
            Log.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramAnonymouski.toString());
          }
        }
      }
    };
    this.KrR = paramh;
    this.KrU.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean agl(int paramInt)
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
  
  protected final void fKe()
  {
    AppMethodBeat.i(96580);
    super.fKe();
    if (!agl(fRp().source))
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      fRw();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.KrR.fHO + AdLandingPagesProxy.getInstance().getUin();
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
      this.KqS.setText(this.KrR.Kls);
      fRw();
      AppMethodBeat.o(96580);
      return;
      str1 = MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      Log.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.KrR.isExpired())
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.KrR.fHO, this.KrT);
    }
    AppMethodBeat.o(96580);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96579);
    super.fKk();
    if (this.KrS)
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.KrS = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.KrR.fHO, this.KrT);
    }
    AppMethodBeat.o(96579);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96583);
    super.fKo();
    this.KrU.dead();
    Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  protected final void fRb()
  {
    AppMethodBeat.i(96578);
    super.fRb();
    this.KrS = true;
    AppMethodBeat.o(96578);
  }
  
  public final void fRw()
  {
    AppMethodBeat.i(96582);
    this.KqS.setEnabled(false);
    this.KqS.setTextColor(Color.parseColor("#33000000"));
    this.KqS.setBackgroundColor(Color.parseColor("#0d000000"));
    i.a(this.context, (r)this.KqB, this.KqS);
    AppMethodBeat.o(96582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */