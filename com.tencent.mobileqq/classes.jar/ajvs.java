import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class ajvs
  extends aoeg
{
  public ajvs(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onFollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.a.i();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUnfollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.a.i();
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUpdateUserFollowList errCode: " + paramInt + " isFinish:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (PublicAccountFragment.a(this.a))
      {
        if (PublicAccountFragment.a(this.a) != null) {
          PublicAccountFragment.b(this.a).a(this.a.b(), true, null);
        }
        PublicAccountFragment.a(this.a, false);
      }
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvs
 * JD-Core Version:    0.7.0.1
 */