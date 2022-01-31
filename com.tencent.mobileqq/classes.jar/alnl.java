import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class alnl
  implements Runnable
{
  public alnl(QidianHandler paramQidianHandler, ToServiceMsg paramToServiceMsg, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getString("extUin");
      long l = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getLong("uinseq");
      int i = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getInt("uinType");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = this.jdField_a_of_type_ComTencentQidianControllerQidianHandler.b.a().b((String)localObject, i, l);
        if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)localObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.a != null))
          {
            ((MessageForUniteGrayTip)localObject).tipParam.a.clear();
            ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(this.jdField_a_of_type_ComTencentQidianControllerQidianHandler.b);
            this.jdField_a_of_type_ComTencentQidianControllerQidianHandler.a(1005, true, this.jdField_a_of_type_JavaUtilHashMap);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(QidianHandler.a(), 2, "handleBlockBulkMsg ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnl
 * JD-Core Version:    0.7.0.1
 */