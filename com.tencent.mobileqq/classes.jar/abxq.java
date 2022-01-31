import android.os.Handler;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class abxq
  extends ndm
{
  public abxq(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(AddFriendLogicActivity.jdField_a_of_type_JavaLangString))
        {
          AddFriendLogicActivity.a(this.a, true);
          this.a.a();
          return;
        }
        AddFriendLogicActivity.a(this.a);
        return;
      }
      AddFriendLogicActivity.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxq
 * JD-Core Version:    0.7.0.1
 */