package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.ai.e.a.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami, e.a.b paramb) {}
  
  public final void run()
  {
    au.Hx();
    Object localObject = c.Fw().abl(this.voN.eeM);
    if ((i.a(this.vLi) != null) && (i.a(this.vLi).size() > 0) && (i.a(this.vLi).contains(this.voN.eeM))) {
      if ((localObject == null) || ((int)((a)localObject).dBe <= 0) || (!a.gR(((ao)localObject).field_type)))
      {
        y.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", new Object[] { this.voN.eeM });
        i.a(this.vLi).remove(this.voN.eeM);
        if (i.a(this.vLi).size() <= 0) {
          break label208;
        }
        localObject = (View)i.b(this.vLi).get(this.voN.eeM);
        if ((localObject != null) && (i.c(this.vLi) != null)) {
          i.c(this.vLi).removeView((View)localObject);
        }
      }
    }
    label208:
    do
    {
      do
      {
        i.b(this.vLi).remove(localObject);
        do
        {
          return;
        } while (i.d(this.vLi) == null);
        if (i.b(this.vLi) != null) {
          i.b(this.vLi).clear();
        }
        if (i.c(this.vLi) != null) {
          i.c(this.vLi).removeAllViews();
        }
        i.d(this.vLi).HJ(i.a(this.vLi).size());
        return;
      } while ((localObject == null) || ((int)((a)localObject).dBe <= 0) || (!a.gR(((ao)localObject).field_type)));
      if (i.a(this.vLi) != null) {
        i.a(this.vLi).clear();
      }
      if (i.b(this.vLi) != null) {
        i.b(this.vLi).clear();
      }
      if (i.c(this.vLi) != null) {
        i.c(this.vLi).removeAllViews();
      }
      i.e(this.vLi);
    } while (i.d(this.vLi) == null);
    i.d(this.vLi).HJ(i.a(this.vLi).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i.1
 * JD-Core Version:    0.7.0.1
 */