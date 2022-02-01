package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference
  extends Preference
{
  private TextView Beb;
  private String knP;
  private TextView mPa;
  private String mTitle;
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27015);
    setLayoutResource(2131495538);
    AppMethodBeat.o(27015);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27017);
    this.mPa = ((TextView)paramView.findViewById(2131309195));
    this.Beb = ((TextView)paramView.findViewById(2131304739));
    if (this.mPa != null) {
      this.mPa.setText(this.mTitle);
    }
    if (this.Beb != null) {
      this.Beb.setText(this.knP);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27017);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27016);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495570, localViewGroup);
    AppMethodBeat.o(27016);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMobileInfoPreference
 * JD-Core Version:    0.7.0.1
 */