import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import mqq.os.MqqHandler;

public class akcd
  implements View.OnClickListener
{
  public akcd(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akcd
 * JD-Core Version:    0.7.0.1
 */