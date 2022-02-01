package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aq
{
  private static LinkedList<View> Ple;
  private static LinkedList<View> Plf;
  private static LinkedList<View> Plg;
  
  static
  {
    AppMethodBeat.i(123728);
    Ple = new LinkedList();
    Plf = new LinkedList();
    Plg = new LinkedList();
    AppMethodBeat.o(123728);
  }
  
  public static void aH(View paramView, int paramInt)
  {
    AppMethodBeat.i(123726);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = Ple;
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
        localLinkedList = Plf;
      } else {
        localLinkedList = Plg;
      }
    }
  }
  
  public static View ams(int paramInt)
  {
    AppMethodBeat.i(123725);
    Object localObject;
    if (paramInt == 1) {
      localObject = Ple;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(123725);
      return localObject;
      if (paramInt == 2) {
        localObject = Plf;
      } else {
        localObject = Plg;
      }
    }
    AppMethodBeat.o(123725);
    return null;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123727);
    Ple.clear();
    Plf.clear();
    Plg.clear();
    AppMethodBeat.o(123727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aq
 * JD-Core Version:    0.7.0.1
 */