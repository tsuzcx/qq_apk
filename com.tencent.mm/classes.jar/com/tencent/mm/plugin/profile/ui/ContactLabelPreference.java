package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference
  extends Preference
{
  private TextView eXr;
  private MMSingelLinePanel mVR;
  private ArrayList<String> mVS = new ArrayList();
  private String title;
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ContactLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    this.eXr = ((TextView)paramView.findViewById(R.h.title));
    this.mVR = ((MMSingelLinePanel)paramView.findViewById(R.h.contact_label_panel));
    this.mVR.setSingleLine(true);
    this.mVR.uXW = false;
    this.mVR.nc(false);
    if (this.eXr != null) {
      this.eXr.setText(this.title);
    }
    if ((this.mVR != null) && (this.mVS != null) && (this.mVS.size() > 0)) {
      this.mVR.a(this.mVS, this.mVS);
    }
    super.onBindView(paramView);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_label_info, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactLabelPreference
 * JD-Core Version:    0.7.0.1
 */