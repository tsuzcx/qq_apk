import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class ak
  implements Runnable
{
  ak(ab paramab, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    ((ClipboardManager)this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", this.jdField_a_of_type_JavaLangString));
    LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Ab.a.app.a().a(this.jdField_a_of_type_Int).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ak
 * JD-Core Version:    0.7.0.1
 */