package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.plugin.qqmail.ui.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI
  extends Activity
{
  protected void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(68078);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
    paramBundle = new c(this);
    paramBundle.a(new c.a()
    {
      public final void cdT()
      {
        AppMethodBeat.i(68076);
        ab.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
        paramBundle.release();
        QQMailStubProxyUI.this.setResult(-1);
        QQMailStubProxyUI.this.finish();
        AppMethodBeat.o(68076);
      }
      
      public final void cdU()
      {
        AppMethodBeat.i(68077);
        ab.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
        paramBundle.release();
        QQMailStubProxyUI.this.setResult(0);
        QQMailStubProxyUI.this.finish();
        AppMethodBeat.o(68077);
      }
    });
    AppMethodBeat.o(68078);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI
 * JD-Core Version:    0.7.0.1
 */