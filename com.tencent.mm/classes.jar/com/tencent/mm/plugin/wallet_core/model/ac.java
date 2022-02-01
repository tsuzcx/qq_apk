package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class ac
{
  public static String TAG = "MicroMsg.WalletIndexPayMenu";
  
  public static void TX(String paramString)
  {
    AppMethodBeat.i(70428);
    g.ajD();
    g.ajC().ajl().set(al.a.IzY, paramString);
    AppMethodBeat.o(70428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */