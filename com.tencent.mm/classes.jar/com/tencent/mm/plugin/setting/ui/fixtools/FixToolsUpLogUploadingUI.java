package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.a.1;
import com.tencent.mm.plugin.setting.model.a.2;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUpLogUploadingUI
  extends MMWizardActivity
{
  private Button fsF;
  public a.a wcR;
  private TextView wdH;
  private ImageView wdI;
  protected ProgressBar wdJ;
  
  public FixToolsUpLogUploadingUI()
  {
    AppMethodBeat.i(73818);
    this.wcR = new a.a()
    {
      public final void Lx(int paramAnonymousInt)
      {
        AppMethodBeat.i(73817);
        ad.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt < 0)
        {
          h.vKh.idkeyStat(873L, 18L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(2131690203);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(2131759436);
          FixToolsUpLogUploadingUI.this.wdJ.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        if (paramAnonymousInt >= 100)
        {
          h.vKh.idkeyStat(873L, 17L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(2131690204);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(2131759437);
          FixToolsUpLogUploadingUI.this.wdJ.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        FixToolsUpLogUploadingUI.this.wdJ.setProgress(paramAnonymousInt);
        AppMethodBeat.o(73817);
      }
    };
    AppMethodBeat.o(73818);
  }
  
  public int getLayoutId()
  {
    return 2131494142;
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
    setMMTitle(2131759434);
    this.wdH = ((TextView)findViewById(2131300121));
    this.wdI = ((ImageView)findViewById(2131300118));
    this.fsF = ((Button)findViewById(2131300117));
    this.wdJ = ((ProgressBar)findViewById(2131300119));
    this.wdI.setImageResource(2131690209);
    this.wdH.setText(2131759440);
    this.fsF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(73815);
        FixToolsUpLogUploadingUI.a(FixToolsUpLogUploadingUI.this);
        AppMethodBeat.o(73815);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73816);
        FixToolsUpLogUploadingUI.b(FixToolsUpLogUploadingUI.this);
        AppMethodBeat.o(73816);
        return true;
      }
    });
    this.wdJ.setVisibility(0);
    this.fsF.setVisibility(8);
    String str = getIntent().getStringExtra("date");
    com.tencent.mm.plugin.setting.model.a locala = com.tencent.mm.plugin.setting.model.a.dny();
    com.tencent.mm.plugin.setting.model.a.wcR = this.wcR;
    ad.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { str, Boolean.valueOf(locala.hsM) });
    if (!locala.hsM)
    {
      locala.hsM = true;
      paramBundle = "weixin";
      if (g.afw()) {
        paramBundle = u.aqG();
      }
      long l1 = bt.eGO() / 86400000L;
      long l2 = com.tencent.mm.plugin.setting.model.a.On(str + "000000");
      int i = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
      ad.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
      g.aeS().a(new bn(new a.1(locala, paramBundle, i)), 0);
      b.a(new a.2(locala));
    }
    AppMethodBeat.o(73819);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73820);
    if (paramInt == 4)
    {
      Xo(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI
 * JD-Core Version:    0.7.0.1
 */