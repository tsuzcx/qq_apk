package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class ab$c$1$1
  implements Runnable
{
  ab$c$1$1(ab.c.1 param1, ImageView paramImageView, String paramString1, Bitmap paramBitmap1, RelativeLayout paramRelativeLayout, String paramString2, Bitmap paramBitmap2) {}
  
  public final void run()
  {
    AppMethodBeat.i(258290);
    if ((this.IHK.getTag() != null) && (this.IHK.getTag().equals(this.UuQ)))
    {
      Log.i("MicroMsg.MusicItemHolder", "setImageBitmap %s %s %s ", new Object[] { Integer.valueOf(this.IHK.hashCode()), this.IHK.getTag(), this.UuQ });
      this.IHK.setImageBitmap(this.PLo);
    }
    if ((this.UuR.getTag() != null) && (this.UuR.getTag().equals(this.UuS)))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.UuU.PHb.Pwc.getContext().getResources(), this.UuT);
      this.UuR.setBackground(localBitmapDrawable);
    }
    AppMethodBeat.o(258290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c.1.1
 * JD-Core Version:    0.7.0.1
 */