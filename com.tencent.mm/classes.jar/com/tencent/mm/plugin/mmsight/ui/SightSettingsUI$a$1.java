package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class SightSettingsUI$a$1
  implements View.OnClickListener
{
  SightSettingsUI$a$1(SightSettingsUI.a parama, SightSettingsUI.b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.mqN;
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    while (i < paramView.mqQ.length)
    {
      localLinkedList1.add(paramView.mqQ[i]);
      localLinkedList2.add(Integer.valueOf(i));
      i += 1;
    }
    h.a(paramView.mqM, "", localLinkedList1, localLinkedList2, "", new SightSettingsUI.b.1(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.a.1
 * JD-Core Version:    0.7.0.1
 */