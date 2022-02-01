package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ap
{
  private static LinkedList<View> JZH;
  private static LinkedList<View> JZI;
  private static LinkedList<View> JZJ;
  
  static
  {
    AppMethodBeat.i(123728);
    JZH = new LinkedList();
    JZI = new LinkedList();
    JZJ = new LinkedList();
    AppMethodBeat.o(123728);
  }
  
  public static void aC(View paramView, int paramInt)
  {
    AppMethodBeat.i(123726);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = JZH;
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
        localLinkedList = JZI;
      } else {
        localLinkedList = JZJ;
      }
    }
  }
  
  public static View adH(int paramInt)
  {
    AppMethodBeat.i(123725);
    Object localObject;
    if (paramInt == 1) {
      localObject = JZH;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(123725);
      return localObject;
      if (paramInt == 2) {
        localObject = JZI;
      } else {
        localObject = JZJ;
      }
    }
    AppMethodBeat.o(123725);
    return null;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123727);
    JZH.clear();
    JZI.clear();
    JZJ.clear();
    AppMethodBeat.o(123727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ap
 * JD-Core Version:    0.7.0.1
 */