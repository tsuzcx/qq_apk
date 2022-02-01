import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class aimy
  extends anyu
{
  aimy(aimx paramaimx) {}
  
  protected void onAddFriend(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      Intent localIntent = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      localIntent.putExtra("uintype", 0);
      aimx.b(this.a, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString + "Q.nearby.follow", 2, "onAddFriend, addUin:" + paramString + "|updateSession");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimy
 * JD-Core Version:    0.7.0.1
 */