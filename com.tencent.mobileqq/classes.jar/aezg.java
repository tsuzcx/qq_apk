import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class aezg
  extends bejh
{
  aezg(ConfessHalfScreenActivity.ConfessBrowserFragment paramConfessBrowserFragment) {}
  
  public void a()
  {
    WebView localWebView;
    if (this.jdField_a_of_type_Behr.a() != null)
    {
      localWebView = this.jdField_a_of_type_Behr.a();
      localWebView.setId(2131380175);
      if (this.b != -1) {
        localWebView.setBackgroundColor(this.b);
      }
      Object localObject = (Activity)localWebView.getContext();
      if ((localObject instanceof ConfessHalfScreenActivity))
      {
        localObject = (ConfessHalfScreenActivity)localObject;
        ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment, ConfessHalfScreenActivity.a((ConfessHalfScreenActivity)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment));
      }
      if (!(this.c instanceof RelativeLayout)) {
        break label171;
      }
      localObject = new RelativeLayout.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.c.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.c.setOnClickListener(new aezh(this));
      return;
      label171:
      this.c.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezg
 * JD-Core Version:    0.7.0.1
 */