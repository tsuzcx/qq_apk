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

public class ahii
  implements aycx
{
  WeakReference<ahia> a;
  
  public ahii(ahia paramahia)
  {
    this.a = new WeakReference(paramahia);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(aycy paramaycy)
  {
    if (this.a == null) {}
    label409:
    for (;;)
    {
      return;
      ahia localahia = (ahia)this.a.get();
      if ((localahia != null) && (localahia.jdField_a_of_type_JavaLangRunnable != null))
      {
        ahia.a(localahia).removeCallbacks(localahia.jdField_a_of_type_JavaLangRunnable);
        localahia.jdField_a_of_type_JavaLangRunnable = null;
      }
      if ((paramaycy.jdField_a_of_type_Int == 0) && (paramaycy.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localahia == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localahia.app.getMessageFacade().getMsgItemByUniseq(localahia.sessionInfo.curFriendUin, localahia.sessionInfo.curType, localahia.jdField_a_of_type_Long);
        localObject2 = localahia.app.getProxyManager().a().a(paramaycy.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((avsf)localahia.app.getManager(174)).a(false, localahia.sessionInfo.curType);
          }
          awcm.a().a((HashMap)localObject1, localahia.jdField_a_of_type_Long, localahia.app);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localahia.a((List)localObject1);
          localObject1 = ChatActivityUtils.a(ahia.a(localahia), localahia.sessionInfo, localahia.app);
          localObject1 = ChatActivityUtils.a(localahia.app, BaseApplicationImpl.getContext(), localahia.sessionInfo, (MessageRecord)localObject1, -1L);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - ahia.a(localahia)));
          }
          localahia.mActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localahia, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localahia == null) || (localahia.app == null)) {
          break label409;
        }
        ((awcg)localahia.app.getManager(166)).a(localahia.app, localahia.sessionInfo.curType, paramaycy.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localahia == null) {
          break;
        }
        localahia.mActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localahia));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahii
 * JD-Core Version:    0.7.0.1
 */