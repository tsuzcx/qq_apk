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
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference
  extends Preference
{
  private MMSingelLinePanel MVY;
  private ArrayList<String> MVZ;
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
    this.MVZ = new ArrayList();
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27012);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27014);
    this.titleTv = ((TextView)paramView.findViewById(R.h.title));
    this.MVY = ((MMSingelLinePanel)paramView.findViewById(R.h.contact_label_panel));
    this.MVY.setSingleLine(true);
    this.MVY.jmI();
    this.MVY.LD(false);
    if (this.titleTv != null) {
      this.titleTv.setText(this.title);
    }
    if ((this.MVY != null) && (this.MVZ != null) && (this.MVZ.size() > 0)) {
      this.MVY.a(this.MVZ, this.MVZ);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27014);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27013);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.glT, localViewGroup);
    AppMethodBeat.o(27013);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactLabelPreference
 * JD-Core Version:    0.7.0.1
 */