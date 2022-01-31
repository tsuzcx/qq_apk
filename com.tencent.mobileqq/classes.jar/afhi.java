import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class afhi
  extends HotChatObserver
{
  public afhi(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDismissHotChat.isSuccess=" + paramBoolean + ",groupcode=" + paramString1 + ",result=" + paramInt + ",strError=" + paramString2);
    }
    if ((paramBoolean) && (paramInt == 0) && (NearbyPeopleProfileActivity.a(this.a) != null) && (NearbyPeopleProfileActivity.a(this.a).hotInfo != null) && (paramString1 != null) && (paramString1.equals(NearbyPeopleProfileActivity.a(this.a).hotInfo.troopUin)) && (NearbyPeopleProfileActivity.a(this.a) != null))
    {
      NearbyPeopleProfileActivity.a(this.a).strHotChatInfo = "";
      NearbyPeopleProfileActivity.a(this.a).hotInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhi
 * JD-Core Version:    0.7.0.1
 */