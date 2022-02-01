package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
{
  private static LinkedList<View> JEQ;
  private static LinkedList<View> JER;
  private static LinkedList<View> JES;
  
  static
  {
    AppMethodBeat.i(123728);
    JEQ = new LinkedList();
    JER = new LinkedList();
    JES = new LinkedList();
    AppMethodBeat.o(123728);
  }
  
  public static void aC(View paramView, int paramInt)
  {
    AppMethodBeat.i(123726);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = JEQ;
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
        localLinkedList = JER;
      } else {
        localLinkedList = JES;
      }
    }
  }
  
  public static View acZ(int paramInt)
  {
    AppMethodBeat.i(123725);
    Object localObject;
    if (paramInt == 1) {
      localObject = JEQ;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(123725);
      return localObject;
      if (paramInt == 2) {
        localObject = JER;
      } else {
        localObject = JES;
      }
    }
    AppMethodBeat.o(123725);
    return null;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123727);
    JEQ.clear();
    JER.clear();
    JES.clear();
    AppMethodBeat.o(123727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */