import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class aanv
{
  private static aanw a(int paramInt)
  {
    aaoe localaaoe = null;
    if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt) || (3 == paramInt)) {
      localaaoe = new aaoe();
    }
    return localaaoe;
  }
  
  public static void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {}
    aanw localaanw;
    do
    {
      do
      {
        aaoc.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
        return;
      } while ((paramInt2 < 0) || (paramInt2 >= 4));
      localaanw = a(paramInt2);
    } while (localaanw == null);
    localaanw.a(paramInt1, paramInt2, paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanv
 * JD-Core Version:    0.7.0.1
 */