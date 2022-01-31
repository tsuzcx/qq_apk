package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.g;

public class BindMobileOrQQHeaderView
  extends LinearLayout
{
  private ImageView heN;
  private TextView mCH;
  private BindMobileOrQQHeaderView.a mCI;
  private View.OnClickListener mCJ = new BindMobileOrQQHeaderView.1(this);
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    this.mCI = BindMobileOrQQHeaderView.a.mCM;
    ca(paramContext);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  private void ca(Context paramContext)
  {
    paramContext = View.inflate(paramContext, b.e.nearby_bindmobile_header_view, this);
    this.mCH = ((TextView)paramContext.findViewById(b.d.nearby_header_text));
    this.heN = ((ImageView)paramContext.findViewById(b.d.nearby_bind_icon));
    switch (BindMobileOrQQHeaderView.2.mCL[this.mCI.ordinal()])
    {
    default: 
      return;
    case 1: 
      setOnClickListener(this.mCJ);
      this.heN.setImageResource(b.g.userguide_bindmb_icon);
      return;
    }
    setOnClickListener(this.mCJ);
    this.heN.setImageResource(b.g.userguide_contacts_icon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */