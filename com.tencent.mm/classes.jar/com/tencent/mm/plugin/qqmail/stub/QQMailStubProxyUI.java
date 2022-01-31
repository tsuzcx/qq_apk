package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.plugin.qqmail.ui.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI
  extends Activity
{
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
    paramBundle = new c(this);
    paramBundle.a(new c.a()
    {
      public final void btI()
      {
        y.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
        paramBundle.release();
        QQMailStubProxyUI.this.setResult(-1);
        QQMailStubProxyUI.this.finish();
      }
      
      public final void btJ()
      {
        y.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
        paramBundle.release();
        QQMailStubProxyUI.this.setResult(0);
        QQMailStubProxyUI.this.finish();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI
 * JD-Core Version:    0.7.0.1
 */