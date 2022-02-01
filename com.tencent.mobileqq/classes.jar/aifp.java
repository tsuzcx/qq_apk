import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

class aifp
  implements zxa<QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp>
{
  aifp(aifl paramaifl) {}
  
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
        if (aifl.a(this.a) == null) {
          break label280;
        }
        if ((TextUtils.isEmpty(aifl.a(this.a))) || (aifl.a(this.a).equals(paramString))) {
          break label262;
        }
        aifl.a(this.a, paramString);
        if (TextUtils.isEmpty(aifl.a(this.a))) {
          break;
        }
      } while (!vhk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aifl.a(this.a), aifl.a(this.a)));
      this.a.a(aifl.a(this.a), 0);
      vrf.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aifl.a(this.a).msgtype, aifl.a(this.a).uniseq);
      this.a.f(131072);
      return;
      vrf.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
      return;
      aifl.a(this.a, paramString);
    } while (TextUtils.isEmpty(aifl.a(this.a)));
    aifl.a(this.a, vhk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aifl.a(this.a), aifl.a(this.a)));
    vrf.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifp
 * JD-Core Version:    0.7.0.1
 */