import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahjt
  implements View.OnClickListener
{
  ahjt(ahjq paramahjq) {}
  
  public void onClick(View paramView)
  {
    ahjq.b(this.a);
    bdla.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", ahjq.a(this.a), "个性签名");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjt
 * JD-Core Version:    0.7.0.1
 */