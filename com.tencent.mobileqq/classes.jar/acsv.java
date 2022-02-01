import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class acsv
  implements View.OnTouchListener
{
  private long a;
  public String a;
  private long b;
  public String b;
  
  protected long a(long paramLong)
  {
    return NetConnInfoCenter.servetTimeSecondInterv * 1000L + paramLong;
  }
  
  protected JSONObject a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams miniAppAntiSpamParams is empty");
      return null;
    }
    Object localObject1 = blhn.a(this.jdField_b_of_type_JavaLangString);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = (String)((Map)localObject1).get("viewid");; localObject2 = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams viewid is empty");
        return null;
      }
      JSONObject localJSONObject2;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        if (localJSONObject1 == null)
        {
          QLog.i("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams antiSpamParams == null");
          return null;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", localThrowable2);
          localJSONObject2 = null;
        }
      }
      try
      {
        localJSONObject2.put("viewid", localObject1);
        return localJSONObject2;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", localThrowable1);
        }
      }
    }
  }
  
  public void a()
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return;
    }
    QLog.i("GdtMvMiniAppReportHelper", 1, "reportVideoStart " + localJSONObject.toString());
    acvo.b(localJSONObject);
  }
  
  public void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_Long);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return;
    }
    try
    {
      localJSONObject.put("cb", paramInt);
      localJSONObject.put("pi", Math.abs(paramLong2));
      localJSONObject.put("pd", paramLong1);
      localJSONObject.put("cct", a(paramLong3));
      QLog.i("GdtMvMiniAppReportHelper", 1, "reportClickButton " + localJSONObject.toString());
      acvo.b(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", localThrowable);
      }
    }
  }
  
  public void a(long paramLong, acrv paramacrv)
  {
    paramacrv = paramacrv.a();
    long l1 = paramacrv[0];
    long l2 = paramacrv[1];
    a(5, paramLong, l1 - l2, l2);
  }
  
  public void a(acsg paramacsg)
  {
    if ((paramacsg == null) || (paramacsg.a() == null) || (paramacsg.a() == null))
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "init error");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramacsg.a().antiSpamParams;
    this.jdField_b_of_type_JavaLangString = paramacsg.a().getUrlForClick();
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(this);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      continue;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsv
 * JD-Core Version:    0.7.0.1
 */