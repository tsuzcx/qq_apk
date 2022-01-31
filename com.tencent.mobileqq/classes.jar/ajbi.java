import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;

public class ajbi
  extends Handler
{
  public ajbi(NewTroopContactView paramNewTroopContactView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbi
 * JD-Core Version:    0.7.0.1
 */