package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
import com.tencent.luggage.l.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.r;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/modeltools/WebViewPermissionRequestHelper;", "", "()V", "geolocationPermissions", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGeolocationPermissions", "()Ljava/util/HashMap;", "locationPermissionExpireHour", "", "getLocationPermissionExpireHour", "()I", "locationPermissionExpireHour$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "permissions", "getPermissions", "addGeolocationPermissions", "", "allow", "url", "origin", "callback", "Landroid/webkit/GeolocationPermissions$Callback;", "addPermissions", "request", "Landroid/webkit/PermissionRequest;", "addToCache", "getPermissionKey", "onGeolocationPermissionsShowPrompt", "context", "Landroid/content/Context;", "rawUrl", "a8KeyScene", "a8KeyUsername", "onPermissionRequest", "showNotGrantToast", "notGrandArray", "Ljava/util/LinkedList;", "showPermissionAlert", "resource", "", "(Landroid/content/Context;Landroid/webkit/PermissionRequest;[Ljava/lang/String;Ljava/lang/String;)V", "showSysPermissionAlert", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showWebPermissionAlert", "words", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "allowKey", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final a WOg;
  private final HashMap<String, Boolean> WOh;
  private final HashMap<String, Boolean> WOi;
  private final kotlin.j WOj;
  private final kotlin.j exj;
  
  static
  {
    AppMethodBeat.i(295877);
    WOg = new a((byte)0);
    AppMethodBeat.o(295877);
  }
  
  public j()
  {
    AppMethodBeat.i(295819);
    this.WOh = new HashMap();
    this.WOi = new HashMap();
    this.WOj = kotlin.k.cm((kotlin.g.a.a)b.WOk);
    this.exj = kotlin.k.cm((kotlin.g.a.a)c.WOl);
    AppMethodBeat.o(295819);
  }
  
  private static String a(PermissionRequest paramPermissionRequest, String paramString)
  {
    AppMethodBeat.i(295842);
    Object localObject1 = "";
    paramPermissionRequest = paramPermissionRequest.getResources();
    s.s(paramPermissionRequest, "request.resources");
    Object localObject2 = (Object[])paramPermissionRequest;
    int k = localObject2.length;
    int i = 0;
    paramPermissionRequest = (PermissionRequest)localObject1;
    if (i < k)
    {
      String str = (String)localObject2[i];
      localObject1 = (CharSequence)paramPermissionRequest;
      if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
      for (int j = 1;; j = 0)
      {
        localObject1 = paramPermissionRequest;
        if (j == 0) {
          localObject1 = s.X(paramPermissionRequest, "-");
        }
        paramPermissionRequest = s.X((String)localObject1, str);
        i += 1;
        break;
      }
    }
    localObject1 = new StringBuilder();
    if (paramString == null) {}
    for (paramString = null;; paramString = r.getHost(paramString))
    {
      paramPermissionRequest = paramString + '-' + paramPermissionRequest;
      AppMethodBeat.o(295842);
      return paramPermissionRequest;
      localObject2 = r.Xnn;
    }
  }
  
  private final void a(final Context paramContext, final PermissionRequest paramPermissionRequest, final String[] paramArrayOfString, final String paramString)
  {
    AppMethodBeat.i(295855);
    final ah.f localf = new ah.f();
    localf.aqH = "";
    if ((kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE")) || (kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.AUDIO_CAPTURE")))
    {
      String str;
      if ((kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE")) && (kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.AUDIO_CAPTURE")))
      {
        str = paramContext.getString(c.i.wv_allow_camera_and_record_audio_permission, new Object[] { paramPermissionRequest.getOrigin().toString() });
        s.s(str, "{\n                contex…toString())\n            }");
      }
      for (;;)
      {
        localf.aqH = str;
        kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new f(this, paramContext, localf, paramPermissionRequest, paramString, paramArrayOfString, null), 3);
        AppMethodBeat.o(295855);
        return;
        if (kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE"))
        {
          str = paramContext.getString(c.i.wv_allow_camera_permission, new Object[] { paramPermissionRequest.getOrigin().toString() });
          s.s(str, "{\n                contex…toString())\n            }");
        }
        else
        {
          str = paramContext.getString(c.i.wv_allow_record_audio_permission, new Object[] { paramPermissionRequest.getOrigin().toString() });
          s.s(str, "{\n                contex…toString())\n            }");
        }
      }
    }
    if (kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.PROTECTED_MEDIA_ID"))
    {
      a(this, paramPermissionRequest, paramString, true);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "showPermissionAlert grant PROTECTED_MEDIA_ID");
      AppMethodBeat.o(295855);
      return;
    }
    paramPermissionRequest.deny();
    Log.w("MicroMsg.WebViewPermissionRequestHelper", "showPermissionAlert not support permission");
    AppMethodBeat.o(295855);
  }
  
  private final void a(PermissionRequest paramPermissionRequest, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(295848);
    if (paramBoolean1) {
      paramPermissionRequest.grant(paramPermissionRequest.getResources());
    }
    for (;;)
    {
      if (paramBoolean2) {
        ((Map)this.WOi).put(a(paramPermissionRequest, paramString), Boolean.valueOf(paramBoolean1));
      }
      AppMethodBeat.o(295848);
      return;
      paramPermissionRequest.deny();
    }
  }
  
  private final void a(boolean paramBoolean, String paramString1, String paramString2, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(295835);
    if (paramCallback != null) {
      paramCallback.invoke(paramString2, paramBoolean, false);
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(295835);
      return;
    }
    paramString2 = r.Xnn;
    paramString1 = r.getHost(paramString1);
    ((Map)this.WOh).put(paramString1, Boolean.valueOf(paramBoolean));
    atj().encode(bkQ(paramString1), paramBoolean);
    AppMethodBeat.o(295835);
  }
  
  private final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(295828);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.exj.getValue();
    AppMethodBeat.o(295828);
    return localMultiProcessMMKV;
  }
  
  private static String bkQ(String paramString)
  {
    AppMethodBeat.i(295826);
    s.u(paramString, "<this>");
    paramString = s.X("##allow##", paramString);
    AppMethodBeat.o(295826);
    return paramString;
  }
  
  private int iwe()
  {
    AppMethodBeat.i(295824);
    int i = ((Number)this.WOj.getValue()).intValue();
    AppMethodBeat.o(295824);
    return i;
  }
  
  public final void a(final Context paramContext, final String paramString1, final String paramString2, final int paramInt, final String paramString3, final String paramString4, final GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(295886);
    s.u(paramContext, "context");
    Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString4 });
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (paramCallback != null) {
        paramCallback.invoke(paramString4, false, false);
      }
      AppMethodBeat.o(295886);
      return;
    }
    localObject = r.Xnn;
    localObject = r.getHost(paramString1);
    boolean bool;
    if (this.WOh.containsKey(localObject))
    {
      paramString1 = (Boolean)this.WOh.get(localObject);
      paramContext = paramString1;
      if (paramString1 == null) {
        paramContext = Boolean.TRUE;
      }
      bool = paramContext.booleanValue();
      Log.d("MicroMsg.WebViewPermissionRequestHelper", s.X("onGeolocationPermissionsShowPrompt use cache, allow = ", Boolean.valueOf(bool)));
      if (paramCallback != null) {
        paramCallback.invoke(paramString4, bool, false);
      }
      AppMethodBeat.o(295886);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = atj().decodeLong((String)localObject, 0L);
    if ((Math.abs(l1 - l2) < 3600000L * iwe()) && (atj().containsKey(bkQ((String)localObject))))
    {
      bool = atj().decodeBool(bkQ((String)localObject), true);
      if (bool)
      {
        Log.i("MicroMsg.WebViewPermissionRequestHelper", "onGeolocationPermissionsShowPrompt less than " + iwe() + " hour(lastShowTime=" + l2 + ", allow=" + bool + "), do not show alert.");
        a(bool, paramString1, paramString4, paramCallback);
        AppMethodBeat.o(295886);
        return;
      }
    }
    atj().encode((String)localObject, l1);
    kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new d(this, paramContext, paramString4, paramString1, paramCallback, paramString2, paramInt, paramString3, null), 3);
    AppMethodBeat.o(295886);
  }
  
  public final void a(PermissionRequest paramPermissionRequest, Context paramContext, String paramString)
  {
    AppMethodBeat.i(295898);
    s.u(paramContext, "context");
    Log.i("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest");
    if (paramPermissionRequest == null)
    {
      AppMethodBeat.o(295898);
      return;
    }
    Object localObject1 = paramPermissionRequest.getResources();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        if (localObject1.length != 0) {
          break label237;
        }
        i = 1;
        label61:
        if (i == 0) {
          break label243;
        }
      }
    }
    label237:
    label243:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label249;
      }
      paramPermissionRequest.deny();
      AppMethodBeat.o(295898);
      return;
      localObject2 = (Collection)new ArrayList();
      int k = localObject1.length;
      i = 0;
      if (i < k)
      {
        Object localObject3 = localObject1[i];
        if ((localObject3.equals("android.webkit.resource.AUDIO_CAPTURE")) || (localObject3.equals("android.webkit.resource.VIDEO_CAPTURE")) || (localObject3.equals("android.webkit.resource.PROTECTED_MEDIA_ID"))) {}
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
        paramPermissionRequest = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(295898);
        throw paramPermissionRequest;
      }
      localObject1 = (String[])localObject1;
      break;
      i = 0;
      break label61;
    }
    label249:
    Object localObject2 = a(paramPermissionRequest, paramString);
    if (this.WOi.containsKey(localObject2))
    {
      localObject1 = (Boolean)this.WOi.get(localObject2);
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = Boolean.FALSE;
      }
      boolean bool = paramContext.booleanValue();
      a(paramPermissionRequest, paramString, bool, false);
      Log.d("MicroMsg.WebViewPermissionRequestHelper", s.X("onPermissionRequest use cache ", Boolean.valueOf(bool)));
      AppMethodBeat.o(295898);
      return;
    }
    a(paramContext, paramPermissionRequest, (String[])localObject1, paramString);
    AppMethodBeat.o(295898);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/modeltools/WebViewPermissionRequestHelper$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b WOk;
    
    static
    {
      AppMethodBeat.i(295782);
      WOk = new b();
      AppMethodBeat.o(295782);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final c WOl;
    
    static
    {
      AppMethodBeat.i(295792);
      WOl = new c();
      AppMethodBeat.o(295792);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(j paramj, Context paramContext, String paramString1, String paramString2, GeolocationPermissions.Callback paramCallback, String paramString3, int paramInt, String paramString4, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(295810);
      paramObject = (d)new d(this.WOm, paramContext, paramString4, paramString1, paramCallback, paramString2, paramInt, paramString3, paramd);
      AppMethodBeat.o(295810);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(295806);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(295806);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = paramContext;
        localObject1 = paramContext.getString(c.i.wv_get_location_msg, new Object[] { paramString4 });
        s.s(localObject1, "context.getString(R.stri…get_location_msg, origin)");
        localObject2 = (d)this;
        this.label = 1;
        localObject1 = j.b(paramObject, (String)localObject1, (d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(295806);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        if (!((Boolean)paramObject).booleanValue())
        {
          j.a(this.WOm, false, paramString1, paramString4, paramCallback);
          h.OAn.b(14340, new Object[] { aa.aUC(paramString2), aa.aUC(paramString1), Integer.valueOf(paramInt), paramString3, Integer.valueOf(ba.ctm()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          paramObject = ah.aiuX;
          AppMethodBeat.o(295806);
          return paramObject;
        }
        h.OAn.b(14340, new Object[] { aa.aUC(paramString2), aa.aUC(paramString1), Integer.valueOf(paramInt), paramString3, Integer.valueOf(ba.ctm()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        paramObject = p.al(new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        localObject1 = this.WOm;
        localObject2 = paramContext;
        d locald = (d)this;
        this.label = 2;
        localObject1 = j.a((j)localObject1, (Context)localObject2, paramObject, locald);
        paramObject = localObject1;
        if (localObject1 != locala) {
          break label417;
        }
        AppMethodBeat.o(295806);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label417:
      if (((Boolean)paramObject).booleanValue()) {
        j.a(this.WOm, true, paramString1, paramString4, paramCallback);
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(295806);
        return paramObject;
        j.a(this.WOm, false, paramString1, paramString4, paramCallback);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(Context paramContext, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    f(j paramj, Context paramContext, ah.f<String> paramf, PermissionRequest paramPermissionRequest, String paramString, String[] paramArrayOfString, d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(295791);
      paramObject = (d)new f(this.WOm, paramContext, localf, paramPermissionRequest, paramString, paramArrayOfString, paramd);
      AppMethodBeat.o(295791);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(295784);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(295784);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = paramContext;
        localObject1 = (String)localf.aqH;
        localObject2 = (d)this;
        this.label = 1;
        localObject1 = j.b(paramObject, (String)localObject1, (d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(295784);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        if (!((Boolean)paramObject).booleanValue())
        {
          Log.i("MicroMsg.WebViewPermissionRequestHelper", "onPermissionRequest cancel");
          j.a(this.WOm, paramPermissionRequest, paramString, false);
          paramObject = ah.aiuX;
          AppMethodBeat.o(295784);
          return paramObject;
        }
        paramObject = new ArrayList();
        if ((kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.AUDIO_CAPTURE")) && (!b.s(paramContext, "android.permission.RECORD_AUDIO"))) {
          paramObject.add("android.permission.RECORD_AUDIO");
        }
        if ((kotlin.a.k.contains(paramArrayOfString, "android.webkit.resource.VIDEO_CAPTURE")) && (!b.s(paramContext, "android.permission.CAMERA"))) {
          paramObject.add("android.permission.CAMERA");
        }
        if (((Collection)paramObject).isEmpty()) {
          i = 1;
        }
        break;
      }
      while (i == 0)
      {
        localObject1 = this.WOm;
        localObject2 = paramContext;
        d locald = (d)this;
        this.label = 2;
        localObject1 = j.a((j)localObject1, (Context)localObject2, paramObject, locald);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(295784);
          return locala;
          i = 0;
          continue;
          ResultKt.throwOnFailure(paramObject);
        }
        else if (!((Boolean)paramObject).booleanValue())
        {
          j.a(this.WOm, paramPermissionRequest, paramString, false);
        }
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(295784);
        return paramObject;
        j.a(this.WOm, paramPermissionRequest, paramString, true);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "permissions", "", "", "kotlin.jvm.PlatformType", "grantResults", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    implements e.f
  {
    g(d<? super Boolean> paramd, j paramj, Context paramContext) {}
    
    public final void onResult(String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(295794);
      if (paramArrayOfInt != null) {
        if (paramArrayOfInt.length != 0) {
          break label57;
        }
      }
      label57:
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.WebViewPermissionRequestHelper", "grantResults empty");
        paramArrayOfString = this.ntL;
        paramArrayOfInt = Boolean.FALSE;
        localObject = Result.Companion;
        paramArrayOfString.resumeWith(Result.constructor-impl(paramArrayOfInt));
        AppMethodBeat.o(295794);
        return;
      }
      Object localObject = new LinkedList();
      int k = paramArrayOfString.length - 1;
      boolean bool;
      int j;
      if (k >= 0)
      {
        i = 0;
        bool = true;
        j = i + 1;
        if (paramArrayOfInt[i] != 0)
        {
          Log.i("MicroMsg.WebViewPermissionRequestHelper", "showSysPermissionAlert PERMISSION_GRANTED, %s", new Object[] { paramArrayOfString[i] });
          ((LinkedList)localObject).add(paramArrayOfString[i]);
          bool = false;
        }
        if (j <= k) {}
      }
      for (;;)
      {
        j.a(this.$context, (LinkedList)localObject);
        Log.i("MicroMsg.WebViewPermissionRequestHelper", s.X("showSysPermissionAlert isGrant=", Boolean.valueOf(bool)));
        paramArrayOfString = this.ntL;
        paramArrayOfInt = Result.Companion;
        paramArrayOfString.resumeWith(Result.constructor-impl(Boolean.valueOf(bool)));
        AppMethodBeat.o(295794);
        return;
        i = j;
        break;
        bool = true;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(d<? super Boolean> paramd) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(295790);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "showWebPermissionAlert ok");
      paramDialogInterface = this.ntL;
      Boolean localBoolean = Boolean.TRUE;
      Result.Companion localCompanion = Result.Companion;
      paramDialogInterface.resumeWith(Result.constructor-impl(localBoolean));
      AppMethodBeat.o(295790);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    implements DialogInterface.OnClickListener
  {
    i(d<? super Boolean> paramd) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(295789);
      Log.i("MicroMsg.WebViewPermissionRequestHelper", "showWebPermissionAlert cancel");
      paramDialogInterface = this.ntL;
      Boolean localBoolean = Boolean.FALSE;
      Result.Companion localCompanion = Result.Companion;
      paramDialogInterface.resumeWith(Result.constructor-impl(localBoolean));
      AppMethodBeat.o(295789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.j
 * JD-Core Version:    0.7.0.1
 */