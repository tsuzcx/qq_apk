package com.tencent.mm.plugin.sns.ui.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private static SparseArray<HashMap> FcR;
  private static m FcS;
  
  static
  {
    AppMethodBeat.i(100382);
    FcR = new SparseArray();
    FcS = new m()
    {
      public final void cr(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(100378);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100377);
            int i = 0;
            while (i < a.fkL().size())
            {
              Object localObject = (Set)((HashMap)a.fkL().valueAt(i)).get(paramAnonymousString);
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
                  localm.cr(paramAnonymousString, paramAnonymousBoolean);
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
    ((e)g.ah(e.class)).addStoryStatusNotifyListener(FcS);
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
    HashMap localHashMap = (HashMap)FcR.get(paramInt);
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
      FcR.put(paramInt, localHashMap);
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
    Object localObject = (HashMap)FcR.get(paramInt);
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
  
  public static void fkK()
  {
    AppMethodBeat.i(100381);
    FcR.remove(4);
    AppMethodBeat.o(100381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.e.a
 * JD-Core Version:    0.7.0.1
 */