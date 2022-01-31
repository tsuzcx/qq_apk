package com.tencent.mm.plugin.order.ui.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.wallet_core.ui.c;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, Bitmap paramBitmap, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    if (this.mRi.mRg != null)
    {
      a locala = this.mRi;
      Bitmap localBitmap = this.val$bmp;
      String str = this.mOH.mOW;
      if (locala.mRg != null)
      {
        locala.mRg.gG(str, str);
        locala.mRg.mMn = localBitmap;
        locala.mRg.mMo = localBitmap;
        locala.mRg.cNd();
      }
      this.mRi.mRg.y(paramView, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.4
 * JD-Core Version:    0.7.0.1
 */