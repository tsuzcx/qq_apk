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
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference
  extends Preference
{
  private Context context;
  private Drawable drawable;
  private int height;
  private String vLt;
  private int xpM;
  int xpN;
  
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
    this.vLt = "";
    this.xpM = -1;
    this.xpN = 8;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(29182);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29184);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131300943);
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      if (this.drawable == null) {
        break label137;
      }
      ((ImageView)localObject).setImageDrawable(this.drawable);
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      paramView = (TextView)paramView.findViewById(2131305745);
      if (paramView != null)
      {
        paramView.setVisibility(this.xpN);
        paramView.setText(this.vLt);
        if (this.xpM != -1) {
          paramView.setBackgroundDrawable(a.l(this.context, this.xpM));
        }
      }
      AppMethodBeat.o(29184);
      return;
      label137:
      if (this.Vu != null)
      {
        ((ImageView)localObject).setImageDrawable(this.Vu);
        ((ImageView)localObject).setVisibility(0);
      }
      else if (this.acJ != 0)
      {
        ((ImageView)localObject).setImageResource(this.acJ);
        ((ImageView)localObject).setVisibility(0);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29183);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494819, localViewGroup);
    localViewGroup.setPadding(0, localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getPaddingBottom());
    AppMethodBeat.o(29183);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendItemPreference
 * JD-Core Version:    0.7.0.1
 */