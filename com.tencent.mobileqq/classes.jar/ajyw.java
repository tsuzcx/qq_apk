import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwitchFragmentTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;

public class ajyw
  implements RadioGroup.OnCheckedChangeListener
{
  public ajyw(SwitchFragmentTitleBarUI paramSwitchFragmentTitleBarUI) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    paramInt = this.a.a(paramRadioGroup);
    if (((QQBrowserActivity)this.a.a.a).b != paramInt)
    {
      paramRadioGroup = QQBrowserActivity.a(paramInt, (QQBrowserActivity)this.a.a.a);
      ((QQBrowserActivity)this.a.a.a).b = paramInt;
      if ((paramRadioGroup.a != null) && (paramRadioGroup.a.a != null)) {
        paramRadioGroup.a.a.setSelectedTab(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajyw
 * JD-Core Version:    0.7.0.1
 */