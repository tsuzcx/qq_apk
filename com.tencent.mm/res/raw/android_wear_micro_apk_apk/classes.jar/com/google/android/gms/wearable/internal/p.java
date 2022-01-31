package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class p
  extends g
  implements l
{
  private final int Tj;
  
  public p(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Tj = paramInt2;
  }
  
  public final byte[] getData()
  {
    return getByteArray("data");
  }
  
  public final Uri getUri()
  {
    return Uri.parse(getString("path"));
  }
  
  public final Map<String, com.google.android.gms.wearable.m> kv()
  {
    HashMap localHashMap = new HashMap(this.Tj);
    int i = 0;
    while (i < this.Tj)
    {
      m localm = new m(this.Ia, this.Iu + i);
      if (localm.kw() != null) {
        localHashMap.put(localm.kw(), localm);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public final String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    Object localObject1 = getByteArray("data");
    Object localObject2 = kv();
    StringBuilder localStringBuilder = new StringBuilder("DataItemInternal{ ");
    String str = String.valueOf(getUri());
    localStringBuilder.append(String.valueOf(str).length() + 4 + "uri=" + str);
    if (localObject1 == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(localObject1.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = ((Map)localObject2).size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!bool) || (((Map)localObject2).isEmpty())) {
        break label336;
      }
      localStringBuilder.append(", assets=[");
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ", ")
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = String.valueOf(((com.google.android.gms.wearable.m)((Map.Entry)localObject3).getValue()).getId());
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject3).length() + (String)localObject1 + str + ": " + (String)localObject3);
      }
    }
    localStringBuilder.append("]");
    label336:
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.p
 * JD-Core Version:    0.7.0.1
 */