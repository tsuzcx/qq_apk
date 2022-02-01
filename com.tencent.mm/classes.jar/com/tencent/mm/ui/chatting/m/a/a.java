package com.tencent.mm.ui.chatting.m.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMTextView.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static volatile a PFd;
  private static final MMHandler PFe;
  
  static
  {
    AppMethodBeat.i(36623);
    PFd = null;
    PFe = new MMHandler("AAChattingHelper");
    AppMethodBeat.o(36623);
  }
  
  private a()
  {
    AppMethodBeat.i(185017);
    PFe.setLogging(false);
    AppMethodBeat.o(185017);
  }
  
  public static void a(CharSequence paramCharSequence, ca paramca)
  {
    AppMethodBeat.i(36621);
    a(paramCharSequence, paramca, 1);
    AppMethodBeat.o(36621);
  }
  
  private static void a(CharSequence paramCharSequence, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36620);
    if ((paramCharSequence instanceof Spannable)) {
      PFe.postToWorker(new b(paramCharSequence, paramca, paramInt));
    }
    AppMethodBeat.o(36620);
  }
  
  public static a gTK()
  {
    AppMethodBeat.i(36619);
    if (PFd == null) {
      try
      {
        if (PFd == null) {
          PFd = new a();
        }
        a locala1 = PFd;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(36619);
      }
    }
    a locala2 = PFd;
    AppMethodBeat.o(36619);
    return locala2;
  }
  
  public static MMTextView.a gTL()
  {
    return a.PFf;
  }
  
  static enum a
    implements MMTextView.a
  {
    static
    {
      AppMethodBeat.i(36616);
      PFf = new a("TEXT_CALLBACK");
      PFg = new a[] { PFf };
      AppMethodBeat.o(36616);
    }
    
    private a() {}
    
    public final void a(CharSequence paramCharSequence, long paramLong)
    {
      AppMethodBeat.i(36615);
      ca localca = ((l)g.af(l.class)).eiy().Hb(paramLong);
      if (Util.isNullOrNil(localca.field_talker))
      {
        Log.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
        AppMethodBeat.o(36615);
        return;
      }
      if ((localca.field_flag & 0x10) == 0)
      {
        a.b(paramCharSequence, localca);
        AppMethodBeat.o(36615);
        return;
      }
      Log.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(36615);
    }
  }
  
  static final class b
    implements Runnable
  {
    private ca dCM;
    private int scene;
    private CharSequence text;
    
    b(CharSequence paramCharSequence, ca paramca, int paramInt)
    {
      this.text = paramCharSequence;
      this.dCM = paramca;
      this.scene = paramInt;
    }
    
    public final void run()
    {
      int i = 0;
      AppMethodBeat.i(36618);
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
            break label398;
          }
          int j = arrayOfObject.length;
          Object localObject1 = localObject3;
          if (i < j)
          {
            localObject1 = arrayOfObject[i];
            if ((localObject1 == null) || (!d.AEF.c(localObject1, p.class))) {
              break label391;
            }
            ((ArrayList)localObject3).add(new a.a((byte)0).a(localObject1, localSpannable));
            break label391;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
            break label385;
          }
          this.dCM = ((l)g.af(l.class)).eiy().Hb(this.dCM.field_msgId);
          if ((this.dCM != null) && (!Util.isNullOrNil(this.dCM.field_talker)))
          {
            this.dCM.setFlag(this.dCM.field_flag | 0x10);
            ((l)g.af(l.class)).eiy().a(this.dCM.field_msgId, this.dCM);
          }
          bg.aVF().aTo().aXf();
          bg.aVF().aTo().b(b.b.iGK);
          localObject1 = ((ArrayList)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label385;
          }
          localObject3 = ((c)((Iterator)localObject1).next()).extInfo;
          h.CyF.a(14237, new Object[] { "msg", Long.valueOf(this.dCM.field_msgId), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), localObject3 });
          h.CyF.idkeyStat(587L, 0L, 1L, false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.a
 * JD-Core Version:    0.7.0.1
 */