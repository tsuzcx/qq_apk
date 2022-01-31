package com.tencent.mm.plugin.record.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.g;
import com.tencent.mm.av.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import java.io.File;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (!com.tencent.mm.compatible.util.f.zF()) {
      s.gM(paramView.getContext());
    }
    Object localObject1;
    xx localxx;
    do
    {
      return;
      localObject1 = (com.tencent.mm.plugin.record.ui.a.b)paramView.getTag();
      localxx = ((com.tencent.mm.plugin.record.ui.a.b)localObject1).bNt.sVA.sWd;
      if (!b.e(((com.tencent.mm.plugin.record.ui.a.b)localObject1).bNt)) {
        break;
      }
      y.i("MicroMsg.OtherViewWrapper", "same song, do release");
      a.Ps();
    } while (this.nuC.nuA);
    this.nuC.handler.sendMessageAtFrontOfQueue(this.nuC.handler.obtainMessage(1));
    return;
    this.nuC.nuA = true;
    paramView = new File(h.f(((com.tencent.mm.plugin.record.ui.a.b)localObject1).bNt, ((com.tencent.mm.plugin.record.ui.a.b)localObject1).bIt));
    if (!paramView.exists()) {
      if (((com.tencent.mm.plugin.record.ui.a.b)localObject1).bNt.bIm == null) {
        paramView = "";
      }
    }
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject1).bNt;
      localObject1 = ((xv)localObject2).title;
      String str1 = ((xv)localObject2).desc;
      String str2 = ((xv)localObject2).sUN;
      String str3 = ((xv)localObject2).sUR;
      String str4 = ((xv)localObject2).sUP;
      localObject2 = ((xv)localObject2).kgC;
      StringBuilder localStringBuilder = new StringBuilder();
      au.Hx();
      a.b(com.tencent.mm.av.f.a(6, null, (String)localObject1, str1, str2, str3, str4, (String)localObject2, c.FQ() + "web/", paramView, "", localxx.appId));
      return;
      paramView = new StringBuilder();
      au.Hx();
      paramView = new File(c.FQ() + "web/" + g.o(((com.tencent.mm.plugin.record.ui.a.b)localObject1).bNt.bIm.getBytes()));
      if (paramView.exists()) {}
      for (paramView = paramView.getAbsolutePath();; paramView = "") {
        break;
      }
      paramView = paramView.getAbsolutePath();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.b.2
 * JD-Core Version:    0.7.0.1
 */