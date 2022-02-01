import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aels
  extends Handler
{
  public aels(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.h();
    }
    do
    {
      return;
      if (paramMessage.what == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
        }
        this.a.a(2, this.a.a.getTroopOwnerName(), this.a.a.isFetchedTroopOwnerUin());
        return;
      }
      if (paramMessage.what == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
        }
        if ((this.a.a.dwGroupFlagExt & 0x800) != 0L) {
          this.a.a(7, this.a.a.troopAuthenticateInfo, false);
        }
        this.a.a(2, this.a.a.troopOwnerNick, this.a.a.isFetchedTroopOwnerUin());
        if ((this.a.a.troopOwnerNick == null) && (!TextUtils.isEmpty(this.a.a.troopowneruin))) {
          TroopInfoActivity.c(this.a);
        }
        this.a.m();
        this.a.c();
        this.a.b();
        if (!TextUtils.isEmpty(this.a.a.mRichFingerMemo)) {}
        for (paramMessage = this.a.a.mRichFingerMemo;; paramMessage = this.a.getResources().getString(2131695646))
        {
          this.a.a(6, paramMessage, this.a.a.isOwnerOrAdim());
          if (this.a.a.troopClass != null) {
            break;
          }
          TroopInfoActivity.d(this.a);
          return;
        }
      }
      if (paramMessage.what == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_CLASS");
        }
        this.a.a(4, this.a.a.troopClass, this.a.a.isOwnerOrAdim());
        return;
      }
      if (paramMessage.what == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
        }
        paramMessage = TroopInfoActivity.a(this.a, this.a.a);
        this.a.a(8, paramMessage, true, 2, true);
        return;
      }
      if (paramMessage.what == 7)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_INTEREST");
        }
        paramMessage = new ArrayList();
        if (!TextUtils.isEmpty(this.a.a.tribeName)) {
          paramMessage.add(this.a.a.tribeName);
        }
        this.a.a(9, paramMessage, true, 1, true);
        TroopInfoActivity.e(this.a);
        return;
      }
    } while (paramMessage.what != 8);
    TroopInfoActivity.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aels
 * JD-Core Version:    0.7.0.1
 */