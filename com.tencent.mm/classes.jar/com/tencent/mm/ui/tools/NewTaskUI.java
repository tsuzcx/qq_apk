package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;

public class NewTaskUI
  extends MMBaseActivity
  implements f
{
  static NewTaskUI AwI;
  private i AwJ;
  private ProgressDialog eeN;
  private c gCZ;
  private SecurityImage gwg;
  
  public NewTaskUI()
  {
    AppMethodBeat.i(34922);
    this.gwg = null;
    this.AwJ = new i();
    this.eeN = null;
    this.gCZ = new NewTaskUI.1(this);
    AppMethodBeat.o(34922);
  }
  
  public static NewTaskUI dNU()
  {
    return AwI;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(34923);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(2130968799);
    aw.Rc().a(701, this);
    aw.Rc().a(252, this);
    AwI = this;
    paramBundle = new s(0, "", "", "");
    aw.Rc().a(paramBundle, 0);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131301149), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(34917);
        aw.Rc().a(paramBundle);
        AppMethodBeat.o(34917);
      }
    });
    AppMethodBeat.o(34923);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34926);
    ab.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(AwI)) {
      AwI = null;
    }
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    if (this.gwg != null) {
      this.gwg.dismiss();
    }
    aw.Rc().b(701, this);
    aw.Rc().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(34926);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34925);
    super.onPause();
    a.ymk.d(this.gCZ);
    AppMethodBeat.o(34925);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34924);
    a.ymk.c(this.gCZ);
    super.onResume();
    AppMethodBeat.o(34924);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(34927);
    ab.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      ab.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(aw.RG()) });
      if (v.a(AwI, paramInt1, paramInt2, new Intent().setClass(AwI, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        AppMethodBeat.o(34927);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)))
    {
      AwI = null;
      finish();
      AppMethodBeat.o(34927);
      return;
    }
    if ((paramm instanceof s))
    {
      paramString = (s)paramm;
      this.AwJ.gEL = paramString.getSecCodeType();
      this.AwJ.gwi = paramString.ajH();
      this.AwJ.gwj = paramString.ajG();
      this.AwJ.gwk = paramString.ajI();
      ab.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.AwJ.gwj + " img len" + this.AwJ.gwi.length + " " + g.Ml());
    }
    if (this.gwg == null)
    {
      this.gwg = SecurityImage.a.a(this, this.AwJ.gEL, this.AwJ.gwi, this.AwJ.gwj, this.AwJ.gwk, new NewTaskUI.3(this), new NewTaskUI.4(this), new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34921);
          NewTaskUI.c(NewTaskUI.this);
          AppMethodBeat.o(34921);
        }
      }, this.AwJ);
      AppMethodBeat.o(34927);
      return;
    }
    ab.d("MicroMsg.NewTaskUI", "imgSid:" + this.AwJ.gwj + " img len" + this.AwJ.gwi.length + " " + g.Ml());
    this.gwg.b(this.AwJ.gEL, this.AwJ.gwi, this.AwJ.gwj, this.AwJ.gwk);
    AppMethodBeat.o(34927);
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