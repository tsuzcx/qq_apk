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

public class ahij
  implements aycx
{
  long jdField_a_of_type_Long;
  WeakReference<ahia> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ahij(ahia paramahia, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahia);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(aycy paramaycy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    ahia localahia;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localahia = (ahia)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localahia != null) && (localahia.jdField_a_of_type_JavaLangRunnable != null))
          {
            ahia.a(localahia).removeCallbacks(localahia.jdField_a_of_type_JavaLangRunnable);
            localahia.jdField_a_of_type_JavaLangRunnable = null;
          }
          if ((paramaycy.jdField_a_of_type_Int != 0) || (paramaycy.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localahia == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localahia.app.getMessageFacade().getMsgItemByUniseq(localahia.sessionInfo.curFriendUin, localahia.sessionInfo.curType, localahia.jdField_a_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new bcgt(StructMsgForGeneralShare.class).c(35).a(amtj.a(2131706121)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localahia.b).a();
            localObject = bbli.a(localahia.app, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localahia.app.getProxyManager().a().a(paramaycy.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      awcm.a().a(localHashMap, localahia.jdField_a_of_type_Long, localahia.app);
      paramaycy = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramaycy.add((ChatMessage)((Iterator)localObject).next());
      }
      localahia.a(paramaycy);
      localObject = ChatActivityUtils.a(ahia.a(localahia), localahia.sessionInfo, localahia.app);
      localObject = ChatActivityUtils.a(localahia.app, BaseApplicationImpl.getContext(), localahia.sessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - ahia.a(localahia)));
      }
      awcm.a().a(localahia.app, ahia.a(localahia), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramaycy = acvv.a(localahia.mActivity, "", paramaycy, localHashMap, true);
        ahia.a(localahia, bbli.a(localahia.app, "0", "0", "0", 0, 0L, paramaycy));
        paramaycy = (bcgw)paramaycy.mStructMsgItemLists.get(0);
        if ((paramaycy instanceof bcgx))
        {
          paramaycy = (bcgw)((bcgx)paramaycy).a.get(0);
          if ((paramaycy instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramaycy).a(localahia.c);
          }
        }
      }
      localahia.mActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localahia, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localahia == null);
    awcm.a().a(localahia.app, null, false);
    localahia.mActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localahia));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahij
 * JD-Core Version:    0.7.0.1
 */