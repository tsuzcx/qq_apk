package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.c.b;

public final class h
{
  public int quD = 0;
  public String quE = "";
  public int quF = 0;
  public String quG = "";
  public int quH = 0;
  public b quI = new b();
  
  public h() {}
  
  public h(Bundle paramBundle)
  {
    this.quD = paramBundle.getInt("key_is_gen_cert", 0);
    this.quF = paramBundle.getInt("key_is_hint_crt", 0);
    this.quH = paramBundle.getInt("key_is_ignore_cert", 0);
    this.quE = paramBundle.getString("key_crt_token", "");
    this.quG = paramBundle.getString("key_crt_wording", "");
    this.quI = new b(this.quG);
  }
  
  public final boolean bUZ()
  {
    return (this.quF != 0) && (!bk.bl(this.quG));
  }
  
  public final boolean bVa()
  {
    return this.quD == 1;
  }
  
  public final boolean bVb()
  {
    return (bVa()) && (this.quH == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.h
 * JD-Core Version:    0.7.0.1
 */