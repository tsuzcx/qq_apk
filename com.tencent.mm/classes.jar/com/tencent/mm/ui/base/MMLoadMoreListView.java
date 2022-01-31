package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;

public class MMLoadMoreListView
  extends ListView
{
  public View jcy = null;
  private TextView uWA;
  private boolean uWB = false;
  private MMLoadMoreListView.a uWy = null;
  private boolean uWz = false;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (this.jcy == null)
    {
      cAN();
      addFooterView(this.jcy);
      this.jcy.setVisibility(8);
    }
  }
  
  public final void cAN()
  {
    this.jcy = View.inflate(getContext(), a.h.mm_footerview, null);
    this.uWA = ((TextView)this.jcy.findViewById(a.g.footer_tips));
    this.jcy.setVisibility(8);
  }
  
  public final void cAO()
  {
    this.uWz = true;
    setOnScrollListener(new MMLoadMoreListView.1(this));
  }
  
  public final void cAP()
  {
    if (this.jcy != null)
    {
      this.uWA.setVisibility(8);
      this.jcy.setVisibility(8);
    }
  }
  
  public final void cAQ()
  {
    this.uWA.setVisibility(0);
    this.jcy.setVisibility(0);
  }
  
  public boolean getScroll2Top()
  {
    return this.uWB;
  }
  
  public void setFooterTips(String paramString)
  {
    this.uWA.setText(paramString);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    this.uWA.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnLoadMoreListener(MMLoadMoreListView.a parama)
  {
    this.uWy = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView
 * JD-Core Version:    0.7.0.1
 */