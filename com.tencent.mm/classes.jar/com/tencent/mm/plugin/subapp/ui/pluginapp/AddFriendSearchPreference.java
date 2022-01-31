package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference
  extends Preference
{
  private Context context;
  private TextView foy = null;
  private TextView pxA = null;
  private View.OnClickListener pxB = new AddFriendSearchPreference.1(this);
  private String pxv = "";
  String pxw = "";
  private View.OnClickListener pxx = null;
  View.OnClickListener pxy = null;
  private InputPreference.a pxz = null;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setLayoutResource(R.i.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView.setOnTouchListener(new AddFriendSearchPreference.2(this));
    this.pxA = ((TextView)paramView.findViewById(R.h.edittext));
    this.foy = ((TextView)paramView.findViewById(R.h.sepical_hint));
    this.foy.setText(this.pxw);
    if (this.pxy != null) {
      this.foy.setOnTouchListener(new AddFriendSearchPreference.3(this));
    }
    if (this.pxz != null)
    {
      paramView = (Button)paramView.findViewById(R.h.button);
      paramView.setOnClickListener(this.pxB);
      paramView.setVisibility(0);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, R.i.mm_preference_content_add_friend_search_item, localViewGroup);
    localViewGroup.setPadding(0, localViewGroup.getPaddingTop(), 0, localViewGroup.getPaddingBottom());
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */