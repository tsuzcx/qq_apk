package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class c
  extends s
{
  private final a DgO;
  private final Intent DgP;
  private final x DgQ;
  
  public c(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.DgQ = new x();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.DgO = a.DgS;
    }
    while (this.DgO == a.DgS)
    {
      this.DgP = null;
      AppMethodBeat.o(109457);
      return;
      a locala = a.Wp(paramBundle.getInt("key_map_app", a.DgS.code));
      if (a(ai.getContext(), locala, null) == null) {
        this.DgO = a.DgS;
      } else {
        this.DgO = locala;
      }
    }
    this.DgP = ((Intent)paramBundle.getParcelable("key_target_intent"));
    AppMethodBeat.o(109457);
  }
  
  private static ResolveInfo a(Context paramContext, a parama, Intent paramIntent)
  {
    AppMethodBeat.i(109458);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F) })));
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    if (bs.gY(paramContext))
    {
      AppMethodBeat.o(109458);
      return null;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramIntent = (ResolveInfo)paramContext.next();
      if ((paramIntent != null) && (paramIntent.activityInfo != null) && (parama.getPackage().equals(paramIntent.activityInfo.packageName)))
      {
        AppMethodBeat.o(109458);
        return paramIntent;
      }
    }
    AppMethodBeat.o(109458);
    return null;
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109462);
    paramContext = this.DgQ.a(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final boolean aFV(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.DgO.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String aNm()
  {
    if (this.DgO == a.DgS) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String eKy()
  {
    if (this.DgO == a.DgS) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final t.a eKz()
  {
    AppMethodBeat.i(109461);
    if (this.DgO == a.DgS)
    {
      locala = this.DgQ.eKz();
      AppMethodBeat.o(109461);
      return locala;
    }
    t.a locala = new t.a();
    locala.DhD = -1;
    locala.DhA = -1;
    ResolveInfo localResolveInfo = a(ai.getContext(), this.DgO, this.DgP);
    if (localResolveInfo != null) {
      locala.DhE = a(ai.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean hi(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.DgO == a.DgS)
    {
      boolean bool = this.DgQ.hi(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.DgO, this.DgP) != null)
    {
      AppMethodBeat.o(109459);
      return true;
    }
    AppMethodBeat.o(109459);
    return false;
  }
  
  public static enum a
  {
    public final int code;
    
    static
    {
      AppMethodBeat.i(109456);
      DgS = new a("TencentMap", 0, 0);
      DgT = new a("GoogleMap", 1, 1);
      DgU = new a("SogouMap", 2, 2);
      DgV = new a("BaiduMap", 3, 3);
      DgW = new a("AutonaviMap", 4, 4);
      DgX = new a[] { DgS, DgT, DgU, DgV, DgW };
      AppMethodBeat.o(109456);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static a Wp(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return DgS;
      case 0: 
        return DgS;
      case 1: 
        return DgT;
      case 2: 
        return DgU;
      case 3: 
        return DgV;
      }
      return DgW;
    }
    
    public final String getPackage()
    {
      AppMethodBeat.i(109455);
      switch (c.1.DgR[ordinal()])
      {
      default: 
        AppMethodBeat.o(109455);
        return "com.tencent.map";
      case 1: 
        AppMethodBeat.o(109455);
        return "com.tencent.map";
      case 2: 
        AppMethodBeat.o(109455);
        return "com.google.android.apps.maps";
      case 3: 
        AppMethodBeat.o(109455);
        return "com.sogou.map.android.maps";
      case 4: 
        AppMethodBeat.o(109455);
        return "com.baidu.BaiduMap";
      }
      AppMethodBeat.o(109455);
      return "com.autonavi.minimap";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c
 * JD-Core Version:    0.7.0.1
 */