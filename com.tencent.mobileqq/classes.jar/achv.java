import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class achv
{
  private static achw a(int paramInt)
  {
    acif localacif = null;
    if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt) || (3 == paramInt)) {
      localacif = new acif();
    }
    return localacif;
  }
  
  public static void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {}
    achw localachw;
    do
    {
      do
      {
        acid.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
        return;
      } while ((paramInt2 < 0) || (paramInt2 >= 4));
      localachw = a(paramInt2);
    } while (localachw == null);
    localachw.a(paramInt1, paramInt2, paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achv
 * JD-Core Version:    0.7.0.1
 */