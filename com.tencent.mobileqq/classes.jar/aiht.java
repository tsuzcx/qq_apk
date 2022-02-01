import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

class aiht
  extends aoeg
{
  aiht(aihh paramaihh) {}
  
  public void onDownPublicAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onDownPublicAccount");
    }
  }
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.a.getIntent());
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c(this.a.a.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiht
 * JD-Core Version:    0.7.0.1
 */