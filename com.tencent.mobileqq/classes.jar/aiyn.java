import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiyn
  implements CompoundButton.OnCheckedChangeListener
{
  aiyn(aiym paramaiym) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.a().e()) {
        this.a.a(true);
      }
      aiym.a(this.a, true);
      aiym.a(this.a).setText(2131717900);
      this.a.a().c(true);
      aiym.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      aiym.a(this.a, false);
      aiym.a(this.a).setText(2131717898);
      if ((this.a.a().f()) && (bhsr.a(this.a.a.a()))) {
        this.a.a(false);
      }
      this.a.a().c(false);
      aiym.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyn
 * JD-Core Version:    0.7.0.1
 */