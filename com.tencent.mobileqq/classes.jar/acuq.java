import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class acuq
  extends apxc
{
  public acuq(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("ProfileCardExtendFriendView onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2)) {
      this.a.a(0L, null, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuq
 * JD-Core Version:    0.7.0.1
 */