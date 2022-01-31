package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class o$1
  implements View.OnClickListener
{
  o$1(o paramo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153943);
    paramView = (az)paramView.getTag();
    if (paramView == null)
    {
      ab.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan tag not valid");
      AppMethodBeat.o(153943);
      return;
    }
    paramView = paramView.cEE;
    if (paramView == null)
    {
      ab.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan msg not valid");
      AppMethodBeat.o(153943);
      return;
    }
    paramView = paramView.field_content;
    if (bo.isNullOrNil(paramView))
    {
      ab.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan content not valid");
      AppMethodBeat.o(153943);
      return;
    }
    Object localObject = OfflineScanContext.CREATOR;
    paramView = OfflineScanContext.a.Yx(paramView);
    ab.i("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan onClick resultType: %d, codeType: %d, selectFromAlbum: %b", new Object[] { Integer.valueOf(paramView.quq), Integer.valueOf(paramView.cpE), Boolean.valueOf(paramView.qus) });
    localObject = j.qut;
    localObject = paramView.typeName;
    if (paramView.qus) {}
    for (int i = 2;; i = 1)
    {
      j.l((String)localObject, i, paramView.networkType, 1);
      if (g.Rc().adt() != 0) {
        break;
      }
      h.a(o.a(this.zUj).zJz.getContext(), o.a(this.zUj).zJz.getContext().getString(2131302008), "", o.a(this.zUj).zJz.getContext().getString(2131296977), new o.1.1(this));
      AppMethodBeat.o(153943);
      return;
    }
    if (paramView.quq == 1)
    {
      if (bo.isNullOrNil(paramView.qur))
      {
        ab.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan qBar result invalid");
        AppMethodBeat.o(153943);
        return;
      }
      o.b(this.zUj).a(o.a(this.zUj).zJz.getContext(), paramView.qur, paramView.cpt, paramView.cpE, paramView.cpF, paramView.typeName, null, paramView.cpJ, 3, true, paramView.networkType);
      AppMethodBeat.o(153943);
      return;
    }
    localObject = paramView.qur;
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.ChattingItemAppMsgOfflineScan", "alvinluo OfflineScan zBar result invalid");
      AppMethodBeat.o(153943);
      return;
    }
    if (o.c(this.zUj) != null) {
      o.c(this.zUj).a(o.a(this.zUj).zJz.getContext(), (String)localObject, paramView.qus, paramView.cpE, paramView.cpF, paramView.typeName, null, paramView.cpJ, 3, true, paramView.networkType);
    }
    AppMethodBeat.o(153943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.1
 * JD-Core Version:    0.7.0.1
 */