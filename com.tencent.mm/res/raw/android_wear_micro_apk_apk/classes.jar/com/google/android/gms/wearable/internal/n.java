package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.l;
import com.google.android.gms.wearable.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class n
  implements l
{
  private Uri IG;
  private byte[] Sh;
  private Map<String, m> Tk;
  
  public n(l paraml)
  {
    this.IG = paraml.getUri();
    this.Sh = paraml.getData();
    HashMap localHashMap = new HashMap();
    paraml = paraml.kv().entrySet().iterator();
    while (paraml.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paraml.next();
      if (localEntry.getKey() != null) {
        localHashMap.put((String)localEntry.getKey(), (m)((m)localEntry.getValue()).freeze());
      }
    }
    this.Tk = Collections.unmodifiableMap(localHashMap);
  }
  
  public final byte[] getData()
  {
    return this.Sh;
  }
  
  public final Uri getUri()
  {
    return this.IG;
  }
  
  public final Map<String, m> kv()
  {
    return this.Tk;
  }
  
  public final String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    Object localObject1 = String.valueOf(this.IG);
    localStringBuilder.append(String.valueOf(localObject1).length() + 4 + "uri=" + (String)localObject1);
    if (this.Sh == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(this.Sh.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = this.Tk.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!bool) || (this.Tk.isEmpty())) {
        break label332;
      }
      localStringBuilder.append(", assets=[");
      Iterator localIterator = this.Tk.entrySet().iterator();
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = ", ")
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = String.valueOf(((m)((Map.Entry)localObject2).getValue()).getId());
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject2).length() + (String)localObject1 + str + ": " + (String)localObject2);
      }
    }
    localStringBuilder.append("]");
    label332:
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.n
 * JD-Core Version:    0.7.0.1
 */