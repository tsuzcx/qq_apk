package com.tencent.mm.ui.chatting.j.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

final class a$b
  implements Runnable
{
  private bi bFH;
  private int scene;
  private CharSequence text;
  
  a$b(CharSequence paramCharSequence, bi parambi, int paramInt)
  {
    this.text = paramCharSequence;
    this.bFH = parambi;
    this.scene = paramInt;
  }
  
  public final void run()
  {
    int i = 0;
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
          break label382;
        }
        int j = arrayOfObject.length;
        Object localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = arrayOfObject[i];
          if ((localObject1 != null) && (com.tencent.mm.plugin.normsg.a.b.mGK.c(localObject1, n.class))) {
            ((ArrayList)localObject3).add(new a.a((byte)0).a(localObject1, localSpannable));
          }
        }
        else
        {
          if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
          {
            this.bFH = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.bFH.field_msgId);
            if ((this.bFH != null) && (!bk.bl(this.bFH.field_talker)))
            {
              this.bFH.fJ(this.bFH.field_flag | 0x10);
              ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.bFH.field_msgId, this.bFH);
            }
            au.Hx().FZ().IK();
            au.Hx().FZ().b(b.b.dYr);
            localObject1 = ((ArrayList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = ((a.b.c)((Iterator)localObject1).next()).extInfo;
              h.nFQ.f(14237, new Object[] { "msg", Long.valueOf(this.bFH.field_msgId), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), localObject3 });
              h.nFQ.a(587L, 0L, 1L, false);
              continue;
            }
          }
          return;
        }
      }
      catch (Exception localException) {}
      i += 1;
      continue;
      label382:
      Object localObject2 = null;
    }
  }
  
  private static final class a$a
    implements a.b.b
  {
    public final a.b.c a(Object paramObject, Spannable paramSpannable)
    {
      String str = paramSpannable.toString().substring(paramSpannable.getSpanStart(paramObject), paramSpannable.getSpanEnd(paramObject));
      try
      {
        paramSpannable = bk.aM(new JSONObject(paramObject.toString()).optString("type"), paramObject.getClass().getName());
        paramObject = paramSpannable;
      }
      catch (JSONException paramSpannable)
      {
        for (;;)
        {
          paramObject = paramObject.getClass().getName();
        }
      }
      return new a.b.c(str, paramObject);
    }
  }
  
  private static abstract interface b
  {
    public abstract a.b.c a(Object paramObject, Spannable paramSpannable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a.a.b
 * JD-Core Version:    0.7.0.1
 */