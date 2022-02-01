package com.tencent.mm.plugin.sns.ui.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.sdk.platformtools.ar;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private static SparseArray<HashMap> ASk;
  private static m ASl;
  
  static
  {
    AppMethodBeat.i(100382);
    ASk = new SparseArray();
    ASl = new m()
    {
      public final void bZ(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(100378);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100377);
            int i = 0;
            while (i < a.eik().size())
            {
              Object localObject = (Set)((HashMap)a.eik().valueAt(i)).get(paramAnonymousString);
              if ((localObject == null) || (((Set)localObject).size() == 0))
              {
                AppMethodBeat.o(100377);
                return;
              }
              localObject = ((Set)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                m localm = (m)((WeakReference)((Iterator)localObject).next()).get();
                if (localm != null) {
                  localm.bZ(paramAnonymousString, paramAnonymousBoolean);
                }
              }
              i += 1;
            }
            AppMethodBeat.o(100377);
          }
        });
        AppMethodBeat.o(100378);
      }
    };
    ((e)g.ad(e.class)).addStoryStatusNotifyListener(ASl);
    AppMethodBeat.o(100382);
  }
  
  public static void a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(100379);
    if ((TextUtils.isEmpty(paramString)) || (paramm == null))
    {
      AppMethodBeat.o(100379);
      return;
    }
    HashMap localHashMap = (HashMap)ASk.get(paramInt);
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
      ((Set)localObject).add(new WeakReference(paramm));
      localHashMap.put(paramString, localObject);
      ASk.put(paramInt, localHashMap);
      AppMethodBeat.o(100379);
      return;
    }
  }
  
  public static void b(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(100380);
    if ((TextUtils.isEmpty(paramString)) || (paramm == null))
    {
      AppMethodBeat.o(100380);
      return;
    }
    Object localObject = (HashMap)ASk.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(100380);
      return;
    }
    paramString = (Set)((HashMap)localObject).get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(100380);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject = (m)((WeakReference)paramString.next()).get();
      if ((localObject == null) || (localObject.equals(paramm))) {
        paramString.remove();
      }
    }
    AppMethodBeat.o(100380);
  }
  
  public static void eij()
  {
    AppMethodBeat.i(100381);
    ASk.remove(4);
    AppMethodBeat.o(100381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.e.a
 * JD-Core Version:    0.7.0.1
 */