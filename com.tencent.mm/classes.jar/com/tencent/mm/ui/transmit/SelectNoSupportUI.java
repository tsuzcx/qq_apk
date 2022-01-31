package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI
  extends MMActivity
{
  private String whB = "friend";
  private TextView whC;
  private TextView whD;
  
  protected final int getLayoutId()
  {
    return R.i.mm_select_no_support_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(getString(R.l.select_conversation_title));
    this.whC = ((TextView)findViewById(R.h.no_share_title_tx));
    this.whD = ((TextView)findViewById(R.h.no_share_detail_tv));
    this.whC.setText(getString(R.l.select_no_support_no_share_to_wechat));
    String str = this.whB;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      setBackBtn(new SelectNoSupportUI.1(this));
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
      this.whD.setText(getString(R.l.select_no_support_share_excced_pricture_to_friend));
      continue;
      this.whD.setText(getString(R.l.select_no_support_share_multi_pricture_to_sns));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.SelectNoSupportUI", "onCreate!");
    this.whB = getIntent().getStringExtra("sharePictureTo");
    y.i("MicroMsg.SelectNoSupportUI", "initData done!");
    initView();
    y.i("MicroMsg.SelectNoSupportUI", "initView done!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectNoSupportUI
 * JD-Core Version:    0.7.0.1
 */