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
  private final x ELA;
  private final c.a ELy;
  private final Intent ELz;
  
  public c(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.ELA = new x();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.ELy = c.a.ELC;
    }
    while (this.ELy == c.a.ELC)
    {
      this.ELz = null;
      AppMethodBeat.o(109457);
      return;
      c.a locala = c.a.Yk(paramBundle.getInt("key_map_app", c.a.ELC.code));
      if (a(aj.getContext(), locala, null) == null) {
        this.ELy = c.a.ELC;
      } else {
        this.ELy = locala;
      }
    }
    this.ELz = ((Intent)paramBundle.getParcelable("key_target_intent"));
    AppMethodBeat.o(109457);
  }
  
  private static ResolveInfo a(Context paramContext, c.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(109458);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F) })));
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    if (bt.hj(paramContext))
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
    paramContext = this.ELA.a(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final boolean aLv(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.ELy.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String aQx()
  {
    if (this.ELy == c.a.ELC) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String eZs()
  {
    if (this.ELy == c.a.ELC) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final t.a eZt()
  {
    AppMethodBeat.i(109461);
    if (this.ELy == c.a.ELC)
    {
      locala = this.ELA.eZt();
      AppMethodBeat.o(109461);
      return locala;
    }
    t.a locala = new t.a();
    locala.EMo = -1;
    locala.EMl = -1;
    ResolveInfo localResolveInfo = a(aj.getContext(), this.ELy, this.ELz);
    if (localResolveInfo != null) {
      locala.EMp = a(aj.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean hn(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.ELy == c.a.ELC)
    {
      boolean bool = this.ELA.hn(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.ELy, this.ELz) != null)
    {
      AppMethodBeat.o(109459);
      return true;
    }
    AppMethodBeat.o(109459);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c
 * JD-Core Version:    0.7.0.1
 */