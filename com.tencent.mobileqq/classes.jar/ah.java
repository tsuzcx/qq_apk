import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class ah
  implements Runnable
{
  ah(ab paramab, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Ab.a.app.a().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!localDataLineMsgRecord.isSendFromLocal());
        this.jdField_a_of_type_Ab.a.app.a().a(this.jdField_a_of_type_Int).e();
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Ab.a.app.a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break;
        }
      } while (this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView));
      this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Ab.a.jdField_a_of_type_ComTencentWidgetXListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ah
 * JD-Core Version:    0.7.0.1
 */