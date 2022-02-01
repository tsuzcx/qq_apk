package com.tencent.mm.smiley;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

public class EmojiHelper
  extends g
{
  private static EmojiHelper acxd;
  private static MMTrimMemoryEventListener acxe;
  private com.tencent.mm.b.f<String, Bitmap> acwQ;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(104917);
    acxe = null;
    AppMethodBeat.o(104917);
  }
  
  private EmojiHelper()
  {
    AppMethodBeat.i(104897);
    this.acwQ = new com.tencent.mm.memory.a.b(200, getClass());
    if (acxe != null) {
      acxe.dead();
    }
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(this);
    acxe = localMMTrimMemoryEventListener;
    localMMTrimMemoryEventListener.alive();
    this.mContext = MMApplicationContext.getContext();
    j.iVg().iUX();
    AppMethodBeat.o(104897);
  }
  
  public static int a(w paramw)
  {
    AppMethodBeat.i(242912);
    j.iVg();
    paramw = j.ayr(paramw.acwN.dIY);
    if (paramw != null)
    {
      int i = paramw.uKG;
      AppMethodBeat.o(242912);
      return i;
    }
    AppMethodBeat.o(242912);
    return 0;
  }
  
  public static Spannable a(Context paramContext, Spannable paramSpannable, int paramInt, PInt paramPInt)
  {
    AppMethodBeat.i(242892);
    j localj = j.iVg();
    s.u(paramContext, "context");
    s.u(paramPInt, "maxNum");
    int i;
    if (paramSpannable == null) {
      i = 0;
    }
    for (;;)
    {
      paramContext = localj.b(paramSpannable, paramInt, paramPInt, 0, i);
      AppMethodBeat.o(242892);
      return paramContext;
      paramContext = paramSpannable.toString();
      if (paramContext == null) {
        i = 0;
      } else {
        i = paramContext.length();
      }
    }
  }
  
  public static Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt)
  {
    AppMethodBeat.i(242896);
    if (paramSpannable == null) {}
    for (int i = 0;; i = paramSpannable.toString().length())
    {
      paramSpannable = j.iVg().b(paramSpannable, paramInt, paramPInt, 0, i);
      AppMethodBeat.o(242896);
      return paramSpannable;
    }
  }
  
  public static Spannable a(Spannable paramSpannable, int paramInt1, PInt paramPInt, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(242898);
    paramSpannable = j.iVg().b(paramSpannable, paramInt1, paramPInt, paramInt2, paramInt3);
    AppMethodBeat.o(242898);
    return paramSpannable;
  }
  
  public static void a(Spannable paramSpannable, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242907);
    paramSpannable.setSpan(new k(paramDrawable, true, paramInt1, paramInt2), paramInt1, paramInt2, 33);
    AppMethodBeat.o(242907);
  }
  
  public static String anH(String paramString)
  {
    AppMethodBeat.i(104908);
    j.iVg();
    s.u(paramString, "content");
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length();
    int m;
    for (int i = 0; i < k; i = Character.charCount(m) + i)
    {
      m = paramString.codePointAt(i);
      Object localObject = j.ayo(m);
      if (localObject != null)
      {
        localObject = ((w)localObject).mdx;
        int n = localObject.length;
        int j = 0;
        while (j < n)
        {
          localStringBuilder.appendCodePoint(localObject[j]);
          j += 1;
        }
      }
      localStringBuilder.appendCodePoint(m);
    }
    paramString = localStringBuilder.toString();
    s.s(paramString, "builder.toString()");
    AppMethodBeat.o(104908);
    return paramString;
  }
  
  public static w ayo(int paramInt)
  {
    AppMethodBeat.i(242911);
    j.iVg();
    w localw = j.ayo(paramInt);
    AppMethodBeat.o(242911);
    return localw;
  }
  
  public static Drawable b(w paramw)
  {
    AppMethodBeat.i(242920);
    j.iVg();
    paramw = j.c(paramw);
    AppMethodBeat.o(242920);
    return paramw;
  }
  
  public static boolean buu(String paramString)
  {
    AppMethodBeat.i(104906);
    j.iVg();
    boolean bool = j.buA(paramString);
    AppMethodBeat.o(104906);
    return bool;
  }
  
  public static String buv(String paramString)
  {
    AppMethodBeat.i(104907);
    j localj = j.iVg();
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(104907);
      return paramString;
    }
    Object localObject1 = e.acxj;
    localObject1 = e.c.acxq;
    if (e.c.iUR().acxn.size() == 0) {
      j.iVf();
    }
    i = paramString.length();
    localObject1 = new StringBuilder();
    ah.d locald = new ah.d();
    Object localObject2 = e.acxj;
    localObject2 = e.c.acxq;
    e.c.iUR().a((CharSequence)paramString, 0, i, (m)new j.g((StringBuilder)localObject1, paramString, locald, localj));
    if (locald.aixb < i) {
      ((StringBuilder)localObject1).append((CharSequence)paramString, locald.aixb, i);
    }
    paramString = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(104907);
    return paramString;
  }
  
  public static w buw(String paramString)
  {
    AppMethodBeat.i(242909);
    j.iVg();
    paramString = j.buz(paramString);
    AppMethodBeat.o(242909);
    return paramString;
  }
  
  public static int getOffset()
  {
    AppMethodBeat.i(242887);
    int i = j.iVg().iVa();
    AppMethodBeat.o(242887);
    return i;
  }
  
  public static EmojiHelper iUM()
  {
    AppMethodBeat.i(104898);
    if (acxd == null) {}
    try
    {
      acxd = new EmojiHelper();
      EmojiHelper localEmojiHelper = acxd;
      AppMethodBeat.o(104898);
      return localEmojiHelper;
    }
    finally
    {
      AppMethodBeat.o(104898);
    }
  }
  
  public static i iUN()
  {
    AppMethodBeat.i(242884);
    i locali = j.iVg().acxG;
    AppMethodBeat.o(242884);
    return locali;
  }
  
  public static Drawable iUO()
  {
    AppMethodBeat.i(242917);
    Object localObject1 = j.iVg();
    Object localObject2 = e.acxj;
    localObject2 = e.c.acxq;
    localObject2 = (p)e.c.iUR().acxm.get(107, null);
    if (localObject2 != null)
    {
      int i = ((p)localObject2).acyu;
      if ((i < ((j)localObject1).acxG.acxC.size()) && (i >= 0))
      {
        localObject2 = (b)((j)localObject1).acxG.acxC.get(i);
        if (localObject2 != null)
        {
          localObject1 = e.acxj;
          localObject1 = e.c.acxq;
          localObject1 = e.c.iUR();
          s.u(localObject2, "dataItem");
          localObject1 = ((e)localObject1).acxp;
          Object localObject3 = ((b)localObject2).acwM;
          s.s(localObject3, "dataItem.codePoints");
          localObject3 = (Iterable)localObject3;
          i = 0;
          localObject3 = ((Iterable)localObject3).iterator();
          Object localObject4;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            localObject4 = (Integer)localObject4;
            if (localObject1 == null)
            {
              localObject1 = null;
              label167:
              localObject1 = (e.b)localObject1;
              if (localObject1 == null) {
                break label277;
              }
              if (i != ((b)localObject2).acwM.size() - 1) {
                break label270;
              }
              localObject1 = ((e.b)localObject1).acwK;
              if (!(localObject1 instanceof w)) {
                break label265;
              }
              localObject1 = (w)localObject1;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label282;
            }
            localObject2 = EmojiDrawableBitmapRepo.acwO;
            localObject2 = EmojiDrawableBitmapRepo.b.acwT;
            localObject1 = EmojiDrawableBitmapRepo.b.iUJ().a((w)localObject1, true);
            AppMethodBeat.o(242917);
            return localObject1;
            localObject1 = ((a)localObject1).acwL;
            s.s(localObject4, "codePoint");
            localObject1 = (a)((SparseArray)localObject1).get(((Integer)localObject4).intValue(), null);
            break label167;
            label265:
            localObject1 = null;
            continue;
            label270:
            i += 1;
            break;
            label277:
            localObject1 = null;
          }
        }
      }
    }
    label282:
    AppMethodBeat.o(242917);
    return null;
  }
  
  public static long iUP()
  {
    AppMethodBeat.i(242926);
    long l = j.iVg().iVb();
    AppMethodBeat.o(242926);
    return l;
  }
  
  public static w nS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242910);
    j.iVg();
    w localw = j.nS(paramInt1, paramInt2);
    AppMethodBeat.o(242910);
    return localw;
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<EmojiHelper> nph;
    
    public MMTrimMemoryEventListener(EmojiHelper paramEmojiHelper)
    {
      super();
      AppMethodBeat.i(242792);
      this.nph = new WeakReference(paramEmojiHelper);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(242792);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.EmojiHelper
 * JD-Core Version:    0.7.0.1
 */