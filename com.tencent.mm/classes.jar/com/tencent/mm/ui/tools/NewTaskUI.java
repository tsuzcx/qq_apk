package com.tencent.mm.ui.tools;

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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.ui.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.k;

public class NewTaskUI
  extends MMBaseActivity
  implements h
{
  static NewTaskUI afJW;
  private j afJX;
  private ProgressDialog lzP;
  private SecurityImage pRw;
  private IListener pZz;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(39115);
    this.pRw = null;
    this.afJX = new j();
    this.lzP = null;
    this.pZz = new NewTaskUI.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(39115);
  }
  
  public static NewTaskUI jDi()
  {
    return afJW;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39116);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(R.i.background_transparent);
    bh.aZW().a(701, this);
    bh.aZW().a(252, this);
    afJW = this;
    paramBundle = new u(0, "", "", "");
    bh.aZW().a(paramBundle, 0);
    getString(R.l.app_tip);
    this.lzP = k.a(this, getString(R.l.login_logining), true, new NewTaskUI.2(this, paramBundle));
    AppMethodBeat.o(39116);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39119);
    Log.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(afJW)) {
      afJW = null;
    }
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    if (this.pRw != null) {
      this.pRw.dismiss();
    }
    bh.aZW().b(701, this);
    bh.aZW().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(39119);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39118);
    super.onPause();
    this.pZz.dead();
    AppMethodBeat.o(39118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39117);
    this.pZz.alive();
    super.onResume();
    AppMethodBeat.o(39117);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(39120);
    Log.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      Log.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(bh.baz()) });
      if (a.a(afJW, paramInt1, paramInt2, new Intent().setClass(afJW, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(39120);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      afJW = null;
      finish();
      AppMethodBeat.o(39120);
      return;
    }
    if ((paramp instanceof u))
    {
      paramString = (u)paramp;
      this.afJX.qbo = paramString.getSecCodeType();
      this.afJX.pRy = paramString.bMj();
      this.afJX.pRz = paramString.bMi();
      this.afJX.pRA = paramString.bMk();
      Log.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.afJX.pRz + " img len" + this.afJX.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
    }
    if (this.pRw == null)
    {
      this.pRw = SecurityImage.a.a(this, R.l.regbyqq_secimg_title, this.afJX.qbo, this.afJX.pRy, this.afJX.pRz, this.afJX.pRA, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39112);
          Log.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).pRz + " img len" + NewTaskUI.a(NewTaskUI.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            Log.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            AppMethodBeat.o(39112);
            return;
          }
          paramAnonymousDialogInterface = new u(NewTaskUI.a(NewTaskUI.this).qbo, NewTaskUI.b(NewTaskUI.this).getSecImgCode(), NewTaskUI.b(NewTaskUI.this).getSecImgSid(), NewTaskUI.b(NewTaskUI.this).getSecImgEncryptKey());
          bh.aZW().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(R.l.app_tip);
          NewTaskUI.a(localNewTaskUI1, k.a(localNewTaskUI2, NewTaskUI.this.getString(R.l.login_logining), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(39111);
              bh.aZW().a(paramAnonymousDialogInterface);
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
          if (NewTaskUI.afJW != null)
          {
            NewTaskUI.afJW = null;
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
      }, this.afJX);
      AppMethodBeat.o(39120);
      return;
    }
    Log.d("MicroMsg.NewTaskUI", "imgSid:" + this.afJX.pRz + " img len" + this.afJX.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
    this.pRw.b(this.afJX.qbo, this.afJX.pRy, this.afJX.pRz, this.afJX.pRA);
    AppMethodBeat.o(39120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI
 * JD-Core Version:    0.7.0.1
 */