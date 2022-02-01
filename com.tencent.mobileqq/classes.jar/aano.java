import java.lang.ref.WeakReference;

class aano
  extends aoeg
{
  WeakReference<aanq> a;
  
  public aano(aanq paramaanq)
  {
    this.a = new WeakReference(paramaanq);
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    aanq localaanq = (aanq)this.a.get();
    if (localaanq != null) {
      localaanq.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aano
 * JD-Core Version:    0.7.0.1
 */