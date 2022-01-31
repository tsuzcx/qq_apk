import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import mqq.app.QQPermissionCallback;

public class aicw
  implements QQPermissionCallback
{
  public aicw(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.a.obtainMessage(2);
    paramArrayOfString.arg1 = 1;
    paramArrayOfString.arg2 = 2131699077;
    paramArrayOfString.sendToTarget();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CreateFaceToFaceDiscussionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aicw
 * JD-Core Version:    0.7.0.1
 */