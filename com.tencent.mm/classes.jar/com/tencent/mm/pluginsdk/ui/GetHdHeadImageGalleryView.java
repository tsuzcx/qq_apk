package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class GetHdHeadImageGalleryView
  extends MMGestureGallery
{
  private String nSp;
  private Bitmap rZA;
  private GetHdHeadImageGalleryView.a rZB;
  private o rZy;
  private Bitmap rZz;
  private String username;
  
  public GetHdHeadImageGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GetHdHeadImageGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.rZB = new GetHdHeadImageGalleryView.a(this, (byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.rZB);
    setSelection(0);
    setSingleClickOverListener(new GetHdHeadImageGalleryView.c(this, (byte)0));
    setLongClickOverListener(new GetHdHeadImageGalleryView.b(this, (byte)0));
  }
  
  public void setHdHeadImage(Bitmap paramBitmap)
  {
    this.rZA = paramBitmap;
    this.rZB.notifyDataSetChanged();
  }
  
  public void setHdHeadImagePath(String paramString)
  {
    this.nSp = paramString;
  }
  
  public void setParentWindow(o paramo)
  {
    this.rZy = paramo;
  }
  
  public void setThumbImage(Bitmap paramBitmap)
  {
    this.rZz = paramBitmap;
    this.rZB.notifyDataSetChanged();
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView
 * JD-Core Version:    0.7.0.1
 */