package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  implements d
{
  private IsoDep wto;
  
  public b(Tag paramTag)
  {
    AppMethodBeat.i(26665);
    if (paramTag == null)
    {
      ad.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
      paramTag = new IllegalStateException("tag is null");
      AppMethodBeat.o(26665);
      throw paramTag;
    }
    this.wto = IsoDep.get(paramTag);
    AppMethodBeat.o(26665);
  }
  
  public final c a(a parama)
  {
    AppMethodBeat.i(26670);
    if (this.wto == null)
    {
      ad.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
      parama = new IllegalStateException("IsoDep is null");
      AppMethodBeat.o(26670);
      throw parama;
    }
    connect();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    c localc;
    for (;;)
    {
      localc = new c(this.wto.transceive(locala.getBytes()));
      localObject = parama;
      if (localc.wsY.length != 0)
      {
        if (localc.wsY.length - 2 <= 0) {
          localObject = localc;
        }
      }
      else
      {
        label92:
        AppMethodBeat.o(26670);
        return localObject;
      }
      if (localc.duv() != 108) {
        break;
      }
      locala.LV(localc.duw());
    }
    if (parama == null) {
      parama = localc;
    }
    for (;;)
    {
      localObject = parama;
      if (localc.duv() != 97) {
        break label92;
      }
      locala = new a((byte[])com.tencent.mm.plugin.nfc.a.b.wtg.clone());
      break;
      parama.a(localc);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(26667);
    if (this.wto.isConnected()) {
      this.wto.close();
    }
    AppMethodBeat.o(26667);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(26666);
    if (!this.wto.isConnected()) {
      this.wto.connect();
    }
    AppMethodBeat.o(26666);
    return true;
  }
  
  public final boolean duz()
  {
    AppMethodBeat.i(26669);
    close();
    connect();
    AppMethodBeat.o(26669);
    return true;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(26668);
    boolean bool = this.wto.isConnected();
    AppMethodBeat.o(26668);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.b
 * JD-Core Version:    0.7.0.1
 */