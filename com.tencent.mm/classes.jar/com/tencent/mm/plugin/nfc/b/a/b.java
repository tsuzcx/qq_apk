package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  implements d
{
  private IsoDep pgt;
  
  public b(Tag paramTag)
  {
    AppMethodBeat.i(23038);
    if (paramTag == null)
    {
      ab.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
      paramTag = new IllegalStateException("tag is null");
      AppMethodBeat.o(23038);
      throw paramTag;
    }
    this.pgt = IsoDep.get(paramTag);
    AppMethodBeat.o(23038);
  }
  
  public final c a(a parama)
  {
    AppMethodBeat.i(23043);
    if (this.pgt == null)
    {
      ab.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
      parama = new IllegalStateException("IsoDep is null");
      AppMethodBeat.o(23043);
      throw parama;
    }
    connect();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    c localc;
    for (;;)
    {
      localc = new c(this.pgt.transceive(locala.getBytes()));
      localObject = parama;
      if (localc.pgd.length != 0)
      {
        if (localc.pgd.length - 2 <= 0) {
          localObject = localc;
        }
      }
      else
      {
        label92:
        AppMethodBeat.o(23043);
        return localObject;
      }
      if (localc.bWV() != 108) {
        break;
      }
      locala.AI(localc.bWW());
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
      locala = new a((byte[])com.tencent.mm.plugin.nfc.a.b.pgl.clone());
      break;
      parama.a(localc);
    }
  }
  
  public final boolean bWZ()
  {
    AppMethodBeat.i(23042);
    close();
    connect();
    AppMethodBeat.o(23042);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(23040);
    if (this.pgt.isConnected()) {
      this.pgt.close();
    }
    AppMethodBeat.o(23040);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(23039);
    if (!this.pgt.isConnected()) {
      this.pgt.connect();
    }
    AppMethodBeat.o(23039);
    return true;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(23041);
    boolean bool = this.pgt.isConnected();
    AppMethodBeat.o(23041);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.b
 * JD-Core Version:    0.7.0.1
 */