package com.tencent.mm.view.recyclerview;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "onItemTouch", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "event", "Landroid/view/MotionEvent;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroid/view/MotionEvent;)Z", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface i$e<VH extends RecyclerView.v>
{
  public abstract boolean a(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i.e
 * JD-Core Version:    0.7.0.1
 */