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
import com.tencent.smtt.export.external.interfaces.CorePermissionRequest;
import com.tencent.smtt.export.external.interfaces.CorePermissionRequest.CorePermissionRequestCallback;
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
    AppMethodBeat.i(53193);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.acquireWakeLock();
    }
    AppMethodBeat.o(53193);
  }
  
  public void addFlashView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(53186);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.addFlashView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(53186);
  }
  
  public int checkPermission(String paramString)
  {
    return -1;
  }
  
  public void exitFullScreenFlash()
  {
    AppMethodBeat.i(53188);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.exitFullScreenFlash();
    }
    AppMethodBeat.o(53188);
  }
  
  public Context getApplicationContex()
  {
    AppMethodBeat.i(53195);
    if (this.mWebChromeClient != null)
    {
      Context localContext = this.mWebChromeClient.getApplicationContex();
      AppMethodBeat.o(53195);
      return localContext;
    }
    AppMethodBeat.o(53195);
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(53175);
    if (this.mWebChromeClient != null)
    {
      View localView = this.mWebChromeClient.getVideoLoadingProgressView();
      AppMethodBeat.o(53175);
      return localView;
    }
    AppMethodBeat.o(53175);
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
    AppMethodBeat.i(53192);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.h5videoExitFullScreen(paramString);
    }
    AppMethodBeat.o(53192);
  }
  
  public void h5videoRequestFullScreen(String paramString)
  {
    AppMethodBeat.i(53191);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.h5videoRequestFullScreen(paramString);
    }
    AppMethodBeat.o(53191);
  }
  
  public void jsExitFullScreen()
  {
    AppMethodBeat.i(53190);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.jsExitFullScreen();
    }
    AppMethodBeat.o(53190);
  }
  
  public void jsRequestFullScreen()
  {
    AppMethodBeat.i(53189);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.jsRequestFullScreen();
    }
    AppMethodBeat.o(53189);
  }
  
  public boolean onAddFavorite(IX5WebViewExtension paramIX5WebViewExtension, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(53179);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onAddFavorite(paramIX5WebViewExtension, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(53179);
      return bool;
    }
    AppMethodBeat.o(53179);
    return false;
  }
  
  public void onAllMetaDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(53196);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onAllMetaDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
    AppMethodBeat.o(53196);
  }
  
  public void onBackforwardFinished(int paramInt)
  {
    AppMethodBeat.i(53176);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onBackforwardFinished(paramInt);
    }
    AppMethodBeat.o(53176);
  }
  
  public void onColorModeChanged(long paramLong) {}
  
  public boolean onGoToEntryOffset(int paramInt)
  {
    AppMethodBeat.i(53200);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onGoToEntryOffset(paramInt);
      AppMethodBeat.o(53200);
      return bool;
    }
    AppMethodBeat.o(53200);
    return true;
  }
  
  public void onHitTestResultFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult)
  {
    AppMethodBeat.i(53178);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHitTestResultFinished(paramIX5WebViewExtension, paramHitTestResult);
    }
    AppMethodBeat.o(53178);
  }
  
  public void onHitTestResultForPluginFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult, Bundle paramBundle)
  {
    AppMethodBeat.i(53177);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHitTestResultForPluginFinished(paramIX5WebViewExtension, paramHitTestResult, paramBundle);
    }
    AppMethodBeat.o(53177);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(53198);
    if (this.mWebChromeClient != null)
    {
      paramString = this.mWebChromeClient.onMiscCallBack(paramString, paramBundle);
      AppMethodBeat.o(53198);
      return paramString;
    }
    AppMethodBeat.o(53198);
    return null;
  }
  
  public boolean onPageNotResponding(Runnable paramRunnable)
  {
    AppMethodBeat.i(53197);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onPageNotResponding(paramRunnable);
      AppMethodBeat.o(53197);
      return bool;
    }
    AppMethodBeat.o(53197);
    return false;
  }
  
  public boolean onPermissionRequest(String paramString, long paramLong, MediaAccessPermissionsCallback paramMediaAccessPermissionsCallback)
  {
    return false;
  }
  
  public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(53180);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPrepareX5ReadPageDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
    AppMethodBeat.o(53180);
  }
  
  public void onPrintPage() {}
  
  public void onPromptNotScalable(IX5WebViewExtension paramIX5WebViewExtension)
  {
    AppMethodBeat.i(53182);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPromptNotScalable(paramIX5WebViewExtension);
    }
    AppMethodBeat.o(53182);
  }
  
  public void onPromptScaleSaved(IX5WebViewExtension paramIX5WebViewExtension)
  {
    AppMethodBeat.i(53181);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPromptScaleSaved(paramIX5WebViewExtension);
    }
    AppMethodBeat.o(53181);
  }
  
  public boolean onSavePassword(ValueCallback<String> paramValueCallback, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(53184);
    if ((this.mWebChromeClient != null) && (sCompatibleNewOnSavePassword)) {
      try
      {
        paramBoolean = this.mWebChromeClient.onSavePassword(paramValueCallback, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean);
        AppMethodBeat.o(53184);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() == null) || (!paramValueCallback.getMessage().contains("onSavePassword")))
        {
          AppMethodBeat.o(53184);
          throw paramValueCallback;
        }
        sCompatibleNewOnSavePassword = false;
      }
    }
    AppMethodBeat.o(53184);
    return false;
  }
  
  public boolean onSavePassword(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Message paramMessage)
  {
    AppMethodBeat.i(53183);
    if (this.mWebChromeClient != null) {
      try
      {
        paramBoolean = this.mWebChromeClient.onSavePassword(paramString1, paramString2, paramString3, paramBoolean, paramMessage);
        AppMethodBeat.o(53183);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramString1) {}
    }
    AppMethodBeat.o(53183);
    return false;
  }
  
  public void onX5ReadModeAvailableChecked(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(53185);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onX5ReadModeAvailableChecked(paramHashMap);
    }
    AppMethodBeat.o(53185);
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(53199);
    if ((this.mWebChromeClient != null) && (sCompatibleOpenFileChooser)) {
      try
      {
        this.mWebChromeClient.openFileChooser(paramValueCallback, paramString1, paramString2);
        AppMethodBeat.o(53199);
        return;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() == null) || (!paramValueCallback.getMessage().contains("openFileChooser")))
        {
          AppMethodBeat.o(53199);
          throw paramValueCallback;
        }
        sCompatibleOpenFileChooser = false;
      }
    }
    AppMethodBeat.o(53199);
  }
  
  public void releaseWakeLock()
  {
    AppMethodBeat.i(53194);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.releaseWakeLock();
    }
    AppMethodBeat.o(53194);
  }
  
  public boolean requestAPPPermission(CorePermissionRequest paramCorePermissionRequest, CorePermissionRequest.CorePermissionRequestCallback paramCorePermissionRequestCallback)
  {
    return false;
  }
  
  public void requestFullScreenFlash()
  {
    AppMethodBeat.i(53187);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.requestFullScreenFlash();
    }
    AppMethodBeat.o(53187);
  }
  
  public void setWebChromeClientExtend(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    this.mWebChromeClient = paramIX5WebChromeClientExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebChromeClientExtension
 * JD-Core Version:    0.7.0.1
 */