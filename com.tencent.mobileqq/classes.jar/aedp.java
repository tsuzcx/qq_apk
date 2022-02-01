import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aedp
  implements View.OnClickListener
{
  public aedp(H5MagicPlayerActivity paramH5MagicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    H5MagicPlayerActivity.a(this.a);
    if ((this.a.d.equals(this.a.c)) && (this.a.a != null)) {
      bdla.b(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.a.a.epId, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.a.a.epId, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedp
 * JD-Core Version:    0.7.0.1
 */