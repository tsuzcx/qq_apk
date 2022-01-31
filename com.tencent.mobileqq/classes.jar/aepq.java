import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.MultiMsgPicsUploadAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

public class aepq
  extends UiCallBack.MultiMsgPicsUploadAdapter
{
  public aepq(MixedMsgManager paramMixedMsgManager, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  private boolean a(MessageForPic paramMessageForPic, PicResult paramPicResult)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    String str = "";
    if (paramPicResult.jdField_a_of_type_JavaLangObject != null) {
      if ((paramPicResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.NotOnlineImage))
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramPicResult.jdField_a_of_type_JavaLangObject);
        if (paramPicResult.b)
        {
          if (!localElem.not_online_image.res_id.has()) {
            break label274;
          }
          str = localElem.not_online_image.res_id.get().toStringUtf8();
        }
      }
    }
    for (;;)
    {
      paramMessageForPic.uuid = str;
      paramMessageForPic.path = str;
      paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
      paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
      paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
      paramMessageForPic.md5 = FileUtils.b(MixedMsgManager.a());
      paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, " pic resp uuid = " + str + " picMsgMD5 = " + paramMessageForPic.md5 + " hasCode = " + paramMessageForPic.hashCode());
      }
      int i = 1;
      label227:
      boolean bool;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "updateMessageForPic success");
        }
        localRichText.elems.add(localElem);
        if (paramPicResult.jdField_a_of_type_Int == 0) {
          bool = true;
        }
      }
      for (;;)
      {
        paramMessageForPic.richText = localRichText;
        return bool;
        label274:
        if (!localElem.not_online_image.download_path.has()) {
          break label489;
        }
        str = localElem.not_online_image.download_path.get().toStringUtf8();
        break;
        if ((paramPicResult.jdField_a_of_type_JavaLangObject instanceof im_msg_body.CustomFace))
        {
          localElem.custom_face.set((im_msg_body.CustomFace)paramPicResult.jdField_a_of_type_JavaLangObject);
          if (paramPicResult.b)
          {
            if (localElem.custom_face.str_file_path.has()) {
              str = localElem.custom_face.str_file_path.get();
            }
            paramMessageForPic.path = str;
            paramMessageForPic.uuid = str;
            paramMessageForPic.md5 = FileUtils.b(MixedMsgManager.a());
            paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
          }
          i = 1;
          break label227;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MixedMsgManager", 2, "WTF, picResult.mExtraObj is " + paramPicResult.jdField_a_of_type_JavaLangObject.getClass().getSimpleName());
        }
        i = 0;
        break label227;
        if (QLog.isColorLevel())
        {
          QLog.e("MixedMsgManager", 2, "[requestUploadPics] Bad picture element");
          bool = false;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("MixedMsgManager", 2, "updateMessageForPic failed, add empty element");
          }
        }
        bool = false;
      }
      label489:
      str = "";
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
    int j;
    boolean bool2;
    if (localMessageForMixedMsg.msgElemList != null)
    {
      int i = 0;
      j = 0;
      boolean bool1 = true;
      bool2 = bool1;
      if (j >= localMessageForMixedMsg.msgElemList.size()) {
        break label135;
      }
      Object localObject = (MessageRecord)localMessageForMixedMsg.msgElemList.get(j);
      if (!(localObject instanceof MessageForPic)) {
        break label138;
      }
      localObject = (MessageForPic)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "updateMessageForPic for MessageForMixedMsg, subMsgIndex[" + j);
      }
      if (!a((MessageForPic)localObject, (PicResult)paramArrayList.get(i))) {
        bool1 = false;
      }
      i += 1;
    }
    label135:
    label138:
    for (;;)
    {
      j += 1;
      break;
      bool2 = true;
      return bool2;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      boolean bool = a(paramArrayList);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload : isAllPicUploadSuccessful = false ");
        }
        MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "picUpload fail");
        return;
      }
      paramArrayList = new MixedMsg.Msg();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (MessageRecord)localIterator.next();
        MixedMsg.Elem localElem = new MixedMsg.Elem();
        if ((localObject1 instanceof MessageForText))
        {
          if (!TextUtils.isEmpty(((MessageRecord)localObject1).msg)) {
            localElem.textMsg.set(((MessageRecord)localObject1).msg);
          }
        }
        else {
          for (;;)
          {
            paramArrayList.elems.get().add(localElem);
            break;
            Object localObject2;
            if (((MessageRecord)localObject1).msgtype == -2000)
            {
              localObject2 = new RichMsg.PicRec();
              try
              {
                localObject1 = (RichMsg.PicRec)((RichMsg.PicRec)localObject2).mergeFrom(((MessageRecord)localObject1).msgData);
                localElem.picMsg.set((MessageMicro)localObject1);
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
              }
            }
            else if (localInvalidProtocolBufferMicroException.msgtype == -1049)
            {
              try
              {
                MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
                localObject2 = MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo);
                localElem.sourceMsgInfo.set(HexUtil.a((byte[])localObject2));
                if (TextUtils.isEmpty(localMessageForReplyText.msg)) {
                  continue;
                }
                localElem.textMsg.set(localMessageForReplyText.msg);
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, localException.getMessage());
              }
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData = paramArrayList.toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload failed");
    }
    MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "picUpload fail : result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepq
 * JD-Core Version:    0.7.0.1
 */