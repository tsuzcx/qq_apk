package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.model.c;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.chatting.d.a.a(hRc=aj.class)
public class av
  extends a
  implements i, aj
{
  private static String TAG = "MicroMsg.RemittanceRevokeComponent";
  
  public final void cy(final ca paramca)
  {
    AppMethodBeat.i(289774);
    e locale = new e(this.fgR.WQv.getContext(), 1, true);
    locale.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(278887);
        paramAnonymouso.d(1, av.this.fgR.WQv.getContext().getString(R.l.app_ok));
        AppMethodBeat.o(278887);
      }
    };
    locale.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(292354);
        if (paramAnonymousMenuItem.getItemId() == 1) {
          av.a(av.this, paramca);
        }
        AppMethodBeat.o(292354);
      }
    };
    long l2 = ((b)h.ae(b.class)).a(b.a.vVa, 120000L);
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 120000L;
    }
    int i = Math.round((float)l1 / 60000.0F);
    locale.j(this.fgR.WQv.getContext().getString(R.l.ewR, new Object[] { Integer.valueOf(i) }), 17, 0);
    locale.eik();
    AppMethodBeat.o(289774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.av
 * JD-Core Version:    0.7.0.1
 */