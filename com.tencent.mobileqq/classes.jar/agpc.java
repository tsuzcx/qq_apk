import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class agpc
  extends AsyncTask
{
  agpc(agpb paramagpb) {}
  
  protected Void a(Void... paramVarArgs)
  {
    Logger.a(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.a.a.b.get(i);
        localObject2 = (PicResult)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = paramVarArgs;
        if (((PicResult)localObject2).jdField_a_of_type_Int == -2)
        {
          String str = BasePicOprerator.a(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, localPicFowardInfo);
          if (str == null) {
            break label546;
          }
          Logger.a(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new TransferRequest();
          ((TransferRequest)localObject2).jdField_e_of_type_Boolean = false;
          ((TransferRequest)localObject2).jdField_b_of_type_JavaLangString = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          ((TransferRequest)localObject2).c = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
          ((TransferRequest)localObject2).d = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
          ((TransferRequest)localObject2).jdField_a_of_type_Int = this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
          ((TransferRequest)localObject2).jdField_b_of_type_Int = 1;
          ((TransferRequest)localObject2).jdField_a_of_type_Long = (this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + i);
          for (localObject1 = ((TransferRequest)localObject2).c + ((TransferRequest)localObject2).jdField_a_of_type_Long; this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(localObject1); localObject1 = ((TransferRequest)localObject2).c + ((TransferRequest)localObject2).jdField_a_of_type_Long) {
            ((TransferRequest)localObject2).jdField_a_of_type_Long += 100L;
          }
          ((TransferRequest)localObject2).jdField_a_of_type_Boolean = true;
          ((TransferRequest)localObject2).jdField_e_of_type_Int = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int;
          ((TransferRequest)localObject2).i = str;
          localObject1 = new TransferRequest.PicUpExtraInfo();
          if (localPicFowardInfo.jdField_a_of_type_Int < 0)
          {
            ((TransferRequest.PicUpExtraInfo)localObject1).jdField_a_of_type_Boolean = false;
            ((TransferRequest)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
            ((TransferRequest)localObject2).jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new agpd(this, i, str);
            this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localPicFowardInfo.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((TransferRequest.PicUpExtraInfo)localObject1).jdField_a_of_type_Boolean = bool;
          break;
        }
        label546:
        ((PicResult)localObject2).jdField_a_of_type_Int = -1;
        ((PicResult)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        ((PicResult)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString = ("Get target pic filepath of [" + i + "] failed");
        if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int == 1) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int == 3000))
        {
          ((PicResult)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
          label640:
          if (!QLog.isColorLevel()) {
            break label788;
          }
          if (paramVarArgs != null) {
            break label785;
          }
          paramVarArgs = new StringBuilder();
          label658:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((PicResult)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString).append("\n");
        }
      }
    }
    label785:
    label788:
    for (;;)
    {
      agpb.a(this.a);
      if (agpb.a(this.a) == 0) {
        agpa.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((PicResult)localObject2).jdField_a_of_type_JavaLangObject = this.a.a.a(null, null, i);
      break label640;
      if (paramVarArgs != null) {
        Logger.b(this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label658;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpc
 * JD-Core Version:    0.7.0.1
 */