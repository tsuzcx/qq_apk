package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.setting.model.a.1;
import com.tencent.mm.plugin.setting.model.a.2;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUpLogUploadingUI
  extends MMWizardActivity
{
  private Button iDz;
  public a.a qEA;
  private TextView qFk;
  private ImageView qFl;
  protected ProgressBar qFm;
  
  public FixToolsUpLogUploadingUI()
  {
    AppMethodBeat.i(126889);
    this.qEA = new FixToolsUpLogUploadingUI.3(this);
    AppMethodBeat.o(126889);
  }
  
  public int getLayoutId()
  {
    return 2130969602;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126890);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(126890);
      return;
    }
    setMMTitle(2131299986);
    this.qFk = ((TextView)findViewById(2131824187));
    this.qFl = ((ImageView)findViewById(2131824186));
    this.iDz = ((Button)findViewById(2131824189));
    this.qFm = ((ProgressBar)findViewById(2131824188));
    this.qFl.setImageResource(2131231345);
    this.qFk.setText(2131299992);
    this.iDz.setOnClickListener(new FixToolsUpLogUploadingUI.1(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(126887);
        FixToolsUpLogUploadingUI.b(FixToolsUpLogUploadingUI.this);
        AppMethodBeat.o(126887);
        return true;
      }
    });
    this.qFm.setVisibility(0);
    this.iDz.setVisibility(8);
    String str = getIntent().getStringExtra("date");
    com.tencent.mm.plugin.setting.model.a locala = com.tencent.mm.plugin.setting.model.a.cjQ();
    com.tencent.mm.plugin.setting.model.a.qEA = this.qEA;
    ab.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { str, Boolean.valueOf(locala.fQi) });
    if (!locala.fQi)
    {
      locala.fQi = true;
      paramBundle = "weixin";
      if (g.RG()) {
        paramBundle = r.Zn();
      }
      long l1 = bo.aoy() / 86400000L;
      long l2 = com.tencent.mm.plugin.setting.model.a.Gm(str + "000000");
      int i = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
      ab.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
      g.Rc().a(new bk(new a.1(locala, paramBundle, i)), 0);
      b.a(new a.2(locala));
    }
    AppMethodBeat.o(126890);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126891);
    if (paramInt == 4)
    {
      Oi(1);
      AppMethodBeat.o(126891);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(126891);
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