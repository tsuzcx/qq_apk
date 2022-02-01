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

public class aidd
  implements ayxc
{
  WeakReference<aicv> a;
  
  public aidd(aicv paramaicv)
  {
    this.a = new WeakReference(paramaicv);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(ayxd paramayxd)
  {
    if (this.a == null) {}
    label409:
    for (;;)
    {
      return;
      aicv localaicv = (aicv)this.a.get();
      if ((localaicv != null) && (localaicv.b != null))
      {
        aicv.a(localaicv).removeCallbacks(localaicv.b);
        localaicv.b = null;
      }
      if ((paramayxd.jdField_a_of_type_Int == 0) && (paramayxd.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localaicv == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaicv.e);
        localObject2 = localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramayxd.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((awmg)localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          awwm.a().a((HashMap)localObject1, localaicv.e, localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localaicv.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(aicv.a(localaicv), localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aicv.a(localaicv)));
          }
          localaicv.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localaicv, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localaicv == null) || (localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label409;
        }
        ((awwg)localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramayxd.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localaicv == null) {
          break;
        }
        localaicv.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localaicv));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidd
 * JD-Core Version:    0.7.0.1
 */