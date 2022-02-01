import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class amaz
  implements CompoundButton.OnCheckedChangeListener
{
  amaz(amay paramamay) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = ((Integer)paramCompoundButton.getTag()).intValue();
    AppletItem localAppletItem = (AppletItem)this.a.a.get(i);
    amay.a(this.a).a(paramCompoundButton, paramBoolean, localAppletItem);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */