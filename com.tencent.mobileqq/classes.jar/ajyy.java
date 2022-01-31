import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class ajyy
  implements View.OnLayoutChangeListener
{
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Rect b = new Rect();
  
  public ajyy(WebViewFragment paramWebViewFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.b);
    paramView.getWindowVisibleDisplayFrame(this.b);
    if (this.jdField_a_of_type_AndroidGraphicsRect.width() == this.b.width())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a == null) {
        break label100;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a.a();
      if (paramView != null)
      {
        paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.height() - this.b.height();
        if (paramInt1 >= -100) {
          break label105;
        }
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.g, 8589934614L, null);
      }
    }
    label100:
    label105:
    while (paramInt1 <= 100)
    {
      return;
      paramView = null;
      break;
    }
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.g, 8589934613L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajyy
 * JD-Core Version:    0.7.0.1
 */