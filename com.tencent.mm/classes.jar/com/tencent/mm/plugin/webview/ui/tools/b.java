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
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.r;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class b
  extends a
{
  private final WeakReference<WebViewUI> PXH;
  
  public b(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79575);
    this.PXH = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(79575);
  }
  
  private WebViewUI gXq()
  {
    AppMethodBeat.i(79585);
    WebViewUI localWebViewUI = (WebViewUI)this.PXH.get();
    AppMethodBeat.o(79585);
    return localWebViewUI;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(79583);
    gXq().Qgv.computeScroll(paramView);
    AppMethodBeat.o(79583);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79579);
    boolean bool = gXq().Qgv.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(79579);
    return bool;
  }
  
  public void invalidate() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79578);
    boolean bool = gXq().Qgv.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(79578);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(79576);
    WebViewUI localWebViewUI = gXq();
    boolean bool1;
    boolean bool2;
    if (paramBundle == null)
    {
      bool1 = true;
      if ((localWebViewUI != null) && (localWebViewUI.pGC != null)) {
        break label117;
      }
      bool2 = true;
      label34:
      Log.i("MicroMsg.DefaultProxyWebViewClientExtension", "method = %s, bundler == null ? %b, invoker == null ? %b", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!Util.isNullOrNil(paramString)) && (paramBundle != null)) {
        if ((gXq() != null) && (!gXq().isFinishing())) {
          break label123;
        }
      }
    }
    label117:
    label123:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localWebViewUI != null)) {
        break label128;
      }
      AppMethodBeat.o(79576);
      return null;
      bool1 = false;
      break;
      bool2 = false;
      break label34;
    }
    label128:
    if ((paramString.equals("addDownloadTask")) && (localWebViewUI.pGC != null)) {
      try
      {
        Bundle localBundle1 = localWebViewUI.pGC.l(14, paramBundle);
        if (localBundle1 != null)
        {
          long l = localBundle1.getLong("download_id", 0L);
          AppMethodBeat.o(79576);
          return Long.valueOf(l);
        }
      }
      catch (RemoteException localRemoteException1)
      {
        Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "invoke the add downloadtask failed");
      }
    }
    if ((paramString.equals("cancelDownloadTask")) && (localWebViewUI.pGC != null)) {
      try
      {
        Bundle localBundle2 = localWebViewUI.pGC.l(16, paramBundle);
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
    if ((paramString.equals("queryDownloadTask")) && (localWebViewUI.pGC != null)) {
      try
      {
        Bundle localBundle3 = localWebViewUI.pGC.l(15, paramBundle);
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
    if ((paramString.equals("installDownloadTask")) && (localWebViewUI.pGC != null)) {
      try
      {
        Bundle localBundle4 = localWebViewUI.pGC.l(17, paramBundle);
        if (localBundle4 != null)
        {
          bool1 = localBundle4.getBoolean("install_result");
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException localRemoteException4)
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
          Drawable localDrawable = com.tencent.mm.cj.b.g(MMApplicationContext.getContext().getPackageManager().getResourcesForApplication(str), i);
          AppMethodBeat.o(79576);
          return localDrawable;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.DefaultProxyWebViewClientExtension", "get resource for package : %s, fail, : %s", new Object[] { str, localException2.getMessage() });
        }
      }
    }
    if ((paramString.equals("getShareUrl")) && (localWebViewUI.pGC != null)) {
      try
      {
        str = localWebViewUI.pGC.bld(localWebViewUI.pHS.getUrl());
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
      if (localWebViewUI.getMMTitle() != null) {}
      for (paramString = localWebViewUI.getMMTitle().toString();; paramString = "")
      {
        paramString = com.tencent.mm.plugin.webview.modeltools.e.b(paramBundle, localWebViewUI.elY(), paramString);
        AppMethodBeat.o(79576);
        return paramString;
      }
    }
    if ((paramString.equals("jumpToSos")) && (localWebViewUI.pGC != null)) {
      try
      {
        com.tencent.mm.plugin.webview.modeltools.e.aL(paramBundle);
        paramString = localWebViewUI.pGC.l(104, paramBundle);
        com.tencent.mm.plugin.webview.modeltools.e.mC(paramBundle.getString("query"), localWebViewUI.elY());
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
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onShowSos"))
    {
      com.tencent.mm.plugin.webview.modeltools.e.v(localWebViewUI.elY(), paramBundle);
      AppMethodBeat.o(79576);
      return null;
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
      if (localWebViewUI.PIQ != null) {
        localWebViewUI.PIQ.b(localWebViewUI.pHS, i, paramString, paramBundle);
      }
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("imagePreview")) {
      try
      {
        paramString = localWebViewUI.POP.l(18, new Bundle());
        j.a(paramBundle, localWebViewUI.pHS, paramString, localWebViewUI.Qfe);
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
    if ((paramString.equals("closeImagePreview")) && (localWebViewUI.pGC != null))
    {
      j.c(localWebViewUI.pGC);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onTranslateFinish"))
    {
      localWebViewUI.Qgn.gSg();
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("onTranslateStart"))
    {
      paramString = localWebViewUI.Qgn;
      if ((paramString.tipDialog != null) && (paramString.tipDialog.isShowing()))
      {
        paramString.tipDialog.dismiss();
        paramString.tipDialog = null;
      }
      localWebViewUI.getString(c.i.app_tip);
      paramString.tipDialog = h.a(localWebViewUI, localWebViewUI.getString(c.i.webview_menu_tranlate_waiting_tips), true, null);
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("onGetTranslateString"))
    {
      paramString = (HashMap)paramBundle.getSerializable("translate_hashmap");
      localWebViewUI.Qgn.a(localWebViewUI.pHS, paramString);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onGetSampleString"))
    {
      paramString = (HashMap)paramBundle.getSerializable("sample_hashmap");
      paramBundle = localWebViewUI.Qgn;
      Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString in");
      paramBundle.PFr = new LinkedList();
      paramBundle.PFr.addAll(paramString.values());
      paramBundle.PFw.countDown();
      Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString end");
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    AppMethodBeat.o(79576);
    return null;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(79582);
    gXq().Qgv.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(79582);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(79581);
    gXq().Qgv.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(79581);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(79584);
    if (gXq().getIntent().getBooleanExtra("show_long_click_popup_menu", true))
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
    boolean bool = gXq().Qgv.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(79577);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(79580);
    paramBoolean = gXq().Qgv.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(79580);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */