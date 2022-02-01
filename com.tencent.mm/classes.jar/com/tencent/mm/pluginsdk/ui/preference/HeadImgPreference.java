package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference
  extends Preference
{
  private View.OnClickListener Fms;
  private Bitmap Rqi;
  private ImageView bwJ;
  private int height;
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31853);
    this.height = -1;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(31853);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31855);
    super.onBindView(paramView);
    if (this.bwJ == null) {
      this.bwJ = ((ImageView)paramView.findViewById(R.h.image_headimg));
    }
    if (this.Fms != null) {
      this.bwJ.setOnClickListener(this.Fms);
    }
    if (this.Rqi != null)
    {
      this.bwJ.setImageBitmap(this.Rqi);
      this.Rqi = null;
    }
    paramView = (LinearLayout)paramView.findViewById(R.h.mm_preference_ll_id);
    if (this.height != -1) {
      paramView.setMinimumHeight(this.height);
    }
    AppMethodBeat.o(31855);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31854);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, R.i.eiS, localViewGroup);
    this.bwJ = ((ImageView)paramViewGroup.findViewById(R.h.image_headimg));
    AppMethodBeat.o(31854);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference
 * JD-Core Version:    0.7.0.1
 */