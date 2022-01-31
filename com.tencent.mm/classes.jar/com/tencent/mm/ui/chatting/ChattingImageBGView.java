package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.y;

public class ChattingImageBGView
  extends ImageView
{
  private int hwu = 0;
  private Bitmap kJz;
  
  public ChattingImageBGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public ChattingImageBGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  private void cCP()
  {
    post(new ChattingImageBGView.1(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.hwu != paramInt3 - paramInt1))
    {
      this.hwu = (paramInt3 - paramInt1);
      y.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      cCP();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.kJz = paramBitmap;
    super.setImageBitmap(paramBitmap);
    cCP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingImageBGView
 * JD-Core Version:    0.7.0.1
 */