package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.iu.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.Serializable;

public final class s
  extends o
  implements Serializable
{
  protected g yod;
  protected boolean yoe;
  protected AdLandingPagesProxy.e yof;
  private c<iu> yog;
  
  public s(Context paramContext, g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    AppMethodBeat.i(96577);
    this.yoe = false;
    this.yof = new AdLandingPagesProxy.e()
    {
      public final void bc(Object paramAnonymousObject) {}
      
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = s.this.yod.dke + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            ai.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            ac.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new iu();
          paramAnonymousObject.dkd.dke = s.this.yod.dke;
          paramAnonymousObject.dkd.state = i;
          a.GpY.l(paramAnonymousObject);
        }
        AppMethodBeat.o(96573);
      }
    };
    this.yog = new c()
    {
      private boolean a(iu paramAnonymousiu)
      {
        AppMethodBeat.i(96575);
        try
        {
          ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramAnonymousiu.dkd.dke + ", state=" + paramAnonymousiu.dkd.state);
          if ((s.this.yod.dke.equals(paramAnonymousiu.dkd.dke)) && (paramAnonymousiu.dkd.state == 0)) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96574);
                s.this.ynj.setText(s.this.yod.yiu);
                s.this.dKQ();
                AppMethodBeat.o(96574);
              }
            });
          }
          AppMethodBeat.o(96575);
          return false;
        }
        catch (Exception paramAnonymousiu)
        {
          for (;;)
          {
            ac.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramAnonymousiu.toString());
          }
        }
      }
    };
    this.yod = paramg;
    this.yog.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean OH(int paramInt)
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
      ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(96581);
      return bool1;
    }
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96583);
    super.dJX();
    this.yog.dead();
    ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96579);
    super.dJY();
    if (this.yoe)
    {
      ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.yoe = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.yod.dke, this.yof);
    }
    AppMethodBeat.o(96579);
  }
  
  protected final void dKO()
  {
    AppMethodBeat.i(96578);
    super.dKO();
    this.yoe = true;
    AppMethodBeat.o(96578);
  }
  
  public final void dKQ()
  {
    AppMethodBeat.i(96582);
    this.ynj.setEnabled(false);
    this.ynj.setTextColor(Color.parseColor("#33000000"));
    this.ynj.setBackgroundColor(Color.parseColor("#0d000000"));
    AppMethodBeat.o(96582);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96580);
    super.dKm();
    if (!OH(dKH().dbL))
    {
      ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      dKQ();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.yod.dke + AdLandingPagesProxy.getInstance().getUin();
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    for (;;)
    {
      boolean bool = "0".equals(str1);
      ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      this.ynj.setText(this.yod.yiu);
      dKQ();
      AppMethodBeat.o(96580);
      return;
      str1 = ai.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      ac.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.yod.isExpired())
    {
      ac.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.yod.dke, this.yof);
    }
    AppMethodBeat.o(96580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */