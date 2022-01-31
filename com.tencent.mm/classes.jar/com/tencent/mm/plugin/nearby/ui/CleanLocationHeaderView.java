package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.b.h;

public class CleanLocationHeaderView
  extends LinearLayout
{
  private ImageView heN;
  private TextView mCH;
  
  public CleanLocationHeaderView(Context paramContext)
  {
    super(paramContext);
    ca(paramContext);
  }
  
  public CleanLocationHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  private void ca(Context paramContext)
  {
    paramContext = View.inflate(paramContext, b.e.nearby_bindmobile_header_view, this);
    this.mCH = ((TextView)paramContext.findViewById(b.d.nearby_header_text));
    this.mCH.setSingleLine(false);
    this.heN = ((ImageView)paramContext.findViewById(b.d.nearby_bind_icon));
    this.mCH.setText(b.h.clean_loaction_header_title);
    this.heN.setImageResource(b.g.peoplenearby_icon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView
 * JD-Core Version:    0.7.0.1
 */