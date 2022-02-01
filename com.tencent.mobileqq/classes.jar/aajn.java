import java.lang.ref.WeakReference;

class aajn
  extends anry
{
  WeakReference<aajp> a;
  
  public aajn(aajp paramaajp)
  {
    this.a = new WeakReference(paramaajp);
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    aajp localaajp = (aajp)this.a.get();
    if (localaajp != null) {
      localaajp.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajn
 * JD-Core Version:    0.7.0.1
 */