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

public class agoh
  implements aweh
{
  WeakReference<agnz> a;
  
  public agoh(agnz paramagnz)
  {
    this.a = new WeakReference(paramagnz);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(awei paramawei)
  {
    if (this.a == null) {}
    label409:
    for (;;)
    {
      return;
      agnz localagnz = (agnz)this.a.get();
      if ((localagnz != null) && (localagnz.b != null))
      {
        agnz.a(localagnz).removeCallbacks(localagnz.b);
        localagnz.b = null;
      }
      if ((paramawei.jdField_a_of_type_Int == 0) && (paramawei.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localagnz == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localagnz.g);
        localObject2 = localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramawei.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((auat)localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          aukx.a().a((HashMap)localObject1, localagnz.g, localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localagnz.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(agnz.a(localagnz), localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - agnz.a(localagnz)));
          }
          localagnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localagnz, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localagnz == null) || (localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label409;
        }
        ((aukr)localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramawei.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localagnz == null) {
          break;
        }
        localagnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localagnz));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoh
 * JD-Core Version:    0.7.0.1
 */