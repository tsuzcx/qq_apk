package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements d
{
  private NfcA Gxo;
  
  public c(Tag paramTag)
  {
    AppMethodBeat.i(26671);
    this.Gxo = NfcA.get(paramTag);
    AppMethodBeat.o(26671);
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(a parama)
  {
    AppMethodBeat.i(26672);
    if (this.Gxo == null)
    {
      Log.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
      parama = new IllegalStateException("NfcA is null");
      AppMethodBeat.o(26672);
      throw parama;
    }
    cyb();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    com.tencent.mm.plugin.nfc.a.c localc = new com.tencent.mm.plugin.nfc.a.c(this.Gxo.transceive(locala.getBytes()));
    localObject = parama;
    if (localc.GwX.length != 0)
    {
      if (localc.GwX.length - 2 >= 0) {
        break label100;
      }
      localObject = localc;
    }
    for (;;)
    {
      label92:
      AppMethodBeat.o(26672);
      return localObject;
      label100:
      if (localc.fiW() == 108)
      {
        locala.aau(localc.fiX());
        break;
      }
      if (parama == null) {
        parama = localc;
      }
      for (;;)
      {
        localObject = parama;
        if (localc.fiW() != 97) {
          break label92;
        }
        if (localc.fiX() == 0) {
          break label174;
        }
        locala = new a((byte[])b.Gxf.clone());
        break;
        parama.a(localc);
      }
      label174:
      parama.GwX[(parama.GwX.length - 1)] = -112;
      localObject = parama;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(26674);
    if (this.Gxo.isConnected()) {
      this.Gxo.close();
    }
    AppMethodBeat.o(26674);
  }
  
  public final boolean cyb()
  {
    AppMethodBeat.i(26673);
    if (!this.Gxo.isConnected()) {
      this.Gxo.connect();
    }
    AppMethodBeat.o(26673);
    return true;
  }
  
  public final boolean fjb()
  {
    AppMethodBeat.i(26676);
    close();
    cyb();
    AppMethodBeat.o(26676);
    return true;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(26675);
    boolean bool = this.Gxo.isConnected();
    AppMethodBeat.o(26675);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.c
 * JD-Core Version:    0.7.0.1
 */