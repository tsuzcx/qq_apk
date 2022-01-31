import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ahfh
  implements Runnable
{
  public ahfh(ReceiptMsgManager paramReceiptMsgManager, ArrayList paramArrayList, Bundle paramBundle, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (((localChatMessage instanceof MessageForPic)) && (new File(((MessageForPic)localChatMessage).path).exists()))
      {
        MessageForPic localMessageForPic = (MessageForPic)localChatMessage;
        int i = this.jdField_a_of_type_AndroidOsBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
        ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager, localMessageForPic, i);
        localMessageForPic.md5 = ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager, localMessageForPic.path);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        localOptions.inSampleSize = 1;
        SafeBitmapFactory.decodeFile(localMessageForPic.path, localOptions);
        localMessageForPic.width = localOptions.outWidth;
        localMessageForPic.height = localOptions.outHeight;
        ReceiptMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, Integer.toString(i));
        if (RichMediaUtil.a(localMessageForPic.path))
        {
          localMessageForPic.width = localOptions.outHeight;
          localMessageForPic.height = localOptions.outWidth;
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMsgManager", 2, new Object[] { "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + localOptions.outWidth + ",options.outHeight = " + localOptions.outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height });
          }
        }
      }
    }
    ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager, 2), false, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfh
 * JD-Core Version:    0.7.0.1
 */