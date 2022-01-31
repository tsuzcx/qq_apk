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

public class agoi
  implements aweh
{
  long jdField_a_of_type_Long;
  WeakReference<agnz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public agoi(agnz paramagnz, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagnz);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(awei paramawei)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    agnz localagnz;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localagnz = (agnz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localagnz != null) && (localagnz.b != null))
          {
            agnz.a(localagnz).removeCallbacks(localagnz.b);
            localagnz.b = null;
          }
          if ((paramawei.jdField_a_of_type_Int != 0) || (paramawei.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localagnz == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localagnz.jdField_g_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new azqg(StructMsgForGeneralShare.class).c(35).a(alpo.a(2131707381)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localagnz.jdField_g_of_type_JavaLangString).a();
            localObject = ayvw.a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramawei.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      aukx.a().a(localHashMap, localagnz.jdField_g_of_type_Long, localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramawei = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramawei.add((ChatMessage)((Iterator)localObject).next());
      }
      localagnz.b(paramawei);
      localObject = ChatActivityUtils.a(agnz.a(localagnz), localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localagnz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - agnz.a(localagnz)));
      }
      aukx.a().a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, agnz.a(localagnz), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramawei = acex.a(localagnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramawei, localHashMap, true);
        agnz.a(localagnz, ayvw.a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramawei));
        paramawei = (azqj)paramawei.mStructMsgItemLists.get(0);
        if ((paramawei instanceof azqk))
        {
          paramawei = (azqj)((azqk)paramawei).a.get(0);
          if ((paramawei instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramawei).a(localagnz.h);
          }
        }
      }
      localagnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localagnz, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localagnz == null);
    aukx.a().a(localagnz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localagnz.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localagnz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoi
 * JD-Core Version:    0.7.0.1
 */