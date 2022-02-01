import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class aefr
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  public aefr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Looper.myQueue().addIdleHandler(new aefs(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefr
 * JD-Core Version:    0.7.0.1
 */