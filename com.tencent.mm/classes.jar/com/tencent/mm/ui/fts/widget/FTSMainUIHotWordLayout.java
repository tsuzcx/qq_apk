package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class FTSMainUIHotWordLayout
  extends LinearLayout
{
  private TextView eXO = null;
  protected View.OnClickListener kCk;
  protected List<LinearLayout> kEJ = null;
  protected int vWh = 2;
  protected boolean vWi = true;
  public FTSMainUIHotWordLayout.b vWj = null;
  
  public FTSMainUIHotWordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public FTSMainUIHotWordLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    setOrientation(1);
    this.kEJ = new ArrayList();
  }
  
  public String getSearchId()
  {
    if ((this.vWj != null) && (this.vWj.fTF != null)) {
      return this.vWj.fTF;
    }
    return "";
  }
  
  public void setOnCellClickListener(View.OnClickListener paramOnClickListener)
  {
    this.kCk = paramOnClickListener;
  }
  
  public void setVisibility(int paramInt)
  {
    int i;
    if (this.kEJ.size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label29;
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      i = 0;
      break;
      label29:
      paramInt = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout
 * JD-Core Version:    0.7.0.1
 */