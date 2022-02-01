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
  private MMSingelLinePanel BdZ;
  private ArrayList<String> Bea;
  private String title;
  private TextView titleTv;
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27012);
    this.Bea = new ArrayList();
    setLayoutResource(2131495538);
    AppMethodBeat.o(27012);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27014);
    this.titleTv = ((TextView)paramView.findViewById(2131309195));
    this.BdZ = ((MMSingelLinePanel)paramView.findViewById(2131299109));
    this.BdZ.setSingleLine(true);
    this.BdZ.OTd = false;
    this.BdZ.Bz(false);
    if (this.titleTv != null) {
      this.titleTv.setText(this.title);
    }
    if ((this.BdZ != null) && (this.Bea != null) && (this.Bea.size() > 0)) {
      this.BdZ.a(this.Bea, this.Bea);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27014);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27013);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495568, localViewGroup);
    AppMethodBeat.o(27013);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactLabelPreference
 * JD-Core Version:    0.7.0.1
 */