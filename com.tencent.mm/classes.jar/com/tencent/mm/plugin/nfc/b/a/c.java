package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  implements d
{
  private NfcA pgu;
  
  public c(Tag paramTag)
  {
    AppMethodBeat.i(23044);
    this.pgu = NfcA.get(paramTag);
    AppMethodBeat.o(23044);
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(a parama)
  {
    AppMethodBeat.i(23045);
    if (this.pgu == null)
    {
      ab.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
      parama = new IllegalStateException("NfcA is null");
      AppMethodBeat.o(23045);
      throw parama;
    }
    connect();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    com.tencent.mm.plugin.nfc.a.c localc = new com.tencent.mm.plugin.nfc.a.c(this.pgu.transceive(locala.getBytes()));
    localObject = parama;
    if (localc.pgd.length != 0)
    {
      if (localc.pgd.length - 2 >= 0) {
        break label100;
      }
      localObject = localc;
    }
    for (;;)
    {
      label92:
      AppMethodBeat.o(23045);
      return localObject;
      label100:
      if (localc.bWV() == 108)
      {
        locala.AI(localc.bWW());
        break;
      }
      if (parama == null) {
        parama = localc;
      }
      for (;;)
      {
        localObject = parama;
        if (localc.bWV() != 97) {
          break label92;
        }
        if (localc.bWW() == 0) {
          break label174;
        }
        locala = new a((byte[])b.pgl.clone());
        break;
        parama.a(localc);
      }
      label174:
      parama.pgd[(parama.pgd.length - 1)] = -112;
      localObject = parama;
    }
  }
  
  public final boolean bWZ()
  {
    AppMethodBeat.i(23049);
    close();
    connect();
    AppMethodBeat.o(23049);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(23047);
    if (this.pgu.isConnected()) {
      this.pgu.close();
    }
    AppMethodBeat.o(23047);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(23046);
    if (!this.pgu.isConnected()) {
      this.pgu.connect();
    }
    AppMethodBeat.o(23046);
    return true;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(23048);
    boolean bool = this.pgu.isConnected();
    AppMethodBeat.o(23048);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.c
 * JD-Core Version:    0.7.0.1
 */