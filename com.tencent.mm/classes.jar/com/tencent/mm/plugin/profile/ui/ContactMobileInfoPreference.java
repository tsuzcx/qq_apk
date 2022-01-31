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
  private String gFX;
  private TextView iJG;
  private String mTitle;
  private TextView pyM;
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23395);
    setLayoutResource(2130970179);
    AppMethodBeat.o(23395);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23397);
    this.iJG = ((TextView)paramView.findViewById(2131820680));
    this.pyM = ((TextView)paramView.findViewById(2131820794));
    if (this.iJG != null) {
      this.iJG.setText(this.mTitle);
    }
    if (this.pyM != null) {
      this.pyM.setText(this.gFX);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(23397);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23396);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970208, localViewGroup);
    AppMethodBeat.o(23396);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMobileInfoPreference
 * JD-Core Version:    0.7.0.1
 */