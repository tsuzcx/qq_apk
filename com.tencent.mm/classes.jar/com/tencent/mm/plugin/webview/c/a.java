package com.tencent.mm.plugin.webview.c;

import android.net.Uri;
import com.tencent.mars.cdn.CronetLogic.ChunkedData;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.g;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ao;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "canDebug", "", "fetchPage", "", "", "", "url", "header", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "overrideProcessResult", "reason", "", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideRequestAuthCurrentUrl", "overrideUrlRedirect", "forceRedirect", "fullUrl", "callback", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.webview.core.m
{
  public static final a WDm;
  
  static
  {
    AppMethodBeat.i(294805);
    WDm = new a((byte)0);
    AppMethodBeat.o(294805);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(294820);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "fullUrl");
    if ((!paramBoolean) && (paramInt == 11))
    {
      AppMethodBeat.o(294820);
      return true;
    }
    AppMethodBeat.o(294820);
    return false;
  }
  
  public final boolean b(int paramInt, final String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(294828);
    s.u(paramString, "reqUrl");
    s.u(paramcdf, "resp");
    if (paramInt != 11)
    {
      AppMethodBeat.o(294828);
      return false;
    }
    final ah.f localf = new ah.f();
    localf.aqH = getController().sMP.getUrl();
    if (!n.T(paramString, (String)localf.aqH, true))
    {
      Log.e("MicroMsg.BizMpVideoInterceptor", "url changed after do get A8key, webUrl:" + localf.aqH + ", reqUrl:" + paramString);
      AppMethodBeat.o(294828);
      return false;
    }
    if ((paramcdf.aanp.aalV & 0x200000) > 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      Log.i("MicroMsg.BizMpVideoInterceptor", "spa auth getA8key not allow");
      paramString = g.XmS;
      g.b(getController().getJsapi(), "a8key not allow");
      AppMethodBeat.o(294828);
      return false;
    }
    Log.i("MicroMsg.BizMpVideoInterceptor", "on spa auth resp handle start");
    j.a((aq)bu.ajwo, null, null, (kotlin.g.a.m)new d(paramcdf, this, paramString, localf, null), 3);
    AppMethodBeat.o(294828);
    return true;
  }
  
  public final boolean isL()
  {
    AppMethodBeat.i(294815);
    Object localObject = getController().getCurrentUrl();
    if ((localObject != null) && (n.U((String)localObject, "https", false) == true)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = g.XmS;
      g.b(getController().getJsapi(), "url is invalid");
      AppMethodBeat.o(294815);
      return false;
    }
    localObject = getController().getCurrentUrl();
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(294815);
      return false;
    }
    Log.i("MicroMsg.BizMpVideoInterceptor", s.X("RequestAuthCurrentUrl startGetA8Key:", localObject));
    getController().m((String)localObject, true, 11);
    AppMethodBeat.o(294815);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor$Companion;", "", "()V", "DEFAULT_DOWNLOAD_PATH", "", "HEADER_SET_COOKIE", "REQ_HEADER_REQUEST_COOKIE", "TAG", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor$callback$1$2", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveChunkedData", "", "protocol", "Lcom/tencent/mars/cdn/CronetLogic$ChunkedData;", "length", "", "onCronetReceiveHeader", "", "header", "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "", "onCronetReceiveUploadProgress", "current", "total", "onCronetTaskCompleted", "filekey", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements CronetLogic.CronetTaskCallback
  {
    b(b<? super CronetLogic.CronetTaskResult, ah> paramb) {}
    
    public final void onCronetReceiveChunkedData(CronetLogic.ChunkedData paramChunkedData, long paramLong) {}
    
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt, String paramString)
    {
      Object localObject = null;
      AppMethodBeat.i(294826);
      s.u(paramString, "protocol");
      if (paramResponseHeader == null) {
        paramResponseHeader = localObject;
      }
      for (;;)
      {
        Log.i("MicroMsg.BizMpVideoInterceptor", s.X("onCronetReceiveHeader: ", paramResponseHeader));
        AppMethodBeat.o(294826);
        return 0;
        paramString = paramResponseHeader.headers;
        paramResponseHeader = localObject;
        if (paramString != null) {
          paramResponseHeader = kotlin.a.k.a(paramString, (CharSequence)", ", null, null, 0, null, null, 62);
        }
      }
    }
    
    public final void onCronetReceiveUploadProgress(long paramLong1, long paramLong2) {}
    
    public final void onCronetTaskCompleted(String paramString1, CronetLogic.CronetTaskResult paramCronetTaskResult, String paramString2)
    {
      paramString1 = null;
      AppMethodBeat.i(294808);
      s.u(paramString2, "protocol");
      this.vUb.invoke(paramCronetTaskResult);
      if (paramCronetTaskResult == null) {}
      for (;;)
      {
        Log.i("MicroMsg.BizMpVideoInterceptor", s.X("onCronetTaskCompleted: ", paramString1));
        AppMethodBeat.o(294808);
        return;
        paramCronetTaskResult = paramCronetTaskResult.headers;
        if (paramCronetTaskResult != null) {
          paramString1 = kotlin.a.k.a(paramCronetTaskResult, (CharSequence)", ", null, null, 0, null, null, 62);
        }
      }
    }
    
    public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<aa, ah>
  {
    c(a parama, Map<String, String> paramMap, d<? super Map<String, ? extends List<String>>> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    d(cdf paramcdf, a parama, String paramString, ah.f<String> paramf, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(294810);
      paramObject = (d)new d(this.WDp, jdField_this, paramString, localf, paramd);
      AppMethodBeat.o(294810);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(294802);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(294802);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.BizMpVideoInterceptor", s.X("fetchPage start:", this.WDp.aanm));
        paramObject = (Map)new LinkedHashMap();
        paramObject.putAll(a.a(jdField_this).WwI);
        paramObject.put("WeChat-SPA-Auth-Req-Flag", "1");
        localObject1 = jdField_this;
        localObject2 = this.WDp.aanm;
        s.s(localObject2, "resp.FullURL");
        localObject3 = (d)this;
        this.label = 1;
        localObject1 = a.a((a)localObject1, (String)localObject2, paramObject, (d)localObject3);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(294802);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (Map)paramObject;
        Log.i("MicroMsg.BizMpVideoInterceptor", s.X("fetchPage end:", this.WDp.aanm));
        paramObject = Uri.parse(this.WDp.aanm).getHost();
        localObject2 = (f)bg.kCh();
        localObject3 = (kotlin.g.a.m)new kotlin.d.b.a.k(localf, jdField_this)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(294781);
            paramAnonymousObject = (d)new 1(this.WDr, this.WDn, paramAnonymousd);
            AppMethodBeat.o(294781);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(294777);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(294777);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            this.WDr.aqH = a.a(this.WDn).sMP.getUrl();
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(294777);
            return paramAnonymousObject;
          }
        };
        localObject4 = (d)this;
        this.L$0 = localObject1;
        this.Uf = paramObject;
        this.label = 2;
        if (l.a((f)localObject2, (kotlin.g.a.m)localObject3, (d)localObject4) == locala)
        {
          AppMethodBeat.o(294802);
          return locala;
        }
        break;
      case 2: 
        localObject2 = (String)this.Uf;
        localObject1 = (Map)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      for (;;)
      {
        if (!n.T(paramString, (String)localf.aqH, true))
        {
          Log.e("MicroMsg.BizMpVideoInterceptor", "url changed after fetch page, webUrl:" + localf.aqH + ", reqUrl:" + paramString);
          paramObject = ah.aiuX;
          AppMethodBeat.o(294802);
          return paramObject;
        }
        if (localObject1 != null)
        {
          localObject3 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            if (paramObject != null)
            {
              localObject2 = (String)((Map.Entry)localObject4).getKey();
              if (localObject2 == null)
              {
                paramObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(294802);
                throw paramObject;
              }
              localObject2 = ((String)localObject2).toLowerCase();
              s.s(localObject2, "(this as java.lang.String).toLowerCase()");
              if (s.p(localObject2, "set-cookie"))
              {
                localObject2 = (List)((Map)localObject1).get(((Map.Entry)localObject4).getKey());
                if (localObject2 == null) {}
                for (localObject2 = null;; localObject2 = Integer.valueOf(((List)localObject2).size()))
                {
                  Log.i("MicroMsg.BizMpVideoInterceptor", s.X("WebView-Trace Spa set cookie:", localObject2));
                  localObject2 = (List)((Map)localObject1).get(((Map.Entry)localObject4).getKey());
                  if (localObject2 == null) {
                    break;
                  }
                  localObject2 = ((Iterable)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ao.setCookie(paramObject, (String)((Iterator)localObject2).next());
                  }
                  break;
                }
              }
            }
          }
        }
        paramObject = (f)bg.kCh();
        localObject1 = (kotlin.g.a.m)new kotlin.d.b.a.k(localf, jdField_this)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(294803);
            paramAnonymousObject = (d)new 2(this.WDr, this.WDn, this.WDq, this.WDp, paramAnonymousd);
            AppMethodBeat.o(294803);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(294793);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(294793);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            this.WDr.aqH = a.a(this.WDn).sMP.getUrl();
            if (n.T(this.WDq, (String)this.WDr.aqH, true))
            {
              Log.i("MicroMsg.BizMpVideoInterceptor", s.X("WebView-Trace Spa notify auth：", this.WDp.aanm));
              a.a(this.WDn).irK().bjQ(this.WDp.aanm);
              paramAnonymousObject = g.XmS;
              paramAnonymousObject = a.a(this.WDn).getJsapi();
              s.u(paramAnonymousObject, "jsApiHandler");
              g.c(paramAnonymousObject, s.X("doAuthCurrentUrl", ":ok"));
            }
            for (;;)
            {
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(294793);
              return paramAnonymousObject;
              Log.e("MicroMsg.BizMpVideoInterceptor", "WebView-Trace Spa auth host not match");
            }
          }
        };
        localObject2 = (d)this;
        this.L$0 = null;
        this.Uf = null;
        this.label = 3;
        if (l.a(paramObject, (kotlin.g.a.m)localObject1, (d)localObject2) == locala)
        {
          AppMethodBeat.o(294802);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(294802);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.a
 * JD-Core Version:    0.7.0.1
 */