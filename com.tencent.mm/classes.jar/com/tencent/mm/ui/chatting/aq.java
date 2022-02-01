package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aq
{
  private static LinkedList<View> WEO;
  private static LinkedList<View> WEP;
  private static LinkedList<View> WEQ;
  
  static
  {
    AppMethodBeat.i(123728);
    WEO = new LinkedList();
    WEP = new LinkedList();
    WEQ = new LinkedList();
    AppMethodBeat.o(123728);
  }
  
  public static void aM(View paramView, int paramInt)
  {
    AppMethodBeat.i(123726);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = WEO;
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
        localLinkedList = WEP;
      } else {
        localLinkedList = WEQ;
      }
    }
  }
  
  public static View avs(int paramInt)
  {
    AppMethodBeat.i(123725);
    Object localObject;
    if (paramInt == 1) {
      localObject = WEO;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(123725);
      return localObject;
      if (paramInt == 2) {
        localObject = WEP;
      } else {
        localObject = WEQ;
      }
    }
    AppMethodBeat.o(123725);
    return null;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123727);
    WEO.clear();
    WEP.clear();
    WEQ.clear();
    AppMethodBeat.o(123727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aq
 * JD-Core Version:    0.7.0.1
 */