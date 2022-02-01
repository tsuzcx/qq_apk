package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class as
{
  private static LinkedList<View> aemo;
  private static LinkedList<View> aemp;
  private static LinkedList<View> aemq;
  
  static
  {
    AppMethodBeat.i(123728);
    aemo = new LinkedList();
    aemp = new LinkedList();
    aemq = new LinkedList();
    AppMethodBeat.o(123728);
  }
  
  public static View aBU(int paramInt)
  {
    AppMethodBeat.i(123725);
    Object localObject;
    if (paramInt == 1) {
      localObject = aemo;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(123725);
      return localObject;
      if (paramInt == 2) {
        localObject = aemp;
      } else {
        localObject = aemq;
      }
    }
    AppMethodBeat.o(123725);
    return null;
  }
  
  public static void bj(View paramView, int paramInt)
  {
    AppMethodBeat.i(123726);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = aemo;
    }
    for (;;)
    {
      if (localLinkedList.size() >= 35) {
        localLinkedList.removeFirst();
      }
      localLinkedList.addLast(paramView);
      AppMethodBeat.o(123726);
      return;
      if (paramInt == 2) {
        localLinkedList = aemp;
      } else {
        localLinkedList = aemq;
      }
    }
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123727);
    aemo.clear();
    aemp.clear();
    aemq.clear();
    AppMethodBeat.o(123727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.as
 * JD-Core Version:    0.7.0.1
 */