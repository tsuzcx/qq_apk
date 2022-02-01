package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends q
{
  private boolean DCY;
  private ah DJT;
  private w EcN;
  private a EcO;
  
  public k(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(202896);
    this.EcN = paramw;
    this.DJT = fds();
    this.EcO = new a();
    AppMethodBeat.o(202896);
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(202898);
    super.b(this.EcN);
    AppMethodBeat.o(202898);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(202900);
    super.eWZ();
    this.DCY = AdLandingPagesProxy.getInstance().isBrandAdded(this.EcN.brandUsername);
    AppMethodBeat.o(202900);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(202897);
    super.eXe();
    if (this.EcN != null) {
      try
      {
        int i = this.DJT.source;
        Log.i("AdLandingPageAddBrandComp", "canNotJump source is ".concat(String.valueOf(i)));
        if (SnsAdNativeLandingPagesUI.ZF(i))
        {
          i = (int)(Util.safeParseDouble("0.6") * 255.0D);
          String str;
          if (!Util.isNullOrNil(this.EcN.DYw))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.EcN.DYw.substring(1) });
            fdx().DYw = str;
          }
          if (!Util.isNullOrNil(this.EcN.DYt))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.EcN.DYt.substring(1) });
            fdx().DYt = str;
          }
          if (!Util.isNullOrNil(this.EcN.DYx))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.EcN.DYx.substring(1) });
            fdx().DYx = str;
          }
          if (this.Edp != null) {
            this.Edp.setEnabled(false);
          }
        }
        AppMethodBeat.o(202897);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdLandingPageAddBrandComp", localThrowable.toString());
      }
    }
    AppMethodBeat.o(202897);
  }
  
  protected final void fde()
  {
    AppMethodBeat.i(202899);
    a locala = this.EcO;
    Object localObject = this.context;
    w localw = this.EcN;
    ah localah = this.DJT;
    boolean bool = this.DCY;
    locala.mContext = ((Context)localObject);
    locala.DxM = 182;
    locala.DCY = bool;
    locala.dRS = localah.getSnsId();
    locala.uxInfo = localah.uxInfo;
    locala.adExtInfo = localah.adExtInfo;
    localObject = new d();
    if (localw == null) {}
    for (;;)
    {
      locala.DCX = ((d)localObject);
      locala.eZo();
      fdf();
      AppMethodBeat.o(202899);
      return;
      ((d)localObject).brandUsername = Util.nullAs(localw.brandUsername, "");
      ((d)localObject).brandHead = Util.nullAs(localw.brandHead, "");
      ((d)localObject).brandName = Util.nullAs(localw.brandName, "");
      ((d)localObject).brandDesc = Util.nullAs(localw.brandDesc, "");
      ((d)localObject).btnTitleAfterAddBrand = Util.nullAs(localw.btnTitleAfterAddBrand, "");
    }
  }
  
  protected final void fdf()
  {
    AppMethodBeat.i(202901);
    this.Edn.report("13387");
    AppMethodBeat.o(202901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */