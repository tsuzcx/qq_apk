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
  private Bitmap Kpt;
  private int height;
  private ImageView kc;
  private View.OnClickListener zHh;
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31853);
    this.height = -1;
    setLayoutResource(2131495538);
    AppMethodBeat.o(31853);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31855);
    super.onBindView(paramView);
    if (this.kc == null) {
      this.kc = ((ImageView)paramView.findViewById(2131302570));
    }
    if (this.zHh != null) {
      this.kc.setOnClickListener(this.zHh);
    }
    if (this.Kpt != null)
    {
      this.kc.setImageBitmap(this.Kpt);
      this.Kpt = null;
    }
    paramView = (LinearLayout)paramView.findViewById(2131304721);
    if (this.height != -1) {
      paramView.setMinimumHeight(this.height);
    }
    AppMethodBeat.o(31855);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31854);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495563, localViewGroup);
    this.kc = ((ImageView)paramViewGroup.findViewById(2131302570));
    AppMethodBeat.o(31854);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference
 * JD-Core Version:    0.7.0.1
 */