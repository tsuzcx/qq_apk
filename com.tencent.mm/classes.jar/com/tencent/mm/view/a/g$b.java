package com.tencent.mm.view.a;

import android.view.View;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.view.SmileySubGrid;

class g$b
{
  ChatFooterPanel.RecommendView wxf;
  SmileySubGrid wxg;
  
  public g$b(g paramg, View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.wxf = ((ChatFooterPanel.RecommendView)paramView);
      return;
    }
    this.wxg = ((SmileySubGrid)paramView.findViewById(a.e.smiley_panel_grid));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.a.g.b
 * JD-Core Version:    0.7.0.1
 */