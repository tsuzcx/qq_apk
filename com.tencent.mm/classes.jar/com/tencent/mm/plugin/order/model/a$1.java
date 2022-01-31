package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class a$1
  implements View.OnClickListener
{
  a$1(MallTransactionObject paramMallTransactionObject, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43747);
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    if (!bo.isNullOrNil(this.poX.ppq))
    {
      localLinkedList.add(Integer.valueOf(0));
      paramView.add(this.val$context.getString(2131305365));
    }
    if (!bo.isNullOrNil(this.poX.poT))
    {
      localLinkedList.add(Integer.valueOf(1));
      paramView.add(this.val$context.getString(2131305366));
    }
    if (!bo.isNullOrNil(this.poX.ppz))
    {
      localLinkedList.add(Integer.valueOf(2));
      paramView.add(this.val$context.getString(2131305368));
    }
    if (localLinkedList.size() == 1)
    {
      a.a(((Integer)localLinkedList.get(0)).intValue(), this.val$context, this.poX);
      AppMethodBeat.o(43747);
      return;
    }
    h.a(this.val$context, null, paramView, localLinkedList, null, true, new a.1.1(this));
    AppMethodBeat.o(43747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a.1
 * JD-Core Version:    0.7.0.1
 */