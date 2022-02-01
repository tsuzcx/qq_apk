import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aijs
  implements View.OnClickListener
{
  aijs(aijr paramaijr) {}
  
  public void onClick(View paramView)
  {
    aijr.a(this.a);
    bdla.b(null, "dc00898", "", "", "0X800B034", "0X800B034", 0, 0, "", "", aijr.a(this.a).curFriendUin, "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijs
 * JD-Core Version:    0.7.0.1
 */