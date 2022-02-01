package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;
import com.tencent.mm.g.a.we;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMFragment;

public class AddressUI
  extends FragmentActivity
{
  public MMFragment PSI;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37647);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.PSI = new AddressUI.AddressUIFragment();
      this.PSI.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.PSI).commit();
    }
    AppMethodBeat.o(37647);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI
 * JD-Core Version:    0.7.0.1
 */