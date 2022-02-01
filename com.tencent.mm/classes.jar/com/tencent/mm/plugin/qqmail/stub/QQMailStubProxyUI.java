package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.plugin.qqmail.ui.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI
  extends HellActivity
{
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(122804);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
    paramBundle = new c(this);
    paramBundle.a(new c.a()
    {
      public final void gEf()
      {
        AppMethodBeat.i(122802);
        Log.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
        paramBundle.release();
        QQMailStubProxyUI.this.setResult(-1);
        QQMailStubProxyUI.this.finish();
        AppMethodBeat.o(122802);
      }
      
      public final void gEg()
      {
        AppMethodBeat.i(122803);
        Log.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
        paramBundle.release();
        QQMailStubProxyUI.this.setResult(0);
        QQMailStubProxyUI.this.finish();
        AppMethodBeat.o(122803);
      }
    });
    AppMethodBeat.o(122804);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI
 * JD-Core Version:    0.7.0.1
 */