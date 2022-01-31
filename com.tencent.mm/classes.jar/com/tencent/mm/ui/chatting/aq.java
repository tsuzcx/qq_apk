package com.tencent.mm.ui.chatting;

import android.view.View;
import java.util.LinkedList;

public final class aq
{
  private static LinkedList<View> vnr = new LinkedList();
  private static LinkedList<View> vns = new LinkedList();
  private static LinkedList<View> vnt = new LinkedList();
  
  public static View GV(int paramInt)
  {
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = vnr;
    }
    while (localLinkedList.size() != 0)
    {
      return (View)localLinkedList.removeFirst();
      if (paramInt == 2) {
        localLinkedList = vns;
      } else {
        localLinkedList = vnt;
      }
    }
    return null;
  }
  
  public static void U(View paramView, int paramInt)
  {
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = vnr;
    }
    for (;;)
    {
      if (localLinkedList.size() >= 35) {
        localLinkedList.removeFirst();
      }
      localLinkedList.addLast(paramView);
      return;
      if (paramInt == 2) {
        localLinkedList = vns;
      } else {
        localLinkedList = vnt;
      }
    }
  }
  
  public static void clear()
  {
    vnr.clear();
    vns.clear();
    vnt.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aq
 * JD-Core Version:    0.7.0.1
 */