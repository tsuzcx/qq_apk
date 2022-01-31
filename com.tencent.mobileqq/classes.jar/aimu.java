import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.qphone.base.util.QLog;

public class aimu
  implements Runnable
{
  public aimu(StructMsgForGeneralShare.GeneralClickHandler paramGeneralClickHandler, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("msgSeq")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("uin")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("sessionType")))
    {
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("msgSeq");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("sessionType");
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare$GeneralClickHandler.a.a();
      localObject = localQQMessageFacade.a((String)localObject, i, l);
      ((MessageRecord)localObject).saveExtInfoToExtStr("receipt_msg_is_read", "1");
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject).extLong));
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extStr", ((MessageRecord)localObject).extStr);
    }
    while (!QLog.isColorLevel())
    {
      long l;
      Object localObject;
      int i;
      QQMessageFacade localQQMessageFacade;
      return;
    }
    QLog.w(StructMsgForGeneralShare.access$000(), 2, "set receipt msg read missing param");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimu
 * JD-Core Version:    0.7.0.1
 */