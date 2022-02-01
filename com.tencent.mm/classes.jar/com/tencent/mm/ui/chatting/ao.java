package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
{
  private static LinkedList<View> Gri;
  private static LinkedList<View> Grj;
  private static LinkedList<View> Grk;
  
  static
  {
    AppMethodBeat.i(123728);
    Gri = new LinkedList();
    Grj = new LinkedList();
    Grk = new LinkedList();
    AppMethodBeat.o(123728);
  }
  
  public static View YD(int paramInt)
  {
    AppMethodBeat.i(123725);
    Object localObject;
    if (paramInt == 1) {
      localObject = Gri;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(123725);
      return localObject;
      if (paramInt == 2) {
        localObject = Grj;
      } else {
        localObject = Grk;
      }
    }
    AppMethodBeat.o(123725);
    return null;
  }
  
  public static void ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(123726);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = Gri;
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
        localLinkedList = Grj;
      } else {
        localLinkedList = Grk;
      }
    }
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123727);
    Gri.clear();
    Grj.clear();
    Grk.clear();
    AppMethodBeat.o(123727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */