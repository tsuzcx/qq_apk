import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class afzg
  extends SwiftBrowserUIStyleHandler
{
  afzg(ConfessHalfScreenActivity.ConfessBrowserFragment paramConfessBrowserFragment) {}
  
  public void initWebViewInContentView()
  {
    WebView localWebView;
    if (this.mComponentContext.a() != null)
    {
      localWebView = this.mComponentContext.a();
      localWebView.setId(2131381402);
      if (this.mBrowserWebviewColor != -1) {
        localWebView.setBackgroundColor(this.mBrowserWebviewColor);
      }
      Object localObject = (Activity)localWebView.getContext();
      if ((localObject instanceof ConfessHalfScreenActivity))
      {
        localObject = (ConfessHalfScreenActivity)localObject;
        ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.a, ConfessHalfScreenActivity.a((ConfessHalfScreenActivity)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.a));
      }
      if (!(this.webviewWrapper instanceof RelativeLayout)) {
        break label171;
      }
      localObject = new RelativeLayout.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.a));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.webviewWrapper.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.webviewWrapper.setOnClickListener(new afzh(this));
      return;
      label171:
      this.webviewWrapper.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzg
 * JD-Core Version:    0.7.0.1
 */