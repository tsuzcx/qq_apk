import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import mqq.os.MqqHandler;

public class akqk
  implements View.OnClickListener
{
  public akqk(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqk
 * JD-Core Version:    0.7.0.1
 */