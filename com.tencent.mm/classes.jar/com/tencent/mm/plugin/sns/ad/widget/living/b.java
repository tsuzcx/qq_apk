package com.tencent.mm.plugin.sns.ad.widget.living;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.protocal.protobuf.ch;
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
  static volatile b QgY;
  private final Map<String, Integer> QgZ;
  private final Map<String, WeakReference<a>> Qha;
  
  public b()
  {
    AppMethodBeat.i(310370);
    this.QgZ = new ArrayMap();
    this.Qha = new ArrayMap();
    AppMethodBeat.o(310370);
  }
  
  public static int I(String paramString, List<ch> paramList)
  {
    AppMethodBeat.i(310427);
    try
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (ch)localIterator.next();
      } while (paramList.wuj != 2);
    }
    finally
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
      i = aWU(paramList.data);
      Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + paramString + ", the living status is " + i);
      hdb().gP(paramString, i);
      AppMethodBeat.o(310427);
      return i;
    }
    Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + paramString + " and the living item is null!!");
    AppMethodBeat.o(310427);
    return 0;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(310441);
    label339:
    label345:
    label352:
    label355:
    for (;;)
    {
      int i;
      try
      {
        localb = hdb();
        l = SystemClock.elapsedRealtimeNanos();
        if ((parama != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject1 = (WeakReference)localb.Qha.get(paramString);
          if ((localObject1 == null) || (parama != ((WeakReference)localObject1).get())) {
            break label352;
          }
          i = 1;
          break label345;
        }
        Log.i("SnsAd.LivingStatusManager", "the input sns id or listener is invalid, or there is same key-value of them.");
      }
      finally
      {
        b localb;
        long l;
        Object localObject1;
        boolean bool;
        Map.Entry localEntry;
        WeakReference localWeakReference;
        AppMethodBeat.o(310441);
        return;
      }
      bool = d.aT(localb.Qha);
      if (bool)
      {
        try
        {
          localObject1 = localb.Qha.entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localEntry = (Map.Entry)((Iterator)localObject1).next();
            if ((localEntry != null) && (localEntry.getValue() != null) && (((WeakReference)localEntry.getValue()).get() != null)) {
              continue;
            }
            ((Iterator)localObject1).remove();
            continue;
          }
          if (d.isEmpty(localb.Qha)) {
            continue;
          }
        }
        finally {}
      }
      else
      {
        localObject3 = localb.Qha.entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label339;
        }
        localEntry = (Map.Entry)((Iterator)localObject3).next();
        localWeakReference = (WeakReference)localEntry.getValue();
        if ((localWeakReference == null) || (localWeakReference.get() != parama)) {
          continue;
        }
        localObject3 = (String)localEntry.getKey();
        if (localObject3 != null) {
          localb.Qha.remove(localObject3);
        }
      }
      localb.Qha.put(paramString, new WeakReference(parama));
      Log.d("SnsAd.LivingStatusManager", "addStatusChangedListener new take times is " + (SystemClock.elapsedRealtimeNanos() - l) + "ns");
      AppMethodBeat.o(310441);
      return;
      Object localObject3 = null;
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
  
  private static int aWU(String paramString)
  {
    AppMethodBeat.i(310393);
    try
    {
      int i = new JSONObject(paramString).optInt("liveStatus", 0);
      return i;
    }
    finally
    {
      AppMethodBeat.o(310393);
    }
    return 0;
  }
  
  private void gP(String paramString, int paramInt)
  {
    AppMethodBeat.i(310386);
    Integer localInteger = (Integer)this.QgZ.put(paramString, Integer.valueOf(paramInt));
    if ((localInteger == null) || (!localInteger.equals(Integer.valueOf(paramInt))))
    {
      Object localObject = (WeakReference)this.Qha.get(paramString);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (localInteger != null) {
            localInteger.intValue();
          }
          ((a)localObject).gS(paramString, paramInt);
        }
      }
    }
    AppMethodBeat.o(310386);
  }
  
  public static int gQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(310403);
    try
    {
      paramString = (Integer)hdb().QgZ.get(paramString);
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
    finally
    {
      AppMethodBeat.o(310403);
    }
  }
  
  public static void gR(String paramString, int paramInt)
  {
    AppMethodBeat.i(310413);
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        hdb().gP(paramString, paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310413);
    }
  }
  
  private static b hdb()
  {
    AppMethodBeat.i(310379);
    if (QgY == null) {}
    try
    {
      if (QgY == null) {
        QgY = new b();
      }
      b localb = QgY;
      AppMethodBeat.o(310379);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(310379);
    }
  }
  
  public static abstract interface a
  {
    public abstract void gS(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.b
 * JD-Core Version:    0.7.0.1
 */