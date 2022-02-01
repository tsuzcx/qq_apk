package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.ce.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.a;
import com.tencent.mm.plugin.webview.q;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.af;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class c
  extends a
{
  private final WeakReference<WebViewUI> WOf;
  private WebViewClipBoardHelper WSk;
  
  public c(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79575);
    this.WOf = new WeakReference(paramWebViewUI);
    this.WSk = new WebViewClipBoardHelper(paramWebViewUI);
    AppMethodBeat.o(79575);
  }
  
  private WebViewUI iwO()
  {
    AppMethodBeat.i(79585);
    WebViewUI localWebViewUI = (WebViewUI)this.WOf.get();
    AppMethodBeat.o(79585);
    return localWebViewUI;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(79583);
    iwO().WRh.computeScroll(paramView);
    AppMethodBeat.o(79583);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79579);
    boolean bool = iwO().WRh.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(79579);
    return bool;
  }
  
  public void invalidate() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79578);
    boolean bool = iwO().WRh.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(79578);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    AppMethodBeat.i(79576);
    Object localObject = iwO();
    boolean bool2;
    if (paramBundle == null)
    {
      bool1 = true;
      if ((localObject != null) && (((WebViewUI)localObject).sLC != null)) {
        break label123;
      }
      bool2 = true;
      label40:
      Log.i("MicroMsg.DefaultProxyWebViewClientExtension", "method = %s, bundler == null ? %b, invoker == null ? %b", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!Util.isNullOrNil(paramString)) && (paramBundle != null)) {
        if ((iwO() != null) && (!iwO().isFinishing())) {
          break label129;
        }
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localObject != null)) {
        break label134;
      }
      AppMethodBeat.o(79576);
      return null;
      bool1 = false;
      break;
      label123:
      bool2 = false;
      break label40;
    }
    label134:
    long l;
    if ((paramString.equals("addDownloadTask")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        Bundle localBundle1 = ((WebViewUI)localObject).sLC.m(14, paramBundle);
        if (localBundle1 != null)
        {
          l = localBundle1.getLong("download_id", 0L);
          AppMethodBeat.o(79576);
          return Long.valueOf(l);
        }
      }
      catch (RemoteException localRemoteException1)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "invoke the add downloadtask failed");
      }
    }
    if ((paramString.equals("cancelDownloadTask")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        Bundle localBundle2 = ((WebViewUI)localObject).sLC.m(16, paramBundle);
        if (localBundle2 != null)
        {
          bool1 = localBundle2.getBoolean("cancel_result", false);
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException localRemoteException2)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "invoke the cancel downloadtask failed");
      }
    }
    if ((paramString.equals("queryDownloadTask")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        Bundle localBundle3 = ((WebViewUI)localObject).sLC.m(15, paramBundle);
        if (localBundle3 != null)
        {
          i = localBundle3.getInt("download_state", 0);
          AppMethodBeat.o(79576);
          return Integer.valueOf(i);
        }
      }
      catch (RemoteException localRemoteException3)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "invoke the queryDownloadTask downloadtask failed");
      }
    }
    if ((paramString.equals("getOAID")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        Bundle localBundle4 = ((WebViewUI)localObject).sLC.m(112, paramBundle);
        AppMethodBeat.o(79576);
        return localBundle4;
      }
      catch (RemoteException localRemoteException4)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "invoke getOAID failed");
      }
    }
    if ((paramString.equals("installDownloadTask")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        Bundle localBundle5 = ((WebViewUI)localObject).sLC.m(17, paramBundle);
        if (localBundle5 != null)
        {
          bool1 = localBundle5.getBoolean("install_result");
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException localRemoteException5)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "invoke the install downloadtask failed");
      }
    }
    String str;
    if (paramString.equals("getDrawable"))
    {
      str = paramBundle.getString("packageName");
      i = paramBundle.getInt("resourceId");
      if ((!Util.isNullOrNil(str)) && (i > 0)) {
        try
        {
          Drawable localDrawable = d.h(MMApplicationContext.getContext().getPackageManager().getResourcesForApplication(str), i);
          AppMethodBeat.o(79576);
          return localDrawable;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "get resource for package : %s, fail, : %s", new Object[] { str, localException2.getMessage() });
        }
      }
    }
    if ((paramString.equals("getShareUrl")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        str = ((WebViewUI)localObject).sLC.bkG(((WebViewUI)localObject).sMP.getUrl());
        Log.i("MicroMsg.DefaultProxyWebViewClientExtension", "getShareUrl by x5 core, shareurl = %s", new Object[] { str });
        AppMethodBeat.o(79576);
        return str;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "getShare url failed");
      }
    }
    if (paramString.equals("smartPickWord"))
    {
      if (((WebViewUI)localObject).getMMTitle() != null) {}
      for (paramString = ((WebViewUI)localObject).getMMTitle().toString();; paramString = "")
      {
        paramString = com.tencent.mm.plugin.webview.modeltools.f.b(paramBundle, ((WebViewUI)localObject).fqa(), paramString);
        AppMethodBeat.o(79576);
        return paramString;
      }
    }
    if ((paramString.equals("jumpToSos")) && (((WebViewUI)localObject).sLC != null)) {
      try
      {
        com.tencent.mm.plugin.webview.modeltools.f.bp(paramBundle);
        paramString = ((WebViewUI)localObject).sLC.m(104, paramBundle);
        com.tencent.mm.plugin.webview.modeltools.f.os(paramBundle.getString("query"), ((WebViewUI)localObject).fqa());
        if (paramString != null)
        {
          bool1 = paramString.getBoolean("open_result");
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException paramString)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "jumpToSos failed");
        AppMethodBeat.o(79576);
        return null;
      }
    }
    if (paramString.equals("supportSmartPickWord"))
    {
      if (!((r)h.ax(r.class)).aBu()) {}
      for (bool1 = bool4;; bool1 = false)
      {
        AppMethodBeat.o(79576);
        return Boolean.valueOf(bool1);
      }
    }
    if (paramString.equals("onShowSos"))
    {
      com.tencent.mm.plugin.webview.modeltools.f.w(((WebViewUI)localObject).fqa(), paramBundle);
      AppMethodBeat.o(79576);
      return null;
    }
    if ((paramString.equals("onClickCopyBtn")) && (this.WSk != null))
    {
      paramString = paramBundle.getString("text");
      paramBundle = this.WSk;
      if (paramBundle.WOf.get() != null)
      {
        l = System.currentTimeMillis();
        if (l - paramBundle.lastReportTime >= 200L)
        {
          paramBundle.lastReportTime = l;
          localObject = new WebViewClipBoardHelper.ClipBoardDataWrapper();
          ((WebViewClipBoardHelper.ClipBoardDataWrapper)localObject).url = ((WebViewUI)paramBundle.WOf.get()).fqa();
          if (paramString == null) {
            break label998;
          }
        }
      }
      label998:
      for (i = paramString.length();; i = 0)
      {
        ((WebViewClipBoardHelper.ClipBoardDataWrapper)localObject).length = i;
        ((WebViewClipBoardHelper.ClipBoardDataWrapper)localObject).fromScene = ((WebViewUI)paramBundle.WOf.get()).getIntent().getIntExtra("from_scence", 0);
        ((WebViewClipBoardHelper.ClipBoardDataWrapper)localObject).username = ((WebViewUI)paramBundle.WOf.get()).getIntent().getStringExtra("geta8key_username");
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, WebViewClipBoardHelper.a.class, null);
        AppMethodBeat.o(79576);
        return null;
      }
    }
    if (paramString.equals("supportImagePreview"))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("shouldInterceptLoadError"))
    {
      i = paramBundle.getInt("errorCode");
      paramString = paramBundle.getString("description");
      paramBundle = paramBundle.getString("failingUrl");
      if (((WebViewUI)localObject).Wzl != null) {
        ((WebViewUI)localObject).Wzl.b(((WebViewUI)localObject).sMP, i, paramString, paramBundle);
      }
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("imagePreview")) {
      try
      {
        paramString = ((WebViewUI)localObject).WFb.m(18, new Bundle());
        com.tencent.mm.plugin.webview.modeltools.k.a(paramBundle, ((WebViewUI)localObject).sMP, paramString, ((WebViewUI)localObject).WXb);
        paramString = Boolean.TRUE;
        AppMethodBeat.o(79576);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
    if ((paramString.equals("closeImagePreview")) && (((WebViewUI)localObject).sLC != null))
    {
      com.tencent.mm.plugin.webview.modeltools.k.c(((WebViewUI)localObject).sLC);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onTranslateFinish"))
    {
      ((WebViewUI)localObject).WYl.irA();
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("onTranslateStart"))
    {
      paramString = ((WebViewUI)localObject).WYl;
      if ((paramString.tipDialog != null) && (paramString.tipDialog.isShowing()))
      {
        paramString.tipDialog.dismiss();
        paramString.tipDialog = null;
      }
      ((Context)localObject).getString(c.i.app_tip);
      paramString.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject, ((Context)localObject).getString(c.i.webview_menu_tranlate_waiting_tips), true, null);
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("onGetTranslateString"))
    {
      paramString = (HashMap)paramBundle.getSerializable("translate_hashmap");
      ((WebViewUI)localObject).WYl.a(((WebViewUI)localObject).sMP, paramString);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onGetSampleString"))
    {
      paramString = (HashMap)paramBundle.getSerializable("sample_hashmap");
      paramBundle = ((WebViewUI)localObject).WYl;
      Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString in");
      paramBundle.WvR = new LinkedList();
      paramBundle.WvR.addAll(paramString.values());
      paramBundle.WvW.countDown();
      Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString end");
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("enableDownload"))
    {
      bool2 = ((r)h.ax(r.class)).aBu();
      if (((WebViewUI)localObject).Wzl == null) {
        break label1536;
      }
    }
    label1536:
    for (boolean bool1 = ((WebViewUI)localObject).Wzl.Wwt;; bool1 = false)
    {
      Log.i("MicroMsg.DefaultProxyWebViewClientExtension", "onMiscCallback enableDownload isTeenMode: %b, isMarkForbidX5Download: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) && (!bool1)) {}
      for (bool1 = bool3;; bool1 = false)
      {
        AppMethodBeat.o(79576);
        return Boolean.valueOf(bool1);
      }
      AppMethodBeat.o(79576);
      return null;
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(79582);
    iwO().WRh.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(79582);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(79581);
    iwO().WRh.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(79581);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(79584);
    if (iwO().getIntent().getBooleanExtra("show_long_click_popup_menu", true))
    {
      AppMethodBeat.o(79584);
      return false;
    }
    AppMethodBeat.o(79584);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79577);
    boolean bool = iwO().WRh.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(79577);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(79580);
    WebViewUI localWebViewUI = iwO();
    if (localWebViewUI == null)
    {
      AppMethodBeat.o(79580);
      return false;
    }
    paramBoolean = localWebViewUI.WRh.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(79580);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */