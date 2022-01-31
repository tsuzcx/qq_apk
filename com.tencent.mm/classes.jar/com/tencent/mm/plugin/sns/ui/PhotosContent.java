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
  private int bzX;
  public ArrayList<TagImageView> rJU;
  private float rJV;
  
  public PhotosContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38474);
    this.rJU = new ArrayList();
    this.bzX = 120;
    AppMethodBeat.o(38474);
  }
  
  public final TagImageView EJ(int paramInt)
  {
    AppMethodBeat.i(38473);
    if (paramInt < this.rJU.size())
    {
      TagImageView localTagImageView = (TagImageView)this.rJU.get(paramInt);
      AppMethodBeat.o(38473);
      return localTagImageView;
    }
    AppMethodBeat.o(38473);
    return null;
  }
  
  public final void a(TagImageView paramTagImageView)
  {
    AppMethodBeat.i(38471);
    this.rJU.add(paramTagImageView);
    AppMethodBeat.o(38471);
  }
  
  public final void cuo()
  {
    AppMethodBeat.i(38470);
    this.rJU.clear();
    AppMethodBeat.o(38470);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38475);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(38475);
  }
  
  public void setImageViewWidth(int paramInt)
  {
    AppMethodBeat.i(38472);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(38472);
      return;
    }
    this.rJV = getResources().getDisplayMetrics().density;
    this.bzX = ((int)(this.bzX * this.rJV));
    if (paramInt < this.bzX) {}
    Object localObject1;
    for (;;)
    {
      i = 0;
      while (i < this.rJU.size())
      {
        localObject1 = getChildAt(i);
        Object localObject2 = new ViewGroup.MarginLayoutParams(((View)localObject1).getLayoutParams());
        ((ViewGroup.MarginLayoutParams)localObject2).width = paramInt;
        ((ViewGroup.MarginLayoutParams)localObject2).height = paramInt;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)(i % 3 * (paramInt + this.rJV * 3.0F)));
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i / 3 * (paramInt + this.rJV * 3.0F)));
        localObject2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 51;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
      paramInt = this.bzX;
    }
    int i = this.rJU.size() / 3;
    if (i > 0)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)getLayoutParams();
      float f1 = paramInt * i;
      float f2 = this.rJV;
      ((ViewGroup.MarginLayoutParams)localObject1).height = ((int)((i - 1) * (f2 * 3.0F) + f1));
      setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(38472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PhotosContent
 * JD-Core Version:    0.7.0.1
 */