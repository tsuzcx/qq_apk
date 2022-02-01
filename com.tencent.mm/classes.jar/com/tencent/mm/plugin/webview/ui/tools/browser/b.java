package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper;", "", "()V", "BUNDLE_KEY_TARGET_INTENT", "", "BUNDLE_KEY_TARGET_URL", "TAG", "qqBrowserHelper", "Lcom/tencent/mm/pluginsdk/model/QQBrowserHelper;", "createBrowserChooser", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "target", "url", "filterBrowserList", "", "Landroid/content/pm/ResolveInfo;", "resolveList", "getAppDisplayName", "context", "Landroid/content/Context;", "resolveInfo", "getBrowserInfo", "packageName", "getBrowserList", "getBrowserListInternal", "isQQBrowser", "", "isSystemApplication", "loadIconForResolveInfo", "Landroid/graphics/drawable/Drawable;", "loadIconFromResourceId", "res", "Landroid/content/res/Resources;", "resId", "", "openInBrowser", "", "tryFixIntentData", "intent", "BrowserSettingResult", "plugin-webview_release"})
public final class b
{
  private static v QiR;
  public static final b QiS;
  
  static
  {
    AppMethodBeat.i(268030);
    QiS = new b();
    AppMethodBeat.o(268030);
  }
  
  public static final ResolveInfo V(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(268024);
    p.k(paramContext, "context");
    p.k(paramString1, "packageName");
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(268024);
      return null;
    }
    Object localObject = d.Qjc;
    if (d.gZI())
    {
      localObject = d.Qjc;
      if (d.bmz(paramString1))
      {
        AppMethodBeat.o(268024);
        return null;
      }
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
    paramString2.setPackage(paramString1);
    paramContext = paramContext.getPackageManager();
    if (paramContext != null)
    {
      paramContext = paramContext.queryIntentActivities(paramString2, 65536);
      if (paramContext != null)
      {
        paramContext = (ResolveInfo)j.M(paramContext, 0);
        AppMethodBeat.o(268024);
        return paramContext;
      }
    }
    AppMethodBeat.o(268024);
    return null;
  }
  
