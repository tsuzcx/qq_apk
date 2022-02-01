import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aimv
  implements azpp
{
  WeakReference<aimn> a;
  
  public aimv(aimn paramaimn)
  {
    this.a = new WeakReference(paramaimn);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(azpq paramazpq)
  {
    if (this.a == null) {}
    label409:
    for (;;)
    {
      return;
      aimn localaimn = (aimn)this.a.get();
      if ((localaimn != null) && (localaimn.b != null))
      {
        aimn.a(localaimn).removeCallbacks(localaimn.b);
        localaimn.b = null;
      }
      if ((paramazpq.jdField_a_of_type_Int == 0) && (paramazpq.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localaimn == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaimn.e);
        localObject2 = localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramazpq.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((axey)localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          axpf.a().a((HashMap)localObject1, localaimn.e, localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localaimn.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(aimn.a(localaimn), localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aimn.a(localaimn)));
          }
          localaimn.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localaimn, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localaimn == null) || (localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label409;
        }
        ((axoz)localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localaimn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaimn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramazpq.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localaimn == null) {
          break;
        }
        localaimn.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localaimn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimv
 * JD-Core Version:    0.7.0.1
 */