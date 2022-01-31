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

public class aegm
  implements atpa
{
  WeakReference<aege> a;
  
  public aegm(aege paramaege)
  {
    this.a = new WeakReference(paramaege);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(atpb paramatpb)
  {
    if (this.a == null) {}
    label406:
    for (;;)
    {
      return;
      aege localaege = (aege)this.a.get();
      if ((localaege != null) && (localaege.b != null))
      {
        aege.a(localaege).removeCallbacks(localaege.b);
        localaege.b = null;
      }
      if ((paramatpb.jdField_a_of_type_Int == 0) && (paramatpb.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localaege == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaege.g);
        localObject2 = localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramatpb.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((arno)localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          arxu.a().a((HashMap)localObject1, localaege.g, localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localaege.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(aege.a(localaege), localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aege.a(localaege)));
          }
          localaege.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localaege, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localaege == null) || (localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label406;
        }
        ((arxo)localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localaege.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaege.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramatpb.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localaege == null) {
          break;
        }
        localaege.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localaege));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegm
 * JD-Core Version:    0.7.0.1
 */