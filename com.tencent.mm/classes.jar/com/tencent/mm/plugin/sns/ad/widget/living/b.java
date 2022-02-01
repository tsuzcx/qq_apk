package com.tencent.mm.plugin.sns.ad.widget.living;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class b
{
  static volatile b JMv;
  private final Map<String, Integer> JMw;
  private final Map<String, WeakReference<a>> JMx;
  
  public b()
  {
    AppMethodBeat.i(218716);
    this.JMw = new ArrayMap();
    this.JMx = new ArrayMap();
    AppMethodBeat.o(218716);
  }
  
  public static int C(String paramString, List<bx> paramList)
  {
    AppMethodBeat.i(218730);
    try
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (bx)localIterator.next();
      } while (paramList.tpK != 2);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int i;
        continue;
        paramList = null;
      }
    }
    if (paramList != null)
    {
      i = aYM(paramList.data);
      Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + paramString + ", the living status is " + i);
      fMf().fW(paramString, i);
      AppMethodBeat.o(218730);
      return i;
    }
    Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + paramString + " and the living item is null!!");
    AppMethodBeat.o(218730);
    return 0;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(218732);
    label339:
    label345:
    label352:
    label355:
    for (;;)
    {
      int i;
      try
      {
        localb = fMf();
        l = SystemClock.elapsedRealtimeNanos();
        if ((parama != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject1 = (WeakReference)localb.JMx.get(paramString);
          if ((localObject1 == null) || (parama != ((WeakReference)localObject1).get())) {
            break label352;
          }
          i = 1;
          break label345;
        }
        Log.i("SnsAd.LivingStatusManager", "the input sns id or listener is invalid, or there is same key-value of them.");
        AppMethodBeat.o(218732);
        return;
      }
      catch (Throwable paramString)
      {
        b localb;
        long l;
        Object localObject1;
        boolean bool;
        Map.Entry localEntry;
        WeakReference localWeakReference;
        AppMethodBeat.o(218732);
        return;
      }
      bool = d.aC(localb.JMx);
      if (bool)
      {
        try
        {
          localObject1 = localb.JMx.entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localEntry = (Map.Entry)((Iterator)localObject1).next();
            if ((localEntry != null) && (localEntry.getValue() != null) && (((WeakReference)localEntry.getValue()).get() != null)) {
              continue;
            }
            ((Iterator)localObject1).remove();
            continue;
          }
          if (d.isEmpty(localb.JMx)) {
            continue;
          }
        }
        catch (Throwable localThrowable) {}
      }
      else
      {
        localObject2 = localb.JMx.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label339;
        }
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        localWeakReference = (WeakReference)localEntry.getValue();
        if ((localWeakReference == null) || (localWeakReference.get() != parama)) {
          continue;
        }
        localObject2 = (String)localEntry.getKey();
        if (localObject2 != null) {
          localb.JMx.remove(localObject2);
        }
      }
      localb.JMx.put(paramString, new WeakReference(parama));
      Log.d("SnsAd.LivingStatusManager", "addStatusChangedListener new take times is " + (SystemClock.elapsedRealtimeNanos() - l) + "ns");
      AppMethodBeat.o(218732);
      return;
      Object localObject2 = null;
      continue;
      for (;;)
      {
        if (i == 0) {
          break label355;
        }
        break;
        i = 0;
      }
    }
  }
  
  private static int aYM(String paramString)
  {
    AppMethodBeat.i(218724);
    try
    {
      int i = new JSONObject(paramString).optInt("liveStatus", 0);
      AppMethodBeat.o(218724);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(218724);
    }
    return 0;
  }
  
  private static b fMf()
  {
    AppMethodBeat.i(218720);
    if (JMv == null) {}
    try
    {
      if (JMv == null) {
        JMv = new b();
      }
      b localb = JMv;
      AppMethodBeat.o(218720);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(218720);
    }
  }
  
  private void fW(String paramString, int paramInt)
  {
    AppMethodBeat.i(218723);
    Integer localInteger = (Integer)this.JMw.put(paramString, Integer.valueOf(paramInt));
    if ((localInteger == null) || (!localInteger.equals(Integer.valueOf(paramInt))))
    {
      Object localObject = (WeakReference)this.JMx.get(paramString);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (localInteger != null) {
            localInteger.intValue();
          }
          ((a)localObject).fZ(paramString, paramInt);
        }
      }
    }
    AppMethodBeat.o(218723);
  }
  
  public static int fX(String paramString, int paramInt)
  {
    AppMethodBeat.i(218726);
    try
    {
      paramString = (Integer)fMf().JMw.get(paramString);
      int i;
      int j;
      if (paramString != null)
      {
        i = paramString.intValue();
        j = i;
        if (i == 0)
        {
          if (paramInt != 1) {
            break label57;
          }
          j = 257;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(218726);
        return j;
        i = 0;
        break;
        label57:
        j = i;
        if (paramInt == 2) {
          j = 770;
        }
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(218726);
    }
  }
  
  public static void fY(String paramString, int paramInt)
  {
    AppMethodBeat.i(218727);
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        fMf().fW(paramString, paramInt);
      }
      AppMethodBeat.o(218727);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(218727);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fZ(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.b
 * JD-Core Version:    0.7.0.1
 */