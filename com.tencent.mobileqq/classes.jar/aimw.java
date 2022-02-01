import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.2;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class aimw
  implements azpp
{
  long jdField_a_of_type_Long;
  WeakReference<aimn> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aimw(aimn paramaimn, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaimn);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(azpq paramazpq)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aimn localaimn;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localaimn = (aimn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localaimn != null) && (localaimn.b != null))
          {
            aimn.a(localaimn).removeCallbacks(localaimn.b);
            localaimn.b = null;
          }
          if ((paramazpq.jdField_a_of_type_Int != 0) || (paramazpq.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localaimn == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaimn.e);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new bdoi(StructMsgForGeneralShare.class).c(35).a(anzj.a(2131705891)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localaimn.g).a();
            localObject = bcry.a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramazpq.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      axpf.a().a(localHashMap, localaimn.e, localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramazpq = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramazpq.add((ChatMessage)((Iterator)localObject).next());
      }
      localaimn.b(paramazpq);
      localObject = ChatActivityUtils.a(aimn.a(localaimn), localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aimn.a(localaimn)));
      }
      axpf.a().a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aimn.a(localaimn), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramazpq = aean.a(localaimn.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramazpq, localHashMap, true);
        aimn.a(localaimn, bcry.a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramazpq));
        paramazpq = (bdol)paramazpq.mStructMsgItemLists.get(0);
        if ((paramazpq instanceof bdom))
        {
          paramazpq = (bdol)((bdom)paramazpq).a.get(0);
          if ((paramazpq instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramazpq).a(localaimn.h);
          }
        }
      }
      localaimn.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localaimn, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localaimn == null);
    axpf.a().a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localaimn.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localaimn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimw
 * JD-Core Version:    0.7.0.1
 */