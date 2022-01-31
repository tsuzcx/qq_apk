package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent
  extends MMFrameLayout
{
  private int gaT = 120;
  public ArrayList<TagImageView> oSb = new ArrayList();
  private float oSc;
  
  public PhotosContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(TagImageView paramTagImageView)
  {
    this.oSb.add(paramTagImageView);
  }
  
  public final void bHX()
  {
    this.oSb.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setImageViewWidth(int paramInt)
  {
    if (paramInt <= 0) {}
    int i;
    do
    {
      return;
      this.oSc = getResources().getDisplayMetrics().density;
      this.gaT = ((int)(this.gaT * this.oSc));
      if (paramInt < this.gaT) {}
      for (;;)
      {
        i = 0;
        while (i < this.oSb.size())
        {
          localObject1 = getChildAt(i);
          Object localObject2 = new ViewGroup.MarginLayoutParams(((View)localObject1).getLayoutParams());
          ((ViewGroup.MarginLayoutParams)localObject2).width = paramInt;
          ((ViewGroup.MarginLayoutParams)localObject2).height = paramInt;
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)(i % 3 * (paramInt + this.oSc * 3.0F)));
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i / 3 * (paramInt + this.oSc * 3.0F)));
          localObject2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
          ((FrameLayout.LayoutParams)localObject2).gravity = 51;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          i += 1;
        }
        paramInt = this.gaT;
      }
      i = this.oSb.size() / 3;
    } while (i <= 0);
    Object localObject1 = (ViewGroup.MarginLayoutParams)getLayoutParams();
    float f1 = paramInt * i;
    float f2 = this.oSc;
    ((ViewGroup.MarginLayoutParams)localObject1).height = ((int)((i - 1) * (f2 * 3.0F) + f1));
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  public final TagImageView yD(int paramInt)
  {
    if (paramInt < this.oSb.size()) {
      return (TagImageView)this.oSb.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.PhotosContent
 * JD-Core Version:    0.7.0.1
 */