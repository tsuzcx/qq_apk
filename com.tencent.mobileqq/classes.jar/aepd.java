import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayBasePanel;
import com.tencent.qphone.base.util.QLog;

public class aepd
  extends FriendListObserver
{
  public aepd(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a()
  {
    boolean bool = this.a.g;
    FriendsManager localFriendsManager = (FriendsManager)this.a.app.getManager(50);
    if (localFriendsManager != null) {
      bool = localFriendsManager.b(NearbyPeopleProfileActivity.a(this.a).uin);
    }
    for (;;)
    {
      if (bool != this.a.g)
      {
        this.a.g = bool;
        this.a.runOnUiThread(new aepe(this));
      }
      return;
    }
  }
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!NearbyPeopleProfileActivity.a(this.a).uin.equals(paramSetting.uin))) {
      return;
    }
    if ((paramSetting.bFaceFlags & 0x20) != 0) {
      this.a.l = 0;
    }
    for (;;)
    {
      this.a.b = paramSetting.url;
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).k();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.nearby_people_card.", 2, "onGetHeadInfo mheadSize is: " + this.a.l + " mGetHeadUrl is: " + this.a.b);
      return;
      if ((paramSetting.bFaceFlags & 0x10) != 0) {
        this.a.l = 640;
      } else if ((paramSetting.bFaceFlags & 0x8) != 0) {
        this.a.l = 140;
      } else if ((paramSetting.bFaceFlags & 0x4) != 0) {
        this.a.l = 100;
      } else {
        this.a.l = 40;
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.e != 3) || (this.a.g) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    a();
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.a.e != 3) || (this.a.g) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    a();
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2)) {}
    while ((this.a.e != 3) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    a();
  }
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onUpdateStangerHead: " + paramBoolean1 + "isStrangerHead: " + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (NearbyPeopleProfileActivity.a(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin)) && (paramBoolean2) && ((this.a.l == 640) || (this.a.l == 0)) && (!TextUtils.isEmpty(this.a.b)) && (!this.a.h)) {
      this.a.a(paramString, this.a.l, this.a.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepd
 * JD-Core Version:    0.7.0.1
 */