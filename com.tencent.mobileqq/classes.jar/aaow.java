import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaow
  implements View.OnClickListener
{
  public aaow(SubscribeQRCodeShareHelper.3 param3) {}
  
  public void onClick(View paramView)
  {
    aaou.a(this.a.this$0).dismiss();
    aaou.a(this.a.this$0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaow
 * JD-Core Version:    0.7.0.1
 */