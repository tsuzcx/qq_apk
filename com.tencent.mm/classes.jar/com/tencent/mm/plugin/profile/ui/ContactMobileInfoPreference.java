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
  private String jpF;
  private TextView lHk;
  private String mTitle;
  private TextView xgo;
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactMobileInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27015);
    setLayoutResource(2131494804);
    AppMethodBeat.o(27015);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27017);
    this.lHk = ((TextView)paramView.findViewById(2131305902));
    this.xgo = ((TextView)paramView.findViewById(2131302344));
    if (this.lHk != null) {
      this.lHk.setText(this.mTitle);
    }
    if (this.xgo != null) {
      this.xgo.setText(this.jpF);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27017);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27016);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494835, localViewGroup);
    AppMethodBeat.o(27016);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMobileInfoPreference
 * JD-Core Version:    0.7.0.1
 */