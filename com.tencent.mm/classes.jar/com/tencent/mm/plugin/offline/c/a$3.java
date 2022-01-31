package com.tencent.mm.plugin.offline.c;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class a$3
  implements bi.a
{
  public final void a(e parame)
  {
    if ((parame == null) || (parame.KR() == null)) {}
    do
    {
      return;
      if (a.access$000() != null) {
        parame.KR().i("offline_token", a.access$000().getBytes());
      }
      if (a.mNN != null) {
        parame.KR().i("offline_token_V2", a.mNN.getBytes());
      }
    } while (a.mNQ == null);
    parame.KR().i("offline_key_list", a.mNQ.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a.3
 * JD-Core Version:    0.7.0.1
 */