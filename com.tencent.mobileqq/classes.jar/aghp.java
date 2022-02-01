import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.qphone.base.util.QLog;

class aghp
  extends aofu
{
  aghp(agho paramagho) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, new Object[] { "onGetTroopInfoExtComplete. ", Boolean.valueOf(paramBoolean), "troopUin=", paramString });
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (agho.a(this.a) == null)) {}
    while ((!TextUtils.equals(paramString, agho.a(this.a).curFriendUin)) || (!bghc.a(agho.a(this.a), paramString, paramTroopInfoExt))) {
      return;
    }
    this.a.a();
  }
  
  protected void onTroopClassExtChanged(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, new Object[] { "onChangeGroupClassExt.", Boolean.valueOf(paramBoolean), " oldClassExt=", Long.valueOf(paramLong) });
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((agho.a(this.a) == null) || (!TextUtils.equals(paramString, agho.a(this.a).curFriendUin))) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghp
 * JD-Core Version:    0.7.0.1
 */