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
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class c
  extends com.tencent.xweb.x5.a.a.a.a.b
{
  private final WeakReference<WebViewUI> uZU;
  
  public c(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(7380);
    this.uZU = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(7380);
  }
  
  private WebViewUI ddt()
  {
    AppMethodBeat.i(7390);
    WebViewUI localWebViewUI = (WebViewUI)this.uZU.get();
    AppMethodBeat.o(7390);
    return localWebViewUI;
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(7388);
    ddt().vga.aGl();
    AppMethodBeat.o(7388);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(7384);
    boolean bool = ddt().vga.B(paramMotionEvent);
    AppMethodBeat.o(7384);
    return bool;
  }
  
  public void invalidate() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(7383);
    boolean bool = ddt().vga.C(paramMotionEvent);
    AppMethodBeat.o(7383);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(7381);
    boolean bool1;
    boolean bool2;
    if (paramBundle == null)
    {
      bool1 = true;
      if ((ddt() != null) && (ddt().igU != null)) {
        break label122;
      }
      bool2 = true;
      label33:
      ab.i("MicroMsg.WebViewLongClickHelper", "method = %s, bundler == null ? %b, invoker == null ? %b", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bo.isNullOrNil(paramString)) && (paramBundle != null)) {
        if ((ddt() != null) && (!ddt().isFinishing())) {
          break label128;
        }
      }
    }
    label128:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (ddt().igU != null)) {
        break label133;
      }
      AppMethodBeat.o(7381);
      return null;
      bool1 = false;
      break;
      label122:
      bool2 = false;
      break label33;
    }
    try
    {
      label133:
      String str1 = ddt().igU.ahS("WebviewEnableTbsDownload");
      ab.i("MicroMsg.WebViewLongClickHelper", "enable value = %s", new Object[] { str1 });
      if ((!bo.isNullOrNil(str1)) && (str1.equals("0")))
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "config closed, not allows tbs download");
        AppMethodBeat.o(7381);
        return null;
      }
    }
    catch (Exception localException1)
    {
      Bundle localBundle1;
      for (;;)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "get dynamic config failed");
        localBundle1 = null;
      }
      if (paramString.equals("addDownloadTask")) {
        try
        {
          localBundle1 = ddt().igU.i(14, paramBundle);
          if (localBundle1 != null)
          {
            long l = localBundle1.getLong("download_id", 0L);
            AppMethodBeat.o(7381);
            return Long.valueOf(l);
          }
        }
        catch (RemoteException localRemoteException1)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "invoke the add downloadtask failed");
        }
      }
      if (paramString.equals("cancelDownloadTask")) {
        try
        {
          Bundle localBundle2 = ddt().igU.i(16, paramBundle);
          if (localBundle2 != null)
          {
            bool1 = localBundle2.getBoolean("cancel_result", false);
            AppMethodBeat.o(7381);
            return Boolean.valueOf(bool1);
          }
        }
        catch (RemoteException localRemoteException2)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "invoke the cancel downloadtask failed");
        }
      }
      if (paramString.equals("queryDownloadTask")) {
        try
        {
          Bundle localBundle3 = ddt().igU.i(15, paramBundle);
          if (localBundle3 != null)
          {
            i = localBundle3.getInt("download_state", 0);
            AppMethodBeat.o(7381);
            return Integer.valueOf(i);
          }
        }
        catch (RemoteException localRemoteException3)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "invoke the queryDownloadTask downloadtask failed");
        }
      }
      if (paramString.equals("installDownloadTask")) {
        try
        {
          Bundle localBundle4 = ddt().igU.i(17, paramBundle);
          if (localBundle4 != null)
          {
            bool1 = localBundle4.getBoolean("install_result");
            AppMethodBeat.o(7381);
            return Boolean.valueOf(bool1);
          }
        }
        catch (RemoteException localRemoteException4)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "invoke the install downloadtask failed");
        }
      }
      String str2;
      if (paramString.equals("getDrawable"))
      {
        str2 = paramBundle.getString("packageName");
        i = paramBundle.getInt("resourceId");
        if ((!bo.isNullOrNil(str2)) && (i > 0)) {
          try
          {
            Drawable localDrawable = com.tencent.mm.cc.b.f(ah.getContext().getPackageManager().getResourcesForApplication(str2), i);
            AppMethodBeat.o(7381);
            return localDrawable;
          }
          catch (Exception localException3)
          {
            ab.e("MicroMsg.WebViewLongClickHelper", "get resource for package : %s, fail, : %s", new Object[] { str2, localException3.getMessage() });
          }
        }
      }
      if (paramString.equals("getShareUrl")) {
        try
        {
          str2 = ddt().igU.agU(ddt().pOd.getUrl());
          ab.i("MicroMsg.WebViewLongClickHelper", "getShareUrl by x5 core, shareurl = %s", new Object[] { str2 });
          AppMethodBeat.o(7381);
          return str2;
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "getShare url failed");
        }
      }
      if (paramString.equals("smartPickWord"))
      {
        if (ddt().getMMTitle() != null) {}
        for (paramString = ddt().getMMTitle().toString();; paramString = "")
        {
          paramString = f.a(paramBundle, ddt().dek(), paramString);
          AppMethodBeat.o(7381);
          return paramString;
        }
      }
      if (paramString.equals("jumpToSos")) {
        try
        {
          f.ad(paramBundle);
          paramString = ddt().igU.i(104, paramBundle);
          f.ht(paramBundle.getString("query"), ddt().dek());
          if (paramString != null)
          {
            bool1 = paramString.getBoolean("open_result");
            AppMethodBeat.o(7381);
            return Boolean.valueOf(bool1);
          }
        }
        catch (RemoteException paramString)
        {
          ab.e("MicroMsg.WebViewLongClickHelper", "jumpToSos failed");
          AppMethodBeat.o(7381);
          return null;
        }
      }
      if (paramString.equals("supportSmartPickWord"))
      {
        paramString = Boolean.TRUE;
        AppMethodBeat.o(7381);
        return paramString;
      }
      if (paramString.equals("onShowSos"))
      {
        f.p(ddt().dek(), paramBundle);
        AppMethodBeat.o(7381);
        return null;
      }
      if (paramString.equals("supportImagePreview"))
      {
        paramString = Boolean.TRUE;
        AppMethodBeat.o(7381);
        return paramString;
      }
      if (paramString.equals("onClickCopyBtn"))
      {
        f.ahB(ddt().dek());
        AppMethodBeat.o(7381);
        return null;
      }
      if (paramString.equals("imagePreview"))
      {
        j.a(paramBundle, ddt().uWu, ddt().ven);
        paramString = Boolean.TRUE;
        AppMethodBeat.o(7381);
        return paramString;
      }
      if (paramString.equals("closeImagePreview"))
      {
        j.d(ddt().igU);
        paramString = Boolean.TRUE;
        AppMethodBeat.o(7381);
        return paramString;
      }
      if (paramString.equals("onTranslateFinish"))
      {
        ddt().vfV.dau();
        AppMethodBeat.o(7381);
        return null;
      }
      if (paramString.equals("onTranslateStart"))
      {
        paramString = ddt().vfV;
        paramBundle = ddt();
        if ((paramString.tipDialog != null) && (paramString.tipDialog.isShowing()))
        {
          paramString.tipDialog.dismiss();
          paramString.tipDialog = null;
        }
        paramBundle.getString(2131297087);
        paramString.tipDialog = h.b(paramBundle, paramBundle.getString(2131305896), true, null);
        AppMethodBeat.o(7381);
        return null;
      }
      if (paramString.equals("onGetTranslateString"))
      {
        paramString = (HashMap)paramBundle.getSerializable("translate_hashmap");
        paramBundle = ddt().vfV;
        paramBundle.uNH = ddt().pOd;
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = paramString.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          String str4 = (String)paramString.get(str3);
          cls localcls = new cls();
          localcls.xVJ = bo.apV(str3);
          localcls.xVK = str4;
          localcls.Scene = 8;
          localLinkedList.add(localcls);
        }
        if (!new q().a(localLinkedList, paramBundle.uNL, paramBundle.uNM))
        {
          paramBundle.dau();
          ab.d("MicroMsg.WebViewTranslateHelper", "translate: BatchGetTranslateString err !!!!");
        }
        paramString = Boolean.TRUE;
        AppMethodBeat.o(7381);
        return paramString;
      }
      if (paramString.equals("onGetSampleString"))
      {
        paramString = (HashMap)paramBundle.getSerializable("sample_hashmap");
        paramBundle = ddt().vfV;
        ddt();
        ab.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString in");
        paramBundle.uNI = new LinkedList();
        paramBundle.uNI.addAll(paramString.values());
        paramBundle.uNN.countDown();
        ab.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString end");
        paramString = Boolean.TRUE;
        AppMethodBeat.o(7381);
        return paramString;
      }
      AppMethodBeat.o(7381);
    }
    return null;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(7387);
    ddt().vga.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(7387);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(7386);
    ddt().vga.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(7386);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(7389);
    if (ddt().getIntent().getBooleanExtra("show_long_click_popup_menu", true))
    {
      AppMethodBeat.o(7389);
      return false;
    }
    AppMethodBeat.o(7389);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(7382);
    boolean bool = ddt().vga.A(paramMotionEvent);
    AppMethodBeat.o(7382);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(7385);
    paramBoolean = ddt().vga.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(7385);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */