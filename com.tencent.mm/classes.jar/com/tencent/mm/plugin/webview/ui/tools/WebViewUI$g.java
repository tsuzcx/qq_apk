package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x5.a.a.a.a.b;

public class WebViewUI$g
  extends b
{
  public WebViewUI$g(WebViewUI paramWebViewUI) {}
  
  public final void computeScroll(View paramView)
  {
    this.rpH.rpi.alk();
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.rpH.rpi.w(paramMotionEvent);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.rpH.rpi.x(paramMotionEvent);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    boolean bool1;
    boolean bool2;
    if (paramBundle == null)
    {
      bool1 = true;
      if (this.rpH.gGn != null) {
        break label80;
      }
      bool2 = true;
      label20:
      y.i("MicroMsg.WebViewUI", "method = %s, bundler == null ? %b, invoker == null ? %b", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bk.bl(paramString)) && (paramBundle != null) && (this.rpH.gGn != null)) {
        break label86;
      }
    }
    label80:
    label86:
    do
    {
      for (;;)
      {
        return null;
        bool1 = false;
        break;
        bool2 = false;
        break label20;
        try
        {
          String str1 = this.rpH.gGn.SQ("WebviewEnableTbsDownload");
          y.i("MicroMsg.WebViewUI", "enable value = %s", new Object[] { str1 });
          if ((!bk.bl(str1)) && (str1.equals("0")))
          {
            y.e("MicroMsg.WebViewUI", "config closed, not allows tbs download");
            return null;
          }
        }
        catch (Exception localException1)
        {
          Bundle localBundle1;
          for (;;)
          {
            y.e("MicroMsg.WebViewUI", "get dynamic config failed");
            localBundle1 = null;
          }
          if (paramString.equals("addDownloadTask")) {
            try
            {
              localBundle1 = this.rpH.gGn.f(14, paramBundle);
              if (localBundle1 != null)
              {
                long l = localBundle1.getLong("download_id", 0L);
                return Long.valueOf(l);
              }
            }
            catch (RemoteException localRemoteException1)
            {
              y.e("MicroMsg.WebViewUI", "invoke the add downloadtask failed");
            }
          }
          if (paramString.equals("cancelDownloadTask")) {
            try
            {
              Bundle localBundle2 = this.rpH.gGn.f(16, paramBundle);
              if (localBundle2 != null)
              {
                bool1 = localBundle2.getBoolean("cancel_result", false);
                return Boolean.valueOf(bool1);
              }
            }
            catch (RemoteException localRemoteException2)
            {
              y.e("MicroMsg.WebViewUI", "invoke the cancel downloadtask failed");
            }
          }
          int i;
          if (paramString.equals("queryDownloadTask")) {
            try
            {
              Bundle localBundle3 = this.rpH.gGn.f(15, paramBundle);
              if (localBundle3 != null)
              {
                i = localBundle3.getInt("download_state", 0);
                return Integer.valueOf(i);
              }
            }
            catch (RemoteException localRemoteException3)
            {
              y.e("MicroMsg.WebViewUI", "invoke the queryDownloadTask downloadtask failed");
            }
          }
          if (paramString.equals("installDownloadTask")) {
            try
            {
              Bundle localBundle4 = this.rpH.gGn.f(17, paramBundle);
              if (localBundle4 != null)
              {
                bool1 = localBundle4.getBoolean("install_result");
                return Boolean.valueOf(bool1);
              }
            }
            catch (RemoteException localRemoteException4)
            {
              y.e("MicroMsg.WebViewUI", "invoke the install downloadtask failed");
            }
          }
          String str2;
          if (paramString.equals("getDrawable"))
          {
            str2 = paramBundle.getString("packageName");
            i = paramBundle.getInt("resourceId");
            if ((!bk.bl(str2)) && (i > 0)) {
              try
              {
                Drawable localDrawable = a.d(this.rpH.getPackageManager().getResourcesForApplication(str2), i);
                return localDrawable;
              }
              catch (Exception localException3)
              {
                y.e("MicroMsg.WebViewUI", "get resource for package : %s, fail, : %s", new Object[] { str2, localException3.getMessage() });
              }
            }
          }
          if (paramString.equals("getShareUrl")) {
            try
            {
              str2 = this.rpH.gGn.RR(this.rpH.niQ.getUrl());
              y.i("MicroMsg.WebViewUI", "getShareUrl by x5 core, shareurl = %s", new Object[] { str2 });
              return str2;
            }
            catch (Exception localException2)
            {
              y.e("MicroMsg.WebViewUI", "getShare url failed");
            }
          }
          if (paramString.equals("smartPickWord")) {
            return f.M(paramBundle);
          }
          if (paramString.equals("jumpToSos")) {
            try
            {
              paramString = this.rpH.gGn.f(104, paramBundle);
              f.fw(paramBundle.getString("query"), this.rpH.cdR());
              if (paramString == null) {
                continue;
              }
              bool1 = paramString.getBoolean("open_result");
              return Boolean.valueOf(bool1);
            }
            catch (RemoteException paramString)
            {
              y.e("MicroMsg.WebViewUI", "jumpToSos failed");
              return null;
            }
          } else if (paramString.equals("supportSmartPickWord")) {
            return Boolean.valueOf(true);
          }
        }
      }
    } while (!paramString.equals("onShowSos"));
    f.SH(this.rpH.cdR());
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    this.rpH.rpi.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.rpH.rpi.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public final boolean onShowLongClickPopupMenu()
  {
    boolean bool = true;
    if (this.rpH.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.rpH.rpi.v(paramMotionEvent);
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return this.rpH.rpi.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g
 * JD-Core Version:    0.7.0.1
 */