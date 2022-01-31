package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference
  extends Preference
{
  private Context context;
  private TextView gFS;
  private String sZj;
  String sZk;
  private View.OnClickListener sZl;
  View.OnClickListener sZm;
  private InputPreference.a sZn;
  private TextView sZo;
  private View.OnClickListener sZp;
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddFriendSearchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25495);
    this.sZj = "";
    this.sZk = "";
    this.sZl = null;
    this.sZm = null;
    this.sZn = null;
    this.sZo = null;
    this.gFS = null;
    this.sZp = new AddFriendSearchPreference.1(this);
    this.context = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(25495);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(25497);
    super.onBindView(paramView);
    paramView.setOnTouchListener(new AddFriendSearchPreference.2(this));
    this.sZo = ((TextView)paramView.findViewById(2131820995));
    this.gFS = ((TextView)paramView.findViewById(2131826201));
    this.gFS.setText(this.sZk);
    if (this.sZm != null) {
      this.gFS.setOnTouchListener(new AddFriendSearchPreference.3(this));
    }
    if (this.sZn != null)
    {
      paramView = (Button)paramView.findViewById(2131820875);
      paramView.setOnClickListener(this.sZp);
      paramView.setVisibility(0);
    }
    OW(8);
    AppMethodBeat.o(25497);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25496);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970195, localViewGroup);
    localViewGroup.setPadding(0, localViewGroup.getPaddingTop(), 0, localViewGroup.getPaddingBottom());
    AppMethodBeat.o(25496);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference
 * JD-Core Version:    0.7.0.1
 */