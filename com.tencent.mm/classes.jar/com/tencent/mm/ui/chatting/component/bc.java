package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.remittance.model.d;
import com.tencent.mm.protocal.protobuf.fci;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.aq;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=aq.class)
public class bc
  extends a
  implements com.tencent.mm.am.h, aq
{
  private static String TAG = "MicroMsg.RemittanceRevokeComponent";
  
  public final void cV(final cc paramcc)
  {
    AppMethodBeat.i(256385);
    f localf = new f(this.hlc.aezO.getContext(), 1, true);
    localf.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(256265);
        paramAnonymouss.c(1, bc.this.hlc.aezO.getContext().getString(R.l.app_ok));
        AppMethodBeat.o(256265);
      }
    };
    localf.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(256261);
        if (paramAnonymousMenuItem.getItemId() == 1) {
          bc.a(bc.this, paramcc);
        }
        AppMethodBeat.o(256261);
      }
    };
    long l2 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.znE, 120000L);
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 120000L;
    }
    int i = Math.round((float)l1 / 60000.0F);
    localf.h(this.hlc.aezO.getContext().getString(R.l.gzu, new Object[] { Integer.valueOf(i) }), 17, 0);
    localf.dDn();
    AppMethodBeat.o(256385);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bc
 * JD-Core Version:    0.7.0.1
 */