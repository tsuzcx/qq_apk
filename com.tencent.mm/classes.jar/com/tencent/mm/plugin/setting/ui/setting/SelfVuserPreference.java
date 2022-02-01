package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference
  extends Preference
{
  Drawable drawable;
  String text;
  private String yEO;
  
  public SelfVuserPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelfVuserPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73979);
    setLayoutResource(2131494804);
    AppMethodBeat.o(73979);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73981);
    super.onBindView(paramView);
    ImageView localImageView = (ImageView)paramView.findViewById(2131300943);
    if (localImageView != null)
    {
      localImageView.setImageDrawable(this.drawable);
      ad.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
      if (!bt.isNullOrNil(this.yEO)) {
        localImageView.setContentDescription(this.yEO);
      }
    }
    paramView = (TextView)paramView.findViewById(2131305744);
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setText(this.text);
    }
    AppMethodBeat.o(73981);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73980);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494883, localViewGroup);
    AppMethodBeat.o(73980);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfVuserPreference
 * JD-Core Version:    0.7.0.1
 */