package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference
  extends Preference
{
  Drawable drawable;
  private String qGE;
  String text;
  
  public SelfVuserPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelfVuserPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127040);
    setLayoutResource(2130970179);
    AppMethodBeat.o(127040);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(127042);
    super.onBindView(paramView);
    ImageView localImageView = (ImageView)paramView.findViewById(2131822243);
    if (localImageView != null)
    {
      localImageView.setImageDrawable(this.drawable);
      ab.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
      if (!bo.isNullOrNil(this.qGE)) {
        localImageView.setContentDescription(this.qGE);
      }
    }
    paramView = (TextView)paramView.findViewById(2131821551);
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.setText(this.text);
    }
    AppMethodBeat.o(127042);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127041);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970253, localViewGroup);
    AppMethodBeat.o(127041);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfVuserPreference
 * JD-Core Version:    0.7.0.1
 */