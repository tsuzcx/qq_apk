package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI
  extends MMActivity
{
  private String QzS = "friend";
  private TextView QzT;
  private TextView QzU;
  
  public int getLayoutId()
  {
    return 2131495639;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39412);
    setMMTitle(getString(2131765142));
    this.QzT = ((TextView)findViewById(2131305464));
    this.QzU = ((TextView)findViewById(2131305463));
    this.QzT.setText(getString(2131765152));
    String str;
    int i;
    if (!Util.isNullOrNil(this.QzS))
    {
      str = this.QzS;
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
      this.QzU.setText(getString(2131765153));
      continue;
      this.QzU.setText(getString(2131765154));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39411);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectNoSupportUI", "onCreate!");
    this.QzS = getIntent().getStringExtra("sharePictureTo");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectNoSupportUI
 * JD-Core Version:    0.7.0.1
 */