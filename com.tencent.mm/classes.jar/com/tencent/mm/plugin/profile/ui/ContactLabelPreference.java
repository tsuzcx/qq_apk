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
  private String title;
  private TextView titleTv;
  private MMSingelLinePanel xgm;
  private ArrayList<String> xgn;
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27012);
    this.xgn = new ArrayList();
    setLayoutResource(2131494804);
    AppMethodBeat.o(27012);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27014);
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.xgm = ((MMSingelLinePanel)paramView.findViewById(2131298672));
    this.xgm.setSingleLine(true);
    this.xgm.JIk = false;
    this.xgm.xK(false);
    if (this.titleTv != null) {
      this.titleTv.setText(this.title);
    }
    if ((this.xgm != null) && (this.xgn != null) && (this.xgn.size() > 0)) {
      this.xgm.a(this.xgn, this.xgn);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27014);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27013);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494833, localViewGroup);
    AppMethodBeat.o(27013);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactLabelPreference
 * JD-Core Version:    0.7.0.1
 */