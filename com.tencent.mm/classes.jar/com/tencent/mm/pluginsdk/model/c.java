package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class c
  extends s
{
  private final a BOA;
  private final Intent BOB;
  private final x BOC;
  
  public c(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.BOC = new x();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.BOA = a.BOE;
    }
    while (this.BOA == a.BOE)
    {
      this.BOB = null;
      AppMethodBeat.o(109457);
      return;
      a locala = a.Uf(paramBundle.getInt("key_map_app", a.BOE.code));
      if (a(aj.getContext(), locala, null) == null) {
        this.BOA = a.BOE;
      } else {
        this.BOA = locala;
      }
    }
    this.BOB = ((Intent)paramBundle.getParcelable("key_target_intent"));
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
    if (bt.gL(paramContext))
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
    paramContext = this.BOC.a(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final boolean aAD(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.BOA.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String aGz()
  {
    if (this.BOA == a.BOE) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String eve()
  {
    if (this.BOA == a.BOE) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final t.a evf()
  {
    AppMethodBeat.i(109461);
    if (this.BOA == a.BOE)
    {
      locala = this.BOC.evf();
      AppMethodBeat.o(109461);
      return locala;
    }
    t.a locala = new t.a();
    locala.BPp = -1;
    locala.BPm = -1;
    ResolveInfo localResolveInfo = a(aj.getContext(), this.BOA, this.BOB);
    if (localResolveInfo != null) {
      locala.BPq = a(aj.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean gX(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.BOA == a.BOE)
    {
      boolean bool = this.BOC.gX(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.BOA, this.BOB) != null)
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
      BOE = new a("TencentMap", 0, 0);
      BOF = new a("GoogleMap", 1, 1);
      BOG = new a("SogouMap", 2, 2);
      BOH = new a("BaiduMap", 3, 3);
      BOI = new a("AutonaviMap", 4, 4);
      BOJ = new a[] { BOE, BOF, BOG, BOH, BOI };
      AppMethodBeat.o(109456);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static a Uf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return BOE;
      case 0: 
        return BOE;
      case 1: 
        return BOF;
      case 2: 
        return BOG;
      case 3: 
        return BOH;
      }
      return BOI;
    }
    
    public final String getPackage()
    {
      AppMethodBeat.i(109455);
      switch (c.1.BOD[ordinal()])
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