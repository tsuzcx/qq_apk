import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class aeif
  extends ajpe
{
  aeif(aegy paramaegy) {}
  
  public void a(int paramInt)
  {
    this.a.D(paramInt);
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0)
    {
      if ((paramPublicAccountInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramPublicAccountInfo.getUin()))) {
        this.a.b(1);
      }
    }
    else {
      return;
    }
    this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    if ((paramBoolean) && (!aegy.c(this.a)))
    {
      localObject = (ajoy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = ((ajoy)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if ((localObject != null) && (this.a.o != null) && (!aegy.d(this.a))) {
        this.a.bo();
      }
      return;
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeif
 * JD-Core Version:    0.7.0.1
 */