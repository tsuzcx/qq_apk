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

public final class d
  extends t
{
  private final d.a JUM;
  private final Intent JUN;
  private final y JUO;
  
  public d(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.JUO = new y();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.JUM = d.a.JUQ;
    }
    while (this.JUM == d.a.JUQ)
    {
      this.JUN = null;
      AppMethodBeat.o(109457);
      return;
      d.a locala = d.a.ahC(paramBundle.getInt("key_map_app", d.a.JUQ.code));
      if (a(MMApplicationContext.getContext(), locala, null) == null) {
        this.JUM = d.a.JUQ;
      } else {
        this.JUM = locala;
      }
    }
    this.JUN = ((Intent)paramBundle.getParcelable("key_target_intent"));
    AppMethodBeat.o(109457);
  }
  
  private static ResolveInfo a(Context paramContext, d.a parama, Intent paramIntent)
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
  
  public final boolean bdn(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.JUM.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String blB()
  {
    if (this.JUM == d.a.JUQ) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109462);
    paramContext = this.JUO.c(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final String gmq()
  {
    if (this.JUM == d.a.JUQ) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final u.a gmr()
  {
    AppMethodBeat.i(109461);
    if (this.JUM == d.a.JUQ)
    {
      locala = this.JUO.gmr();
      AppMethodBeat.o(109461);
      return locala;
    }
    u.a locala = new u.a();
    locala.JVD = -1;
    locala.JVA = -1;
    ResolveInfo localResolveInfo = a(MMApplicationContext.getContext(), this.JUM, this.JUN);
    if (localResolveInfo != null) {
      locala.JVE = c(MMApplicationContext.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean in(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.JUM == d.a.JUQ)
    {
      boolean bool = this.JUO.in(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.JUM, this.JUN) != null)
    {
      AppMethodBeat.o(109459);
      return true;
    }
    AppMethodBeat.o(109459);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d
 * JD-Core Version:    0.7.0.1
 */