package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.e.i;

public final class e
  extends i<t>
{
  public static final String[] dXp = { i.a(t.buS, "WalletFunciontList") };
  public com.tencent.mm.sdk.e.e dXw;
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, t.buS, "WalletFunciontList", null);
    this.dXw = parame;
  }
  
  public final void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    t localt = new t();
    localt.field_wallet_region = paramInt;
    localt.field_function_list = paramString1;
    localt.field_new_list = paramString2;
    localt.field_banner_list = paramString3;
    localt.field_type_name_list = paramString4;
    super.a(localt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.e
 * JD-Core Version:    0.7.0.1
 */