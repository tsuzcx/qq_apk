package com.tencent.mm.view.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.view.SmileySubGrid;

class i$c
{
  ChatFooterPanel.RecommendView ASt;
  SmileySubGrid ASu;
  
  public i$c(i parami, View paramView, int paramInt)
  {
    AppMethodBeat.i(63000);
    switch (paramInt)
    {
    default: 
      this.ASu = ((SmileySubGrid)paramView.findViewById(2131821545));
      AppMethodBeat.o(63000);
      return;
    }
    this.ASt = ((ChatFooterPanel.RecommendView)paramView);
    AppMethodBeat.o(63000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.i.c
 * JD-Core Version:    0.7.0.1
 */