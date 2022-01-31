package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.b;
import com.tencent.mm.h.a.ce;
import com.tencent.mm.h.a.ce.a;
import com.tencent.mm.h.a.ce.b;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.df;
import com.tencent.mm.h.a.dg;
import com.tencent.mm.h.a.dh;
import com.tencent.mm.h.a.dh.b;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.fi;
import com.tencent.mm.h.a.fl;
import com.tencent.mm.h.a.fo;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.h.a.gr;
import com.tencent.mm.h.a.gr.b;
import com.tencent.mm.h.a.he;
import com.tencent.mm.h.a.hs;
import com.tencent.mm.h.a.hs.a;
import com.tencent.mm.h.a.mr;
import com.tencent.mm.h.a.mr.b;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.a.mz.a;
import com.tencent.mm.h.a.ra;
import com.tencent.mm.h.a.ra.b;
import com.tencent.mm.h.a.uk;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelstat.a.b.1;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.fts.b.e;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.f.a;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.modelcache.q.5;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.modeltools.j.a;
import com.tencent.mm.plugin.webview.modeltools.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.bag.n.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.79;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;

final class WebViewStubService$1
  extends d.a
{
  WebViewStubService$1(WebViewStubService paramWebViewStubService) {}
  
  private static int oX(String paramString)
  {
    try
    {
      int i = bk.getInt(com.tencent.mm.m.g.AA().getValue(paramString), 1);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: " + paramString);
    }
    return 1;
  }
  
  public final void Ch(int paramInt)
  {
    if (WebViewStubService.h(this.rkg).size() == 0)
    {
      localObject1 = new fo();
      ((fo)localObject1).bMz.bMC = 2;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new fi();
      ((fi)localObject1).bMc.op = 2;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new fl();
      ((fl)localObject1).bMj.op = 2;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
    y.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
    localg.ryu = true;
    com.tencent.mm.sdk.b.a.udP.d(localg.iGH);
    if (localg.cgp())
    {
      localObject1 = com.tencent.mm.plugin.webview.modeltools.g.ccL().Sl(localg.ryX);
      if (localObject1 != null) {
        ai.d(new g.79(localg, (WebViewJSSDKFileItem)localObject1));
      }
    }
    Object localObject5;
    if (((localg.cdu() != 8) && (localg.cdu() != -1)) || (localg.aZY() == 27)) {
      if (((localg.ryt == null) || (localg.ryt.isEmpty())) && ((localg.rys == null) || (localg.rys.isEmpty())))
      {
        y.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
        localObject5 = f.a.cbG();
        if (!bk.dk(((com.tencent.mm.plugin.webview.model.f)localObject5).rfp)) {
          break label1325;
        }
        y.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
      }
    }
    for (;;)
    {
      if (localg.ryq != null) {
        localg.ryq.setClassLoader(localg.getClass().getClassLoader());
      }
      localObject1 = "";
      if (localg.ryq != null)
      {
        localg.ryq.setClassLoader(localg.getClass().getClassLoader());
        localObject1 = localg.ryq.getString("KoriginUrl");
      }
      Object localObject2 = new uk();
      ((uk)localObject2).ceP.ceM = ((String)localObject1);
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if (localg.ryq != null)
      {
        localObject1 = com.tencent.mm.modelsns.b.i(localg.ryq);
        if (localObject1 != null)
        {
          ((com.tencent.mm.modelsns.b)localObject1).update();
          ((com.tencent.mm.modelsns.b)localObject1).QX();
        }
      }
      localObject1 = localg.ryW.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!bk.bl((String)localObject2))
        {
          com.tencent.mm.plugin.webview.modeltools.g.ccK();
          ag.rO((String)localObject2);
          localObject2 = (g.b)localg.ryW.get(localObject2);
          if (localObject2 != null)
          {
            if (((g.b)localObject2).rAH != null) {
              com.tencent.mm.plugin.webview.modeltools.g.ccK().a(((g.b)localObject2).rAH);
            }
            if (((g.b)localObject2).rym != null) {
              localg.a(((g.b)localObject2).rym, "uploadVideo:cancel", null, false);
            }
          }
        }
      }
      Object localObject6;
      if ((localg.ryt != null) && (!localg.ryt.isEmpty()))
      {
        localObject1 = localg.ryt.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (String)((Map.Entry)localObject5).getValue();
          y.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", new Object[] { localObject2, localObject5 });
          try
          {
            localObject6 = new dg();
            ((dg)localObject6).bJz.bJx = false;
            ((dg)localObject6).bJz.bJw = ((String)localObject2);
            ((dg)localObject6).bJz.bwK = ((String)localObject5);
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject6);
            y.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
          }
          catch (Exception localException1)
          {
            y.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
            y.printErrStackTrace("MicroMsg.MsgHandler", localException1, "", new Object[0]);
          }
        }
        localg.ryt.clear();
      }
      if ((localg.rys == null) || (localg.rys.isEmpty())) {
        break;
      }
      localObject1 = localg.rys.entrySet().iterator();
      Object localObject3 = localg.cgo();
      if (!bk.bl((String)localObject3))
      {
        localObject3 = com.tencent.mm.ai.f.kX((String)localObject3);
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.ai.d)localObject3).bS(false);
          if ((localObject3 == null) || (((d.b)localObject3).LS() == null) || (!((d.b)localObject3).LS().Mc())) {}
        }
      }
      for (boolean bool = true;; bool = false)
      {
        y.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[] { Boolean.valueOf(bool) });
        if (localObject1 == null) {
          break;
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (String)((Map.Entry)localObject5).getValue();
          y.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[] { localObject3, localObject5 });
          if (bool)
          {
            localObject6 = new dh();
            ((dh)localObject6).bJB.bJD = ((String)localObject3);
            ((dh)localObject6).bJB.bwK = ((String)localObject5);
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject6);
            if (((dh)localObject6).bJC.bJy) {}
          }
          else
          {
            try
            {
              localObject6 = new df();
              ((df)localObject6).bJu.bJx = false;
              ((df)localObject6).bJu.bJw = ((String)localObject3);
              ((df)localObject6).bJu.bwK = ((String)localObject5);
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject6);
              y.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
            }
            catch (Exception localException2)
            {
              y.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
              y.printErrStackTrace("MicroMsg.MsgHandler", localException2, "", new Object[0]);
            }
          }
        }
      }
      localg.rys.clear();
      break;
      if (localg.cdu() != 8) {
        break;
      }
      if ((localg.rys == null) || (localg.rys.isEmpty()))
      {
        y.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
        break;
      }
      localObject1 = localg.rys.entrySet().iterator();
      if (localObject1 != null) {
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (String)((Map.Entry)localObject5).getValue();
          y.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[] { str, localObject5 });
          localObject6 = new dh();
          ((dh)localObject6).bJB.bJD = str;
          ((dh)localObject6).bJB.bwK = ((String)localObject5);
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject6);
          if (!((dh)localObject6).bJC.bJy) {
            try
            {
              localObject6 = new df();
              ((df)localObject6).bJu.bJx = false;
              ((df)localObject6).bJu.bJw = str;
              ((df)localObject6).bJu.bwK = ((String)localObject5);
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject6);
              y.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
            }
            catch (Exception localException3)
            {
              y.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
              y.printErrStackTrace("MicroMsg.MsgHandler", localException3, "", new Object[0]);
            }
          }
        }
      }
      localg.rys.clear();
      break;
      label1325:
      if (!au.DK())
      {
        y.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
      }
      else
      {
        ((com.tencent.mm.plugin.webview.model.f)localObject5).rfm = com.tencent.mm.m.g.AA().getInt("MMUxAdLog2GSendSize", 20480);
        ((com.tencent.mm.plugin.webview.model.f)localObject5).rfn = com.tencent.mm.m.g.AA().getInt("MMUxAdLog3GSendSize", 30720);
        ((com.tencent.mm.plugin.webview.model.f)localObject5).rfo = com.tencent.mm.m.g.AA().getInt("MMUxAdLogWifiSendSize", 51200);
        y.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.webview.model.f)localObject5).rfm), Integer.valueOf(((com.tencent.mm.plugin.webview.model.f)localObject5).rfn), Integer.valueOf(((com.tencent.mm.plugin.webview.model.f)localObject5).rfo) });
        localObject1 = ((com.tencent.mm.plugin.webview.model.f)localObject5).rfp;
        if (bk.dk((List)localObject1)) {
          y.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
        }
        for (localObject1 = null;; localObject1 = localObject4)
        {
          if (!bk.dk((List)localObject1)) {
            break label2005;
          }
          y.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
          break;
          y.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
          y.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).setLength(0);
          ((StringBuilder)localObject6).append("{ ");
          localObject4 = ((List)localObject1).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((StringBuilder)localObject6).append(((asw)((Iterator)localObject4).next()).tou).append(", ");
          }
          ((StringBuilder)localObject6).append(" }");
          y.d("MicroMsg.WebView.JsLogHelper", ((StringBuilder)localObject6).toString());
          Object localObject7;
          int i;
          if ((bk.cp(((com.tencent.mm.plugin.webview.model.f)localObject5).rfr) < 100L) && (((com.tencent.mm.plugin.webview.model.f)localObject5).rfq > 0))
          {
            paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject5).rfq;
            localObject7 = new LinkedList();
            ((LinkedList)localObject7).addAll((Collection)localObject1);
            localObject4 = new LinkedList();
            localObject1 = null;
            i = 0;
          }
          for (;;)
          {
            if (((LinkedList)localObject7).size() <= 0) {
              break label1859;
            }
            asw localasw;
            if (i <= 0)
            {
              localObject1 = new LinkedList();
              localasw = (asw)((LinkedList)localObject7).remove();
              i += localasw.tov.oY.length;
              ((LinkedList)localObject1).add(localasw);
              ((List)localObject4).add(localObject1);
              continue;
              ((com.tencent.mm.plugin.webview.model.f)localObject5).rfr = SystemClock.elapsedRealtime();
              if (aq.isWifi(ae.getContext()))
              {
                paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject5).rfo;
                ((com.tencent.mm.plugin.webview.model.f)localObject5).rfq = paramInt;
                break;
              }
              if ((aq.is3G(ae.getContext())) || (aq.is4G(ae.getContext())))
              {
                paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject5).rfn;
                ((com.tencent.mm.plugin.webview.model.f)localObject5).rfq = paramInt;
                break;
              }
              aq.is2G(ae.getContext());
              paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject5).rfm;
              ((com.tencent.mm.plugin.webview.model.f)localObject5).rfq = paramInt;
              break;
            }
            if (((asw)((LinkedList)localObject7).peek()).tov.oY.length + i >= paramInt)
            {
              i = 0;
            }
            else
            {
              localasw = (asw)((LinkedList)localObject7).remove();
              i += localasw.tov.oY.length;
              ((LinkedList)localObject1).add(localasw);
            }
          }
          label1859:
          y.d("MicroMsg.WebView.JsLogHelper", "split result: ");
          localObject1 = ((List)localObject4).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject7 = (List)((Iterator)localObject1).next();
            ((StringBuilder)localObject6).setLength(0);
            ((StringBuilder)localObject6).append("{ ");
            localObject7 = ((List)localObject7).iterator();
            while (((Iterator)localObject7).hasNext()) {
              ((StringBuilder)localObject6).append(((asw)((Iterator)localObject7).next()).tou).append(", ");
            }
            ((StringBuilder)localObject6).append(" }");
            y.d("MicroMsg.WebView.JsLogHelper", ((StringBuilder)localObject6).toString());
            y.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
          }
          y.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        label2005:
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (List)((Iterator)localObject1).next();
          if (!bk.dk((List)localObject4))
          {
            y.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
            localObject4 = new t((List)localObject4);
            au.Dk().a((com.tencent.mm.ah.m)localObject4, 0);
          }
        }
        ((com.tencent.mm.plugin.webview.model.f)localObject5).rfp.clear();
      }
    }
    localg.ryW.clear();
    Object localObject1 = r.cot().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (r.a)((Iterator)localObject1).next();
      y.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + ((r.a)localObject4).getName());
      ((r.a)localObject4).cfi();
    }
    r.clear();
    com.tencent.mm.sdk.b.a.udP.d(localg.odj);
    com.tencent.mm.sdk.b.a.udP.d(localg.odk);
    com.tencent.mm.sdk.b.a.udP.d(localg.ryV);
    com.tencent.mm.sdk.b.a.udP.d(localg.rzh);
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(com.tencent.mm.storage.ac.a.uqZ, Boolean.valueOf(false));
    }
    localObject1 = ae.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("isNewScanning", false);
    ((SharedPreferences.Editor)localObject1).commit();
    localg.ryn = null;
    localg.ryU = null;
    localg.b(localg.rym, new int[0]);
    localg.ryy = null;
    localg.rzd.clear();
    localObject1 = q.a.ccy();
    Object localObject4 = localg.ryZ;
    if ((com.tencent.mm.compatible.e.w.zx() == 0) || (!au.DK()) || (bk.dk((List)localObject4))) {}
    for (;;)
    {
      q.a.ccy().Ch(localg.bVm);
      return;
      localObject4 = new q.5((com.tencent.mm.plugin.webview.modelcache.q)localObject1, (List)localObject4);
      ((com.tencent.mm.plugin.webview.modelcache.q)localObject1).DS().O((Runnable)localObject4);
    }
  }
  
  public final Bundle Cm(int paramInt)
  {
    return com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).cgi();
  }
  
  public final boolean Cn(int paramInt)
  {
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
    boolean bool = localg.dCs;
    int i;
    if (com.tencent.mm.protocal.d.spd)
    {
      i = 1;
      if (!bool) {
        break label58;
      }
      y.w("MicroMsg.WebViewStubService", "isBusy(%d), doingFunction = %s", new Object[] { Integer.valueOf(paramInt), localg.ryw });
    }
    label58:
    while ((i == 0) || (!localg.ryx))
    {
      return bool;
      i = 0;
      break;
    }
    y.i("MicroMsg.WebViewStubService", "isBusy(%d), awaiting proxyUI", new Object[] { Integer.valueOf(paramInt) });
    return true;
  }
  
  public final void Co(int paramInt)
  {
    y.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", new Object[] { Integer.valueOf(paramInt) });
    Iterator localIterator = WebViewStubService.h(this.rkg).iterator();
    while (localIterator.hasNext())
    {
      WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
      if (localWebViewStubCallbackWrapper.id == paramInt)
      {
        WebViewStubService.h(this.rkg).remove(localWebViewStubCallbackWrapper);
        return;
      }
    }
    WebViewStubService.g(this.rkg).remove(paramInt);
  }
  
  public final void Cp(int paramInt)
  {
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
    WebViewStubService localWebViewStubService = this.rkg;
    ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryu = false;
    Iterator localIterator = r.cot().iterator();
    while (localIterator.hasNext())
    {
      r.a locala = (r.a)localIterator.next();
      y.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + locala.getName());
      locala.eA(localWebViewStubService);
    }
    ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryB = false;
    if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryq != null)
    {
      localObject = ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryq.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        localObject = (SnsAdClick)localObject;
        if (((SnsAdClick)localObject).eAF > 0L)
        {
          ((SnsAdClick)localObject).eAG += bk.cp(((SnsAdClick)localObject).eAF);
          ((SnsAdClick)localObject).eAF = 0L;
        }
      }
    }
  }
  
  public final void Cq(int paramInt)
  {
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
    ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryu = true;
    Iterator localIterator = r.cot().iterator();
    while (localIterator.hasNext())
    {
      r.a locala = (r.a)localIterator.next();
      y.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + locala.getName());
      locala.cfj();
    }
    if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryq != null)
    {
      localObject = ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).ryq.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick))) {
        ((SnsAdClick)localObject).eAF = bk.UZ();
      }
    }
  }
  
  public final boolean GR()
  {
    return com.tencent.mm.model.q.GR();
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).cgi().putString(paramString1, paramString2);
  }
  
  public final List<String> Mm()
  {
    Object localObject = com.tencent.mm.ai.f.Mm();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.ai.f.la(str)) {
        localLinkedList.add(str);
      }
    }
    return localLinkedList;
  }
  
  public final boolean Mn()
  {
    return com.tencent.mm.ai.f.Mn();
  }
  
  public final b Q(Bundle paramBundle)
  {
    WebViewStubService.a locala = new WebViewStubService.a((byte)0);
    long l = paramBundle.getLong("msg_id", -9223372036854775808L);
    Object localObject1 = paramBundle.getString("sns_local_id");
    int i = paramBundle.getInt("news_svr_id", 0);
    Object localObject2 = paramBundle.getString("news_svr_tweetid");
    cj localcj = new cj();
    boolean bool;
    if (-9223372036854775808L != l)
    {
      localcj.bIw.bIA = paramBundle.getInt("message_index", 0);
      bool = com.tencent.mm.pluginsdk.model.e.a(localcj, l);
      if (!bool) {
        break label459;
      }
      String str = bk.pm(paramBundle.getString("prePublishId"));
      localObject1 = u.ij(str);
      localObject2 = u.Hc().v((String)localObject1, true);
      ((u.b)localObject2).h("sendAppMsgScene", Integer.valueOf(2));
      ((u.b)localObject2).h("preChatName", paramBundle.getString("preChatName"));
      ((u.b)localObject2).h("preMsgIndex", Integer.valueOf(paramBundle.getInt("preMsgIndex")));
      ((u.b)localObject2).h("prePublishId", str);
      ((u.b)localObject2).h("preUsername", paramBundle.getString("preUsername"));
      ((u.b)localObject2).h("getA8KeyScene", paramBundle.getString("getA8KeyScene"));
      ((u.b)localObject2).h("referUrl", paramBundle.getString("referUrl"));
      paramBundle = paramBundle.getBundle("jsapiargs");
      if (paramBundle != null) {
        ((u.b)localObject2).h("adExtStr", paramBundle.getString("key_snsad_statextstr"));
      }
      localcj.bIw.bIB = ((String)localObject1);
      com.tencent.mm.sdk.b.a.udP.m(localcj);
    }
    for (;;)
    {
      locala.ret = localcj.bIx.ret;
      return locala;
      if (!bk.bl((String)localObject1))
      {
        localObject2 = new ra();
        ((ra)localObject2).cak.can = ((String)localObject1);
        ((ra)localObject2).cak.cao = localcj;
        ((ra)localObject2).cak.url = paramBundle.getString("rawUrl");
        ((ra)localObject2).cak.cam = true;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        bool = ((ra)localObject2).cal.bIe;
        break;
      }
      if (i != 0)
      {
        localObject1 = new mr();
        ((mr)localObject1).bWk.opType = 3;
        ((mr)localObject1).bWk.bWm = localcj;
        ((mr)localObject1).bWk.bWn = i;
        ((mr)localObject1).bWk.bWo = ((String)localObject2);
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        bool = ((mr)localObject1).bWl.bIe;
        break;
      }
      locala.rbu = true;
      return locala;
      label459:
      if (localcj.bIw.bIC == 0) {
        localcj.bIw.bIC = R.l.favorite_fail_nonsupport;
      }
      com.tencent.mm.sdk.b.a.udP.m(localcj);
    }
  }
  
  public final boolean R(Bundle paramBundle)
  {
    ce localce = new ce();
    localce.bIp.bIr = paramBundle.getLong("fav_local_id", -1L);
    com.tencent.mm.sdk.b.a.udP.m(localce);
    y.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(localce.bIp.bIr), Boolean.valueOf(localce.bIq.bIe) });
    return localce.bIq.bIe;
  }
  
  public final String RR(String paramString)
  {
    return com.tencent.mm.plugin.webview.model.ao.RR(paramString);
  }
  
  public final String SL(String paramString)
  {
    return com.tencent.mm.ag.b.jZ(paramString);
  }
  
  public final String SM(String paramString)
  {
    if (o.a.rSF != null) {
      return o.a.rSF.q(this.rkg, paramString);
    }
    return null;
  }
  
  public final void SN(String paramString)
  {
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.by(paramString, false);
    if ((localObject != null) && (bk.bl(((com.tencent.mm.pluginsdk.model.app.f)localObject).field_openId)))
    {
      y.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = " + paramString);
      localObject = new he();
      ((he)localObject).bPb.appId = paramString;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final String SO(String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.g.by(paramString, false);
    if (paramString == null) {
      return null;
    }
    return paramString.field_packageName;
  }
  
  public final boolean SP(String paramString)
  {
    return com.tencent.mm.br.d.SP(paramString);
  }
  
  public final String SQ(String paramString)
  {
    boolean bool = au.DK();
    y.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = " + bool);
    if (!bool) {
      return (String)new WebViewStubService.1.4(this, paramString).b(WebViewStubService.f(this.rkg));
    }
    return com.tencent.mm.m.g.AA().getValue(paramString);
  }
  
  public final void SR(String paramString)
  {
    boolean bool = au.DK();
    y.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = " + bool);
    paramString = new WebViewStubService.1.5(this, paramString);
    if (!bool)
    {
      paramString.b(WebViewStubService.f(this.rkg));
      return;
    }
    paramString.b(null);
  }
  
  public final int SS(String paramString)
  {
    cj localcj = new cj();
    com.tencent.mm.pluginsdk.model.e.a(localcj, 1, paramString);
    com.tencent.mm.sdk.b.a.udP.m(localcj);
    return localcj.bIx.ret;
  }
  
  public final void ST(String paramString)
  {
    Object localObject1;
    if (o.Za(paramString))
    {
      localObject1 = com.tencent.mm.a.g.bQ(paramString);
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As((String)localObject1);
      if ((localObject1 != null) && (((EmojiInfo)localObject1).cwz())) {
        break label367;
      }
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Au(paramString);
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As((String)localObject1);
    }
    label106:
    label367:
    for (;;)
    {
      int i;
      Object localObject2;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject1 != null) {
          break label209;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        if (((com.tencent.mm.sdk.platformtools.c.decodeFile(paramString, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.Ag())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.Ag())) {
          break label362;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i > com.tencent.mm.m.b.Ah()) || (j != 0))
        {
          com.tencent.mm.ui.base.h.a(ae.getContext(), this.rkg.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", this.rkg.getString(R.l.i_know_it), null);
          return;
          i = com.tencent.mm.a.e.bJ(((EmojiInfo)localObject1).cwL());
          break;
          paramString = ((EmojiInfo)localObject1).cwL();
          break label106;
        }
        localObject2 = new Intent();
        if (localObject1 == null) {}
        for (paramString = "";; paramString = ((EmojiInfo)localObject1).Wv())
        {
          ((Intent)localObject2).putExtra("Retr_File_Name", paramString);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject2).putExtra("Retr_MsgImgScene", 1);
          ((Intent)localObject2).addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.eUR.l((Intent)localObject2, this.rkg);
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Retr_File_Name", paramString);
        ((Intent)localObject1).putExtra("Retr_Compress_Type", 0);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
        ((Intent)localObject1).addFlags(268435456);
        com.tencent.mm.plugin.webview.a.a.eUR.l((Intent)localObject1, this.rkg);
        return;
      }
    }
  }
  
  public final void SU(String paramString)
  {
    if ((WebViewStubService.i(this.rkg) == null) || (!WebViewStubService.i(this.rkg).containsKey(paramString)))
    {
      y.e("MicroMsg.WebViewStubService", "%s is not recognizing", new Object[] { paramString });
      return;
    }
    com.tencent.mm.h.a.am localam = new com.tencent.mm.h.a.am();
    localam.bGF.filePath = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localam);
    WebViewStubService.i(this.rkg).remove(paramString);
  }
  
  public final String SV(String paramString)
  {
    com.tencent.mm.pluginsdk.d.VD(paramString);
    return "";
  }
  
  @Deprecated
  public final void a(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    y.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WebViewStubService.f(this.rkg).post(new WebViewStubService.1.1(this, paramInt1, paramBundle, paramInt2));
  }
  
  public final void a(Bundle paramBundle, int paramInt)
  {
    WebViewStubService.g(this.rkg).put(paramInt, paramBundle);
  }
  
  public final void a(e parame, int paramInt)
  {
    y.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", new Object[] { Integer.valueOf(parame.hashCode()), Integer.valueOf(paramInt) });
    WebViewStubService.h(this.rkg).add(new WebViewStubCallbackWrapper(parame, paramInt));
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
  }
  
  public final void a(String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = new Bundle();
    JsapiPermissionWrapper localJsapiPermissionWrapper = new JsapiPermissionWrapper();
    localJsapiPermissionWrapper.fromBundle(paramBundle);
    localBundle.putParcelable("proxyui_perm_key", localJsapiPermissionWrapper);
    localBundle.putString("proxyui_username_key", paramString);
    localBundle.putInt("webview_binder_id", paramInt);
    WebViewStubService.a(this.rkg, 4, localBundle, paramInt);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (WebViewStubService.i(this.rkg) == null)
    {
      WebViewStubService.a(this.rkg, new HashMap());
      com.tencent.mm.sdk.b.a.udP.c(WebViewStubService.j(this.rkg));
    }
    Object localObject = u.Hc().v("basescanui@datacenter", true);
    ((u.b)localObject).h("key_basescanui_screen_x", Integer.valueOf(paramInt1));
    ((u.b)localObject).h("key_basescanui_screen_y", Integer.valueOf(paramInt2));
    localObject = new mz();
    ((mz)localObject).bWF.filePath = paramString;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      ((mz)localObject).bWF.bWG = new HashSet();
      paramInt2 = paramArrayOfInt.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int i = paramArrayOfInt[paramInt1];
        ((mz)localObject).bWF.bWG.add(Integer.valueOf(i));
        paramInt1 += 1;
      }
    }
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    WebViewStubService.i(this.rkg).put(paramString, Integer.valueOf(1));
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    boolean bool = WebViewStubService.SK(paramString2);
    y.i("MicroMsg.WebViewStubService", "handleMsg, function = " + paramString2 + ", doInActivity = " + bool);
    JsapiPermissionWrapper localJsapiPermissionWrapper = new JsapiPermissionWrapper();
    localJsapiPermissionWrapper.fromBundle(paramBundle1);
    if ("wcPrivacyPolicyResult".equals(paramString2))
    {
      paramBundle1 = (Bundle)WebViewStubService.g(this.rkg).get(paramInt);
      if ((paramBundle1 != null) && (paramBundle1.getBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", false))) {
        bool = false;
      }
    }
    for (;;)
    {
      if (bool)
      {
        if (WebViewStubService.a(this.rkg, paramString1, paramString2, paramString3, localJsapiPermissionWrapper, paramBundle2, paramInt)) {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).lv(true);
        }
        return true;
      }
      paramBundle1 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.i();
      paramBundle1.type = paramString1;
      paramBundle1.rAO = paramString2;
      paramBundle1.rAL = paramString3;
      paramBundle1.ndL = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.af(paramBundle2.getBundle("compatParams"));
      label336:
      for (;;)
      {
        try
        {
          paramBundle1.rAM = new JSONObject(paramBundle2.getString("rawParams"));
          paramString1 = null;
          paramString2 = WebViewStubService.h(this.rkg).iterator();
          if (paramString2.hasNext())
          {
            paramString3 = (WebViewStubCallbackWrapper)paramString2.next();
            if ((paramString3 == null) || (paramString3.id != paramInt)) {
              break label336;
            }
            paramString1 = paramString3.rno;
          }
        }
        catch (JSONException paramString1)
        {
          y.e("MicroMsg.WebViewStubService", "get rawParams, e = %s", new Object[] { paramString1 });
          continue;
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).cgh();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).a(this.rkg, paramString1);
          bool = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).a(paramBundle1, localJsapiPermissionWrapper);
          y.i("MicroMsg.WebViewStubService", "handleRet = " + bool);
          return bool;
        }
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    return p.a.rSH.a(this.rkg, paramString, paramBoolean, paramBundle);
  }
  
  public final String aY(int paramInt, String paramString)
  {
    au.Hx();
    return bk.aM((String)com.tencent.mm.model.c.Dz().get(paramInt, null), paramString);
  }
  
  public final void ab(int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("proxyui_expired_errtype", paramInt1);
    localBundle.putInt("proxyui_expired_errcode", paramInt2);
    WebViewStubService.a(this.rkg, 6, localBundle, paramInt3);
  }
  
  public final void ae(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.rkg, WebViewStubProxyUI.class);
    localIntent.putExtra("proxyui_action_code_key", 9);
    localIntent.putExtra("proxyui_next_intent_key", paramIntent);
    localIntent.setFlags(268435456);
    this.rkg.startActivity(localIntent);
  }
  
  public final void bn(String paramString, boolean paramBoolean)
  {
    p.a.rSH.a(this.rkg, paramString, paramBoolean);
  }
  
  public final void cP(String paramString, int paramInt)
  {
    new Bundle().putInt("webview_binder_id", paramInt);
    WebViewStubService.a(this.rkg, 5, null, paramInt);
  }
  
  public final String cQ(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return com.tencent.mm.plugin.webview.model.am.Sp(paramString);
    }
    return com.tencent.mm.plugin.webview.model.am.Sq(paramString);
  }
  
  public final void cR(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("proxyui_phone", paramString);
    WebViewStubService.a(this.rkg, 8, localBundle, paramInt);
  }
  
  public final boolean cdg()
  {
    return au.DK();
  }
  
  public final String[] cdh()
  {
    String str = com.tencent.mm.m.g.AB().H("WebViewConfig", "removeJavascriptInterface");
    if (bk.bl(str)) {
      return null;
    }
    return str.split(";");
  }
  
  public final String cdi()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(-1535680990, null);
  }
  
  public final String cdj()
  {
    return x.d(this.rkg.getSharedPreferences(ae.cqR(), 0));
  }
  
  public final String cdk()
  {
    hs localhs = new hs();
    com.tencent.mm.sdk.b.a.udP.m(localhs);
    return localhs.bPM.url;
  }
  
  public final Map cdl()
  {
    com.tencent.mm.m.d locald = com.tencent.mm.m.g.AB().Al();
    if (locald == null) {
      return null;
    }
    return locald.dAm;
  }
  
  public final int cdm()
  {
    com.tencent.mm.kernel.g.DN();
    return com.tencent.mm.kernel.a.CK();
  }
  
  public final int cdn()
  {
    au.Hx();
    return bk.g((Integer)com.tencent.mm.model.c.Dz().get(12304, null));
  }
  
  public final void cdo()
  {
    Intent localIntent = new Intent();
    au.Hx();
    String str = (String)com.tencent.mm.model.c.Dz().get(2, null);
    localIntent.setFlags(268435456);
    localIntent.putExtra("sns_userName", str);
    localIntent.addFlags(67108864);
    au.Hx();
    int i = bk.a((Integer)com.tencent.mm.model.c.Dz().get(68389, null), 0);
    au.Hx();
    com.tencent.mm.model.c.Dz().o(68389, Integer.valueOf(i + 1));
    localIntent.setClassName(ae.getContext(), "com.tencent.mm.plugin.sns.ui.SnsUserUI");
    this.rkg.startActivity(localIntent);
  }
  
  public final void cdp()
  {
    if ((com.tencent.mm.model.q.Gu() & 0x8000) == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (com.tencent.mm.br.d.SP("sns")))
      {
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.setClassName(ae.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
        localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
        this.rkg.startActivity(localIntent);
      }
      return;
    }
  }
  
  public final boolean cdq()
  {
    return com.tencent.mm.model.q.Gw();
  }
  
  public final boolean cdr()
  {
    return oX("EnableWebviewScanQRCode") == 1;
  }
  
  public final boolean cds()
  {
    return (!au.Hz()) || (au.CW());
  }
  
  public final List<String> cdt()
  {
    if (com.tencent.mm.kernel.g.DK()) {
      com.tencent.mm.plugin.webview.modeltools.g.ccF();
    }
    for (k localk = com.tencent.mm.plugin.webview.modeltools.g.ccM();; localk = null)
    {
      if (localk == null) {
        return new ArrayList();
      }
      return new ArrayList(localk.ccR());
    }
  }
  
  public final int cdu()
  {
    return com.tencent.mm.pluginsdk.wallet.i.cdu();
  }
  
  public final boolean cdv()
  {
    return oX("WebViewDownLoadFileSwitch") == 1;
  }
  
  public final String[] cdw()
  {
    String str = com.tencent.mm.m.g.AB().H("AsyncCheckUrl", "UrlHost");
    if (!bk.bl(str)) {
      return str.split(";");
    }
    return null;
  }
  
  public final boolean cz(String paramString)
  {
    return o.a.rSF.cz(paramString);
  }
  
  public final int eH(int paramInt1, int paramInt2)
  {
    au.Hx();
    return bk.a((Integer)com.tencent.mm.model.c.Dz().get(paramInt1, null), paramInt2);
  }
  
  public final void eI(int paramInt1, int paramInt2)
  {
    WebViewStubService.f(this.rkg).post(new WebViewStubService.1.3(this, paramInt1, paramInt2));
  }
  
  public final Bundle f(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = new Bundle();
    long l1;
    boolean bool;
    label596:
    int i;
    label1300:
    Object localObject2;
    Object localObject4;
    Object localObject5;
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.WebViewStubService", "unknown action = %d", new Object[] { Integer.valueOf(paramInt) });
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 4006: 
    case 19: 
    case 75: 
    case 51: 
    case 23: 
    case 24: 
    case 26: 
    case 31: 
    case 50: 
    case 76: 
    case 71: 
    case 93: 
    case 94: 
    case 100: 
    case 10001: 
    case 80: 
    case 83: 
    case 78: 
    case 91: 
    case 92: 
      for (;;)
      {
        return localObject3;
        if (paramBundle == null) {
          return null;
        }
        Object localObject1 = bk.pm(paramBundle.getString("task_url"));
        paramBundle = paramBundle.getString("task_name");
        y.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", new Object[] { localObject1, paramBundle });
        if (bk.bl((String)localObject1))
        {
          y.e("MicroMsg.WebViewStubService", "download url is null or nil");
          return null;
        }
        localObject3 = new e.a();
        ((e.a)localObject3).zN((String)localObject1);
        ((e.a)localObject3).zP(paramBundle);
        ((e.a)localObject3).eO(true);
        ((e.a)localObject3).pE(1);
        paramBundle = ((e.a)localObject3).iPG;
        l1 = com.tencent.mm.plugin.downloader.model.d.aFP().a(paramBundle);
        y.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", new Object[] { Long.valueOf(l1) });
        paramBundle = new Bundle();
        paramBundle.putLong("download_id", l1);
        return paramBundle;
        l1 = paramBundle.getLong("download_id", 0L);
        paramBundle = com.tencent.mm.plugin.downloader.model.d.aFP().dd(l1);
        if (paramBundle == null)
        {
          bool = true;
          if (paramBundle != null) {
            break label596;
          }
        }
        for (paramInt = 0;; paramInt = paramBundle.status)
        {
          y.i("MicroMsg.WebViewStubService", "query download task info, info == null ? %b task state = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
          paramInt = 0;
          if (paramBundle != null) {
            paramInt = paramBundle.status;
          }
          y.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt) });
          paramBundle = new Bundle();
          paramBundle.putInt("download_state", paramInt);
          return paramBundle;
          bool = false;
          break;
        }
        l1 = paramBundle.getLong("download_id", 0L);
        paramInt = com.tencent.mm.plugin.downloader.model.d.aFP().dc(l1);
        y.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt) });
        paramBundle = new Bundle();
        if (paramInt > 0) {}
        for (bool = true;; bool = false)
        {
          paramBundle.putBoolean("cancel_result", bool);
          return paramBundle;
        }
        l1 = paramBundle.getLong("download_id");
        localObject1 = com.tencent.mm.plugin.downloader.model.d.aFP().dd(l1);
        paramBundle = new Bundle();
        if (localObject1 == null)
        {
          y.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
          paramBundle.putBoolean("install_result", false);
          return paramBundle;
        }
        if (((FileDownloadTaskInfo)localObject1).status != 3)
        {
          y.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + ((FileDownloadTaskInfo)localObject1).status);
          paramBundle.putBoolean("install_result", false);
          return paramBundle;
        }
        if (com.tencent.mm.a.e.bK(((FileDownloadTaskInfo)localObject1).path))
        {
          localObject1 = Uri.fromFile(new File(((FileDownloadTaskInfo)localObject1).path));
          paramBundle.putBoolean("install_result", com.tencent.mm.pluginsdk.model.app.q.g(this.rkg, (Uri)localObject1));
          return paramBundle;
        }
        y.e("MicroMsg.WebViewStubService", "file not exists : %s", new Object[] { ((FileDownloadTaskInfo)localObject1).path });
        paramBundle.putBoolean("install_result", false);
        return paramBundle;
        paramBundle = new Bundle();
        localObject1 = ae.cqT().getString("nfc_open_url", null);
        y.i("MicroMsg.WebViewStubService", "nfc url=" + bk.pm((String)localObject1));
        if ((!bk.bl((String)localObject1)) && (!bk.bl(((String)localObject1).trim()))) {
          paramBundle.putString("debugConfig", (String)localObject1);
        }
        au.Hx();
        paramBundle.putString("config", String.valueOf(com.tencent.mm.model.c.Dz().get(com.tencent.mm.storage.ac.a.upK, null)));
        return paramBundle;
        paramBundle = new Bundle();
        paramBundle.putBoolean("webview_video_proxy_init", al.cbY().hasInit);
        return paramBundle;
        paramBundle = al.cbY();
        if (paramBundle.hasInit)
        {
          paramBundle.rgh = null;
          al.rgg = null;
          paramBundle.hasInit = false;
        }
        return null;
        try
        {
          if (Looper.myLooper() == null) {
            Looper.prepare();
          }
          com.tencent.mm.modelgeo.c.Ob().b(new WebViewStubService.1.6(this));
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.WebViewStubService", paramBundle, "", new Object[0]);
          }
        }
        return null;
        bool = au.DK();
        paramBundle = new WebViewStubService.1.7(this);
        if (!bool) {}
        for (paramBundle = (String)paramBundle.b(WebViewStubService.f(this.rkg));; paramBundle = (String)paramBundle.b(null))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("config_info_username", paramBundle);
          return localObject1;
        }
        localObject3 = new Bundle();
        paramBundle = null;
        try
        {
          localObject1 = com.tencent.mm.model.c.c.IX().fJ(com.tencent.mm.plugin.webview.modeltools.c.rhR);
          paramBundle = (Bundle)localObject1;
        }
        catch (AssertionFailedError localAssertionFailedError)
        {
          for (;;)
          {
            y.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
          }
        }
        catch (com.tencent.mm.model.b localb)
        {
          for (;;)
          {
            y.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
          }
          paramBundle = paramBundle.ctr();
          l1 = bk.getLong((String)paramBundle.get("interval"), 0L);
          long l2 = bk.UX();
          au.Hx();
          long l3 = bk.c((Long)com.tencent.mm.model.c.Dz().get(com.tencent.mm.storage.ac.a.uqU, null));
          y.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1) });
          if (l3 < l2) {
            break label1300;
          }
          y.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
          return localObject3;
          au.Hx();
          com.tencent.mm.model.c.Dz().c(com.tencent.mm.storage.ac.a.uqU, Long.valueOf(l1 + l2));
          i = bk.getInt((String)paramBundle.get("urlCount"), 0);
          localObject2 = new ArrayList(i);
          paramInt = 0;
          while (paramInt < i)
          {
            ((ArrayList)localObject2).add(paramBundle.get(String.format("url%d", new Object[] { Integer.valueOf(paramInt) })));
            paramInt += 1;
          }
          ((Bundle)localObject3).putStringArrayList("cookies_cleanup_url_list", (ArrayList)localObject2);
          return localObject3;
        }
        if ((paramBundle == null) || (!paramBundle.isValid()))
        {
          y.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", new Object[] { paramBundle });
          return localObject3;
        }
        paramBundle = new Bundle(1);
        paramBundle.putBoolean("webview_resource_cache_inWhiteList", false);
        return paramBundle;
        if (!au.DK()) {
          return null;
        }
        paramBundle = com.tencent.mm.model.c.c.IX().fJ("100036");
        if (!paramBundle.isValid())
        {
          y.d("MicroMsg.WebViewStubService", "test is valid");
          return null;
        }
        paramBundle = paramBundle.ctr();
        localObject2 = new Bundle();
        paramInt = bk.getInt((String)paramBundle.get("controlFlag"), 0);
        ((Bundle)localObject2).putInt("webview_ad_intercept_control_flag", paramInt);
        if (paramInt == 0)
        {
          y.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
          return localObject2;
        }
        i = bk.getInt((String)paramBundle.get("blackListCount"), 0);
        localObject3 = new ArrayList();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject4 = (String)paramBundle.get("blackList" + (paramInt + 1));
          if ((!bk.bl((String)localObject4)) && (!((ArrayList)localObject3).contains(localObject4)))
          {
            y.i("MicroMsg.WebViewStubService", "add black list domin = %s", new Object[] { localObject4 });
            ((ArrayList)localObject3).add(localObject4);
          }
          paramInt += 1;
        }
        i = bk.getInt((String)paramBundle.get("whiteListCount"), 0);
        localObject4 = new ArrayList();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject5 = (String)paramBundle.get("whiteList" + (paramInt + 1));
          if ((!bk.bl((String)localObject5)) && (!((ArrayList)localObject4).contains(localObject5)))
          {
            y.i("MicroMsg.WebViewStubService", "add white list domin = %s", new Object[] { localObject5 });
            ((ArrayList)localObject4).add(localObject5);
          }
          paramInt += 1;
        }
        ((Bundle)localObject2).putStringArrayList("webview_ad_intercept_blacklist_domins", (ArrayList)localObject3);
        ((Bundle)localObject2).putStringArrayList("webview_ad_intercept_whitelist_domins", (ArrayList)localObject4);
        return localObject2;
        if (paramBundle == null) {
          return null;
        }
        paramBundle = paramBundle.getString("data");
        if (paramBundle == null) {
          return null;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("key_biz_type", com.tencent.mm.ai.f.kX(paramBundle).field_type);
        return localObject2;
        if (paramBundle == null) {
          return Bundle.EMPTY;
        }
        localObject2 = new Bundle();
        paramInt = paramBundle.getInt("webview_binder_id");
        paramBundle = bk.pm(paramBundle.getString("rawUrl"));
        ((Bundle)localObject2).putString("appId", com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).sj(paramBundle));
        return localObject2;
        if (paramBundle == null) {
          return null;
        }
        localObject2 = paramBundle.getString("enterprise_action");
        paramBundle = new Bundle();
        if (((String)localObject2).equals("enterprise_has_connector"))
        {
          com.tencent.mm.ai.z.My();
          if (com.tencent.mm.ai.e.Mf().size() > 0)
          {
            bool = true;
            paramBundle.putBoolean("enterprise_has_connector", bool);
          }
        }
        for (;;)
        {
          return paramBundle;
          bool = false;
          break;
          if (((String)localObject2).equals("enterprise_connectors"))
          {
            com.tencent.mm.ai.z.My();
            localObject2 = com.tencent.mm.ai.e.Mf();
            if (localObject2 != null) {
              paramBundle.putStringArrayList("enterprise_connectors", new ArrayList((Collection)localObject2));
            }
          }
        }
        paramBundle = new Bundle();
        paramBundle.putBoolean("is_oauth_native", false);
        if (!com.tencent.mm.kernel.g.DN().Dc())
        {
          y.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
          return paramBundle;
        }
        if (!com.tencent.mm.kernel.g.DQ().dKP.dLj)
        {
          y.i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
          return paramBundle;
        }
        localObject2 = com.tencent.mm.model.c.c.IX().fJ("100272");
        if (!((com.tencent.mm.storage.c)localObject2).isValid())
        {
          y.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
          return paramBundle;
        }
        localObject2 = ((com.tencent.mm.storage.c)localObject2).ctr();
        if (localObject2 == null)
        {
          y.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
          return paramBundle;
        }
        if ((((Map)localObject2).containsKey("isUseNative")) && ("1".equals(((Map)localObject2).get("isUseNative"))))
        {
          paramBundle.putBoolean("is_oauth_native", true);
          return paramBundle;
        }
        y.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
        return paramBundle;
        return com.tencent.mm.plugin.webview.model.ac.a.cbQ();
        paramBundle = com.tencent.mm.m.g.AB().H("WebViewConfig", "mediaEnableAutoPlayHostPaths");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("enable_auto_play_host_paths", paramBundle);
        return localObject2;
        paramBundle = new StringBuilder("kwid_");
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.modelappbrand.b.dZM = com.tencent.mm.kernel.a.CK() + "_" + bk.UY();
        y.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", new Object[] { com.tencent.mm.modelappbrand.b.dZM });
        continue;
        if (paramBundle == null) {
          return null;
        }
        localObject2 = paramBundle.getString("KAppId");
        localObject4 = paramBundle.getString("shortcut_user_name");
        paramInt = paramBundle.getInt("webviewui_binder_id");
        if ((bk.bl((String)localObject2)) || (bk.bl((String)localObject4))) {
          return null;
        }
        WebViewStubService.a(this.rkg, 10, paramBundle, paramInt);
        continue;
        WebViewStubService.a(this.rkg, paramBundle.getInt("screen_orientation", -1));
        continue;
        ((Bundle)localObject3).putBoolean("isOpenForFaceBook", com.tencent.mm.model.q.GI());
        continue;
        if (paramBundle == null) {
          return null;
        }
        paramInt = paramBundle.getInt("game_sourceScene");
        paramBundle = new gq();
        paramBundle.bOu.actionCode = 5;
        paramBundle.bOu.scene = paramInt;
        com.tencent.mm.sdk.b.a.udP.m(paramBundle);
        continue;
        if (paramBundle == null) {
          return null;
        }
        paramBundle = paramBundle.getString("game_hv_menu_appid");
        if (bk.bl(paramBundle)) {
          return null;
        }
        localObject2 = new gr();
        ((gr)localObject2).bOv.uC = 3;
        ((gr)localObject2).bOv.bOx = paramBundle;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        ((Bundle)localObject3).putString("game_hv_menu_pbcache", ((gr)localObject2).bOw.result);
      }
    case 129: 
      paramInt = paramBundle.getInt("webview_instance_id");
      localObject2 = null;
      localObject4 = WebViewStubService.h(this.rkg).iterator();
      label2491:
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (WebViewStubCallbackWrapper)((Iterator)localObject4).next();
        if ((localObject5 == null) || (((WebViewStubCallbackWrapper)localObject5).id != paramInt)) {
          break label3487;
        }
        localObject2 = ((WebViewStubCallbackWrapper)localObject5).rno;
      }
      break;
    }
    label3462:
    label3481:
    label3487:
    for (;;)
    {
      for (;;)
      {
        break label2491;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt).a(this.rkg, (e)localObject2);
        localObject2 = new HashMap();
        ((Map)localObject2).put("scene", Integer.valueOf(paramBundle.getInt("scene")));
        ((Map)localObject2).put("webview_instance_id", Integer.valueOf(paramInt));
        com.tencent.mm.plugin.webview.modeltools.g.ccI().ab((Map)localObject2);
        break;
        localObject4 = new HashMap();
        ((Map)localObject4).put("logString", paramBundle.getString("logString"));
        localObject5 = com.tencent.mm.plugin.webview.modeltools.g.ccI();
        localObject2 = aa.s((Map)localObject4, "logString");
        HashMap localHashMap = new HashMap();
        if (!((String)localObject2).contains("h5version=")) {
          localHashMap.put("h5version", Integer.valueOf(aa.Bs(0)));
        }
        paramBundle = (Bundle)localObject2;
        if (localHashMap.keySet().size() > 0) {
          if (((String)localObject2).length() <= 0) {
            break label2766;
          }
        }
        label2766:
        for (paramBundle = (String)localObject2 + "&" + aa.T(localHashMap);; paramBundle = aa.T(localHashMap))
        {
          ((Map)localObject4).put("logString", paramBundle);
          ((com.tencent.mm.plugin.webview.fts.b)localObject5).ad((Map)localObject4);
          break;
        }
        paramBundle = com.tencent.mm.model.c.c.IX().fJ("100248");
        if (!paramBundle.isValid())
        {
          y.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
          return null;
        }
        if (bk.getInt((String)paramBundle.ctr().get("isForceSync"), 0) != 1) {
          break;
        }
        paramBundle = com.tencent.mm.m.g.AB().H("WebViewConfig", "forceSyncA8KeyHostPath");
        y.d("MicroMsg.ConfigListDecoder", "host list = %s", new Object[] { paramBundle });
        ((Bundle)localObject3).putString("force_geta8key_host_path", paramBundle);
        break;
        if (paramBundle == null) {
          return null;
        }
        localObject4 = paramBundle.keySet();
        if (localObject4 == null) {
          return null;
        }
        localObject2 = new JSONObject();
        try
        {
          localObject4 = ((Set)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            ((JSONObject)localObject2).put((String)localObject5, paramBundle.get((String)localObject5));
          }
          paramBundle = new gr();
        }
        catch (JSONException paramBundle)
        {
          return null;
        }
        paramBundle.bOv.uC = 4;
        paramBundle.bOv.bOx = ((JSONObject)localObject2).toString();
        com.tencent.mm.sdk.b.a.udP.m(paramBundle);
        break;
        if (paramBundle == null) {
          return null;
        }
        if (paramBundle == null) {
          break;
        }
        try
        {
          com.tencent.mm.sdk.f.e.post(new b.1(paramBundle), "web_call_rpt");
        }
        catch (Exception paramBundle)
        {
          y.printErrStackTrace("MicroMsg.WebViewStubService", paramBundle, "webview call back mm error", new Object[0]);
        }
      }
      break;
      if (paramBundle == null) {
        return null;
      }
      l1 = paramBundle.getLong("key_activity_browse_time", 0L);
      com.tencent.mm.modelstat.f.Rs().s(WebViewUI.class.getName(), l1);
      break;
      paramBundle = com.tencent.mm.model.c.c.IX().fJ("100376");
      if (!paramBundle.isValid())
      {
        y.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
        return null;
      }
      if ("true".equals(paramBundle.ctr().get("enabled"))) {
        return new Bundle();
      }
      return null;
      if (paramBundle == null) {
        return null;
      }
      ((Bundle)localObject3).putBoolean("is_enterprise_username", com.tencent.mm.ai.f.la(paramBundle.getString("enterprise_biz_username")));
      break;
      return n.a.X(paramBundle);
      localObject2 = new Bundle();
      com.tencent.mm.plugin.webview.modeltools.f.SG(paramBundle.getString("query"));
      ((Bundle)localObject2).putBoolean("open_result", false);
      return localObject2;
      if (paramBundle == null) {
        return new Bundle();
      }
      paramInt = paramBundle.getInt("WebViewShare_BinderID");
      i = paramBundle.getInt("WebViewShare_type");
      localObject2 = new Bundle();
      localObject3 = paramBundle.getString("WebViewShare_wv_url", "");
      paramBundle = null;
      if (i == 1)
      {
        paramBundle = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
        localObject4 = paramBundle.ryE;
        if ((((j)localObject4).riP.containsKey(localObject3)) && (((j)localObject4).riP.get(localObject3) != null))
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label3362;
          }
          paramBundle = null;
          if (paramBundle == null) {
            break label3381;
          }
          bool = true;
          ((Bundle)localObject2).putBoolean("WebViewShare_reslut", bool);
        }
      }
      label3362:
      label3381:
      while (i != 2) {
        for (;;)
        {
          if (paramBundle != null)
          {
            ((Bundle)localObject2).putString("link", paramBundle.eAl);
            ((Bundle)localObject2).putString("title", paramBundle.title);
            ((Bundle)localObject2).putString("desc", paramBundle.desc);
            ((Bundle)localObject2).putString("img_url", paramBundle.oOp);
          }
          return localObject2;
          paramInt = 0;
          continue;
          paramBundle = (j.a)paramBundle.ryE.riP.get(localObject3);
          continue;
          bool = false;
        }
      }
      paramBundle = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
      localObject4 = paramBundle.ryE;
      if ((((j)localObject4).riQ.containsKey(localObject3)) && (((j)localObject4).riQ.get(localObject3) != null))
      {
        paramInt = 1;
        label3431:
        if (paramInt != 0) {
          break label3462;
        }
        paramBundle = null;
        label3437:
        if (paramBundle == null) {
          break label3481;
        }
      }
      for (bool = true;; bool = false)
      {
        ((Bundle)localObject2).putBoolean("WebViewShare_reslut", bool);
        break;
        paramInt = 0;
        break label3431;
        paramBundle = (j.a)paramBundle.ryE.riQ.get(localObject3);
        break label3437;
      }
    }
  }
  
  public final void favEditTag()
  {
    gf localgf = new gf();
    localgf.bNF.type = 35;
    com.tencent.mm.sdk.b.a.udP.m(localgf);
  }
  
  public final String fz(String paramString1, String paramString2)
  {
    return "";
  }
  
  public final String gV(String paramString)
  {
    au.Hx();
    return com.tencent.mm.model.c.Fw().abl(paramString).Bp();
  }
  
  public final String getLanguage()
  {
    return x.fB(ae.getContext());
  }
  
  public final void h(int paramInt, List<String> paramList)
  {
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    com.tencent.mm.plugin.report.service.h.f(paramInt, paramList);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramString1 == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(ae.getContext(), WebviewScanImageActivity.class);
    localIntent.setFlags(872415232);
    localIntent.putExtra("key_string_for_scan", paramString1);
    localIntent.putExtra("key_string_for_url", paramString2);
    localIntent.putExtra("key_string_for_image_url", paramString3);
    localIntent.putExtra("key_codetype_for_scan", paramInt1);
    localIntent.putExtra("key_codeversion_for_scan", paramInt2);
    ae.getContext().startActivity(localIntent);
  }
  
  public final void h(String paramString, boolean paramBoolean, int paramInt)
  {
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramInt);
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", new Object[] { paramString });
      localg.dCs = false;
      localg.ryp.add(paramString);
      if (paramBoolean) {
        localg.ryo.add(paramString);
      }
    }
  }
  
  public final boolean hU(String paramString)
  {
    return com.tencent.mm.model.s.hU(paramString);
  }
  
  public final boolean hk(String paramString)
  {
    return com.tencent.mm.model.s.hk(paramString);
  }
  
  public final boolean hl(String paramString)
  {
    boolean bool = au.DK();
    y.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = " + bool);
    if (!bool) {
      return false;
    }
    return com.tencent.mm.model.s.hl(paramString);
  }
  
  public final void i(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = com.tencent.mm.plugin.webview.modeltools.g.ccI();
    switch (paramInt)
    {
    case 2: 
    case 4: 
    default: 
      return;
    case 1: 
      int i = paramBundle.getInt("webview_id");
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).qYR.remove(Integer.valueOf(i));
      paramBundle = ((com.tencent.mm.plugin.webview.fts.b)localObject1).qYX;
      if (!paramBundle.qZs)
      {
        paramInt = 1;
        if ((paramInt == 0) || (bk.bl(paramBundle.bVk))) {
          break label211;
        }
        y.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", new Object[] { Boolean.valueOf(paramBundle.qZs), paramBundle.bVk, Boolean.valueOf(paramBundle.bGq), Boolean.valueOf(paramBundle.pDz), Integer.valueOf(paramBundle.kxU) });
        com.tencent.mm.plugin.websearch.api.ao.a(paramBundle.scene, paramBundle.bVk, paramBundle.pDz, paramBundle.bGq, paramBundle.kxU);
        paramBundle.qZs = true;
      }
      for (;;)
      {
        y.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", new Object[] { Integer.valueOf(i) });
        return;
        paramInt = 0;
        break;
        y.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", new Object[] { paramBundle.bVk });
      }
    case 3: 
      if (((com.tencent.mm.plugin.webview.fts.b)localObject1).kxg != null) {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(((com.tencent.mm.plugin.webview.fts.b)localObject1).kxg);
      }
      Object localObject2 = new com.tencent.mm.plugin.fts.a.a.i();
      ((com.tencent.mm.plugin.fts.a.a.i)localObject2).bVk = paramBundle.getString("query");
      ((com.tencent.mm.plugin.fts.a.a.i)localObject2).kxc = paramBundle.getInt("count");
      ((com.tencent.mm.plugin.fts.a.a.i)localObject2).kxf = ((com.tencent.mm.plugin.webview.fts.b)localObject1).mVF;
      ((com.tencent.mm.plugin.fts.a.a.i)localObject2).kxd.add("notifymessage");
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).kxg = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).search(8, (com.tencent.mm.plugin.fts.a.a.i)localObject2);
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).kxg.kwb = Integer.valueOf(paramBundle.getInt("webview_id"));
      localObject2 = new com.tencent.mm.plugin.websearch.api.s();
      ((com.tencent.mm.plugin.websearch.api.s)localObject2).scene = paramBundle.getInt("scene");
      ((com.tencent.mm.plugin.websearch.api.s)localObject2).bGm = paramBundle.getString("query");
      ((com.tencent.mm.plugin.websearch.api.s)localObject2).qTw = 1;
      ((com.tencent.mm.plugin.websearch.api.s)localObject2).bVm = paramBundle.getInt("webview_id");
      if (((com.tencent.mm.plugin.webview.fts.b)localObject1).qYU != null) {
        au.Dk().c(((com.tencent.mm.plugin.webview.fts.b)localObject1).qYU);
      }
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).qYU = new com.tencent.mm.plugin.webview.fts.e((com.tencent.mm.plugin.websearch.api.s)localObject2);
      au.Dk().a(1161, (com.tencent.mm.ah.f)localObject1);
      au.Dk().a(((com.tencent.mm.plugin.webview.fts.b)localObject1).qYU, 0);
      return;
    case 5: 
      label211:
      paramBundle = paramBundle.getString("history");
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory(paramBundle);
      return;
    }
    paramBundle = paramBundle.getString("reportString");
    y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramBundle });
    localObject1 = new blf();
    ((blf)localObject1).tEQ = paramBundle;
    paramBundle = new com.tencent.mm.plugin.websearch.api.w((blf)localObject1);
    com.tencent.mm.kernel.g.Dk().a(paramBundle, 0);
  }
  
  public final boolean isSDCardAvailable()
  {
    au.Hx();
    return com.tencent.mm.model.c.isSDCardAvailable();
  }
  
  public final Bundle o(int paramInt, Bundle paramBundle)
  {
    com.tencent.mm.plugin.webview.modeltools.g.ccI();
    return com.tencent.mm.plugin.webview.fts.b.o(paramInt, paramBundle);
  }
  
  public final void q(int paramInt, Bundle paramBundle)
  {
    com.tencent.mm.plugin.webview.c.a locala = com.tencent.mm.plugin.webview.modeltools.g.ccG();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.get(str));
    }
    switch (paramInt)
    {
    default: 
      y.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    locala.W(localHashMap);
  }
  
  public final boolean r(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewStubService", "doScene, type = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", new Object[] { Integer.valueOf(paramInt) });
    }
    do
    {
      return false;
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
      Object localObject = paramBundle.getString("geta8key_data_req_url");
      if (!bk.bl(paramBundle.getString("k_share_url"))) {
        com.tencent.mm.plugin.webview.model.ao.fv((String)localObject, paramBundle.getString("k_share_url"));
      }
      if (!bk.bl((String)localObject)) {}
      for (localObject = new com.tencent.mm.modelsimple.h((String)localObject, paramBundle.getString("geta8key_data_username"), paramBundle.getInt("geta8key_data_scene"), paramBundle.getInt("geta8key_data_reason"), paramBundle.getInt("geta8key_data_flag"), paramBundle.getString("geta8key_data_net_type"), paramBundle.getInt("geta8key_session_id", 0), paramBundle.getString("geta8key_data_appid"), paramBundle.getString("key_function_id"), paramBundle.getInt("key_wallet_region", 0), paramBundle.getByteArray("k_a8key_cookie"));; localObject = new com.tencent.mm.modelsimple.h(paramBundle.getString("geta8key_data_appid"), paramBundle.getString("geta8key_data_scope"), paramBundle.getString("geta8key_data_state"), paramBundle.getInt("geta8key_session_id", 0)))
      {
        ((com.tencent.mm.modelsimple.h)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
        return au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      }
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
      localObject = new com.tencent.mm.plugin.webview.model.n(paramBundle.getString("reading_mode_data_url"), paramBundle.getString("reading_mode_data_useragent"), paramBundle.getInt("reading_mode_data_width"), paramBundle.getInt("reading_mode_data_height"));
      ((com.tencent.mm.plugin.webview.model.n)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
      return au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
      return WebViewStubService.P(paramBundle);
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
      localObject = new v(paramBundle.getString("oauth_url"), paramBundle.getString("biz_username"), paramBundle.getInt("scene"));
      ((v)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
      return au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
      localObject = paramBundle.getString("oauth_url");
      int i = paramBundle.getInt("opt");
      LinkedList localLinkedList = new LinkedList(paramBundle.getStringArrayList("scopes"));
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        localStringBuilder.append((String)localLinkedList.get(paramInt)).append(",");
        paramInt += 1;
      }
      y.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
      localObject = new com.tencent.mm.plugin.webview.model.w((String)localObject, i, localLinkedList);
      ((com.tencent.mm.plugin.webview.model.w)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
      return au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
      return WebViewStubService.a(this.rkg, paramBundle);
      if (!cdg())
      {
        y.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        return false;
      }
    } while (paramBundle == null);
    paramBundle = paramBundle.getString("ad_report_data_str");
    y.d("MicroMsg.WebViewReportUtil", "doReportCgi : %s", new Object[] { paramBundle });
    ((com.tencent.mm.plugin.sns.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sns.b.a.class)).g(13791, paramBundle, (int)bk.UX());
    return true;
  }
  
  public final boolean x(long paramLong, String paramString)
  {
    if ((paramLong == -9223372036854775808L) && (paramString == null)) {
      return false;
    }
    Object localObject = new do();
    if (paramLong != -9223372036854775808L) {
      ((do)localObject).bJZ.bIt = paramLong;
    }
    if (paramString != null) {
      ((do)localObject).bJZ.bJQ = paramString;
    }
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (((do)localObject).bKa.bJy) {
      return true;
    }
    if ((au.DK()) && (paramLong != -9223372036854775808L))
    {
      au.Hx();
      paramString = com.tencent.mm.model.c.Fy().fd(paramLong);
      if (paramString.getType() == 49)
      {
        boolean bool = com.tencent.mm.model.s.fn(paramString.field_talker);
        localObject = paramString.field_content;
        int i = paramString.field_isSend;
        paramString = (String)localObject;
        if (bool)
        {
          paramString = (String)localObject;
          if (localObject != null)
          {
            paramString = (String)localObject;
            if (i == 0) {
              paramString = com.tencent.mm.model.bd.iJ((String)localObject);
            }
          }
        }
        paramString = g.a.gp(paramString);
        if (paramString.type == 3) {
          return com.tencent.mm.pluginsdk.model.app.g.m(ae.getContext(), 16L);
        }
        if (paramString.type == 4) {
          return com.tencent.mm.pluginsdk.model.app.g.m(ae.getContext(), 8L);
        }
      }
    }
    return false;
  }
  
  public final void z(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = WebViewJSSDKFileItem.y(paramInt, paramString1, paramString2);
    paramString1.fNe = false;
    com.tencent.mm.plugin.webview.modeltools.g.ccL().b(paramString1);
    com.tencent.mm.plugin.webview.modeltools.g.ccK().b(null, paramString1.bMB, null);
  }
  
  public final boolean zF()
  {
    return com.tencent.mm.compatible.util.f.zF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1
 * JD-Core Version:    0.7.0.1
 */