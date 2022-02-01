import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;

class actg
  implements acuw
{
  private actg(acsz paramacsz) {}
  
  public String a(String paramString)
  {
    int i = 0;
    if ((acsz.a(this.a) == null) || (acsz.a(this.a).a() == null) || (acsz.a(this.a).a() == null))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail data empty");
      i = 1;
    }
    if (TextUtils.isEmpty(acsz.a(this.a).a().adsContent))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail adsContent empty");
      i = 1;
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(acsz.a(this.a).a().getTraceId())))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail req=" + paramString + ",local=" + acsz.a(this.a).a().getTraceId());
      i = 1;
    }
    if (i != 0)
    {
      if (acsz.a(this.a) != null) {
        acsz.a(this.a).a();
      }
      return "";
    }
    return acsz.a(this.a).a().adsContent;
  }
  
  public void a(String paramString)
  {
    if (acsz.a(this.a) != null)
    {
      acsz.a(this.a).a(2131362124, paramString);
      return;
    }
    QLog.i("EndCardWeb", 1, "mvAnimationController null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actg
 * JD-Core Version:    0.7.0.1
 */