package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class RemittanceMsgAlertActivity
  extends AppCompatActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68212);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    boolean bool = getIntent().getBooleanExtra("key_is_no_contact", false);
    paramBundle = new f.a(this);
    Context localContext = ak.getContext();
    if (bool) {}
    for (int i = 2131762489;; i = 2131762488)
    {
      paramBundle = paramBundle.aZq(localContext.getString(i)).afZ(ak.getContext().getResources().getColor(2131101171)).afY(2131760315).b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      });
      paramBundle.b(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(68211);
          RemittanceMsgAlertActivity.this.finish();
          AppMethodBeat.o(68211);
        }
      });
      paramBundle.show();
      AppMethodBeat.o(68212);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68213);
    super.onDestroy();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(68213);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity
 * JD-Core Version:    0.7.0.1
 */