package com.tencent.mm.plugin.webview.core;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.i.f;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class m
{
  private static final Map<String, LinkedList<a>> PJh;
  private static final int PJi = 3;
  public static final m PJj;
  private static final String TAG = "MicroMsg.WebViewUIConnectionPool";
  
  static
  {
    AppMethodBeat.i(205133);
    PJj = new m();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    PJh = (Map)new HashMap();
    PJi = 3;
    AppMethodBeat.o(205133);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, d paramd)
  {
    AppMethodBeat.i(205132);
    p.k(paramClass, "stubService");
    p.k(paramd, "binder");
    int i;
    if (paramBoolean) {
      if (!((Collection)bt(paramClass)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        paramClass = bt(paramClass).pop();
        f.gWT();
        Log.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      p.k(paramd, "binder");
      paramClass.PJk = paramd;
      paramClass.bPe();
      Log.i(TAG, "attach service");
      AppMethodBeat.o(205132);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = MMApplicationContext.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        f.gWS();
      }
      Log.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> bt(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(205130);
    String str = paramClass.getCanonicalName();
    if (str == null) {
      p.iCn();
    }
    p.j(str, "stubService.canonicalName!!");
    LinkedList localLinkedList = (LinkedList)PJh.get(str);
    paramClass = localLinkedList;
    if (localLinkedList == null)
    {
      paramClass = new LinkedList();
      PJh.put(str, paramClass);
    }
    AppMethodBeat.o(205130);
    return paramClass;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
  public static final class a
    implements ServiceConnection
  {
    final boolean JbE;
    d PJk;
    final Class<? extends Service> PvH;
    e pGC;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(213716);
      this.JbE = paramBoolean;
      this.PvH = paramClass;
      AppMethodBeat.o(213716);
    }
    
    final void bPe()
    {
      AppMethodBeat.i(213714);
      if (this.pGC != null)
      {
        d locald = this.PJk;
        if (locald != null)
        {
          locald.a((c)new a(this));
          AppMethodBeat.o(213714);
          return;
        }
      }
      AppMethodBeat.o(213714);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(213711);
      m localm = m.PJj;
      Log.i(m.gTc(), "connected:".concat(String.valueOf(paramComponentName)));
      this.pGC = e.a.L(paramIBinder);
      bPe();
      AppMethodBeat.o(213711);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(213708);
      m localm = m.PJj;
      Log.i(m.gTc(), "disconnected:".concat(String.valueOf(paramComponentName)));
      this.pGC = null;
      paramComponentName = this.PJk;
      if ((paramComponentName != null) && (paramComponentName.gPK()))
      {
        localm = m.PJj;
        m.a(this.JbE, this.PvH, paramComponentName);
      }
      this.PJk = null;
      paramComponentName = m.PJj;
      m.bu(this.PvH).remove(this);
      AppMethodBeat.o(213708);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
    public static final class a
      implements c
    {
      public final void close()
      {
        AppMethodBeat.i(206592);
        Object localObject = this.PJl;
        ((m.a)localObject).PJk = null;
        if (((m.a)localObject).JbE)
        {
          m localm = m.PJj;
          int i = m.bu(((m.a)localObject).PvH).size();
          localm = m.PJj;
          if (i < m.gTd())
          {
            localm = m.PJj;
            m.bu(((m.a)localObject).PvH).add(localObject);
            localObject = m.PJj;
            Log.i(m.gTc(), "detach with reuse service");
            AppMethodBeat.o(206592);
            return;
          }
        }
        try
        {
          MMApplicationContext.getContext().unbindService((ServiceConnection)localObject);
          label92:
          localObject = m.PJj;
          Log.i(m.gTc(), "detach unbind service");
          AppMethodBeat.o(206592);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          break label92;
        }
      }
      
      public final e gSm()
      {
        AppMethodBeat.i(206590);
        e locale = this.PJl.pGC;
        if (locale == null) {
          p.iCn();
        }
        AppMethodBeat.o(206590);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.m
 * JD-Core Version:    0.7.0.1
 */