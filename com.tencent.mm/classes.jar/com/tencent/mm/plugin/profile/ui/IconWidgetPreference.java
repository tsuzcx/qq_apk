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
  private ImageView xiq;
  private int xir;
  private Bitmap xis;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27256);
    this.xiq = null;
    this.xir = -1;
    this.xis = null;
    setLayoutResource(2131494804);
    setWidgetLayoutResource(0);
    AppMethodBeat.o(27256);
  }
  
  public final void aa(Bitmap paramBitmap)
  {
    AppMethodBeat.i(27258);
    this.xis = paramBitmap;
    if (this.xiq != null) {
      this.xiq.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(27258);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27259);
    super.onBindView(paramView);
    this.xiq = ((ImageView)paramView.findViewById(2131303377));
    if (this.xiq != null)
    {
      this.xiq.setVisibility(8);
      if (this.xir != -1)
      {
        this.xiq.setImageResource(this.xir);
        this.xiq.setVisibility(0);
        AppMethodBeat.o(27259);
        return;
      }
      if (this.xis != null)
      {
        this.xiq.setImageBitmap(this.xis);
        this.xiq.setVisibility(0);
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