package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;

public class NewTaskUI
  extends MMBaseActivity
  implements f
{
  static NewTaskUI wdY;
  private ProgressDialog dnm = null;
  private SecurityImage fex = null;
  private c flH = new NewTaskUI.1(this);
  private g wdZ = new g();
  
  public static NewTaskUI cJf()
  {
    return wdY;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(R.i.background_transparent);
    au.Dk().a(701, this);
    wdY = this;
    paramBundle = new q(0, "", "", "");
    au.Dk().a(paramBundle, 0);
    getString(R.l.app_tip);
    this.dnm = h.b(this, getString(R.l.login_logining), true, new NewTaskUI.2(this, paramBundle));
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(wdY)) {
      wdY = null;
    }
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    if (this.fex != null) {
      this.fex.dismiss();
    }
    au.Dk().b(701, this);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    a.udP.d(this.flH);
  }
  
  public void onResume()
  {
    a.udP.c(this.flH);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      y.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(au.DK()) });
      if (w.a(wdY, paramInt1, paramInt2, new Intent().setClass(wdY, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      wdY = null;
      finish();
      return;
    }
    if ((paramm instanceof q))
    {
      paramString = (q)paramm;
      this.wdZ.fns = paramString.getSecCodeType();
      this.wdZ.fez = paramString.QA();
      this.wdZ.feA = paramString.Qz();
      this.wdZ.feB = paramString.QB();
      y.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.wdZ.feA + " img len" + this.wdZ.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    }
    if (this.fex == null)
    {
      this.fex = SecurityImage.a.a(this, R.l.regbyqq_secimg_title, this.wdZ.fns, this.wdZ.fez, this.wdZ.feA, this.wdZ.feB, new NewTaskUI.3(this), new NewTaskUI.4(this), new NewTaskUI.5(this), this.wdZ);
      return;
    }
    y.d("MicroMsg.NewTaskUI", "imgSid:" + this.wdZ.feA + " img len" + this.wdZ.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    this.fex.a(this.wdZ.fns, this.wdZ.fez, this.wdZ.feA, this.wdZ.feB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */