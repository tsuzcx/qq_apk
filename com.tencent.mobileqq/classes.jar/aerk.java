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

public class aerk
  implements aumy
{
  long jdField_a_of_type_Long;
  WeakReference<aerb> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aerk(aerb paramaerb, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaerb);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(aumz paramaumz)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aerb localaerb;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localaerb = (aerb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localaerb != null) && (localaerb.b != null))
          {
            aerb.a(localaerb).removeCallbacks(localaerb.b);
            localaerb.b = null;
          }
          if ((paramaumz.jdField_a_of_type_Int != 0) || (paramaumz.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localaerb == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaerb.jdField_g_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new axuk(StructMsgForGeneralShare.class).c(35).a(ajyc.a(2131706998)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localaerb.jdField_g_of_type_JavaLangString).a();
            localObject = axaq.a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramaumz.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      asty.a().a(localHashMap, localaerb.jdField_g_of_type_Long, localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramaumz = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramaumz.add((ChatMessage)((Iterator)localObject).next());
      }
      localaerb.b(paramaumz);
      localObject = ChatActivityUtils.a(aerb.a(localaerb), localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaerb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aerb.a(localaerb)));
      }
      asty.a().a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aerb.a(localaerb), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramaumz = aaod.a(localaerb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramaumz, localHashMap, true);
        aerb.a(localaerb, axaq.a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramaumz));
        paramaumz = (axun)paramaumz.mStructMsgItemLists.get(0);
        if ((paramaumz instanceof axuo))
        {
          paramaumz = (axun)((axuo)paramaumz).a.get(0);
          if ((paramaumz instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramaumz).a(localaerb.h);
          }
        }
      }
      localaerb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localaerb, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localaerb == null);
    asty.a().a(localaerb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localaerb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localaerb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aerk
 * JD-Core Version:    0.7.0.1
 */