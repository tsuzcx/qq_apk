import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

class aipi
  implements aaav<QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp>
{
  aipi(aipe paramaipe) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp paramStGetPMBeginShowMsgRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetPMBeginShowMsgRsp == null)) {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "requestNewestShowFuelTips error:" + paramLong + "  errorMsg:" + paramString);
    }
    label262:
    label280:
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramStGetPMBeginShowMsgRsp.pmBeginShow.has());
        paramString = paramStGetPMBeginShowMsgRsp.pmBeginShow.get();
        if (aipe.a(this.a) == null) {
          break label280;
        }
        if ((TextUtils.isEmpty(aipe.a(this.a))) || (aipe.a(this.a).equals(paramString))) {
          break label262;
        }
        aipe.a(this.a, paramString);
        if (TextUtils.isEmpty(aipe.a(this.a))) {
          break;
        }
      } while (!vjo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aipe.a(this.a), aipe.a(this.a)));
      this.a.a(aipe.a(this.a), 0);
      vtq.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aipe.a(this.a).msgtype, aipe.a(this.a).uniseq);
      this.a.f(131072);
      return;
      vtq.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
      return;
      aipe.a(this.a, paramString);
    } while (TextUtils.isEmpty(aipe.a(this.a)));
    aipe.a(this.a, vjo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aipe.a(this.a), aipe.a(this.a)));
    vtq.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipi
 * JD-Core Version:    0.7.0.1
 */