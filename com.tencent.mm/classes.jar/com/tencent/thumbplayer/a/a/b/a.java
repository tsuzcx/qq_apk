package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

public final class a
{
  private static int[] Keo = new int[0];
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(187752);
    f.i("TPDrmCapability", "TPDrmCapability, init");
    if (!TPNativeLibraryLoader.isLibLoaded())
    {
      AppMethodBeat.o(187752);
      return;
    }
    f.i("TPDrmCapability", "TPDrmCapability, read sp.");
    paramContext = paramContext.getSharedPreferences("DRM_CAP", 0);
    j((HashSet)paramContext.getStringSet("DRM_CAP_LIST", new HashSet()));
    i.getScheduledExecutorServiceInstance().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187750);
        Object localObject = TPThumbplayerCapabilityHelper.getDRMCapabilities();
        f.i("TPDrmCapability", "TPThumbplayerCapabilityHelper, drm cap:" + Arrays.toString((int[])localObject));
        if (localObject.length == 0)
        {
          AppMethodBeat.o(187750);
          return;
        }
        HashSet localHashSet = new HashSet();
        int m = localObject.length;
        int j = 0;
        if (j < m)
        {
          int k = localObject[j];
          int i;
          if (k == 0) {
            i = 0;
          }
          for (;;)
          {
            localHashSet.add(String.valueOf(i));
            j += 1;
            break;
            if (1 == k)
            {
              i = 1;
            }
            else if (2 == k)
            {
              i = 2;
            }
            else
            {
              i = k;
              if (3 == k) {
                i = 3;
              }
            }
          }
        }
        a.k(localHashSet);
        localObject = this.HoF.edit();
        ((SharedPreferences.Editor)localObject).putStringSet("DRM_CAP_LIST", localHashSet);
        ((SharedPreferences.Editor)localObject).apply();
        AppMethodBeat.o(187750);
      }
    });
    AppMethodBeat.o(187752);
  }
  
  private static void j(HashSet<String> paramHashSet)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(187751);
        if ((paramHashSet != null) && (paramHashSet.size() > 0))
        {
          paramHashSet = paramHashSet.toArray();
          Keo = new int[paramHashSet.length];
          i = 0;
          if (i < paramHashSet.length) {
            if ((paramHashSet[i] instanceof String)) {
              Keo[i] = Integer.parseInt((String)paramHashSet[i]);
            } else {
              Keo[i] = -1;
            }
          }
        }
      }
      finally {}
      f.i("TPDrmCapability", "TPDrmCapability, read sp ret:" + Arrays.toString(Keo));
      AppMethodBeat.o(187751);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */