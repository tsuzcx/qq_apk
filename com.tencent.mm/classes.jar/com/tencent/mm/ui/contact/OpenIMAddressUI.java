package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment Aan;
  
  public int getLayoutId()
  {
    return 2130970391;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33800);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.Aan = new OpenIMAddressUI.OpenIMAddressUIFragment();
      this.Aan.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(2131826641, this.Aan).commit();
    }
    AppMethodBeat.o(33800);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */