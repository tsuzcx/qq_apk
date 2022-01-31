package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.d;
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
    removeAllViews();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      TextView localTextView = new TextView(getContext());
      localTextView.setText(str);
      localTextView.setTextColor(Color.parseColor("#ff891e"));
      localTextView.setTextSize(0, a.aa(getContext(), a.d.SmallTextSize));
      addView(localTextView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout
 * JD-Core Version:    0.7.0.1
 */