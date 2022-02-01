package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class k
  extends q
{
  private af zAi;
  private v zUF;
  private a zUG;
  private boolean zsI;
  
  public k(Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    AppMethodBeat.i(219442);
    this.zUF = paramv;
    this.zAi = eaD();
    this.zUG = new a();
    AppMethodBeat.o(219442);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(219444);
    super.a(this.zUF);
    AppMethodBeat.o(219444);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219443);
    super.dUI();
    if (this.zUF != null) {
      try
      {
        int i = this.zAi.doj;
        ae.i("AdLandingPageAddBrandComp", "canNotJump source is ".concat(String.valueOf(i)));
        if (SnsAdNativeLandingPagesUI.RJ(i))
        {
          i = (int)(bu.aSD("0.6") * 255.0D);
          String str;
          if (!bu.isNullOrNil(this.zUF.zQx))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.zUF.zQx.substring(1) });
            eaI().zQx = str;
          }
          if (!bu.isNullOrNil(this.zUF.zQu))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.zUF.zQu.substring(1) });
            eaI().zQu = str;
          }
          if (!bu.isNullOrNil(this.zUF.zQy))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.zUF.zQy.substring(1) });
            eaI().zQy = str;
          }
          if (this.zVi != null) {
            this.zVi.setEnabled(false);
          }
        }
        AppMethodBeat.o(219443);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.e("AdLandingPageAddBrandComp", localThrowable.toString());
      }
    }
    AppMethodBeat.o(219443);
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(219446);
    super.dUK();
    this.zsI = AdLandingPagesProxy.getInstance().isBrandAdded(this.zUF.hTJ);
    AppMethodBeat.o(219446);
  }
  
  protected final void eap()
  {
    AppMethodBeat.i(219445);
    a locala = this.zUG;
    Object localObject = this.context;
    v localv = this.zUF;
    af localaf = this.zAi;
    boolean bool = this.zsI;
    locala.mContext = ((Context)localObject);
    locala.zsG = 182;
    locala.zsI = bool;
    locala.dAg = localaf.getSnsId();
    locala.dGD = localaf.dGD;
    locala.zsJ = localaf.zsJ;
    localObject = new c();
    if (localv == null) {}
    for (;;)
    {
      locala.zsH = ((c)localObject);
      locala.dWd();
      eaq();
      AppMethodBeat.o(219445);
      return;
      ((c)localObject).hTJ = bu.bI(localv.hTJ, "");
      ((c)localObject).ztf = bu.bI(localv.ztf, "");
      ((c)localObject).dpI = bu.bI(localv.dpI, "");
      ((c)localObject).ztg = bu.bI(localv.ztg, "");
      ((c)localObject).zth = bu.bI(localv.zth, "");
    }
  }
  
  protected final void eaq()
  {
    AppMethodBeat.i(219447);
    this.zVg.report("13387");
    AppMethodBeat.o(219447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */