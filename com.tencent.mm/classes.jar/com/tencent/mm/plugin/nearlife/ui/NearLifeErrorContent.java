package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class NearLifeErrorContent
  extends FrameLayout
{
  private View contentView;
  private ListView fuF;
  private Context mContext;
  private TextView mFH;
  private View mFI;
  
  public NearLifeErrorContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public NearLifeErrorContent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    this.contentView = View.inflate(this.mContext, R.i.near_life_error_content, this);
    this.mFH = ((TextView)this.contentView.findViewById(R.h.near_life_not_found));
    this.mFI = this.contentView.findViewById(R.h.nearby_life_locate_failed);
  }
  
  public void setListView(ListView paramListView)
  {
    this.fuF = paramListView;
  }
  
  public final void vj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mFH.setVisibility(8);
      this.mFI.setVisibility(8);
      this.fuF.setVisibility(0);
      return;
    case 1: 
      this.mFH.setVisibility(0);
      this.mFI.setVisibility(8);
      this.fuF.setVisibility(8);
      return;
    }
    this.mFH.setVisibility(8);
    this.mFI.setVisibility(0);
    this.fuF.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent
 * JD-Core Version:    0.7.0.1
 */