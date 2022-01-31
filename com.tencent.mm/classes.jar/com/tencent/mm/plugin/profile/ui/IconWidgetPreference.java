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
  private ImageView pAP;
  private int pAQ;
  private Bitmap pAR;
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconWidgetPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23643);
    this.pAP = null;
    this.pAQ = -1;
    this.pAR = null;
    setLayoutResource(2130970179);
    setWidgetLayoutResource(0);
    AppMethodBeat.o(23643);
  }
  
  public final void M(Bitmap paramBitmap)
  {
    AppMethodBeat.i(23645);
    this.pAR = paramBitmap;
    if (this.pAP != null) {
      this.pAP.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(23645);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23646);
    super.onBindView(paramView);
    this.pAP = ((ImageView)paramView.findViewById(2131826262));
    if (this.pAP != null)
    {
      this.pAP.setVisibility(8);
      if (this.pAQ != -1)
      {
        this.pAP.setImageResource(this.pAQ);
        this.pAP.setVisibility(0);
        AppMethodBeat.o(23646);
        return;
      }
      if (this.pAR != null)
      {
        this.pAP.setImageBitmap(this.pAR);
        this.pAP.setVisibility(0);
      }
    }
    AppMethodBeat.o(23646);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23644);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970264, localViewGroup);
    AppMethodBeat.o(23644);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.IconWidgetPreference
 * JD-Core Version:    0.7.0.1
 */