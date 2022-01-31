import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.io.File;

class ac
  implements Runnable
{
  ac(ab paramab, int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Ab.a.app.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ab.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView)) {
        this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((DataLineMsgRecord)localObject).fileFrom == 0) && (((DataLineMsgRecord)localObject).path != null) && (((DataLineMsgRecord)localObject).thumbPath != null) && (((DataLineMsgRecord)localObject).path.equals(this.jdField_a_of_type_JavaLangString)))
      {
        localObject = new File(((DataLineMsgRecord)localObject).thumbPath);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      return;
      this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      if ((localObject != null) && (!((DataLineMsgRecord)localObject).bIsResendOrRecvFile))
      {
        LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
        LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ac
 * JD-Core Version:    0.7.0.1
 */