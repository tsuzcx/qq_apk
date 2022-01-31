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
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.a;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.hw.a;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.nn.b;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nw.a;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelstat.a.c.1;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.webview.f.c.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.a.b;
import com.tencent.mm.plugin.webview.model.ah.a;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.f.a;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.model.y;
import com.tencent.mm.plugin.webview.modeltools.l;
import com.tencent.mm.plugin.webview.modeltools.l.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.bag.n.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.89;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.pluginsdk.ui.tools.t.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
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
  
  private static int wp(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(7178);
    try
    {
      int j = bo.getInt(com.tencent.mm.m.g.Nq().getValue(paramString), 1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(7178);
    return i;
  }
  
  public final void I(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(7184);
    paramString1 = WebViewJSSDKFileItem.H(paramInt, paramString1, paramString2);
    paramString1.hgo = false;
    com.tencent.mm.plugin.webview.modeltools.g.dcE().a(paramString1);
    com.tencent.mm.plugin.webview.modeltools.g.dcD().b(null, paramString1.ctV, null);
    AppMethodBeat.o(7184);
  }
  
  public final Bundle Kf(int paramInt)
  {
    AppMethodBeat.i(7139);
    Bundle localBundle = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).dgw();
    AppMethodBeat.o(7139);
    return localBundle;
  }
  
  public final boolean Kg(int paramInt)
  {
    AppMethodBeat.i(7140);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
    boolean bool = localg.ezJ;
    int i;
    if (com.tencent.mm.protocal.d.whK)
    {
      i = 1;
      if (!bool) {
        break label69;
      }
      ab.w("MicroMsg.WebViewStubService", "isBusy(%d), doingFunction = %s", new Object[] { Integer.valueOf(paramInt), localg.vpx });
    }
    label69:
    while ((i == 0) || (!localg.vpy))
    {
      AppMethodBeat.o(7140);
      return bool;
      i = 0;
      break;
    }
    ab.i("MicroMsg.WebViewStubService", "isBusy(%d), awaiting proxyUI", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(7140);
    return true;
  }
  
  public final void Kh(int paramInt)
  {
    AppMethodBeat.i(7149);
    ab.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", new Object[] { Integer.valueOf(paramInt) });
    Iterator localIterator = WebViewStubService.f(this.uZy).iterator();
    while (localIterator.hasNext())
    {
      WebViewStubCallbackWrapper localWebViewStubCallbackWrapper = (WebViewStubCallbackWrapper)localIterator.next();
      if (localWebViewStubCallbackWrapper.id == paramInt)
      {
        WebViewStubService.f(this.uZy).remove(localWebViewStubCallbackWrapper);
        AppMethodBeat.o(7149);
        return;
      }
    }
    WebViewStubService.h(this.uZy).remove(paramInt);
    AppMethodBeat.o(7149);
  }
  
  public final void Ki(int paramInt)
  {
    AppMethodBeat.i(7170);
    if (WebViewStubService.f(this.uZy).size() == 0)
    {
      localObject1 = new fr();
      ((fr)localObject1).ctT.ctW = 2;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new fl();
      ((fl)localObject1).ctw.op = 2;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new fo();
      ((fo)localObject1).ctE.op = 2;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
    ab.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
    localg.vpw = true;
    if (localg.dgD())
    {
      localObject1 = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh(localg.vpZ);
      if (localObject1 != null) {
        com.tencent.mm.sdk.platformtools.al.d(new g.89(localg, (WebViewJSSDKFileItem)localObject1));
      }
    }
    Object localObject4;
    if (((localg.ddp() != 8) && (localg.ddp() != -1)) || (localg.getScene() == 27)) {
      if (((localg.vpu == null) || (localg.vpu.isEmpty())) && ((localg.vpt == null) || (localg.vpt.isEmpty())))
      {
        ab.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
        if (localg.vpv != null) {
          ao.a.flI.pl(localg.vpv);
        }
        localObject4 = f.a.dbJ();
        if (!bo.es(((com.tencent.mm.plugin.webview.model.f)localObject4).uVr)) {
          break label1407;
        }
        ab.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
      }
    }
    label1407:
    Object localObject3;
    for (;;)
    {
      if (localg.vpr != null) {
        localg.vpr.setClassLoader(localg.getClass().getClassLoader());
      }
      if (localg.vpr != null)
      {
        localObject1 = localg.vpr.getParcelable("KSnsAdTag");
        if ((localObject1 != null) && ((localObject1 instanceof SnsAdClick)))
        {
          localObject2 = (SnsAdClick)localObject1;
          localObject1 = new os();
          ((os)localObject1).cFp.cFq = 1;
          ((os)localObject1).cFp.cFb = ((SnsAdClick)localObject2);
          localObject2 = localg.vpr.getString("KAnsUxInfo", "");
          ((os)localObject1).cFp.cFe = ((String)localObject2);
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      localObject1 = "";
      if (localg.vpr != null)
      {
        localg.vpr.setClassLoader(localg.getClass().getClassLoader());
        localObject1 = localg.vpr.getString("KoriginUrl");
      }
      Object localObject2 = new we();
      ((we)localObject2).cNv.cfG = ((String)localObject1);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      if (localg.vpr != null)
      {
        localObject1 = com.tencent.mm.modelsns.b.s(localg.vpr);
        if (localObject1 != null)
        {
          ((com.tencent.mm.modelsns.b)localObject1).update();
          ((com.tencent.mm.modelsns.b)localObject1).ake();
        }
      }
      localObject1 = localg.vpY.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!bo.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.webview.modeltools.g.dcD();
          com.tencent.mm.plugin.webview.model.al.zE((String)localObject2);
          localObject2 = (g.b)localg.vpY.get(localObject2);
          if (localObject2 != null)
          {
            if (((g.b)localObject2).vrJ != null) {
              com.tencent.mm.plugin.webview.modeltools.g.dcD().a(((g.b)localObject2).vrJ);
            }
            if (((g.b)localObject2).vpn != null) {
              localg.a(((g.b)localObject2).vpn, "uploadVideo:cancel", null, false);
            }
          }
        }
      }
      Object localObject5;
      if ((localg.vpu != null) && (!localg.vpu.isEmpty()))
      {
        localObject1 = localg.vpu.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          ab.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", new Object[] { localObject2, localObject4 });
          try
          {
            localObject5 = new dj();
            ((dj)localObject5).cqT.cqR = false;
            ((dj)localObject5).cqT.cqQ = ((String)localObject2);
            ((dj)localObject5).cqT.bYu = ((String)localObject4);
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject5);
            ab.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
          }
          catch (Exception localException1)
          {
            ab.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
            ab.printErrStackTrace("MicroMsg.MsgHandler", localException1, "", new Object[0]);
          }
        }
        localg.vpu.clear();
      }
      if ((localg.vpt == null) || (localg.vpt.isEmpty())) {
        break;
      }
      localObject1 = localg.vpt.entrySet().iterator();
      boolean bool = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Lr(localg.dgC());
      ab.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[] { Boolean.valueOf(bool) });
      if (localObject1 != null) {
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject1).next();
          String str1 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          ab.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[] { str1, localObject4 });
          if (bool)
          {
            localObject5 = new dk();
            ((dk)localObject5).cqV.cqX = str1;
            ((dk)localObject5).cqV.bYu = ((String)localObject4);
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject5);
            if (((dk)localObject5).cqW.cqS) {}
          }
          else
          {
            try
            {
              localObject5 = new di();
              ((di)localObject5).cqO.cqR = false;
              ((di)localObject5).cqO.cqQ = str1;
              ((di)localObject5).cqO.bYu = ((String)localObject4);
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject5);
              ab.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
            }
            catch (Exception localException2)
            {
              ab.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
              ab.printErrStackTrace("MicroMsg.MsgHandler", localException2, "", new Object[0]);
            }
          }
        }
      }
      localg.vpt.clear();
      break;
      if (localg.ddp() != 8) {
        break;
      }
      if ((localg.vpt == null) || (localg.vpt.isEmpty()))
      {
        ab.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
        break;
      }
      localObject1 = localg.vpt.entrySet().iterator();
      if (localObject1 != null) {
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject1).next();
          String str2 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          ab.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[] { str2, localObject4 });
          localObject5 = new dk();
          ((dk)localObject5).cqV.cqX = str2;
          ((dk)localObject5).cqV.bYu = ((String)localObject4);
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject5);
          if (!((dk)localObject5).cqW.cqS) {
            try
            {
              localObject5 = new di();
              ((di)localObject5).cqO.cqR = false;
              ((di)localObject5).cqO.cqQ = str2;
              ((di)localObject5).cqO.bYu = ((String)localObject4);
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject5);
              ab.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
            }
            catch (Exception localException3)
            {
              ab.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
              ab.printErrStackTrace("MicroMsg.MsgHandler", localException3, "", new Object[0]);
            }
          }
        }
      }
      localg.vpt.clear();
      break;
      if (!com.tencent.mm.kernel.g.RG())
      {
        ab.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
      }
      else
      {
        ((com.tencent.mm.plugin.webview.model.f)localObject4).uVo = com.tencent.mm.m.g.Nq().getInt("MMUxAdLog2GSendSize", 20480);
        ((com.tencent.mm.plugin.webview.model.f)localObject4).uVp = com.tencent.mm.m.g.Nq().getInt("MMUxAdLog3GSendSize", 30720);
        ((com.tencent.mm.plugin.webview.model.f)localObject4).uVq = com.tencent.mm.m.g.Nq().getInt("MMUxAdLogWifiSendSize", 51200);
        ab.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.webview.model.f)localObject4).uVo), Integer.valueOf(((com.tencent.mm.plugin.webview.model.f)localObject4).uVp), Integer.valueOf(((com.tencent.mm.plugin.webview.model.f)localObject4).uVq) });
        localObject1 = ((com.tencent.mm.plugin.webview.model.f)localObject4).uVr;
        if (bo.es((List)localObject1)) {
          ab.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
        }
        for (localObject1 = null;; localObject1 = localObject3)
        {
          if (!bo.es((List)localObject1)) {
            break label2098;
          }
          ab.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
          break;
          ab.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
          ab.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).setLength(0);
          ((StringBuilder)localObject5).append("{ ");
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((StringBuilder)localObject5).append(((ayx)((Iterator)localObject3).next()).xoo).append(", ");
          }
          ((StringBuilder)localObject5).append(" }");
          ab.d("MicroMsg.WebView.JsLogHelper", ((StringBuilder)localObject5).toString());
          Object localObject6;
          int i;
          if ((bo.av(((com.tencent.mm.plugin.webview.model.f)localObject4).uVt) < 100L) && (((com.tencent.mm.plugin.webview.model.f)localObject4).uVs > 0))
          {
            paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject4).uVs;
            localObject6 = new LinkedList();
            ((LinkedList)localObject6).addAll((Collection)localObject1);
            localObject3 = new LinkedList();
            localObject1 = null;
            i = 0;
          }
          for (;;)
          {
            if (((LinkedList)localObject6).size() <= 0) {
              break label1948;
            }
            ayx localayx;
            if (i <= 0)
            {
              localObject1 = new LinkedList();
              localayx = (ayx)((LinkedList)localObject6).remove();
              i += localayx.xop.pW.length;
              ((LinkedList)localObject1).add(localayx);
              ((List)localObject3).add(localObject1);
              continue;
              ((com.tencent.mm.plugin.webview.model.f)localObject4).uVt = SystemClock.elapsedRealtime();
              if (com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext()))
              {
                paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject4).uVq;
                ((com.tencent.mm.plugin.webview.model.f)localObject4).uVs = paramInt;
                break;
              }
              if ((com.tencent.mm.sdk.platformtools.at.is3G(ah.getContext())) || (com.tencent.mm.sdk.platformtools.at.is4G(ah.getContext())))
              {
                paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject4).uVp;
                ((com.tencent.mm.plugin.webview.model.f)localObject4).uVs = paramInt;
                break;
              }
              com.tencent.mm.sdk.platformtools.at.is2G(ah.getContext());
              paramInt = ((com.tencent.mm.plugin.webview.model.f)localObject4).uVo;
              ((com.tencent.mm.plugin.webview.model.f)localObject4).uVs = paramInt;
              break;
            }
            if (((ayx)((LinkedList)localObject6).peek()).xop.pW.length + i >= paramInt)
            {
              i = 0;
            }
            else
            {
              localayx = (ayx)((LinkedList)localObject6).remove();
              i += localayx.xop.pW.length;
              ((LinkedList)localObject1).add(localayx);
            }
          }
          label1948:
          ab.d("MicroMsg.WebView.JsLogHelper", "split result: ");
          localObject1 = ((List)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject6 = (List)((Iterator)localObject1).next();
            ((StringBuilder)localObject5).setLength(0);
            ((StringBuilder)localObject5).append("{ ");
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext()) {
              ((StringBuilder)localObject5).append(((ayx)((Iterator)localObject6).next()).xoo).append(", ");
            }
            ((StringBuilder)localObject5).append(" }");
            ab.d("MicroMsg.WebView.JsLogHelper", ((StringBuilder)localObject5).toString());
            ab.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
          }
          ab.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        label2098:
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (List)((Iterator)localObject1).next();
          if (!bo.es((List)localObject3))
          {
            ab.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
            localObject3 = new w((List)localObject3);
            com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject3, 0);
          }
        }
        ((com.tencent.mm.plugin.webview.model.f)localObject4).uVr.clear();
      }
    }
    localg.vpY.clear();
    Object localObject1 = com.tencent.mm.pluginsdk.ui.tools.t.dpK().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (t.a)((Iterator)localObject1).next();
      ab.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + ((t.a)localObject3).getName());
      ((t.a)localObject3).dfr();
    }
    com.tencent.mm.pluginsdk.ui.tools.t.clear();
    com.tencent.mm.sdk.b.a.ymk.d(localg.qRp);
    com.tencent.mm.sdk.b.a.ymk.d(localg.qRq);
    com.tencent.mm.sdk.b.a.ymk.d(localg.vpX);
    com.tencent.mm.sdk.b.a.ymk.d(localg.vqj);
    if (localg.vqa != null) {
      com.tencent.mm.sdk.b.a.ymk.d(localg.vqa);
    }
    if (localg.hxo != null) {
      com.tencent.mm.sdk.b.a.ymk.d(localg.hxo);
    }
    if (localg.vqh != null) {
      localg.vqh.dead();
    }
    if (com.tencent.mm.kernel.g.RG()) {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yBa, Boolean.FALSE);
    }
    localObject1 = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("isNewScanning", false);
    ((SharedPreferences.Editor)localObject1).commit();
    localg.vpo = null;
    localg.vpW = null;
    localg.b(localg.vpn, new int[0]);
    localg.vpz = null;
    localg.vqe.clear();
    localObject1 = localg.vpB;
    com.tencent.mm.kernel.g.Rc().b(1093, (com.tencent.mm.ai.f)localObject1);
    AppMethodBeat.o(7170);
  }
  
  public final void Kj(int paramInt)
  {
    AppMethodBeat.i(7179);
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
    WebViewStubService localWebViewStubService = this.uZy;
    ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpw = false;
    Iterator localIterator = com.tencent.mm.pluginsdk.ui.tools.t.dpK().iterator();
    while (localIterator.hasNext())
    {
      t.a locala = (t.a)localIterator.next();
      ab.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + locala.getName());
      locala.fz(localWebViewStubService);
    }
    ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpC = false;
    if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpr != null)
    {
      localObject = ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpr.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        localObject = (SnsAdClick)localObject;
        if (((SnsAdClick)localObject).fQx > 0L)
        {
          ((SnsAdClick)localObject).fQy += bo.av(((SnsAdClick)localObject).fQx);
          ((SnsAdClick)localObject).fQx = 0L;
        }
      }
    }
    AppMethodBeat.o(7179);
  }
  
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(7180);
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
    ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpw = true;
    Iterator localIterator = com.tencent.mm.pluginsdk.ui.tools.t.dpK().iterator();
    while (localIterator.hasNext())
    {
      t.a locala = (t.a)localIterator.next();
      ab.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + locala.getName());
      locala.dfs();
    }
    if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpr != null)
    {
      localObject = ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject).vpr.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick))) {
        ((SnsAdClick)localObject).fQx = bo.yB();
      }
    }
    AppMethodBeat.o(7180);
  }
  
  public final boolean Mi()
  {
    AppMethodBeat.i(7120);
    boolean bool = com.tencent.mm.compatible.util.f.Mi();
    AppMethodBeat.o(7120);
    return bool;
  }
  
  public final void Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(7141);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).dgw().putString(paramString1, paramString2);
    AppMethodBeat.o(7141);
  }
  
  public final boolean ZT()
  {
    AppMethodBeat.i(7137);
    boolean bool = com.tencent.mm.model.r.ZT();
    AppMethodBeat.o(7137);
    return bool;
  }
  
  @Deprecated
  public final void a(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    AppMethodBeat.i(7122);
    ab.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WebViewStubService.g(this.uZy).post(new WebViewStubService.1.1(this, paramInt1, paramBundle, paramInt2));
    AppMethodBeat.o(7122);
  }
  
  public final void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(7186);
    WebViewStubService.h(this.uZy).put(paramInt, paramBundle);
    AppMethodBeat.o(7186);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(7150);
    ab.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", new Object[] { Integer.valueOf(parame.hashCode()), Integer.valueOf(paramInt) });
    WebViewStubService.f(this.uZy).add(new WebViewStubCallbackWrapper(parame, paramInt));
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
    AppMethodBeat.o(7150);
  }
  
  public final void a(String paramString, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(7143);
    Bundle localBundle = new Bundle();
    JsapiPermissionWrapper localJsapiPermissionWrapper = new JsapiPermissionWrapper();
    localJsapiPermissionWrapper.fromBundle(paramBundle);
    localBundle.putParcelable("proxyui_perm_key", localJsapiPermissionWrapper);
    localBundle.putString("proxyui_username_key", paramString);
    localBundle.putInt("webview_binder_id", paramInt);
    WebViewStubService.a(this.uZy, 4, localBundle, paramInt);
    AppMethodBeat.o(7143);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(7175);
    if (paramString1 == null)
    {
      AppMethodBeat.o(7175);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(ah.getContext(), WebviewScanImageActivity.class);
    localIntent.setFlags(872415232);
    localIntent.putExtra("key_string_for_scan", paramString1);
    localIntent.putExtra("key_string_for_url", paramString2);
    localIntent.putExtra("key_string_for_image_url", paramString3);
    localIntent.putExtra("key_codetype_for_scan", paramInt1);
    localIntent.putExtra("key_codeversion_for_scan", paramInt2);
    if (paramBundle != null)
    {
      paramString1 = paramBundle.getString("preUsername");
      paramString3 = paramBundle.getString("preChatName");
      paramBundle = paramBundle.getString("rawUrl");
      String str = v.oQ("WebviewQrCode");
      v.b localb = v.aae().z(str, true);
      localb.i("preUsername", paramString1);
      localb.i("preChatName", paramString3);
      localb.i("url", paramString2);
      localb.i("rawUrl", paramBundle);
      localIntent.putExtra("img_gallery_session_id", str);
    }
    ah.getContext().startActivity(localIntent);
    AppMethodBeat.o(7175);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7173);
    if (WebViewStubService.i(this.uZy) == null)
    {
      WebViewStubService.a(this.uZy, new HashMap());
      com.tencent.mm.sdk.b.a.ymk.c(WebViewStubService.j(this.uZy));
      com.tencent.mm.sdk.b.a.ymk.c(WebViewStubService.k(this.uZy));
    }
    Object localObject = v.aae().z("basescanui@datacenter", true);
    ((v.b)localObject).i("key_basescanui_screen_x", Integer.valueOf(paramInt1));
    ((v.b)localObject).i("key_basescanui_screen_y", Integer.valueOf(paramInt2));
    localObject = new nw();
    ((nw)localObject).cEv.filePath = paramString;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      ((nw)localObject).cEv.cEw = new HashSet();
      paramInt2 = paramArrayOfInt.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int i = paramArrayOfInt[paramInt1];
        ((nw)localObject).cEv.cEw.add(Integer.valueOf(i));
        paramInt1 += 1;
      }
    }
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    WebViewStubService.i(this.uZy).put(paramString, Integer.valueOf(1));
    AppMethodBeat.o(7173);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    AppMethodBeat.i(7142);
    boolean bool = WebViewStubService.ahM(paramString2);
    ab.i("MicroMsg.WebViewStubService", "handleMsg, function = " + paramString2 + ", doInActivity = " + bool);
    JsapiPermissionWrapper localJsapiPermissionWrapper = new JsapiPermissionWrapper();
    localJsapiPermissionWrapper.fromBundle(paramBundle1);
    if ("wcPrivacyPolicyResult".equals(paramString2))
    {
      paramBundle1 = (Bundle)WebViewStubService.h(this.uZy).get(paramInt);
      if ((paramBundle1 != null) && (paramBundle1.getBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", false))) {
        bool = false;
      }
    }
    for (;;)
    {
      if (bool)
      {
        if (WebViewStubService.a(this.uZy, paramString1, paramString2, paramString3, localJsapiPermissionWrapper, paramBundle2, paramInt)) {
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).oF(true);
        }
        AppMethodBeat.o(7142);
        return true;
      }
      paramBundle1 = new i();
      paramBundle1.type = paramString1;
      paramBundle1.vrQ = paramString2;
      paramBundle1.vrN = paramString3;
      paramBundle1.pJb = i.az(paramBundle2.getBundle("compatParams"));
      label357:
      for (;;)
      {
        try
        {
          paramString1 = paramBundle2.getString("rawParams");
          if (!TextUtils.isEmpty(paramString1)) {
            paramBundle1.vrO = new JSONObject(paramString1);
          }
          paramString1 = null;
          paramString2 = WebViewStubService.f(this.uZy).iterator();
          if (paramString2.hasNext())
          {
            paramString3 = (WebViewStubCallbackWrapper)paramString2.next();
            if ((paramString3 == null) || (paramString3.id != paramInt)) {
              break label357;
            }
            paramString1 = paramString3.vdZ;
          }
        }
        catch (JSONException paramString1)
        {
          ab.e("MicroMsg.WebViewStubService", "get rawParams, e = %s", new Object[] { paramString1 });
          continue;
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).dgv();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).a(this.uZy, paramString1, paramString1);
          bool = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).a(paramBundle1, localJsapiPermissionWrapper);
          ab.i("MicroMsg.WebViewStubService", "handleRet = ".concat(String.valueOf(bool)));
          AppMethodBeat.o(7142);
          return bool;
        }
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(7133);
    paramBoolean = r.a.vJD.a(this.uZy, paramString, paramBoolean, paramBundle);
    AppMethodBeat.o(7133);
    return paramBoolean;
  }
  
  public final void aA(Intent paramIntent)
  {
    AppMethodBeat.i(7183);
    Intent localIntent = new Intent(this.uZy, WebViewStubProxyUI.class);
    localIntent.putExtra("proxyui_action_code_key", 9);
    localIntent.putExtra("proxyui_next_intent_key", paramIntent);
    localIntent.setFlags(268435456);
    this.uZy.startActivity(localIntent);
    AppMethodBeat.o(7183);
  }
  
  public final List<String> aeT()
  {
    AppMethodBeat.i(7131);
    Object localObject = com.tencent.mm.aj.f.aeT();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.aj.f.rV(str)) {
        localLinkedList.add(str);
      }
    }
    AppMethodBeat.o(7131);
    return localLinkedList;
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(7130);
    boolean bool = com.tencent.mm.aj.f.aeU();
    AppMethodBeat.o(7130);
    return bool;
  }
  
  public final String agU(String paramString)
  {
    AppMethodBeat.i(7154);
    paramString = com.tencent.mm.plugin.webview.model.at.agU(paramString);
    AppMethodBeat.o(7154);
    return paramString;
  }
  
  public final String ahN(String paramString)
  {
    AppMethodBeat.i(7124);
    paramString = com.tencent.mm.ah.b.qS(paramString);
    AppMethodBeat.o(7124);
    return paramString;
  }
  
  public final String ahO(String paramString)
  {
    AppMethodBeat.i(7134);
    paramString = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.q.class)).x(this.uZy, paramString);
    AppMethodBeat.o(7134);
    return paramString;
  }
  
  public final void ahP(String paramString)
  {
    AppMethodBeat.i(7144);
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, false);
    if ((localObject != null) && (bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.f)localObject).field_openId)))
    {
      ab.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = ".concat(String.valueOf(paramString)));
      localObject = new hi();
      ((hi)localObject).cwu.appId = paramString;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    AppMethodBeat.o(7144);
  }
  
  public final String ahQ(String paramString)
  {
    AppMethodBeat.i(7145);
    paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, false);
    if (paramString == null)
    {
      AppMethodBeat.o(7145);
      return null;
    }
    paramString = paramString.field_packageName;
    AppMethodBeat.o(7145);
    return paramString;
  }
  
  public final boolean ahR(String paramString)
  {
    AppMethodBeat.i(7148);
    boolean bool = com.tencent.mm.bq.d.ahR(paramString);
    AppMethodBeat.o(7148);
    return bool;
  }
  
  public final String ahS(String paramString)
  {
    AppMethodBeat.i(7156);
    boolean bool = com.tencent.mm.kernel.g.RG();
    ab.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      paramString = (String)new WebViewStubService.1.4(this, paramString).b(WebViewStubService.g(this.uZy));
      AppMethodBeat.o(7156);
      return paramString;
    }
    paramString = com.tencent.mm.m.g.Nq().getValue(paramString);
    AppMethodBeat.o(7156);
    return paramString;
  }
  
  public final void ahT(String paramString)
  {
    AppMethodBeat.i(7157);
    boolean bool = com.tencent.mm.kernel.g.RG();
    ab.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = ".concat(String.valueOf(bool)));
    paramString = new WebViewStubService.1.5(this, paramString);
    if (!bool)
    {
      paramString.b(WebViewStubService.g(this.uZy));
      AppMethodBeat.o(7157);
      return;
    }
    paramString.b(null);
    AppMethodBeat.o(7157);
  }
  
  public final int ahU(String paramString)
  {
    AppMethodBeat.i(7159);
    cm localcm = new cm();
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ad.class)).a(localcm, 1, paramString);
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    int i = localcm.cpS.ret;
    AppMethodBeat.o(7159);
    return i;
  }
  
  public final void ahV(String paramString)
  {
    AppMethodBeat.i(7162);
    Object localObject1;
    if (com.tencent.mm.sdk.platformtools.r.aoY(paramString))
    {
      localObject1 = com.tencent.mm.a.g.getMD5(paramString);
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt((String)localObject1);
      if ((localObject1 != null) && (((EmojiInfo)localObject1).dzn())) {
        break label399;
      }
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
      ah.getContext();
      localObject1 = ((com.tencent.mm.pluginsdk.a.d)localObject1).Kv(paramString);
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt((String)localObject1);
    }
    label394:
    label399:
    for (;;)
    {
      int i;
      label120:
      Object localObject2;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject1 != null) {
          break label229;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        if (((com.tencent.mm.sdk.platformtools.d.decodeFile(paramString, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.m.b.MV())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.m.b.MV())) {
          break label394;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i > com.tencent.mm.m.b.MW()) || (j != 0))
        {
          com.tencent.mm.ui.base.h.a(ah.getContext(), this.uZy.getString(2131299130), "", this.uZy.getString(2131300718), null);
          AppMethodBeat.o(7162);
          return;
          i = com.tencent.mm.a.e.cM(((EmojiInfo)localObject1).dQB());
          break;
          label229:
          paramString = ((EmojiInfo)localObject1).dQB();
          break label120;
        }
        localObject2 = new Intent();
        if (localObject1 == null) {}
        for (paramString = "";; paramString = ((EmojiInfo)localObject1).Al())
        {
          ((Intent)localObject2).putExtra("Retr_File_Name", paramString);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject2).putExtra("Retr_MsgImgScene", 1);
          ((Intent)localObject2).addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.gmO.k((Intent)localObject2, this.uZy);
          AppMethodBeat.o(7162);
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Retr_File_Name", paramString);
        ((Intent)localObject1).putExtra("Retr_Compress_Type", 0);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
        ((Intent)localObject1).addFlags(268435456);
        com.tencent.mm.plugin.webview.a.a.gmO.k((Intent)localObject1, this.uZy);
        AppMethodBeat.o(7162);
        return;
      }
    }
  }
  
  public final void ahW(String paramString)
  {
    AppMethodBeat.i(7174);
    if ((WebViewStubService.i(this.uZy) == null) || (!WebViewStubService.i(this.uZy).containsKey(paramString)))
    {
      ab.e("MicroMsg.WebViewStubService", "%s is not recognizing", new Object[] { paramString });
      AppMethodBeat.o(7174);
      return;
    }
    ao localao = new ao();
    localao.cnS.filePath = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localao);
    WebViewStubService.i(this.uZy).remove(paramString);
    com.tencent.mm.a.e.deleteFile(paramString);
    AppMethodBeat.o(7174);
  }
  
  public final String ahX(String paramString)
  {
    AppMethodBeat.i(7176);
    com.tencent.mm.pluginsdk.e.akZ(paramString);
    AppMethodBeat.o(7176);
    return "";
  }
  
  public final b ai(Bundle paramBundle)
  {
    AppMethodBeat.i(7123);
    WebViewStubService.a locala = new WebViewStubService.a((byte)0);
    long l = paramBundle.getLong("msg_id", -9223372036854775808L);
    Object localObject1 = paramBundle.getString("sns_local_id");
    int i = paramBundle.getInt("news_svr_id", 0);
    Object localObject2 = paramBundle.getString("news_svr_tweetid");
    cm localcm = new cm();
    boolean bool;
    if (-9223372036854775808L != l)
    {
      localcm.cpR.cpV = paramBundle.getInt("message_index", 0);
      bool = ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ad.class)).a(localcm, l);
      if (!bool) {
        break label488;
      }
      String str = bo.nullAsNil(paramBundle.getString("prePublishId"));
      localObject1 = v.oQ(str);
      localObject2 = v.aae().z((String)localObject1, true);
      ((v.b)localObject2).i("sendAppMsgScene", Integer.valueOf(2));
      ((v.b)localObject2).i("preChatName", paramBundle.getString("preChatName"));
      ((v.b)localObject2).i("preMsgIndex", Integer.valueOf(paramBundle.getInt("preMsgIndex")));
      ((v.b)localObject2).i("prePublishId", str);
      ((v.b)localObject2).i("preUsername", paramBundle.getString("preUsername"));
      ((v.b)localObject2).i("getA8KeyScene", paramBundle.getString("getA8KeyScene"));
      ((v.b)localObject2).i("referUrl", paramBundle.getString("referUrl"));
      paramBundle = paramBundle.getBundle("jsapiargs");
      if (paramBundle != null) {
        ((v.b)localObject2).i("adExtStr", paramBundle.getString("key_snsad_statextstr"));
      }
      localcm.cpR.cpW = ((String)localObject1);
      com.tencent.mm.sdk.b.a.ymk.l(localcm);
    }
    for (;;)
    {
      locala.ret = localcm.cpS.ret;
      AppMethodBeat.o(7123);
      return locala;
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject2 = new sm();
        ((sm)localObject2).cIK.cIN = ((String)localObject1);
        ((sm)localObject2).cIK.cIO = localcm;
        ((sm)localObject2).cIK.url = paramBundle.getString("rawUrl");
        ((sm)localObject2).cIK.cIM = true;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        bool = ((sm)localObject2).cIL.cpz;
        break;
      }
      if (i != 0)
      {
        localObject1 = new nn();
        ((nn)localObject1).cDX.opType = 3;
        ((nn)localObject1).cDX.cDZ = localcm;
        ((nn)localObject1).cDX.cEa = i;
        ((nn)localObject1).cDX.cEb = ((String)localObject2);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        bool = ((nn)localObject1).cDY.cpz;
        break;
      }
      locala.uRc = true;
      AppMethodBeat.o(7123);
      return locala;
      label488:
      if (localcm.cpR.cpX == 0) {
        localcm.cpR.cpX = 2131299721;
      }
      com.tencent.mm.sdk.b.a.ymk.l(localcm);
    }
  }
  
  public final boolean aj(Bundle paramBundle)
  {
    AppMethodBeat.i(7152);
    ch localch = new ch();
    localch.cpK.cpM = paramBundle.getLong("fav_local_id", -1L);
    com.tencent.mm.sdk.b.a.ymk.l(localch);
    ab.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", new Object[] { Long.valueOf(localch.cpK.cpM), Boolean.valueOf(localch.cpL.cpz) });
    boolean bool = localch.cpL.cpz;
    AppMethodBeat.o(7152);
    return bool;
  }
  
  public final void an(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(7147);
    Bundle localBundle = new Bundle();
    localBundle.putInt("proxyui_expired_errtype", paramInt1);
    localBundle.putInt("proxyui_expired_errcode", paramInt2);
    WebViewStubService.a(this.uZy, 6, localBundle, paramInt3);
    AppMethodBeat.o(7147);
  }
  
  public final String bF(int paramInt, String paramString)
  {
    AppMethodBeat.i(7128);
    paramString = bo.bf((String)com.tencent.mm.kernel.g.RL().Ru().get(paramInt, null), paramString);
    AppMethodBeat.o(7128);
    return paramString;
  }
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7136);
    r.a.vJD.a(this.uZy, paramString, paramBoolean);
    AppMethodBeat.o(7136);
  }
  
  public final boolean dM(String paramString)
  {
    AppMethodBeat.i(7146);
    boolean bool = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.q.class)).dM(paramString);
    AppMethodBeat.o(7146);
    return bool;
  }
  
  public final void dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(7135);
    new Bundle().putInt("webview_binder_id", paramInt);
    WebViewStubService.a(this.uZy, 5, null, paramInt);
    AppMethodBeat.o(7135);
  }
  
  public final String dP(String paramString, int paramInt)
  {
    AppMethodBeat.i(7158);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(7158);
      return null;
    case 1: 
      paramString = ar.aho(paramString);
      AppMethodBeat.o(7158);
      return paramString;
    }
    paramString = ar.ahp(paramString);
    AppMethodBeat.o(7158);
    return paramString;
  }
  
  public final void dQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(7171);
    Bundle localBundle = new Bundle();
    localBundle.putString("proxyui_phone", paramString);
    WebViewStubService.a(this.uZy, 8, localBundle, paramInt);
    AppMethodBeat.o(7171);
  }
  
  public final boolean ddb()
  {
    AppMethodBeat.i(7121);
    boolean bool = com.tencent.mm.kernel.g.RG();
    AppMethodBeat.o(7121);
    return bool;
  }
  
  public final String[] ddc()
  {
    AppMethodBeat.i(7151);
    Object localObject = com.tencent.mm.m.g.Nr().R("WebViewConfig", "removeJavascriptInterface");
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(7151);
      return null;
    }
    localObject = ((String)localObject).split(";");
    AppMethodBeat.o(7151);
    return localObject;
  }
  
  public final String ddd()
  {
    AppMethodBeat.i(7153);
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(-1535680990, null);
    AppMethodBeat.o(7153);
    return str;
  }
  
  public final String dde()
  {
    AppMethodBeat.i(7155);
    String str = com.tencent.mm.sdk.platformtools.aa.f(this.uZy.getSharedPreferences(ah.dsP(), 0));
    AppMethodBeat.o(7155);
    return str;
  }
  
  public final String ddf()
  {
    AppMethodBeat.i(7164);
    Object localObject = new hw();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((hw)localObject).cxf.url;
    AppMethodBeat.o(7164);
    return localObject;
  }
  
  public final Map ddg()
  {
    AppMethodBeat.i(7165);
    Object localObject = com.tencent.mm.m.g.Nr().Na();
    if (localObject == null)
    {
      AppMethodBeat.o(7165);
      return null;
    }
    localObject = ((com.tencent.mm.m.d)localObject).etO;
    AppMethodBeat.o(7165);
    return localObject;
  }
  
  public final int ddh()
  {
    AppMethodBeat.i(7166);
    com.tencent.mm.kernel.g.RJ();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(7166);
    return i;
  }
  
  public final int ddi()
  {
    AppMethodBeat.i(7167);
    int i = bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12304, null));
    AppMethodBeat.o(7167);
    return i;
  }
  
  public final void ddj()
  {
    AppMethodBeat.i(7168);
    Intent localIntent = new Intent();
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null);
    localIntent.setFlags(268435456);
    localIntent.putExtra("sns_userName", str);
    localIntent.addFlags(67108864);
    localIntent.putExtra("sns_adapter_type", 1);
    int i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(68389, null), 0);
    com.tencent.mm.kernel.g.RL().Ru().set(68389, Integer.valueOf(i + 1));
    localIntent.setClassName(ah.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI");
    this.uZy.startActivity(localIntent);
    AppMethodBeat.o(7168);
  }
  
  public final void ddk()
  {
    AppMethodBeat.i(7169);
    if ((com.tencent.mm.model.r.Zy() & 0x8000) == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (com.tencent.mm.bq.d.ahR("sns")))
      {
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.setClassName(ah.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
        localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
        this.uZy.startActivity(localIntent);
      }
      AppMethodBeat.o(7169);
      return;
    }
  }
  
  public final boolean ddl()
  {
    AppMethodBeat.i(7172);
    boolean bool = com.tencent.mm.model.r.ZB();
    AppMethodBeat.o(7172);
    return bool;
  }
  
  public final boolean ddm()
  {
    AppMethodBeat.i(7177);
    if (wp("EnableWebviewScanQRCode") == 1)
    {
      AppMethodBeat.o(7177);
      return true;
    }
    AppMethodBeat.o(7177);
    return false;
  }
  
  public final boolean ddn()
  {
    AppMethodBeat.i(7182);
    com.tencent.mm.kernel.g.RJ();
    if ((!com.tencent.mm.kernel.a.QT()) || (com.tencent.mm.kernel.a.QP()))
    {
      AppMethodBeat.o(7182);
      return true;
    }
    AppMethodBeat.o(7182);
    return false;
  }
  
  public final List<String> ddo()
  {
    AppMethodBeat.i(7185);
    if (com.tencent.mm.kernel.g.RG()) {
      com.tencent.mm.plugin.webview.modeltools.g.dcy();
    }
    for (Object localObject = com.tencent.mm.plugin.webview.modeltools.g.dcF();; localObject = null)
    {
      if (localObject == null)
      {
        localObject = new ArrayList();
        AppMethodBeat.o(7185);
        return localObject;
      }
      localObject = new ArrayList(((com.tencent.mm.plugin.webview.modeltools.m)localObject).dcM());
      AppMethodBeat.o(7185);
      return localObject;
    }
  }
  
  public final int ddp()
  {
    AppMethodBeat.i(7187);
    int i = com.tencent.mm.pluginsdk.wallet.j.ddp();
    AppMethodBeat.o(7187);
    return i;
  }
  
  public final boolean ddq()
  {
    AppMethodBeat.i(7188);
    if (wp("WebViewDownLoadFileSwitch") == 1)
    {
      AppMethodBeat.o(7188);
      return true;
    }
    AppMethodBeat.o(7188);
    return false;
  }
  
  public final String[] ddr()
  {
    AppMethodBeat.i(7189);
    Object localObject = com.tencent.mm.m.g.Nr().R("AsyncCheckUrl", "UrlHost");
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(";");
      AppMethodBeat.o(7189);
      return localObject;
    }
    AppMethodBeat.o(7189);
    return null;
  }
  
  public final void favEditTag()
  {
    AppMethodBeat.i(7160);
    gi localgi = new gi();
    localgi.cuX.type = 35;
    com.tencent.mm.sdk.b.a.ymk.l(localgi);
    AppMethodBeat.o(7160);
  }
  
  public final int gM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7126);
    paramInt1 = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(paramInt1, null), paramInt2);
    AppMethodBeat.o(7126);
    return paramInt1;
  }
  
  public final void gN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7127);
    WebViewStubService.g(this.uZy).post(new WebViewStubService.1.3(this, paramInt1, paramInt2));
    AppMethodBeat.o(7127);
  }
  
  public final String getLanguage()
  {
    AppMethodBeat.i(7163);
    String str = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
    AppMethodBeat.o(7163);
    return str;
  }
  
  public final String hw(String paramString1, String paramString2)
  {
    return "";
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7181);
    Object localObject3 = new Bundle();
    long l1;
    boolean bool;
    label666:
    label1444:
    int i;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.WebViewStubService", "unknown action = %d", new Object[] { Integer.valueOf(paramInt) });
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
        AppMethodBeat.o(7181);
        return localObject3;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        Object localObject1 = bo.nullAsNil(paramBundle.getString("task_url"));
        paramBundle = paramBundle.getString("task_name");
        ab.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", new Object[] { localObject1, paramBundle });
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.e("MicroMsg.WebViewStubService", "download url is null or nil");
          AppMethodBeat.o(7181);
          return null;
        }
        localObject3 = new g.a();
        ((g.a)localObject3).JJ((String)localObject1);
        ((g.a)localObject3).JL(paramBundle);
        ((g.a)localObject3).gr(true);
        ((g.a)localObject3).tV(1);
        paramBundle = ((g.a)localObject3).kYR;
        l1 = com.tencent.mm.plugin.downloader.model.f.bjl().a(paramBundle);
        ab.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", new Object[] { Long.valueOf(l1) });
        paramBundle = new Bundle();
        paramBundle.putLong("download_id", l1);
        AppMethodBeat.o(7181);
        return paramBundle;
        l1 = paramBundle.getLong("download_id", 0L);
        paramBundle = com.tencent.mm.plugin.downloader.model.f.bjl().iA(l1);
        if (paramBundle == null)
        {
          bool = true;
          if (paramBundle != null) {
            break label666;
          }
        }
        for (paramInt = 0;; paramInt = paramBundle.status)
        {
          ab.i("MicroMsg.WebViewStubService", "query download task info, info == null ? %b task state = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
          paramInt = 0;
          if (paramBundle != null) {
            paramInt = paramBundle.status;
          }
          ab.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt) });
          paramBundle = new Bundle();
          paramBundle.putInt("download_state", paramInt);
          AppMethodBeat.o(7181);
          return paramBundle;
          bool = false;
          break;
        }
        l1 = paramBundle.getLong("download_id", 0L);
        paramInt = com.tencent.mm.plugin.downloader.model.f.bjl().iz(l1);
        ab.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramInt) });
        paramBundle = new Bundle();
        if (paramInt > 0) {}
        for (bool = true;; bool = false)
        {
          paramBundle.putBoolean("cancel_result", bool);
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        l1 = paramBundle.getLong("download_id");
        localObject1 = com.tencent.mm.plugin.downloader.model.f.bjl().iA(l1);
        paramBundle = new Bundle();
        if (localObject1 == null)
        {
          ab.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
          paramBundle.putBoolean("install_result", false);
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        if (((FileDownloadTaskInfo)localObject1).status != 3)
        {
          ab.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + ((FileDownloadTaskInfo)localObject1).status);
          paramBundle.putBoolean("install_result", false);
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        if (com.tencent.mm.a.e.cN(((FileDownloadTaskInfo)localObject1).path))
        {
          localObject1 = Uri.fromFile(new File(((FileDownloadTaskInfo)localObject1).path));
          com.tencent.mm.pluginsdk.model.app.q.a(this.uZy, (Uri)localObject1, null);
          paramBundle.putBoolean("install_result", true);
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        ab.e("MicroMsg.WebViewStubService", "file not exists : %s", new Object[] { ((FileDownloadTaskInfo)localObject1).path });
        paramBundle.putBoolean("install_result", false);
        AppMethodBeat.o(7181);
        return paramBundle;
        paramBundle = new Bundle();
        localObject1 = ah.dsR().getString("nfc_open_url", null);
        ab.i("MicroMsg.WebViewStubService", "nfc url=" + bo.nullAsNil((String)localObject1));
        if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(((String)localObject1).trim()))) {
          paramBundle.putString("debugConfig", (String)localObject1);
        }
        paramBundle.putString("config", String.valueOf(com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzK, null)));
        AppMethodBeat.o(7181);
        return paramBundle;
        paramBundle = new Bundle();
        paramBundle.putBoolean("webview_video_proxy_init", aq.dcc().hasInit);
        AppMethodBeat.o(7181);
        return paramBundle;
        paramBundle = aq.dcc();
        if (paramBundle.hasInit)
        {
          paramBundle.uWu = null;
          aq.uWt = null;
          paramBundle.hasInit = false;
        }
        AppMethodBeat.o(7181);
        return null;
        try
        {
          if (Looper.myLooper() == null) {
            Looper.prepare();
          }
          com.tencent.mm.sdk.g.d.ysm.execute(new WebViewStubService.1.6(this));
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.WebViewStubService", paramBundle, "", new Object[0]);
          }
        }
        AppMethodBeat.o(7181);
        return null;
        bool = com.tencent.mm.kernel.g.RG();
        paramBundle = new WebViewStubService.1.7(this);
        if (!bool) {}
        for (paramBundle = (String)paramBundle.b(WebViewStubService.g(this.uZy));; paramBundle = (String)paramBundle.b(null))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("config_info_username", paramBundle);
          AppMethodBeat.o(7181);
          return localObject1;
        }
        localObject3 = new Bundle();
        paramBundle = null;
        try
        {
          localObject1 = com.tencent.mm.model.c.c.abU().me(com.tencent.mm.plugin.webview.modeltools.c.uXq);
          paramBundle = (Bundle)localObject1;
        }
        catch (AssertionFailedError localAssertionFailedError)
        {
          for (;;)
          {
            ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
          }
        }
        catch (com.tencent.mm.model.b localb)
        {
          for (;;)
          {
            ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
          }
          paramBundle = paramBundle.dvN();
          l1 = bo.getLong((String)paramBundle.get("interval"), 0L);
          long l2 = bo.aox();
          long l3 = bo.c((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yAV, null));
          ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1) });
          if (l3 < l2) {
            break label1444;
          }
          ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
          AppMethodBeat.o(7181);
          return localObject3;
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAV, Long.valueOf(l1 + l2));
          i = bo.getInt((String)paramBundle.get("urlCount"), 0);
          localObject2 = new ArrayList(i);
          paramInt = 0;
          while (paramInt < i)
          {
            ((ArrayList)localObject2).add(paramBundle.get(String.format("url%d", new Object[] { Integer.valueOf(paramInt) })));
            paramInt += 1;
          }
          ((Bundle)localObject3).putStringArrayList("cookies_cleanup_url_list", (ArrayList)localObject2);
          AppMethodBeat.o(7181);
          return localObject3;
        }
        if ((paramBundle == null) || (!paramBundle.isValid()))
        {
          ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", new Object[] { paramBundle });
          AppMethodBeat.o(7181);
          return localObject3;
        }
        if (!com.tencent.mm.kernel.g.RG())
        {
          AppMethodBeat.o(7181);
          return null;
        }
        paramBundle = com.tencent.mm.model.c.c.abU().me("100036");
        if (!paramBundle.isValid())
        {
          ab.d("MicroMsg.WebViewStubService", "test is valid");
          AppMethodBeat.o(7181);
          return null;
        }
        paramBundle = paramBundle.dvN();
        localObject2 = new Bundle();
        paramInt = bo.getInt((String)paramBundle.get("controlFlag"), 0);
        ((Bundle)localObject2).putInt("webview_ad_intercept_control_flag", paramInt);
        if (paramInt == 0)
        {
          ab.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
          AppMethodBeat.o(7181);
          return localObject2;
        }
        i = bo.getInt((String)paramBundle.get("blackListCount"), 0);
        localObject3 = new ArrayList();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject4 = (String)paramBundle.get("blackList" + (paramInt + 1));
          if ((!bo.isNullOrNil((String)localObject4)) && (!((ArrayList)localObject3).contains(localObject4)))
          {
            ab.i("MicroMsg.WebViewStubService", "add black list domin = %s", new Object[] { localObject4 });
            ((ArrayList)localObject3).add(localObject4);
          }
          paramInt += 1;
        }
        i = bo.getInt((String)paramBundle.get("whiteListCount"), 0);
        localObject4 = new ArrayList();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject5 = (String)paramBundle.get("whiteList" + (paramInt + 1));
          if ((!bo.isNullOrNil((String)localObject5)) && (!((ArrayList)localObject4).contains(localObject5)))
          {
            ab.i("MicroMsg.WebViewStubService", "add white list domin = %s", new Object[] { localObject5 });
            ((ArrayList)localObject4).add(localObject5);
          }
          paramInt += 1;
        }
        ((Bundle)localObject2).putStringArrayList("webview_ad_intercept_blacklist_domins", (ArrayList)localObject3);
        ((Bundle)localObject2).putStringArrayList("webview_ad_intercept_whitelist_domins", (ArrayList)localObject4);
        AppMethodBeat.o(7181);
        return localObject2;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        paramBundle = paramBundle.getString("data");
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("key_biz_type", com.tencent.mm.aj.f.rS(paramBundle).field_type);
        AppMethodBeat.o(7181);
        return localObject2;
        if (paramBundle == null)
        {
          paramBundle = Bundle.EMPTY;
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        localObject2 = new Bundle();
        paramInt = paramBundle.getInt("webview_binder_id");
        paramBundle = bo.nullAsNil(paramBundle.getString("rawUrl"));
        ((Bundle)localObject2).putString("appId", com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).bZ(paramBundle));
        AppMethodBeat.o(7181);
        return localObject2;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        localObject2 = paramBundle.getString("enterprise_action");
        paramBundle = new Bundle();
        if (((String)localObject2).equals("enterprise_has_connector"))
        {
          com.tencent.mm.aj.z.afi();
          if (com.tencent.mm.aj.e.aeM().size() > 0)
          {
            bool = true;
            paramBundle.putBoolean("enterprise_has_connector", bool);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(7181);
          return paramBundle;
          bool = false;
          break;
          if (((String)localObject2).equals("enterprise_connectors"))
          {
            com.tencent.mm.aj.z.afi();
            localObject2 = com.tencent.mm.aj.e.aeM();
            if (localObject2 != null) {
              paramBundle.putStringArrayList("enterprise_connectors", new ArrayList((Collection)localObject2));
            }
          }
        }
        paramBundle = new Bundle();
        paramBundle.putBoolean("is_oauth_native", false);
        if (!com.tencent.mm.kernel.g.RJ().QU())
        {
          ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        if (!com.tencent.mm.kernel.g.RM().eIn.eIH)
        {
          ab.i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        localObject2 = com.tencent.mm.model.c.c.abU().me("100272");
        if (!((com.tencent.mm.storage.c)localObject2).isValid())
        {
          ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        localObject2 = ((com.tencent.mm.storage.c)localObject2).dvN();
        if (localObject2 == null)
        {
          ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        if ((((Map)localObject2).containsKey("isUseNative")) && ("1".equals(((Map)localObject2).get("isUseNative"))))
        {
          paramBundle.putBoolean("is_oauth_native", true);
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
        AppMethodBeat.o(7181);
        return paramBundle;
        paramBundle = ah.a.dbT();
        AppMethodBeat.o(7181);
        return paramBundle;
        paramBundle = a.b.dbH();
        AppMethodBeat.o(7181);
        return paramBundle;
        paramBundle = new StringBuilder("kwid_");
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.modelappbrand.b.fpR = com.tencent.mm.kernel.a.getUin() + "_" + bo.aoy();
        ab.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", new Object[] { com.tencent.mm.modelappbrand.b.fpR });
        continue;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        localObject2 = paramBundle.getString("KAppId");
        localObject4 = paramBundle.getString("shortcut_user_name");
        paramInt = paramBundle.getInt("webviewui_binder_id");
        if ((bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil((String)localObject4)))
        {
          AppMethodBeat.o(7181);
          return null;
        }
        WebViewStubService.a(this.uZy, 10, paramBundle, paramInt);
        continue;
        WebViewStubService.a(this.uZy, paramBundle.getInt("screen_orientation", -1));
        continue;
        ((Bundle)localObject3).putBoolean("isOpenForFaceBook", com.tencent.mm.model.r.ZM());
        continue;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        paramInt = paramBundle.getInt("game_sourceScene");
        paramBundle = new gu();
        paramBundle.cvL.actionCode = 5;
        paramBundle.cvL.scene = paramInt;
        com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
        continue;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        paramBundle = paramBundle.getString("game_hv_menu_appid");
        if (bo.isNullOrNil(paramBundle))
        {
          AppMethodBeat.o(7181);
          return null;
        }
        localObject2 = new gv();
        ((gv)localObject2).cvM.vA = 3;
        ((gv)localObject2).cvM.cvO = paramBundle;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        ((Bundle)localObject3).putString("game_hv_menu_pbcache", ((gv)localObject2).cvN.result);
      }
    case 129: 
      paramInt = paramBundle.getInt("webview_instance_id");
      localObject2 = null;
      localObject4 = WebViewStubService.f(this.uZy).iterator();
      label2741:
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (WebViewStubCallbackWrapper)((Iterator)localObject4).next();
        if ((localObject5 == null) || (((WebViewStubCallbackWrapper)localObject5).id != paramInt)) {
          break label4373;
        }
        localObject2 = ((WebViewStubCallbackWrapper)localObject5).vdZ;
      }
      break;
    }
    label4109:
    label4115:
    label4373:
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          break label2741;
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt).a(this.uZy, (e)localObject2);
          localObject2 = new HashMap();
          ((Map)localObject2).put("scene", Integer.valueOf(paramBundle.getInt("scene")));
          ((Map)localObject2).put("webview_instance_id", Integer.valueOf(paramInt));
          com.tencent.mm.plugin.webview.modeltools.g.dcB().aw((Map)localObject2);
          break;
          localObject4 = new HashMap();
          ((Map)localObject4).put("logString", paramBundle.getString("logString"));
          localObject5 = com.tencent.mm.plugin.webview.modeltools.g.dcB();
          localObject2 = com.tencent.mm.plugin.websearch.api.aa.t((Map)localObject4, "logString");
          HashMap localHashMap = new HashMap();
          if (!((String)localObject2).contains("h5version=")) {
            localHashMap.put("h5version", Integer.valueOf(com.tencent.mm.plugin.websearch.api.aa.Jf(0)));
          }
          paramBundle = (Bundle)localObject2;
          if (localHashMap.keySet().size() > 0) {
            if (((String)localObject2).length() <= 0) {
              break label3016;
            }
          }
          label3016:
          for (paramBundle = (String)localObject2 + "&" + com.tencent.mm.plugin.websearch.api.aa.an(localHashMap);; paramBundle = com.tencent.mm.plugin.websearch.api.aa.an(localHashMap))
          {
            ((Map)localObject4).put("logString", paramBundle);
            ((com.tencent.mm.plugin.webview.fts.b)localObject5).ay((Map)localObject4);
            break;
          }
          paramBundle = com.tencent.mm.model.c.c.abU().me("100248");
          if (!paramBundle.isValid())
          {
            ab.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
            AppMethodBeat.o(7181);
            return null;
          }
          if (bo.getInt((String)paramBundle.dvN().get("isForceSync"), 0) != 1) {
            break;
          }
          paramBundle = com.tencent.mm.m.g.Nr().R("WebViewConfig", "forceSyncA8KeyHostPath");
          ab.d("MicroMsg.ConfigListDecoder", "host list = %s", new Object[] { paramBundle });
          ((Bundle)localObject3).putString("force_geta8key_host_path", paramBundle);
          break;
          if (paramBundle == null)
          {
            AppMethodBeat.o(7181);
            return null;
          }
          localObject4 = paramBundle.keySet();
          if (localObject4 == null)
          {
            AppMethodBeat.o(7181);
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
            paramBundle = new gv();
          }
          catch (JSONException paramBundle)
          {
            AppMethodBeat.o(7181);
            return null;
          }
          paramBundle.cvM.vA = 4;
          paramBundle.cvM.cvO = ((JSONObject)localObject2).toString();
          com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
          break;
          if (paramBundle == null)
          {
            AppMethodBeat.o(7181);
            return null;
          }
          if (paramBundle == null) {
            break;
          }
          try
          {
            com.tencent.mm.sdk.g.d.post(new c.1(paramBundle), "web_call_rpt");
          }
          catch (Exception paramBundle)
          {
            ab.printErrStackTrace("MicroMsg.WebViewStubService", paramBundle, "webview call back mm error", new Object[0]);
          }
        }
        break;
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        l1 = paramBundle.getLong("key_activity_browse_time", 0L);
        com.tencent.mm.modelstat.f.akB().B(WebViewUI.class.getName(), l1);
        break;
        paramBundle = com.tencent.mm.model.c.c.abU().me("100484");
        if (!paramBundle.isValid())
        {
          AppMethodBeat.o(7181);
          return null;
        }
        if ("1".equals(paramBundle.dvN().get("closeDelayInject")))
        {
          paramBundle = new Bundle();
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        AppMethodBeat.o(7181);
        return null;
        paramBundle = new bv();
        com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
        AppMethodBeat.o(7181);
        return null;
        if (com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.misc.a.a.class) != null) {}
        for (paramInt = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.misc.a.a.class)).yW(16);; paramInt = 0)
        {
          ((Bundle)localObject3).putInt("sim_card_type", paramInt);
          AppMethodBeat.o(7181);
          return localObject3;
        }
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramBundle.getInt("WebViewShare_BinderID"));
        if (paramBundle != null)
        {
          localObject3 = paramBundle.getString("function", "");
          ab.i("MicroMsg.MsgHandler", "onWebViewUITipsDialogCancel %s", new Object[] { localObject3 });
          if ("profile".equals(localObject3))
          {
            ao.a.flI.pl(paramBundle.getString("username", ""));
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject2).a(((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject2).vpn, "profile:cancel", null);
          }
        }
        AppMethodBeat.o(7181);
        return null;
        if (paramBundle == null)
        {
          paramBundle = new Bundle();
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        paramInt = paramBundle.getInt("WebViewShare_BinderID");
        localObject2 = paramBundle.getString("WebViewShare_wv_url", "");
        paramBundle = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
        localObject2 = u.agP((String)localObject2);
        localObject3 = paramBundle.vpG;
        if ((((com.tencent.mm.plugin.webview.f.c)localObject3).vtY.containsKey(localObject2)) && (((com.tencent.mm.plugin.webview.f.c)localObject3).vtY.get(localObject2) != null))
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label3743;
          }
        }
        label3743:
        for (paramBundle = null;; paramBundle = paramBundle.vpG.ajo((String)localObject2))
        {
          localObject2 = new Bundle();
          if (paramBundle != null)
          {
            ((Bundle)localObject2).putInt("key_hao_kan_permission", paramBundle.permission);
            ((Bundle)localObject2).putInt("key_hao_kan_recommand", paramBundle.vtZ);
            ((Bundle)localObject2).putString("key_hao_kan_title", paramBundle.title);
          }
          AppMethodBeat.o(7181);
          return localObject2;
          paramInt = 0;
          break;
        }
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        ((Bundle)localObject3).putBoolean("is_enterprise_username", com.tencent.mm.aj.f.rV(paramBundle.getString("enterprise_biz_username")));
        break;
        paramBundle = n.a.ao(paramBundle);
        AppMethodBeat.o(7181);
        return paramBundle;
        localObject2 = new Bundle();
        com.tencent.mm.plugin.webview.modeltools.f.ae(paramBundle);
        ((Bundle)localObject2).putBoolean("open_result", false);
        AppMethodBeat.o(7181);
        return localObject2;
        if (paramBundle == null)
        {
          paramBundle = new Bundle();
          AppMethodBeat.o(7181);
          return paramBundle;
        }
        paramInt = paramBundle.getInt("WebViewShare_BinderID");
        i = paramBundle.getInt("WebViewShare_type");
        localObject2 = new Bundle();
        localObject3 = paramBundle.getString("WebViewShare_wv_url", "");
        paramBundle = null;
        if (i == 1)
        {
          paramBundle = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
          localObject3 = u.agP((String)localObject3);
          localObject4 = paramBundle.vpF;
          if ((((l)localObject4).uYx.containsKey(localObject3)) && (((l)localObject4).uYx.get(localObject3) != null))
          {
            paramInt = 1;
            if (paramInt != 0) {
              break label4033;
            }
            paramBundle = null;
            if (paramBundle == null) {
              break label4052;
            }
            bool = true;
            ((Bundle)localObject2).putBoolean("WebViewShare_reslut", bool);
          }
        }
        label4033:
        label4052:
        while (i != 2) {
          for (;;)
          {
            if (paramBundle != null)
            {
              ((Bundle)localObject2).putString("link", paramBundle.link);
              ((Bundle)localObject2).putString("title", paramBundle.title);
              ((Bundle)localObject2).putString("desc", paramBundle.desc);
              ((Bundle)localObject2).putString("img_url", paramBundle.rGa);
            }
            AppMethodBeat.o(7181);
            return localObject2;
            paramInt = 0;
            continue;
            paramBundle = (l.a)paramBundle.vpF.uYx.get(localObject3);
            continue;
            bool = false;
          }
        }
        paramBundle = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
        localObject3 = u.agP((String)localObject3);
        localObject4 = paramBundle.vpF;
        if ((((l)localObject4).uYy.containsKey(localObject3)) && (((l)localObject4).uYy.get(localObject3) != null))
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label4140;
          }
          paramBundle = null;
          if (paramBundle == null) {
            break label4159;
          }
        }
        label4140:
        label4159:
        for (bool = true;; bool = false)
        {
          ((Bundle)localObject2).putBoolean("WebViewShare_reslut", bool);
          break;
          paramInt = 0;
          break label4109;
          paramBundle = (l.a)paramBundle.vpF.uYy.get(localObject3);
          break label4115;
        }
        if (paramBundle == null)
        {
          AppMethodBeat.o(7181);
          return null;
        }
        try
        {
          paramBundle.setClassLoader(getClass().getClassLoader());
          if (paramBundle.getStringArrayList("reportAdH5Load") == null) {
            break;
          }
          localObject2 = paramBundle.getStringArrayList("reportAdH5Load");
          localObject4 = new on();
          ((on)localObject4).cFc.cFb = ((SnsAdClick)paramBundle.getParcelable("snsAdClick"));
          ((on)localObject4).cFc.url = com.tencent.mm.compatible.util.q.encode((String)((List)localObject2).get(0), "UTF-8");
          ((on)localObject4).cFc.cFd = bo.apV((String)((List)localObject2).get(1));
          ((on)localObject4).cFc.timestamp = bo.apW((String)((List)localObject2).get(2));
          ((on)localObject4).cFc.cFe = ((String)((List)localObject2).get(3));
          ((on)localObject4).cFc.errorCode = paramBundle.getInt("errCode", 0);
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
        }
        catch (Exception paramBundle)
        {
          ab.e("MicroMsg.WebViewStubService", "report sns ad exception, %s", new Object[] { paramBundle.getMessage() });
        }
      }
      break;
    }
  }
  
  public final boolean isSDCardAvailable()
  {
    AppMethodBeat.i(7125);
    boolean bool = com.tencent.mm.kernel.g.RL().isSDCardAvailable();
    AppMethodBeat.o(7125);
    return bool;
  }
  
  public final void j(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7138);
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramInt);
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", new Object[] { paramString });
      localg.ezJ = false;
      localg.vpq.add(paramString);
      if (paramBoolean) {
        localg.vpp.add(paramString);
      }
    }
    AppMethodBeat.o(7138);
  }
  
  public final void k(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(7132);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    com.tencent.mm.plugin.report.service.h.g(paramInt, paramList);
    AppMethodBeat.o(7132);
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(7116);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString).Oe();
    AppMethodBeat.o(7116);
    return paramString;
  }
  
  public final boolean nT(String paramString)
  {
    AppMethodBeat.i(7117);
    boolean bool = com.tencent.mm.model.t.nT(paramString);
    AppMethodBeat.o(7117);
    return bool;
  }
  
  public final boolean nU(String paramString)
  {
    AppMethodBeat.i(7119);
    boolean bool = com.tencent.mm.kernel.g.RG();
    ab.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(7119);
      return false;
    }
    bool = com.tencent.mm.model.t.nU(paramString);
    AppMethodBeat.o(7119);
    return bool;
  }
  
  public final boolean oD(String paramString)
  {
    AppMethodBeat.i(7118);
    boolean bool = com.tencent.mm.model.t.oD(paramString);
    AppMethodBeat.o(7118);
    return bool;
  }
  
  public final Bundle r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(153164);
    paramBundle = com.tencent.mm.plugin.webview.modeltools.g.dcB().r(paramInt, paramBundle);
    AppMethodBeat.o(153164);
    return paramBundle;
  }
  
  public final Bundle s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7115);
    com.tencent.mm.plugin.webview.modeltools.g.dcB();
    paramBundle = com.tencent.mm.plugin.webview.fts.b.s(paramInt, paramBundle);
    AppMethodBeat.o(7115);
    return paramBundle;
  }
  
  public final void u(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7113);
    com.tencent.mm.plugin.webview.c.a locala = com.tencent.mm.plugin.webview.modeltools.g.dcz();
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
      ab.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(7113);
      return;
    }
    locala.ar(localHashMap);
    AppMethodBeat.o(7113);
  }
  
  public final boolean v(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7129);
    ab.i("MicroMsg.WebViewStubService", "doScene, type = %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    boolean bool;
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(7129);
      return false;
    case 233: 
      if (!ddb())
      {
        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        AppMethodBeat.o(7129);
        return false;
      }
      localObject = paramBundle.getString("geta8key_data_req_url");
      if (!bo.isNullOrNil(paramBundle.getString("k_share_url"))) {
        com.tencent.mm.plugin.webview.model.at.hs((String)localObject, paramBundle.getString("k_share_url"));
      }
      if (!bo.isNullOrNil((String)localObject)) {}
      for (localObject = new com.tencent.mm.modelsimple.j((String)localObject, paramBundle.getString("geta8key_data_username"), paramBundle.getInt("geta8key_data_scene"), paramBundle.getInt("geta8key_data_reason"), paramBundle.getInt("geta8key_data_flag"), paramBundle.getString("geta8key_data_net_type"), paramBundle.getInt("geta8key_session_id", 0), paramBundle.getString("geta8key_data_appid"), paramBundle.getString("key_function_id"), paramBundle.getInt("key_wallet_region", 0), paramBundle.getByteArray("k_a8key_cookie"));; localObject = new com.tencent.mm.modelsimple.j(paramBundle.getString("geta8key_data_appid"), paramBundle.getString("geta8key_data_scope"), paramBundle.getString("geta8key_data_state"), paramBundle.getInt("geta8key_session_id", 0)))
      {
        ((com.tencent.mm.modelsimple.j)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
        paramInt = paramBundle.getInt("geta8key_data_subscene", -1);
        if (paramInt > 0) {
          ((com.tencent.mm.modelsimple.j)localObject).setSubScene(paramInt);
        }
        paramBundle = paramBundle.getString("geta8key_outer_url");
        if (!bo.isNullOrNil(paramBundle)) {
          ((com.tencent.mm.modelsimple.j)localObject).uo(paramBundle);
        }
        bool = com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
        AppMethodBeat.o(7129);
        return bool;
      }
    case 673: 
      if (!ddb())
      {
        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        AppMethodBeat.o(7129);
        return false;
      }
      localObject = new com.tencent.mm.plugin.webview.model.p(paramBundle.getString("reading_mode_data_url"), paramBundle.getString("reading_mode_data_useragent"), paramBundle.getInt("reading_mode_data_width"), paramBundle.getInt("reading_mode_data_height"));
      ((com.tencent.mm.plugin.webview.model.p)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
      bool = com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      AppMethodBeat.o(7129);
      return bool;
    case 666: 
      if (!ddb())
      {
        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        AppMethodBeat.o(7129);
        return false;
      }
      bool = WebViewStubService.ah(paramBundle);
      AppMethodBeat.o(7129);
      return bool;
    case 1254: 
      if (!ddb())
      {
        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        AppMethodBeat.o(7129);
        return false;
      }
      localObject = new y(paramBundle.getString("oauth_url"), paramBundle.getString("biz_username"), paramBundle.getInt("scene"));
      ((y)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
      bool = com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      AppMethodBeat.o(7129);
      return bool;
    case 1373: 
      if (!ddb())
      {
        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        AppMethodBeat.o(7129);
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
      ab.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
      localObject = new com.tencent.mm.plugin.webview.model.z((String)localObject, i, localLinkedList);
      ((com.tencent.mm.plugin.webview.model.z)localObject).tag = Integer.valueOf(paramBundle.getInt("webview_binder_id"));
      bool = com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      AppMethodBeat.o(7129);
      return bool;
    case 2836: 
      if (!ddb())
      {
        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
        AppMethodBeat.o(7129);
        return false;
      }
      bool = WebViewStubService.a(this.uZy, paramBundle);
      AppMethodBeat.o(7129);
      return bool;
    }
    if (!ddb())
    {
      ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
      AppMethodBeat.o(7129);
      return false;
    }
    if (paramBundle == null)
    {
      AppMethodBeat.o(7129);
      return false;
    }
    paramBundle = paramBundle.getString("ad_report_data_str");
    ab.d("MicroMsg.WebViewReportUtil", "doReportCgi : %s", new Object[] { paramBundle });
    if (com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.a.class) == null)
    {
      AppMethodBeat.o(7129);
      return false;
    }
    ((com.tencent.mm.plugin.sns.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.a.class)).j(13791, paramBundle, (int)bo.aox());
    AppMethodBeat.o(7129);
    return true;
  }
  
  public final boolean y(long paramLong, String paramString)
  {
    AppMethodBeat.i(7161);
    if ((paramLong == -9223372036854775808L) && (paramString == null))
    {
      AppMethodBeat.o(7161);
      return false;
    }
    Object localObject = new dr();
    if (paramLong != -9223372036854775808L) {
      ((dr)localObject).crt.cpO = paramLong;
    }
    if (paramString != null) {
      ((dr)localObject).crt.crk = paramString;
    }
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (((dr)localObject).cru.cqS)
    {
      AppMethodBeat.o(7161);
      return true;
    }
    if ((com.tencent.mm.kernel.g.RG()) && (paramLong != -9223372036854775808L))
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramLong);
      if (paramString.getType() == 49)
      {
        boolean bool = com.tencent.mm.model.t.lA(paramString.field_talker);
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
              paramString = bf.pv((String)localObject);
            }
          }
        }
        paramString = j.b.mY(paramString);
        if (paramString.type == 3)
        {
          bool = com.tencent.mm.pluginsdk.model.app.g.o(ah.getContext(), 16L);
          AppMethodBeat.o(7161);
          return bool;
        }
        if (paramString.type == 4)
        {
          bool = com.tencent.mm.pluginsdk.model.app.g.o(ah.getContext(), 8L);
          AppMethodBeat.o(7161);
          return bool;
        }
      }
    }
    AppMethodBeat.o(7161);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1
 * JD-Core Version:    0.7.0.1
 */