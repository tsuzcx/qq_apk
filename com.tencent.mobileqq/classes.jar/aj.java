import android.content.Context;
import android.text.ClipboardManager;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class aj
  implements Runnable
{
  aj(ab paramab, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    try
    {
      ((ClipboardManager)this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      label41:
      LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
      LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_Ab.a.app.a().a(this.jdField_a_of_type_Int).e();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aj
 * JD-Core Version:    0.7.0.1
 */