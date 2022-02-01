import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aidb
  implements azjj
{
  WeakReference<aict> a;
  
  public aidb(aict paramaict)
  {
    this.a = new WeakReference(paramaict);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(azjk paramazjk)
  {
    if (this.a == null) {}
    label409:
    for (;;)
    {
      return;
      aict localaict = (aict)this.a.get();
      if ((localaict != null) && (localaict.jdField_a_of_type_JavaLangRunnable != null))
      {
        aict.a(localaict).removeCallbacks(localaict.jdField_a_of_type_JavaLangRunnable);
        localaict.jdField_a_of_type_JavaLangRunnable = null;
      }
      if ((paramazjk.jdField_a_of_type_Int == 0) && (paramazjk.jdField_a_of_type_ArrayOfByte != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
        }
        if (localaict == null) {
          continue;
        }
        Object localObject1 = new HashMap();
        Object localObject2 = localaict.app.getMessageFacade().getMsgItemByUniseq(localaict.sessionInfo.curFriendUin, localaict.sessionInfo.curType, localaict.jdField_a_of_type_Long);
        localObject2 = localaict.app.getProxyManager().a().a(paramazjk.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, (MessageRecord)localObject2, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
        {
          if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
            ((awyg)localaict.app.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(false, localaict.sessionInfo.curType);
          }
          axio.a().a((HashMap)localObject1, localaict.jdField_a_of_type_Long, localaict.app);
          localObject1 = new ArrayList();
          ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
          localaict.a((List)localObject1);
          localObject1 = ChatActivityUtils.a(aict.a(localaict), localaict.sessionInfo, localaict.app);
          localObject1 = ChatActivityUtils.a(localaict.app, BaseApplicationImpl.getContext(), localaict.sessionInfo, (MessageRecord)localObject1, -1L);
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aict.a(localaict)));
          }
          localaict.mActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localaict, (CharSequence)localObject1));
        }
      }
      for (;;)
      {
        if ((localaict == null) || (localaict.app == null)) {
          break label409;
        }
        ((axii)localaict.app.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(localaict.app, localaict.sessionInfo.curType, paramazjk.jdField_a_of_type_Int, 2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
        }
        if (localaict == null) {
          break;
        }
        localaict.mActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localaict));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidb
 * JD-Core Version:    0.7.0.1
 */