package com.tencent.mm.plugin.webview.core;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.h.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class l
{
  private static final Map<String, LinkedList<a>> EaO;
  public static final l EaP;
  private static final int MAX = 3;
  private static final String TAG = "MicroMsg.WebViewUIConnectionPool";
  
  static
  {
    AppMethodBeat.i(214153);
    EaP = new l();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    EaO = (Map)new HashMap();
    MAX = 3;
    AppMethodBeat.o(214153);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, d paramd)
  {
    AppMethodBeat.i(214152);
    p.h(paramClass, "stubService");
    p.h(paramd, "binder");
    int i;
    if (paramBoolean) {
      if (!((Collection)aW(paramClass)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        paramClass = aW(paramClass).pop();
        b.eVd();
        ae.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      p.h(paramd, "binder");
      paramClass.EaQ = paramd;
      paramClass.bio();
      ae.i(TAG, "attach service");
      AppMethodBeat.o(214152);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = ak.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        b.eVc();
      }
      ae.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> aW(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(214151);
    String str = paramClass.getCanonicalName();
    if (str == null) {
      p.gkB();
    }
    LinkedList localLinkedList = (LinkedList)EaO.get(str);
    paramClass = localLinkedList;
    if (localLinkedList == null)
    {
      paramClass = new LinkedList();
      EaO.put(str, paramClass);
    }
    AppMethodBeat.o(214151);
    return paramClass;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
  public static final class a
    implements ServiceConnection
  {
    final Class<? extends Service> DRv;
    d EaQ;
    final boolean EaR;
    e lzT;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(214150);
      this.EaR = paramBoolean;
      this.DRv = paramClass;
      AppMethodBeat.o(214150);
    }
    
    final void bio()
    {
      AppMethodBeat.i(214149);
      if (this.lzT != null)
      {
        d locald = this.EaQ;
        if (locald != null)
        {
          locald.a((c)new a(this));
          AppMethodBeat.o(214149);
          return;
        }
      }
      AppMethodBeat.o(214149);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(214148);
      l locall = l.EaP;
      ae.i(l.eRC(), "connected:".concat(String.valueOf(paramComponentName)));
      this.lzT = e.a.H(paramIBinder);
      bio();
      AppMethodBeat.o(214148);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(214147);
      l locall = l.EaP;
      ae.i(l.eRC(), "disconnected:".concat(String.valueOf(paramComponentName)));
      this.lzT = null;
      paramComponentName = this.EaQ;
      if ((paramComponentName != null) && (paramComponentName.ePi()))
      {
        locall = l.EaP;
        l.a(this.EaR, this.DRv, paramComponentName);
      }
      this.EaQ = null;
      paramComponentName = l.EaP;
      l.aX(this.DRv).remove(this);
      AppMethodBeat.o(214147);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
    public static final class a
      implements c
    {
      public final void close()
      {
        AppMethodBeat.i(214146);
        Object localObject = this.EaS;
        ((l.a)localObject).EaQ = null;
        if (((l.a)localObject).EaR)
        {
          l locall = l.EaP;
          int i = l.aX(((l.a)localObject).DRv).size();
          locall = l.EaP;
          if (i < l.eRD())
          {
            locall = l.EaP;
            l.aX(((l.a)localObject).DRv).add(localObject);
            localObject = l.EaP;
            ae.i(l.eRC(), "detach with reuse service");
            AppMethodBeat.o(214146);
            return;
          }
        }
        ak.getContext().unbindService((ServiceConnection)localObject);
        localObject = l.EaP;
        ae.i(l.eRC(), "detach unbind service");
        AppMethodBeat.o(214146);
      }
      
      public final e eQS()
      {
        AppMethodBeat.i(214145);
        e locale = this.EaS.lzT;
        if (locale == null) {
          p.gkB();
        }
        AppMethodBeat.o(214145);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.l
 * JD-Core Version:    0.7.0.1
 */