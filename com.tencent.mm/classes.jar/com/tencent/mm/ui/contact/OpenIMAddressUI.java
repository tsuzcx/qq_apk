package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment PSI;
  
  public int getLayoutId()
  {
    return 2131495886;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37918);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.PSI = new OpenIMAddressUI.OpenIMAddressUIFragment();
      this.PSI.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(2131302666, this.PSI).commit();
    }
    AppMethodBeat.o(37918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */