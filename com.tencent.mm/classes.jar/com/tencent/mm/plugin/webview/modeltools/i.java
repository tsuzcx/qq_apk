package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
import com.tencent.luggage.k.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.e;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/modeltools/WebViewPermissionRequestHelper;", "", "()V", "geolocationPermissions", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGeolocationPermissions", "()Ljava/util/HashMap;", "locationPermissionExpireHour", "", "getLocationPermissionExpireHour", "()I", "locationPermissionExpireHour$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "permissions", "getPermissions", "addGeolocationPermissions", "", "allow", "url", "origin", "callback", "Landroid/webkit/GeolocationPermissions$Callback;", "addPermissions", "request", "Landroid/webkit/PermissionRequest;", "addToCache", "getPermissionKey", "onGeolocationPermissionsShowPrompt", "context", "Landroid/content/Context;", "rawUrl", "a8KeyScene", "a8KeyUsername", "onPermissionRequest", "showGeolocationPermissionAlert", "showPermissionAlert", "resource", "", "(Landroid/content/Context;Landroid/webkit/PermissionRequest;[Ljava/lang/String;Ljava/lang/String;)V", "allowKey", "Companion", "plugin-webview_release"})
public final class i
{
  public static final a PXL;
  private final HashMap<String, Boolean> PXI;
  private final HashMap<String, Boolean> PXJ;
  private final kotlin.f PXK;
  private final kotlin.f lrB;
  
  static
  {
    AppMethodBeat.i(215224);
    PXL = new a((byte)0);
    AppMethodBeat.o(215224);
  }
  
  public i()
  {
    AppMethodBeat.i(215222);
    this.PXI = new HashMap();
    this.PXJ = new HashMap();
    this.PXK = g.ar((a)b.PXM);
    this.lrB = g.ar((a)c.PXN);
    AppMethodBeat.o(215222);
  }
  
  private static String a(PermissionRequest paramPermissionRequest, String paramString)
  {
    AppMethodBeat.i(215213);
    Object localObject1 = "";
    Object localObject2 = paramPermissionRequest.getResources();
    kotlin.g.b.p.j(localObject2, "request.resources");
    int k = localObject2.length;
    int i = 0;
    paramPermissionRequest = (PermissionRequest)localObject1;
    if (i < k)
    {
      String str = localObject2[i];
      localObject1 = (CharSequence)paramPermissionRequest;
      if ((localObject1 == null) || (n.ba((CharSequence)localObject1))) {}
      for (int j = 1;; j = 0)
      {
        localObject1 = paramPermissionRequest;
        if (j == 0) {
          localObject1 = paramPermissionRequest + "-";
        }
        paramPermissionRequest = (String)localObject1 + str;
        i += 1;
        break;
      }
    }
    localObject1 = new StringBuilder();
    if (paramString != null) {
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.Qvn;
    }
    for (paramString = com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.getHost(paramString);; paramString = null)
    {
      paramPermissionRequest = paramString + '-' + paramPermissionRequest;
      AppMethodBeat.o(215213);
      return paramPermissionRequest;
    }
  }
  
  private final void a(Context paramContext, final PermissionRequest paramPermissionRequest, String[] paramArrayOfString, final String paramString)
  {
    AppMethodBeat.i(215217);
    if ((e.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE")) || (e.contains(paramArrayOfString, "android.webkit.resource.AUDIO_CAPTURE")))
    {
      if ((e.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE")) && (e.contains(paramArrayOfString, "android.webkit.resource.AUDIO_CAPTURE")))
      {
        paramArrayOfString = paramContext.getString(c.i.wv_allow_camera_and_record_audio_permission, new Object[] { paramPermissionRequest.getOrigin().toString() });
        kotlin.g.b.p.j(paramArrayOfString, "context.getString(R.stri…equest.origin.toString())");
        com.tencent.mm.ui.base.h.a(paramContext, false, "", paramArrayOfString, paramContext.getString(c.i.appbrand_request_accept), paramContext.getString(c.i.appbrand_request_reject), (DialogInterface.OnClickListener)new h(this, paramPermissionRequest, paramString), (DialogInterface.OnClickListener)new i(this, paramPermissionRequest, paramString));
        AppMethodBeat.o(215217);
        return;
      }
      if (e.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE")) {}
      for (paramArrayOfString = paramContext.getString(c.i.wv_allow_camera_permission, new Object[] { paramPermissionRequest.getOrigin().toString() });; paramArrayOfString = paramContext.getString(c.i.wv_allow_record_audio_permission, new Object[] { paramPermissionRequest.getOrigin().toString() }))
      {
        kotlin.g.b.p.j(paramArrayOfString, "if (resource.contains(Pe…toString())\n            }");
        break;
      }
    }
    if (e.contains(paramArrayOfString, "android.webkit.resource.PROTECTED_MEDIA_ID"))
    {
      a(this, paramPermissionRequest, paramString, true);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "showPermissionAlert grant PROTECTED_MEDIA_ID");
      AppMethodBeat.o(215217);
      return;
    }
    paramPermissionRequest.deny();
    Log.w("MicroMsg.WebViewPermissionRequestHelper", "showPermissionAlert not support permission");
    AppMethodBeat.o(215217);
  }
  
  private final void a(PermissionRequest paramPermissionRequest, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215214);
    if (paramBoolean1) {
      paramPermissionRequest.grant(paramPermissionRequest.getResources());
    }
    for (;;)
    {
      if (paramBoolean2) {
        ((Map)this.PXJ).put(a(paramPermissionRequest, paramString), Boolean.valueOf(paramBoolean1));
      }
      AppMethodBeat.o(215214);
      return;
      paramPermissionRequest.deny();
    }
  }
  
  private final void a(boolean paramBoolean, String paramString1, String paramString2, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(215211);
    if (paramCallback != null) {
      paramCallback.invoke(paramString2, paramBoolean, false);
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(215211);
      return;
    }
    paramString2 = com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.Qvn;
    paramString1 = com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.getHost(paramString1);
    ((Map)this.PXI).put(paramString1, Boolean.valueOf(paramBoolean));
    bcJ().encode(bll(paramString1), paramBoolean);
    AppMethodBeat.o(215211);
  }
  
  private final void b(Context paramContext, final String paramString1, final String paramString2, final int paramInt, final String paramString3, final String paramString4, final GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(215207);
    com.tencent.mm.ui.base.h.a(paramContext, false, "", paramContext.getString(c.i.wv_get_location_msg, new Object[] { paramString4 }), paramContext.getString(c.i.appbrand_request_accept), paramContext.getString(c.i.appbrand_request_reject), (DialogInterface.OnClickListener)new f(this, paramString1, paramString4, paramCallback, paramString2, paramInt, paramString3), (DialogInterface.OnClickListener)new g(this, paramString1, paramString4, paramCallback, paramString2, paramInt, paramString3));
    AppMethodBeat.o(215207);
  }
  
  private final MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(215201);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.lrB.getValue();
    AppMethodBeat.o(215201);
    return localMultiProcessMMKV;
  }
  
  private static String bll(String paramString)
  {
    AppMethodBeat.i(215196);
    kotlin.g.b.p.k(paramString, "$this$allowKey");
    paramString = "##allow##".concat(String.valueOf(paramString));
    AppMethodBeat.o(215196);
    return paramString;
  }
  
  private int gWz()
  {
    AppMethodBeat.i(215194);
    int i = ((Number)this.PXK.getValue()).intValue();
    AppMethodBeat.o(215194);
    return i;
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final int paramInt, final String paramString3, final String paramString4, final GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(215204);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString4 });
    Object localObject = (CharSequence)paramString1;
    int i;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {
      i = 1;
    }
    while (i != 0) {
      if (paramCallback != null)
      {
        paramCallback.invoke(paramString4, false, false);
        AppMethodBeat.o(215204);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(215204);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.Qvn;
    localObject = com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.getHost(paramString1);
    boolean bool;
    if (this.PXI.containsKey(localObject))
    {
      paramString1 = (Boolean)this.PXI.get(localObject);
      paramContext = paramString1;
      if (paramString1 == null) {
        paramContext = Boolean.TRUE;
      }
      kotlin.g.b.p.j(paramContext, "geolocationPermissions[key] ?: true");
      bool = paramContext.booleanValue();
      Log.d("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt use cache, allow = ".concat(String.valueOf(bool)));
      if (paramCallback != null)
      {
        paramCallback.invoke(paramString4, bool, false);
        AppMethodBeat.o(215204);
        return;
      }
      AppMethodBeat.o(215204);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = bcJ().decodeLong((String)localObject, 0L);
    if ((Math.abs(l1 - l2) < 3600000L * gWz()) && (bcJ().containsKey(bll((String)localObject))))
    {
      bool = bcJ().decodeBool(bll((String)localObject), true);
      if (bool)
      {
        Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt less than " + gWz() + " hour(lastShowTime=" + l2 + ", allow=" + bool + "), do not show alert.");
        a(bool, paramString1, paramString4, paramCallback);
        AppMethodBeat.o(215204);
        return;
      }
    }
    bcJ().encode((String)localObject, l1);
    if (!com.tencent.luggage.k.f.aI(paramContext).a("android.permission.ACCESS_FINE_LOCATION", (f.f)new d(this, paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, paramCallback)))
    {
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt need request permission now");
      AppMethodBeat.o(215204);
      return;
    }
    b(paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, paramCallback);
    AppMethodBeat.o(215204);
  }
  
  public final void a(final PermissionRequest paramPermissionRequest, final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(215219);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest");
    if (paramPermissionRequest == null)
    {
      AppMethodBeat.o(215219);
      return;
    }
    Object localObject1 = paramPermissionRequest.getResources();
    if (localObject1 != null)
    {
      localObject2 = (Collection)new ArrayList();
      int k = localObject1.length;
      i = 0;
      if (i < k)
      {
        localObject3 = localObject1[i];
        if ((((String)localObject3).equals("android.webkit.resource.AUDIO_CAPTURE")) || (((String)localObject3).equals("android.webkit.resource.VIDEO_CAPTURE")) || (((String)localObject3).equals("android.webkit.resource.PROTECTED_MEDIA_ID"))) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            ((Collection)localObject2).add(localObject3);
          }
          i += 1;
          break;
        }
      }
      localObject1 = ((Collection)localObject2).toArray(new String[0]);
      if (localObject1 == null)
      {
        paramPermissionRequest = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(215219);
        throw paramPermissionRequest;
      }
      localObject1 = (String[])localObject1;
      if (localObject1 != null)
      {
        if (localObject1.length != 0) {
          break label234;
        }
        i = 1;
        label204:
        if (i == 0) {
          break label240;
        }
      }
    }
    label234:
    label240:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label246;
      }
      paramPermissionRequest.deny();
      AppMethodBeat.o(215219);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label204;
    }
    label246:
    Object localObject2 = a(paramPermissionRequest, paramString);
    if (this.PXJ.containsKey(localObject2))
    {
      localObject1 = (Boolean)this.PXJ.get(localObject2);
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = Boolean.FALSE;
      }
      kotlin.g.b.p.j(paramContext, "permissions[permissionKey] ?: false");
      boolean bool = paramContext.booleanValue();
      a(paramPermissionRequest, paramString, bool, false);
      Log.d("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest use cache ".concat(String.valueOf(bool)));
      AppMethodBeat.o(215219);
      return;
    }
    Object localObject3 = new ArrayList();
    if ((e.contains((Object[])localObject1, "android.webkit.resource.AUDIO_CAPTURE")) && (!b.o(paramContext, "android.permission.RECORD_AUDIO"))) {
      ((ArrayList)localObject3).add("android.permission.RECORD_AUDIO");
    }
    if ((e.contains((Object[])localObject1, "android.webkit.resource.VIDEO_CAPTURE")) && (!b.o(paramContext, "android.permission.CAMERA"))) {
      ((ArrayList)localObject3).add("android.permission.CAMERA");
    }
    if (((Collection)localObject3).isEmpty()) {
      i = 1;
    }
    while (i == 0)
    {
      localObject2 = com.tencent.luggage.k.f.aI(paramContext);
      localObject3 = ((Collection)localObject3).toArray(new String[0]);
      if (localObject3 == null)
      {
        paramPermissionRequest = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(215219);
        throw paramPermissionRequest;
        i = 0;
      }
      else
      {
        ((com.tencent.luggage.k.f)localObject2).a((String[])localObject3, (f.f)new e(this, paramContext, paramPermissionRequest, (String[])localObject1, paramString));
        AppMethodBeat.o(215219);
        return;
      }
    }
    a(paramContext, paramPermissionRequest, (String[])localObject1, paramString);
    AppMethodBeat.o(215219);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/modeltools/WebViewPermissionRequestHelper$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Integer>
  {
    public static final b PXM;
    
    static
    {
      AppMethodBeat.i(268217);
      PXM = new b();
      AppMethodBeat.o(268217);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final c PXN;
    
    static
    {
      AppMethodBeat.i(262744);
      PXN = new c();
      AppMethodBeat.o(262744);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onResult", "([Ljava/lang/String;[I)V"})
  static final class d
    implements f.f
  {
    d(i parami, Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, GeolocationPermissions.Callback paramCallback) {}
    
    public final void q(int[] paramArrayOfInt)
    {
      int j = 1;
      AppMethodBeat.i(217169);
      if (paramArrayOfInt != null)
      {
        if (paramArrayOfInt.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label87;
          }
        }
        label87:
        for (int i = j;; i = 0)
        {
          if ((i == 0) || (paramArrayOfInt[0] != 0)) {
            break label92;
          }
          Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt PERMISSION_GRANTED");
          i.a(this.PXO, paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, paramCallback);
          AppMethodBeat.o(217169);
          return;
          i = 0;
          break;
        }
      }
      label92:
      Log.e("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt PERMISSION_DENIED");
      i.a(this.PXO, false, paramString1, paramString4, paramCallback);
      AppMethodBeat.o(217169);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onResult", "([Ljava/lang/String;[I)V"})
  static final class e
    implements f.f
  {
    e(i parami, Context paramContext, PermissionRequest paramPermissionRequest, String[] paramArrayOfString, String paramString) {}
    
    public final void q(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(264502);
      int k = 1;
      int i = 1;
      if (paramArrayOfInt != null)
      {
        int m = paramArrayOfInt.length;
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          if (paramArrayOfInt[j] != 0) {
            i = 0;
          }
          j += 1;
        }
      }
      if (k != 0)
      {
        Log.i("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest PERMISSION_GRANTED");
        i.a(this.PXO, paramContext, paramPermissionRequest, this.PXV, paramString);
        AppMethodBeat.o(264502);
        return;
      }
      Log.e("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest PERMISSION_DENIED");
      i.a(this.PXO, paramPermissionRequest, paramString, false);
      AppMethodBeat.o(264502);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(i parami, String paramString1, String paramString2, GeolocationPermissions.Callback paramCallback, String paramString3, int paramInt, String paramString4) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(257825);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt ok");
      i.a(this.PXO, true, paramString1, paramString4, paramCallback);
      com.tencent.mm.plugin.report.service.h.IzE.a(14340, new Object[] { ab.aXb(paramString2), ab.aXb(paramString1), Integer.valueOf(paramInt), paramString3, Integer.valueOf(ba.bTg()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(257825);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(i parami, String paramString1, String paramString2, GeolocationPermissions.Callback paramCallback, String paramString3, int paramInt, String paramString4) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(223465);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt cancel");
      i.a(this.PXO, false, paramString1, paramString4, paramCallback);
      com.tencent.mm.plugin.report.service.h.IzE.a(14340, new Object[] { ab.aXb(paramString2), ab.aXb(paramString1), Integer.valueOf(paramInt), paramString3, Integer.valueOf(ba.bTg()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(223465);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(i parami, PermissionRequest paramPermissionRequest, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(223975);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest ok");
      i.a(this.PXO, paramPermissionRequest, paramString, true);
      AppMethodBeat.o(223975);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class i
    implements DialogInterface.OnClickListener
  {
    i(i parami, PermissionRequest paramPermissionRequest, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(228343);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest cancel");
      i.a(this.PXO, paramPermissionRequest, paramString, false);
      AppMethodBeat.o(228343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.i
 * JD-Core Version:    0.7.0.1
 */