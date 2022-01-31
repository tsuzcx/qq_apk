package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

final class n$2
  implements View.OnClickListener
{
  n$2(n paramn, LinkedList paramLinkedList, n.a parama, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(79175);
    paramView = new ArrayList();
    int i = 0;
    while (i < this.hDM.size())
    {
      if ((((bwv)this.hDM.get(i)).xJY == 2) || (((bwv)this.hDM.get(i)).xJY == 3)) {
        paramView.add(((bwv)this.hDM.get(i)).wAh);
      }
      i += 1;
    }
    ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_scope", paramView);
    this.vte.h(2, localBundle);
    this.tdU.dismiss();
    AppMethodBeat.o(79175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.2
 * JD-Core Version:    0.7.0.1
 */