package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
{
  private static LinkedList<View> zCN;
  private static LinkedList<View> zCO;
  private static LinkedList<View> zCP;
  
  static
  {
    AppMethodBeat.i(70052);
    zCN = new LinkedList();
    zCO = new LinkedList();
    zCP = new LinkedList();
    AppMethodBeat.o(70052);
  }
  
  public static View Py(int paramInt)
  {
    AppMethodBeat.i(70049);
    Object localObject;
    if (paramInt == 1) {
      localObject = zCN;
    }
    while (((LinkedList)localObject).size() != 0)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      AppMethodBeat.o(70049);
      return localObject;
      if (paramInt == 2) {
        localObject = zCO;
      } else {
        localObject = zCP;
      }
    }
    AppMethodBeat.o(70049);
    return null;
  }
  
  public static void an(View paramView, int paramInt)
  {
    AppMethodBeat.i(70050);
    LinkedList localLinkedList;
    if (paramInt == 1) {
      localLinkedList = zCN;
    }
    for (;;)
    {
      if (localLinkedList.size() >= 35) {
        localLinkedList.removeFirst();
      }
      localLinkedList.addLast(paramView);
      AppMethodBeat.o(70050);
      return;
      if (paramInt == 2) {
        localLinkedList = zCO;
      } else {
        localLinkedList = zCP;
      }
    }
  }
  
  public static void clear()
  {
    AppMethodBeat.i(70051);
    zCN.clear();
    zCO.clear();
    zCP.clear();
    AppMethodBeat.o(70051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */