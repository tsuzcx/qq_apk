package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.a.1;
import com.tencent.mm.plugin.setting.model.a.2;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUpLogUploadingUI
  extends MMWizardActivity
{
  private Button ksU;
  public a.a nQD = new FixToolsUpLogUploadingUI.3(this);
  private TextView nRm;
  private ImageView nRn;
  protected ProgressBar nRo;
  
  protected final int getLayoutId()
  {
    return a.g.fix_tools_uplog_uploading;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {}
    String str;
    com.tencent.mm.plugin.setting.model.a locala;
    do
    {
      return;
      setMMTitle(a.i.fix_tools_uplog);
      this.nRm = ((TextView)findViewById(a.f.fix_tools_uplog_uploading));
      this.nRn = ((ImageView)findViewById(a.f.fix_tools_uplog_logo));
      this.ksU = ((Button)findViewById(a.f.fix_tools_uplog_finish));
      this.nRo = ((ProgressBar)findViewById(a.f.fix_tools_uplog_progress));
      this.nRn.setImageResource(a.h.fix_tools_uplog);
      this.nRm.setText(a.i.fix_tools_uplog_uploading);
      this.ksU.setOnClickListener(new FixToolsUpLogUploadingUI.1(this));
      setBackBtn(new FixToolsUpLogUploadingUI.2(this));
      this.nRo.setVisibility(0);
      this.ksU.setVisibility(8);
      str = getIntent().getStringExtra("date");
      locala = com.tencent.mm.plugin.setting.model.a.byG();
      com.tencent.mm.plugin.setting.model.a.nQD = this.nQD;
      y.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", new Object[] { str, Boolean.valueOf(locala.eAp) });
    } while (locala.eAp);
    locala.eAp = true;
    paramBundle = "weixin";
    if (g.DK()) {
      paramBundle = q.Gj();
    }
    long l1 = bk.UY() / 86400000L;
    long l2 = com.tencent.mm.plugin.setting.model.a.xt(str + "000000");
    int i = (int)((l1 * 86400000L + 57600000L - 1L - l2) / 86400000L);
    y.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
    g.Dk().a(new bi(new a.1(locala, paramBundle, i)), 0);
    b.a(new a.2(locala));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI
 * JD-Core Version:    0.7.0.1
 */