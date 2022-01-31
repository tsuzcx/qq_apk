package com.tencent.mm.plugin.sns.ui.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private static SparseArray<HashMap> slO;
  private static l slP;
  
  static
  {
    AppMethodBeat.i(40419);
    slO = new SparseArray();
    slP = new a.1();
    ((e)g.G(e.class)).addStoryStatusNotifyListener(slP);
    AppMethodBeat.o(40419);
  }
  
  public static void a(int paramInt, String paramString, l paraml)
  {
    AppMethodBeat.i(40416);
    if ((TextUtils.isEmpty(paramString)) || (paraml == null))
    {
      AppMethodBeat.o(40416);
      return;
    }
    HashMap localHashMap = (HashMap)slO.get(paramInt);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      Set localSet = (Set)localHashMap.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(new WeakReference(paraml));
      localHashMap.put(paramString, localObject);
      slO.put(paramInt, localHashMap);
      AppMethodBeat.o(40416);
      return;
    }
  }
  
  public static void b(int paramInt, String paramString, l paraml)
  {
    AppMethodBeat.i(40417);
    if ((TextUtils.isEmpty(paramString)) || (paraml == null))
    {
      AppMethodBeat.o(40417);
      return;
    }
    Object localObject = (HashMap)slO.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(40417);
      return;
    }
    paramString = (Set)((HashMap)localObject).get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(40417);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject = (l)((WeakReference)paramString.next()).get();
      if ((localObject == null) || (localObject.equals(paraml))) {
        paramString.remove();
      }
    }
    AppMethodBeat.o(40417);
  }
  
  public static void cxo()
  {
    AppMethodBeat.i(40418);
    slO.remove(4);
    AppMethodBeat.o(40418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.e.a
 * JD-Core Version:    0.7.0.1
 */