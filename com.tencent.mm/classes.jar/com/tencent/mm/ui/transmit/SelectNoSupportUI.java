package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI
  extends MMActivity
{
  private String XYq = "friend";
  private TextView XYr;
  private TextView XYs;
  
  public int getLayoutId()
  {
    return R.i.mm_select_no_support_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39412);
    setMMTitle(getString(R.l.eRX));
    this.XYr = ((TextView)findViewById(R.h.no_share_title_tx));
    this.XYs = ((TextView)findViewById(R.h.no_share_detail_tv));
    this.XYr.setText(getString(R.l.select_no_support_no_share_to_wechat));
    String str;
    int i;
    if (!Util.isNullOrNil(this.XYq))
    {
      str = this.XYq;
      i = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39410);
          paramAnonymousMenuItem = SelectNoSupportUI.this;
          paramAnonymousMenuItem.hideVKB();
          paramAnonymousMenuItem.finish();
          AppMethodBeat.o(39410);
          return true;
        }
      });
      AppMethodBeat.o(39412);
      return;
      if (!str.equals("friend")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("sns")) {
        break;
      }
      i = 1;
      break;
      this.XYs.setText(getString(R.l.select_no_support_share_excced_pricture_to_friend));
      continue;
      this.XYs.setText(getString(R.l.select_no_support_share_multi_pricture_to_sns));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39411);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectNoSupportUI", "onCreate!");
    this.XYq = getIntent().getStringExtra("sharePictureTo");
    Log.i("MicroMsg.SelectNoSupportUI", "initData done!");
    initView();
    Log.i("MicroMsg.SelectNoSupportUI", "initView done!");
    AppMethodBeat.o(39411);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectNoSupportUI
 * JD-Core Version:    0.7.0.1
 */