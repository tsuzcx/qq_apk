import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class acfh
  implements achf
{
  private acfh(acey paramacey) {}
  
  public String a(String paramString)
  {
    int i = 0;
    if ((acey.a(this.a) == null) || (acey.a(this.a).a() == null) || (acey.a(this.a).a() == null))
    {
      QLog.i("Web", 1, "onGetAdInfo fail data empty");
      i = 1;
    }
    if (TextUtils.isEmpty(acey.a(this.a).a().adsContent))
    {
      QLog.i("Web", 1, "onGetAdInfo fail adsContent empty");
      i = 1;
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(acey.a(this.a).a().getTraceId())))
    {
      QLog.i("Web", 1, "onGetAdInfo fail req=" + paramString + ",local=" + acey.a(this.a).a().getTraceId());
      i = 1;
    }
    if (i != 0)
    {
      if (acey.a(this.a) != null) {
        acey.a(this.a).a();
      }
      if (acey.a(this.a) != null) {
        acey.a(this.a).c();
      }
      return "";
    }
    if (acey.a(this.a) != null) {
      acey.a(this.a).d();
    }
    return acey.a(this.a).a().adsContent;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvViewController", 2, "onVideoClose");
    }
    this.a.a(false);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject2 = localJSONObject;
        QLog.e("GdtMvViewController", 1, "onReportAntiSpam,json error:" + paramString);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (acey.a(this.a) != null)
          {
            localJSONObject.put("pd", acey.a(this.a).b());
            localObject2 = localJSONObject;
          }
          this.a.a.a((JSONObject)localObject2);
          return;
        }
        catch (JSONException localJSONException2)
        {
          Object localObject2;
          Object localObject1;
          break label57;
        }
        localJSONException1 = localJSONException1;
        localObject1 = null;
      }
      label57:
      localObject2 = localObject1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (acey.a(this.a) != null)
    {
      acey.a(this.a).a(1, paramString, paramBoolean);
      return;
    }
    QLog.i("Web", 1, "mvAnimationController null");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvViewController", 2, "onVideoMute");
    }
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfh
 * JD-Core Version:    0.7.0.1
 */