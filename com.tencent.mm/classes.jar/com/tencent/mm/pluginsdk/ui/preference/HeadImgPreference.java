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
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference
  extends Preference
{
  private Bitmap Ciy;
  private int height;
  private ImageView hg;
  private View.OnClickListener tOp;
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31853);
    this.height = -1;
    setLayoutResource(2131494804);
    AppMethodBeat.o(31853);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31855);
    super.onBindView(paramView);
    if (this.hg == null) {
      this.hg = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.tOp != null) {
      this.hg.setOnClickListener(this.tOp);
    }
    if (this.Ciy != null)
    {
      this.hg.setImageBitmap(this.Ciy);
      this.Ciy = null;
    }
    paramView = (LinearLayout)paramView.findViewById(2131302326);
    if (this.height != -1) {
      paramView.setMinimumHeight(this.height);
    }
    AppMethodBeat.o(31855);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31854);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494828, localViewGroup);
    this.hg = ((ImageView)paramViewGroup.findViewById(2131300940));
    AppMethodBeat.o(31854);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference
 * JD-Core Version:    0.7.0.1
 */