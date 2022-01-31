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

public class agsw
  implements awiq
{
  WeakReference<agso> a;
  
  public agsw(agso paramagso)
  {
    this.a = new WeakReference(paramagso);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(awir paramawir)
  {
    if (this.a == null) {}
    label409:
    for (;;)
    {
      return;
      agso localagso = (agso)this.a.get();
      if ((localagso != null) && (localagso.b != null))
      {
        agso.a(localagso).removeCallbacks(localagso.b);
        localagso.b = null;
      }
      if ((paramawir.jdField_a_of_type_Int == 0) && (paramawir.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localagso == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localagso.g);
        localObject2 = localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramawir.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((aufc)localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          aupg.a().a((HashMap)localObject1, localagso.g, localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localagso.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(agso.a(localagso), localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - agso.a(localagso)));
          }
          localagso.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localagso, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localagso == null) || (localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label409;
        }
        ((aupa)localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramawir.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localagso == null) {
          break;
        }
        localagso.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localagso));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsw
 * JD-Core Version:    0.7.0.1
 */