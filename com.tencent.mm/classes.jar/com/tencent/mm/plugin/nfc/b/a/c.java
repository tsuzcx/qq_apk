package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements d
{
  private NfcA mGo;
  
  public c(Tag paramTag)
  {
    this.mGo = NfcA.get(paramTag);
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(a parama)
  {
    if (this.mGo == null)
    {
      y.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
      throw new IllegalStateException("NfcA is null");
    }
    connect();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    com.tencent.mm.plugin.nfc.a.c localc;
    for (;;)
    {
      localc = new com.tencent.mm.plugin.nfc.a.c(this.mGo.transceive(locala.getBytes()));
      localObject = parama;
      if (localc.mFX.length != 0)
      {
        if (localc.mFX.length - 2 < 0) {
          localObject = localc;
        }
      }
      else {
        label78:
        return localObject;
      }
      if (localc.bow() != 108) {
        break;
      }
      locala.vk(localc.box());
    }
    if (parama == null) {
      parama = localc;
    }
    for (;;)
    {
      localObject = parama;
      if (localc.bow() != 97) {
        break label78;
      }
      if (localc.box() == 0) {
        break label154;
      }
      locala = new a((byte[])b.mGf.clone());
      break;
      parama.a(localc);
    }
    label154:
    parama.mFX[(parama.mFX.length - 1)] = -112;
    return parama;
  }
  
  public final boolean boz()
  {
    close();
    connect();
    return true;
  }
  
  public final void close()
  {
    if (this.mGo.isConnected()) {
      this.mGo.close();
    }
  }
  
  public final boolean connect()
  {
    if (!this.mGo.isConnected()) {
      this.mGo.connect();
    }
    return true;
  }
  
  public final boolean isConnected()
  {
    return this.mGo.isConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.c
 * JD-Core Version:    0.7.0.1
 */