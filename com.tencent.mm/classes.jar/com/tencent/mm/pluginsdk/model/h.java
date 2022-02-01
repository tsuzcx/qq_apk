package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class h
  extends z
{
  private final a XQP;
  private final Intent XQQ;
  private final ae XQR;
  
  public h(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.XQR = new ae();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.XQP = a.XQT;
    }
    while (this.XQP == a.XQT)
    {
      this.XQQ = null;
      AppMethodBeat.o(109457);
      return;
      a locala = a.avE(paramBundle.getInt("key_map_app", a.XQT.code));
      if (a(MMApplicationContext.getContext(), locala, null) == null) {
        this.XQP = a.XQT;
      } else {
        this.XQP = locala;
      }
    }
    this.XQQ = ((Intent)paramBundle.getParcelable("key_target_intent"));
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
    if (Util.isNullOrNil(paramContext))
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
  
  public final String bTD()
  {
    if (this.XQP == a.XQT) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final boolean bpt(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.XQP.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109462);
    paramContext = this.XQR.c(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final String getPackageName()
  {
    return "com.tencent.map";
  }
  
  public final String iHM()
  {
    return null;
  }
  
  public final String iHN()
  {
    if (this.XQP == a.XQT) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final aa.a iHO()
  {
    AppMethodBeat.i(109461);
    if (this.XQP == a.XQT)
    {
      locala = this.XQR.iHO();
      AppMethodBeat.o(109461);
      return locala;
    }
    aa.a locala = new aa.a();
    locala.XRN = -1;
    locala.XRK = -1;
    ResolveInfo localResolveInfo = a(MMApplicationContext.getContext(), this.XQP, this.XQQ);
    if (localResolveInfo != null) {
      locala.XRO = c(MMApplicationContext.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean ln(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.XQP == a.XQT)
    {
      boolean bool = this.XQR.ln(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.XQP, this.XQQ) != null)
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
      XQT = new a("TencentMap", 0, 0);
      XQU = new a("GoogleMap", 1, 1);
      XQV = new a("SogouMap", 2, 2);
      XQW = new a("BaiduMap", 3, 3);
      XQX = new a("AutonaviMap", 4, 4);
      XQY = new a[] { XQT, XQU, XQV, XQW, XQX };
      AppMethodBeat.o(109456);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static a avE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return XQT;
      case 0: 
        return XQT;
      case 1: 
        return XQU;
      case 2: 
        return XQV;
      case 3: 
        return XQW;
      }
      return XQX;
    }
    
    public final String getPackage()
    {
      AppMethodBeat.i(109455);
      switch (h.1.XQS[ordinal()])
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */