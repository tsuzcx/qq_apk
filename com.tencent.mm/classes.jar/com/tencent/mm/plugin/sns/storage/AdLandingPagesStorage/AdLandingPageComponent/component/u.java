package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import java.io.Serializable;

public final class u
  extends q
  implements Serializable
{
  protected g zWe;
  protected boolean zWf;
  protected AdLandingPagesProxy.e zWg;
  private c<jd> zWh;
  
  public u(Context paramContext, g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    AppMethodBeat.i(96577);
    this.zWf = false;
    this.zWg = new AdLandingPagesProxy.e()
    {
      public final void be(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = u.this.zWe.dwW + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            ak.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            ae.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new jd();
          paramAnonymousObject.dwV.dwW = u.this.zWe.dwW;
          paramAnonymousObject.dwV.state = i;
          a.IvT.l(paramAnonymousObject);
        }
        AppMethodBeat.o(96573);
      }
    };
    this.zWh = new c()
    {
      private boolean a(jd paramAnonymousjd)
      {
        AppMethodBeat.i(96575);
        try
        {
          ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramAnonymousjd.dwV.dwW + ", state=" + paramAnonymousjd.dwV.state);
          if ((u.this.zWe.dwW.equals(paramAnonymousjd.dwV.dwW)) && (paramAnonymousjd.dwV.state == 0)) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96574);
                u.this.zVi.setText(u.this.zWe.zQb);
                u.this.eaL();
                AppMethodBeat.o(96574);
              }
            });
          }
          AppMethodBeat.o(96575);
          return false;
        }
        catch (Exception paramAnonymousjd)
        {
          for (;;)
          {
            ae.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramAnonymousjd.toString());
          }
        }
      }
    };
    this.zWe = paramg;
    this.zWh.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean QW(int paramInt)
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
      ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(96581);
      return bool1;
    }
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96580);
    super.dUJ();
    if (!QW(eaD().doj))
    {
      ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      eaL();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.zWe.dwW + AdLandingPagesProxy.getInstance().getUin();
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    for (;;)
    {
      boolean bool = "0".equals(str1);
      ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      this.zVi.setText(this.zWe.zQb);
      eaL();
      AppMethodBeat.o(96580);
      return;
      str1 = ak.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      ae.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.zWe.isExpired())
    {
      ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.zWe.dwW, this.zWg);
    }
    AppMethodBeat.o(96580);
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96579);
    super.dUK();
    if (this.zWf)
    {
      ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.zWf = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.zWe.dwW, this.zWg);
    }
    AppMethodBeat.o(96579);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96583);
    super.dUM();
    this.zWh.dead();
    ae.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  public final void eaL()
  {
    AppMethodBeat.i(96582);
    this.zVi.setEnabled(false);
    this.zVi.setTextColor(Color.parseColor("#33000000"));
    this.zVi.setBackgroundColor(Color.parseColor("#0d000000"));
    AppMethodBeat.o(96582);
  }
  
  protected final void eap()
  {
    AppMethodBeat.i(96578);
    super.eap();
    this.zWf = true;
    AppMethodBeat.o(96578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */