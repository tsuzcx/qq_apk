import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahlf
  implements View.OnClickListener
{
  ahlf(ahlc paramahlc) {}
  
  public void onClick(View paramView)
  {
    ahlc.b(this.a);
    bcst.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", ahlc.a(this.a), "个性签名");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */