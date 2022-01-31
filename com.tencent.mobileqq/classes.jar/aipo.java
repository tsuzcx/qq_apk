import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.AppInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class aipo
  implements BusinessObserver
{
  aipo(aipn paramaipn) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|isSuccess=" + paramBoolean + ",time=" + (System.currentTimeMillis() - ForwardSdkShareProcessor.b(this.a.b)));
    }
    i = -1;
    paramInt = i;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        paramInt = i;
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse;
        if (paramBundle != null)
        {
          localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localGetAppinfoResponse.mergeFrom(paramBundle);
          paramInt = localGetAppinfoResponse.ret.get();
        }
        paramInt = i;
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|ret=" + paramInt);
          }
          if (paramInt == 0)
          {
            ForwardSdkShareProcessor.a(this.a.b).d = Share.a(localGetAppinfoResponse.iconsURL, 16);
            ForwardSdkShareProcessor.a(this.a.b).e = Share.a(localGetAppinfoResponse.iconsURL, 100);
            if (localGetAppinfoResponse.androidInfo != null)
            {
              paramBundle = localGetAppinfoResponse.androidInfo;
              if (paramBundle.packName.has()) {
                ForwardSdkShareProcessor.a(this.a.b).jdField_a_of_type_JavaLangString = paramBundle.packName.get();
              }
              if (paramBundle.messagetail.has()) {
                ForwardSdkShareProcessor.a(this.a.b).b = paramBundle.messagetail.get();
              }
              if ((paramBundle.sourceUrl.has()) && (ForwardSdkShareProcessor.a(this.a.b) != Long.parseLong("1103584836"))) {
                ForwardSdkShareProcessor.a(this.a.b).c = paramBundle.sourceUrl.get();
              }
            }
            ForwardSdkShareProcessor.a(this.a.b).jdField_a_of_type_Int = 1;
            paramBundle = this.a.b.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.b.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.a.b.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.a.b.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            if ((paramBundle != null) && ((paramBundle instanceof MessageForStructing)) && ((((MessageForStructing)paramBundle).structingMsg instanceof AbsShareMsg)))
            {
              paramBundle = (AbsShareMsg)((MessageForStructing)paramBundle).structingMsg;
              paramBundle.mSource_A_ActionData = ForwardSdkShareProcessor.a(this.a.b).jdField_a_of_type_JavaLangString;
              paramBundle.mSourceName = ForwardSdkShareProcessor.a(this.a.b).b;
              paramBundle.mSourceIcon = ForwardSdkShareProcessor.a(this.a.b).d;
              paramBundle.mSourceUrl = ForwardSdkShareProcessor.a(this.a.b).c;
              paramBundle.shareData.appInfoStatus = 1;
              this.a.b.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.a.b.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.a.b.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, paramBundle.getBytes());
              this.a.b.d(1002);
            }
          }
          if ((ForwardSdkShareProcessor.a(this.a.b).jdField_a_of_type_Int == 1) || (aipn.a(this.a) >= 2) || (paramInt == 110507) || (paramInt == 110401)) {
            break;
          }
          aipn.b(this.a);
          this.a.d();
          return;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            i = paramInt;
          }
        }
        paramBundle = paramBundle;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("Q.share.ForwardSdkShareProcessor", 2, paramBundle, new Object[0]);
        paramInt = i;
      }
    }
    aipn.a(this.a).set(true);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipo
 * JD-Core Version:    0.7.0.1
 */