package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;

public final class BizBindWxaInfoUI
  extends DrawStatusBarActivity
{
  private TextView mVp;
  private ListView mVq;
  private String mVr;
  private String mVs;
  
  protected final int getLayoutId()
  {
    return y.h.biz_bind_wxa_info_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      return;
    }
    this.mVr = getIntent().getStringExtra("extra_username");
    this.mVs = getIntent().getStringExtra("extra_appid");
    setBackBtn(new BizBindWxaInfoUI.1(this));
    setMMTitle(y.j.contact_info_bind_weapp);
    ta(this.mController.czv());
    paramBundle = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
    View localView = getLayoutInflater().inflate(y.h.biz_bind_wxa_info_header, null);
    this.mVp = ((TextView)localView.findViewById(y.g.titleTv));
    TextView localTextView = this.mVp;
    int j = y.j.biz_bind_weapp_provide_service;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(j, new Object[] { Integer.valueOf(i) }));
      this.mVq = ((ListView)findViewById(y.g.dataLv));
      this.mVq.addHeaderView(localView);
      this.mVq.setAdapter(new BizBindWxaInfoUI.a(getLayoutInflater(), paramBundle));
      this.mVq.setOnItemClickListener(new BizBindWxaInfoUI.2(this));
      this.mController.contentView.setBackgroundResource(y.d.settings_bg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */