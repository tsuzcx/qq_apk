package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;

public class RemittanceMsgAlertActivity
  extends AppCompatActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45083);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    boolean bool = getIntent().getBooleanExtra("key_is_no_contact", false);
    paramBundle = new e.a(this);
    Context localContext = ah.getContext();
    if (bool) {}
    for (int i = 2131302583;; i = 2131302582)
    {
      paramBundle = paramBundle.avu(localContext.getString(i)).Rn(ah.getContext().getResources().getColor(2131690701)).Rm(2131300718).b(new e.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      });
      paramBundle.b(new RemittanceMsgAlertActivity.2(this));
      paramBundle.show();
      AppMethodBeat.o(45083);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45084);
    super.onDestroy();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(45084);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity
 * JD-Core Version:    0.7.0.1
 */