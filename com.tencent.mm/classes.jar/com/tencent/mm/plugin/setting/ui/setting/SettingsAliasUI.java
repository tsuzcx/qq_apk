package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public class SettingsAliasUI
  extends MMActivity
  implements f
{
  private String dCJ;
  private ProgressDialog eeN = null;
  private ImageView egq;
  private TextView egr;
  private TextView gIE;
  private EditText qHW;
  private d qHX;
  private boolean qHY = false;
  private TextView qHZ;
  private f qHf = null;
  
  public int getLayoutId()
  {
    return 2130970689;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127194);
    setMMTitle(2131301615);
    this.egq = ((ImageView)findViewById(2131821210));
    this.egr = ((TextView)findViewById(2131823254));
    this.gIE = ((TextView)findViewById(2131827077));
    this.qHZ = ((TextView)findViewById(2131827603));
    this.qHW = ((EditText)findViewById(2131827602));
    String str = r.Zn();
    if (!ad.ari(str))
    {
      this.qHW.setText(r.Zn());
      this.gIE.setText(getString(2131296536, new Object[] { str }));
    }
    this.qHW.setSelection(this.qHW.getText().length());
    this.qHW.setFocusable(true);
    this.qHW.setFocusableInTouchMode(true);
    this.qHW.addTextChangedListener(new SettingsAliasUI.1(this));
    this.egr.setText(j.b(this, bo.nullAsNil(r.Zp()), this.egr.getTextSize()));
    a.b.c(this.egq, str);
    setBackBtn(new SettingsAliasUI.2(this));
    addTextOptionMenu(0, getString(2131297063), new SettingsAliasUI.3(this), null, q.b.zby);
    enableOptionMenu(false);
    AppMethodBeat.o(127194);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127191);
    super.onCreate(paramBundle);
    this.qHY = getIntent().getBooleanExtra("KFromSetAliasTips", false);
    initView();
    g.Rc().a(177, this);
    AppMethodBeat.o(127191);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127193);
    if (this.qHX != null) {
      g.Rc().a(this.qHX);
    }
    g.Rc().b(177, this);
    super.onDestroy();
    AppMethodBeat.o(127193);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127192);
    super.onPause();
    AppMethodBeat.o(127192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = 1;
    AppMethodBeat.i(127195);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.qHY) {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10358, "1");
      }
      hideVKB();
      g.RL().Ru().set(42, this.dCJ);
      paramString = g.Rc();
      paramm = new SettingsAliasUI.5(this);
      this.qHf = paramm;
      paramString.a(255, paramm);
      paramString = new t(1);
      g.Rc().a(paramString, 0);
      AppMethodBeat.o(127195);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (b.gmP.a(getContext(), paramInt1, paramInt2, paramString)) {
      paramInt1 = i;
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(127195);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        paramInt1 = 0;
        break;
      } while ((paramInt2 != -7) && (paramInt2 != -10));
      com.tencent.mm.ui.base.h.h(getContext(), 2131302377, 2131301619);
      paramInt1 = i;
    }
    AppMethodBeat.o(127195);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI
 * JD-Core Version:    0.7.0.1
 */