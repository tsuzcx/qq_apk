package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements d
{
  private IsoDep mGn;
  
  public b(Tag paramTag)
  {
    if (paramTag == null)
    {
      y.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
      throw new IllegalStateException("tag is null");
    }
    this.mGn = IsoDep.get(paramTag);
  }
  
  public final c a(a parama)
  {
    if (this.mGn == null)
    {
      y.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
      throw new IllegalStateException("IsoDep is null");
    }
    connect();
    Object localObject = null;
    a locala = parama;
    parama = (a)localObject;
    c localc;
    for (;;)
    {
      localc = new c(this.mGn.transceive(locala.getBytes()));
      localObject = parama;
      if (localc.mFX.length != 0)
      {
        if (localc.mFX.length - 2 <= 0) {
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
      locala = new a((byte[])com.tencent.mm.plugin.nfc.a.b.mGf.clone());
      break;
      parama.a(localc);
    }
  }
  
  public final boolean boz()
  {
    close();
    connect();
    return true;
  }
  
  public final void close()
  {
    if (this.mGn.isConnected()) {
      this.mGn.close();
    }
  }
  
  public final boolean connect()
  {
    if (!this.mGn.isConnected()) {
      this.mGn.connect();
    }
    return true;
  }
  
  public final boolean isConnected()
  {
    return this.mGn.isConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.b
 * JD-Core Version:    0.7.0.1
 */