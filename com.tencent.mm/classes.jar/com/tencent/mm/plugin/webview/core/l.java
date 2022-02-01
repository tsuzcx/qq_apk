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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class l
{
  private static final Map<String, LinkedList<a>> ANu;
  public static final l ANv;
  private static final int MAX = 3;
  private static final String TAG = "MicroMsg.WebViewUIConnectionPool";
  
  static
  {
    AppMethodBeat.i(189391);
    ANv = new l();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    ANu = (Map)new HashMap();
    MAX = 3;
    AppMethodBeat.o(189391);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, d paramd)
  {
    AppMethodBeat.i(189390);
    k.h(paramClass, "stubService");
    k.h(paramd, "binder");
    int i;
    if (paramBoolean) {
      if (!((Collection)aT(paramClass)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        paramClass = aT(paramClass).pop();
        b.enc();
        ad.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      k.h(paramd, "binder");
      paramClass.ANw = paramd;
      paramClass.aXe();
      ad.i(TAG, "attach service");
      AppMethodBeat.o(189390);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = aj.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        b.enb();
      }
      ad.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> aT(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(189389);
    String str = paramClass.getCanonicalName();
    if (str == null) {
      k.fvU();
    }
    LinkedList localLinkedList = (LinkedList)ANu.get(str);
    paramClass = localLinkedList;
    if (localLinkedList == null)
    {
      paramClass = new LinkedList();
      ANu.put(str, paramClass);
    }
    AppMethodBeat.o(189389);
    return paramClass;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
  public static final class a
    implements ServiceConnection
  {
    d ANw;
    final boolean ANx;
    final Class<? extends Service> ANy;
    e kxf;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(189388);
      this.ANx = paramBoolean;
      this.ANy = paramClass;
      AppMethodBeat.o(189388);
    }
    
    final void aXe()
    {
      AppMethodBeat.i(189387);
      if (this.kxf != null)
      {
        d locald = this.ANw;
        if (locald != null)
        {
          locald.a((c)new a(this));
          AppMethodBeat.o(189387);
          return;
        }
      }
      AppMethodBeat.o(189387);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(189386);
      l locall = l.ANv;
      ad.i(l.ejH(), "connected:".concat(String.valueOf(paramComponentName)));
      this.kxf = e.a.G(paramIBinder);
      aXe();
      AppMethodBeat.o(189386);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(189385);
      l locall = l.ANv;
      ad.i(l.ejH(), "disconnected:".concat(String.valueOf(paramComponentName)));
      this.kxf = null;
      paramComponentName = this.ANw;
      if ((paramComponentName != null) && (paramComponentName.ejl()))
      {
        locall = l.ANv;
        l.a(this.ANx, this.ANy, paramComponentName);
      }
      this.ANw = null;
      paramComponentName = l.ANv;
      l.aU(this.ANy).remove(this);
      AppMethodBeat.o(189385);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
    public static final class a
      implements c
    {
      public final void close()
      {
        AppMethodBeat.i(189384);
        Object localObject = this.ANz;
        ((l.a)localObject).ANw = null;
        if (((l.a)localObject).ANx)
        {
          l locall = l.ANv;
          int i = l.aU(((l.a)localObject).ANy).size();
          locall = l.ANv;
          if (i < l.ejI())
          {
            locall = l.ANv;
            l.aU(((l.a)localObject).ANy).add(localObject);
            localObject = l.ANv;
            ad.i(l.ejH(), "detach with reuse service");
            AppMethodBeat.o(189384);
            return;
          }
        }
        aj.getContext().unbindService((ServiceConnection)localObject);
        localObject = l.ANv;
        ad.i(l.ejH(), "detach unbind service");
        AppMethodBeat.o(189384);
      }
      
      public final e eiX()
      {
        AppMethodBeat.i(189383);
        e locale = this.ANz.kxf;
        if (locale == null) {
          k.fvU();
        }
        AppMethodBeat.o(189383);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.l
 * JD-Core Version:    0.7.0.1
 */