package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;

public class SettingsAliasUI
  extends MMActivity
  implements f
{
  private String cMT;
  private ProgressDialog dnm = null;
  private ImageView doU;
  private TextView doV;
  private TextView frb;
  private EditText nTW;
  private d nTX;
  private boolean nTY = false;
  private TextView nTZ;
  private f nTf = null;
  
  protected final int getLayoutId()
  {
    return a.g.settings_alias;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.modify_username);
    this.doU = ((ImageView)findViewById(a.f.avatar_iv));
    this.doV = ((TextView)findViewById(a.f.nickname_tv));
    this.frb = ((TextView)findViewById(a.f.username_tv));
    this.nTZ = ((TextView)findViewById(a.f.modify_username_detail_message));
    this.nTW = ((EditText)findViewById(a.f.regbyqqreg_account_et));
    String str = q.Gj();
    if (!ad.aaX(str))
    {
      this.nTW.setText(q.Gj());
      this.frb.setText(getString(a.i.app_account, new Object[] { str }));
    }
    this.nTW.setSelection(this.nTW.getText().length());
    this.nTW.setFocusable(true);
    this.nTW.setFocusableInTouchMode(true);
    this.nTW.addTextChangedListener(new SettingsAliasUI.1(this));
    this.doV.setText(j.a(this, bk.pm(q.Gl()), this.doV.getTextSize()));
    a.b.a(this.doU, str);
    setBackBtn(new SettingsAliasUI.2(this));
    a(0, getString(a.i.app_save), new SettingsAliasUI.3(this), s.b.uNx);
    enableOptionMenu(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nTY = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    g.Dk().a(177, this);
  }
  
  public void onDestroy()
  {
    if (this.nTX != null) {
      g.Dk().c(this.nTX);
    }
    g.Dk().b(177, this);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.nTY) {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10358, "1");
      }
      XM();
      g.DP().Dz().o(42, this.cMT);
      paramString = g.Dk();
      paramm = new SettingsAliasUI.5(this);
      this.nTf = paramm;
      paramString.a(255, paramm);
      paramString = new r(1);
      g.Dk().a(paramString, 0);
    }
    for (;;)
    {
      return;
      if (this.dnm != null)
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      if (b.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
        paramInt1 = i;
      }
      while (paramInt1 != 0)
      {
        return;
        switch (paramInt1)
        {
        }
        do
        {
          paramInt1 = 0;
          break;
        } while ((paramInt2 != -7) && (paramInt2 != -10));
        com.tencent.mm.ui.base.h.h(this.mController.uMN, a.i.reg_username_exist_tip, a.i.modify_username_failed);
        paramInt1 = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */