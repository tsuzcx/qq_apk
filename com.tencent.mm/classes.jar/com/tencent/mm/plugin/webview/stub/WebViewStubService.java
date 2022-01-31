package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebViewStubService
  extends Service
  implements com.tencent.mm.ai.f
{
  private List<WebViewStubCallbackWrapper> cvl;
  private com.tencent.mm.sdk.b.c eDE;
  private ak handler;
  private n mKL;
  private com.tencent.mm.plugin.webview.model.d.a nlt;
  private Map<String, Integer> uSi;
  private com.tencent.mm.plugin.game.api.g uXR;
  private final SparseArray<Bundle> uZr;
  private d.a uZs;
  private com.tencent.mm.sdk.b.c uZt;
  private int uZu;
  private m uZv;
  private Set<Integer> uZw;
  private int uZx;
  
  public WebViewStubService()
  {
    AppMethodBeat.i(7207);
    this.uZr = new SparseArray();
    this.uZs = new WebViewStubService.1(this);
    this.eDE = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ny paramAnonymousny)
      {
        AppMethodBeat.i(7192);
        if (!(paramAnonymousny instanceof ny))
        {
          AppMethodBeat.o(7192);
          return false;
        }
        if ((WebViewStubService.i(WebViewStubService.this) != null) && (!WebViewStubService.i(WebViewStubService.this).containsKey(paramAnonymousny.cEy.filePath)))
        {
          AppMethodBeat.o(7192);
          return false;
        }
        if (WebViewStubService.i(WebViewStubService.this) != null) {
          WebViewStubService.i(WebViewStubService.this).remove(paramAnonymousny.cEy.filePath);
        }
        com.tencent.mm.a.e.deleteFile(paramAnonymousny.cEy.filePath);
        ab.d("MicroMsg.WebViewStubService", "result: " + paramAnonymousny.cEy.result);
        try
        {
          Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
          while (localIterator.hasNext()) {
            ((WebViewStubCallbackWrapper)localIterator.next()).vdZ.e(paramAnonymousny.cEy.filePath, paramAnonymousny.cEy.result, paramAnonymousny.cEy.cpE, paramAnonymousny.cEy.cpF);
          }
          return false;
        }
        catch (RemoteException paramAnonymousny)
        {
          ab.printErrStackTrace("MicroMsg.WebViewStubService", paramAnonymousny, "", new Object[0]);
          AppMethodBeat.o(7192);
        }
      }
    };
    this.uZt = new WebViewStubService.4(this);
    this.cvl = new ArrayList();
    this.uZu = 0;
    this.uZw = new HashSet();
    this.uZx = -1;
    AppMethodBeat.o(7207);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(7209);
    ab.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
    paramIntent = this.uZs;
    AppMethodBeat.o(7209);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(7208);
    super.onCreate();
    ab.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
    this.handler = new ak();
    this.uZv = new m()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155687);
        ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            Object localObject = d.iJ(paramAnonymousLong);
            if (localObject != null)
            {
              localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
              localBundle.putCharSequence("download_manager_appid", (CharSequence)localObject);
              localBundle.putInt("download_manager_errcode", paramAnonymousInt);
              localWebViewStubCallbackWrapper.vdZ.e(1003, localBundle);
            }
            else
            {
              String str = "";
            }
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + localException.getMessage());
            AppMethodBeat.o(155687);
            return;
          }
        }
        AppMethodBeat.o(155687);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155686);
        ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            paramAnonymousString = d.iJ(paramAnonymousLong);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = paramAnonymousString.field_appId;
              localBundle.putCharSequence("download_manager_appid", paramAnonymousString);
              localWebViewStubCallbackWrapper.vdZ.e(1002, localBundle);
            }
            else
            {
              paramAnonymousString = "";
            }
          }
          catch (Exception paramAnonymousString)
          {
            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + paramAnonymousString.getMessage());
            AppMethodBeat.o(155686);
            return;
          }
        }
        AppMethodBeat.o(155686);
      }
      
      public final void hx(long paramAnonymousLong)
      {
        AppMethodBeat.i(155690);
        try
        {
          Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
          while (localIterator.hasNext())
          {
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramAnonymousLong);
            if ((locala == null) || (locala.field_totalSize == 0L))
            {
              ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
              AppMethodBeat.o(155690);
              return;
            }
            int i = (int)(locala.field_downloadedSize / locala.field_totalSize * 100.0D);
            float f = (float)locala.field_downloadedSize * 100.0F / (float)locala.field_totalSize;
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            localBundle.putInt("download_manager_progress", i);
            localBundle.putFloat("download_manager_progress_float", f);
            localBundle.putString("download_manager_appid", locala.field_appId);
            localWebViewStubCallbackWrapper.vdZ.e(1007, localBundle);
          }
          AppMethodBeat.o(155690);
        }
        catch (Exception localException)
        {
          ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + localException.getMessage());
          AppMethodBeat.o(155690);
          return;
        }
      }
      
      public final void hy(long paramAnonymousLong) {}
      
      public final void i(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(155691);
        ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            paramAnonymousString = d.iJ(paramAnonymousLong);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = paramAnonymousString.field_appId;
              localBundle.putCharSequence("download_manager_appid", paramAnonymousString);
              localWebViewStubCallbackWrapper.vdZ.e(1011, localBundle);
            }
            else
            {
              paramAnonymousString = "";
            }
          }
          catch (Exception paramAnonymousString)
          {
            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + paramAnonymousString.getMessage());
            AppMethodBeat.o(155691);
            return;
          }
        }
        AppMethodBeat.o(155691);
      }
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(155689);
        ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskPaused, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            Object localObject = d.iJ(paramAnonymousLong);
            if (localObject != null)
            {
              localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
              localBundle.putCharSequence("download_manager_appid", (CharSequence)localObject);
              localWebViewStubCallbackWrapper.vdZ.e(1010, localBundle);
            }
            else
            {
              String str = "";
            }
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + localException.getMessage());
            AppMethodBeat.o(155689);
            return;
          }
        }
        AppMethodBeat.o(155689);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(155688);
        ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            Object localObject = d.iJ(paramAnonymousLong);
            if (localObject != null)
            {
              localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
              localBundle.putCharSequence("download_manager_appid", (CharSequence)localObject);
              localWebViewStubCallbackWrapper.vdZ.e(1008, localBundle);
            }
            else
            {
              String str = "";
            }
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + localException.getMessage());
            AppMethodBeat.o(155688);
            return;
          }
        }
        AppMethodBeat.o(155688);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(155685);
        ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(paramAnonymousLong)));
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.f(WebViewStubService.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            paramAnonymousString = d.iJ(paramAnonymousLong);
            if (paramAnonymousString != null)
            {
              paramAnonymousString = paramAnonymousString.field_appId;
              localBundle.putCharSequence("download_manager_appid", paramAnonymousString);
              localWebViewStubCallbackWrapper.vdZ.e(1012, localBundle);
            }
            else
            {
              paramAnonymousString = "";
            }
          }
          catch (Exception paramAnonymousString)
          {
            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + paramAnonymousString.getMessage());
            AppMethodBeat.o(155685);
            return;
          }
        }
        AppMethodBeat.o(155685);
      }
    };
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.a(this.uZv);
    this.nlt = new WebViewStubService.6(this);
    this.mKL = new WebViewStubService.7(this);
    com.tencent.mm.kernel.g.RK().a(this.mKL);
    if (com.tencent.mm.kernel.g.RG()) {
      com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this.nlt);
    }
    this.uXR = new WebViewStubService.8(this);
    com.tencent.mm.plugin.game.api.a.a(this.uXR);
    AppMethodBeat.o(7208);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7211);
    ab.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
    super.onDestroy();
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.b(this.uZv);
    if (com.tencent.mm.kernel.g.RG()) {
      com.tencent.mm.plugin.webview.modeltools.g.dcD().b(this.nlt);
    }
    com.tencent.mm.kernel.g.RK().b(this.mKL);
    this.mKL = null;
    this.uZv = null;
    this.cvl.clear();
    com.tencent.mm.plugin.game.api.a.b(this.uXR);
    AppMethodBeat.o(7211);
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    // Byte code:
    //   0: sipush 7212
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 4
    //   8: invokevirtual 471	com/tencent/mm/ai/m:getType	()I
    //   11: istore 6
    //   13: ldc 193
    //   15: ldc_w 473
    //   18: iconst_4
    //   19: anewarray 197	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: iload 6
    //   26: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: iload_2
    //   33: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: aastore
    //   37: dup
    //   38: iconst_2
    //   39: iload_1
    //   40: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_3
    //   46: aload_3
    //   47: aastore
    //   48: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: iload 6
    //   53: bipush 106
    //   55: if_icmpne +410 -> 465
    //   58: invokestatic 334	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   61: bipush 106
    //   63: aload_0
    //   64: invokevirtual 476	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   67: iload_1
    //   68: ifne +7 -> 75
    //   71: iload_2
    //   72: ifeq +42 -> 114
    //   75: ldc 193
    //   77: new 478	java/lang/StringBuilder
    //   80: dup
    //   81: ldc_w 480
    //   84: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: iload_1
    //   88: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc_w 487
    //   94: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_2
    //   98: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: sipush 7212
    //   110: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: aload 4
    //   116: checkcast 496	com/tencent/mm/plugin/messenger/a/f
    //   119: invokevirtual 500	com/tencent/mm/plugin/messenger/a/f:bPI	()Lcom/tencent/mm/protocal/protobuf/bxh;
    //   122: astore 7
    //   124: aload 7
    //   126: getfield 506	com/tencent/mm/protocal/protobuf/bxh:wOT	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   129: invokestatic 511	com/tencent/mm/platformtools/aa:a	(Lcom/tencent/mm/protocal/protobuf/bwc;)Ljava/lang/String;
    //   132: astore 4
    //   134: invokestatic 517	com/tencent/mm/ah/o:acQ	()Lcom/tencent/mm/ah/d;
    //   137: aload 4
    //   139: aload 7
    //   141: getfield 521	com/tencent/mm/protocal/protobuf/bxh:woT	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   144: invokestatic 524	com/tencent/mm/platformtools/aa:a	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)[B
    //   147: invokevirtual 530	com/tencent/mm/ah/d:n	(Ljava/lang/String;[B)Z
    //   150: pop
    //   151: new 126	android/content/Intent
    //   154: dup
    //   155: invokespecial 531	android/content/Intent:<init>	()V
    //   158: astore 8
    //   160: ldc_w 533
    //   163: invokestatic 537	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   166: checkcast 533	com/tencent/mm/api/j
    //   169: aload 8
    //   171: aload 7
    //   173: bipush 30
    //   175: invokeinterface 540 4 0
    //   180: aload 4
    //   182: invokestatic 545	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokevirtual 214	java/lang/String:length	()I
    //   188: ifle +263 -> 451
    //   191: ldc_w 547
    //   194: invokestatic 537	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   197: checkcast 547	com/tencent/mm/plugin/messenger/foundation/a/j
    //   200: invokeinterface 551 1 0
    //   205: aload 4
    //   207: invokeinterface 557 2 0
    //   212: astore 9
    //   214: aload 9
    //   216: ifnull +24 -> 240
    //   219: aload 9
    //   221: getfield 562	com/tencent/mm/g/c/aq:field_type	I
    //   224: invokestatic 568	com/tencent/mm/n/a:je	(I)Z
    //   227: ifne +13 -> 240
    //   230: aload 8
    //   232: ldc_w 570
    //   235: iconst_1
    //   236: invokevirtual 573	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   239: pop
    //   240: aload 7
    //   242: getfield 576	com/tencent/mm/protocal/protobuf/bxh:xpe	I
    //   245: bipush 8
    //   247: iand
    //   248: ifle +33 -> 281
    //   251: getstatic 582	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   254: sipush 10298
    //   257: new 478	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   264: aload 4
    //   266: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 585
    //   272: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 589	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   281: aload 8
    //   283: ldc 151
    //   285: invokevirtual 155	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   288: pop
    //   289: getstatic 595	com/tencent/mm/plugin/webview/a/a:gmO	Lcom/tencent/mm/pluginsdk/n;
    //   292: aload 8
    //   294: aload_0
    //   295: invokeinterface 600 3 0
    //   300: new 179	android/os/Bundle
    //   303: dup
    //   304: invokespecial 601	android/os/Bundle:<init>	()V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 603
    //   314: aload 4
    //   316: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_0
    //   320: getfield 79	com/tencent/mm/plugin/webview/stub/WebViewStubService:cvl	Ljava/util/List;
    //   323: invokeinterface 105 1 0
    //   328: astore 4
    //   330: aload 4
    //   332: invokeinterface 111 1 0
    //   337: ifeq +121 -> 458
    //   340: aload 4
    //   342: invokeinterface 115 1 0
    //   347: checkcast 117	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   350: astore 8
    //   352: new 14	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   355: dup
    //   356: invokespecial 607	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   359: astore 9
    //   361: aload 9
    //   363: iload 6
    //   365: putfield 610	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   368: aload 9
    //   370: iload_1
    //   371: putfield 613	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   374: aload 9
    //   376: iload_2
    //   377: putfield 616	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   380: aload 9
    //   382: aload_3
    //   383: putfield 619	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errMsg	Ljava/lang/String;
    //   386: aload 9
    //   388: aload 7
    //   390: putfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   393: aload 9
    //   395: getfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   398: ldc_w 625
    //   401: aload 8
    //   403: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   406: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   409: aload 8
    //   411: getfield 124	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:vdZ	Lcom/tencent/mm/plugin/webview/stub/e;
    //   414: aload 9
    //   416: invokeinterface 634 2 0
    //   421: pop
    //   422: goto -92 -> 330
    //   425: astore_3
    //   426: ldc 193
    //   428: new 478	java/lang/StringBuilder
    //   431: dup
    //   432: ldc_w 636
    //   435: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   438: aload_3
    //   439: invokevirtual 639	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: sipush 7212
    //   454: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   457: return
    //   458: sipush 7212
    //   461: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: return
    //   465: iload 6
    //   467: sipush 233
    //   470: if_icmpne +916 -> 1386
    //   473: aload 4
    //   475: instanceof 641
    //   478: ifeq +908 -> 1386
    //   481: aload 4
    //   483: checkcast 641	com/tencent/mm/modelsimple/j
    //   486: astore 9
    //   488: new 179	android/os/Bundle
    //   491: dup
    //   492: invokespecial 601	android/os/Bundle:<init>	()V
    //   495: astore 8
    //   497: aload 9
    //   499: invokevirtual 645	com/tencent/mm/modelsimple/j:ajo	()[B
    //   502: astore 7
    //   504: aload 7
    //   506: ifnull +9 -> 515
    //   509: aload 7
    //   511: arraylength
    //   512: ifgt +11 -> 523
    //   515: ldc 193
    //   517: ldc_w 647
    //   520: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload 7
    //   525: astore 4
    //   527: aload 7
    //   529: ifnonnull +6 -> 535
    //   532: aconst_null
    //   533: astore 4
    //   535: aload 8
    //   537: ldc_w 649
    //   540: aload 4
    //   542: invokevirtual 653	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   545: aload 9
    //   547: getfield 657	com/tencent/mm/modelsimple/j:rr	Lcom/tencent/mm/ai/b;
    //   550: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   553: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   556: checkcast 666	com/tencent/mm/protocal/protobuf/afg
    //   559: getfield 670	com/tencent/mm/protocal/protobuf/afg:wYq	Lcom/tencent/mm/protocal/protobuf/afc;
    //   562: astore 4
    //   564: aload 4
    //   566: ifnonnull +464 -> 1030
    //   569: iconst_0
    //   570: istore 5
    //   572: aload 8
    //   574: ldc_w 672
    //   577: iload 5
    //   579: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   582: aload 8
    //   584: ldc_w 674
    //   587: aload 9
    //   589: getfield 657	com/tencent/mm/modelsimple/j:rr	Lcom/tencent/mm/ai/b;
    //   592: getfield 255	com/tencent/mm/ai/b:fsV	Lcom/tencent/mm/ai/b$b;
    //   595: getfield 260	com/tencent/mm/ai/b$b:fta	Lcom/tencent/mm/bv/a;
    //   598: checkcast 676	com/tencent/mm/protocal/protobuf/aff
    //   601: getfield 679	com/tencent/mm/protocal/protobuf/aff:wsD	I
    //   604: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   607: aload 8
    //   609: ldc_w 681
    //   612: aload 9
    //   614: invokevirtual 684	com/tencent/mm/modelsimple/j:ajm	()Ljava/lang/String;
    //   617: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 8
    //   622: ldc_w 686
    //   625: aload 9
    //   627: invokevirtual 689	com/tencent/mm/modelsimple/j:ajl	()Ljava/lang/String;
    //   630: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 8
    //   635: ldc_w 691
    //   638: aload 9
    //   640: invokevirtual 694	com/tencent/mm/modelsimple/j:getTitle	()Ljava/lang/String;
    //   643: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload 8
    //   648: ldc_w 696
    //   651: aload 9
    //   653: invokevirtual 699	com/tencent/mm/modelsimple/j:ajn	()I
    //   656: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   659: aload 8
    //   661: ldc_w 701
    //   664: aload 9
    //   666: invokevirtual 704	com/tencent/mm/modelsimple/j:getContent	()Ljava/lang/String;
    //   669: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: aload 8
    //   674: ldc_w 706
    //   677: aload 9
    //   679: getfield 657	com/tencent/mm/modelsimple/j:rr	Lcom/tencent/mm/ai/b;
    //   682: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   685: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   688: checkcast 666	com/tencent/mm/protocal/protobuf/afg
    //   691: getfield 709	com/tencent/mm/protocal/protobuf/afg:wYz	Ljava/lang/String;
    //   694: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 8
    //   699: ldc_w 711
    //   702: aload 9
    //   704: getfield 657	com/tencent/mm/modelsimple/j:rr	Lcom/tencent/mm/ai/b;
    //   707: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   710: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   713: checkcast 666	com/tencent/mm/protocal/protobuf/afg
    //   716: getfield 714	com/tencent/mm/protocal/protobuf/afg:nQe	Ljava/lang/String;
    //   719: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   722: aload 8
    //   724: ldc_w 716
    //   727: aload 9
    //   729: invokevirtual 720	com/tencent/mm/modelsimple/j:ajr	()J
    //   732: invokevirtual 724	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   735: aload 8
    //   737: ldc_w 726
    //   740: aload 9
    //   742: getfield 657	com/tencent/mm/modelsimple/j:rr	Lcom/tencent/mm/ai/b;
    //   745: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   748: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   751: checkcast 666	com/tencent/mm/protocal/protobuf/afg
    //   754: getfield 729	com/tencent/mm/protocal/protobuf/afg:jJA	Ljava/lang/String;
    //   757: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 8
    //   762: ldc_w 731
    //   765: aload 9
    //   767: invokevirtual 734	com/tencent/mm/modelsimple/j:ajv	()[B
    //   770: invokevirtual 653	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   773: aload 8
    //   775: ldc_w 736
    //   778: aload 9
    //   780: getfield 657	com/tencent/mm/modelsimple/j:rr	Lcom/tencent/mm/ai/b;
    //   783: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   786: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   789: checkcast 666	com/tencent/mm/protocal/protobuf/afg
    //   792: getfield 739	com/tencent/mm/protocal/protobuf/afg:wYA	Ljava/lang/String;
    //   795: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   798: ldc 193
    //   800: ldc_w 741
    //   803: iconst_1
    //   804: anewarray 197	java/lang/Object
    //   807: dup
    //   808: iconst_0
    //   809: aload 9
    //   811: invokevirtual 734	com/tencent/mm/modelsimple/j:ajv	()[B
    //   814: invokestatic 745	com/tencent/mm/sdk/platformtools/bo:cg	([B)Ljava/lang/String;
    //   817: aastore
    //   818: invokestatic 747	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   821: aload 9
    //   823: invokevirtual 751	com/tencent/mm/modelsimple/j:ajs	()Ljava/util/List;
    //   826: astore 4
    //   828: aload 4
    //   830: invokestatic 755	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   833: ifne +227 -> 1060
    //   836: aload 4
    //   838: invokeinterface 105 1 0
    //   843: astore 7
    //   845: aload 7
    //   847: invokeinterface 111 1 0
    //   852: ifeq +1887 -> 2739
    //   855: aload 7
    //   857: invokeinterface 115 1 0
    //   862: checkcast 757	com/tencent/mm/protocal/protobuf/avl
    //   865: astore 10
    //   867: aload 10
    //   869: ifnull +25 -> 894
    //   872: aload 10
    //   874: getfield 760	com/tencent/mm/protocal/protobuf/avl:wxP	Ljava/lang/String;
    //   877: invokestatic 763	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   880: ifne +14 -> 894
    //   883: aload 10
    //   885: getfield 766	com/tencent/mm/protocal/protobuf/avl:qsu	Ljava/lang/String;
    //   888: invokestatic 763	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   891: ifeq -46 -> 845
    //   894: ldc 193
    //   896: ldc_w 768
    //   899: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   902: iconst_1
    //   903: istore 5
    //   905: iload 5
    //   907: ifne +153 -> 1060
    //   910: aload 4
    //   912: invokeinterface 771 1 0
    //   917: anewarray 210	java/lang/String
    //   920: astore 7
    //   922: aload 4
    //   924: invokeinterface 771 1 0
    //   929: anewarray 210	java/lang/String
    //   932: astore 10
    //   934: iconst_0
    //   935: istore 5
    //   937: iload 5
    //   939: aload 4
    //   941: invokeinterface 771 1 0
    //   946: if_icmpge +94 -> 1040
    //   949: aload 4
    //   951: iload 5
    //   953: invokeinterface 775 2 0
    //   958: checkcast 757	com/tencent/mm/protocal/protobuf/avl
    //   961: astore 12
    //   963: aload 12
    //   965: getfield 760	com/tencent/mm/protocal/protobuf/avl:wxP	Ljava/lang/String;
    //   968: astore 11
    //   970: aload 12
    //   972: getfield 766	com/tencent/mm/protocal/protobuf/avl:qsu	Ljava/lang/String;
    //   975: astore 12
    //   977: ldc 193
    //   979: ldc_w 777
    //   982: iconst_3
    //   983: anewarray 197	java/lang/Object
    //   986: dup
    //   987: iconst_0
    //   988: iload 5
    //   990: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   993: aastore
    //   994: dup
    //   995: iconst_1
    //   996: aload 11
    //   998: aastore
    //   999: dup
    //   1000: iconst_2
    //   1001: aload 12
    //   1003: aastore
    //   1004: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: aload 7
    //   1009: iload 5
    //   1011: aload 11
    //   1013: aastore
    //   1014: aload 10
    //   1016: iload 5
    //   1018: aload 12
    //   1020: aastore
    //   1021: iload 5
    //   1023: iconst_1
    //   1024: iadd
    //   1025: istore 5
    //   1027: goto -90 -> 937
    //   1030: aload 4
    //   1032: getfield 782	com/tencent/mm/protocal/protobuf/afc:wXX	I
    //   1035: istore 5
    //   1037: goto -465 -> 572
    //   1040: aload 8
    //   1042: ldc_w 784
    //   1045: aload 7
    //   1047: invokevirtual 788	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1050: aload 8
    //   1052: ldc_w 790
    //   1055: aload 10
    //   1057: invokevirtual 788	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1060: aload 8
    //   1062: ldc_w 792
    //   1065: aload 9
    //   1067: invokevirtual 796	com/tencent/mm/modelsimple/j:ajq	()Ljava/util/ArrayList;
    //   1070: invokevirtual 800	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1073: ldc 193
    //   1075: ldc_w 802
    //   1078: iconst_4
    //   1079: anewarray 197	java/lang/Object
    //   1082: dup
    //   1083: iconst_0
    //   1084: aload 9
    //   1086: invokevirtual 805	com/tencent/mm/modelsimple/j:ajp	()Ljava/lang/String;
    //   1089: aastore
    //   1090: dup
    //   1091: iconst_1
    //   1092: aload 9
    //   1094: invokevirtual 689	com/tencent/mm/modelsimple/j:ajl	()Ljava/lang/String;
    //   1097: aastore
    //   1098: dup
    //   1099: iconst_2
    //   1100: aload 9
    //   1102: invokevirtual 684	com/tencent/mm/modelsimple/j:ajm	()Ljava/lang/String;
    //   1105: aastore
    //   1106: dup
    //   1107: iconst_3
    //   1108: getstatic 811	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1111: aastore
    //   1112: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1115: aload 9
    //   1117: invokevirtual 805	com/tencent/mm/modelsimple/j:ajp	()Ljava/lang/String;
    //   1120: invokestatic 763	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1123: ifne +152 -> 1275
    //   1126: aload 9
    //   1128: invokevirtual 689	com/tencent/mm/modelsimple/j:ajl	()Ljava/lang/String;
    //   1131: aload 9
    //   1133: invokevirtual 805	com/tencent/mm/modelsimple/j:ajp	()Ljava/lang/String;
    //   1136: invokestatic 816	com/tencent/mm/plugin/webview/model/at:hs	(Ljava/lang/String;Ljava/lang/String;)V
    //   1139: aload 9
    //   1141: getfield 817	com/tencent/mm/modelsimple/j:tag	Ljava/lang/Object;
    //   1144: ifnull +1589 -> 2733
    //   1147: aload 9
    //   1149: getfield 817	com/tencent/mm/modelsimple/j:tag	Ljava/lang/Object;
    //   1152: checkcast 321	java/lang/Integer
    //   1155: invokevirtual 820	java/lang/Integer:intValue	()I
    //   1158: istore 5
    //   1160: aload_0
    //   1161: getfield 79	com/tencent/mm/plugin/webview/stub/WebViewStubService:cvl	Ljava/util/List;
    //   1164: invokeinterface 105 1 0
    //   1169: astore 4
    //   1171: aload 4
    //   1173: invokeinterface 111 1 0
    //   1178: ifeq +201 -> 1379
    //   1181: aload 4
    //   1183: invokeinterface 115 1 0
    //   1188: checkcast 117	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   1191: astore 7
    //   1193: iload 5
    //   1195: ifeq +111 -> 1306
    //   1198: iload 5
    //   1200: aload 7
    //   1202: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1205: if_icmpeq +101 -> 1306
    //   1208: ldc 193
    //   1210: ldc_w 822
    //   1213: iconst_2
    //   1214: anewarray 197	java/lang/Object
    //   1217: dup
    //   1218: iconst_0
    //   1219: iload 5
    //   1221: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1224: aastore
    //   1225: dup
    //   1226: iconst_1
    //   1227: aload 7
    //   1229: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1232: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1235: aastore
    //   1236: invokestatic 747	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1239: goto -68 -> 1171
    //   1242: astore_3
    //   1243: ldc 193
    //   1245: new 478	java/lang/StringBuilder
    //   1248: dup
    //   1249: ldc_w 824
    //   1252: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1255: aload_3
    //   1256: invokestatic 830	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1259: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1265: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1268: sipush 7212
    //   1271: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1274: return
    //   1275: ldc 193
    //   1277: ldc_w 832
    //   1280: iconst_2
    //   1281: anewarray 197	java/lang/Object
    //   1284: dup
    //   1285: iconst_0
    //   1286: aload 9
    //   1288: invokevirtual 689	com/tencent/mm/modelsimple/j:ajl	()Ljava/lang/String;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_1
    //   1294: aload 9
    //   1296: invokevirtual 684	com/tencent/mm/modelsimple/j:ajm	()Ljava/lang/String;
    //   1299: aastore
    //   1300: invokestatic 354	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1303: goto -164 -> 1139
    //   1306: new 14	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   1309: dup
    //   1310: invokespecial 607	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   1313: astore 9
    //   1315: aload 9
    //   1317: iload 6
    //   1319: putfield 610	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   1322: aload 9
    //   1324: iload_1
    //   1325: putfield 613	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   1328: aload 9
    //   1330: iload_2
    //   1331: putfield 616	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   1334: aload 9
    //   1336: aload_3
    //   1337: putfield 619	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errMsg	Ljava/lang/String;
    //   1340: aload 9
    //   1342: aload 8
    //   1344: putfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   1347: aload 9
    //   1349: getfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   1352: ldc_w 625
    //   1355: aload 7
    //   1357: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1360: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1363: aload 7
    //   1365: getfield 124	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:vdZ	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1368: aload 9
    //   1370: invokeinterface 634 2 0
    //   1375: pop
    //   1376: goto -205 -> 1171
    //   1379: sipush 7212
    //   1382: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1385: return
    //   1386: iload 6
    //   1388: sipush 673
    //   1391: if_icmpne +278 -> 1669
    //   1394: aload 4
    //   1396: checkcast 834	com/tencent/mm/plugin/webview/model/p
    //   1399: astore 8
    //   1401: new 179	android/os/Bundle
    //   1404: dup
    //   1405: invokespecial 601	android/os/Bundle:<init>	()V
    //   1408: astore 7
    //   1410: aload 8
    //   1412: getfield 835	com/tencent/mm/plugin/webview/model/p:rr	Lcom/tencent/mm/ai/b;
    //   1415: ifnonnull +152 -> 1567
    //   1418: aconst_null
    //   1419: astore 4
    //   1421: aload 7
    //   1423: ldc_w 837
    //   1426: aload 4
    //   1428: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1431: aload 8
    //   1433: getfield 838	com/tencent/mm/plugin/webview/model/p:tag	Ljava/lang/Object;
    //   1436: ifnull +1291 -> 2727
    //   1439: aload 8
    //   1441: getfield 838	com/tencent/mm/plugin/webview/model/p:tag	Ljava/lang/Object;
    //   1444: checkcast 321	java/lang/Integer
    //   1447: invokevirtual 820	java/lang/Integer:intValue	()I
    //   1450: istore 5
    //   1452: aload_0
    //   1453: getfield 79	com/tencent/mm/plugin/webview/stub/WebViewStubService:cvl	Ljava/util/List;
    //   1456: invokeinterface 105 1 0
    //   1461: astore 4
    //   1463: aload 4
    //   1465: invokeinterface 111 1 0
    //   1470: ifeq +192 -> 1662
    //   1473: aload 4
    //   1475: invokeinterface 115 1 0
    //   1480: checkcast 117	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   1483: astore 8
    //   1485: iload 5
    //   1487: ifeq +102 -> 1589
    //   1490: iload 5
    //   1492: aload 8
    //   1494: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1497: if_icmpeq +92 -> 1589
    //   1500: ldc 193
    //   1502: ldc_w 840
    //   1505: iconst_2
    //   1506: anewarray 197	java/lang/Object
    //   1509: dup
    //   1510: iconst_0
    //   1511: iload 5
    //   1513: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1516: aastore
    //   1517: dup
    //   1518: iconst_1
    //   1519: aload 8
    //   1521: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1524: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1527: aastore
    //   1528: invokestatic 747	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1531: goto -68 -> 1463
    //   1534: astore_3
    //   1535: ldc 193
    //   1537: new 478	java/lang/StringBuilder
    //   1540: dup
    //   1541: ldc_w 824
    //   1544: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1547: aload_3
    //   1548: invokestatic 830	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1551: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1560: sipush 7212
    //   1563: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1566: return
    //   1567: aload 8
    //   1569: getfield 835	com/tencent/mm/plugin/webview/model/p:rr	Lcom/tencent/mm/ai/b;
    //   1572: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   1575: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   1578: checkcast 842	com/tencent/mm/protocal/protobuf/aow
    //   1581: getfield 845	com/tencent/mm/protocal/protobuf/aow:URL	Ljava/lang/String;
    //   1584: astore 4
    //   1586: goto -165 -> 1421
    //   1589: new 14	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   1592: dup
    //   1593: invokespecial 607	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   1596: astore 9
    //   1598: aload 9
    //   1600: iload 6
    //   1602: putfield 610	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   1605: aload 9
    //   1607: iload_1
    //   1608: putfield 613	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   1611: aload 9
    //   1613: iload_2
    //   1614: putfield 616	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   1617: aload 9
    //   1619: aload_3
    //   1620: putfield 619	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errMsg	Ljava/lang/String;
    //   1623: aload 9
    //   1625: aload 7
    //   1627: putfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   1630: aload 9
    //   1632: getfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   1635: ldc_w 625
    //   1638: aload 8
    //   1640: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1643: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1646: aload 8
    //   1648: getfield 124	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:vdZ	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1651: aload 9
    //   1653: invokeinterface 634 2 0
    //   1658: pop
    //   1659: goto -196 -> 1463
    //   1662: sipush 7212
    //   1665: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1668: return
    //   1669: iload 6
    //   1671: sipush 666
    //   1674: if_icmpne +348 -> 2022
    //   1677: aload 4
    //   1679: checkcast 310	com/tencent/mm/ao/c
    //   1682: astore 7
    //   1684: new 179	android/os/Bundle
    //   1687: dup
    //   1688: invokespecial 601	android/os/Bundle:<init>	()V
    //   1691: astore 4
    //   1693: aload 4
    //   1695: ldc_w 847
    //   1698: aload 7
    //   1700: invokevirtual 851	com/tencent/mm/ao/c:agu	()Lcom/tencent/mm/protocal/protobuf/ayl;
    //   1703: getfield 856	com/tencent/mm/protocal/protobuf/ayl:ProductID	Ljava/lang/String;
    //   1706: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1709: iload_1
    //   1710: ifne +96 -> 1806
    //   1713: iload_2
    //   1714: ifne +92 -> 1806
    //   1717: aload 4
    //   1719: ldc_w 847
    //   1722: invokevirtual 183	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1725: astore 8
    //   1727: ldc 193
    //   1729: ldc_w 858
    //   1732: iconst_1
    //   1733: anewarray 197	java/lang/Object
    //   1736: dup
    //   1737: iconst_0
    //   1738: aload 8
    //   1740: aastore
    //   1741: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1744: aload 8
    //   1746: invokestatic 763	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1749: ifne +57 -> 1806
    //   1752: new 126	android/content/Intent
    //   1755: dup
    //   1756: invokespecial 531	android/content/Intent:<init>	()V
    //   1759: astore 9
    //   1761: aload 9
    //   1763: ldc_w 860
    //   1766: aload 8
    //   1768: invokevirtual 296	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1771: pop
    //   1772: aload 9
    //   1774: ldc_w 862
    //   1777: bipush 12
    //   1779: invokevirtual 141	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1782: pop
    //   1783: aload 9
    //   1785: ldc_w 864
    //   1788: bipush 12
    //   1790: invokevirtual 141	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1793: pop
    //   1794: aload_0
    //   1795: ldc_w 866
    //   1798: ldc_w 868
    //   1801: aload 9
    //   1803: invokestatic 873	com/tencent/mm/bq/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1806: aload 7
    //   1808: getfield 328	com/tencent/mm/ao/c:tag	Ljava/lang/Object;
    //   1811: ifnull +910 -> 2721
    //   1814: aload 7
    //   1816: getfield 328	com/tencent/mm/ao/c:tag	Ljava/lang/Object;
    //   1819: checkcast 321	java/lang/Integer
    //   1822: invokevirtual 820	java/lang/Integer:intValue	()I
    //   1825: istore 5
    //   1827: aload_0
    //   1828: getfield 79	com/tencent/mm/plugin/webview/stub/WebViewStubService:cvl	Ljava/util/List;
    //   1831: invokeinterface 105 1 0
    //   1836: astore 7
    //   1838: aload 7
    //   1840: invokeinterface 111 1 0
    //   1845: ifeq +170 -> 2015
    //   1848: aload 7
    //   1850: invokeinterface 115 1 0
    //   1855: checkcast 117	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   1858: astore 8
    //   1860: iload 5
    //   1862: ifeq +80 -> 1942
    //   1865: iload 5
    //   1867: aload 8
    //   1869: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1872: if_icmpeq +70 -> 1942
    //   1875: ldc 193
    //   1877: ldc_w 875
    //   1880: iconst_2
    //   1881: anewarray 197	java/lang/Object
    //   1884: dup
    //   1885: iconst_0
    //   1886: iload 5
    //   1888: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1891: aastore
    //   1892: dup
    //   1893: iconst_1
    //   1894: aload 8
    //   1896: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1899: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1902: aastore
    //   1903: invokestatic 747	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1906: goto -68 -> 1838
    //   1909: astore_3
    //   1910: ldc 193
    //   1912: new 478	java/lang/StringBuilder
    //   1915: dup
    //   1916: ldc_w 877
    //   1919: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1922: aload_3
    //   1923: invokevirtual 639	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1926: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1932: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1935: sipush 7212
    //   1938: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1941: return
    //   1942: new 14	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   1945: dup
    //   1946: invokespecial 607	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   1949: astore 9
    //   1951: aload 9
    //   1953: iload 6
    //   1955: putfield 610	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   1958: aload 9
    //   1960: iload_1
    //   1961: putfield 613	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   1964: aload 9
    //   1966: iload_2
    //   1967: putfield 616	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   1970: aload 9
    //   1972: aload_3
    //   1973: putfield 619	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errMsg	Ljava/lang/String;
    //   1976: aload 9
    //   1978: aload 4
    //   1980: putfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   1983: aload 9
    //   1985: getfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   1988: ldc_w 625
    //   1991: aload 8
    //   1993: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1996: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1999: aload 8
    //   2001: getfield 124	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:vdZ	Lcom/tencent/mm/plugin/webview/stub/e;
    //   2004: aload 9
    //   2006: invokeinterface 634 2 0
    //   2011: pop
    //   2012: goto -174 -> 1838
    //   2015: sipush 7212
    //   2018: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2021: return
    //   2022: iload 6
    //   2024: sipush 1254
    //   2027: if_icmpne +389 -> 2416
    //   2030: aload 4
    //   2032: checkcast 879	com/tencent/mm/plugin/webview/model/y
    //   2035: astore 7
    //   2037: aload 7
    //   2039: getfield 880	com/tencent/mm/plugin/webview/model/y:tag	Ljava/lang/Object;
    //   2042: ifnull +673 -> 2715
    //   2045: aload 7
    //   2047: getfield 880	com/tencent/mm/plugin/webview/model/y:tag	Ljava/lang/Object;
    //   2050: checkcast 321	java/lang/Integer
    //   2053: invokevirtual 820	java/lang/Integer:intValue	()I
    //   2056: istore 5
    //   2058: aload_0
    //   2059: getfield 79	com/tencent/mm/plugin/webview/stub/WebViewStubService:cvl	Ljava/util/List;
    //   2062: invokeinterface 105 1 0
    //   2067: astore 7
    //   2069: aload 7
    //   2071: invokeinterface 111 1 0
    //   2076: ifeq +333 -> 2409
    //   2079: aload 7
    //   2081: invokeinterface 115 1 0
    //   2086: checkcast 117	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   2089: astore 8
    //   2091: iload 5
    //   2093: ifeq +80 -> 2173
    //   2096: iload 5
    //   2098: aload 8
    //   2100: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2103: if_icmpeq +70 -> 2173
    //   2106: ldc 193
    //   2108: ldc_w 882
    //   2111: iconst_2
    //   2112: anewarray 197	java/lang/Object
    //   2115: dup
    //   2116: iconst_0
    //   2117: iload 5
    //   2119: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2122: aastore
    //   2123: dup
    //   2124: iconst_1
    //   2125: aload 8
    //   2127: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2130: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2133: aastore
    //   2134: invokestatic 747	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2137: goto -68 -> 2069
    //   2140: astore_3
    //   2141: ldc 193
    //   2143: new 478	java/lang/StringBuilder
    //   2146: dup
    //   2147: ldc_w 884
    //   2150: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2153: aload_3
    //   2154: invokestatic 830	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2157: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2160: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2163: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2166: sipush 7212
    //   2169: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2172: return
    //   2173: new 14	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   2176: dup
    //   2177: invokespecial 607	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   2180: astore 9
    //   2182: aload 9
    //   2184: iload 6
    //   2186: putfield 610	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   2189: aload 9
    //   2191: iload_1
    //   2192: putfield 613	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   2195: aload 9
    //   2197: iload_2
    //   2198: putfield 616	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   2201: aload 9
    //   2203: aload_3
    //   2204: putfield 619	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errMsg	Ljava/lang/String;
    //   2207: new 179	android/os/Bundle
    //   2210: dup
    //   2211: invokespecial 601	android/os/Bundle:<init>	()V
    //   2214: astore 10
    //   2216: iload_1
    //   2217: ifne +528 -> 2745
    //   2220: iload_2
    //   2221: ifeq +45 -> 2266
    //   2224: goto +521 -> 2745
    //   2227: aload 9
    //   2229: aload 10
    //   2231: putfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   2234: aload 9
    //   2236: getfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   2239: ldc_w 625
    //   2242: aload 8
    //   2244: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2247: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2250: aload 8
    //   2252: getfield 124	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:vdZ	Lcom/tencent/mm/plugin/webview/stub/e;
    //   2255: aload 9
    //   2257: invokeinterface 634 2 0
    //   2262: pop
    //   2263: goto -194 -> 2069
    //   2266: aload 4
    //   2268: instanceof 879
    //   2271: ifne +6 -> 2277
    //   2274: goto -47 -> 2227
    //   2277: aload 4
    //   2279: checkcast 879	com/tencent/mm/plugin/webview/model/y
    //   2282: getfield 885	com/tencent/mm/plugin/webview/model/y:rr	Lcom/tencent/mm/ai/b;
    //   2285: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   2288: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   2291: checkcast 887	com/tencent/mm/protocal/protobuf/bgr
    //   2294: astore 11
    //   2296: aload 10
    //   2298: ldc_w 889
    //   2301: aload 4
    //   2303: checkcast 879	com/tencent/mm/plugin/webview/model/y
    //   2306: getfield 892	com/tencent/mm/plugin/webview/model/y:uVL	Ljava/lang/String;
    //   2309: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2312: aload 10
    //   2314: ldc_w 894
    //   2317: aload 11
    //   2319: getfield 898	com/tencent/mm/protocal/protobuf/bgr:xvT	Ljava/util/LinkedList;
    //   2322: invokestatic 904	com/tencent/mm/plugin/webview/model/ah:aF	(Ljava/util/LinkedList;)Ljava/util/ArrayList;
    //   2325: invokevirtual 800	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2328: aload 10
    //   2330: ldc_w 906
    //   2333: aload 11
    //   2335: getfield 909	com/tencent/mm/protocal/protobuf/bgr:fhP	Ljava/lang/String;
    //   2338: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2341: aload 10
    //   2343: ldc_w 911
    //   2346: aload 11
    //   2348: getfield 914	com/tencent/mm/protocal/protobuf/bgr:xvU	Ljava/lang/String;
    //   2351: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2354: aload 10
    //   2356: ldc_w 916
    //   2359: aload 11
    //   2361: getfield 919	com/tencent/mm/protocal/protobuf/bgr:wqy	Ljava/lang/String;
    //   2364: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2367: aload 10
    //   2369: ldc_w 921
    //   2372: aload 11
    //   2374: getfield 925	com/tencent/mm/protocal/protobuf/bgr:xvV	Z
    //   2377: invokevirtual 929	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2380: aload 10
    //   2382: ldc_w 931
    //   2385: aload 11
    //   2387: getfield 934	com/tencent/mm/protocal/protobuf/bgr:xvW	Z
    //   2390: invokevirtual 929	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2393: aload 10
    //   2395: ldc_w 936
    //   2398: aload 11
    //   2400: getfield 939	com/tencent/mm/protocal/protobuf/bgr:xvX	Z
    //   2403: invokevirtual 929	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2406: goto -179 -> 2227
    //   2409: sipush 7212
    //   2412: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2415: return
    //   2416: iload 6
    //   2418: sipush 1373
    //   2421: if_icmpne +139 -> 2560
    //   2424: aload 4
    //   2426: checkcast 941	com/tencent/mm/plugin/webview/model/z
    //   2429: astore 7
    //   2431: aload 7
    //   2433: getfield 942	com/tencent/mm/plugin/webview/model/z:tag	Ljava/lang/Object;
    //   2436: ifnull +273 -> 2709
    //   2439: aload 7
    //   2441: getfield 942	com/tencent/mm/plugin/webview/model/z:tag	Ljava/lang/Object;
    //   2444: checkcast 321	java/lang/Integer
    //   2447: invokevirtual 820	java/lang/Integer:intValue	()I
    //   2450: istore 5
    //   2452: aload_0
    //   2453: getfield 79	com/tencent/mm/plugin/webview/stub/WebViewStubService:cvl	Ljava/util/List;
    //   2456: invokeinterface 105 1 0
    //   2461: astore 7
    //   2463: aload 7
    //   2465: invokeinterface 111 1 0
    //   2470: ifeq +232 -> 2702
    //   2473: aload 7
    //   2475: invokeinterface 115 1 0
    //   2480: checkcast 117	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   2483: astore 8
    //   2485: iload 5
    //   2487: ifeq +80 -> 2567
    //   2490: iload 5
    //   2492: aload 8
    //   2494: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2497: if_icmpeq +70 -> 2567
    //   2500: ldc 193
    //   2502: ldc_w 944
    //   2505: iconst_2
    //   2506: anewarray 197	java/lang/Object
    //   2509: dup
    //   2510: iconst_0
    //   2511: iload 5
    //   2513: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2516: aastore
    //   2517: dup
    //   2518: iconst_1
    //   2519: aload 8
    //   2521: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2524: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2527: aastore
    //   2528: invokestatic 747	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2531: goto -68 -> 2463
    //   2534: astore_3
    //   2535: ldc 193
    //   2537: new 478	java/lang/StringBuilder
    //   2540: dup
    //   2541: ldc_w 946
    //   2544: invokespecial 481	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2547: aload_3
    //   2548: invokestatic 830	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2551: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2554: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2557: invokestatic 220	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2560: sipush 7212
    //   2563: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2566: return
    //   2567: new 14	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   2570: dup
    //   2571: invokespecial 607	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   2574: astore 9
    //   2576: aload 9
    //   2578: iload 6
    //   2580: putfield 610	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   2583: aload 9
    //   2585: iload_1
    //   2586: putfield 613	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   2589: aload 9
    //   2591: iload_2
    //   2592: putfield 616	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   2595: aload 9
    //   2597: aload_3
    //   2598: putfield 619	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errMsg	Ljava/lang/String;
    //   2601: new 179	android/os/Bundle
    //   2604: dup
    //   2605: invokespecial 601	android/os/Bundle:<init>	()V
    //   2608: astore 10
    //   2610: iload_1
    //   2611: ifne +137 -> 2748
    //   2614: iload_2
    //   2615: ifeq +45 -> 2660
    //   2618: goto +130 -> 2748
    //   2621: aload 9
    //   2623: aload 10
    //   2625: putfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   2628: aload 9
    //   2630: getfield 623	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:mEJ	Landroid/os/Bundle;
    //   2633: ldc_w 625
    //   2636: aload 8
    //   2638: getfield 120	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2641: invokevirtual 629	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2644: aload 8
    //   2646: getfield 124	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:vdZ	Lcom/tencent/mm/plugin/webview/stub/e;
    //   2649: aload 9
    //   2651: invokeinterface 634 2 0
    //   2656: pop
    //   2657: goto -194 -> 2463
    //   2660: aload 4
    //   2662: instanceof 941
    //   2665: ifne +6 -> 2671
    //   2668: goto -47 -> 2621
    //   2671: aload 10
    //   2673: ldc_w 916
    //   2676: aload 4
    //   2678: checkcast 941	com/tencent/mm/plugin/webview/model/z
    //   2681: getfield 947	com/tencent/mm/plugin/webview/model/z:rr	Lcom/tencent/mm/ai/b;
    //   2684: getfield 661	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   2687: getfield 664	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   2690: checkcast 949	com/tencent/mm/protocal/protobuf/bgp
    //   2693: getfield 950	com/tencent/mm/protocal/protobuf/bgp:wqy	Ljava/lang/String;
    //   2696: invokevirtual 606	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2699: goto -78 -> 2621
    //   2702: sipush 7212
    //   2705: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2708: return
    //   2709: iconst_0
    //   2710: istore 5
    //   2712: goto -260 -> 2452
    //   2715: iconst_0
    //   2716: istore 5
    //   2718: goto -660 -> 2058
    //   2721: iconst_0
    //   2722: istore 5
    //   2724: goto -897 -> 1827
    //   2727: iconst_0
    //   2728: istore 5
    //   2730: goto -1278 -> 1452
    //   2733: iconst_0
    //   2734: istore 5
    //   2736: goto -1576 -> 1160
    //   2739: iconst_0
    //   2740: istore 5
    //   2742: goto -1837 -> 905
    //   2745: goto -518 -> 2227
    //   2748: goto -127 -> 2621
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2751	0	this	WebViewStubService
    //   0	2751	1	paramInt1	int
    //   0	2751	2	paramInt2	int
    //   0	2751	3	paramString	String
    //   0	2751	4	paramm	com.tencent.mm.ai.m
    //   570	2171	5	i	int
    //   11	2568	6	j	int
    //   122	2352	7	localObject1	Object
    //   158	2487	8	localObject2	Object
    //   212	2438	9	localObject3	Object
    //   865	1807	10	localObject4	Object
    //   968	1431	11	localObject5	Object
    //   961	58	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   319	330	425	java/lang/Exception
    //   330	422	425	java/lang/Exception
    //   1139	1160	1242	java/lang/Exception
    //   1160	1171	1242	java/lang/Exception
    //   1171	1193	1242	java/lang/Exception
    //   1198	1239	1242	java/lang/Exception
    //   1306	1376	1242	java/lang/Exception
    //   1431	1452	1534	java/lang/Exception
    //   1452	1463	1534	java/lang/Exception
    //   1463	1485	1534	java/lang/Exception
    //   1490	1531	1534	java/lang/Exception
    //   1589	1659	1534	java/lang/Exception
    //   1806	1827	1909	java/lang/Exception
    //   1827	1838	1909	java/lang/Exception
    //   1838	1860	1909	java/lang/Exception
    //   1865	1906	1909	java/lang/Exception
    //   1942	2012	1909	java/lang/Exception
    //   2030	2058	2140	java/lang/Exception
    //   2058	2069	2140	java/lang/Exception
    //   2069	2091	2140	java/lang/Exception
    //   2096	2137	2140	java/lang/Exception
    //   2173	2216	2140	java/lang/Exception
    //   2227	2263	2140	java/lang/Exception
    //   2266	2274	2140	java/lang/Exception
    //   2277	2406	2140	java/lang/Exception
    //   2424	2452	2534	java/lang/Exception
    //   2452	2463	2534	java/lang/Exception
    //   2463	2485	2534	java/lang/Exception
    //   2490	2531	2534	java/lang/Exception
    //   2567	2610	2534	java/lang/Exception
    //   2621	2657	2534	java/lang/Exception
    //   2660	2668	2534	java/lang/Exception
    //   2671	2699	2534	java/lang/Exception
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(7210);
    ab.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
    h.detach();
    at.clear();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(7210);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService
 * JD-Core Version:    0.7.0.1
 */