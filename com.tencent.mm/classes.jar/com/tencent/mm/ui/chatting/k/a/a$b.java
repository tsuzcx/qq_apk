package com.tencent.mm.ui.chatting.k.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;

final class a$b
  implements Runnable
{
  private bi cmQ;
  private int scene;
  private CharSequence text;
  
  a$b(CharSequence paramCharSequence, bi parambi, int paramInt)
  {
    this.text = paramCharSequence;
    this.cmQ = parambi;
    this.scene = paramInt;
  }
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(32678);
    if ((this.text instanceof Spannable)) {}
    for (;;)
    {
      try
      {
        Spannable localSpannable = (Spannable)this.text;
        System.nanoTime();
        Object[] arrayOfObject = localSpannable.getSpans(0, localSpannable.length(), Object.class);
        Object localObject3 = new ArrayList(1);
        if ((arrayOfObject == null) || (arrayOfObject.length == 0)) {
          break label401;
        }
        int j = arrayOfObject.length;
        Object localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = arrayOfObject[i];
          if ((localObject1 == null) || (!com.tencent.mm.plugin.normsg.a.b.pgQ.d(localObject1, n.class))) {
            break label394;
          }
          ((ArrayList)localObject3).add(new a.b.a.a((byte)0).a(localObject1, localSpannable));
          break label394;
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
          break label387;
        }
        this.cmQ = ((j)g.E(j.class)).bPQ().kB(this.cmQ.field_msgId);
        if ((this.cmQ != null) && (!bo.isNullOrNil(this.cmQ.field_talker)))
        {
          this.cmQ.hV(this.cmQ.field_flag | 0x10);
          ((j)g.E(j.class)).bPQ().a(this.cmQ.field_msgId, this.cmQ);
        }
        aw.aaz().Za().abH();
        aw.aaz().Za().b(b.b.fow);
        localObject1 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label387;
        }
        localObject3 = ((a.b.c)((Iterator)localObject1).next()).extInfo;
        com.tencent.mm.plugin.report.service.h.qsU.e(14237, new Object[] { "msg", Long.valueOf(this.cmQ.field_msgId), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), localObject3 });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(587L, 0L, 1L, false);
        continue;
        AppMethodBeat.o(32678);
      }
      catch (Exception localException) {}
      return;
      label387:
      AppMethodBeat.o(32678);
      return;
      label394:
      i += 1;
      continue;
      label401:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */