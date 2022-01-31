package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebViewStubService
  extends Service
  implements f
{
  private List<WebViewStubCallbackWrapper> bNT = new ArrayList();
  private com.tencent.mm.sdk.b.c dGc = new WebViewStubService.2(this);
  private ah handler;
  private n koY;
  private Map<String, Integer> rcw;
  private final SparseArray<Bundle> rjZ = new SparseArray();
  private d.a rka = new WebViewStubService.1(this);
  private int rkb = 0;
  private k rkc;
  private com.tencent.mm.plugin.webview.model.d.a rkd;
  private Set<Integer> rke = new HashSet();
  private int rkf = -1;
  
  public IBinder onBind(Intent paramIntent)
  {
    y.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
    return this.rka;
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
    this.handler = new ah();
    this.rkc = new k()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        y.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = " + paramAnonymousLong);
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.h(WebViewStubService.this).iterator();
            if (localIterator.hasNext())
            {
              WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
              Bundle localBundle = new Bundle();
              localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
              Object localObject = com.tencent.mm.plugin.downloader.model.c.dk(paramAnonymousLong);
              if (localObject != null)
              {
                localObject = ((a)localObject).field_appId;
                localBundle.putCharSequence("download_manager_appid", (CharSequence)localObject);
                localBundle.putInt("download_manager_errcode", paramAnonymousInt);
                localWebViewStubCallbackWrapper.rno.b(1003, localBundle);
              }
            }
            else
            {
              return;
            }
          }
          catch (Exception localException)
          {
            y.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + localException.getMessage());
          }
          String str = "";
        }
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        y.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = " + paramAnonymousLong);
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.h(WebViewStubService.this).iterator();
            if (localIterator.hasNext())
            {
              WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
              Bundle localBundle = new Bundle();
              localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
              paramAnonymousString = com.tencent.mm.plugin.downloader.model.c.dk(paramAnonymousLong);
              if (paramAnonymousString != null)
              {
                paramAnonymousString = paramAnonymousString.field_appId;
                localBundle.putCharSequence("download_manager_appid", paramAnonymousString);
                localWebViewStubCallbackWrapper.rno.b(1002, localBundle);
              }
            }
            else
            {
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            y.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + paramAnonymousString.getMessage());
          }
          paramAnonymousString = "";
        }
      }
      
      public final void cy(long paramAnonymousLong)
      {
        try
        {
          Iterator localIterator = WebViewStubService.h(WebViewStubService.this).iterator();
          while (localIterator.hasNext())
          {
            WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
            a locala = com.tencent.mm.plugin.downloader.model.c.dk(paramAnonymousLong);
            if ((locala == null) || (locala.field_totalSize == 0L))
            {
              y.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = " + paramAnonymousLong);
              return;
            }
            int i = (int)(locala.field_downloadedSize / locala.field_totalSize * 100.0D);
            Bundle localBundle = new Bundle();
            localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
            localBundle.putInt("download_manager_progress", i);
            localBundle.putString("download_manager_appid", locala.field_appId);
            localWebViewStubCallbackWrapper.rno.b(1007, localBundle);
          }
          return;
        }
        catch (Exception localException)
        {
          y.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + localException.getMessage());
        }
      }
      
      public final void cz(long paramAnonymousLong) {}
      
      public final void k(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void onTaskPaused(long paramAnonymousLong) {}
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        y.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = " + paramAnonymousLong);
        for (;;)
        {
          try
          {
            Iterator localIterator = WebViewStubService.h(WebViewStubService.this).iterator();
            if (localIterator.hasNext())
            {
              WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
              Bundle localBundle = new Bundle();
              localBundle.putLong("download_manager_downloadid", paramAnonymousLong);
              Object localObject = com.tencent.mm.plugin.downloader.model.c.dk(paramAnonymousLong);
              if (localObject != null)
              {
                localObject = ((a)localObject).field_appId;
                localBundle.putCharSequence("download_manager_appid", (CharSequence)localObject);
                localWebViewStubCallbackWrapper.rno.b(1008, localBundle);
              }
            }
            else
            {
              return;
            }
          }
          catch (Exception localException)
          {
            y.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + localException.getMessage());
          }
          String str = "";
        }
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString) {}
    };
    d.aFP();
    b.a(this.rkc);
    this.rkd = new WebViewStubService.4(this);
    this.koY = new WebViewStubService.5(this);
    au.a(this.koY);
    if (au.DK()) {
      g.ccK().a(this.rkd);
    }
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
    super.onDestroy();
    d.aFP();
    b.b(this.rkc);
    if (au.DK()) {
      g.ccK().b(this.rkd);
    }
    au.b(this.koY);
    this.koY = null;
    this.rkc = null;
    this.bNT.clear();
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokevirtual 432	com/tencent/mm/ah/m:getType	()I
    //   5: istore 6
    //   7: ldc 122
    //   9: ldc_w 434
    //   12: iconst_4
    //   13: anewarray 140	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload 6
    //   20: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: iload_2
    //   27: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: iload_1
    //   34: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_3
    //   40: aload_3
    //   41: aastore
    //   42: invokestatic 247	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: iload 6
    //   47: bipush 106
    //   49: if_icmpne +373 -> 422
    //   52: invokestatic 112	com/tencent/mm/model/au:Dk	()Lcom/tencent/mm/ah/p;
    //   55: bipush 106
    //   57: aload_0
    //   58: invokevirtual 437	com/tencent/mm/ah/p:b	(ILcom/tencent/mm/ah/f;)V
    //   61: iload_1
    //   62: ifne +7 -> 69
    //   65: iload_2
    //   66: ifeq +36 -> 102
    //   69: ldc 122
    //   71: new 439	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 441
    //   78: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: iload_1
    //   82: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc_w 448
    //   88: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_2
    //   92: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: return
    //   102: aload 4
    //   104: checkcast 457	com/tencent/mm/plugin/messenger/a/f
    //   107: invokevirtual 461	com/tencent/mm/plugin/messenger/a/f:bhH	()Lcom/tencent/mm/protocal/c/bnm;
    //   110: astore 7
    //   112: aload 7
    //   114: getfield 467	com/tencent/mm/protocal/c/bnm:sQs	Lcom/tencent/mm/protocal/c/bml;
    //   117: invokestatic 472	com/tencent/mm/platformtools/aa:a	(Lcom/tencent/mm/protocal/c/bml;)Ljava/lang/String;
    //   120: astore 4
    //   122: invokestatic 478	com/tencent/mm/ag/o:JQ	()Lcom/tencent/mm/ag/d;
    //   125: aload 4
    //   127: aload 7
    //   129: getfield 482	com/tencent/mm/protocal/c/bnm:svJ	Lcom/tencent/mm/protocal/c/bmk;
    //   132: invokestatic 485	com/tencent/mm/platformtools/aa:a	(Lcom/tencent/mm/protocal/c/bmk;)[B
    //   135: invokevirtual 490	com/tencent/mm/ag/d:h	(Ljava/lang/String;[B)Z
    //   138: pop
    //   139: new 181	android/content/Intent
    //   142: dup
    //   143: invokespecial 491	android/content/Intent:<init>	()V
    //   146: astore 8
    //   148: aload 8
    //   150: aload 7
    //   152: bipush 30
    //   154: invokestatic 496	com/tencent/mm/pluginsdk/ui/tools/c:a	(Landroid/content/Intent;Lcom/tencent/mm/protocal/c/bnm;I)V
    //   157: aload 4
    //   159: invokestatic 501	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   162: invokevirtual 253	java/lang/String:length	()I
    //   165: ifle -64 -> 101
    //   168: invokestatic 505	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   171: pop
    //   172: invokestatic 511	com/tencent/mm/model/c:Fw	()Lcom/tencent/mm/storage/bd;
    //   175: aload 4
    //   177: invokeinterface 517 2 0
    //   182: astore 9
    //   184: aload 9
    //   186: ifnull +24 -> 210
    //   189: aload 9
    //   191: getfield 522	com/tencent/mm/h/c/ao:field_type	I
    //   194: invokestatic 528	com/tencent/mm/n/a:gR	(I)Z
    //   197: ifne +13 -> 210
    //   200: aload 8
    //   202: ldc_w 530
    //   205: iconst_1
    //   206: invokevirtual 533	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   209: pop
    //   210: aload 7
    //   212: getfield 536	com/tencent/mm/protocal/c/bnm:tpg	I
    //   215: bipush 8
    //   217: iand
    //   218: ifle +33 -> 251
    //   221: getstatic 542	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   224: sipush 10298
    //   227: new 439	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   234: aload 4
    //   236: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 545
    //   242: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 549	com/tencent/mm/plugin/report/service/h:aC	(ILjava/lang/String;)V
    //   251: aload 8
    //   253: ldc 204
    //   255: invokevirtual 208	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   258: pop
    //   259: getstatic 555	com/tencent/mm/plugin/webview/a/a:eUR	Lcom/tencent/mm/pluginsdk/m;
    //   262: aload 8
    //   264: aload_0
    //   265: invokeinterface 560 3 0
    //   270: new 83	android/os/Bundle
    //   273: dup
    //   274: invokespecial 561	android/os/Bundle:<init>	()V
    //   277: astore 7
    //   279: aload 7
    //   281: ldc_w 563
    //   284: aload 4
    //   286: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_0
    //   290: getfield 65	com/tencent/mm/plugin/webview/stub/WebViewStubService:bNT	Ljava/util/List;
    //   293: invokeinterface 161 1 0
    //   298: astore 4
    //   300: aload 4
    //   302: invokeinterface 166 1 0
    //   307: ifeq -206 -> 101
    //   310: aload 4
    //   312: invokeinterface 170 1 0
    //   317: checkcast 172	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   320: astore 8
    //   322: new 12	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   325: dup
    //   326: invokespecial 567	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   329: astore 9
    //   331: aload 9
    //   333: iload 6
    //   335: putfield 570	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   338: aload 9
    //   340: iload_1
    //   341: putfield 573	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   344: aload 9
    //   346: iload_2
    //   347: putfield 576	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   350: aload 9
    //   352: aload_3
    //   353: putfield 579	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:aox	Ljava/lang/String;
    //   356: aload 9
    //   358: aload 7
    //   360: putfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   363: aload 9
    //   365: getfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   368: ldc_w 585
    //   371: aload 8
    //   373: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   376: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   379: aload 8
    //   381: getfield 179	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:rno	Lcom/tencent/mm/plugin/webview/stub/e;
    //   384: aload 9
    //   386: invokeinterface 594 2 0
    //   391: pop
    //   392: goto -92 -> 300
    //   395: astore_3
    //   396: ldc 122
    //   398: new 439	java/lang/StringBuilder
    //   401: dup
    //   402: ldc_w 596
    //   405: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   408: aload_3
    //   409: invokevirtual 599	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   412: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: return
    //   422: iload 6
    //   424: sipush 233
    //   427: if_icmpne +896 -> 1323
    //   430: aload 4
    //   432: checkcast 601	com/tencent/mm/modelsimple/h
    //   435: astore 9
    //   437: new 83	android/os/Bundle
    //   440: dup
    //   441: invokespecial 561	android/os/Bundle:<init>	()V
    //   444: astore 8
    //   446: aload 9
    //   448: invokevirtual 605	com/tencent/mm/modelsimple/h:Qi	()[B
    //   451: astore 7
    //   453: aload 7
    //   455: ifnull +9 -> 464
    //   458: aload 7
    //   460: arraylength
    //   461: ifgt +11 -> 472
    //   464: ldc 122
    //   466: ldc_w 607
    //   469: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload 7
    //   474: astore 4
    //   476: aload 7
    //   478: ifnonnull +6 -> 484
    //   481: aconst_null
    //   482: astore 4
    //   484: aload 8
    //   486: ldc_w 609
    //   489: aload 4
    //   491: invokevirtual 613	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   494: aload 9
    //   496: getfield 617	com/tencent/mm/modelsimple/h:dmK	Lcom/tencent/mm/ah/b;
    //   499: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   502: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   505: checkcast 626	com/tencent/mm/protocal/c/aao
    //   508: getfield 630	com/tencent/mm/protocal/c/aao:sZY	Lcom/tencent/mm/protocal/c/aak;
    //   511: astore 4
    //   513: aload 4
    //   515: ifnonnull +464 -> 979
    //   518: iconst_0
    //   519: istore 5
    //   521: aload 8
    //   523: ldc_w 632
    //   526: iload 5
    //   528: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   531: aload 8
    //   533: ldc_w 634
    //   536: aload 9
    //   538: getfield 617	com/tencent/mm/modelsimple/h:dmK	Lcom/tencent/mm/ah/b;
    //   541: getfield 290	com/tencent/mm/ah/b:ecE	Lcom/tencent/mm/ah/b$b;
    //   544: getfield 295	com/tencent/mm/ah/b$b:ecN	Lcom/tencent/mm/bv/a;
    //   547: checkcast 636	com/tencent/mm/protocal/c/aan
    //   550: getfield 639	com/tencent/mm/protocal/c/aan:sZO	I
    //   553: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   556: aload 8
    //   558: ldc_w 641
    //   561: aload 9
    //   563: invokevirtual 644	com/tencent/mm/modelsimple/h:Qg	()Ljava/lang/String;
    //   566: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: aload 8
    //   571: ldc_w 646
    //   574: aload 9
    //   576: invokevirtual 649	com/tencent/mm/modelsimple/h:Qf	()Ljava/lang/String;
    //   579: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload 8
    //   584: ldc_w 651
    //   587: aload 9
    //   589: invokevirtual 654	com/tencent/mm/modelsimple/h:getTitle	()Ljava/lang/String;
    //   592: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 8
    //   597: ldc_w 656
    //   600: aload 9
    //   602: invokevirtual 659	com/tencent/mm/modelsimple/h:Qh	()I
    //   605: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   608: aload 8
    //   610: ldc_w 661
    //   613: aload 9
    //   615: invokevirtual 664	com/tencent/mm/modelsimple/h:getContent	()Ljava/lang/String;
    //   618: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload 8
    //   623: ldc_w 666
    //   626: aload 9
    //   628: getfield 617	com/tencent/mm/modelsimple/h:dmK	Lcom/tencent/mm/ah/b;
    //   631: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   634: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   637: checkcast 626	com/tencent/mm/protocal/c/aao
    //   640: getfield 669	com/tencent/mm/protocal/c/aao:tai	Ljava/lang/String;
    //   643: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload 8
    //   648: ldc_w 671
    //   651: aload 9
    //   653: getfield 617	com/tencent/mm/modelsimple/h:dmK	Lcom/tencent/mm/ah/b;
    //   656: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   659: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   662: checkcast 626	com/tencent/mm/protocal/c/aao
    //   665: getfield 674	com/tencent/mm/protocal/c/aao:lsL	Ljava/lang/String;
    //   668: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload 8
    //   673: ldc_w 676
    //   676: aload 9
    //   678: invokevirtual 680	com/tencent/mm/modelsimple/h:Ql	()J
    //   681: invokevirtual 684	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   684: aload 8
    //   686: ldc_w 686
    //   689: aload 9
    //   691: getfield 617	com/tencent/mm/modelsimple/h:dmK	Lcom/tencent/mm/ah/b;
    //   694: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   697: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   700: checkcast 626	com/tencent/mm/protocal/c/aao
    //   703: getfield 689	com/tencent/mm/protocal/c/aao:hPY	Ljava/lang/String;
    //   706: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   709: aload 8
    //   711: ldc_w 691
    //   714: aload 9
    //   716: invokevirtual 694	com/tencent/mm/modelsimple/h:Qo	()[B
    //   719: invokevirtual 613	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   722: aload 8
    //   724: ldc_w 696
    //   727: aload 9
    //   729: getfield 617	com/tencent/mm/modelsimple/h:dmK	Lcom/tencent/mm/ah/b;
    //   732: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   735: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   738: checkcast 626	com/tencent/mm/protocal/c/aao
    //   741: getfield 699	com/tencent/mm/protocal/c/aao:taj	Ljava/lang/String;
    //   744: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: ldc 122
    //   749: ldc_w 701
    //   752: iconst_1
    //   753: anewarray 140	java/lang/Object
    //   756: dup
    //   757: iconst_0
    //   758: aload 9
    //   760: invokevirtual 694	com/tencent/mm/modelsimple/h:Qo	()[B
    //   763: invokestatic 705	com/tencent/mm/sdk/platformtools/bk:bG	([B)Ljava/lang/String;
    //   766: aastore
    //   767: invokestatic 707	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   770: aload 9
    //   772: invokevirtual 711	com/tencent/mm/modelsimple/h:Qm	()Ljava/util/List;
    //   775: astore 4
    //   777: aload 4
    //   779: invokestatic 715	com/tencent/mm/sdk/platformtools/bk:dk	(Ljava/util/List;)Z
    //   782: ifne +227 -> 1009
    //   785: aload 4
    //   787: invokeinterface 161 1 0
    //   792: astore 7
    //   794: aload 7
    //   796: invokeinterface 166 1 0
    //   801: ifeq +1823 -> 2624
    //   804: aload 7
    //   806: invokeinterface 170 1 0
    //   811: checkcast 717	com/tencent/mm/protocal/c/apm
    //   814: astore 10
    //   816: aload 10
    //   818: ifnull +25 -> 843
    //   821: aload 10
    //   823: getfield 720	com/tencent/mm/protocal/c/apm:sCH	Ljava/lang/String;
    //   826: invokestatic 723	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   829: ifne +14 -> 843
    //   832: aload 10
    //   834: getfield 726	com/tencent/mm/protocal/c/apm:nFs	Ljava/lang/String;
    //   837: invokestatic 723	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   840: ifeq -46 -> 794
    //   843: ldc 122
    //   845: ldc_w 728
    //   848: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: iconst_1
    //   852: istore 5
    //   854: iload 5
    //   856: ifne +153 -> 1009
    //   859: aload 4
    //   861: invokeinterface 731 1 0
    //   866: anewarray 249	java/lang/String
    //   869: astore 7
    //   871: aload 4
    //   873: invokeinterface 731 1 0
    //   878: anewarray 249	java/lang/String
    //   881: astore 10
    //   883: iconst_0
    //   884: istore 5
    //   886: iload 5
    //   888: aload 4
    //   890: invokeinterface 731 1 0
    //   895: if_icmpge +94 -> 989
    //   898: aload 4
    //   900: iload 5
    //   902: invokeinterface 735 2 0
    //   907: checkcast 717	com/tencent/mm/protocal/c/apm
    //   910: astore 12
    //   912: aload 12
    //   914: getfield 720	com/tencent/mm/protocal/c/apm:sCH	Ljava/lang/String;
    //   917: astore 11
    //   919: aload 12
    //   921: getfield 726	com/tencent/mm/protocal/c/apm:nFs	Ljava/lang/String;
    //   924: astore 12
    //   926: ldc 122
    //   928: ldc_w 737
    //   931: iconst_3
    //   932: anewarray 140	java/lang/Object
    //   935: dup
    //   936: iconst_0
    //   937: iload 5
    //   939: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   942: aastore
    //   943: dup
    //   944: iconst_1
    //   945: aload 11
    //   947: aastore
    //   948: dup
    //   949: iconst_2
    //   950: aload 12
    //   952: aastore
    //   953: invokestatic 247	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: aload 7
    //   958: iload 5
    //   960: aload 11
    //   962: aastore
    //   963: aload 10
    //   965: iload 5
    //   967: aload 12
    //   969: aastore
    //   970: iload 5
    //   972: iconst_1
    //   973: iadd
    //   974: istore 5
    //   976: goto -90 -> 886
    //   979: aload 4
    //   981: getfield 742	com/tencent/mm/protocal/c/aak:sZE	I
    //   984: istore 5
    //   986: goto -465 -> 521
    //   989: aload 8
    //   991: ldc_w 744
    //   994: aload 7
    //   996: invokevirtual 748	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   999: aload 8
    //   1001: ldc_w 750
    //   1004: aload 10
    //   1006: invokevirtual 748	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1009: aload 8
    //   1011: ldc_w 752
    //   1014: aload 9
    //   1016: invokevirtual 756	com/tencent/mm/modelsimple/h:Qk	()Ljava/util/ArrayList;
    //   1019: invokevirtual 760	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1022: ldc 122
    //   1024: ldc_w 762
    //   1027: iconst_4
    //   1028: anewarray 140	java/lang/Object
    //   1031: dup
    //   1032: iconst_0
    //   1033: aload 9
    //   1035: invokevirtual 765	com/tencent/mm/modelsimple/h:Qj	()Ljava/lang/String;
    //   1038: aastore
    //   1039: dup
    //   1040: iconst_1
    //   1041: aload 9
    //   1043: invokevirtual 649	com/tencent/mm/modelsimple/h:Qf	()Ljava/lang/String;
    //   1046: aastore
    //   1047: dup
    //   1048: iconst_2
    //   1049: aload 9
    //   1051: invokevirtual 644	com/tencent/mm/modelsimple/h:Qg	()Ljava/lang/String;
    //   1054: aastore
    //   1055: dup
    //   1056: iconst_3
    //   1057: iconst_1
    //   1058: invokestatic 770	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1061: aastore
    //   1062: invokestatic 247	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1065: aload 9
    //   1067: invokevirtual 765	com/tencent/mm/modelsimple/h:Qj	()Ljava/lang/String;
    //   1070: invokestatic 723	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1073: ifne +146 -> 1219
    //   1076: aload 9
    //   1078: invokevirtual 649	com/tencent/mm/modelsimple/h:Qf	()Ljava/lang/String;
    //   1081: aload 9
    //   1083: invokevirtual 765	com/tencent/mm/modelsimple/h:Qj	()Ljava/lang/String;
    //   1086: invokestatic 775	com/tencent/mm/plugin/webview/model/ao:fv	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: aload 9
    //   1091: getfield 776	com/tencent/mm/modelsimple/h:tag	Ljava/lang/Object;
    //   1094: ifnull +1524 -> 2618
    //   1097: aload 9
    //   1099: getfield 776	com/tencent/mm/modelsimple/h:tag	Ljava/lang/Object;
    //   1102: checkcast 98	java/lang/Integer
    //   1105: invokevirtual 779	java/lang/Integer:intValue	()I
    //   1108: istore 5
    //   1110: aload_0
    //   1111: getfield 65	com/tencent/mm/plugin/webview/stub/WebViewStubService:bNT	Ljava/util/List;
    //   1114: invokeinterface 161 1 0
    //   1119: astore 4
    //   1121: aload 4
    //   1123: invokeinterface 166 1 0
    //   1128: ifeq -1027 -> 101
    //   1131: aload 4
    //   1133: invokeinterface 170 1 0
    //   1138: checkcast 172	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   1141: astore 7
    //   1143: iload 5
    //   1145: ifeq +105 -> 1250
    //   1148: iload 5
    //   1150: aload 7
    //   1152: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1155: if_icmpeq +95 -> 1250
    //   1158: ldc 122
    //   1160: ldc_w 781
    //   1163: iconst_2
    //   1164: anewarray 140	java/lang/Object
    //   1167: dup
    //   1168: iconst_0
    //   1169: iload 5
    //   1171: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1174: aastore
    //   1175: dup
    //   1176: iconst_1
    //   1177: aload 7
    //   1179: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1182: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: aastore
    //   1186: invokestatic 707	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1189: goto -68 -> 1121
    //   1192: astore_3
    //   1193: ldc 122
    //   1195: new 439	java/lang/StringBuilder
    //   1198: dup
    //   1199: ldc_w 783
    //   1202: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1205: aload_3
    //   1206: invokestatic 789	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1209: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1218: return
    //   1219: ldc 122
    //   1221: ldc_w 791
    //   1224: iconst_2
    //   1225: anewarray 140	java/lang/Object
    //   1228: dup
    //   1229: iconst_0
    //   1230: aload 9
    //   1232: invokevirtual 649	com/tencent/mm/modelsimple/h:Qf	()Ljava/lang/String;
    //   1235: aastore
    //   1236: dup
    //   1237: iconst_1
    //   1238: aload 9
    //   1240: invokevirtual 644	com/tencent/mm/modelsimple/h:Qg	()Ljava/lang/String;
    //   1243: aastore
    //   1244: invokestatic 143	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1247: goto -158 -> 1089
    //   1250: new 12	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   1253: dup
    //   1254: invokespecial 567	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   1257: astore 9
    //   1259: aload 9
    //   1261: iload 6
    //   1263: putfield 570	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   1266: aload 9
    //   1268: iload_1
    //   1269: putfield 573	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   1272: aload 9
    //   1274: iload_2
    //   1275: putfield 576	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   1278: aload 9
    //   1280: aload_3
    //   1281: putfield 579	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:aox	Ljava/lang/String;
    //   1284: aload 9
    //   1286: aload 8
    //   1288: putfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   1291: aload 9
    //   1293: getfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   1296: ldc_w 585
    //   1299: aload 7
    //   1301: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1304: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1307: aload 7
    //   1309: getfield 179	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:rno	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1312: aload 9
    //   1314: invokeinterface 594 2 0
    //   1319: pop
    //   1320: goto -199 -> 1121
    //   1323: iload 6
    //   1325: sipush 673
    //   1328: if_icmpne +265 -> 1593
    //   1331: aload 4
    //   1333: checkcast 793	com/tencent/mm/plugin/webview/model/n
    //   1336: astore 8
    //   1338: new 83	android/os/Bundle
    //   1341: dup
    //   1342: invokespecial 561	android/os/Bundle:<init>	()V
    //   1345: astore 7
    //   1347: aload 8
    //   1349: getfield 794	com/tencent/mm/plugin/webview/model/n:dmK	Lcom/tencent/mm/ah/b;
    //   1352: ifnonnull +146 -> 1498
    //   1355: aconst_null
    //   1356: astore 4
    //   1358: aload 7
    //   1360: ldc_w 796
    //   1363: aload 4
    //   1365: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1368: aload 8
    //   1370: getfield 797	com/tencent/mm/plugin/webview/model/n:tag	Ljava/lang/Object;
    //   1373: ifnull +1239 -> 2612
    //   1376: aload 8
    //   1378: getfield 797	com/tencent/mm/plugin/webview/model/n:tag	Ljava/lang/Object;
    //   1381: checkcast 98	java/lang/Integer
    //   1384: invokevirtual 779	java/lang/Integer:intValue	()I
    //   1387: istore 5
    //   1389: aload_0
    //   1390: getfield 65	com/tencent/mm/plugin/webview/stub/WebViewStubService:bNT	Ljava/util/List;
    //   1393: invokeinterface 161 1 0
    //   1398: astore 4
    //   1400: aload 4
    //   1402: invokeinterface 166 1 0
    //   1407: ifeq -1306 -> 101
    //   1410: aload 4
    //   1412: invokeinterface 170 1 0
    //   1417: checkcast 172	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   1420: astore 8
    //   1422: iload 5
    //   1424: ifeq +96 -> 1520
    //   1427: iload 5
    //   1429: aload 8
    //   1431: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1434: if_icmpeq +86 -> 1520
    //   1437: ldc 122
    //   1439: ldc_w 799
    //   1442: iconst_2
    //   1443: anewarray 140	java/lang/Object
    //   1446: dup
    //   1447: iconst_0
    //   1448: iload 5
    //   1450: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1453: aastore
    //   1454: dup
    //   1455: iconst_1
    //   1456: aload 8
    //   1458: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1461: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1464: aastore
    //   1465: invokestatic 707	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1468: goto -68 -> 1400
    //   1471: astore_3
    //   1472: ldc 122
    //   1474: new 439	java/lang/StringBuilder
    //   1477: dup
    //   1478: ldc_w 783
    //   1481: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1484: aload_3
    //   1485: invokestatic 789	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1488: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1494: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1497: return
    //   1498: aload 8
    //   1500: getfield 794	com/tencent/mm/plugin/webview/model/n:dmK	Lcom/tencent/mm/ah/b;
    //   1503: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   1506: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   1509: checkcast 801	com/tencent/mm/protocal/c/ajp
    //   1512: getfield 804	com/tencent/mm/protocal/c/ajp:URL	Ljava/lang/String;
    //   1515: astore 4
    //   1517: goto -159 -> 1358
    //   1520: new 12	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   1523: dup
    //   1524: invokespecial 567	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   1527: astore 9
    //   1529: aload 9
    //   1531: iload 6
    //   1533: putfield 570	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   1536: aload 9
    //   1538: iload_1
    //   1539: putfield 573	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   1542: aload 9
    //   1544: iload_2
    //   1545: putfield 576	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   1548: aload 9
    //   1550: aload_3
    //   1551: putfield 579	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:aox	Ljava/lang/String;
    //   1554: aload 9
    //   1556: aload 7
    //   1558: putfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   1561: aload 9
    //   1563: getfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   1566: ldc_w 585
    //   1569: aload 8
    //   1571: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1574: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1577: aload 8
    //   1579: getfield 179	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:rno	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1582: aload 9
    //   1584: invokeinterface 594 2 0
    //   1589: pop
    //   1590: goto -190 -> 1400
    //   1593: iload 6
    //   1595: sipush 666
    //   1598: if_icmpne +335 -> 1933
    //   1601: aload 4
    //   1603: checkcast 79	com/tencent/mm/modelsimple/u
    //   1606: astore 7
    //   1608: new 83	android/os/Bundle
    //   1611: dup
    //   1612: invokespecial 561	android/os/Bundle:<init>	()V
    //   1615: astore 4
    //   1617: aload 4
    //   1619: ldc_w 806
    //   1622: aload 7
    //   1624: invokevirtual 810	com/tencent/mm/modelsimple/u:QO	()Lcom/tencent/mm/protocal/c/ask;
    //   1627: getfield 815	com/tencent/mm/protocal/c/ask:syc	Ljava/lang/String;
    //   1630: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1633: iload_1
    //   1634: ifne +96 -> 1730
    //   1637: iload_2
    //   1638: ifne +92 -> 1730
    //   1641: aload 4
    //   1643: ldc_w 806
    //   1646: invokevirtual 87	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1649: astore 8
    //   1651: ldc 122
    //   1653: ldc_w 817
    //   1656: iconst_1
    //   1657: anewarray 140	java/lang/Object
    //   1660: dup
    //   1661: iconst_0
    //   1662: aload 8
    //   1664: aastore
    //   1665: invokestatic 247	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1668: aload 8
    //   1670: invokestatic 723	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1673: ifne +57 -> 1730
    //   1676: new 181	android/content/Intent
    //   1679: dup
    //   1680: invokespecial 491	android/content/Intent:<init>	()V
    //   1683: astore 9
    //   1685: aload 9
    //   1687: ldc_w 819
    //   1690: aload 8
    //   1692: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1695: pop
    //   1696: aload 9
    //   1698: ldc_w 821
    //   1701: bipush 12
    //   1703: invokevirtual 196	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1706: pop
    //   1707: aload 9
    //   1709: ldc_w 823
    //   1712: bipush 12
    //   1714: invokevirtual 196	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1717: pop
    //   1718: aload_0
    //   1719: ldc_w 825
    //   1722: ldc_w 827
    //   1725: aload 9
    //   1727: invokestatic 832	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1730: aload 7
    //   1732: getfield 106	com/tencent/mm/modelsimple/u:tag	Ljava/lang/Object;
    //   1735: ifnull +871 -> 2606
    //   1738: aload 7
    //   1740: getfield 106	com/tencent/mm/modelsimple/u:tag	Ljava/lang/Object;
    //   1743: checkcast 98	java/lang/Integer
    //   1746: invokevirtual 779	java/lang/Integer:intValue	()I
    //   1749: istore 5
    //   1751: aload_0
    //   1752: getfield 65	com/tencent/mm/plugin/webview/stub/WebViewStubService:bNT	Ljava/util/List;
    //   1755: invokeinterface 161 1 0
    //   1760: astore 7
    //   1762: aload 7
    //   1764: invokeinterface 166 1 0
    //   1769: ifeq -1668 -> 101
    //   1772: aload 7
    //   1774: invokeinterface 170 1 0
    //   1779: checkcast 172	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   1782: astore 8
    //   1784: iload 5
    //   1786: ifeq +74 -> 1860
    //   1789: iload 5
    //   1791: aload 8
    //   1793: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1796: if_icmpeq +64 -> 1860
    //   1799: ldc 122
    //   1801: ldc_w 834
    //   1804: iconst_2
    //   1805: anewarray 140	java/lang/Object
    //   1808: dup
    //   1809: iconst_0
    //   1810: iload 5
    //   1812: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1815: aastore
    //   1816: dup
    //   1817: iconst_1
    //   1818: aload 8
    //   1820: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1823: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1826: aastore
    //   1827: invokestatic 707	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1830: goto -68 -> 1762
    //   1833: astore_3
    //   1834: ldc 122
    //   1836: new 439	java/lang/StringBuilder
    //   1839: dup
    //   1840: ldc_w 836
    //   1843: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1846: aload_3
    //   1847: invokevirtual 599	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1850: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1859: return
    //   1860: new 12	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   1863: dup
    //   1864: invokespecial 567	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   1867: astore 9
    //   1869: aload 9
    //   1871: iload 6
    //   1873: putfield 570	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   1876: aload 9
    //   1878: iload_1
    //   1879: putfield 573	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   1882: aload 9
    //   1884: iload_2
    //   1885: putfield 576	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   1888: aload 9
    //   1890: aload_3
    //   1891: putfield 579	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:aox	Ljava/lang/String;
    //   1894: aload 9
    //   1896: aload 4
    //   1898: putfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   1901: aload 9
    //   1903: getfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   1906: ldc_w 585
    //   1909: aload 8
    //   1911: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   1914: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1917: aload 8
    //   1919: getfield 179	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:rno	Lcom/tencent/mm/plugin/webview/stub/e;
    //   1922: aload 9
    //   1924: invokeinterface 594 2 0
    //   1929: pop
    //   1930: goto -168 -> 1762
    //   1933: iload 6
    //   1935: sipush 1254
    //   1938: if_icmpne +376 -> 2314
    //   1941: aload 4
    //   1943: checkcast 838	com/tencent/mm/plugin/webview/model/v
    //   1946: astore 7
    //   1948: aload 7
    //   1950: getfield 839	com/tencent/mm/plugin/webview/model/v:tag	Ljava/lang/Object;
    //   1953: ifnull +647 -> 2600
    //   1956: aload 7
    //   1958: getfield 839	com/tencent/mm/plugin/webview/model/v:tag	Ljava/lang/Object;
    //   1961: checkcast 98	java/lang/Integer
    //   1964: invokevirtual 779	java/lang/Integer:intValue	()I
    //   1967: istore 5
    //   1969: aload_0
    //   1970: getfield 65	com/tencent/mm/plugin/webview/stub/WebViewStubService:bNT	Ljava/util/List;
    //   1973: invokeinterface 161 1 0
    //   1978: astore 7
    //   1980: aload 7
    //   1982: invokeinterface 166 1 0
    //   1987: ifeq -1886 -> 101
    //   1990: aload 7
    //   1992: invokeinterface 170 1 0
    //   1997: checkcast 172	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   2000: astore 8
    //   2002: iload 5
    //   2004: ifeq +74 -> 2078
    //   2007: iload 5
    //   2009: aload 8
    //   2011: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2014: if_icmpeq +64 -> 2078
    //   2017: ldc 122
    //   2019: ldc_w 841
    //   2022: iconst_2
    //   2023: anewarray 140	java/lang/Object
    //   2026: dup
    //   2027: iconst_0
    //   2028: iload 5
    //   2030: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2033: aastore
    //   2034: dup
    //   2035: iconst_1
    //   2036: aload 8
    //   2038: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2041: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2044: aastore
    //   2045: invokestatic 707	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2048: goto -68 -> 1980
    //   2051: astore_3
    //   2052: ldc 122
    //   2054: new 439	java/lang/StringBuilder
    //   2057: dup
    //   2058: ldc_w 843
    //   2061: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2064: aload_3
    //   2065: invokestatic 789	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2068: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2074: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2077: return
    //   2078: new 12	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   2081: dup
    //   2082: invokespecial 567	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   2085: astore 9
    //   2087: aload 9
    //   2089: iload 6
    //   2091: putfield 570	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   2094: aload 9
    //   2096: iload_1
    //   2097: putfield 573	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   2100: aload 9
    //   2102: iload_2
    //   2103: putfield 576	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   2106: aload 9
    //   2108: aload_3
    //   2109: putfield 579	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:aox	Ljava/lang/String;
    //   2112: new 83	android/os/Bundle
    //   2115: dup
    //   2116: invokespecial 561	android/os/Bundle:<init>	()V
    //   2119: astore 10
    //   2121: iload_1
    //   2122: ifne +508 -> 2630
    //   2125: iload_2
    //   2126: ifeq +45 -> 2171
    //   2129: goto +501 -> 2630
    //   2132: aload 9
    //   2134: aload 10
    //   2136: putfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   2139: aload 9
    //   2141: getfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   2144: ldc_w 585
    //   2147: aload 8
    //   2149: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2152: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2155: aload 8
    //   2157: getfield 179	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:rno	Lcom/tencent/mm/plugin/webview/stub/e;
    //   2160: aload 9
    //   2162: invokeinterface 594 2 0
    //   2167: pop
    //   2168: goto -188 -> 1980
    //   2171: aload 4
    //   2173: instanceof 838
    //   2176: ifne +6 -> 2182
    //   2179: goto -47 -> 2132
    //   2182: aload 4
    //   2184: checkcast 838	com/tencent/mm/plugin/webview/model/v
    //   2187: getfield 844	com/tencent/mm/plugin/webview/model/v:dmK	Lcom/tencent/mm/ah/b;
    //   2190: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   2193: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   2196: checkcast 846	com/tencent/mm/protocal/c/azo
    //   2199: astore 11
    //   2201: aload 10
    //   2203: ldc_w 848
    //   2206: aload 4
    //   2208: checkcast 838	com/tencent/mm/plugin/webview/model/v
    //   2211: getfield 851	com/tencent/mm/plugin/webview/model/v:rfz	Ljava/lang/String;
    //   2214: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2217: aload 10
    //   2219: ldc_w 853
    //   2222: aload 11
    //   2224: getfield 857	com/tencent/mm/protocal/c/azo:tvI	Ljava/util/LinkedList;
    //   2227: invokestatic 863	com/tencent/mm/plugin/webview/model/ac:au	(Ljava/util/LinkedList;)Ljava/util/ArrayList;
    //   2230: invokevirtual 760	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2233: aload 10
    //   2235: ldc_w 865
    //   2238: aload 11
    //   2240: getfield 868	com/tencent/mm/protocal/c/azo:dRQ	Ljava/lang/String;
    //   2243: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2246: aload 10
    //   2248: ldc_w 870
    //   2251: aload 11
    //   2253: getfield 873	com/tencent/mm/protocal/c/azo:tvJ	Ljava/lang/String;
    //   2256: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2259: aload 10
    //   2261: ldc_w 875
    //   2264: aload 11
    //   2266: getfield 878	com/tencent/mm/protocal/c/azo:sLy	Ljava/lang/String;
    //   2269: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2272: aload 10
    //   2274: ldc_w 880
    //   2277: aload 11
    //   2279: getfield 884	com/tencent/mm/protocal/c/azo:tvK	Z
    //   2282: invokevirtual 888	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2285: aload 10
    //   2287: ldc_w 890
    //   2290: aload 11
    //   2292: getfield 893	com/tencent/mm/protocal/c/azo:tvL	Z
    //   2295: invokevirtual 888	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2298: aload 10
    //   2300: ldc_w 895
    //   2303: aload 11
    //   2305: getfield 898	com/tencent/mm/protocal/c/azo:tvM	Z
    //   2308: invokevirtual 888	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2311: goto -179 -> 2132
    //   2314: iload 6
    //   2316: sipush 1373
    //   2319: if_icmpne -2218 -> 101
    //   2322: aload 4
    //   2324: checkcast 900	com/tencent/mm/plugin/webview/model/w
    //   2327: astore 7
    //   2329: aload 7
    //   2331: getfield 901	com/tencent/mm/plugin/webview/model/w:tag	Ljava/lang/Object;
    //   2334: ifnull +260 -> 2594
    //   2337: aload 7
    //   2339: getfield 901	com/tencent/mm/plugin/webview/model/w:tag	Ljava/lang/Object;
    //   2342: checkcast 98	java/lang/Integer
    //   2345: invokevirtual 779	java/lang/Integer:intValue	()I
    //   2348: istore 5
    //   2350: aload_0
    //   2351: getfield 65	com/tencent/mm/plugin/webview/stub/WebViewStubService:bNT	Ljava/util/List;
    //   2354: invokeinterface 161 1 0
    //   2359: astore 7
    //   2361: aload 7
    //   2363: invokeinterface 166 1 0
    //   2368: ifeq -2267 -> 101
    //   2371: aload 7
    //   2373: invokeinterface 170 1 0
    //   2378: checkcast 172	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper
    //   2381: astore 8
    //   2383: iload 5
    //   2385: ifeq +74 -> 2459
    //   2388: iload 5
    //   2390: aload 8
    //   2392: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2395: if_icmpeq +64 -> 2459
    //   2398: ldc 122
    //   2400: ldc_w 903
    //   2403: iconst_2
    //   2404: anewarray 140	java/lang/Object
    //   2407: dup
    //   2408: iconst_0
    //   2409: iload 5
    //   2411: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2414: aastore
    //   2415: dup
    //   2416: iconst_1
    //   2417: aload 8
    //   2419: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2422: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2425: aastore
    //   2426: invokestatic 707	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2429: goto -68 -> 2361
    //   2432: astore_3
    //   2433: ldc 122
    //   2435: new 439	java/lang/StringBuilder
    //   2438: dup
    //   2439: ldc_w 905
    //   2442: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2445: aload_3
    //   2446: invokestatic 789	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2449: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2452: invokevirtual 455	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2455: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2458: return
    //   2459: new 12	com/tencent/mm/plugin/webview/stub/WebViewStubService$b
    //   2462: dup
    //   2463: invokespecial 567	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:<init>	()V
    //   2466: astore 9
    //   2468: aload 9
    //   2470: iload 6
    //   2472: putfield 570	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:type	I
    //   2475: aload 9
    //   2477: iload_1
    //   2478: putfield 573	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errType	I
    //   2481: aload 9
    //   2483: iload_2
    //   2484: putfield 576	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:errCode	I
    //   2487: aload 9
    //   2489: aload_3
    //   2490: putfield 579	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:aox	Ljava/lang/String;
    //   2493: new 83	android/os/Bundle
    //   2496: dup
    //   2497: invokespecial 561	android/os/Bundle:<init>	()V
    //   2500: astore 10
    //   2502: iload_1
    //   2503: ifne +130 -> 2633
    //   2506: iload_2
    //   2507: ifeq +45 -> 2552
    //   2510: goto +123 -> 2633
    //   2513: aload 9
    //   2515: aload 10
    //   2517: putfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   2520: aload 9
    //   2522: getfield 583	com/tencent/mm/plugin/webview/stub/WebViewStubService$b:kke	Landroid/os/Bundle;
    //   2525: ldc_w 585
    //   2528: aload 8
    //   2530: getfield 175	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:id	I
    //   2533: invokevirtual 589	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2536: aload 8
    //   2538: getfield 179	com/tencent/mm/plugin/webview/ui/tools/WebViewStubCallbackWrapper:rno	Lcom/tencent/mm/plugin/webview/stub/e;
    //   2541: aload 9
    //   2543: invokeinterface 594 2 0
    //   2548: pop
    //   2549: goto -188 -> 2361
    //   2552: aload 4
    //   2554: instanceof 900
    //   2557: ifne +6 -> 2563
    //   2560: goto -47 -> 2513
    //   2563: aload 10
    //   2565: ldc_w 875
    //   2568: aload 4
    //   2570: checkcast 900	com/tencent/mm/plugin/webview/model/w
    //   2573: getfield 906	com/tencent/mm/plugin/webview/model/w:dmK	Lcom/tencent/mm/ah/b;
    //   2576: getfield 621	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   2579: getfield 624	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   2582: checkcast 908	com/tencent/mm/protocal/c/azm
    //   2585: getfield 909	com/tencent/mm/protocal/c/azm:sLy	Ljava/lang/String;
    //   2588: invokevirtual 566	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2591: goto -78 -> 2513
    //   2594: iconst_0
    //   2595: istore 5
    //   2597: goto -247 -> 2350
    //   2600: iconst_0
    //   2601: istore 5
    //   2603: goto -634 -> 1969
    //   2606: iconst_0
    //   2607: istore 5
    //   2609: goto -858 -> 1751
    //   2612: iconst_0
    //   2613: istore 5
    //   2615: goto -1226 -> 1389
    //   2618: iconst_0
    //   2619: istore 5
    //   2621: goto -1511 -> 1110
    //   2624: iconst_0
    //   2625: istore 5
    //   2627: goto -1773 -> 854
    //   2630: goto -498 -> 2132
    //   2633: goto -120 -> 2513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2636	0	this	WebViewStubService
    //   0	2636	1	paramInt1	int
    //   0	2636	2	paramInt2	int
    //   0	2636	3	paramString	String
    //   0	2636	4	paramm	com.tencent.mm.ah.m
    //   519	2107	5	i	int
    //   5	2466	6	j	int
    //   110	2262	7	localObject1	Object
    //   146	2391	8	localObject2	Object
    //   182	2360	9	localObject3	Object
    //   814	1750	10	localObject4	Object
    //   917	1387	11	localObject5	Object
    //   910	58	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   289	300	395	java/lang/Exception
    //   300	392	395	java/lang/Exception
    //   1089	1110	1192	java/lang/Exception
    //   1110	1121	1192	java/lang/Exception
    //   1121	1143	1192	java/lang/Exception
    //   1148	1189	1192	java/lang/Exception
    //   1250	1320	1192	java/lang/Exception
    //   1368	1389	1471	java/lang/Exception
    //   1389	1400	1471	java/lang/Exception
    //   1400	1422	1471	java/lang/Exception
    //   1427	1468	1471	java/lang/Exception
    //   1520	1590	1471	java/lang/Exception
    //   1730	1751	1833	java/lang/Exception
    //   1751	1762	1833	java/lang/Exception
    //   1762	1784	1833	java/lang/Exception
    //   1789	1830	1833	java/lang/Exception
    //   1860	1930	1833	java/lang/Exception
    //   1941	1969	2051	java/lang/Exception
    //   1969	1980	2051	java/lang/Exception
    //   1980	2002	2051	java/lang/Exception
    //   2007	2048	2051	java/lang/Exception
    //   2078	2121	2051	java/lang/Exception
    //   2132	2168	2051	java/lang/Exception
    //   2171	2179	2051	java/lang/Exception
    //   2182	2311	2051	java/lang/Exception
    //   2322	2350	2432	java/lang/Exception
    //   2350	2361	2432	java/lang/Exception
    //   2361	2383	2432	java/lang/Exception
    //   2388	2429	2432	java/lang/Exception
    //   2459	2502	2432	java/lang/Exception
    //   2513	2549	2432	java/lang/Exception
    //   2552	2560	2432	java/lang/Exception
    //   2563	2591	2432	java/lang/Exception
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    y.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
    h.detach();
    ao.clear();
    q.a.ccy().release(false);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService
 * JD-Core Version:    0.7.0.1
 */