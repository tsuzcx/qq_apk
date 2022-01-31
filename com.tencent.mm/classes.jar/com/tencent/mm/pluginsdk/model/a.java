package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class a
  extends q
{
  private final a.a vJW;
  private final Intent vJX;
  private final v vJY;
  
  public a(Bundle paramBundle)
  {
    AppMethodBeat.i(125813);
    this.vJY = new v();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.vJW = a.a.vKa;
    }
    while (this.vJW == a.a.vKa)
    {
      this.vJX = null;
      AppMethodBeat.o(125813);
      return;
      a.a locala = a.a.Lt(paramBundle.getInt("key_map_app", a.a.vKa.code));
      if (a(ah.getContext(), locala, null) == null) {
        this.vJW = a.a.vKa;
      } else {
        this.vJW = locala;
      }
    }
    this.vJX = ((Intent)paramBundle.getParcelable("key_target_intent"));
    AppMethodBeat.o(125813);
  }
  
  private static ResolveInfo a(Context paramContext, a.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(125814);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F) })));
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    if (bo.es(paramContext))
    {
      AppMethodBeat.o(125814);
      return null;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramIntent = (ResolveInfo)paramContext.next();
      if ((paramIntent != null) && (paramIntent.activityInfo != null) && (parama.getPackage().equals(paramIntent.activityInfo.packageName)))
      {
        AppMethodBeat.o(125814);
        return paramIntent;
      }
    }
    AppMethodBeat.o(125814);
    return null;
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(125818);
    paramContext = this.vJY.a(paramContext, paramResolveInfo);
    AppMethodBeat.o(125818);
    return paramContext;
  }
  
  public final boolean alg(String paramString)
  {
    AppMethodBeat.i(125816);
    boolean bool = this.vJW.getPackage().equals(paramString);
    AppMethodBeat.o(125816);
    return bool;
  }
  
  public final String aoo()
  {
    if (this.vJW == a.a.vKa) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String dkX()
  {
    if (this.vJW == a.a.vKa) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final r.a dkY()
  {
    AppMethodBeat.i(125817);
    if (this.vJW == a.a.vKa)
    {
      locala = this.vJY.dkY();
      AppMethodBeat.o(125817);
      return locala;
    }
    r.a locala = new r.a();
    locala.vKL = -1;
    locala.vKI = -1;
    ResolveInfo localResolveInfo = a(ah.getContext(), this.vJW, this.vJX);
    if (localResolveInfo != null) {
      locala.vKM = a(ah.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(125817);
    return locala;
  }
  
  public final boolean fL(Context paramContext)
  {
    AppMethodBeat.i(125815);
    if (this.vJW == a.a.vKa)
    {
      boolean bool = this.vJY.fL(paramContext);
      AppMethodBeat.o(125815);
      return bool;
    }
    if (a(paramContext, this.vJW, this.vJX) != null)
    {
      AppMethodBeat.o(125815);
      return true;
    }
    AppMethodBeat.o(125815);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a
 * JD-Core Version:    0.7.0.1
 */