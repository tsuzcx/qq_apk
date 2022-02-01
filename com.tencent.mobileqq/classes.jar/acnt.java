import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class acnt
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acnv jdField_a_of_type_Acnv;
  private List<WeakReference<View>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  private int d;
  
  private String a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("da", String.valueOf(paramInt2));
      localJSONObject.put("db", String.valueOf(paramInt3));
      localJSONObject.put("px", String.valueOf(paramInt4));
      localJSONObject.put("py", String.valueOf(paramInt5));
      return a(paramInt1, paramString, localJSONObject.toString());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToExposureUrl error", localException);
      }
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl TextUtils.isEmpty(url)");
      return paramString1;
    }
    Map localMap = bkgj.a(paramString1);
    if ((localMap != null) && (localMap.containsKey("s")))
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl hasKey  type = " + paramInt + ", url=" + paramString1);
      return paramString1;
    }
    paramString1 = bkgj.a(paramString1, "s", paramString2);
    QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl type = " + paramInt + ",result url=" + paramString1);
    return paramString1;
  }
  
  public String a(String paramString)
  {
    return a(4, paramString, bclx.b(BaseApplicationImpl.getContext()), bclx.a(BaseApplicationImpl.getContext()), 0, 0);
  }
  
  String a(String paramString1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_b_of_type_Long;
    long l5 = System.currentTimeMillis();
    long l6 = this.jdField_a_of_type_Long;
    int i;
    int j;
    int k;
    String str;
    if (paramBoolean1)
    {
      i = 1;
      j = bclx.b(BaseApplicationImpl.getContext());
      k = bclx.a(BaseApplicationImpl.getContext());
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        paramString2.put("g", String.valueOf(l1 - l2));
        paramString2.put("sc", String.valueOf(l3 - l4));
        paramString2.put("ec", String.valueOf(l5 - l6));
        paramString2.put("aa", String.valueOf(this.jdField_a_of_type_Int));
        paramString2.put("ab", String.valueOf(this.jdField_b_of_type_Int));
        paramString2.put("ba", String.valueOf(this.c));
        paramString2.put("bb", String.valueOf(this.d));
        paramString2.put("d", String.valueOf(0));
        paramString2.put("p", String.valueOf(paramLong));
        paramString2.put("f", String.valueOf(0));
        paramString2.put("x", String.valueOf(i));
        paramString2.put("sz", String.valueOf(-999));
        paramString2.put("db", String.valueOf(k));
        paramString2.put("da", String.valueOf(j));
        if (!paramBoolean2) {
          continue;
        }
        i = 2;
        paramString2.put("vca", String.valueOf(i));
        paramString2.put("px", String.valueOf(0));
        paramString2.put("py", String.valueOf(0));
      }
      catch (Exception localException)
      {
        acqy.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", localException);
        continue;
      }
      str = paramString2.toString();
      return a(3, paramString1, str);
      i = 0;
      break;
      i = 1;
    }
  }
  
  public String a(String paramString, acnu paramacnu)
  {
    if (paramacnu == null)
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToClickUrl params == null");
      return paramString;
    }
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_b_of_type_Long;
    long l5 = System.currentTimeMillis();
    long l6 = this.jdField_a_of_type_Long;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("g", String.valueOf(l1 - l2));
      localJSONObject.put("sc", String.valueOf(l3 - l4));
      localJSONObject.put("ec", String.valueOf(l5 - l6));
      localJSONObject.put("aa", String.valueOf(this.jdField_a_of_type_Int - paramacnu.c));
      localJSONObject.put("ab", String.valueOf(this.jdField_b_of_type_Int - paramacnu.d));
      localJSONObject.put("ba", String.valueOf(this.c - paramacnu.c));
      localJSONObject.put("bb", String.valueOf(this.d - paramacnu.d));
      localJSONObject.put("d", "0");
      localJSONObject.put("p", "0");
      localJSONObject.put("f", "0");
      localJSONObject.put("x", "1");
      localJSONObject.put("db", String.valueOf(paramacnu.jdField_b_of_type_Int));
      localJSONObject.put("da", String.valueOf(paramacnu.jdField_a_of_type_Int));
      localJSONObject.put("px", String.valueOf(paramacnu.c));
      localJSONObject.put("py", String.valueOf(paramacnu.d));
      return a(1, paramString, localJSONObject.toString());
    }
    catch (Exception paramacnu)
    {
      for (;;)
      {
        acqy.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", paramacnu);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acnv = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((WeakReference)localIterator.next()).get();
      if (localView != null) {
        localView.setOnTouchListener(null);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramView));
    paramView.setOnTouchListener(this);
  }
  
  public String b(String paramString, acnu paramacnu)
  {
    if (paramacnu == null)
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToExposureUr params == null");
      return paramString;
    }
    return a(2, paramString, paramacnu.jdField_a_of_type_Int, paramacnu.jdField_b_of_type_Int, paramacnu.c, paramacnu.d);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.c = ((int)paramMotionEvent.getRawX());
      this.d = ((int)paramMotionEvent.getRawY());
      if (this.jdField_a_of_type_Acnv != null) {
        this.jdField_a_of_type_Acnv.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnt
 * JD-Core Version:    0.7.0.1
 */