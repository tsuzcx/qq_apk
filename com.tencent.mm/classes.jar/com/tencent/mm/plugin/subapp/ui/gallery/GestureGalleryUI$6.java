package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class GestureGalleryUI$6
  implements n.d
{
  GestureGalleryUI$6(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      if (bk.bl(GestureGalleryUI.c(this.pwN)))
      {
        y.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
        return;
      }
      if (o.Za(GestureGalleryUI.c(this.pwN)))
      {
        paramMenuItem = com.tencent.mm.vfs.e.aeY(GestureGalleryUI.c(this.pwN));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramMenuItem);
        if (paramMenuItem != null) {
          break label645;
        }
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Au(GestureGalleryUI.c(this.pwN));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramMenuItem);
      }
      break;
    }
    label640:
    label645:
    for (;;)
    {
      long l;
      label158:
      Object localObject;
      if (paramMenuItem == null)
      {
        l = 0L;
        if (paramMenuItem != null) {
          break label282;
        }
        localObject = GestureGalleryUI.c(this.pwN);
        label171:
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((com.tencent.mm.sdk.platformtools.c.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.m.b.Ag())) && (localOptions.outWidth <= com.tencent.mm.m.b.Ag())) {
          break label640;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((l > com.tencent.mm.m.b.Ah()) || (paramInt != 0))
        {
          h.a(this.pwN.mController.uMN, this.pwN.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", this.pwN.getString(R.l.i_know_it), null);
          return;
          l = com.tencent.mm.vfs.e.aeQ(paramMenuItem.cwL());
          break label158;
          label282:
          localObject = paramMenuItem.cwL();
          break label171;
        }
        localObject = new Intent();
        if (paramMenuItem == null) {}
        for (paramMenuItem = "";; paramMenuItem = paramMenuItem.Wv())
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.plugin.subapp.b.eUR.l((Intent)localObject, this.pwN.mController.uMN);
          return;
        }
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_File_Name", GestureGalleryUI.c(this.pwN));
        paramMenuItem.putExtra("Retr_Compress_Type", 0);
        paramMenuItem.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.subapp.b.eUR.l(paramMenuItem, this.pwN.mController.uMN);
        return;
        if ((GestureGalleryUI.c(this.pwN) == null) || (GestureGalleryUI.c(this.pwN).equals(""))) {
          break;
        }
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this.pwN);
          return;
        }
        l.i(GestureGalleryUI.c(this.pwN), this.pwN);
        return;
        paramMenuItem = new cj();
        com.tencent.mm.pluginsdk.model.e.a(paramMenuItem, 1, GestureGalleryUI.c(this.pwN));
        paramMenuItem.bIw.activity = this.pwN;
        paramMenuItem.bIw.bID = 32;
        a.udP.m(paramMenuItem);
        return;
        y.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
        paramMenuItem = new cd();
        paramMenuItem.bIi.activity = this.pwN;
        paramMenuItem.bIi.bGE = GestureGalleryUI.f(this.pwN);
        paramMenuItem.bIi.bIj = GestureGalleryUI.e(this.pwN);
        paramMenuItem.bIi.bIk = GestureGalleryUI.i(this.pwN);
        paramMenuItem.bIi.scene = GestureGalleryUI.j(this.pwN);
        paramMenuItem.bIi.bIo = this.pwN.getIntent().getBundleExtra("_stat_obj");
        a.udP.m(paramMenuItem);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */