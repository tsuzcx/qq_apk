package com.tencent.mm.ui.chatting.n.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

final class a$b
  implements Runnable
{
  private CharSequence LV;
  private ca fvt;
  private int scene;
  
  a$b(CharSequence paramCharSequence, ca paramca, int paramInt)
  {
    this.LV = paramCharSequence;
    this.fvt = paramca;
    this.scene = paramInt;
  }
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(36618);
    if ((this.LV instanceof Spannable)) {}
    for (;;)
    {
      try
      {
        Spannable localSpannable = (Spannable)this.LV;
        System.nanoTime();
        Object[] arrayOfObject = localSpannable.getSpans(0, localSpannable.length(), Object.class);
        Object localObject3 = new ArrayList(1);
        if ((arrayOfObject == null) || (arrayOfObject.length == 0)) {
          break label398;
        }
        int j = arrayOfObject.length;
        Object localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = arrayOfObject[i];
          if ((localObject1 == null) || (!d.GxJ.c(localObject1, p.class))) {
            break label391;
          }
          ((ArrayList)localObject3).add(new a.a((byte)0).a(localObject1, localSpannable));
          break label391;
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
          break label385;
        }
        this.fvt = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.fvt.field_msgId);
        if ((this.fvt != null) && (!Util.isNullOrNil(this.fvt.field_talker)))
        {
          this.fvt.setFlag(this.fvt.field_flag | 0x10);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fvt.field_msgId, this.fvt);
        }
        bh.beI().bcm().bgm();
        bh.beI().bcm().b(b.b.lwM);
        localObject1 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label385;
        }
        localObject3 = ((c)((Iterator)localObject1).next()).extInfo;
        com.tencent.mm.plugin.report.service.h.IzE.a(14237, new Object[] { "msg", Long.valueOf(this.fvt.field_msgId), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), localObject3 });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(587L, 0L, 1L, false);
        continue;
        AppMethodBeat.o(36618);
      }
      catch (Exception localException) {}
      return;
      label385:
      AppMethodBeat.o(36618);
      return;
      label391:
      i += 1;
      continue;
      label398:
      Object localObject2 = null;
    }
  }
  
  static final class a$a
    implements a.b.b
  {
    public final a.b.c a(Object paramObject, Spannable paramSpannable)
    {
      AppMethodBeat.i(36617);
      String str = paramSpannable.toString().substring(paramSpannable.getSpanStart(paramObject), paramSpannable.getSpanEnd(paramObject));
      try
      {
        paramSpannable = Util.nullAs(new JSONObject(paramObject.toString()).optString("type"), paramObject.getClass().getName());
        paramObject = paramSpannable;
      }
      catch (JSONException paramSpannable)
      {
        for (;;)
        {
          paramObject = paramObject.getClass().getName();
        }
      }
      paramObject = new a.b.c(str, paramObject);
      AppMethodBeat.o(36617);
      return paramObject;
    }
  }
  
  static abstract interface b
  {
    public abstract a.b.c a(Object paramObject, Spannable paramSpannable);
  }
  
  static final class c
  {
    String extInfo;
    String text;
    
    c(String paramString1, String paramString2)
    {
      this.text = paramString1;
      this.extInfo = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.a.b
 * JD-Core Version:    0.7.0.1
 */