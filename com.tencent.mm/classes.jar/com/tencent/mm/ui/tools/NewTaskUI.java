package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.x;

public class NewTaskUI
  extends MMBaseActivity
  implements g
{
  static NewTaskUI HsN;
  private i HsO;
  private ProgressDialog fpP;
  private SecurityImage ijd;
  private c iqt;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(39115);
    this.ijd = null;
    this.HsO = new i();
    this.fpP = null;
    this.iqt = new NewTaskUI.1(this);
    AppMethodBeat.o(39115);
  }
  
  public static NewTaskUI fdV()
  {
    return HsN;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39116);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(2131493128);
    az.aeS().a(701, this);
    az.aeS().a(252, this);
    HsN = this;
    paramBundle = new s(0, "", "", "");
    az.aeS().a(paramBundle, 0);
    getString(2131755906);
    this.fpP = h.b(this, getString(2131760781), true, new NewTaskUI.2(this, paramBundle));
    AppMethodBeat.o(39116);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39119);
    ad.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(HsN)) {
      HsN = null;
    }
    if ((this.fpP != null) && (this.fpP.isShowing())) {
      this.fpP.dismiss();
    }
    if (this.ijd != null) {
      this.ijd.dismiss();
    }
    az.aeS().b(701, this);
    az.aeS().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(39119);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39118);
    super.onPause();
    a.ESL.d(this.iqt);
    AppMethodBeat.o(39118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39117);
    a.ESL.c(this.iqt);
    super.onResume();
    AppMethodBeat.o(39117);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(39120);
    ad.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.fpP != null) && (this.fpP.isShowing())) {
      this.fpP.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      ad.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(az.afw()) });
      if (x.a(HsN, paramInt1, paramInt2, new Intent().setClass(HsN, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(39120);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      HsN = null;
      finish();
      AppMethodBeat.o(39120);
      return;
    }
    if ((paramn instanceof s))
    {
      paramString = (s)paramn;
      this.HsO.iss = paramString.getSecCodeType();
      this.HsO.ijf = paramString.aAL();
      this.HsO.ijg = paramString.aAK();
      this.HsO.ijh = paramString.aAM();
      ad.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.HsO.ijg + " img len" + this.HsO.ijf.length + " " + f.XJ());
    }
    if (this.ijd == null)
    {
      this.ijd = SecurityImage.a.a(this, this.HsO.iss, this.HsO.ijf, this.HsO.ijg, this.HsO.ijh, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39112);
          ad.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).ijg + " img len" + NewTaskUI.a(NewTaskUI.this).ijf.length + " " + f.XJ());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            ad.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            AppMethodBeat.o(39112);
            return;
          }
          paramAnonymousDialogInterface = new s(NewTaskUI.a(NewTaskUI.this).iss, NewTaskUI.b(NewTaskUI.this).getSecImgCode(), NewTaskUI.b(NewTaskUI.this).getSecImgSid(), NewTaskUI.b(NewTaskUI.this).getSecImgEncryptKey());
          az.aeS().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(2131755906);
          NewTaskUI.a(localNewTaskUI1, h.b(localNewTaskUI2, NewTaskUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(39111);
              az.aeS().a(paramAnonymousDialogInterface);
              AppMethodBeat.o(39111);
            }
          }));
          AppMethodBeat.o(39112);
        }
      }, new DialogInterface.OnCancelListener()new DialogInterface.OnDismissListener
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(39113);
          if (NewTaskUI.HsN != null)
          {
            NewTaskUI.HsN = null;
            NewTaskUI.this.finish();
          }
          AppMethodBeat.o(39113);
        }
      }, new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(39114);
          NewTaskUI.c(NewTaskUI.this);
          AppMethodBeat.o(39114);
        }
      }, this.HsO);
      AppMethodBeat.o(39120);
      return;
    }
    ad.d("MicroMsg.NewTaskUI", "imgSid:" + this.HsO.ijg + " img len" + this.HsO.ijf.length + " " + f.XJ());
    this.ijd.b(this.HsO.iss, this.HsO.ijf, this.HsO.ijg, this.HsO.ijh);
    AppMethodBeat.o(39120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */