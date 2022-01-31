package com.tencent.smtt.export.external.extension.proxy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.HashMap;

public class ProxyWebChromeClientExtension
  implements IX5WebChromeClientExtension
{
  private static boolean sCompatibleNewOnSavePassword = true;
  private static boolean sCompatibleOpenFileChooser = true;
  protected IX5WebChromeClientExtension mWebChromeClient;
  
  public void acquireWakeLock()
  {
    AppMethodBeat.i(63791);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.acquireWakeLock();
    }
    AppMethodBeat.o(63791);
  }
  
  public void addFlashView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(63784);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.addFlashView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(63784);
  }
  
  public void exitFullScreenFlash()
  {
    AppMethodBeat.i(63786);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.exitFullScreenFlash();
    }
    AppMethodBeat.o(63786);
  }
  
  public Context getApplicationContex()
  {
    AppMethodBeat.i(63793);
    if (this.mWebChromeClient != null)
    {
      Context localContext = this.mWebChromeClient.getApplicationContex();
      AppMethodBeat.o(63793);
      return localContext;
    }
    AppMethodBeat.o(63793);
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(63773);
    if (this.mWebChromeClient != null)
    {
      View localView = this.mWebChromeClient.getVideoLoadingProgressView();
      AppMethodBeat.o(63773);
      return localView;
    }
    AppMethodBeat.o(63773);
    return null;
  }
  
  public Object getX5WebChromeClientInstance()
  {
    return this.mWebChromeClient;
  }
  
  public IX5WebChromeClientExtension getmWebChromeClient()
  {
    return this.mWebChromeClient;
  }
  
  public void h5videoExitFullScreen(String paramString)
  {
    AppMethodBeat.i(63790);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.h5videoExitFullScreen(paramString);
    }
    AppMethodBeat.o(63790);
  }
  
  public void h5videoRequestFullScreen(String paramString)
  {
    AppMethodBeat.i(63789);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.h5videoRequestFullScreen(paramString);
    }
    AppMethodBeat.o(63789);
  }
  
  public void jsExitFullScreen()
  {
    AppMethodBeat.i(63788);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.jsExitFullScreen();
    }
    AppMethodBeat.o(63788);
  }
  
  public void jsRequestFullScreen()
  {
    AppMethodBeat.i(63787);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.jsRequestFullScreen();
    }
    AppMethodBeat.o(63787);
  }
  
  public boolean onAddFavorite(IX5WebViewExtension paramIX5WebViewExtension, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(63777);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onAddFavorite(paramIX5WebViewExtension, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(63777);
      return bool;
    }
    AppMethodBeat.o(63777);
    return false;
  }
  
  public void onAllMetaDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(63794);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onAllMetaDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
    AppMethodBeat.o(63794);
  }
  
  public void onBackforwardFinished(int paramInt)
  {
    AppMethodBeat.i(63774);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onBackforwardFinished(paramInt);
    }
    AppMethodBeat.o(63774);
  }
  
  public void onColorModeChanged(long paramLong) {}
  
  public void onHitTestResultFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult)
  {
    AppMethodBeat.i(63776);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHitTestResultFinished(paramIX5WebViewExtension, paramHitTestResult);
    }
    AppMethodBeat.o(63776);
  }
  
  public void onHitTestResultForPluginFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult, Bundle paramBundle)
  {
    AppMethodBeat.i(63775);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHitTestResultForPluginFinished(paramIX5WebViewExtension, paramHitTestResult, paramBundle);
    }
    AppMethodBeat.o(63775);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(63796);
    if (this.mWebChromeClient != null)
    {
      paramString = this.mWebChromeClient.onMiscCallBack(paramString, paramBundle);
      AppMethodBeat.o(63796);
      return paramString;
    }
    AppMethodBeat.o(63796);
    return null;
  }
  
  public boolean onPageNotResponding(Runnable paramRunnable)
  {
    AppMethodBeat.i(63795);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onPageNotResponding(paramRunnable);
      AppMethodBeat.o(63795);
      return bool;
    }
    AppMethodBeat.o(63795);
    return false;
  }
  
  public boolean onPermissionRequest(String paramString, long paramLong, MediaAccessPermissionsCallback paramMediaAccessPermissionsCallback)
  {
    return false;
  }
  
  public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(63778);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPrepareX5ReadPageDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
    AppMethodBeat.o(63778);
  }
  
  public void onPrintPage() {}
  
  public void onPromptNotScalable(IX5WebViewExtension paramIX5WebViewExtension)
  {
    AppMethodBeat.i(63780);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPromptNotScalable(paramIX5WebViewExtension);
    }
    AppMethodBeat.o(63780);
  }
  
  public void onPromptScaleSaved(IX5WebViewExtension paramIX5WebViewExtension)
  {
    AppMethodBeat.i(63779);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPromptScaleSaved(paramIX5WebViewExtension);
    }
    AppMethodBeat.o(63779);
  }
  
  public boolean onSavePassword(ValueCallback<String> paramValueCallback, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(63782);
    if ((this.mWebChromeClient != null) && (sCompatibleNewOnSavePassword)) {
      try
      {
        paramBoolean = this.mWebChromeClient.onSavePassword(paramValueCallback, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean);
        AppMethodBeat.o(63782);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() == null) || (!paramValueCallback.getMessage().contains("onSavePassword")))
        {
          AppMethodBeat.o(63782);
          throw paramValueCallback;
        }
        sCompatibleNewOnSavePassword = false;
      }
    }
    AppMethodBeat.o(63782);
    return false;
  }
  
  public boolean onSavePassword(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Message paramMessage)
  {
    AppMethodBeat.i(63781);
    if (this.mWebChromeClient != null) {
      try
      {
        paramBoolean = this.mWebChromeClient.onSavePassword(paramString1, paramString2, paramString3, paramBoolean, paramMessage);
        AppMethodBeat.o(63781);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramString1) {}
    }
    AppMethodBeat.o(63781);
    return false;
  }
  
  public void onX5ReadModeAvailableChecked(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(63783);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onX5ReadModeAvailableChecked(paramHashMap);
    }
    AppMethodBeat.o(63783);
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(63797);
    if ((this.mWebChromeClient != null) && (sCompatibleOpenFileChooser)) {
      try
      {
        this.mWebChromeClient.openFileChooser(paramValueCallback, paramString1, paramString2);
        AppMethodBeat.o(63797);
        return;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() == null) || (!paramValueCallback.getMessage().contains("openFileChooser")))
        {
          AppMethodBeat.o(63797);
          throw paramValueCallback;
        }
        sCompatibleOpenFileChooser = false;
      }
    }
    AppMethodBeat.o(63797);
  }
  
  public void releaseWakeLock()
  {
    AppMethodBeat.i(63792);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.releaseWakeLock();
    }
    AppMethodBeat.o(63792);
  }
  
  public void requestFullScreenFlash()
  {
    AppMethodBeat.i(63785);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.requestFullScreenFlash();
    }
    AppMethodBeat.o(63785);
  }
  
  public void setWebChromeClientExtend(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    this.mWebChromeClient = paramIX5WebChromeClientExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebChromeClientExtension
 * JD-Core Version:    0.7.0.1
 */