package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent
  extends MMFrameLayout
{
  public ArrayList<TagImageView> RhU;
  private float RhV;
  private int ekE;
  
  public PhotosContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98153);
    this.RhU = new ArrayList();
    this.ekE = 120;
    AppMethodBeat.o(98153);
  }
  
  public final void a(TagImageView paramTagImageView)
  {
    AppMethodBeat.i(98150);
    this.RhU.add(paramTagImageView);
    AppMethodBeat.o(98150);
  }
  
  public final TagImageView alP(int paramInt)
  {
    AppMethodBeat.i(98152);
    if (paramInt < this.RhU.size())
    {
      TagImageView localTagImageView = (TagImageView)this.RhU.get(paramInt);
      AppMethodBeat.o(98152);
      return localTagImageView;
    }
    AppMethodBeat.o(98152);
    return null;
  }
  
  public final void hnc()
  {
    AppMethodBeat.i(98149);
    this.RhU.clear();
    AppMethodBeat.o(98149);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98154);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(98154);
  }
  
  public void setImageViewWidth(int paramInt)
  {
    AppMethodBeat.i(98151);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(98151);
      return;
    }
    this.RhV = getResources().getDisplayMetrics().density;
    this.ekE = ((int)(this.ekE * this.RhV));
    if (paramInt < this.ekE) {}
    Object localObject1;
    for (;;)
    {
      i = 0;
      while (i < this.RhU.size())
      {
        localObject1 = getChildAt(i);
        Object localObject2 = new ViewGroup.MarginLayoutParams(((View)localObject1).getLayoutParams());
        ((ViewGroup.MarginLayoutParams)localObject2).width = paramInt;
        ((ViewGroup.MarginLayoutParams)localObject2).height = paramInt;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)(i % 3 * (paramInt + this.RhV * 3.0F)));
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i / 3 * (paramInt + this.RhV * 3.0F)));
        localObject2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 51;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
      paramInt = this.ekE;
    }
    int i = this.RhU.size() / 3;
    if (i > 0)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)getLayoutParams();
      float f1 = paramInt * i;
      float f2 = this.RhV;
      ((ViewGroup.MarginLayoutParams)localObject1).height = ((int)((i - 1) * (f2 * 3.0F) + f1));
      setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(98151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PhotosContent
 * JD-Core Version:    0.7.0.1
 */