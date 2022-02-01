package com.tencent.mm.plugin.sns.ad.widget.living;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.protocal.protobuf.bz;
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
  static volatile b DAI;
  private final Map<String, Integer> DAJ;
  private final Map<String, WeakReference<a>> DAK;
  
  public b()
  {
    AppMethodBeat.i(202425);
    this.DAJ = new ArrayMap();
    this.DAK = new ArrayMap();
    AppMethodBeat.o(202425);
  }
  
  public static int C(String paramString, List<bz> paramList)
  {
    AppMethodBeat.i(202431);
    try
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (bz)localIterator.next();
      } while (paramList.pTI != 2);
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
      i = aNU(paramList.data);
      Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + paramString + ", the living status is " + i);
      eYv().ft(paramString, i);
      AppMethodBeat.o(202431);
      return i;
    }
    Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + paramString + " and the living item is null!!");
    AppMethodBeat.o(202431);
    return 0;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(202432);
    label339:
    label345:
    label352:
    label355:
    for (;;)
    {
      int i;
      try
      {
        localb = eYv();
        l = SystemClock.elapsedRealtimeNanos();
        if ((parama != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject1 = (WeakReference)localb.DAK.get(paramString);
          if ((localObject1 == null) || (parama != ((WeakReference)localObject1).get())) {
            break label352;
          }
          i = 1;
          break label345;
        }
        Log.i("SnsAd.LivingStatusManager", "the input sns id or listener is invalid, or there is same key-value of them.");
        AppMethodBeat.o(202432);
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
        AppMethodBeat.o(202432);
        return;
      }
      bool = c.aI(localb.DAK);
      if (bool)
      {
        try
        {
          localObject1 = localb.DAK.entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localEntry = (Map.Entry)((Iterator)localObject1).next();
            if ((localEntry != null) && (localEntry.getValue() != null) && (((WeakReference)localEntry.getValue()).get() != null)) {
              continue;
            }
            ((Iterator)localObject1).remove();
            continue;
          }
          if (c.isEmpty(localb.DAK)) {
            continue;
          }
        }
        catch (Throwable localThrowable) {}
      }
      else
      {
        localObject2 = localb.DAK.entrySet().iterator();
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
          localb.DAK.remove(localObject2);
        }
      }
      localb.DAK.put(paramString, new WeakReference(parama));
      Log.d("SnsAd.LivingStatusManager", "addStatusChangedListener new take times is " + (SystemClock.elapsedRealtimeNanos() - l) + "ns");
      AppMethodBeat.o(202432);
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
  
  private static int aNU(String paramString)
  {
    AppMethodBeat.i(202428);
    try
    {
      int i = new JSONObject(paramString).optInt("liveStatus", 0);
      AppMethodBeat.o(202428);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202428);
    }
    return 0;
  }
  
  private static b eYv()
  {
    AppMethodBeat.i(202426);
    if (DAI == null) {}
    try
    {
      if (DAI == null) {
        DAI = new b();
      }
      b localb = DAI;
      AppMethodBeat.o(202426);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(202426);
    }
  }
  
  private void ft(String paramString, int paramInt)
  {
    AppMethodBeat.i(202427);
    Integer localInteger = (Integer)this.DAJ.put(paramString, Integer.valueOf(paramInt));
    if ((localInteger == null) || (!localInteger.equals(Integer.valueOf(paramInt))))
    {
      Object localObject = (WeakReference)this.DAK.get(paramString);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (localInteger != null) {
            localInteger.intValue();
          }
          ((a)localObject).fw(paramString, paramInt);
        }
      }
    }
    AppMethodBeat.o(202427);
  }
  
  public static int fu(String paramString, int paramInt)
  {
    AppMethodBeat.i(202429);
    try
    {
      paramString = (Integer)eYv().DAJ.get(paramString);
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
        AppMethodBeat.o(202429);
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
      AppMethodBeat.o(202429);
    }
  }
  
  public static void fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(202430);
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        eYv().ft(paramString, paramInt);
      }
      AppMethodBeat.o(202430);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202430);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fw(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.b
 * JD-Core Version:    0.7.0.1
 */