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

public class agsx
  implements awiq
{
  long jdField_a_of_type_Long;
  WeakReference<agso> jdField_a_of_type_JavaLangRefWeakReference;
  
  public agsx(agso paramagso, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagso);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(awir paramawir)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    agso localagso;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localagso = (agso)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localagso != null) && (localagso.b != null))
          {
            agso.a(localagso).removeCallbacks(localagso.b);
            localagso.b = null;
          }
          if ((paramawir.jdField_a_of_type_Int != 0) || (paramawir.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localagso == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localagso.jdField_g_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new azup(StructMsgForGeneralShare.class).c(35).a(alud.a(2131707393)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localagso.jdField_g_of_type_JavaLangString).a();
            localObject = azaf.a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramawir.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      aupg.a().a(localHashMap, localagso.jdField_g_of_type_Long, localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramawir = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramawir.add((ChatMessage)((Iterator)localObject).next());
      }
      localagso.b(paramawir);
      localObject = ChatActivityUtils.a(agso.a(localagso), localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localagso.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - agso.a(localagso)));
      }
      aupg.a().a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, agso.a(localagso), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramawir = acjm.a(localagso.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramawir, localHashMap, true);
        agso.a(localagso, azaf.a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramawir));
        paramawir = (azus)paramawir.mStructMsgItemLists.get(0);
        if ((paramawir instanceof azut))
        {
          paramawir = (azus)((azut)paramawir).a.get(0);
          if ((paramawir instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramawir).a(localagso.h);
          }
        }
      }
      localagso.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localagso, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localagso == null);
    aupg.a().a(localagso.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localagso.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localagso));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsx
 * JD-Core Version:    0.7.0.1
 */