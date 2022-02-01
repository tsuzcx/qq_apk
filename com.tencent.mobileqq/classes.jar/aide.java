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

public class aide
  implements ayxc
{
  long jdField_a_of_type_Long;
  WeakReference<aicv> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aide(aicv paramaicv, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaicv);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(ayxd paramayxd)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aicv localaicv;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localaicv = (aicv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localaicv != null) && (localaicv.b != null))
          {
            aicv.a(localaicv).removeCallbacks(localaicv.b);
            localaicv.b = null;
          }
          if ((paramayxd.jdField_a_of_type_Int != 0) || (paramayxd.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localaicv == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localaicv.e);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new bcvp(StructMsgForGeneralShare.class).c(35).a(anni.a(2131705784)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localaicv.g).a();
            localObject = bbzh.a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramayxd.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      awwm.a().a(localHashMap, localaicv.e, localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramayxd = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramayxd.add((ChatMessage)((Iterator)localObject).next());
      }
      localaicv.b(paramayxd);
      localObject = ChatActivityUtils.a(aicv.a(localaicv), localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localaicv.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aicv.a(localaicv)));
      }
      awwm.a().a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aicv.a(localaicv), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramayxd = adrm.a(localaicv.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramayxd, localHashMap, true);
        aicv.a(localaicv, bbzh.a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramayxd));
        paramayxd = (bcvs)paramayxd.mStructMsgItemLists.get(0);
        if ((paramayxd instanceof bcvt))
        {
          paramayxd = (bcvs)((bcvt)paramayxd).a.get(0);
          if ((paramayxd instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramayxd).a(localaicv.h);
          }
        }
      }
      localaicv.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localaicv, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localaicv == null);
    awwm.a().a(localaicv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localaicv.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localaicv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aide
 * JD-Core Version:    0.7.0.1
 */