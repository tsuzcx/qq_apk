package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

public final class a
  extends r
{
  private final a.a rSY;
  private final Intent rSZ;
  private final w rTa = new w();
  
  public a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.rSY = a.a.rTc;
    }
    while (this.rSY == a.a.rTc)
    {
      this.rSZ = null;
      return;
      a.a locala = a.a.DB(paramBundle.getInt("key_map_app", a.a.rTc.code));
      if (a(ae.getContext(), locala, null) == null) {
        this.rSY = a.a.rTc;
      } else {
        this.rSY = locala;
      }
    }
    this.rSZ = ((Intent)paramBundle.getParcelable("key_target_intent"));
  }
  
  private static ResolveInfo a(Context paramContext, a.a parama, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F) })));
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    if (bk.dk(paramContext)) {
      return null;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramIntent = (ResolveInfo)paramContext.next();
      if ((paramIntent != null) && (paramIntent.activityInfo != null) && (parama.getPackage().equals(paramIntent.activityInfo.packageName))) {
        return paramIntent;
      }
    }
    return null;
  }
  
  public final String UP()
  {
    if (this.rSY == a.a.rTc) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final boolean VJ(String paramString)
  {
    return this.rSY.getPackage().equals(paramString);
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    return this.rTa.a(paramContext, paramResolveInfo);
  }
  
  public final String cks()
  {
    if (this.rSY == a.a.rTc) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final s.a ckt()
  {
    Object localObject;
    if (this.rSY == a.a.rTc) {
      localObject = this.rTa.ckt();
    }
    s.a locala;
    ResolveInfo localResolveInfo;
    do
    {
      return localObject;
      locala = new s.a();
      locala.rTO = -1;
      locala.rTL = -1;
      localResolveInfo = a(ae.getContext(), this.rSY, this.rSZ);
      localObject = locala;
    } while (localResolveInfo == null);
    locala.rTP = a(ae.getContext(), localResolveInfo);
    return locala;
  }
  
  public final boolean eL(Context paramContext)
  {
    if (this.rSY == a.a.rTc) {
      return this.rTa.eL(paramContext);
    }
    return a(paramContext, this.rSY, this.rSZ) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a
 * JD-Core Version:    0.7.0.1
 */