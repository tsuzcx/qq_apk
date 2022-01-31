package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class TranslationResultUI$a
  extends BaseAdapter
{
  Bitmap bitmap;
  
  private TranslationResultUI$a(TranslationResultUI paramTranslationResultUI) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(138652);
    if (TranslationResultUI.f(this.zOm) == null)
    {
      TranslationResultUI.a(this.zOm, new MultiTouchImageView(this.zOm, 0, 0));
      TranslationResultUI.f(this.zOm).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      TranslationResultUI.f(this.zOm).dDJ();
    }
    if (this.bitmap != null)
    {
      TranslationResultUI.f(this.zOm).setImageBitmap(this.bitmap);
      TranslationResultUI.f(this.zOm).cb(this.bitmap.getWidth(), this.bitmap.getHeight());
    }
    paramView = TranslationResultUI.f(this.zOm);
    AppMethodBeat.o(138652);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI.a
 * JD-Core Version:    0.7.0.1
 */