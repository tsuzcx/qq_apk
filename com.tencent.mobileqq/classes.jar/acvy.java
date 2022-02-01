import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.activity.ChatActivityFacade.3;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;
import java.util.Locale;

public class acvy
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetC2CFeedRsp>
{
  public acvy(ChatActivityFacade.3 param3) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetC2CFeedRsp paramStGetC2CFeedRsp)
  {
    if (paramBoolean) {
      if (paramStGetC2CFeedRsp != null)
      {
        if ((QLog.isColorLevel()) && (paramStGetC2CFeedRsp.attchInfo != null) && (paramStGetC2CFeedRsp.attchInfo.get() != null)) {
          QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: response.attchInfo==" + paramStGetC2CFeedRsp.attchInfo.get());
        }
        acvv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp, this.a.jdField_a_of_type_Boolean);
        if ((paramStGetC2CFeedRsp.attchInfo != null) && (!StringUtil.isEmpty(paramStGetC2CFeedRsp.attchInfo.get()))) {
          acvv.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp.attchInfo.get());
        }
      }
    }
    for (;;)
    {
      QLog.d("ChatActivityFacade", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + paramVSBaseRequest.getTraceId() + " | SeqId:" + paramVSBaseRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest failed: response==null");
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityFacade.QCircleFeeds", 2, String.format(Locale.getDefault(), "QCircleStGetC2CFeedRequest failed: retCode=%d,errMsg=%s", new Object[] { Long.valueOf(paramLong), paramString }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvy
 * JD-Core Version:    0.7.0.1
 */