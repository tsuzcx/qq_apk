import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;

public class akun
  implements View.OnClickListener
{
  public akun(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onClick(View paramView)
  {
    if (SwiftIphoneTitleBarUI.a(this.a) != null) {
      SwiftIphoneTitleBarUI.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akun
 * JD-Core Version:    0.7.0.1
 */