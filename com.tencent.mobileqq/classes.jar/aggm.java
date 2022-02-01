import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aggm
  implements View.OnClickListener
{
  public aggm(BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, "vip_card_extension jumpUrl=" + str);
    }
    if (!bhsr.a(str)) {
      VasWebviewUtil.openQQBrowserActivity(this.a.getContext(), str, 256L, null, false, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggm
 * JD-Core Version:    0.7.0.1
 */