import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;

public class aamr
{
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, aamw paramaamw, aamv paramaamv)
  {
    a(paramContext, null, paramStFeed, paramaamw, paramaamv);
  }
  
  private static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, aamw paramaamw, aamv paramaamv)
  {
    blir localblir = blir.a(paramContext);
    localblir.a(paramContext.getString(2131718486));
    localblir.a(2131718487, 3);
    localblir.c(2131690580);
    localblir.a(new aams(localblir, paramaamv));
    localblir.a(new aamt(paramStUser, paramStFeed, paramaamw, paramaamv, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser, aamw paramaamw, aamv paramaamv)
  {
    a(paramContext, paramStUser, null, paramaamw, paramaamv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamr
 * JD-Core Version:    0.7.0.1
 */