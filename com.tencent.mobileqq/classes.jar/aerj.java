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

public class aerj
  implements aumy
{
  WeakReference<aerb> a;
  
  public aerj(aerb paramaerb)
  {
    this.a = new WeakReference(paramaerb);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(aumz paramaumz)
  {
    if (this.a == null) {}
    label406:
    for (;;)
    {
      return;
      aerb localaerb = (aerb)this.a.get();
      if ((localaerb != null) && (localaerb.b != null))
      {
        aerb.a(localaerb).removeCallbacks(localaerb.b);
        localaerb.b = null;
      }
      if ((paramaumz.jdField_a_of_type_Int == 0) && (paramaumz.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localaerb == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaerb.g);
        localObject2 = localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramaumz.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((asjs)localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(false, localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          asty.a().a((HashMap)localObject1, localaerb.g, localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localaerb.b((List)localObject1);
          localObject1 = ChatActivityUtils.a(aerb.a(localaerb), localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject1 = ChatActivityUtils.a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aerb.a(localaerb)));
          }
          localaerb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localaerb, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localaerb == null) || (localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label406;
        }
        ((asts)localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaumz.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localaerb == null) {
          break;
        }
        localaerb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localaerb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aerj
 * JD-Core Version:    0.7.0.1
 */