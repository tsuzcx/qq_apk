package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FTSMainUIHotWordLayout
  extends LinearLayout
{
  protected int Aop;
  protected boolean Aoq;
  public FTSMainUIHotWordLayout.b Aor;
  private TextView gpL;
  protected View.OnClickListener mYg;
  protected List<LinearLayout> nbh;
  
  public FTSMainUIHotWordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91590);
    this.nbh = null;
    this.Aop = 2;
    this.Aoq = true;
    this.gpL = null;
    this.Aor = null;
    initView();
    AppMethodBeat.o(91590);
  }
  
  public FTSMainUIHotWordLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91591);
    this.nbh = null;
    this.Aop = 2;
    this.Aoq = true;
    this.gpL = null;
    this.Aor = null;
    initView();
    AppMethodBeat.o(91591);
  }
  
  private void initView()
  {
    AppMethodBeat.i(91592);
    setOrientation(1);
    this.nbh = new ArrayList();
    AppMethodBeat.o(91592);
  }
  
  public String getSearchId()
  {
    if ((this.Aor != null) && (this.Aor.hng != null)) {
      return this.Aor.hng;
    }
    return "";
  }
  
  public void setOnCellClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mYg = paramOnClickListener;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(91593);
    int i;
    if (this.nbh.size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label39;
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      AppMethodBeat.o(91593);
      return;
      i = 0;
      break;
      label39:
      paramInt = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout
 * JD-Core Version:    0.7.0.1
 */