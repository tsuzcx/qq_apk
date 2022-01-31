import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class akye
  implements TouchWebView.OnOverScrollHandler
{
  public akye(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizUiRefreshView.a();
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetTextView.setText("网页由 " + ((Uri)localObject).getHost() + " 提供");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizUiRefreshView.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akye
 * JD-Core Version:    0.7.0.1
 */