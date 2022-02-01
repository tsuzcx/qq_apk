import java.lang.ref.WeakReference;

class aanp
  extends aoeg
{
  WeakReference<aanq> a;
  
  public aanp(aanq paramaanq)
  {
    this.a = new WeakReference(paramaanq);
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    aanq localaanq = (aanq)this.a.get();
    if (localaanq != null) {
      localaanq.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanp
 * JD-Core Version:    0.7.0.1
 */