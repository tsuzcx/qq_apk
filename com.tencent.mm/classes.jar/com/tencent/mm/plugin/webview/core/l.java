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
import d.g.b.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class l
{
  private static final Map<String, LinkedList<a>> DIQ;
  public static final l DIR;
  private static final int MAX = 3;
  private static final String TAG = "MicroMsg.WebViewUIConnectionPool";
  
  static
  {
    AppMethodBeat.i(214312);
    DIR = new l();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    DIQ = (Map)new HashMap();
    MAX = 3;
    AppMethodBeat.o(214312);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, d paramd)
  {
    AppMethodBeat.i(214311);
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
        b.eRr();
        ad.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      p.h(paramd, "binder");
      paramClass.DIS = paramd;
      paramClass.bhG();
      ad.i(TAG, "attach service");
      AppMethodBeat.o(214311);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = aj.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        b.eRq();
      }
      ad.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> aW(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(214310);
    String str = paramClass.getCanonicalName();
    if (str == null) {
      p.gfZ();
    }
    LinkedList localLinkedList = (LinkedList)DIQ.get(str);
    paramClass = localLinkedList;
    if (localLinkedList == null)
    {
      paramClass = new LinkedList();
      DIQ.put(str, paramClass);
    }
    AppMethodBeat.o(214310);
    return paramClass;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
  public static final class a
    implements ServiceConnection
  {
    d DIS;
    final boolean DIT;
    final Class<? extends Service> DzN;
    e lvv;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(214309);
      this.DIT = paramBoolean;
      this.DzN = paramClass;
      AppMethodBeat.o(214309);
    }
    
    final void bhG()
    {
      AppMethodBeat.i(214308);
      if (this.lvv != null)
      {
        d locald = this.DIS;
        if (locald != null)
        {
          locald.a((c)new a(this));
          AppMethodBeat.o(214308);
          return;
        }
      }
      AppMethodBeat.o(214308);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(214307);
      l locall = l.DIR;
      ad.i(l.eNR(), "connected:".concat(String.valueOf(paramComponentName)));
      this.lvv = e.a.G(paramIBinder);
      bhG();
      AppMethodBeat.o(214307);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(214306);
      l locall = l.DIR;
      ad.i(l.eNR(), "disconnected:".concat(String.valueOf(paramComponentName)));
      this.lvv = null;
      paramComponentName = this.DIS;
      if ((paramComponentName != null) && (paramComponentName.eLz()))
      {
        locall = l.DIR;
        l.a(this.DIT, this.DzN, paramComponentName);
      }
      this.DIS = null;
      paramComponentName = l.DIR;
      l.aX(this.DzN).remove(this);
      AppMethodBeat.o(214306);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
    public static final class a
      implements c
    {
      public final void close()
      {
        AppMethodBeat.i(214305);
        Object localObject = this.DIU;
        ((l.a)localObject).DIS = null;
        if (((l.a)localObject).DIT)
        {
          l locall = l.DIR;
          int i = l.aX(((l.a)localObject).DzN).size();
          locall = l.DIR;
          if (i < l.eNS())
          {
            locall = l.DIR;
            l.aX(((l.a)localObject).DzN).add(localObject);
            localObject = l.DIR;
            ad.i(l.eNR(), "detach with reuse service");
            AppMethodBeat.o(214305);
            return;
          }
        }
        aj.getContext().unbindService((ServiceConnection)localObject);
        localObject = l.DIR;
        ad.i(l.eNR(), "detach unbind service");
        AppMethodBeat.o(214305);
      }
      
      public final e eNh()
      {
        AppMethodBeat.i(214304);
        e locale = this.DIU.lvv;
        if (locale == null) {
          p.gfZ();
        }
        AppMethodBeat.o(214304);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.l
 * JD-Core Version:    0.7.0.1
 */