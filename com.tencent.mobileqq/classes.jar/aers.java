import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aers
  implements Runnable
{
  public aers(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, int paramInt1, HashMap paramHashMap, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    MultiMsgManager.a(System.currentTimeMillis());
    Object localObject2;
    if (this.jdField_a_of_type_Int == 5)
    {
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager);
      if (this.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager.a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (this.jdField_a_of_type_Int == 5) {
        break label170;
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localObject2 = ((MultiMsgProxy)localObject1).a((MessageRecord)localObject2, localArrayList1, null, true, bool);
      if (this.jdField_a_of_type_Int == 5) {
        ReceiptUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localObject2 != null) {
        break label296;
      }
      if (this.jdField_a_of_type_Int != 2) {
        break label175;
      }
      ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(8031, false, Integer.valueOf(3));
      return;
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, 0);
      break;
    }
    label175:
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    int i = this.b;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(MessageHandler.c(this.b), false, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    return;
    label296:
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    localObject1 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    int j;
    Iterator localIterator;
    if (this.jdField_a_of_type_Int == 2)
    {
      j = 0;
      localIterator = ((ArrayList)localObject2).iterator();
    }
    label352:
    label484:
    label506:
    Object localObject5;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject4 = (MessageRecord)localIterator.next();
        Object localObject6;
        if ((localObject4 instanceof MessageForPic))
        {
          localObject6 = PicBusiManager.a(7, (MessageForPic)localObject4, j, (String)localObject3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (localObject6 != null)
          {
            if (this.jdField_a_of_type_Int == 5)
            {
              if (this.jdField_a_of_type_AndroidOsBundle == null) {
                break label484;
              }
              i = this.jdField_a_of_type_AndroidOsBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
              label439:
              ((PicFowardInfo)localObject6).jdField_a_of_type_Int = i;
              localObject4 = ((PicFowardInfo)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
              if (i != 2) {
                break label506;
              }
            }
            for (i = 1;; i = 0)
            {
              for (;;)
              {
                ((PicUploadInfo)localObject4).l = i;
                localArrayList2.add(localObject6);
                break label352;
                j = this.b;
                break;
                try
                {
                  i = Integer.valueOf(ReceiptMsgManager.b((MessageRecord)localObject4)).intValue();
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  i = 0;
                }
              }
              break label439;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
          }
        }
        else if ((localNumberFormatException instanceof MessageForMixedMsg))
        {
          localObject5 = PicBusiManager.a(7, (MessageForMixedMsg)localNumberFormatException, j, (String)localObject3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (localObject5 != null) {
            localArrayList2.addAll((Collection)localObject5);
          } else if (QLog.isColorLevel()) {
            QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
          }
        }
        else if (((MessageRecord)localObject5).msgtype == -1036)
        {
          localObject5 = ((MessageForLongMsg)localObject5).longMsgFragmentList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MessageRecord)((Iterator)localObject5).next();
            if ((localObject6 instanceof MessageForMixedMsg))
            {
              localObject6 = PicBusiManager.a(7, (MessageForMixedMsg)localObject6, j, (String)localObject3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              if (localObject6 != null) {
                localArrayList2.addAll((Collection)localObject6);
              }
            }
          }
        }
        else if ((localObject5 instanceof MessageForStructing))
        {
          localObject5 = ((MessageForStructing)localObject5).structingMsg;
          if ((localObject5 != null) && ((localObject5 instanceof StructMsgForImageShare)))
          {
            localObject6 = ((StructMsgForImageShare)localObject5).getFirstImageElement();
            if (localObject6 != null)
            {
              if (((StructMsgItemImage)localObject6).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
              {
                if (((StructMsgItemImage)localObject6).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                  ((StructMsgItemImage)localObject6).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localObject5);
                }
                ((StructMsgItemImage)localObject6).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject6).a();
              }
              localObject5 = PicBusiManager.a(7, ((StructMsgItemImage)localObject6).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.b, (String)localObject3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              if (localObject5 != null) {
                localArrayList2.add(localObject5);
              } else if (QLog.isColorLevel()) {
                QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
              }
            }
          }
        }
        else if ((localObject5 instanceof MessageForShortVideo))
        {
          localObject6 = ShortVideoUtils.a((MessageForShortVideo)localObject5);
          ((MessageForShortVideo)localObject5).videoFileName = ((String)localObject6);
          if (localObject1 != null) {
            break label1538;
          }
          localObject1 = ShortVideoBusiManager.a(5, 5);
        }
      }
    }
    label1538:
    for (;;)
    {
      localObject5 = ShortVideoBusiManager.a(5, localObject5, (ShortVideoReq)localObject1);
      if (localObject5 != null) {
        localArrayList3.add(localObject5);
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
        }
      }
      if ((!(localObject5 instanceof MessageForPtt)) || (this.jdField_a_of_type_Int != 5)) {
        break label352;
      }
      localArrayList4.add((MessageForPtt)localObject5);
      break label352;
      localObject3 = (ChatMessage)localArrayList1.get(0);
      if (localObject3 != null) {}
      for (i = ((ChatMessage)localObject3).istroop;; i = 0)
      {
        if (i == 0) {
          i = 1;
        }
        for (;;)
        {
          label979:
          if (this.b == 0) {
            j = 1;
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004660", "0X8004660", 0, 0, i + "", j + "", "" + localArrayList1.size(), "" + localArrayList2.size());
            if ((localArrayList2.size() == 0) && (localArrayList3.size() == 0) && (localArrayList4.size() == 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg", 2, "[requestSendMultiMsg]There's not any picture messages, goto onPackAndSendMsg");
              }
              MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, (ArrayList)localObject2, true, this.jdField_a_of_type_Int);
              return;
              if (i == 3000)
              {
                i = 2;
                break label979;
              }
              if (i != 1) {
                break label1528;
              }
              i = 3;
              break label979;
              if (this.b == 3000)
              {
                j = 2;
                continue;
              }
              if (this.b != 1) {
                break label1523;
              }
              j = 3;
              continue;
            }
            if (localArrayList2.size() > 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList2.size() + "], goto requestUploadPics");
              }
              if (this.jdField_a_of_type_Int != 5) {
                break label1512;
              }
              MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, 1);
            }
            for (;;)
            {
              MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (ArrayList)localObject2, localArrayList2, this.jdField_a_of_type_Int);
              if (localArrayList3.size() > 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg", 2, "[requestSendMultiMsg]Upload videos, count is [" + localArrayList3.size() + "], goto requestUploadVideos");
                }
                MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, 2);
                MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (ArrayList)localObject2, localArrayList3, (ShortVideoReq)localObject1, this.jdField_a_of_type_Int);
              }
              if (localArrayList4.size() <= 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg", 2, "[requestSendMultiMsg]Upload ptts, count is [" + localArrayList4.size() + "], goto requestUploadPtts");
              }
              MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (ArrayList)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
              return;
              label1512:
              MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, 1);
            }
            label1523:
            j = 4;
          }
          label1528:
          i = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aers
 * JD-Core Version:    0.7.0.1
 */