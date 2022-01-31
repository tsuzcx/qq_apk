package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.y;

final class b$d$1
  implements View.OnClickListener
{
  b$d$1(b.d paramd, b paramb) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = this.vop.vol.GZ(((Integer)paramView.getTag()).intValue());
    if (localObject == null) {
      return;
    }
    b localb = this.vop.vol;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_biz_chat_id", localb.voj);
    localIntent.putExtra("key_is_biz_chat", localb.kax);
    if (localObject == null)
    {
      y.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
      return;
    }
    localObject = ((b.c)localObject).bWO;
    if (localObject == null)
    {
      y.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
      return;
    }
    int k = localb.mContext.getResources().getConfiguration().orientation;
    int[] arrayOfInt = new int[2];
    int j;
    int i;
    if (paramView != null)
    {
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      localIntent.addFlags(536870912);
      localIntent.putExtra("img_gallery_msg_id", ((cs)localObject).field_msgId).putExtra("img_gallery_msg_svr_id", ((cs)localObject).field_msgSvrId).putExtra("img_gallery_talker", ((cs)localObject).field_talker).putExtra("img_gallery_chatroom_name", ((cs)localObject).field_talker).putExtra("img_gallery_orientation", k);
      if (paramView != null) {
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
      }
      for (;;)
      {
        d.e(localb.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
        ((Activity)localb.mContext).overridePendingTransition(0, 0);
        return;
        localIntent.putExtra("img_gallery_back_from_grid", true);
      }
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.d.1
 * JD-Core Version:    0.7.0.1
 */