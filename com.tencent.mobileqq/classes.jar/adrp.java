import com.tencent.mobileqq.activity.ChatActivityFacade.3;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;
import java.util.Locale;

public class adrp
  implements zxa<FeedCloudRead.StGetC2CFeedRsp>
{
  public adrp(ChatActivityFacade.3 param3) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetC2CFeedRsp paramStGetC2CFeedRsp)
  {
    if (paramBoolean) {
      if (paramStGetC2CFeedRsp != null)
      {
        if ((QLog.isColorLevel()) && (paramStGetC2CFeedRsp.attchInfo != null) && (paramStGetC2CFeedRsp.attchInfo.get() != null)) {
          QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: response.attchInfo==" + paramStGetC2CFeedRsp.attchInfo.get());
        }
        adrm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp, this.a.jdField_a_of_type_Boolean);
        if ((paramStGetC2CFeedRsp.attchInfo != null) && (!bgsp.a(paramStGetC2CFeedRsp.attchInfo.get()))) {
          adrm.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp.attchInfo.get());
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest failed: response==null");
      return;
    }
    QLog.e("ChatActivityFacade.QCircleFeeds", 2, String.format(Locale.getDefault(), "QCircleStGetC2CFeedRequest failed: retCode=%d,errMsg=%s", new Object[] { Long.valueOf(paramLong), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrp
 * JD-Core Version:    0.7.0.1
 */