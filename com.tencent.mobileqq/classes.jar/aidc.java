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

public class aidc
  implements azjj
{
  long jdField_a_of_type_Long;
  WeakReference<aict> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aidc(aict paramaict, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaict);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(azjk paramazjk)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aict localaict;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localaict = (aict)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localaict != null) && (localaict.jdField_a_of_type_JavaLangRunnable != null))
          {
            aict.a(localaict).removeCallbacks(localaict.jdField_a_of_type_JavaLangRunnable);
            localaict.jdField_a_of_type_JavaLangRunnable = null;
          }
          if ((paramazjk.jdField_a_of_type_Int != 0) || (paramazjk.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localaict == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localaict.app.getMessageFacade().getMsgItemByUniseq(localaict.sessionInfo.curFriendUin, localaict.sessionInfo.curType, localaict.jdField_a_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new bdnr(StructMsgForGeneralShare.class).c(35).a(anvx.a(2131706473)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localaict.b).a();
            localObject = bcsa.a(localaict.app, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localaict.app.getProxyManager().a().a(paramazjk.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      axio.a().a(localHashMap, localaict.jdField_a_of_type_Long, localaict.app);
      paramazjk = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramazjk.add((ChatMessage)((Iterator)localObject).next());
      }
      localaict.a(paramazjk);
      localObject = ChatActivityUtils.a(aict.a(localaict), localaict.sessionInfo, localaict.app);
      localObject = ChatActivityUtils.a(localaict.app, BaseApplicationImpl.getContext(), localaict.sessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - aict.a(localaict)));
      }
      axio.a().a(localaict.app, aict.a(localaict), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramazjk = admh.a(localaict.mActivity, "", paramazjk, localHashMap, true);
        if (paramazjk != null)
        {
          aict.a(localaict, bcsa.a(localaict.app, "0", "0", "0", 0, 0L, paramazjk));
          paramazjk = (bdnu)paramazjk.mStructMsgItemLists.get(0);
          if ((paramazjk instanceof bdnv))
          {
            paramazjk = (bdnu)((bdnv)paramazjk).a.get(0);
            if ((paramazjk instanceof StructMsgItemTitle)) {
              ((StructMsgItemTitle)paramazjk).a(localaict.c);
            }
          }
        }
      }
      localaict.mActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localaict, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localaict == null);
    axio.a().a(localaict.app, null, false);
    localaict.mActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localaict));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidc
 * JD-Core Version:    0.7.0.1
 */