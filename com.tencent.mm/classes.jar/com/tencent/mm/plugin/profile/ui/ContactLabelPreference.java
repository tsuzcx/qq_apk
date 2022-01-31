package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference
  extends Preference
{
  private MMSingelLinePanel pyK;
  private ArrayList<String> pyL;
  private String title;
  private TextView titleTv;
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23392);
    this.pyL = new ArrayList();
    setLayoutResource(2130970179);
    AppMethodBeat.o(23392);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23394);
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.pyK = ((MMSingelLinePanel)paramView.findViewById(2131820916));
    this.pyK.setSingleLine(true);
    this.pyK.zmn = false;
    this.pyK.qF(false);
    if (this.titleTv != null) {
      this.titleTv.setText(this.title);
    }
    if ((this.pyK != null) && (this.pyL != null) && (this.pyL.size() > 0)) {
      this.pyK.a(this.pyL, this.pyL);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(23394);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23393);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970206, localViewGroup);
    AppMethodBeat.o(23393);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactLabelPreference
 * JD-Core Version:    0.7.0.1
 */