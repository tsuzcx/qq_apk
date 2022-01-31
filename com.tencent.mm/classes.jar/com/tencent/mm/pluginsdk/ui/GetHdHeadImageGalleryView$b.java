package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class GetHdHeadImageGalleryView$b
  implements MMGestureGallery.c
{
  private GetHdHeadImageGalleryView$b(GetHdHeadImageGalleryView paramGetHdHeadImageGalleryView) {}
  
  public final void aRg()
  {
    if ((GetHdHeadImageGalleryView.b(this.rZC) != null) && (GetHdHeadImageGalleryView.c(this.rZC) != null))
    {
      String[] arrayOfString = this.rZC.getContext().getResources().getStringArray(a.a.get_hd_head_img_alert);
      h.a(this.rZC.getContext(), null, arrayOfString, "", new h.c()
      {
        public final void gl(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          }
          String str = com.tencent.mm.compatible.util.e.dzD + "hdImg_" + g.o(GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.b.this.rZC).getBytes()) + System.currentTimeMillis() + ".jpg";
          com.tencent.mm.vfs.e.deleteFile(str);
          com.tencent.mm.vfs.e.r(GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.b.this.rZC), str);
          q.a(str, GetHdHeadImageGalleryView.b.this.rZC.getContext());
          Toast.makeText(GetHdHeadImageGalleryView.b.this.rZC.getContext(), GetHdHeadImageGalleryView.b.this.rZC.getContext().getString(a.h.get_hd_head_img_save_tips, new Object[] { com.tencent.mm.compatible.util.e.dzD }), 1).show();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.b
 * JD-Core Version:    0.7.0.1
 */