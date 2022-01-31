package com.tencent.mm.plugin.offline.c;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  implements bi.a
{
  public final void a(e parame)
  {
    if ((parame == null) || (parame.KR() == null)) {
      y.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
    }
    do
    {
      return;
      byte[] arrayOfByte = parame.KR().ks("offline_token");
      if (arrayOfByte != null) {
        a.KB(new String(arrayOfByte));
      }
      arrayOfByte = parame.KR().ks("offline_token_V2");
      if (arrayOfByte != null) {
        a.mNN = new String(arrayOfByte);
      }
      parame = parame.KR().ks("offline_key_list");
    } while (parame == null);
    a.mNQ = new String(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a.4
 * JD-Core Version:    0.7.0.1
 */