import android.widget.ImageButton;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.util.InputMethodUtil;

public class aizb
  implements Runnable
{
  public aizb(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void run()
  {
    InputMethodUtil.a(this.a.jdField_a_of_type_AndroidWidgetEditText);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    this.a.c.setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizb
 * JD-Core Version:    0.7.0.1
 */