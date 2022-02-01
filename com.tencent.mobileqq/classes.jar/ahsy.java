import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahsy
  implements CompoundButton.OnCheckedChangeListener
{
  ahsy(ahsx paramahsx) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.a().e()) {
        this.a.a(true);
      }
      ahsx.a(this.a, true);
      ahsx.a(this.a).setText(2131718140);
      this.a.a().c(true);
      ahsx.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ahsx.a(this.a, false);
      ahsx.a(this.a).setText(2131718138);
      if ((this.a.a().f()) && (StringUtil.isEmpty(this.a.a.a()))) {
        this.a.a(false);
      }
      this.a.a().c(false);
      ahsx.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsy
 * JD-Core Version:    0.7.0.1
 */