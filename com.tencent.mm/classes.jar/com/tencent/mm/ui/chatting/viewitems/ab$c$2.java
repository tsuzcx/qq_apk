package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class ab$c$2
  implements Runnable
{
  ab$c$2(ca paramca, com.tencent.mm.ui.chatting.e.a parama, RelativeLayout paramRelativeLayout, boolean paramBoolean, String paramString1, String paramString2, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(258292);
    final Bitmap localBitmap1 = q.bcR().a(this.iBF.field_imgPath, com.tencent.mm.cb.a.getDensity(this.PHb.Pwc.getContext()), false);
    final Bitmap localBitmap2 = ab.b(this.PHb.Pwc.getContext(), localBitmap1, this.UuR.getHeight(), this.UuR.getWidth(), this.yVS);
    q.bcV().h(this.UuQ, localBitmap1);
    q.bcV().h(this.UuS, localBitmap2);
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233769);
        if ((ab.c.2.this.IHK.getTag() != null) && (ab.c.2.this.IHK.getTag().equals(ab.c.2.this.UuQ)) && (localBitmap1 != null) && (!localBitmap1.isRecycled())) {
          ab.c.2.this.IHK.setImageBitmap(localBitmap1);
        }
        if ((ab.c.2.this.UuR.getTag() != null) && (ab.c.2.this.UuR.getTag().equals(ab.c.2.this.UuS)) && (localBitmap2 != null) && (!localBitmap2.isRecycled()))
        {
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(ab.c.2.this.PHb.Pwc.getContext().getResources(), localBitmap2);
          ab.c.2.this.UuR.setBackground(localBitmapDrawable);
        }
        AppMethodBeat.o(233769);
      }
    });
    AppMethodBeat.o(258292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c.2
 * JD-Core Version:    0.7.0.1
 */