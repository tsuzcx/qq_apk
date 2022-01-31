package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class WxaBindWxaInfoUI
  extends MMActivity
{
  private ListView mListView;
  private TextView pxU;
  
  public final int getLayoutId()
  {
    return 2130971333;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143694);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(143694);
      return;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(143687);
        WxaBindWxaInfoUI.this.finish();
        AppMethodBeat.o(143687);
        return false;
      }
    });
    setMMTitle(2131296808);
    setActionbarColor(getActionbarColor());
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    paramBundle = getIntent().getStringExtra("register");
    View localView = getLayoutInflater().inflate(2130971332, null);
    this.pxU = ((TextView)localView.findViewById(2131821335));
    TextView localTextView = this.pxU;
    if (bo.isNullOrNil(paramBundle)) {
      paramBundle = getString(2131296808);
    }
    for (;;)
    {
      localTextView.setText(paramBundle);
      this.mListView = ((ListView)findViewById(2131821835));
      this.mListView.addHeaderView(localView);
      this.mListView.setAdapter(new WxaBindWxaInfoUI.a(getLayoutInflater(), localArrayList));
      this.mListView.setOnItemClickListener(new WxaBindWxaInfoUI.2(this));
      getContentView().setBackgroundResource(2131690446);
      AppMethodBeat.o(143694);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI
 * JD-Core Version:    0.7.0.1
 */