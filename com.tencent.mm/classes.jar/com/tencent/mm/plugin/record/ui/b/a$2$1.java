package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Map;

final class a$2$1
  implements n.c
{
  a$2$1(a.2 param2) {}
  
  public final void a(l paraml)
  {
    nb localnb;
    if (a.2.a(this.nuv).sVO == 0)
    {
      if (a.2.b(this.nuv).aPX()) {
        paraml.e(2, a.2.c(this.nuv).getString(R.l.favorite_share_with_friend));
      }
      if (a.2.b(this.nuv).aPY()) {
        paraml.e(1, a.2.c(this.nuv).getString(R.l.favorite_post_to_sns));
      }
      paraml.e(3, a.2.c(this.nuv).getString(R.l.favorite_save_image));
      localnb = (nb)this.nuv.nus.kbT.get(a.2.d(this.nuv));
      if (localnb == null) {
        break label265;
      }
      if (!bk.bl(localnb.bWI.result))
      {
        if (!com.tencent.mm.plugin.scanner.a.wM(localnb.bWI.bIj)) {
          break label172;
        }
        paraml.e(4, a.2.c(this.nuv).getString(R.l.recog_qbar_of_image_file));
      }
    }
    return;
    label172:
    if (com.tencent.mm.plugin.scanner.a.aD(localnb.bWI.bIj, localnb.bWI.result))
    {
      paraml.e(4, a.2.c(this.nuv).getString(R.l.recog_wxcode_of_image_file));
      return;
    }
    if (com.tencent.mm.plugin.scanner.a.wL(localnb.bWI.bIj))
    {
      paraml.e(4, a.2.c(this.nuv).getString(R.l.recog_barcode_of_image_file));
      return;
    }
    paraml.e(4, a.2.c(this.nuv).getString(R.l.recog_qbar_of_image_file));
    return;
    label265:
    paraml = new mz();
    paraml.bWF.filePath = a.2.d(this.nuv);
    com.tencent.mm.sdk.b.a.udP.m(paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.2.1
 * JD-Core Version:    0.7.0.1
 */