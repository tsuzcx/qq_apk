package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import java.util.Iterator;
import java.util.LinkedList;

public class FavourLayout
  extends LinearLayout
{
  public FavourLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FavourLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setWording(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(71482);
    removeAllViews();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      TextView localTextView = new TextView(getContext());
      localTextView.setText(str);
      localTextView.setTextColor(Color.parseColor("#ff891e"));
      localTextView.setTextSize(0, a.aG(getContext(), 2131165587));
      addView(localTextView);
    }
    AppMethodBeat.o(71482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout
 * JD-Core Version:    0.7.0.1
 */