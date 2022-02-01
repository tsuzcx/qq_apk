import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aakv
  implements View.OnClickListener
{
  public aakv(SubscribeQRCodeShareHelper.3 param3) {}
  
  public void onClick(View paramView)
  {
    aakt.a(this.a.this$0).dismiss();
    aakt.a(this.a.this$0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakv
 * JD-Core Version:    0.7.0.1
 */