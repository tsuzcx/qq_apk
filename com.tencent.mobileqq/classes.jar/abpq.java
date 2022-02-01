import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;

class abpq
  implements abrf
{
  private abpq(abpi paramabpi) {}
  
  public String a(String paramString)
  {
    int i = 0;
    if ((abpi.a(this.a) == null) || (abpi.a(this.a).a() == null) || (abpi.a(this.a).a() == null))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail data empty");
      i = 1;
    }
    if (TextUtils.isEmpty(abpi.a(this.a).a().adsContent))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail adsContent empty");
      i = 1;
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(abpi.a(this.a).a().getTraceId())))
    {
      QLog.i("EndCardWeb", 1, "onGetAdInfo fail req=" + paramString + ",local=" + abpi.a(this.a).a().getTraceId());
      i = 1;
    }
    if (i != 0)
    {
      if (abpi.a(this.a) != null) {
        abpi.a(this.a).a();
      }
      return "";
    }
    return abpi.a(this.a).a().adsContent;
  }
  
  public void a(String paramString)
  {
    if (abpi.a(this.a) != null)
    {
      abpi.a(this.a).a(2131362124, paramString);
      return;
    }
    QLog.i("EndCardWeb", 1, "mvAnimationController null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpq
 * JD-Core Version:    0.7.0.1
 */