package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public final class c
  extends s
{
  private final c.a FdW;
  private final Intent FdX;
  private final x FdY;
  
  public c(Bundle paramBundle)
  {
    AppMethodBeat.i(109457);
    this.FdY = new x();
    if ((paramBundle == null) || (paramBundle.getParcelable("key_target_intent") == null)) {
      this.FdW = c.a.Fea;
    }
    while (this.FdW == c.a.Fea)
    {
      this.FdX = null;
      AppMethodBeat.o(109457);
      return;
      c.a locala = c.a.YQ(paramBundle.getInt("key_map_app", c.a.Fea.code));
      if (a(ak.getContext(), locala, null) == null) {
        this.FdW = c.a.Fea;
      } else {
        this.FdW = locala;
      }
    }
    this.FdX = ((Intent)paramBundle.getParcelable("key_target_intent"));
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
    if (bu.ht(paramContext))
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
    paramContext = this.FdY.a(paramContext, paramResolveInfo);
    AppMethodBeat.o(109462);
    return paramContext;
  }
  
  public final boolean aMR(String paramString)
  {
    AppMethodBeat.i(109460);
    boolean bool = this.FdW.getPackage().equals(paramString);
    AppMethodBeat.o(109460);
    return bool;
  }
  
  public final String aQW()
  {
    if (this.FdW == c.a.Fea) {
      return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }
    return null;
  }
  
  public final String fdg()
  {
    if (this.FdW == c.a.Fea) {
      return "TencentMap.apk";
    }
    return null;
  }
  
  public final t.a fdh()
  {
    AppMethodBeat.i(109461);
    if (this.FdW == c.a.Fea)
    {
      locala = this.FdY.fdh();
      AppMethodBeat.o(109461);
      return locala;
    }
    t.a locala = new t.a();
    locala.FeM = -1;
    locala.FeJ = -1;
    ResolveInfo localResolveInfo = a(ak.getContext(), this.FdW, this.FdX);
    if (localResolveInfo != null) {
      locala.FeN = a(ak.getContext(), localResolveInfo);
    }
    AppMethodBeat.o(109461);
    return locala;
  }
  
  public final boolean ht(Context paramContext)
  {
    AppMethodBeat.i(109459);
    if (this.FdW == c.a.Fea)
    {
      boolean bool = this.FdY.ht(paramContext);
      AppMethodBeat.o(109459);
      return bool;
    }
    if (a(paramContext, this.FdW, this.FdX) != null)
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