package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.a.1;
import com.tencent.mm.plugin.setting.model.a.2;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUpLogUploadingUI
  extends MMWizardActivity
{
  public a.a CXD;
  private TextView CYx;
  private ImageView CYy;
  protected ProgressBar CYz;
  private Button gwO;
  
  public FixToolsUpLogUploadingUI()
  {
    AppMethodBeat.i(73818);
    this.CXD = new a.a()
    {
      public final void Xn(int paramAnonymousInt)
      {
        AppMethodBeat.i(73817);
        Log.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt < 0)
        {
          h.CyF.idkeyStat(873L, 18L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(2131690298);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(2131760725);
          FixToolsUpLogUploadingUI.this.CYz.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        if (paramAnonymousInt >= 100)
        {
          h.CyF.idkeyStat(873L, 17L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(2131690299);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(2131760726);
          FixToolsUpLogUploadingUI.this.CYz.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        FixToolsUpLogUploadingUI.this.CYz.setProgress(paramAnonymousInt);
        AppMethodBeat.o(73817);
      }
    };
    AppMethodBeat.o(73818);
  }
  
  public int getLayoutId()
  {
    return 2131494696;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73819);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(73819);
      return;
    }
    setMMTitle(2131760723);
    this.CYx = ((TextView)findViewById(2131301561));
    this.CYy = ((ImageView)findViewById(2131301558));
    this.gwO = ((Button)findViewById(2131301557));
    this.CYz = ((ProgressBar)findViewById(2131301559));
    this.CYy.setImageResource(2131690304);
    this.CYx.setText(2131760729);
    this.gwO.setOnClickListener(new FixToolsUpLogUploadingUI.1(this));
    setBackBtn(new FixToolsUpLogUploadingUI.2(this));
    this.CYz.setVisibility(0);
    this.gwO.setVisibility(8);
    String str = getIntent().getStringExtra("date");
    com.tencent.mm.plugin.setting.model.a locala = com.tencent.mm.plugin.setting.model.a.eSG();
    com.tencent.mm.plugin.setting.model.a.CXD = this.CXD;
    Log.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { str, Boolean.valueOf(locala.jkK) });
    if (!locala.jkK)
    {
      locala.jkK = true;
      paramBundle = "weixin";
      if (g.aAc()) {
        paramBundle = z.aTY();
      }
      long l1 = Util.nowMilliSecond() / 86400000L;
      long l2 = com.tencent.mm.plugin.setting.model.a.agD(str + "000000");
      int i = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
      Log.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
      g.azz().a(new bu(new a.1(locala, paramBundle, i)), 0);
      b.a(new a.2(locala));
    }
    AppMethodBeat.o(73819);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73820);
    if (paramInt == 4)
    {
      ala(1);
      AppMethodBeat.o(73820);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(73820);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI
 * JD-Core Version:    0.7.0.1
 */