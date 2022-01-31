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

public class aeri
  implements auna
{
  long jdField_a_of_type_Long;
  WeakReference<aeqz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aeri(aeqz paramaeqz, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaeqz);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(aunb paramaunb)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aeqz localaeqz;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localaeqz = (aeqz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localaeqz != null) && (localaeqz.b != null))
          {
            aeqz.a(localaeqz).removeCallbacks(localaeqz.b);
            localaeqz.b = null;
          }
          if ((paramaunb.jdField_a_of_type_Int != 0) || (paramaunb.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localaeqz == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaeqz.jdField_g_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new axum(StructMsgForGeneralShare.class).c(35).a(ajya.a(2131707009)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localaeqz.jdField_g_of_type_JavaLangString).a();
            localObject = axas.a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramaunb.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      asua.a().a(localHashMap, localaeqz.jdField_g_of_type_Long, localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramaunb = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramaunb.add((ChatMessage)((Iterator)localObject).next());
      }
      localaeqz.b(paramaunb);
      localObject = ChatActivityUtils.a(aeqz.a(localaeqz), localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aeqz.a(localaeqz)));
      }
      asua.a().a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aeqz.a(localaeqz), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramaunb = aanz.a(localaeqz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramaunb, localHashMap, true);
        aeqz.a(localaeqz, axas.a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramaunb));
        paramaunb = (axup)paramaunb.mStructMsgItemLists.get(0);
        if ((paramaunb instanceof axuq))
        {
          paramaunb = (axup)((axuq)paramaunb).a.get(0);
          if ((paramaunb instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramaunb).a(localaeqz.h);
          }
        }
      }
      localaeqz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localaeqz, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localaeqz == null);
    asua.a().a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localaeqz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localaeqz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeri
 * JD-Core Version:    0.7.0.1
 */