package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.Serializable;

public final class s
  extends o
  implements Serializable
{
  protected g xbo;
  protected boolean xbp;
  protected AdLandingPagesProxy.e xbq;
  private c<in> xbr;
  
  public s(Context paramContext, g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    AppMethodBeat.i(96577);
    this.xbp = false;
    this.xbq = new AdLandingPagesProxy.e()
    {
      public final void bf(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = s.this.xbo.dmw + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            aj.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            com.tencent.mm.sdk.platformtools.ad.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new in();
          paramAnonymousObject.dmv.dmw = s.this.xbo.dmw;
          paramAnonymousObject.dmv.state = i;
          a.ESL.l(paramAnonymousObject);
        }
        AppMethodBeat.o(96573);
      }
    };
    this.xbr = new c()
    {
      private boolean a(in paramAnonymousin)
      {
        AppMethodBeat.i(96575);
        try
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramAnonymousin.dmv.dmw + ", state=" + paramAnonymousin.dmv.state);
          if ((s.this.xbo.dmw.equals(paramAnonymousin.dmv.dmw)) && (paramAnonymousin.dmv.state == 0)) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96574);
                s.this.xau.setText(s.this.xbo.wVG);
                s.this.dwr();
                AppMethodBeat.o(96574);
              }
            });
          }
          AppMethodBeat.o(96575);
          return false;
        }
        catch (Exception paramAnonymousin)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramAnonymousin.toString());
          }
        }
      }
    };
    this.xbo = paramg;
    this.xbr.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean MF(int paramInt)
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(96581);
      return bool1;
    }
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96580);
    super.dvN();
    if (!MF(dwi().dep))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      dwr();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.xbo.dmw + AdLandingPagesProxy.getInstance().getUin();
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    for (;;)
    {
      boolean bool = "0".equals(str1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      this.xau.setText(this.xbo.wVG);
      dwr();
      AppMethodBeat.o(96580);
      return;
      str1 = aj.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      com.tencent.mm.sdk.platformtools.ad.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.xbo.isExpired())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.xbo.dmw, this.xbq);
    }
    AppMethodBeat.o(96580);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96583);
    super.dvy();
    this.xbr.dead();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96579);
    super.dvz();
    if (this.xbp)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.xbp = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.xbo.dmw, this.xbq);
    }
    AppMethodBeat.o(96579);
  }
  
  protected final void dwp()
  {
    AppMethodBeat.i(96578);
    super.dwp();
    this.xbp = true;
    AppMethodBeat.o(96578);
  }
  
  public final void dwr()
  {
    AppMethodBeat.i(96582);
    this.xau.setEnabled(false);
    this.xau.setTextColor(Color.parseColor("#33000000"));
    this.xau.setBackgroundColor(Color.parseColor("#0d000000"));
    AppMethodBeat.o(96582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */