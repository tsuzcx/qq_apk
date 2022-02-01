import android.text.TextUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajbx
  extends andd
{
  public ajbx(Conversation paramConversation) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, 1);
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.a(8, paramString, 1);
      this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
      this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onGetTroopMemberCard isSuccess=" + paramBoolean + " data=" + paramObject);
    }
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      this.a.a(8, String.valueOf(l), 1);
    }
  }
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (TroopMemberCardInfo)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        this.a.a(8, paramArrayList.troopuin, 1);
        this.a.a(8, paramArrayList.memberuin, -2147483648);
        this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
        this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      }
    }
  }
  
  protected void onTroopHonorUpdate(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.equals(this.a.a.getCurrentAccountUin()))) {
      this.a.a(8, paramString1, 1);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0)
      {
        avnu.a().c(this.a.a);
        this.a.a(8, paramString, 1);
        this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
        this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    avnu.a().b(paramString, this.a.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopmanagersuccess");
    }
    this.a.a(8, paramString, 1);
    this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
    this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
  }
  
  protected void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
      this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      if (paramTroopInfo != null) {
        this.a.a(8, paramTroopInfo.troopuin, 1);
      }
    }
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    avnu.a().c(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbx
 * JD-Core Version:    0.7.0.1
 */