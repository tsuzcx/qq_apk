import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aglc
  implements nxx
{
  aglc(aglb paramaglb) {}
  
  public void a()
  {
    if ((ChatActivityUtils.a(aglb.a(this.a).sessionInfo.curFriendUin, aglb.a(this.a).app.getCurrentAccountUin()) != null) || (QLog.isColorLevel())) {
      QLog.d(".troop.notify_feeds.aio", 2, "getAppIds onFailed, reqNotifyItems");
    }
    bgif.a(aglb.a(this.a).app, aglb.a(this.a).sessionInfo.curFriendUin);
  }
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((aglb.a(this.a) == null) || (aglb.a(this.a).app == null) || (aglb.a(this.a).sessionInfo == null)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (ChatActivityUtils.a(aglb.a(this.a).sessionInfo.curFriendUin, aglb.a(this.a).app.getCurrentAccountUin()) != null);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1L));
      localArrayList.add(Long.valueOf(2L));
      localArrayList.add(Long.valueOf(1101236949L));
      localArrayList.add(Long.valueOf(1101484419L));
      localArrayList.add(Long.valueOf(1102858908L));
      localArrayList.add(Long.valueOf(1106611799L));
      localArrayList.add(Long.valueOf(1104445552L));
      localArrayList.add(Long.valueOf(1106717414L));
      localArrayList.add(Long.valueOf(101509131L));
      localArrayList.add(Long.valueOf(1106588005L));
      localArrayList.add(Long.valueOf(1106664488L));
      localArrayList.add(Long.valueOf(101618516L));
      localArrayList.add(Long.valueOf(101872323L));
      localArrayList.add(Long.valueOf(101890494L));
      localArrayList.add(Long.valueOf(101896870L));
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(Long.valueOf(((TroopAppInfo)paramArrayList.next()).appId));
        }
      }
      paramArrayList = (aoep)aglb.a(this.a).app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (paramArrayList == null);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "send_oidb_0x8c9_2, appIds.size=" + localArrayList.size());
    }
    paramArrayList.a(aglb.a(this.a).sessionInfo.curFriendUin, localArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglc
 * JD-Core Version:    0.7.0.1
 */