package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami, e.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(33703);
    aw.aaz();
    Object localObject = c.YA().arw(this.zEp.fuO);
    if ((i.a(this.AcK) != null) && (i.a(this.AcK).size() > 0) && (i.a(this.AcK).contains(this.zEp.fuO)))
    {
      if ((localObject == null) || ((int)((a)localObject).euF <= 0) || (!a.je(((aq)localObject).field_type)))
      {
        ab.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", new Object[] { this.zEp.fuO });
        i.a(this.AcK).remove(this.zEp.fuO);
        if (i.a(this.AcK).size() > 0)
        {
          localObject = (View)i.b(this.AcK).get(this.zEp.fuO);
          if ((localObject != null) && (i.c(this.AcK) != null))
          {
            i.c(this.AcK).removeView((View)localObject);
            i.b(this.AcK).remove(localObject);
          }
          AppMethodBeat.o(33703);
          return;
        }
        if (i.d(this.AcK) != null)
        {
          if (i.b(this.AcK) != null) {
            i.b(this.AcK).clear();
          }
          if (i.c(this.AcK) != null) {
            i.c(this.AcK).removeAllViews();
          }
          i.d(this.AcK).Qr(i.a(this.AcK).size());
          AppMethodBeat.o(33703);
        }
      }
    }
    else
    {
      if ((localObject == null) || ((int)((a)localObject).euF <= 0) || (!a.je(((aq)localObject).field_type)))
      {
        AppMethodBeat.o(33703);
        return;
      }
      if (i.a(this.AcK) != null) {
        i.a(this.AcK).clear();
      }
      if (i.b(this.AcK) != null) {
        i.b(this.AcK).clear();
      }
      if (i.c(this.AcK) != null) {
        i.c(this.AcK).removeAllViews();
      }
      i.e(this.AcK);
      if (i.d(this.AcK) != null) {
        i.d(this.AcK).Qr(i.a(this.AcK).size());
      }
    }
    AppMethodBeat.o(33703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i.1
 * JD-Core Version:    0.7.0.1
 */