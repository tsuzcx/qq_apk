package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

final class h
  extends c
{
  public h(WalletCheckPwdNewUI paramWalletCheckPwdNewUI)
  {
    super(paramWalletCheckPwdNewUI);
  }
  
  public final void azA(String paramString)
  {
    AppMethodBeat.i(70680);
    Intent localIntent = new Intent();
    localIntent.putExtra("encrypt_pwd", paramString);
    this.BBF.setResult(-1, localIntent);
    this.BBF.finish();
    AppMethodBeat.o(70680);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(70679);
    String str = this.BBF.getIntent().getStringExtra("title");
    if (!bs.isNullOrNil(str)) {
      this.BBF.BEX.setText(str);
    }
    AppMethodBeat.o(70679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */