package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements d
{
  private IsoDep Mtn;
  
  public b(Tag paramTag)
  {
    AppMethodBeat.i(26665);
    if (paramTag == null)
    {
      Log.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
      paramTag = new IllegalStateException("tag is null");
      AppMethodBeat.o(26665);
      throw paramTag;
    }
    this.Mtn = IsoDep.get(paramTag);
    AppMethodBeat.o(26665);
  }
  
  public final c a(a parama)
  {
    AppMethodBeat.i(26670);
    if (this.Mtn == null)
    {
      Log.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
      parama = new IllegalStateException("IsoDep is null");
      AppMethodBeat.o(26670);
      throw parama;
    }
    cmB();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    c localc;
    for (;;)
    {
      localc = new c(this.Mtn.transceive(locala.getBytes()));
      localObject = parama;
      if (localc.MsX.length != 0)
      {
        if (localc.MsX.length - 2 <= 0) {
          localObject = localc;
        }
      }
      else
      {
        label92:
        AppMethodBeat.o(26670);
        return localObject;
      }
      if (localc.gtn() != 108) {
        break;
      }
      locala.aeN(localc.gto());
    }
    if (parama == null) {
      parama = localc;
    }
    for (;;)
    {
      localObject = parama;
      if (localc.gtn() != 97) {
        break label92;
      }
      locala = new a((byte[])com.tencent.mm.plugin.nfc.a.b.Mtf.clone());
      break;
      parama.a(localc);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(26667);
    if (this.Mtn.isConnected()) {
      this.Mtn.close();
    }
    AppMethodBeat.o(26667);
  }
  
  public final boolean cmB()
  {
    AppMethodBeat.i(26666);
    if (!this.Mtn.isConnected()) {
      this.Mtn.connect();
    }
    AppMethodBeat.o(26666);
    return true;
  }
  
  public final boolean gtr()
  {
    AppMethodBeat.i(26669);
    close();
    cmB();
    AppMethodBeat.o(26669);
    return true;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(26668);
    boolean bool = this.Mtn.isConnected();
    AppMethodBeat.o(26668);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.b
 * JD-Core Version:    0.7.0.1
 */