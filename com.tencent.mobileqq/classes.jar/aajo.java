import java.lang.ref.WeakReference;

class aajo
  extends anry
{
  WeakReference<aajp> a;
  
  public aajo(aajp paramaajp)
  {
    this.a = new WeakReference(paramaajp);
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    aajp localaajp = (aajp)this.a.get();
    if (localaajp != null) {
      localaajp.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajo
 * JD-Core Version:    0.7.0.1
 */