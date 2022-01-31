import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;

public class akmw
  implements View.OnClickListener
{
  public akmw(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onClick(View paramView)
  {
    if (SwiftIphoneTitleBarUI.a(this.a) != null) {
      SwiftIphoneTitleBarUI.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmw
 * JD-Core Version:    0.7.0.1
 */