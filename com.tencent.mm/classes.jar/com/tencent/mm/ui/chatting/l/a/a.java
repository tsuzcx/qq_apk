package com.tencent.mm.ui.chatting.l.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.widget.MMTextView.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static volatile a GGo;
  private static final ap GGp;
  
  static
  {
    AppMethodBeat.i(36623);
    GGo = null;
    GGp = new ap("AAChattingHelper");
    AppMethodBeat.o(36623);
  }
  
  private a()
  {
    AppMethodBeat.i(185017);
    GGp.setLogging(false);
    AppMethodBeat.o(185017);
  }
  
  public static void a(CharSequence paramCharSequence, bl parambl)
  {
    AppMethodBeat.i(36621);
    a(paramCharSequence, parambl, 1);
    AppMethodBeat.o(36621);
  }
  
  private static void a(CharSequence paramCharSequence, bl parambl, int paramInt)
  {
    AppMethodBeat.i(36620);
    if ((paramCharSequence instanceof Spannable)) {
      GGp.postToWorker(new b(paramCharSequence, parambl, paramInt));
    }
    AppMethodBeat.o(36620);
  }
  
  public static a fat()
  {
    AppMethodBeat.i(36619);
    if (GGo == null) {
      try
      {
        if (GGo == null) {
          GGo = new a();
        }
        a locala1 = GGo;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(36619);
      }
    }
    a locala2 = GGo;
    AppMethodBeat.o(36619);
    return locala2;
  }
  
  public static MMTextView.a fau()
  {
    return a.GGq;
  }
  
  static enum a
    implements MMTextView.a
  {
    static
    {
      AppMethodBeat.i(36616);
      GGq = new a("TEXT_CALLBACK");
      GGr = new a[] { GGq };
      AppMethodBeat.o(36616);
    }
    
    private a() {}
    
    public final void a(CharSequence paramCharSequence, long paramLong)
    {
      AppMethodBeat.i(36615);
      bl localbl = ((k)g.ab(k.class)).cOI().rm(paramLong);
      if (bt.isNullOrNil(localbl.field_talker))
      {
        ad.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
        AppMethodBeat.o(36615);
        return;
      }
      if ((localbl.field_flag & 0x10) == 0)
      {
        a.b(paramCharSequence, localbl);
        AppMethodBeat.o(36615);
        return;
      }
      ad.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(36615);
    }
  }
  
  static final class b
    implements Runnable
  {
    private bl dbD;
    private int scene;
    private CharSequence text;
    
    b(CharSequence paramCharSequence, bl parambl, int paramInt)
    {
      this.text = paramCharSequence;
      this.dbD = parambl;
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
            if ((localObject1 == null) || (!com.tencent.mm.plugin.normsg.a.b.ufs.e(localObject1, o.class))) {
              break label391;
            }
            ((ArrayList)localObject3).add(new a.a((byte)0).a(localObject1, localSpannable));
            break label391;
          }
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
            break label385;
          }
          this.dbD = ((k)g.ab(k.class)).cOI().rm(this.dbD.field_msgId);
          if ((this.dbD != null) && (!bt.isNullOrNil(this.dbD.field_talker)))
          {
            this.dbD.setFlag(this.dbD.field_flag | 0x10);
            ((k)g.ab(k.class)).cOI().a(this.dbD.field_msgId, this.dbD);
          }
          az.arV().aqm().atj();
          az.arV().aqm().b(b.b.gPX);
          localObject1 = ((ArrayList)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label385;
          }
          localObject3 = ((c)((Iterator)localObject1).next()).extInfo;
          com.tencent.mm.plugin.report.service.h.vKh.f(14237, new Object[] { "msg", Long.valueOf(this.dbD.field_msgId), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), localObject3 });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(587L, 0L, 1L, false);
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
          paramSpannable = bt.by(new JSONObject(paramObject.toString()).optString("type"), paramObject.getClass().getName());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.a
 * JD-Core Version:    0.7.0.1
 */