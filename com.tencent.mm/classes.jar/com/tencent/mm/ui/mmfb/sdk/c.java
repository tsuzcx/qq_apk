package com.tencent.mm.ui.mmfb.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static final String[] afyH = { "com.android.chrome", "com.chrome.beta", "com.chrome.dev" };
  
  public static String jBP()
  {
    AppMethodBeat.i(250204);
    Object localObject1 = MMApplicationContext.getContext().getApplicationContext();
    Object localObject2 = new Intent("android.support.customtabs.action.CustomTabsService");
    localObject2 = ((Context)localObject1).getPackageManager().queryIntentServices((Intent)localObject2, 0);
    if (localObject2 != null)
    {
      localObject1 = new HashSet(Arrays.asList(afyH));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ServiceInfo localServiceInfo = ((ResolveInfo)((Iterator)localObject2).next()).serviceInfo;
        if ((localServiceInfo != null) && (((Set)localObject1).contains(localServiceInfo.packageName)))
        {
          localObject1 = localServiceInfo.packageName;
          AppMethodBeat.o(250204);
          return localObject1;
        }
      }
    }
    AppMethodBeat.o(250204);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.c
 * JD-Core Version:    0.7.0.1
 */