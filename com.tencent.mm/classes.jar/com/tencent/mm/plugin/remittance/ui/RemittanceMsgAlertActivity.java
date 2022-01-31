package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.d;

public class RemittanceMsgAlertActivity
  extends AppCompatActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    boolean bool = getIntent().getBooleanExtra("key_is_no_contact", false);
    paramBundle = new e.a(this);
    Context localContext = ae.getContext();
    if (bool) {}
    for (int i = a.i.remittance_find_from_jsapi_failed_nocontact;; i = a.i.remittance_find_from_jsapi_failed_delete)
    {
      paramBundle = paramBundle.aeG(localContext.getString(i)).Iv(ae.getContext().getResources().getColor(a.c.wechat_green)).Iu(a.i.i_know_it).b(new e.d()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      });
      paramBundle.b(new RemittanceMsgAlertActivity.2(this));
      paramBundle.show();
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity
 * JD-Core Version:    0.7.0.1
 */