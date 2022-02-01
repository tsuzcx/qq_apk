package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public Map<String, e> mPurchaseMap;
  
  d()
  {
    AppMethodBeat.i(71804);
    this.mPurchaseMap = new HashMap();
    AppMethodBeat.o(71804);
  }
  
  d(String paramString, e parame)
  {
    AppMethodBeat.i(71805);
    this.mPurchaseMap = new HashMap();
    this.mPurchaseMap.clear();
    this.mPurchaseMap.put(paramString, parame);
    AppMethodBeat.o(71805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.d
 * JD-Core Version:    0.7.0.1
 */