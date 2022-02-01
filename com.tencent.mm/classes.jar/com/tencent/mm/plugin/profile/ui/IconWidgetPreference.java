package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference
  extends Preference
{
  private ImageView GZT;
  private int GZU;
  private Bitmap GZV;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27256);
    this.GZT = null;
    this.GZU = -1;
    this.GZV = null;
    setLayoutResource(R.i.mm_preference);
    auN(0);
    AppMethodBeat.o(27256);
  }
  
  public final void ai(Bitmap paramBitmap)
  {
    AppMethodBeat.i(27258);
    this.GZV = paramBitmap;
    if (this.GZT != null) {
      this.GZT.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(27258);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27259);
    super.onBindView(paramView);
    this.GZT = ((ImageView)paramView.findViewById(R.h.dRl));
    if (this.GZT != null)
    {
      this.GZT.setVisibility(8);
      if (this.GZU != -1)
      {
        this.GZT.setImageResource(this.GZU);
        this.GZT.setVisibility(0);
        AppMethodBeat.o(27259);
        return;
      }
      if (this.GZV != null)
      {
        this.GZT.setImageBitmap(this.GZV);
        this.GZT.setVisibility(0);
      }
    }
    AppMethodBeat.o(27259);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27257);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, R.i.ejg, localViewGroup);
    AppMethodBeat.o(27257);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.IconWidgetPreference
 * JD-Core Version:    0.7.0.1
 */