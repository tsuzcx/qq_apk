import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class aakc
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  public aakc(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Looper.myQueue().addIdleHandler(new aakd(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakc
 * JD-Core Version:    0.7.0.1
 */