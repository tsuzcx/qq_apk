package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI
  extends MMActivity
{
  private String AAw = "friend";
  private TextView AAx;
  private TextView AAy;
  
  public int getLayoutId()
  {
    return 2130970271;
  }
  
  public void initView()
  {
    AppMethodBeat.i(35210);
    setMMTitle(getString(2131303059));
    this.AAx = ((TextView)findViewById(2131826278));
    this.AAy = ((TextView)findViewById(2131826279));
    this.AAx.setText(getString(2131303069));
    String str = this.AAw;
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
      AppMethodBeat.o(35210);
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
      this.AAy.setText(getString(2131303070));
      continue;
      this.AAy.setText(getString(2131303071));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35209);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.SelectNoSupportUI", "onCreate!");
    this.AAw = getIntent().getStringExtra("sharePictureTo");
    ab.i("MicroMsg.SelectNoSupportUI", "initData done!");
    initView();
    ab.i("MicroMsg.SelectNoSupportUI", "initView done!");
    AppMethodBeat.o(35209);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectNoSupportUI
 * JD-Core Version:    0.7.0.1
 */