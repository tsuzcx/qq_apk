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
  private ImageView Bgk;
  private int Bgl;
  private Bitmap Bgm;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27256);
    this.Bgk = null;
    this.Bgl = -1;
    this.Bgm = null;
    setLayoutResource(2131495538);
    setWidgetLayoutResource(0);
    AppMethodBeat.o(27256);
  }
  
  public final void al(Bitmap paramBitmap)
  {
    AppMethodBeat.i(27258);
    this.Bgm = paramBitmap;
    if (this.Bgk != null) {
      this.Bgk.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(27258);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27259);
    super.onBindView(paramView);
    this.Bgk = ((ImageView)paramView.findViewById(2131306090));
    if (this.Bgk != null)
    {
      this.Bgk.setVisibility(8);
      if (this.Bgl != -1)
      {
        this.Bgk.setImageResource(this.Bgl);
        this.Bgk.setVisibility(0);
        AppMethodBeat.o(27259);
        return;
      }
      if (this.Bgm != null)
      {
        this.Bgk.setImageBitmap(this.Bgm);
        this.Bgk.setVisibility(0);
      }
    }
    AppMethodBeat.o(27259);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27257);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495632, localViewGroup);
    AppMethodBeat.o(27257);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.IconWidgetPreference
 * JD-Core Version:    0.7.0.1
 */