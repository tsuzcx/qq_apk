package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements d
{
  private NfcA wIZ;
  
  public c(Tag paramTag)
  {
    AppMethodBeat.i(26671);
    this.wIZ = NfcA.get(paramTag);
    AppMethodBeat.o(26671);
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(a parama)
  {
    AppMethodBeat.i(26672);
    if (this.wIZ == null)
    {
      ae.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
      parama = new IllegalStateException("NfcA is null");
      AppMethodBeat.o(26672);
      throw parama;
    }
    connect();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    com.tencent.mm.plugin.nfc.a.c localc = new com.tencent.mm.plugin.nfc.a.c(this.wIZ.transceive(locala.getBytes()));
    localObject = parama;
    if (localc.wII.length != 0)
    {
      if (localc.wII.length - 2 >= 0) {
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
      if (localc.dxL() == 108)
      {
        locala.MA(localc.dxM());
        break;
      }
      if (parama == null) {
        parama = localc;
      }
      for (;;)
      {
        localObject = parama;
        if (localc.dxL() != 97) {
          break label92;
        }
        if (localc.dxM() == 0) {
          break label174;
        }
        locala = new a((byte[])b.wIQ.clone());
        break;
        parama.a(localc);
      }
      label174:
      parama.wII[(parama.wII.length - 1)] = -112;
      localObject = parama;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(26674);
    if (this.wIZ.isConnected()) {
      this.wIZ.close();
    }
    AppMethodBeat.o(26674);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(26673);
    if (!this.wIZ.isConnected()) {
      this.wIZ.connect();
    }
    AppMethodBeat.o(26673);
    return true;
  }
  
  public final boolean dxP()
  {
    AppMethodBeat.i(26676);
    close();
    connect();
    AppMethodBeat.o(26676);
    return true;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(26675);
    boolean bool = this.wIZ.isConnected();
    AppMethodBeat.o(26675);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.c
 * JD-Core Version:    0.7.0.1
 */