package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class ScanTranslationCaptureUI$a
  extends BaseAdapter
{
  Bitmap bitmap;
  
  private ScanTranslationCaptureUI$a(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
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
    AppMethodBeat.i(138497);
    if (paramView == null)
    {
      paramView = new MultiTouchImageView(this.qAW, 0, 0);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    }
    for (;;)
    {
      if (this.bitmap != null)
      {
        paramView.setImageBitmap(this.bitmap);
        paramView.cb(this.bitmap.getWidth(), this.bitmap.getHeight());
        paramView.dDJ();
      }
      AppMethodBeat.o(138497);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.a
 * JD-Core Version:    0.7.0.1
 */