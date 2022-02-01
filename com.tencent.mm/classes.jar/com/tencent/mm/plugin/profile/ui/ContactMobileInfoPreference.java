package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference
  extends Preference
{
  private TextView MWa;
  private String mTitle;
  private String qcQ;
  private TextView sUt;
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27015);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27015);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27017);
    this.sUt = ((TextView)paramView.findViewById(R.h.title));
    this.MWa = ((TextView)paramView.findViewById(R.h.mobile));
    if (this.sUt != null) {
      this.sUt.setText(this.mTitle);
    }
    if (this.MWa != null) {
      this.MWa.setText(this.qcQ);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27017);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27016);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.glU, localViewGroup);
    AppMethodBeat.o(27016);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMobileInfoPreference
 * JD-Core Version:    0.7.0.1
 */