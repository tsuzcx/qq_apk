package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

final class n$2
  implements View.OnClickListener
{
  n$2(n paramn, LinkedList paramLinkedList, n.a parama, i parami) {}
  
  public final void onClick(View paramView)
  {
    paramView = new ArrayList();
    int i = 0;
    while (i < this.fXW.size())
    {
      if ((((bna)this.fXW.get(i)).tGf == 2) || (((bna)this.fXW.get(i)).tGf == 3)) {
        paramView.add(((bna)this.fXW.get(i)).sEi);
      }
      i += 1;
    }
    y.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_scope", paramView);
    this.rCS.e(2, localBundle);
    this.fXY.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.2
 * JD-Core Version:    0.7.0.1
 */