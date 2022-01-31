package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class d$2$2
  implements n.d
{
  d$2$2(d.2 param2, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(153640);
    if (paramInt == 0)
    {
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setText(this.ehq.getText());
      h.bN(this.qay.qau.context, this.qay.qau.context.getString(2131296896));
      AppMethodBeat.o(153640);
      return;
    }
    Object localObject;
    u localu;
    tt localtt;
    tt.a locala;
    if (paramInt == 1)
    {
      if ((this.qay.qaw) && (this.qay.qax.status == 2))
      {
        paramMenuItem = this.qay.qav;
        localObject = paramMenuItem.Co(this.qay.gxr);
        if (((u)localObject).status == 2)
        {
          ((u)localObject).status = 0;
          paramMenuItem.jXl.notifyDataSetChanged();
        }
        AppMethodBeat.o(153640);
        return;
      }
      localObject = this.qay.qav;
      int i = this.qay.gxr;
      if (!this.qay.qaw) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localu = ((i)localObject).Co(i);
        if ((bo.isNullOrNil(localu.pYY)) || (paramInt != 0)) {
          break;
        }
        localu.status = 2;
        ((i)localObject).jXl.notifyDataSetChanged();
        AppMethodBeat.o(153640);
        return;
      }
      localtt = new tt();
      localtt.cKm.cKo = false;
      localtt.cKm.id = String.valueOf(i);
      localtt.cKm.cKn = ((aca)((i)localObject).pZZ.pZa.get(i)).desc;
      locala = localtt.cKm;
      if (localu.pYZ == null) {
        break label345;
      }
    }
    label345:
    for (paramMenuItem = localu.pYZ.pW;; paramMenuItem = null)
    {
      locala.cKp = paramMenuItem;
      localtt.cKm.type = 4;
      com.tencent.mm.sdk.b.a.ymk.l(localtt);
      localu.status = 1;
      ((i)localObject).jXl.notifyDataSetChanged();
      AppMethodBeat.o(153640);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.2.2
 * JD-Core Version:    0.7.0.1
 */