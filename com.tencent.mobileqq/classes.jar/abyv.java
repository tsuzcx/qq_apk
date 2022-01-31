import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class abyv
  implements alkr
{
  private int jdField_a_of_type_Int;
  private WeakReference<AddFriendVerifyActivity> jdField_a_of_type_MqqUtilWeakReference;
  
  public abyv(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAddFriendVerifyActivity);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AddFriendVerifyActivity localAddFriendVerifyActivity = (AddFriendVerifyActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localAddFriendVerifyActivity != null) && (!localAddFriendVerifyActivity.isFinishing()))
    {
      localAddFriendVerifyActivity.a(paramInt, paramBoolean, paramObject, this.jdField_a_of_type_Int);
      return;
    }
    QLog.e("AddFriendVerifyActivity", 1, "onUpdate: activity is null, type=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyv
 * JD-Core Version:    0.7.0.1
 */