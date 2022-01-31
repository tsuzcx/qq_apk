package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class f
  extends a
{
  public f(WalletCheckPwdNewUI paramWalletCheckPwdNewUI)
  {
    super(paramWalletCheckPwdNewUI);
  }
  
  public final void afz(String paramString)
  {
    AppMethodBeat.i(47130);
    Intent localIntent = new Intent();
    localIntent.putExtra("encrypt_pwd", paramString);
    this.umH.setResult(-1, localIntent);
    this.umH.finish();
    AppMethodBeat.o(47130);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(47129);
    String str = this.umH.getIntent().getStringExtra("title");
    if (!bo.isNullOrNil(str)) {
      this.umH.upH.setText(str);
    }
    AppMethodBeat.o(47129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */