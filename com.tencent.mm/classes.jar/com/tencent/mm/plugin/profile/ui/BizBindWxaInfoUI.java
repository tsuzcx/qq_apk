package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class BizBindWxaInfoUI
  extends MMActivity
{
  private TextView pxU;
  private ListView pxV;
  private String pxW;
  private String pxX;
  
  public final int getLayoutId()
  {
    return 2130968859;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(134419);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(134419);
      return;
    }
    this.pxW = getIntent().getStringExtra("extra_username");
    this.pxX = getIntent().getStringExtra("extra_appid");
    setBackBtn(new BizBindWxaInfoUI.1(this));
    setMMTitle(2131298528);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
    View localView = getLayoutInflater().inflate(2130968858, null);
    this.pxU = ((TextView)localView.findViewById(2131821335));
    TextView localTextView = this.pxU;
    if (paramBundle != null) {}
    for (int i = paramBundle.size();; i = 0)
    {
      localTextView.setText(getString(2131297671, new Object[] { Integer.valueOf(i) }));
      this.pxV = ((ListView)findViewById(2131821835));
      this.pxV.addHeaderView(localView);
      this.pxV.setAdapter(new BizBindWxaInfoUI.a(getLayoutInflater(), paramBundle));
      this.pxV.setOnItemClickListener(new BizBindWxaInfoUI.2(this));
      getContentView().setBackgroundResource(2131690446);
      AppMethodBeat.o(134419);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */