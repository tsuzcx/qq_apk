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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
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
  private final WeakReference<WebViewUI> DWm;
  
  public b(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79575);
    this.DWm = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(79575);
  }
  
  private WebViewUI eRK()
  {
    AppMethodBeat.i(79585);
    WebViewUI localWebViewUI = (WebViewUI)this.DWm.get();
    AppMethodBeat.o(79585);
    return localWebViewUI;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(79583);
    eRK().Eeb.bpf();
    AppMethodBeat.o(79583);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79579);
    boolean bool = eRK().Eeb.y(paramMotionEvent);
    AppMethodBeat.o(79579);
    return bool;
  }
  
  public void invalidate() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(79578);
    boolean bool = eRK().Eeb.z(paramMotionEvent);
    AppMethodBeat.o(79578);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(79576);
    boolean bool1;
    boolean bool2;
    if (paramBundle == null)
    {
      bool1 = true;
      if ((eRK() != null) && (eRK().lvv != null)) {
        break label123;
      }
      bool2 = true;
      label35:
      ad.i("MicroMsg.WebViewLongClickHelper", "method = %s, bundler == null ? %b, invoker == null ? %b", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bt.isNullOrNil(paramString)) && (paramBundle != null)) {
        if ((eRK() != null) && (!eRK().isFinishing())) {
          break label129;
        }
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (eRK().lvv != null)) {
        break label134;
      }
      AppMethodBeat.o(79576);
      return null;
      bool1 = false;
      break;
      label123:
      bool2 = false;
      break label35;
    }
    try
    {
      label134:
      String str1 = eRK().lvv.aIv("WebviewEnableTbsDownload");
      ad.i("MicroMsg.WebViewLongClickHelper", "enable value = %s", new Object[] { str1 });
      if ((!bt.isNullOrNil(str1)) && (str1.equals("0")))
      {
        ad.e("MicroMsg.WebViewLongClickHelper", "config closed, not allows tbs download");
        AppMethodBeat.o(79576);
        return null;
      }
    }
    catch (Exception localException1)
    {
      Bundle localBundle1;
      for (;;)
      {
        ad.e("MicroMsg.WebViewLongClickHelper", "get dynamic config failed");
        localBundle1 = null;
      }
      if (paramString.equals("addDownloadTask")) {
        try
        {
          localBundle1 = eRK().lvv.k(14, paramBundle);
          if (localBundle1 != null)
          {
            long l = localBundle1.getLong("download_id", 0L);
            AppMethodBeat.o(79576);
            return Long.valueOf(l);
          }
        }
        catch (RemoteException localRemoteException1)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "invoke the add downloadtask failed");
        }
      }
      if (paramString.equals("cancelDownloadTask")) {
        try
        {
          Bundle localBundle2 = eRK().lvv.k(16, paramBundle);
          if (localBundle2 != null)
          {
            bool1 = localBundle2.getBoolean("cancel_result", false);
            AppMethodBeat.o(79576);
            return Boolean.valueOf(bool1);
          }
        }
        catch (RemoteException localRemoteException2)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "invoke the cancel downloadtask failed");
        }
      }
      if (paramString.equals("queryDownloadTask")) {
        try
        {
          Bundle localBundle3 = eRK().lvv.k(15, paramBundle);
          if (localBundle3 != null)
          {
            i = localBundle3.getInt("download_state", 0);
            AppMethodBeat.o(79576);
            return Integer.valueOf(i);
          }
        }
        catch (RemoteException localRemoteException3)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "invoke the queryDownloadTask downloadtask failed");
        }
      }
      if (paramString.equals("installDownloadTask")) {
        try
        {
          Bundle localBundle4 = eRK().lvv.k(17, paramBundle);
          if (localBundle4 != null)
          {
            bool1 = localBundle4.getBoolean("install_result");
            AppMethodBeat.o(79576);
            return Boolean.valueOf(bool1);
          }
        }
        catch (RemoteException localRemoteException4)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "invoke the install downloadtask failed");
        }
      }
      String str2;
      if (paramString.equals("getDrawable"))
      {
        str2 = paramBundle.getString("packageName");
        i = paramBundle.getInt("resourceId");
        if ((!bt.isNullOrNil(str2)) && (i > 0)) {
          try
          {
            Drawable localDrawable = com.tencent.mm.cd.b.f(aj.getContext().getPackageManager().getResourcesForApplication(str2), i);
            AppMethodBeat.o(79576);
            return localDrawable;
          }
          catch (Exception localException3)
          {
            ad.e("MicroMsg.WebViewLongClickHelper", "get resource for package : %s, fail, : %s", new Object[] { str2, localException3.getMessage() });
          }
        }
      }
      if (paramString.equals("getShareUrl")) {
        try
        {
          str2 = eRK().lvv.aHL(eRK().omW.getUrl());
          ad.i("MicroMsg.WebViewLongClickHelper", "getShareUrl by x5 core, shareurl = %s", new Object[] { str2 });
          AppMethodBeat.o(79576);
          return str2;
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "getShare url failed");
        }
      }
      if (paramString.equals("smartPickWord"))
      {
        if (eRK().getMMTitle() != null) {}
        for (paramString = eRK().getMMTitle().toString();; paramString = "")
        {
          paramString = com.tencent.mm.plugin.webview.modeltools.f.a(paramBundle, eRK().eNy(), paramString);
          AppMethodBeat.o(79576);
          return paramString;
        }
      }
      if (paramString.equals("jumpToSos")) {
        try
        {
          com.tencent.mm.plugin.webview.modeltools.f.aC(paramBundle);
          paramString = eRK().lvv.k(104, paramBundle);
          com.tencent.mm.plugin.webview.modeltools.f.kW(paramBundle.getString("query"), eRK().eNy());
          if (paramString != null)
          {
            bool1 = paramString.getBoolean("open_result");
            AppMethodBeat.o(79576);
            return Boolean.valueOf(bool1);
          }
        }
        catch (RemoteException paramString)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "jumpToSos failed");
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
        com.tencent.mm.plugin.webview.modeltools.f.r(eRK().eNy(), paramBundle);
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
        com.tencent.mm.plugin.webview.modeltools.f.aHT(eRK().eNy());
        AppMethodBeat.o(79576);
        return null;
      }
      if (!paramString.equals("imagePreview")) {}
    }
    try
    {
      paramString = eRK().DNO.k(18, new Bundle());
      j.a(paramBundle, eRK().omW, paramString, eRK().EcL);
      paramString = Boolean.TRUE;
      AppMethodBeat.o(79576);
      return paramString;
      if (paramString.equals("closeImagePreview"))
      {
        j.c(eRK().lvv);
        paramString = Boolean.TRUE;
        AppMethodBeat.o(79576);
        return paramString;
      }
      if (paramString.equals("onTranslateFinish"))
      {
        eRK().EdU.eNd();
        AppMethodBeat.o(79576);
        return null;
      }
      if (paramString.equals("onTranslateStart"))
      {
        paramString = eRK().EdU;
        paramBundle = eRK();
        if ((paramString.tipDialog != null) && (paramString.tipDialog.isShowing()))
        {
          paramString.tipDialog.dismiss();
          paramString.tipDialog = null;
        }
        paramBundle.getString(2131755906);
        paramString.tipDialog = h.b(paramBundle, paramBundle.getString(2131766132), true, null);
        AppMethodBeat.o(79576);
        return null;
      }
      if (paramString.equals("onGetTranslateString"))
      {
        paramString = (HashMap)paramBundle.getSerializable("translate_hashmap");
        eRK().EdU.a(eRK().omW, paramString);
        paramString = Boolean.TRUE;
        AppMethodBeat.o(79576);
        return paramString;
      }
      if (paramString.equals("onGetSampleString"))
      {
        paramString = (HashMap)paramBundle.getSerializable("sample_hashmap");
        paramBundle = eRK().EdU;
        eRK();
        ad.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString in");
        paramBundle.DFJ = new LinkedList();
        paramBundle.DFJ.addAll(paramString.values());
        paramBundle.DFO.countDown();
        ad.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString end");
        paramString = Boolean.TRUE;
        AppMethodBeat.o(79576);
        return paramString;
      }
      AppMethodBeat.o(79576);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(79582);
    eRK().Eeb.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(79582);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(79581);
    eRK().Eeb.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(79581);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(79584);
    if (eRK().getIntent().getBooleanExtra("show_long_click_popup_menu", true))
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
    boolean bool = eRK().Eeb.x(paramMotionEvent);
    AppMethodBeat.o(79577);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(79580);
    paramBoolean = eRK().Eeb.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(79580);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */