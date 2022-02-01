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
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends r
{
  private x QOA;
  private a QOB;
  private boolean Qkw;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai Qud;
  
  public k(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    AppMethodBeat.i(307084);
    this.QOA = paramx;
    this.Qud = hjn();
    this.QOB = new a();
    AppMethodBeat.o(307084);
  }
  
  private boolean hiY()
  {
    AppMethodBeat.i(307087);
    int i = this.Qud.source;
    int j = this.Qud.QLu;
    Log.i("AdLandingPageAddBrandComp", "canNotJumpAddBrand, source=" + i + ", originSource=" + j);
    if ((SnsAdNativeLandingPagesUI.alU(i)) || (SnsAdNativeLandingPagesUI.alU(j)) || (i == 27) || (j == 27) || (i == 7) || (j == 7))
    {
      AppMethodBeat.o(307087);
      return true;
    }
    AppMethodBeat.o(307087);
    return false;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(307091);
    super.Gs();
    if (this.QOA != null) {
      try
      {
        boolean bool = hiY();
        Log.i("AdLandingPageAddBrandComp", "setBtnView, canNotAddBrand=" + bool + ", compatibleJumpUrl=" + this.QOA.QKA);
        if ((bool) && (TextUtils.isEmpty(this.QOA.QKA)))
        {
          int i = (int)(Util.safeParseDouble("0.6") * 255.0D);
          String str;
          if (!Util.isNullOrNil(this.QOA.PSc))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.QOA.PSc.substring(1) });
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).PSc = str;
          }
          if (!Util.isNullOrNil(this.QOA.QJR))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.QOA.QJR.substring(1) });
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJR = str;
          }
          if (!Util.isNullOrNil(this.QOA.QJV))
          {
            str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.QOA.QJV.substring(1) });
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJV = str;
          }
          if (this.QPn != null) {
            this.QPn.setEnabled(false);
          }
        }
        AppMethodBeat.o(307091);
        return;
      }
      finally
      {
        Log.e("AdLandingPageAddBrandComp", localObject.toString());
      }
    }
    AppMethodBeat.o(307091);
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(307096);
    super.c(this.QOA);
    AppMethodBeat.o(307096);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(307109);
    super.hao();
    this.Qkw = AdLandingPagesProxy.getInstance().isBrandAdded(this.QOA.owR);
    AppMethodBeat.o(307109);
  }
  
  protected final void hiZ()
  {
    long l = 0L;
    AppMethodBeat.i(307105);
    if (hiY())
    {
      if (!TextUtils.isEmpty(this.QOA.QKA))
      {
        String str = this.QOA.QKA;
        try
        {
          int i = hjn().source;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            l = com.tencent.mm.plugin.sns.storage.ai.aXe(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
            Log.i("AdLandingPageAddBrandComp", "jumpH5, snsId=" + l + ", snsIdStr=" + t.uA(l) + ", source=" + i);
          }
          m.a(this.context, str, hjn(), i, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKG, false);
        }
        finally
        {
          for (;;)
          {
            Log.e("AdLandingPageAddBrandComp", "jumpH5 exp=" + localObject1.toString());
          }
        }
        this.QPl.bD("addBrandBtnJumpType", 1L);
        hja();
        AppMethodBeat.o(307105);
        return;
      }
      Log.e("AdLandingPageAddBrandComp", "canNotJumpAddBrand and jumpUrl is empty");
      AppMethodBeat.o(307105);
      return;
    }
    a locala = this.QOB;
    Object localObject2 = this.context;
    x localx = this.QOA;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai localai = this.Qud;
    boolean bool = this.Qkw;
    locala.mContext = ((Context)localObject2);
    locala.xOq = 182;
    locala.Qkw = bool;
    locala.hQX = localai.getSnsId();
    locala.uxInfo = localai.uxInfo;
    locala.adExtInfo = localai.adExtInfo;
    localObject2 = new f();
    if (localx == null) {}
    for (;;)
    {
      locala.Qkv = ((f)localObject2);
      locala.hel();
      this.QPl.bD("addBrandBtnJumpType", 0L);
      hja();
      AppMethodBeat.o(307105);
      return;
      ((f)localObject2).owR = Util.nullAs(localx.owR, "");
      ((f)localObject2).PLE = Util.nullAs(localx.PLE, "");
      ((f)localObject2).hEy = Util.nullAs(localx.hEy, "");
      ((f)localObject2).PLF = Util.nullAs(localx.PLF, "");
      ((f)localObject2).PLG = Util.nullAs(localx.PLG, "");
    }
  }
  
  protected final void hja()
  {
    AppMethodBeat.i(307112);
    this.QPl.report("13387");
    AppMethodBeat.o(307112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */