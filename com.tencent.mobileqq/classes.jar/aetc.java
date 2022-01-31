import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class aetc
  extends akdo
{
  aetc(aerv paramaerv) {}
  
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
    if ((paramBoolean) && (!aerv.d(this.a)))
    {
      localObject = (akdi)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = ((akdi)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if ((localObject != null) && (this.a.o != null) && (!aerv.e(this.a))) {
        this.a.bq();
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
 * Qualified Name:     aetc
 * JD-Core Version:    0.7.0.1
 */