package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.MenuItem;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.x;

public class OpenIMAddressUI
  extends MMActivity
{
  public x vIR;
  
  protected final int getLayoutId()
  {
    return R.i.open_im_address_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.Z(16908290) == null)
    {
      this.vIR = new OpenIMAddressUI.a();
      this.vIR.setArguments(getIntent().getExtras());
      paramBundle.bP().a(R.h.inner_content, this.vIR).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */