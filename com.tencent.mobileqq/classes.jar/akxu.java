import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class akxu
  implements Runnable
{
  public akxu(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.a);
    localTextView.setBackgroundColor(2130706432);
    localTextView.setTextColor(2147483647);
    StringBuilder localStringBuilder = new StringBuilder().append("当前内核:");
    if (this.jdField_a_of_type_Int == 0) {}
    for (String str = "系统WebView";; str = "x5 " + this.jdField_a_of_type_Int)
    {
      localTextView.setText(str);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.a.addContentView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxu
 * JD-Core Version:    0.7.0.1
 */