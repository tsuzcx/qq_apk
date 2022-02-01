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
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.setting.model.a.1;
import com.tencent.mm.plugin.setting.model.a.2;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUpLogUploadingUI
  extends MMWizardActivity
{
  private Button fRF;
  public a.a ySN;
  private TextView yTE;
  private ImageView yTF;
  protected ProgressBar yTG;
  
  public FixToolsUpLogUploadingUI()
  {
    AppMethodBeat.i(73818);
    this.ySN = new a.a()
    {
      public final void PJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(73817);
        ae.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt < 0)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(873L, 18L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(2131690203);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(2131759436);
          FixToolsUpLogUploadingUI.this.yTG.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        if (paramAnonymousInt >= 100)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(873L, 17L, 1L, false);
          FixToolsUpLogUploadingUI.c(FixToolsUpLogUploadingUI.this).setImageResource(2131690204);
          FixToolsUpLogUploadingUI.d(FixToolsUpLogUploadingUI.this).setText(2131759437);
          FixToolsUpLogUploadingUI.this.yTG.setVisibility(8);
          FixToolsUpLogUploadingUI.e(FixToolsUpLogUploadingUI.this).setVisibility(0);
          AppMethodBeat.o(73817);
          return;
        }
        FixToolsUpLogUploadingUI.this.yTG.setProgress(paramAnonymousInt);
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
    this.yTE = ((TextView)findViewById(2131300121));
    this.yTF = ((ImageView)findViewById(2131300118));
    this.fRF = ((Button)findViewById(2131300117));
    this.yTG = ((ProgressBar)findViewById(2131300119));
    this.yTF.setImageResource(2131690209);
    this.yTE.setText(2131759440);
    this.fRF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(73815);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUpLogUploadingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FixToolsUpLogUploadingUI.a(FixToolsUpLogUploadingUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUpLogUploadingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.yTG.setVisibility(0);
    this.fRF.setVisibility(8);
    String str = getIntent().getStringExtra("date");
    com.tencent.mm.plugin.setting.model.a locala = com.tencent.mm.plugin.setting.model.a.dQF();
    com.tencent.mm.plugin.setting.model.a.ySN = this.ySN;
    ae.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { str, Boolean.valueOf(locala.ipD) });
    if (!locala.ipD)
    {
      locala.ipD = true;
      paramBundle = "weixin";
      if (com.tencent.mm.kernel.g.ajM()) {
        paramBundle = v.aAC();
      }
      long l1 = bu.fpO() / 86400000L;
      long l2 = com.tencent.mm.plugin.setting.model.a.WH(str + "000000");
      int i = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
      ae.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
      com.tencent.mm.kernel.g.ajj().a(new bq(new a.1(locala, paramBundle, i)), 0);
      com.tencent.mm.kernel.b.a(new a.2(locala));
    }
    AppMethodBeat.o(73819);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73820);
    if (paramInt == 4)
    {
      acs(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI
 * JD-Core Version:    0.7.0.1
 */