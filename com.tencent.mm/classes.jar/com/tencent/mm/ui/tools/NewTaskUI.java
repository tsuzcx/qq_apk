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
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class NewTaskUI
  extends MMBaseActivity
  implements com.tencent.mm.ak.i
{
  static NewTaskUI QvG;
  private i QvH;
  private ProgressDialog gtM;
  private SecurityImage kdp;
  private IListener kkK;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(39115);
    this.kdp = null;
    this.QvH = new i();
    this.gtM = null;
    this.kkK = new NewTaskUI.1(this);
    AppMethodBeat.o(39115);
  }
  
  public static NewTaskUI gXN()
  {
    return QvG;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(39116);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(2131493171);
    bg.azz().a(701, this);
    bg.azz().a(252, this);
    QvG = this;
    paramBundle = new com.tencent.mm.modelsimple.t(0, "", "", "");
    bg.azz().a(paramBundle, 0);
    getString(2131755998);
    this.gtM = h.a(this, getString(2131762532), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39110);
        bg.azz().a(paramBundle);
        AppMethodBeat.o(39110);
      }
    });
    AppMethodBeat.o(39116);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39119);
    Log.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(QvG)) {
      QvG = null;
    }
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    if (this.kdp != null) {
      this.kdp.dismiss();
    }
    bg.azz().b(701, this);
    bg.azz().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(39119);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39118);
    super.onPause();
    EventCenter.instance.removeListener(this.kkK);
    AppMethodBeat.o(39118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39117);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    AppMethodBeat.o(39117);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(39120);
    Log.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      Log.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(bg.aAc()) });
      if (a.a(QvG, paramInt1, paramInt2, new Intent().setClass(QvG, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(39120);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      QvG = null;
      finish();
      AppMethodBeat.o(39120);
      return;
    }
    if ((paramq instanceof com.tencent.mm.modelsimple.t))
    {
      paramString = (com.tencent.mm.modelsimple.t)paramq;
      this.QvH.kmJ = paramString.getSecCodeType();
      this.QvH.kdr = paramString.bfm();
      this.QvH.kds = paramString.bfl();
      this.QvH.kdt = paramString.bfn();
      Log.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.QvH.kds + " img len" + this.QvH.kdr.length + " " + f.apq());
    }
    if (this.kdp == null)
    {
      this.kdp = SecurityImage.a.a(this, this.QvH.kmJ, this.QvH.kdr, this.QvH.kds, this.QvH.kdt, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39112);
          Log.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).kds + " img len" + NewTaskUI.a(NewTaskUI.this).kdr.length + " " + f.apq());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            Log.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            AppMethodBeat.o(39112);
            return;
          }
          paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(NewTaskUI.a(NewTaskUI.this).kmJ, NewTaskUI.b(NewTaskUI.this).getSecImgCode(), NewTaskUI.b(NewTaskUI.this).getSecImgSid(), NewTaskUI.b(NewTaskUI.this).getSecImgEncryptKey());
          bg.azz().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(2131755998);
          NewTaskUI.a(localNewTaskUI1, h.a(localNewTaskUI2, NewTaskUI.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(39111);
              bg.azz().a(paramAnonymousDialogInterface);
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
          if (NewTaskUI.QvG != null)
          {
            NewTaskUI.QvG = null;
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
      }, this.QvH);
      AppMethodBeat.o(39120);
      return;
    }
    Log.d("MicroMsg.NewTaskUI", "imgSid:" + this.QvH.kds + " img len" + this.QvH.kdr.length + " " + f.apq());
    this.kdp.b(this.QvH.kmJ, this.QvH.kdr, this.QvH.kds, this.QvH.kdt);
    AppMethodBeat.o(39120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */