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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.y;

public class NewTaskUI
  extends MMBaseActivity
  implements com.tencent.mm.al.f
{
  static NewTaskUI KKo;
  private i KKp;
  private ProgressDialog fMu;
  private SecurityImage jct;
  private c jjI;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(39115);
    this.jct = null;
    this.KKp = new i();
    this.fMu = null;
    this.jjI = new NewTaskUI.1(this);
    AppMethodBeat.o(39115);
  }
  
  public static NewTaskUI fKD()
  {
    return KKo;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(39116);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(2131493128);
    ba.aiU().a(701, this);
    ba.aiU().a(252, this);
    KKo = this;
    paramBundle = new s(0, "", "", "");
    ba.aiU().a(paramBundle, 0);
    getString(2131755906);
    this.fMu = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39110);
        ba.aiU().a(paramBundle);
        AppMethodBeat.o(39110);
      }
    });
    AppMethodBeat.o(39116);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39119);
    ad.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(KKo)) {
      KKo = null;
    }
    if ((this.fMu != null) && (this.fMu.isShowing())) {
      this.fMu.dismiss();
    }
    if (this.jct != null) {
      this.jct.dismiss();
    }
    ba.aiU().b(701, this);
    ba.aiU().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(39119);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39118);
    super.onPause();
    a.IbL.d(this.jjI);
    AppMethodBeat.o(39118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39117);
    a.IbL.c(this.jjI);
    super.onResume();
    AppMethodBeat.o(39117);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(39120);
    ad.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.fMu != null) && (this.fMu.isShowing())) {
      this.fMu.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      ad.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(ba.ajx()) });
      if (y.a(KKo, paramInt1, paramInt2, new Intent().setClass(KKo, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(39120);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      KKo = null;
      finish();
      AppMethodBeat.o(39120);
      return;
    }
    if ((paramn instanceof s))
    {
      paramString = (s)paramn;
      this.KKp.jlF = paramString.getSecCodeType();
      this.KKp.jcv = paramString.aKM();
      this.KKp.jcw = paramString.aKL();
      this.KKp.jcx = paramString.aKN();
      ad.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.KKp.jcw + " img len" + this.KKp.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
    }
    if (this.jct == null)
    {
      this.jct = SecurityImage.a.a(this, this.KKp.jlF, this.KKp.jcv, this.KKp.jcw, this.KKp.jcx, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39112);
          ad.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).jcw + " img len" + NewTaskUI.a(NewTaskUI.this).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            ad.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            AppMethodBeat.o(39112);
            return;
          }
          paramAnonymousDialogInterface = new s(NewTaskUI.a(NewTaskUI.this).jlF, NewTaskUI.b(NewTaskUI.this).getSecImgCode(), NewTaskUI.b(NewTaskUI.this).getSecImgSid(), NewTaskUI.b(NewTaskUI.this).getSecImgEncryptKey());
          ba.aiU().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(2131755906);
          NewTaskUI.a(localNewTaskUI1, h.b(localNewTaskUI2, NewTaskUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(39111);
              ba.aiU().a(paramAnonymousDialogInterface);
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
          if (NewTaskUI.KKo != null)
          {
            NewTaskUI.KKo = null;
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
      }, this.KKp);
      AppMethodBeat.o(39120);
      return;
    }
    ad.d("MicroMsg.NewTaskUI", "imgSid:" + this.KKp.jcw + " img len" + this.KKp.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
    this.jct.b(this.KKp.jlF, this.KKp.jcv, this.KKp.jcw, this.KKp.jcx);
    AppMethodBeat.o(39120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */