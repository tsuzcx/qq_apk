package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference
  extends Preference
{
  private String MPk;
  private int MPl;
  int MPm;
  private Context context;
  private Drawable drawable;
  private int height;
  
  public AddFriendItemPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AddFriendItemPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendItemPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29182);
    this.MPk = "";
    this.MPl = -1;
    this.MPm = 8;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(29182);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29184);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(R.h.image_iv);
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      if (this.drawable == null) {
        break label140;
      }
      ((ImageView)localObject).setImageDrawable(this.drawable);
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)paramView.findViewById(R.h.mm_preference_ll_id);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      paramView = (TextView)paramView.findViewById(R.h.text_tv_one);
      if (paramView != null)
      {
        paramView.setVisibility(this.MPm);
        paramView.setText(this.MPk);
        if (this.MPl != -1) {
          paramView.setBackgroundDrawable(a.m(this.context, this.MPl));
        }
      }
      AppMethodBeat.o(29184);
      return;
      label140:
      if (getIcon() != null)
      {
        ((ImageView)localObject).setImageDrawable(getIcon());
        ((ImageView)localObject).setVisibility(0);
      }
      else if (dqA() != 0)
      {
        ((ImageView)localObject).setImageResource(dqA());
        ((ImageView)localObject).setVisibility(0);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29183);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, R.i.glL, localViewGroup);
    localViewGroup.setPadding(0, localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getPaddingBottom());
    AppMethodBeat.o(29183);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendItemPreference
 * JD-Core Version:    0.7.0.1
 */