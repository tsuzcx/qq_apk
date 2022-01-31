package com.tencent.mm.plugin.nearlife.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class NearPoiHeader
  extends LinearLayout
{
  private TextView gaI;
  private ImageView lZh;
  
  public NearPoiHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public NearPoiHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = View.inflate(paramContext, R.i.near_header_item, this);
    this.lZh = ((ImageView)paramContext.findViewById(R.h.location_icon));
    this.gaI = ((TextView)paramContext.findViewById(R.h.life_item_title));
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.gaI.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearPoiHeader
 * JD-Core Version:    0.7.0.1
 */