package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class GetHdHeadImageGalleryView
  extends MMGestureGallery
{
  private String qGn;
  private String username;
  private Bitmap vQA;
  private Bitmap vQB;
  private GetHdHeadImageGalleryView.a vQC;
  private o vQz;
  
  public GetHdHeadImageGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79687);
    init();
    AppMethodBeat.o(79687);
  }
  
  public GetHdHeadImageGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79686);
    init();
    AppMethodBeat.o(79686);
  }
  
  private void init()
  {
    AppMethodBeat.i(79688);
    this.vQC = new GetHdHeadImageGalleryView.a(this, (byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.vQC);
    setSelection(0);
    setSingleClickOverListener(new GetHdHeadImageGalleryView.c(this, (byte)0));
    setLongClickOverListener(new GetHdHeadImageGalleryView.b(this, (byte)0));
    AppMethodBeat.o(79688);
  }
  
  public void setHdHeadImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(79690);
    this.vQB = paramBitmap;
    this.vQC.notifyDataSetChanged();
    AppMethodBeat.o(79690);
  }
  
  public void setHdHeadImagePath(String paramString)
  {
    this.qGn = paramString;
  }
  
  public void setParentWindow(o paramo)
  {
    this.vQz = paramo;
  }
  
  public void setThumbImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(79689);
    this.vQA = paramBitmap;
    this.vQC.notifyDataSetChanged();
    AppMethodBeat.o(79689);
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  final class a$a
  {
    ImageView cxy;
    ProgressBar rRL;
    View vQE;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView
 * JD-Core Version:    0.7.0.1
 */