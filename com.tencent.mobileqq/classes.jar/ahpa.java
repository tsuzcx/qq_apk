import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class ahpa
  extends alvc
{
  public ahpa(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUnfollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.a.i();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUpdateUserFollowList errCode: " + paramInt + " isFinish:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (PublicAccountFragment.a(this.a))
      {
        if (this.a.a != null) {
          this.a.a.a(this.a.b(), true, null);
        }
        PublicAccountFragment.a(this.a, false);
      }
      this.a.i();
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onFollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpa
 * JD-Core Version:    0.7.0.1
 */