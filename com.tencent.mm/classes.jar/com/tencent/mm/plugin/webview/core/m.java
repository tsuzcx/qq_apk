package com.tencent.mm.plugin.webview.core;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.i.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool;", "", "()V", "MAX", "", "TAG", "", "pools", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "bind", "", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getPool", "ShareServiceConnection", "webview-sdk_release"})
public final class m
{
  private static final Map<String, LinkedList<a>> INb;
  public static final m INc;
  private static final int MAX = 3;
  private static final String TAG = "MicroMsg.WebViewUIConnectionPool";
  
  static
  {
    AppMethodBeat.i(225084);
    INc = new m();
    TAG = "MicroMsg.WebViewUIConnectionPool";
    INb = (Map)new HashMap();
    MAX = 3;
    AppMethodBeat.o(225084);
  }
  
  public static void a(boolean paramBoolean, Class<? extends Service> paramClass, d paramd)
  {
    AppMethodBeat.i(225083);
    p.h(paramClass, "stubService");
    p.h(paramd, "binder");
    int i;
    if (paramBoolean) {
      if (!((Collection)aY(paramClass)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        paramClass = aY(paramClass).pop();
        b.gdS();
        Log.i(TAG, "reuse service");
      }
    }
    label100:
    a locala;
    for (paramClass = (a)paramClass;; paramClass = locala)
    {
      p.h(paramd, "binder");
      paramClass.INd = paramd;
      paramClass.bDD();
      Log.i(TAG, "attach service");
      AppMethodBeat.o(225083);
      return;
      i = 0;
      break;
      locala = new a(paramBoolean, paramClass);
      Context localContext = MMApplicationContext.getContext();
      localContext.bindService(new Intent(localContext, paramClass), (ServiceConnection)locala, 1);
      if (paramBoolean) {
        b.gdR();
      }
      Log.i(TAG, "bind new service");
    }
  }
  
  private static LinkedList<a> aY(Class<? extends Service> paramClass)
  {
    AppMethodBeat.i(225082);
    String str = paramClass.getCanonicalName();
    if (str == null) {
      p.hyc();
    }
    p.g(str, "stubService.canonicalName!!");
    LinkedList localLinkedList = (LinkedList)INb.get(str);
    paramClass = localLinkedList;
    if (localLinkedList == null)
    {
      paramClass = new LinkedList();
      INb.put(str, paramClass);
    }
    AppMethodBeat.o(225082);
    return paramClass;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection;", "Landroid/content/ServiceConnection;", "reuse", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "(ZLjava/lang/Class;)V", "binder", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "getBinder", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "setBinder", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;)V", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "getReuse", "()Z", "attach", "", "detach", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "tryBind", "webview-sdk_release"})
  public static final class a
    implements ServiceConnection
  {
    final boolean CVS;
    final Class<? extends Service> IBu;
    d INd;
    e mHh;
    
    public a(boolean paramBoolean, Class<? extends Service> paramClass)
    {
      AppMethodBeat.i(225081);
      this.CVS = paramBoolean;
      this.IBu = paramClass;
      AppMethodBeat.o(225081);
    }
    
    final void bDD()
    {
      AppMethodBeat.i(225080);
      if (this.mHh != null)
      {
        d locald = this.INd;
        if (locald != null)
        {
          locald.a((c)new a(this));
          AppMethodBeat.o(225080);
          return;
        }
      }
      AppMethodBeat.o(225080);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(225079);
      m localm = m.INc;
      Log.i(m.gak(), "connected:".concat(String.valueOf(paramComponentName)));
      this.mHh = e.a.H(paramIBinder);
      bDD();
      AppMethodBeat.o(225079);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(225078);
      m localm = m.INc;
      Log.i(m.gak(), "disconnected:".concat(String.valueOf(paramComponentName)));
      this.mHh = null;
      paramComponentName = this.INd;
      if ((paramComponentName != null) && (paramComponentName.fXa()))
      {
        localm = m.INc;
        m.a(this.CVS, this.IBu, paramComponentName);
      }
      this.INd = null;
      paramComponentName = m.INc;
      m.aZ(this.IBu).remove(this);
      AppMethodBeat.o(225078);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewUIConnectionPool$ShareServiceConnection$tryBind$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "close", "", "webview-sdk_release"})
    public static final class a
      implements c
    {
      public final void close()
      {
        AppMethodBeat.i(225077);
        Object localObject = this.INe;
        ((m.a)localObject).INd = null;
        if (((m.a)localObject).CVS)
        {
          m localm = m.INc;
          int i = m.aZ(((m.a)localObject).IBu).size();
          localm = m.INc;
          if (i < m.gal())
          {
            localm = m.INc;
            m.aZ(((m.a)localObject).IBu).add(localObject);
            localObject = m.INc;
            Log.i(m.gak(), "detach with reuse service");
            AppMethodBeat.o(225077);
            return;
          }
        }
        MMApplicationContext.getContext().unbindService((ServiceConnection)localObject);
        localObject = m.INc;
        Log.i(m.gak(), "detach unbind service");
        AppMethodBeat.o(225077);
      }
      
      public final e fZs()
      {
        AppMethodBeat.i(225076);
        e locale = this.INe.mHh;
        if (locale == null) {
          p.hyc();
        }
        AppMethodBeat.o(225076);
        return locale;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.m
 * JD-Core Version:    0.7.0.1
 */