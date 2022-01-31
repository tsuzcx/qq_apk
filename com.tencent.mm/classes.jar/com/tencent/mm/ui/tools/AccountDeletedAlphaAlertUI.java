package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.model.aw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class AccountDeletedAlphaAlertUI
  extends MMActivity
{
  private static AccountDeletedAlphaAlertUI ApP = null;
  
  public static AccountDeletedAlphaAlertUI dNv()
  {
    return ApP;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34741);
    super.onCreate(paramBundle);
    ApP = this;
    paramBundle = new w();
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    aw.hold();
    paramBundle = com.tencent.mm.h.a.kO(getIntent().getStringExtra("errmsg"));
    if (paramBundle != null)
    {
      paramBundle.a(this, new AccountDeletedAlphaAlertUI.1(this), null);
      AppMethodBeat.o(34741);
      return;
    }
    h.a(this, getString(2131301415), null, false, new AccountDeletedAlphaAlertUI.2(this));
    AppMethodBeat.o(34741);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34742);
    if (equals(ApP)) {
      ApP = null;
    }
    super.onDestroy();
    AppMethodBeat.o(34742);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI
 * JD-Core Version:    0.7.0.1
 */