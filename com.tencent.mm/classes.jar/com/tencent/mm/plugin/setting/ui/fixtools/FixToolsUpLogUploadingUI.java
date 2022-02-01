package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.b.1;
import com.tencent.mm.plugin.setting.model.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FixToolsUpLogUploadingUI
  extends MMWizardActivity
{
  public b.a Pnv;
  private TextView PoD;
  private ImageView PoE;
  protected ProgressBar PoF;
  private Button lDb;
  
  public FixToolsUpLogUploadingUI()
  {
    AppMethodBeat.i(73818);
    this.Pnv = new b.a()
    {
      public final void aiS(int paramAnonymousInt)
      {
        AppMethodBeat.i(73817);
        Log.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt < 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(873L, 18L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(b.h.fix_tools_failed);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(b.i.fix_tools_uplog_fail);
          FixToolsUpLogUploadingUI.this.PoF.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        if (paramAnonymousInt >= 100)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(873L, 17L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(b.h.fix_tools_finish);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(b.i.fix_tools_uplog_success);
          FixToolsUpLogUploadingUI.this.PoF.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        FixToolsUpLogUploadingUI.this.PoF.setProgress(paramAnonymousInt);
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
    this.PoD = ((TextView)findViewById(b.f.fix_tools_uplog_uploading));
    this.PoE = ((ImageView)findViewById(b.f.fix_tools_uplog_logo));
    this.lDb = ((Button)findViewById(b.f.fix_tools_uplog_finish));
    this.PoF = ((ProgressBar)findViewById(b.f.fix_tools_uplog_progress));
    this.PoE.setImageResource(b.h.fix_tools_uplog);
    this.PoD.setText(b.i.fix_tools_uplog_uploading);
    this.lDb.setOnClickListener(new FixToolsUpLogUploadingUI.1(this));
    setBackBtn(new FixToolsUpLogUploadingUI.2(this));
    this.PoF.setVisibility(0);
    this.lDb.setVisibility(8);
    paramBundle = getIntent().getStringExtra("date");
    com.tencent.mm.plugin.setting.model.b localb = com.tencent.mm.plugin.setting.model.b.gUU();
    com.tencent.mm.plugin.setting.model.b.Pnv = this.Pnv;
    Log.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { paramBundle, Boolean.valueOf(localb.oTC) });
    if (!localb.oTC)
    {
      localb.oTC = true;
      if (!com.tencent.mm.kernel.h.baz()) {
        break label344;
      }
      com.tencent.mm.kernel.h.baC();
    }
    label344:
    for (int i = com.tencent.mm.kernel.b.getUin();; i = 0)
    {
      long l1 = Util.nowMilliSecond() / 86400000L;
      long l2 = com.tencent.mm.plugin.setting.model.b.ahE(paramBundle + "000000");
      int j = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
      Log.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(j) });
      com.tencent.mm.kernel.h.aZW().a(new bw(new b.1(localb, j, i)), 0);
      AppMethodBeat.o(73819);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73820);
    if (paramInt == 4)
    {
      aAp(1);
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