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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class l
{
  private static final Map<String, LinkedList<a>> CfM;
  public static final l CfN;
  private static final int MAX = 3;
  private static final String TAG = "MicroMsg.WebViewUIConnectionPool";
  
  static
  {
    AppMethodBeat.i(205523);
    CfN = new l();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    CfM = (Map)new HashMap();
    MAX = 3;
    AppMethodBeat.o(205523);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, d paramd)
  {
    AppMethodBeat.i(205522);
    k.h(paramClass, "stubService");
    k.h(paramd, "binder");
    int i;
    if (paramBoolean) {
      if (!((Collection)aU(paramClass)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        paramClass = aU(paramClass).pop();
        b.eCx();
        ac.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      k.h(paramd, "binder");
      paramClass.CfO = paramd;
      paramClass.bec();
      ac.i(TAG, "attach service");
      AppMethodBeat.o(205522);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = ai.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        b.eCw();
      }
      ac.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> aU(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(205521);
    String str = paramClass.getCanonicalName();
    if (str == null) {
      k.fOy();
    }
    LinkedList localLinkedList = (LinkedList)CfM.get(str);
    paramClass = localLinkedList;
    if (localLinkedList == null)
    {
      paramClass = new LinkedList();
      CfM.put(str, paramClass);
    }
    AppMethodBeat.o(205521);
    return paramClass;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
  public static final class a
    implements ServiceConnection
  {
    d CfO;
    final boolean CfP;
    final Class<? extends Service> CfQ;
    e kYt;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(205520);
      this.CfP = paramBoolean;
      this.CfQ = paramClass;
      AppMethodBeat.o(205520);
    }
    
    final void bec()
    {
      AppMethodBeat.i(205519);
      if (this.kYt != null)
      {
        d locald = this.CfO;
        if (locald != null)
        {
          locald.a((c)new a(this));
          AppMethodBeat.o(205519);
          return;
        }
      }
      AppMethodBeat.o(205519);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(205518);
      l locall = l.CfN;
      ac.i(l.ezc(), "connected:".concat(String.valueOf(paramComponentName)));
      this.kYt = e.a.G(paramIBinder);
      bec();
      AppMethodBeat.o(205518);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(205517);
      l locall = l.CfN;
      ac.i(l.ezc(), "disconnected:".concat(String.valueOf(paramComponentName)));
      this.kYt = null;
      paramComponentName = this.CfO;
      if ((paramComponentName != null) && (paramComponentName.eyG()))
      {
        locall = l.CfN;
        l.a(this.CfP, this.CfQ, paramComponentName);
      }
      this.CfO = null;
      paramComponentName = l.CfN;
      l.aV(this.CfQ).remove(this);
      AppMethodBeat.o(205517);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
    public static final class a
      implements c
    {
      public final void close()
      {
        AppMethodBeat.i(205516);
        Object localObject = this.CfR;
        ((l.a)localObject).CfO = null;
        if (((l.a)localObject).CfP)
        {
          l locall = l.CfN;
          int i = l.aV(((l.a)localObject).CfQ).size();
          locall = l.CfN;
          if (i < l.ezd())
          {
            locall = l.CfN;
            l.aV(((l.a)localObject).CfQ).add(localObject);
            localObject = l.CfN;
            ac.i(l.ezc(), "detach with reuse service");
            AppMethodBeat.o(205516);
            return;
          }
        }
        ai.getContext().unbindService((ServiceConnection)localObject);
        localObject = l.CfN;
        ac.i(l.ezc(), "detach unbind service");
        AppMethodBeat.o(205516);
      }
      
      public final e eyr()
      {
        AppMethodBeat.i(205515);
        e locale = this.CfR.kYt;
        if (locale == null) {
          k.fOy();
        }
        AppMethodBeat.o(205515);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.l
 * JD-Core Version:    0.7.0.1
 */