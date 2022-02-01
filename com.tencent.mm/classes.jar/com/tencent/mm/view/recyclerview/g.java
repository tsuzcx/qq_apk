package com.tencent.mm.view.recyclerview;

import android.view.MotionEvent;
import android.view.View;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "onClick", "", "itemView", "Landroid/view/View;", "data", "position", "", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/ConvertData;I)V", "onLongClick", "", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/ConvertData;I)Z", "onTouch", "event", "Landroid/view/MotionEvent;", "item", "(Landroid/view/View;Landroid/view/MotionEvent;Lcom/tencent/mm/view/recyclerview/ConvertData;I)Z", "libmmui_release"})
public abstract interface g<D extends a>
{
  public abstract void a(View paramView, D paramD);
  
  public abstract boolean a(View paramView, MotionEvent paramMotionEvent, D paramD);
  
  public abstract boolean a(View paramView, D paramD, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g
 * JD-Core Version:    0.7.0.1
 */