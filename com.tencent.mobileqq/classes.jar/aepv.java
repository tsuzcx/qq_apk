import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class aepv
  implements UpCallBack
{
  protected MessageForMixedMsg a;
  protected String a;
  protected ArrayList a;
  protected Map a;
  
  public aepv(MixedMsgManager paramMixedMsgManager, MessageForMixedMsg paramMessageForMixedMsg, Map paramMap, String paramString, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg = paramMessageForMixedMsg;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString)).intValue();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(i);
    if ((localMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)localMessageRecord).richText = paramRichText;
    }
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject;
    if (paramSendResult.jdField_b_of_type_Int == 0)
    {
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(i);
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        ((MessageForPic)localObject).md5 = paramSendResult.d;
        ((MessageForPic)localObject).uuid = paramSendResult.c;
        ((MessageForPic)localObject).size = paramSendResult.jdField_a_of_type_Long;
        ((MessageForPic)localObject).groupFileID = paramSendResult.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.prewrite();
      }
      if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
      {
        localObject = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList.get(0);
        if ((localObject instanceof MessageForText))
        {
          localObject = (MessageForText)localObject;
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (((MessageForText)localObject).atInfoList == null)) {
            ((MessageForText)localObject).atInfoList = this.jdField_a_of_type_JavaUtilArrayList;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            AnonymousChatHelper.a().a(localMessageRecord);
          }
        }
        MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new ErrorMessage(paramSendResult.jdField_b_of_type_Int, paramSendResult.jdField_a_of_type_JavaLangString);
        QLog.d("zivonchen", 2, "reqUploadMultiPics UiCallBack success result = " + paramSendResult + ", error = " + localObject);
      }
      return;
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "send Msg fail: " + paramSendResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepv
 * JD-Core Version:    0.7.0.1
 */