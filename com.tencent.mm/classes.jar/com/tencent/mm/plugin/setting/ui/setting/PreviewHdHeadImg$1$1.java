package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vfs.e;

final class PreviewHdHeadImg$1$1
  implements n.c
{
  PreviewHdHeadImg$1$1(PreviewHdHeadImg.1 param1) {}
  
  public final void a(l paraml)
  {
    paraml.fq(1, a.i.settings_avatar_select_from_album);
    Bitmap localBitmap = b.a(PreviewHdHeadImg.a(this.nSr.nSq), true, -1);
    o.JQ();
    if (e.bK(d.A(q.Gj() + ".last", true))) {
      paraml.fq(3, a.i.settings_see_last_avatar);
    }
    if (localBitmap != null) {
      paraml.fq(2, a.i.get_hd_head_img_save_alert);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1.1
 * JD-Core Version:    0.7.0.1
 */