import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aerh
  implements auna
{
  WeakReference<aeqz> a;
  
  public aerh(aeqz paramaeqz)
  {
    this.a = new WeakReference(paramaeqz);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(aunb paramaunb)
  {
    if (this.a == null) {}
    label406:
    for (;;)
    {
      return;
      aeqz localaeqz = (aeqz)this.a.get();
      if ((localaeqz != null) && (localaeqz.b != null))
      {
        aeqz.a(localaeqz).removeCallbacks(localaeqz.b);
        localaeqz.b = null;
      }
      if ((paramaunb.jdField_a_of_type_Int == 0) && (paramaunb.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localaeqz == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaeqz.g);
        localObject2 = localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramaunb.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((asju)localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          asua.a().a((HashMap)localObject1, localaeqz.g, localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localaeqz.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(aeqz.a(localaeqz), localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aeqz.a(localaeqz)));
          }
          localaeqz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localaeqz, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localaeqz == null) || (localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label406;
        }
        ((astu)localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localaeqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaunb.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localaeqz == null) {
          break;
        }
        localaeqz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localaeqz));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aerh
 * JD-Core Version:    0.7.0.1
 */