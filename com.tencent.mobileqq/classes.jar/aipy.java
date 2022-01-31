import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class aipy
  implements Runnable
{
  aipy(aipx paramaipx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,retry=" + aipx.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get()) && (TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", ForwardSdkShareProcessor.e(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
      ((Bundle)localObject).putString("intext_4", "" + i);
      ReportCenter.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      localObject = new Bundle();
      HashMap localHashMap = HttpUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_AndroidContentContext, str, ForwardSdkShareProcessor.f(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), 1, ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      aipx.b(this.a).set(((Bundle)localObject).getInt("retcode", -1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,suc=" + bool + ",ret=" + aipx.b(this.a) + ",cost=" + l);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "12");
      localBundle.putString("intext_3", "0");
      if (!bool) {
        break label1060;
      }
      localObject = "0";
      label386:
      localBundle.putString("intext_1", (String)localObject);
      localBundle.putString("intext_2", "" + aipx.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", ForwardSdkShareProcessor.e(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
      }
      ReportCenter.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1068;
      }
      ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).putAll(localHashMap);
      ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).set(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,url=" + ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).toString());
      }
      localObject = (String)ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get("imageUrl");
      if (localObject != null) {
        ShareProcessorUtil.a(false, ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), (String)localObject);
      }
    }
    label1060:
    label1068:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + aipx.b(this.a) + ",cost=" + l + ",url=" + ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).toString());
      }
      localObject = this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).length();
      break;
      localObject = "1";
      break label386;
      if ((aipx.b(this.a).get() == 100000) && (ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) < 2))
      {
        ForwardSdkShareProcessor.d(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor);
        ForwardSdkShareProcessor.d(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, null);
        ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, true);
        ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor);
        return;
      }
    } while ((aipx.b(this.a).get() != -1) || (aipx.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipy
 * JD-Core Version:    0.7.0.1
 */