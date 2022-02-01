package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Activity;
import android.app.PendingIntent;
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
import com.tencent.mm.pluginsdk.model.aa;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper;", "", "()V", "BUNDLE_KEY_TARGET_INTENT", "", "BUNDLE_KEY_TARGET_URL", "TAG", "qqBrowserHelper", "Lcom/tencent/mm/pluginsdk/model/QQBrowserHelper;", "createBrowserChooser", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "target", "url", "filterBrowserList", "", "Landroid/content/pm/ResolveInfo;", "resolveList", "getAppDisplayName", "context", "Landroid/content/Context;", "resolveInfo", "getBrowserInfo", "packageName", "getBrowserList", "getBrowserListInternal", "isQQBrowser", "", "isSystemApplication", "loadIconForResolveInfo", "Landroid/graphics/drawable/Drawable;", "loadIconFromResourceId", "res", "Landroid/content/res/Resources;", "resId", "", "openInBrowser", "", "tryFixIntentData", "intent", "BrowserSettingResult", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b XaP;
  private static x XaQ;
  
  static
  {
    AppMethodBeat.i(296671);
    XaP = new b();
    AppMethodBeat.o(296671);
  }
  
  public static final ResolveInfo Z(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(296601);
    s.u(paramContext, "context");
    s.u(paramString1, "packageName");
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(296601);
      return null;
    }
    Object localObject = d.XaV;
    if (d.izL())
    {
      localObject = d.XaV;
      if (d.bma(paramString1))
      {
        AppMethodBeat.o(296601);
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
    if (paramContext == null)
    {
      AppMethodBeat.o(296601);
      return null;
    }
    paramContext = paramContext.queryIntentActivities(paramString2, 65536);
    if (paramContext == null)
    {
      AppMethodBeat.o(296601);
      return null;
    }
    paramContext = (ResolveInfo)p.ae(paramContext, 0);
    AppMethodBeat.o(296601);
    return paramContext;
  }
  
  public static final Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(296571);
    s.u(paramActivity, "activity");
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
    AppMethodBeat.o(296571);
    return paramString;
  }
  
  public static final Drawable a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(296632);
    s.u(paramContext, "context");
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(296632);
      return null;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(296632);
      return null;
    }
    try
    {
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        paramContext = localPackageManager.getResourcesForApplication(paramResolveInfo.resolvePackageName);
        s.s(paramContext, "packageManager.getResour…eInfo.resolvePackageName)");
        paramContext = e(paramContext, paramResolveInfo.icon);
        if (paramContext != null)
        {
          AppMethodBeat.o(296632);
          return paramContext;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        paramContext = localPackageManager.getResourcesForApplication(paramResolveInfo.activityInfo.packageName);
        s.s(paramContext, "packageManager.getResour…activityInfo.packageName)");
        Drawable localDrawable = e(paramContext, i);
        if (localDrawable != null)
        {
          paramContext = paramResolveInfo.activityInfo;
          if (paramContext == null) {}
          for (paramContext = localObject;; paramContext = paramContext.packageName)
          {
            Log.d("MicroMsg.BrowserChooseDialogHelper", "loadIconForResolveInfo %s, iconRes %d done", new Object[] { paramContext, Integer.valueOf(i) });
            AppMethodBeat.o(296632);
            return localDrawable;
          }
        }
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.BrowserChooseDialogHelper", "Couldn't find resources for package", new Object[] { paramContext });
      paramContext = paramResolveInfo.loadIcon(localPackageManager);
      AppMethodBeat.o(296632);
    }
  }
  
  private static final void a(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(296665);
    Log.i("MicroMsg.BrowserChooseDialogHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(296665);
  }
  
  public static final void a(Context paramContext, Intent paramIntent, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(296661);
    String str;
    Object localObject1;
    if (paramIntent == null)
    {
      str = null;
      if (paramResolveInfo != null) {
        break label116;
      }
      localObject1 = null;
      break label403;
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo openInBrowser package: %s, uri: %s, url: %s", new Object[] { localObject1, localObject2, str });
        aa.iIe();
        localObject1 = aa.F(0, null);
        if (localObject1 != null) {
          break label165;
        }
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.model.QQBrowserHelper");
        AppMethodBeat.o(296661);
        throw paramContext;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.BrowserChooseDialogHelper", (Throwable)paramContext, "onBrowserItemClick exception", new Object[0]);
      }
      label98:
      AppMethodBeat.o(296661);
      return;
      str = paramIntent.getStringExtra("targeturl");
      break;
      label116:
      localObject1 = paramResolveInfo.activityInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label403;
      }
      localObject1 = ((ActivityInfo)localObject1).packageName;
      break label403;
      label138:
      localObject2 = paramIntent.getData();
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((Uri)localObject2).toString();
      }
    }
    label165:
    Object localObject2 = (x)localObject1;
    if (paramResolveInfo == null) {
      localObject1 = null;
    }
    while (((x)localObject2).bpt((String)localObject1))
    {
      ((x)localObject2).cD(paramContext, str);
      AppMethodBeat.o(296661);
      return;
      localObject1 = paramResolveInfo.activityInfo;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((ActivityInfo)localObject1).packageName;
      }
    }
    for (;;)
    {
      if (com.tencent.mm.compatible.util.d.rb(29))
      {
        paramIntent = PendingIntent.getActivity(paramContext, 0, paramIntent, 134217728);
        if (paramIntent == null) {
          break label98;
        }
        paramIntent.send(paramContext, 1, null, b..ExternalSyntheticLambda0.INSTANCE, null);
        AppMethodBeat.o(296661);
        return;
      }
      label403:
      do
      {
        paramIntent.addFlags(524288);
        if (paramResolveInfo == null) {
          paramResolveInfo = "";
        }
        for (;;)
        {
          paramIntent.setPackage(paramResolveInfo);
          break;
          paramResolveInfo = paramResolveInfo.activityInfo;
          if (paramResolveInfo == null)
          {
            paramResolveInfo = "";
          }
          else
          {
            localObject1 = paramResolveInfo.packageName;
            paramResolveInfo = (ResolveInfo)localObject1;
            if (localObject1 == null) {
              paramResolveInfo = "";
            }
          }
        }
        if (paramContext == null) {
          break label98;
        }
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper", "openInBrowser", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper", "openInBrowser", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(296661);
        return;
        if (paramIntent != null) {
          break label138;
        }
        localObject2 = null;
        break;
      } while (paramIntent != null);
      paramIntent = null;
    }
  }
  
  public static final List<ResolveInfo> aK(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(296587);
    s.u(paramContext, "context");
    if (paramIntent == null)
    {
      paramContext = (List)new ArrayList();
      AppMethodBeat.o(296587);
      return paramContext;
    }
    paramIntent.addCategory("android.intent.category.BROWSABLE");
    Object localObject1 = paramIntent.getData();
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label188;
      }
      i = 1;
      label77:
      localObject2 = paramIntent;
      if (i == 0) {
        if (!n.U((String)localObject1, "https://view.inews.qq.com", false))
        {
          localObject2 = paramIntent;
          if (!n.U((String)localObject1, "http://view.inews.qq.com", false)) {}
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
      if (paramContext != null) {
        break label193;
      }
      paramContext = null;
    }
    for (;;)
    {
      paramIntent = paramContext;
      if (paramContext == null) {
        paramIntent = (List)new ArrayList();
      }
      paramContext = mk(paramIntent);
      AppMethodBeat.o(296587);
      return paramContext;
      localObject1 = ((Uri)localObject1).toString();
      break;
      label188:
      i = 0;
      break label77;
      label193:
      paramContext = paramContext.queryIntentActivities((Intent)localObject2, 131072);
      continue;
      label206:
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = paramContext.queryIntentActivities((Intent)localObject2, 65536);
      }
    }
  }
  
  public static final String b(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(296645);
    s.u(paramContext, "context");
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(296645);
      return "";
    }
    paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager());
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      paramResolveInfo = Pattern.compile("\\(.*推荐.*\\)", 2).matcher((CharSequence)paramContext);
      if (!paramResolveInfo.find()) {
        break label135;
      }
      paramContext = paramResolveInfo.replaceAll("");
      if (paramContext != null) {
        break;
      }
      AppMethodBeat.o(296645);
      return "";
      paramResolveInfo = paramContext.toString();
      paramContext = paramResolveInfo;
      if (paramResolveInfo == null) {
        paramContext = "";
      }
    }
    paramContext = n.bq((CharSequence)paramContext).toString();
    if (paramContext == null)
    {
      AppMethodBeat.o(296645);
      return "";
    }
    AppMethodBeat.o(296645);
    return paramContext;
    label135:
    paramContext = n.bq((CharSequence)paramContext).toString();
    AppMethodBeat.o(296645);
    return paramContext;
  }
  
  private static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(296637);
    try
    {
      paramResources = com.tencent.mm.ce.d.g(paramResources, paramInt);
      AppMethodBeat.o(296637);
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
  
  private static List<ResolveInfo> mk(List<? extends ResolveInfo> paramList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(296621);
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
        if (localResolveInfo == null)
        {
          localObject1 = null;
          label88:
          Log.v("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList packageName: %s", new Object[] { localObject1 });
          if (localResolveInfo == null) {
            continue;
          }
          if (localResolveInfo != null) {
            break label190;
          }
          i = 0;
          label116:
          if ((i & 0x1) <= 0) {
            break label227;
          }
          i = 1;
          label124:
          if (i == 0) {
            break label240;
          }
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 != null) {
            break label232;
          }
        }
        label190:
        label227:
        label232:
        for (Object localObject1 = null;; localObject1 = ((ActivityInfo)localObject1).packageName)
        {
          Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList package: %s is system application", new Object[] { localObject1 });
          localArrayList3.add(localResolveInfo);
          break;
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label88;
          }
          localObject1 = ((ActivityInfo)localObject1).packageName;
          break label88;
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 == null)
          {
            i = 0;
            break label116;
          }
          localObject1 = ((ActivityInfo)localObject1).applicationInfo;
          if (localObject1 == null)
          {
            i = 0;
            break label116;
          }
          i = ((ApplicationInfo)localObject1).flags;
          break label116;
          i = 0;
          break label124;
        }
        label240:
        localObject1 = d.XaV;
        localObject1 = localResolveInfo.activityInfo;
        label256:
        label275:
        x localx;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!d.blZ((String)localObject1)) {
            break label369;
          }
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 != null) {
            break label335;
          }
          localObject1 = null;
          if (XaQ == null) {
            XaQ = new x();
          }
          localx = XaQ;
          s.checkNotNull(localx);
          if (localObject1 != null) {
            break label343;
          }
          localObject1 = null;
        }
        for (;;)
        {
          if (!localx.bpt((String)localObject1)) {
            break label358;
          }
          localArrayList4.add(localResolveInfo);
          break;
          localObject1 = ((ActivityInfo)localObject1).packageName;
          break label256;
          label335:
          localObject1 = ((ActivityInfo)localObject1).packageName;
          break label275;
          label343:
          localObject1 = ((String)localObject1).toLowerCase();
          s.s(localObject1, "(this as java.lang.String).toLowerCase()");
        }
        label358:
        localArrayList2.add(localResolveInfo);
        continue;
        label369:
        localObject1 = d.XaV;
        if (d.izL())
        {
          localObject1 = d.XaV;
          localObject1 = localResolveInfo.activityInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            label395:
            if (!d.bma((String)localObject1)) {
              break label449;
            }
            localObject1 = localResolveInfo.activityInfo;
            if (localObject1 != null) {
              break label441;
            }
          }
          label441:
          for (localObject1 = null;; localObject1 = ((ActivityInfo)localObject1).packageName)
          {
            Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList package: %s is in block list", new Object[] { localObject1 });
            break;
            localObject1 = ((ActivityInfo)localObject1).packageName;
            break label395;
          }
        }
        label449:
        localArrayList1.add(localResolveInfo);
      }
    }
    localArrayList1.addAll(0, (Collection)localArrayList3);
    localArrayList1.addAll(localArrayList3.size(), (Collection)localArrayList4);
    int i = localArrayList3.size();
    localArrayList1.addAll(localArrayList4.size() + i, (Collection)localArrayList2);
    if (paramList == null) {}
    for (paramList = localObject2;; paramList = Integer.valueOf(paramList.size()))
    {
      Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList resolveList: %s, finalList: %s, systemBrowserCount: %d, qqBrowserList: %s, filteredAllowList: %s", new Object[] { paramList, Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList3.size()), Integer.valueOf(localArrayList4.size()), Integer.valueOf(localArrayList2.size()) });
      paramList = (List)localArrayList1;
      AppMethodBeat.o(296621);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.b
 * JD-Core Version:    0.7.0.1
 */