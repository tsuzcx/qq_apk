package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jc.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.Serializable;

public final class t
  extends p
  implements Serializable
{
  protected g zEY;
  protected boolean zEZ;
  protected AdLandingPagesProxy.e zFa;
  private c<jc> zFb;
  
  public t(Context paramContext, g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    AppMethodBeat.i(96577);
    this.zEZ = false;
    this.zFa = new AdLandingPagesProxy.e()
    {
      public final void be(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = t.this.zEY.dvR + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            aj.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            ad.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new jc();
          paramAnonymousObject.dvQ.dvR = t.this.zEY.dvR;
          paramAnonymousObject.dvQ.state = i;
          a.IbL.l(paramAnonymousObject);
        }
        AppMethodBeat.o(96573);
      }
    };
    this.zFb = new c()
    {
      private boolean a(jc paramAnonymousjc)
      {
        AppMethodBeat.i(96575);
        try
        {
          ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramAnonymousjc.dvQ.dvR + ", state=" + paramAnonymousjc.dvQ.state);
          if ((t.this.zEY.dvR.equals(paramAnonymousjc.dvQ.dvR)) && (paramAnonymousjc.dvQ.state == 0)) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96574);
                t.this.zEd.setText(t.this.zEY.zyC);
                t.this.dXi();
                AppMethodBeat.o(96574);
              }
            });
          }
          AppMethodBeat.o(96575);
          return false;
        }
        catch (Exception paramAnonymousjc)
        {
          for (;;)
          {
            ad.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramAnonymousjc.toString());
          }
        }
      }
    };
    this.zEY = paramg;
    this.zFb.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean Qp(int paramInt)
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
      ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(96581);
      return bool1;
    }
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96580);
    super.dRl();
    if (!Qp(dWZ().dnh))
    {
      ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      dXi();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.zEY.dvR + AdLandingPagesProxy.getInstance().getUin();
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    for (;;)
    {
      boolean bool = "0".equals(str1);
      ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      this.zEd.setText(this.zEY.zyC);
      dXi();
      AppMethodBeat.o(96580);
      return;
      str1 = aj.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      ad.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.zEY.isExpired())
    {
      ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.zEY.dvR, this.zFa);
    }
    AppMethodBeat.o(96580);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96579);
    super.dRm();
    if (this.zEZ)
    {
      ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.zEZ = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.zEY.dvR, this.zFa);
    }
    AppMethodBeat.o(96579);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96583);
    super.dRo();
    this.zFb.dead();
    ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  protected final void dXg()
  {
    AppMethodBeat.i(96578);
    super.dXg();
    this.zEZ = true;
    AppMethodBeat.o(96578);
  }
  
  public final void dXi()
  {
    AppMethodBeat.i(96582);
    this.zEd.setEnabled(false);
    this.zEd.setTextColor(Color.parseColor("#33000000"));
    this.zEd.setBackgroundColor(Color.parseColor("#0d000000"));
    AppMethodBeat.o(96582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */