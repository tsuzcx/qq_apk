package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.c;

public final class k
{
  public String crt_token;
  public String crt_wording;
  public int is_gen_cert;
  public int is_hint_cert;
  public int is_ignore_cert;
  public c uhb;
  
  public k()
  {
    AppMethodBeat.i(46739);
    this.is_gen_cert = 0;
    this.crt_token = "";
    this.is_hint_cert = 0;
    this.crt_wording = "";
    this.is_ignore_cert = 0;
    this.uhb = new c();
    AppMethodBeat.o(46739);
  }
  
  public k(Bundle paramBundle)
  {
    AppMethodBeat.i(46740);
    this.is_gen_cert = 0;
    this.crt_token = "";
    this.is_hint_cert = 0;
    this.crt_wording = "";
    this.is_ignore_cert = 0;
    this.uhb = new c();
    this.is_gen_cert = paramBundle.getInt("key_is_gen_cert", 0);
    this.is_hint_cert = paramBundle.getInt("key_is_hint_crt", 0);
    this.is_ignore_cert = paramBundle.getInt("key_is_ignore_cert", 0);
    this.crt_token = paramBundle.getString("key_crt_token", "");
    this.crt_wording = paramBundle.getString("key_crt_wording", "");
    this.uhb = new c(this.crt_wording);
    AppMethodBeat.o(46740);
  }
  
  public final boolean cTq()
  {
    AppMethodBeat.i(46741);
    if ((this.is_hint_cert != 0) && (!bo.isNullOrNil(this.crt_wording)))
    {
      AppMethodBeat.o(46741);
      return true;
    }
    AppMethodBeat.o(46741);
    return false;
  }
  
  public final boolean cTr()
  {
    return this.is_gen_cert == 1;
  }
  
  public final boolean cTs()
  {
    AppMethodBeat.i(46742);
    if ((cTr()) && (this.is_ignore_cert == 0))
    {
      AppMethodBeat.o(46742);
      return true;
    }
    AppMethodBeat.o(46742);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.k
 * JD-Core Version:    0.7.0.1
 */