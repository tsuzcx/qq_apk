package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.j.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

final class SnsCommentDetailUI$c
  implements a.b
{
  private int Qev;
  private WeakReference<ImageView> Rqo;
  private int Rqp;
  private int Rqq;
  
  public SnsCommentDetailUI$c(ImageView paramImageView)
  {
    AppMethodBeat.i(308008);
    this.Rqo = new WeakReference(paramImageView);
    paramImageView = paramImageView.getContext();
    this.Qev = a.fromDPToPix(paramImageView, 16);
    this.Rqp = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramImageView, 32.0F);
    this.Rqq = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramImageView, 6.0F);
    AppMethodBeat.o(308008);
  }
  
  public final void g(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(308010);
    try
    {
      Object localObject = this.Rqo;
      if (localObject == null)
      {
        AppMethodBeat.o(308010);
        return;
      }
      localObject = (ImageView)this.Rqo.get();
      if (localObject == null)
      {
        AppMethodBeat.o(308010);
        return;
      }
      if ((paramBoolean) && (paramBitmap != null))
      {
        paramBitmap = new BitmapDrawable(MMApplicationContext.getContext().getResources(), paramBitmap);
        paramBitmap.setBounds(0, 0, this.Qev, this.Qev);
        paramBitmap.setColorFilter(((ImageView)localObject).getResources().getColor(b.c.Link), PorterDuff.Mode.SRC_ATOP);
        ((ImageView)localObject).setImageDrawable(paramBitmap);
        paramBitmap = new LinearLayout.LayoutParams(this.Rqp, this.Rqp);
        paramBitmap.topMargin = this.Rqq;
        int i = (this.Rqp - this.Qev) / 2;
        ((ImageView)localObject).setPadding(i, i, i, i);
        paramBitmap.gravity = 49;
        ((ImageView)localObject).setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(308010);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "onDownloadResult, exp=" + paramBitmap.toString());
      AppMethodBeat.o(308010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.c
 * JD-Core Version:    0.7.0.1
 */