  public static final Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(268020);
    p.k(paramActivity, "activity");
    Log.v("MicroMsg.BrowserChooseDialogHelper", "alvinluo createBrowserChooser activity: %s, url: %s", new Object[] { paramActivity, paramString });
    Bundle localBundle = new Bundle();
    localBundle.putString("target_url", paramString);
    localBundle.putParcelable("target_intent", (Parcelable)paramIntent);
    paramIntent.putExtra("targeturl", paramString);
    paramString = new Intent();
    paramString.setClass((Context)paramActivity, BrowserChooseUI.class);
    paramString.putExtra("scene", 4);
    paramString.putExtra("targetintent", (Parcelable)paramIntent);
    paramString.putExtra("transferback", localBundle);
    AppMethodBeat.o(268020);
    return paramString;
  }
  
  public static final Drawable a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(268026);
    p.k(paramContext, "context");
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(268026);
      return null;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(268026);
      return null;
    }
    try
    {
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        paramContext = localPackageManager.getResourcesForApplication(paramResolveInfo.resolvePackageName);
        p.j(paramContext, "packageManager.getResour…eInfo.resolvePackageName)");
        paramContext = d(paramContext, paramResolveInfo.icon);
        if (paramContext != null)
        {
          AppMethodBeat.o(268026);
          return paramContext;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        paramContext = localPackageManager.getResourcesForApplication(paramResolveInfo.activityInfo.packageName);
        p.j(paramContext, "packageManager.getResour…activityInfo.packageName)");
        Drawable localDrawable = d(paramContext, i);
        if (localDrawable != null)
        {
          ActivityInfo localActivityInfo = paramResolveInfo.activityInfo;
          paramContext = localObject;
          if (localActivityInfo != null) {
            paramContext = localActivityInfo.packageName;
          }
          Log.d("MicroMsg.BrowserChooseDialogHelper", "loadIconForResolveInfo %s, iconRes %d done", new Object[] { paramContext, Integer.valueOf(i) });
          AppMethodBeat.o(268026);
          return localDrawable;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.BrowserChooseDialogHelper", "Couldn't find resources for package", new Object[] { paramContext });
      paramContext = paramResolveInfo.loadIcon(localPackageManager);
      AppMethodBeat.o(268026);
    }
    return paramContext;
  }
  
  public static final void a(Context paramContext, Intent paramIntent, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(268029);
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        str = paramIntent.getStringExtra("targeturl");
        if (paramResolveInfo == null) {
          break label367;
        }
        localObject1 = paramResolveInfo.activityInfo;
        if (localObject1 == null) {
          break label367;
        }
        localObject1 = ((ActivityInfo)localObject1).packageName;
        if (paramIntent == null) {
          break label373;
        }
        localObject2 = paramIntent.getData();
        if (localObject2 == null) {
          break label373;
        }
        localObject2 = ((Uri)localObject2).toString();
        Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo openInBrowser package: %s, uri: %s, url: %s", new Object[] { localObject1, localObject2, str });
        y.hhf();
        localObject2 = (v)y.C(0, null);
        if (paramResolveInfo == null) {
          break label379;
        }
        localObject1 = paramResolveInfo.activityInfo;
        if (localObject1 == null) {
          break label379;
        }
        localObject1 = ((ActivityInfo)localObject1).packageName;
        if (((v)localObject2).bpD((String)localObject1))
        {
          ((v)localObject2).cs(paramContext, str);
          AppMethodBeat.o(268029);
          return;
        }
        if (paramIntent != null)
        {
          paramIntent.addFlags(524288);
          if (paramResolveInfo == null) {
            break label385;
          }
          paramResolveInfo = paramResolveInfo.activityInfo;
          if (paramResolveInfo == null) {
            break label385;
          }
          str = paramResolveInfo.packageName;
          paramResolveInfo = str;
          if (str == null) {
            break label385;
          }
          paramIntent.setPackage(paramResolveInfo);
          if (!com.tencent.mm.compatible.util.d.qV(29)) {
            break label272;
          }
          paramIntent = PendingIntent.getActivity(paramContext, 0, paramIntent, 134217728);
          if (paramIntent == null) {
            break label265;
          }
          paramIntent.send(paramContext, 1, null, (PendingIntent.OnFinished)a.QiT, null);
          AppMethodBeat.o(268029);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.BrowserChooseDialogHelper", (Throwable)paramContext, "onBrowserItemClick exception", new Object[0]);
        AppMethodBeat.o(268029);
        return;
      }
      paramIntent = null;
      continue;
      label265:
      AppMethodBeat.o(268029);
      return;
      label272:
      if (paramContext != null)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper", "openInBrowser", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper", "openInBrowser", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(268029);
        return;
      }
      AppMethodBeat.o(268029);
      return;
      String str = null;
      continue;
      label367:
      Object localObject1 = null;
      continue;
      label373:
      Object localObject2 = null;
      continue;
      label379:
      localObject1 = null;
      continue;
      label385:
      paramResolveInfo = "";
    }
  }
  
  public static final List<ResolveInfo> aB(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(268023);
    p.k(paramContext, "context");
    if (paramIntent == null)
    {
      paramContext = (List)new ArrayList();
      AppMethodBeat.o(268023);
      return paramContext;
    }
    paramIntent.addCategory("android.intent.category.BROWSABLE");
    Object localObject1 = paramIntent.getData();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((Uri)localObject1).toString();
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label196;
      }
      i = 1;
      label80:
      localObject2 = paramIntent;
      if (i == 0) {
        if (!n.M((String)localObject1, "https://view.inews.qq.com", false))
        {
          localObject2 = paramIntent;
          if (!n.M((String)localObject1, "http://view.inews.qq.com", false)) {}
        }
        else
        {
          localObject2 = new Intent(paramIntent);
          ((Intent)localObject2).setData(Uri.parse("https://mp.weixin.qq.com"));
        }
      }
      paramContext = paramContext.getPackageManager();
      if (Build.VERSION.SDK_INT < 23) {
        break label206;
      }
      if (paramContext == null) {
        break label201;
      }
      paramContext = paramContext.queryIntentActivities((Intent)localObject2, 131072);
    }
    for (;;)
    {
      paramIntent = paramContext;
      if (paramContext == null) {
        paramIntent = (List)new ArrayList();
      }
      paramContext = jb(paramIntent);
      AppMethodBeat.o(268023);
      return paramContext;
      localObject1 = null;
      break;
      label196:
      i = 0;
      break label80;
      label201:
      paramContext = null;
      continue;
      label206:
      if (paramContext != null) {
        paramContext = paramContext.queryIntentActivities((Intent)localObject2, 65536);
      } else {
        paramContext = null;
      }
    }
  }
  
  public static final String b(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(268028);
    p.k(paramContext, "context");
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(268028);
      return "";
    }
    paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager());
    if (paramContext != null)
    {
      paramResolveInfo = paramContext.toString();
      paramContext = paramResolveInfo;
      if (paramResolveInfo != null) {}
    }
    else
    {
      paramContext = "";
    }
    paramResolveInfo = Pattern.compile("\\(.*推荐.*\\)", 2).matcher((CharSequence)paramContext);
    if (paramResolveInfo.find())
    {
      paramContext = paramResolveInfo.replaceAll("");
      if (paramContext != null)
      {
        if (paramContext == null)
        {
          paramContext = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(268028);
          throw paramContext;
        }
        paramResolveInfo = n.bb((CharSequence)paramContext).toString();
        paramContext = paramResolveInfo;
        if (paramResolveInfo != null) {}
      }
      else
      {
        paramContext = "";
      }
      AppMethodBeat.o(268028);
      return paramContext;
    }
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(268028);
      throw paramContext;
    }
    paramContext = n.bb((CharSequence)paramContext).toString();
    AppMethodBeat.o(268028);
    return paramContext;
  }
  
  private static Drawable d(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(268027);
    try
    {
      paramResources = com.tencent.mm.cj.b.f(paramResources, paramInt);
      AppMethodBeat.o(268027);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;)
      {
        paramResources = null;
      }
    }
  }
  
  private static List<ResolveInfo> jb(List<? extends ResolveInfo> paramList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(268025);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        if (localResolveInfo != null)
        {
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 != null)
          {
            localObject1 = ((ActivityInfo)localObject1).packageName;
            label101:
            Log.v("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList packageName: %s", new Object[] { localObject1 });
            if (localResolveInfo == null) {
              continue;
            }
            if (localResolveInfo == null) {
              break label210;
            }
            localObject1 = localResolveInfo.activityInfo;
            if (localObject1 == null) {
              break label210;
            }
            localObject1 = ((ActivityInfo)localObject1).applicationInfo;
            if (localObject1 == null) {
              break label210;
            }
            i = ((ApplicationInfo)localObject1).flags;
            label151:
            if ((i & 0x1) <= 0) {
              break label215;
            }
            i = 1;
            label159:
            if (i == 0) {
              break label225;
            }
            localObject1 = localResolveInfo.activityInfo;
            if (localObject1 == null) {
              break label220;
            }
          }
        }
        label210:
        label215:
        label220:
        for (localObject1 = ((ActivityInfo)localObject1).packageName;; localObject1 = null)
        {
          Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList package: %s is system application", new Object[] { localObject1 });
          localArrayList3.add(localResolveInfo);
          break;
          localObject1 = null;
          break label101;
          i = 0;
          break label151;
          i = 0;
          break label159;
        }
        label225:
        localObject1 = d.Qjc;
        localObject1 = localResolveInfo.activityInfo;
        if (localObject1 != null)
        {
          localObject1 = ((ActivityInfo)localObject1).packageName;
          if (!d.bmy((String)localObject1)) {
            break label380;
          }
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 == null) {
            break label327;
          }
        }
        v localv;
        label327:
        for (localObject1 = ((ActivityInfo)localObject1).packageName;; localObject1 = null)
        {
          if (QiR == null) {
            QiR = new v();
          }
          localv = QiR;
          if (localv == null) {
            p.iCn();
          }
          if (localObject1 == null) {
            break label364;
          }
          if (localObject1 != null) {
            break label332;
          }
          paramList = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(268025);
          throw paramList;
          localObject1 = null;
          break;
        }
        label332:
        localObject1 = ((String)localObject1).toLowerCase();
        p.j(localObject1, "(this as java.lang.String).toLowerCase()");
        for (;;)
        {
          if (!localv.bpD((String)localObject1)) {
            break label369;
          }
          localArrayList4.add(localResolveInfo);
          break;
          label364:
          localObject1 = null;
        }
        label369:
        localArrayList2.add(localResolveInfo);
        continue;
        label380:
        localObject1 = d.Qjc;
        if (d.gZI())
        {
          localObject1 = d.Qjc;
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 != null)
          {
            localObject1 = ((ActivityInfo)localObject1).packageName;
            label409:
            if (!d.bmz((String)localObject1)) {
              break label460;
            }
            localObject1 = localResolveInfo.activityInfo;
            if (localObject1 == null) {
              break label455;
            }
          }
          label455:
          for (localObject1 = ((ActivityInfo)localObject1).packageName;; localObject1 = null)
          {
            Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList package: %s is in block list", new Object[] { localObject1 });
            break;
            localObject1 = null;
            break label409;
          }
        }
        label460:
        localArrayList1.add(localResolveInfo);
      }
    }
    localArrayList1.addAll(0, (Collection)localArrayList3);
    localArrayList1.addAll(localArrayList3.size(), (Collection)localArrayList4);
    int i = localArrayList3.size();
    localArrayList1.addAll(localArrayList4.size() + i, (Collection)localArrayList2);
    Object localObject1 = localObject2;
    if (paramList != null) {
      localObject1 = Integer.valueOf(paramList.size());
    }
    Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList resolveList: %s, finalList: %s, systemBrowserCount: %d, qqBrowserList: %s, filteredAllowList: %s", new Object[] { localObject1, Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList3.size()), Integer.valueOf(localArrayList4.size()), Integer.valueOf(localArrayList2.size()) });
    paramList = (List)localArrayList1;
    AppMethodBeat.o(268025);
    return paramList;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pendingIntent", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "intent", "Landroid/content/Intent;", "resultCode", "", "resultData", "", "resultExtras", "Landroid/os/Bundle;", "onSendFinished"})
  static final class a
    implements PendingIntent.OnFinished
  {
    public static final a QiT;
    
    static
    {
      AppMethodBeat.i(265641);
      QiT = new a();
      AppMethodBeat.o(265641);
    }
    
    public final void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(265637);
      Log.i("MicroMsg.BrowserChooseDialogHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(265637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.b
 * JD-Core Version:    0.7.0.1
 */