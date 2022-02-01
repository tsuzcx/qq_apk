package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public abstract class MallBaseUI
  extends MMActivity
{
  protected String kwn;
  
  protected final void avQ(String paramString)
  {
    this.kwn = paramString;
    showDialog(-10001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66933);
        MallBaseUI.this.finish();
        AppMethodBeat.o(66933);
        return true;
      }
    });
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case -10001: 
      if (bu.isNullOrNil(this.kwn)) {
        this.kwn = getString(2131761118);
      }
      com.tencent.mm.ui.base.h.a(this, this.kwn, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(66934);
          MallBaseUI.this.finish();
          AppMethodBeat.o(66934);
        }
      });
    }
    com.tencent.mm.wallet_core.ui.h.a(getContext(), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1)) {
      callBackMenu();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    getContentView().setVisibility(paramInt);
    if (paramInt == 0)
    {
      showTitleView();
      return;
    }
    hideTitleView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallBaseUI
 * JD-Core Version:    0.7.0.1
 */