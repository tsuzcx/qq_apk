import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aegn
  implements atpa
{
  long jdField_a_of_type_Long;
  WeakReference<aege> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aegn(aege paramaege, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaege);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(atpb paramatpb)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aege localaege;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localaege = (aege)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localaege != null) && (localaege.b != null))
          {
            aege.a(localaege).removeCallbacks(localaege.b);
            localaege.b = null;
          }
          if ((paramatpb.jdField_a_of_type_Int != 0) || (paramatpb.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localaege == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaege.jdField_g_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new awui(StructMsgForGeneralShare.class).c(35).a(ajjy.a(2131641213)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localaege.jdField_g_of_type_JavaLangString).a();
            localObject = awbi.a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramatpb.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      arxu.a().a(localHashMap, localaege.jdField_g_of_type_Long, localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramatpb = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramatpb.add((ChatMessage)((Iterator)localObject).next());
      }
      localaege.b(paramatpb);
      localObject = ChatActivityUtils.a(aege.a(localaege), localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aege.a(localaege)));
      }
      arxu.a().a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aege.a(localaege), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramatpb = aael.a(localaege.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramatpb, localHashMap, true);
        aege.a(localaege, awbi.a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramatpb));
        paramatpb = (awul)paramatpb.mStructMsgItemLists.get(0);
        if ((paramatpb instanceof awum))
        {
          paramatpb = (awul)((awum)paramatpb).a.get(0);
          if ((paramatpb instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramatpb).a(localaege.h);
          }
        }
      }
      localaege.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localaege, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localaege == null);
    arxu.a().a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localaege.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localaege));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegn
 * JD-Core Version:    0.7.0.1
 */