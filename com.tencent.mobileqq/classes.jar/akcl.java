import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import java.util.List;

class akcl
  implements CompoundButton.OnCheckedChangeListener
{
  akcl(akck paramakck) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = ((Integer)paramCompoundButton.getTag()).intValue();
    AppletItem localAppletItem = (AppletItem)this.a.a.get(i);
    akck.a(this.a).a(paramCompoundButton, paramBoolean, localAppletItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcl
 * JD-Core Version:    0.7.0.1
 */