package com.tencent.mm.plugin.webview.core;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.h.h;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final String TAG;
  public static final o WzA;
  private static final Map<String, LinkedList<a>> WzB;
  private static final int WzC;
  
  static
  {
    AppMethodBeat.i(295112);
    WzA = new o();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    WzB = (Map)new HashMap();
    WzC = 3;
    AppMethodBeat.o(295112);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, f paramf)
  {
    AppMethodBeat.i(295091);
    s.u(paramClass, "stubService");
    s.u(paramf, "binder");
    int i;
    if (paramBoolean) {
      if (!((Collection)cd(paramClass)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        paramClass = cd(paramClass).pop();
        h.iwK();
        Log.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      s.u(paramf, "binder");
      paramClass.WzD = paramf;
      paramClass.cpt();
      Log.i(TAG, "attach service");
      AppMethodBeat.o(295091);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = MMApplicationContext.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        h.iwJ();
      }
      Log.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> cd(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(295081);
    paramClass = paramClass.getCanonicalName();
    s.checkNotNull(paramClass);
    LinkedList localLinkedList = (LinkedList)WzB.get(paramClass);
    if (localLinkedList == null)
    {
      localLinkedList = new LinkedList();
      WzB.put(paramClass, localLinkedList);
      AppMethodBeat.o(295081);
      return localLinkedList;
    }
    AppMethodBeat.o(295081);
    return localLinkedList;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ServiceConnection
  {
    final boolean Plu;
    final Class<? extends Service> WlU;
    f WzD;
    com.tencent.mm.plugin.webview.stub.e sLC;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(294944);
      this.Plu = paramBoolean;
      this.WlU = paramClass;
      AppMethodBeat.o(294944);
    }
    
    final void cpt()
    {
      AppMethodBeat.i(294963);
      if (this.sLC != null)
      {
        f localf = this.WzD;
        if (localf != null) {
          localf.a((e)new a(this));
        }
      }
      AppMethodBeat.o(294963);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(294955);
      Log.i(o.aUw(), s.X("connected:", paramComponentName));
      this.sLC = e.a.Q(paramIBinder);
      cpt();
      AppMethodBeat.o(294955);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(294949);
      Log.i(o.aUw(), s.X("disconnected:", paramComponentName));
      this.sLC = null;
      paramComponentName = this.WzD;
      if ((paramComponentName != null) && (paramComponentName.fTZ()))
      {
        o localo = o.WzA;
        o.a(this.Plu, this.WlU, paramComponentName);
      }
      this.WzD = null;
      paramComponentName = o.WzA;
      o.ce(this.WlU).remove(this);
      AppMethodBeat.o(294949);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements e
    {
      a(o.a parama) {}
      
      public final void close()
      {
        AppMethodBeat.i(295113);
        o.a locala = this.WzE;
        locala.WzD = null;
        if (locala.Plu)
        {
          o localo = o.WzA;
          if (o.ce(locala.WlU).size() < o.isO())
          {
            localo = o.WzA;
            o.ce(locala.WlU).add(locala);
            Log.i(o.aUw(), "detach with reuse service");
            AppMethodBeat.o(295113);
            return;
          }
        }
        try
        {
          MMApplicationContext.getContext().unbindService((ServiceConnection)locala);
          label82:
          Log.i(o.aUw(), "detach unbind service");
          AppMethodBeat.o(295113);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          break label82;
        }
      }
      
      public final com.tencent.mm.plugin.webview.stub.e irJ()
      {
        AppMethodBeat.i(295103);
        com.tencent.mm.plugin.webview.stub.e locale = this.WzE.sLC;
        s.checkNotNull(locale);
        AppMethodBeat.o(295103);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.o
 * JD-Core Version:    0.7.0.1
 */