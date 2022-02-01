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
import com.tencent.mm.plugin.webview.c;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class b
  extends a
{
  private final WeakReference<WebViewUI> Jbp;
  
  public b(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79575);
    this.Jbp = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(79575);
  }
  
  private WebViewUI geo()
  {
    AppMethodBeat.i(79585);
    WebViewUI localWebViewUI = (WebViewUI)this.Jbp.get();
    AppMethodBeat.o(79585);
    return localWebViewUI;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(79583);
    geo().Jjw.bLv();
    AppMethodBeat.o(79583);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79579);
    boolean bool = geo().Jjw.C(paramMotionEvent);
    AppMethodBeat.o(79579);
    return bool;
  }
  
  public void invalidate() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79578);
    boolean bool = geo().Jjw.D(paramMotionEvent);
    AppMethodBeat.o(79578);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(79576);
    boolean bool1;
    boolean bool2;
    if (paramBundle == null)
    {
      bool1 = true;
      if ((geo() != null) && (geo().mHh != null)) {
        break label120;
      }
      bool2 = true;
      label32:
      Log.i("MicroMsg.WebViewLongClickHelper", "method = %s, bundler == null ? %b, invoker == null ? %b", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!Util.isNullOrNil(paramString)) && (paramBundle != null)) {
        if ((geo() != null) && (!geo().isFinishing())) {
          break label126;
        }
      }
    }
    label120:
    label126:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (geo().mHh != null)) {
        break label131;
      }
      AppMethodBeat.o(79576);
      return null;
      bool1 = false;
      break;
      bool2 = false;
      break label32;
    }
    label131:
    if (paramString.equals("addDownloadTask")) {
      try
      {
        Bundle localBundle1 = geo().mHh.j(14, paramBundle);
        if (localBundle1 != null)
        {
          long l = localBundle1.getLong("download_id", 0L);
          AppMethodBeat.o(79576);
          return Long.valueOf(l);
        }
      }
      catch (RemoteException localRemoteException1)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the add downloadtask failed");
      }
    }
    if (paramString.equals("cancelDownloadTask")) {
      try
      {
        Bundle localBundle2 = geo().mHh.j(16, paramBundle);
        if (localBundle2 != null)
        {
          bool1 = localBundle2.getBoolean("cancel_result", false);
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException localRemoteException2)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the cancel downloadtask failed");
      }
    }
    if (paramString.equals("queryDownloadTask")) {
      try
      {
        Bundle localBundle3 = geo().mHh.j(15, paramBundle);
        if (localBundle3 != null)
        {
          i = localBundle3.getInt("download_state", 0);
          AppMethodBeat.o(79576);
          return Integer.valueOf(i);
        }
      }
      catch (RemoteException localRemoteException3)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the queryDownloadTask downloadtask failed");
      }
    }
    if (paramString.equals("installDownloadTask")) {
      try
      {
        Bundle localBundle4 = geo().mHh.j(17, paramBundle);
        if (localBundle4 != null)
        {
          bool1 = localBundle4.getBoolean("install_result");
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException localRemoteException4)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the install downloadtask failed");
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
          Drawable localDrawable = com.tencent.mm.cc.b.g(MMApplicationContext.getContext().getPackageManager().getResourcesForApplication(str), i);
          AppMethodBeat.o(79576);
          return localDrawable;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.WebViewLongClickHelper", "get resource for package : %s, fail, : %s", new Object[] { str, localException2.getMessage() });
        }
      }
    }
    if (paramString.equals("getShareUrl")) {
      try
      {
        str = geo().mHh.aZj(geo().pGj.getUrl());
        Log.i("MicroMsg.WebViewLongClickHelper", "getShareUrl by x5 core, shareurl = %s", new Object[] { str });
        AppMethodBeat.o(79576);
        return str;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "getShare url failed");
      }
    }
    if (paramString.equals("smartPickWord"))
    {
      if (geo().getMMTitle() != null) {}
      for (paramString = geo().getMMTitle().toString();; paramString = "")
      {
        paramString = com.tencent.mm.plugin.webview.modeltools.f.b(paramBundle, geo().fZM(), paramString);
        AppMethodBeat.o(79576);
        return paramString;
      }
    }
    if (paramString.equals("jumpToSos")) {
      try
      {
        com.tencent.mm.plugin.webview.modeltools.f.aP(paramBundle);
        paramString = geo().mHh.j(104, paramBundle);
        com.tencent.mm.plugin.webview.modeltools.f.mc(paramBundle.getString("query"), geo().fZM());
        if (paramString != null)
        {
          bool1 = paramString.getBoolean("open_result");
          AppMethodBeat.o(79576);
          return Boolean.valueOf(bool1);
        }
      }
      catch (RemoteException paramString)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "jumpToSos failed");
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
      com.tencent.mm.plugin.webview.modeltools.f.q(geo().fZM(), paramBundle);
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("supportImagePreview"))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onClickCopyBtn"))
    {
      com.tencent.mm.plugin.webview.modeltools.f.aZr(geo().fZM());
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("imagePreview")) {
      try
      {
        paramString = geo().ISw.j(18, new Bundle());
        j.a(paramBundle, geo().pGj, paramString, geo().Jig);
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
    if (paramString.equals("closeImagePreview"))
    {
      j.c(geo().mHh);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onTranslateFinish"))
    {
      geo().Jjp.fZn();
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("onTranslateStart"))
    {
      paramString = geo().Jjp;
      paramBundle = geo();
      if ((paramString.tipDialog != null) && (paramString.tipDialog.isShowing()))
      {
        paramString.tipDialog.dismiss();
        paramString.tipDialog = null;
      }
      paramBundle.getString(2131755998);
      paramString.tipDialog = h.a(paramBundle, paramBundle.getString(2131768603), true, null);
      AppMethodBeat.o(79576);
      return null;
    }
    if (paramString.equals("onGetTranslateString"))
    {
      paramString = (HashMap)paramBundle.getSerializable("translate_hashmap");
      geo().Jjp.a(geo().pGj, paramString);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
    }
    if (paramString.equals("onGetSampleString"))
    {
      paramString = (HashMap)paramBundle.getSerializable("sample_hashmap");
      paramBundle = geo().Jjp;
      geo();
      Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString in");
      paramBundle.IJx = new LinkedList();
      paramBundle.IJx.addAll(paramString.values());
      paramBundle.IJC.countDown();
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
    geo().Jjw.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(79582);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(79581);
    geo().Jjw.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(79581);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(79584);
    if (geo().getIntent().getBooleanExtra("show_long_click_popup_menu", true))
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
    boolean bool = geo().Jjw.B(paramMotionEvent);
    AppMethodBeat.o(79577);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(79580);
    paramBoolean = geo().Jjw.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(79580);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */