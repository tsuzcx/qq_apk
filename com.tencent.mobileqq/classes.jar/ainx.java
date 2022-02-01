import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ainx
  implements CompoundButton.OnCheckedChangeListener
{
  ainx(ainw paramainw) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.a().e()) {
        this.a.a(true);
      }
      ainw.a(this.a, true);
      ainw.a(this.a).setText(2131718525);
      this.a.a().c(true);
      ainw.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ainw.a(this.a, false);
      ainw.a(this.a).setText(2131718523);
      if ((this.a.a().f()) && (StringUtil.isEmpty(this.a.a.a()))) {
        this.a.a(false);
      }
      this.a.a().c(false);
      ainw.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainx
 * JD-Core Version:    0.7.0.1
 */