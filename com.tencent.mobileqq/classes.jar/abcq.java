import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import java.lang.ref.WeakReference;

final class abcq
  implements aaav<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<abcm> a;
  
  public abcq(abcm paramabcm)
  {
    this.a = new WeakReference(paramabcm);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramString = (abcm)this.a.get();
    if (paramString == null) {}
    do
    {
      return;
      paramString.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    abcm.a(paramString, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcq
 * JD-Core Version:    0.7.0.1
 */