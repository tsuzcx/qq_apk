package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class RemittanceMsgAlertActivity
  extends AppCompatActivity
{
  public Resources getResources()
  {
    AppMethodBeat.i(227108);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(227108);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68212);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    boolean bool = getIntent().getBooleanExtra("key_is_no_contact", false);
    paramBundle = new f.a(this);
    Context localContext = MMApplicationContext.getContext();
    if (bool) {}
    for (int i = a.i.remittance_find_from_jsapi_failed_nocontact;; i = a.i.remittance_find_from_jsapi_failed_delete)
    {
      paramBundle = paramBundle.bBl(localContext.getString(i)).ayq(MMApplicationContext.getContext().getResources().getColor(a.c.wechat_green)).ayp(a.i.i_know_it).b(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity
 * JD-Core Version:    0.7.0.1
 */