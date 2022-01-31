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
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference
  extends Preference
{
  private Context context;
  private Drawable drawable;
  private int height;
  private String pAS;
  private int qGe;
  int qGf;
  
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
    AppMethodBeat.i(25490);
    this.pAS = "";
    this.qGe = -1;
    this.qGf = 8;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(25490);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(25492);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131822243);
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
      localObject = (LinearLayout)paramView.findViewById(2131822408);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      paramView = (TextView)paramView.findViewById(2131822409);
      if (paramView != null)
      {
        paramView.setVisibility(this.qGf);
        paramView.setText(this.pAS);
        if (this.qGe != -1) {
          paramView.setBackgroundDrawable(a.k(this.context, this.qGe));
        }
      }
      AppMethodBeat.o(25492);
      return;
      label137:
      if (this.la != null)
      {
        ((ImageView)localObject).setImageDrawable(this.la);
        ((ImageView)localObject).setVisibility(0);
      }
      else if (this.UM != 0)
      {
        ((ImageView)localObject).setImageResource(this.UM);
        ((ImageView)localObject).setVisibility(0);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25491);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970194, localViewGroup);
    localViewGroup.setPadding(0, localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getPaddingBottom());
    AppMethodBeat.o(25491);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendItemPreference
 * JD-Core Version:    0.7.0.1
 */