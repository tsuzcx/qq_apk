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
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bh;
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
  implements i
{
  static NewTaskUI XTI;
  private j XTJ;
  private ProgressDialog iXX;
  private SecurityImage mUP;
  private IListener ncA;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(39115);
    this.mUP = null;
    this.XTJ = new j();
    this.iXX = null;
    this.ncA = new NewTaskUI.1(this);
    AppMethodBeat.o(39115);
  }
  
  public static NewTaskUI hYz()
  {
    return XTI;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39116);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(R.i.background_transparent);
    bh.aGY().a(701, this);
    bh.aGY().a(252, this);
    XTI = this;
    paramBundle = new com.tencent.mm.modelsimple.t(0, "", "", "");
    bh.aGY().a(paramBundle, 0);
    getString(R.l.app_tip);
    this.iXX = h.a(this, getString(R.l.login_logining), true, new NewTaskUI.2(this, paramBundle));
    AppMethodBeat.o(39116);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39119);
    Log.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(XTI)) {
      XTI = null;
    }
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    if (this.mUP != null) {
      this.mUP.dismiss();
    }
    bh.aGY().b(701, this);
    bh.aGY().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(39119);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39118);
    super.onPause();
    EventCenter.instance.removeListener(this.ncA);
    AppMethodBeat.o(39118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39117);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    AppMethodBeat.o(39117);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(39120);
    Log.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      Log.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(bh.aHB()) });
      if (a.a(XTI, paramInt1, paramInt2, new Intent().setClass(XTI, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(39120);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      XTI = null;
      finish();
      AppMethodBeat.o(39120);
      return;
    }
    if ((paramq instanceof com.tencent.mm.modelsimple.t))
    {
      paramString = (com.tencent.mm.modelsimple.t)paramq;
      this.XTJ.neB = paramString.getSecCodeType();
      this.XTJ.mUR = paramString.boC();
      this.XTJ.mUS = paramString.boB();
      this.XTJ.mUT = paramString.boD();
      Log.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.XTJ.mUS + " img len" + this.XTJ.mUR.length + " " + f.avD());
    }
    if (this.mUP == null)
    {
      this.mUP = SecurityImage.a.a(this, R.l.regbyqq_secimg_title, this.XTJ.neB, this.XTJ.mUR, this.XTJ.mUS, this.XTJ.mUT, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39112);
          Log.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).mUS + " img len" + NewTaskUI.a(NewTaskUI.this).mUR.length + " " + f.avD());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            Log.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            AppMethodBeat.o(39112);
            return;
          }
          paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(NewTaskUI.a(NewTaskUI.this).neB, NewTaskUI.b(NewTaskUI.this).getSecImgCode(), NewTaskUI.b(NewTaskUI.this).getSecImgSid(), NewTaskUI.b(NewTaskUI.this).getSecImgEncryptKey());
          bh.aGY().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(R.l.app_tip);
          NewTaskUI.a(localNewTaskUI1, h.a(localNewTaskUI2, NewTaskUI.this.getString(R.l.login_logining), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(39111);
              bh.aGY().a(paramAnonymousDialogInterface);
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
          if (NewTaskUI.XTI != null)
          {
            NewTaskUI.XTI = null;
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
      }, this.XTJ);
      AppMethodBeat.o(39120);
      return;
    }
    Log.d("MicroMsg.NewTaskUI", "imgSid:" + this.XTJ.mUS + " img len" + this.XTJ.mUR.length + " " + f.avD());
    this.mUP.b(this.XTJ.neB, this.XTJ.mUR, this.XTJ.mUS, this.XTJ.mUT);
    AppMethodBeat.o(39120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */