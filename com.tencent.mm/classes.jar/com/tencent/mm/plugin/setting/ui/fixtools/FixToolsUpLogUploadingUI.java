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
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
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
  public a.a Jdj;
  private TextView Jed;
  private ImageView Jee;
  protected ProgressBar Jef;
  private Button jbb;
  
  public FixToolsUpLogUploadingUI()
  {
    AppMethodBeat.i(73818);
    this.Jdj = new a.a()
    {
      public final void aem(int paramAnonymousInt)
      {
        AppMethodBeat.i(73817);
        Log.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt < 0)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(873L, 18L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(b.h.fix_tools_failed);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(b.i.fix_tools_uplog_fail);
          FixToolsUpLogUploadingUI.this.Jef.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        if (paramAnonymousInt >= 100)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(873L, 17L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(b.h.fix_tools_finish);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(b.i.fix_tools_uplog_success);
          FixToolsUpLogUploadingUI.this.Jef.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        FixToolsUpLogUploadingUI.this.Jef.setProgress(paramAnonymousInt);
        AppMethodBeat.o(73817);
      }
    };
    AppMethodBeat.o(73818);
  }
  
  public int getLayoutId()
  {
    return b.g.fix_tools_uplog_uploading;
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
    setMMTitle(b.i.fix_tools_uplog);
    this.Jed = ((TextView)findViewById(b.f.fix_tools_uplog_uploading));
    this.Jee = ((ImageView)findViewById(b.f.fix_tools_uplog_logo));
    this.jbb = ((Button)findViewById(b.f.fix_tools_uplog_finish));
    this.Jef = ((ProgressBar)findViewById(b.f.fix_tools_uplog_progress));
    this.Jee.setImageResource(b.h.fix_tools_uplog);
    this.Jed.setText(b.i.fix_tools_uplog_uploading);
    this.jbb.setOnClickListener(new FixToolsUpLogUploadingUI.1(this));
    setBackBtn(new FixToolsUpLogUploadingUI.2(this));
    this.Jef.setVisibility(0);
    this.jbb.setVisibility(8);
    String str = getIntent().getStringExtra("date");
    com.tencent.mm.plugin.setting.model.a locala = com.tencent.mm.plugin.setting.model.a.fFJ();
    com.tencent.mm.plugin.setting.model.a.Jdj = this.Jdj;
    Log.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { str, Boolean.valueOf(locala.maL) });
    if (!locala.maL)
    {
      locala.maL = true;
      paramBundle = "weixin";
      if (com.tencent.mm.kernel.h.aHB()) {
        paramBundle = z.bcZ();
      }
      long l1 = Util.nowMilliSecond() / 86400000L;
      long l2 = com.tencent.mm.plugin.setting.model.a.aoh(str + "000000");
      int i = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
      Log.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
      com.tencent.mm.kernel.h.aGY().a(new bv(new a.1(locala, paramBundle, i)), 0);
      c.a(new a.2(locala));
    }
    AppMethodBeat.o(73819);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73820);
    if (paramInt == 4)
    {
      atX(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI
 * JD-Core Version:    0.7.0.1
 */