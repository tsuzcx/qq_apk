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

public final class f
  extends x
{
  private final a QUU;
  private final Intent QUV;
  private final ac QUW;
  
  public f(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.QUW = new ac();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.QUU = a.QUY;
    }
    while (this.QUU == a.QUY)
    {
      this.QUV = null;
      AppMethodBeat.o(109457);
      return;
      a locala = a.apB(paramBundle.getInt("key_map_app", a.QUY.code));
      if (a(MMApplicationContext.getContext(), locala, null) == null) {
        this.QUU = a.QUY;
      } else {
        this.QUU = locala;
      }
    }
    this.QUV = ((Intent)paramBundle.getParcelable("key_target_intent"));
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
  
  public final boolean bpD(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.QUU.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String bvr()
  {
    if (this.QUU == a.QUY) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109462);
    paramContext = this.QUW.c(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final String getPackageName()
  {
    return "com.tencent.map";
  }
  
  public final String hgO()
  {
    if (this.QUU == a.QUY) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final y.a hgP()
  {
    AppMethodBeat.i(109461);
    if (this.QUU == a.QUY)
    {
      locala = this.QUW.hgP();
      AppMethodBeat.o(109461);
      return locala;
    }
    y.a locala = new y.a();
    locala.QVQ = -1;
    locala.QVN = -1;
    ResolveInfo localResolveInfo = a(MMApplicationContext.getContext(), this.QUU, this.QUV);
    if (localResolveInfo != null) {
      locala.QVR = c(MMApplicationContext.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean jq(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.QUU == a.QUY)
    {
      boolean bool = this.QUW.jq(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.QUU, this.QUV) != null)
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
      QUY = new a("TencentMap", 0, 0);
      QUZ = new a("GoogleMap", 1, 1);
      QVa = new a("SogouMap", 2, 2);
      QVb = new a("BaiduMap", 3, 3);
      QVc = new a("AutonaviMap", 4, 4);
      QVd = new a[] { QUY, QUZ, QVa, QVb, QVc };
      AppMethodBeat.o(109456);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
    
    public static a apB(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return QUY;
      case 0: 
        return QUY;
      case 1: 
        return QUZ;
      case 2: 
        return QVa;
      case 3: 
        return QVb;
      }
      return QVc;
    }
    
    public final String getPackage()
    {
      AppMethodBeat.i(109455);
      switch (f.1.QUX[ordinal()])
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.f
 * JD-Core Version:    0.7.0.1
 */