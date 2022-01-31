import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class afwo
  extends ayfl
{
  public afwo(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720140).equals(str))
      {
        paramArrayOfObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((DocsGrayTipsInfo)localObject).a, 0, l);
        if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)paramArrayOfObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.a != null)) {
            ((MessageForUniteGrayTip)localObject).tipParam.a.clear();
          }
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsg(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
          localObject = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramArrayOfObject.uniseq);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).what = 78;
          ((Message)localObject).arg1 = 0;
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        }
      }
      bcpw.a(this.a.getActivity(), str, 0).a();
      QLog.i(ayeb.i, 2, " onGetUserAuth  isSuccess = " + paramBoolean + " tips =" + str);
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      QLog.e(ayeb.i, 2, " onGetUserAuth  exception = " + paramArrayOfObject.toString());
    }
  }
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      QLog.i(ayeb.i, 2, " onSetUserAuth  isSuccess = " + paramBoolean);
      Object localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramArrayOfObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((DocsGrayTipsInfo)localObject).a, 0, l);
        if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)paramArrayOfObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.a != null)) {
            ((MessageForUniteGrayTip)localObject).tipParam.a.clear();
          }
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsg(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
          localObject = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramArrayOfObject.uniseq);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).what = 78;
          ((Message)localObject).arg1 = 0;
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        }
      }
      bcpw.a(this.a.getActivity(), str, 0).a();
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      QLog.e(ayeb.i, 1, " onSetUserAuth  exception  = " + paramArrayOfObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afwo
 * JD-Core Version:    0.7.0.1
 */