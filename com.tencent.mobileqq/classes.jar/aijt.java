import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aijt
  implements View.OnClickListener
{
  aijt(aijr paramaijr) {}
  
  public void onClick(View paramView)
  {
    aijr.b(this.a);
    bdla.b(null, "dc00898", "", "", "0X800B032", "0X800B032", 0, 0, "", "", aijr.a(this.a).curFriendUin, "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijt
 * JD-Core Version:    0.7.0.1
 */