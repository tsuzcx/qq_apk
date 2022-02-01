package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class j
  extends e
{
  public j(WalletCheckPwdNewUI paramWalletCheckPwdNewUI)
  {
    super(paramWalletCheckPwdNewUI);
  }
  
  public final void aQI(String paramString)
  {
    AppMethodBeat.i(70680);
    Intent localIntent = new Intent();
    localIntent.putExtra("encrypt_pwd", paramString);
    this.VLr.setResult(-1, localIntent);
    this.VLr.finish();
    AppMethodBeat.o(70680);
  }
  
  public final boolean gwr()
  {
    return false;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(70679);
    String str = this.VLr.getIntent().getStringExtra("title");
    if (!Util.isNullOrNil(str)) {
      this.VLr.Vju.setText(str);
    }
    str = this.VLr.getIntent().getStringExtra("subtitle");
    if (!Util.isNullOrNil(str)) {
      this.VLr.Vjv.setText(str);
    }
    AppMethodBeat.o(70679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */