package com.tencent.mm.view.recyclerview;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "onClick", "", "itemView", "Landroid/view/View;", "data", "position", "", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/ConvertData;I)V", "onLongClick", "", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/ConvertData;I)Z", "onTouch", "event", "Landroid/view/MotionEvent;", "item", "(Landroid/view/View;Landroid/view/MotionEvent;Lcom/tencent/mm/view/recyclerview/ConvertData;I)Z", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h<D extends a>
{
  public abstract void a(View paramView, D paramD, int paramInt);
  
  public abstract boolean a(View paramView, MotionEvent paramMotionEvent, D paramD);
  
  public abstract boolean b(View paramView, D paramD, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */