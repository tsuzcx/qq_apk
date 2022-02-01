import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class aaiq
{
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, aaiv paramaaiv, aaiu paramaaiu)
  {
    a(paramContext, null, paramStFeed, paramaaiv, paramaaiu);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, aaiv paramaaiv, aaiu paramaaiu)
  {
    bkho localbkho = bkho.a(paramContext);
    localbkho.a(paramContext.getString(2131718350));
    localbkho.a(2131718351, 3);
    localbkho.c(2131690582);
    localbkho.a(new aair(localbkho, paramaaiu));
    localbkho.a(new aais(paramStUser, paramStFeed, paramaaiv, paramaaiu, localbkho));
    if (!localbkho.isShowing()) {
      localbkho.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, aaiv paramaaiv, aaiu paramaaiu)
  {
    a(paramContext, paramStUser, null, paramaaiv, paramaaiu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiq
 * JD-Core Version:    0.7.0.1
 */