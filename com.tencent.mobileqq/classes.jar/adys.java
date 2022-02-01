import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adys
  extends anvn
{
  public adys(BaseChatPie paramBaseChatPie) {}
  
  protected void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    if (this.a.A()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
        return;
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
      return;
    } while (this.a.jdField_a_of_type_Aivw == null);
    this.a.jdField_a_of_type_Aivw.a(paramArrayList);
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Aggs != null)) {
      this.a.jdField_a_of_type_Aggs.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adys
 * JD-Core Version:    0.7.0.1
 */