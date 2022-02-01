package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI
  extends MMActivity
{
  private String HwO = "friend";
  private TextView HwP;
  private TextView HwQ;
  
  public int getLayoutId()
  {
    return 2131494901;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39412);
    setMMTitle(getString(2131763005));
    this.HwP = ((TextView)findViewById(2131302887));
    this.HwQ = ((TextView)findViewById(2131302886));
    this.HwP.setText(getString(2131763015));
    String str = this.HwO;
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
      this.HwQ.setText(getString(2131763016));
      continue;
      this.HwQ.setText(getString(2131763017));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39411);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.SelectNoSupportUI", "onCreate!");
    this.HwO = getIntent().getStringExtra("sharePictureTo");
    ad.i("MicroMsg.SelectNoSupportUI", "initData done!");
    initView();
    ad.i("MicroMsg.SelectNoSupportUI", "initView done!");
    AppMethodBeat.o(39411);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectNoSupportUI
 * JD-Core Version:    0.7.0.1
 */