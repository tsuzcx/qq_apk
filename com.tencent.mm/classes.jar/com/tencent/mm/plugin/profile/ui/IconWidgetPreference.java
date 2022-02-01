package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference
  extends Preference
{
  private int wSA;
  private Bitmap wSB;
  private ImageView wSz;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27256);
    this.wSz = null;
    this.wSA = -1;
    this.wSB = null;
    setLayoutResource(2131494804);
    setWidgetLayoutResource(0);
    AppMethodBeat.o(27256);
  }
  
  public final void Z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(27258);
    this.wSB = paramBitmap;
    if (this.wSz != null) {
      this.wSz.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(27258);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27259);
    super.onBindView(paramView);
    this.wSz = ((ImageView)paramView.findViewById(2131303377));
    if (this.wSz != null)
    {
      this.wSz.setVisibility(8);
      if (this.wSA != -1)
      {
        this.wSz.setImageResource(this.wSA);
        this.wSz.setVisibility(0);
        AppMethodBeat.o(27259);
        return;
      }
      if (this.wSB != null)
      {
        this.wSz.setImageBitmap(this.wSB);
        this.wSz.setVisibility(0);
      }
    }
    AppMethodBeat.o(27259);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27257);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494894, localViewGroup);
    AppMethodBeat.o(27257);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.IconWidgetPreference
 * JD-Core Version:    0.7.0.1
 */