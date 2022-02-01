package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.d;

public final class i
{
  public d VEJ;
  public String crt_token;
  public String crt_wording;
  public int is_gen_cert;
  public int is_hint_cert;
  public int is_ignore_cert;
  
  public i()
  {
    AppMethodBeat.i(70256);
    this.is_gen_cert = 0;
    this.crt_token = "";
    this.is_hint_cert = 0;
    this.crt_wording = "";
    this.is_ignore_cert = 0;
    this.VEJ = new d();
    AppMethodBeat.o(70256);
  }
  
  public i(Bundle paramBundle)
  {
    AppMethodBeat.i(70257);
    this.is_gen_cert = 0;
    this.crt_token = "";
    this.is_hint_cert = 0;
    this.crt_wording = "";
    this.is_ignore_cert = 0;
    this.VEJ = new d();
    this.is_gen_cert = paramBundle.getInt("key_is_gen_cert", 0);
    this.is_hint_cert = paramBundle.getInt("key_is_hint_crt", 0);
    this.is_ignore_cert = paramBundle.getInt("key_is_ignore_cert", 0);
    this.crt_token = paramBundle.getString("key_crt_token", "");
    this.crt_wording = paramBundle.getString("key_crt_wording", "");
    this.VEJ = new d(this.crt_wording);
    AppMethodBeat.o(70257);
  }
  
  public final boolean iig()
  {
    AppMethodBeat.i(70258);
    if ((this.is_hint_cert != 0) && (!Util.isNullOrNil(this.crt_wording)))
    {
      AppMethodBeat.o(70258);
      return true;
    }
    AppMethodBeat.o(70258);
    return false;
  }
  
  public final boolean iih()
  {
    return this.is_gen_cert == 1;
  }
  
  public final boolean iii()
  {
    AppMethodBeat.i(70259);
    if ((iih()) && (this.is_ignore_cert == 0))
    {
      AppMethodBeat.o(70259);
      return true;
    }
    AppMethodBeat.o(70259);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.i
 * JD-Core Version:    0.7.0.1
 */