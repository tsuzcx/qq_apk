package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V", "bitmap", "Landroid/graphics/Bitmap;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImageBitmap", "", "scan-translation_release"})
final class ScanTranslationResultUI$b
  extends BaseAdapter
{
  private Bitmap bitmap;
  
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
    AppMethodBeat.i(120968);
    p.k(paramViewGroup, "viewGroup");
    if (paramView == null)
    {
      paramView = new MultiTouchImageView((Context)this.ISE.getContext(), 0, 0, (byte)0);
      paramView.setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
    }
    for (;;)
    {
      if (this.bitmap != null)
      {
        paramView.setImageBitmap(this.bitmap);
        paramViewGroup = this.bitmap;
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramInt = paramViewGroup.getWidth();
        paramViewGroup = this.bitmap;
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramView.di(paramInt, paramViewGroup.getHeight());
        paramView.hJx();
      }
      paramView = (View)paramView;
      AppMethodBeat.o(120968);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
    }
  }
  
  public final void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120969);
    p.k(paramBitmap, "bitmap");
    this.bitmap = paramBitmap;
    AppMethodBeat.o(120969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.b
 * JD-Core Version:    0.7.0.1
 */