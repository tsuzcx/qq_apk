package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends q
{
  private boolean JPn;
  private ai JWV;
  private x Kqp;
  private a Kqq;
  
  public k(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    AppMethodBeat.i(207123);
    this.Kqp = paramx;
    this.JWV = fRp();
    this.Kqq = new a();
    AppMethodBeat.o(207123);
  }
  
  private boolean fRa()
  {
    AppMethodBeat.i(207127);
    int i = this.JWV.source;
    int j = this.JWV.Knp;
    Log.i("AdLandingPageAddBrandComp", "canNotJumpAddBrand, source=" + i + ", originSource=" + j);
    if ((SnsAdNativeLandingPagesUI.ahb(i)) || (SnsAdNativeLandingPagesUI.ahb(j)) || (i == 27) || (j == 27) || (i == 7) || (j == 7))
    {
      AppMethodBeat.o(207127);
      return true;
    }
    AppMethodBeat.o(207127);
    return false;
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(207125);
    super.c(this.Kqp);
    AppMethodBeat.o(207125);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(207132);
    super.fKk();
    this.JPn = AdLandingPagesProxy.getInstance().isBrandAdded(this.Kqp.lFl);
    AppMethodBeat.o(207132);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(207124);
    super.fKp();
    if (this.Kqp != null) {
      try
      {
        boolean bool = fRa();
        Log.i("AdLandingPageAddBrandComp", "setBtnView, canNotAddBrand=" + bool + ", compatibleJumpUrl=" + this.Kqp.Kmv);
        if ((bool) && (TextUtils.isEmpty(this.Kqp.Kmv)))
        {
          int i = (int)(Util.safeParseDouble("0.6") * 255.0D);
          String str;
          if (!Util.isNullOrNil(this.Kqp.KlQ))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.Kqp.KlQ.substring(1) });
            ((r)this.KqB).KlQ = str;
          }
          if (!Util.isNullOrNil(this.Kqp.KlM))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.Kqp.KlM.substring(1) });
            ((r)this.KqB).KlM = str;
          }
          if (!Util.isNullOrNil(this.Kqp.KlR))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.Kqp.KlR.substring(1) });
            ((r)this.KqB).KlR = str;
          }
          if (this.KqS != null) {
            this.KqS.setEnabled(false);
          }
        }
        AppMethodBeat.o(207124);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdLandingPageAddBrandComp", localThrowable.toString());
      }
    }
    AppMethodBeat.o(207124);
  }
  
  protected final void fRb()
  {
    long l = 0L;
    AppMethodBeat.i(207131);
    if (fRa())
    {
      if (!TextUtils.isEmpty(this.Kqp.Kmv))
      {
        String str = this.Kqp.Kmv;
        try
        {
          int i = fRp().source;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            l = y.aYS(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
            Log.i("AdLandingPageAddBrandComp", "jumpH5, snsId=" + l + ", snsIdStr=" + t.Qu(l) + ", source=" + i);
          }
          m.a(this.context, str, fRp(), i, l, ((r)this.KqB).KmB, false);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("AdLandingPageAddBrandComp", "jumpH5 exp=" + localThrowable.toString());
          }
        }
        this.KqQ.br("addBrandBtnJumpType", 1L);
        fRc();
        AppMethodBeat.o(207131);
        return;
      }
      Log.e("AdLandingPageAddBrandComp", "canNotJumpAddBrand and jumpUrl is empty");
      AppMethodBeat.o(207131);
      return;
    }
    a locala = this.Kqq;
    Object localObject = this.context;
    x localx = this.Kqp;
    ai localai = this.JWV;
    boolean bool = this.JPn;
    locala.mContext = ((Context)localObject);
    locala.JCO = 182;
    locala.JPn = bool;
    locala.fLp = localai.getSnsId();
    locala.uxInfo = localai.uxInfo;
    locala.adExtInfo = localai.adExtInfo;
    localObject = new f();
    if (localx == null) {}
    for (;;)
    {
      locala.JPm = ((f)localObject);
      locala.fNf();
      this.KqQ.br("addBrandBtnJumpType", 0L);
      fRc();
      AppMethodBeat.o(207131);
      return;
      ((f)localObject).lFl = Util.nullAs(localx.lFl, "");
      ((f)localObject).JxP = Util.nullAs(localx.JxP, "");
      ((f)localObject).fzM = Util.nullAs(localx.fzM, "");
      ((f)localObject).JxQ = Util.nullAs(localx.JxQ, "");
      ((f)localObject).JxR = Util.nullAs(localx.JxR, "");
    }
  }
  
  protected final void fRc()
  {
    AppMethodBeat.i(207133);
    this.KqQ.report("13387");
    AppMethodBeat.o(207133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */