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
  private ImageView MXY;
  private int MXZ;
  private Bitmap MYa;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27256);
    this.MXY = null;
    this.MXZ = -1;
    this.MYa = null;
    setLayoutResource(R.i.mm_preference);
    aBp(0);
    AppMethodBeat.o(27256);
  }
  
  public final void av(Bitmap paramBitmap)
  {
    AppMethodBeat.i(27258);
    this.MYa = paramBitmap;
    if (this.MXY != null) {
      this.MXY.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(27258);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27259);
    super.onBindView(paramView);
    this.MXY = ((ImageView)paramView.findViewById(R.h.fTo));
    if (this.MXY != null)
    {
      this.MXY.setVisibility(8);
      if (this.MXZ != -1)
      {
        this.MXY.setImageResource(this.MXZ);
        this.MXY.setVisibility(0);
        AppMethodBeat.o(27259);
        return;
      }
      if (this.MYa != null)
      {
        this.MXY.setImageBitmap(this.MYa);
        this.MXY.setVisibility(0);
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
    View.inflate(this.mContext, R.i.gmh, localViewGroup);
    AppMethodBeat.o(27257);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.IconWidgetPreference
 * JD-Core Version:    0.7.0.1
 */