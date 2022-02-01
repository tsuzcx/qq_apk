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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.y;

public class NewTaskUI
  extends MMBaseActivity
  implements com.tencent.mm.ak.f
{
  static NewTaskUI LgI;
  private i LgJ;
  private ProgressDialog fOC;
  private SecurityImage jfm;
  private c jmB;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(39115);
    this.jfm = null;
    this.LgJ = new i();
    this.fOC = null;
    this.jmB = new NewTaskUI.1(this);
    AppMethodBeat.o(39115);
  }
  
  public static NewTaskUI fOU()
  {
    return LgI;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(39116);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(2131493128);
    bc.ajj().a(701, this);
    bc.ajj().a(252, this);
    LgI = this;
    paramBundle = new t(0, "", "", "");
    bc.ajj().a(paramBundle, 0);
    getString(2131755906);
    this.fOC = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39110);
        bc.ajj().a(paramBundle);
        AppMethodBeat.o(39110);
      }
    });
    AppMethodBeat.o(39116);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39119);
    ae.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(LgI)) {
      LgI = null;
    }
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    if (this.jfm != null) {
      this.jfm.dismiss();
    }
    bc.ajj().b(701, this);
    bc.ajj().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(39119);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39118);
    super.onPause();
    a.IvT.d(this.jmB);
    AppMethodBeat.o(39118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39117);
    a.IvT.c(this.jmB);
    super.onResume();
    AppMethodBeat.o(39117);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(39120);
    ae.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      ae.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(bc.ajM()) });
      if (y.a(LgI, paramInt1, paramInt2, new Intent().setClass(LgI, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(39120);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      LgI = null;
      finish();
      AppMethodBeat.o(39120);
      return;
    }
    if ((paramn instanceof t))
    {
      paramString = (t)paramn;
      this.LgJ.joz = paramString.getSecCodeType();
      this.LgJ.jfo = paramString.aLj();
      this.LgJ.jfp = paramString.aLi();
      this.LgJ.jfq = paramString.aLk();
      ae.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.LgJ.jfp + " img len" + this.LgJ.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
    }
    if (this.jfm == null)
    {
      this.jfm = SecurityImage.a.a(this, this.LgJ.joz, this.LgJ.jfo, this.LgJ.jfp, this.LgJ.jfq, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39112);
          ae.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).jfp + " img len" + NewTaskUI.a(NewTaskUI.this).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            ae.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            AppMethodBeat.o(39112);
            return;
          }
          paramAnonymousDialogInterface = new t(NewTaskUI.a(NewTaskUI.this).joz, NewTaskUI.b(NewTaskUI.this).getSecImgCode(), NewTaskUI.b(NewTaskUI.this).getSecImgSid(), NewTaskUI.b(NewTaskUI.this).getSecImgEncryptKey());
          bc.ajj().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(2131755906);
          NewTaskUI.a(localNewTaskUI1, h.b(localNewTaskUI2, NewTaskUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(39111);
              bc.ajj().a(paramAnonymousDialogInterface);
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
          if (NewTaskUI.LgI != null)
          {
            NewTaskUI.LgI = null;
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
      }, this.LgJ);
      AppMethodBeat.o(39120);
      return;
    }
    ae.d("MicroMsg.NewTaskUI", "imgSid:" + this.LgJ.jfp + " img len" + this.LgJ.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
    this.jfm.b(this.LgJ.joz, this.LgJ.jfo, this.LgJ.jfp, this.LgJ.jfq);
    AppMethodBeat.o(39120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */