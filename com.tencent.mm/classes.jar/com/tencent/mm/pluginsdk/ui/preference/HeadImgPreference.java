package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference
  extends Preference
{
  private int height = -1;
  private ImageView hic;
  public View.OnClickListener nXW;
  private Bitmap sit;
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
  }
  
  public final void R(Bitmap paramBitmap)
  {
    this.sit = null;
    if (this.hic != null)
    {
      this.hic.setImageBitmap(paramBitmap);
      return;
    }
    this.sit = paramBitmap;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.hic == null) {
      this.hic = ((ImageView)paramView.findViewById(R.h.image_headimg));
    }
    if (this.nXW != null) {
      this.hic.setOnClickListener(this.nXW);
    }
    if (this.sit != null)
    {
      this.hic.setImageBitmap(this.sit);
      this.sit = null;
    }
    paramView = (LinearLayout)paramView.findViewById(R.h.mm_preference_ll_id);
    if (this.height != -1) {
      paramView.setMinimumHeight(this.height);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, R.i.mm_preference_content_headimg, localViewGroup);
    this.hic = ((ImageView)paramViewGroup.findViewById(R.h.image_headimg));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference
 * JD-Core Version:    0.7.0.1
 */