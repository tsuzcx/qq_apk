package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.af;
import com.tencent.mm.model.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(3)
public class AccountDeletedAlphaAlertUI
  extends MMActivity
{
  private static AccountDeletedAlphaAlertUI afCX = null;
  
  public static AccountDeletedAlphaAlertUI jCI()
  {
    return afCX;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38935);
    super.onCreate(paramBundle);
    afCX = this;
    new af().publish();
    bh.aZH();
    paramBundle = com.tencent.mm.broadcast.a.CH(getIntent().getStringExtra("errmsg"));
    if (paramBundle != null)
    {
      paramBundle.a(this, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38933);
          AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
          AppMethodBeat.o(38933);
        }
      }, null);
      AppMethodBeat.o(38935);
      return;
    }
    k.a(this, getString(R.l.gNm), null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(38934);
        AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
        AppMethodBeat.o(38934);
      }
    });
    AppMethodBeat.o(38935);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38936);
    if (equals(afCX)) {
      afCX = null;
    }
    super.onDestroy();
    AppMethodBeat.o(38936);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI
 * JD-Core Version:    0.7.0.1
 */