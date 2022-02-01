import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;

class acpd
  implements acqs
{
  private acpd(acow paramacow) {}
  
  public String a(String paramString)
  {
    int i = 0;
    if ((acow.a(this.a) == null) || (acow.a(this.a).a() == null) || (acow.a(this.a).a() == null))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail data empty");
      i = 1;
    }
    if (TextUtils.isEmpty(acow.a(this.a).a().adsContent))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail adsContent empty");
      i = 1;
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(acow.a(this.a).a().getTraceId())))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail req=" + paramString + ",local=" + acow.a(this.a).a().getTraceId());
      i = 1;
    }
    if (i != 0)
    {
      if (acow.a(this.a) != null) {
        acow.a(this.a).a();
      }
      return "";
    }
    return acow.a(this.a).a().adsContent;
  }
  
  public void a(String paramString)
  {
    if (acow.a(this.a) != null)
    {
      acow.a(this.a).a(2131362118, paramString);
      return;
    }
    QLog.i("EndCardWeb", 1, "mvAnimationController null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpd
 * JD-Core Version:    0.7.0.1
 */