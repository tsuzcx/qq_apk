import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.MultiForwardUploadAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

public class aejk
  extends UiCallBack.MultiForwardUploadAdapter
{
  public aejk(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap paramHashMap, int paramInt2) {}
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    int i;
    int k;
    int j;
    MessageRecord localMessageRecord;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "onMultiForwardVideoUploadResult success[" + paramArrayList.size() + "]");
      }
      i = 0;
      k = 0;
      paramInt = 0;
      j = paramInt;
      if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label278;
      }
      localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (!(localMessageRecord instanceof MessageForShortVideo)) {
        break label363;
      }
      if (i >= paramArrayList.size())
      {
        QLog.e("MultiMsg", 1, "MultiForwardVideo: error index!");
        j = i;
        i = paramInt;
        paramInt = j;
      }
    }
    for (;;)
    {
      k += 1;
      j = i;
      i = paramInt;
      paramInt = j;
      break;
      ShortVideoResult localShortVideoResult = (ShortVideoResult)paramArrayList.get(i);
      j = paramInt;
      if (localShortVideoResult != null)
      {
        if ((localShortVideoResult.jdField_a_of_type_Int != 0) || (localShortVideoResult.jdField_a_of_type_JavaLangObject == null) || (!(localShortVideoResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.RichText))) {
          break label213;
        }
        ((MessageForShortVideo)localMessageRecord).richText = ((im_msg_body.RichText)localShortVideoResult.jdField_a_of_type_JavaLangObject);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = i + 1;
        i = j;
        break;
        label213:
        j = paramInt;
        if (localShortVideoResult.jdField_a_of_type_Int == -1)
        {
          j = paramInt;
          if (localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
          {
            j = paramInt;
            if ("cancel".equals(localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b)) {
              j = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "onMultiForwardVideoUploadResult failed!");
      }
      j = 0;
      label278:
      if (j != 0) {
        MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      }
      do
      {
        return;
        MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, 2);
      } while (MultiMsgManager.c(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager) != 0);
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, false, this.b);
      return;
      label363:
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejk
 * JD-Core Version:    0.7.0.1
 */