import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahld
  implements View.OnClickListener
{
  ahld(ahlc paramahlc) {}
  
  public void onClick(View paramView)
  {
    ahlc.a(this.a);
    bcst.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", ahlc.a(this.a), "空间");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahld
 * JD-Core Version:    0.7.0.1
 */