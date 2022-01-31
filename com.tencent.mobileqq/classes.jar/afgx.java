import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class afgx
{
  private afhb jdField_a_of_type_Afhb = new afgy(this);
  private afhc jdField_a_of_type_Afhc;
  public Context a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public String a;
  public String b;
  private String c;
  
  public afgx(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramString;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramContext);
    paramContext = aonq.a();
    this.jdField_a_of_type_JavaLangString = paramContext.F;
    this.b = paramContext.G;
  }
  
  private int a(String paramString, float paramFloat, int paramInt)
  {
    int j = 0;
    Paint localPaint;
    if (!TextUtils.isEmpty(paramString))
    {
      localPaint = new Paint();
      localPaint.setTextSize(TypedValue.applyDimension(2, paramFloat, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
    }
    for (int i = (int)localPaint.measureText(paramString, 0, paramString.length());; i = 0)
    {
      paramString = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      if (paramString != null) {
        j = paramString.getDefaultDisplay().getWidth();
      }
      return j - paramInt - i;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("intimate_relationship", 2, "jumph5Url strUrl Empty");
      return;
    }
    if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("selfSet_leftViewText", alud.a(2131706932));
      paramContext.startActivity(localIntent);
      return;
    }
    QLog.e("intimate_relationship", 2, "jumph5Url strUrl unRecognized " + paramString);
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_Afhb = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(afhc paramafhc)
  {
    this.jdField_a_of_type_Afhc = paramafhc;
  }
  
  public void a(Context paramContext, ArrayList<IntimateInfo.MemoryDayInfo> paramArrayList)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      ArrayList localArrayList = new ArrayList();
      Object localObject;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)paramArrayList.next();
          if ((localMemoryDayInfo != null) && (localMemoryDayInfo.date != 0L))
          {
            Date localDate = new Date(localMemoryDayInfo.date);
            if ((((Date)localObject).getDay() == localDate.getDay()) && (((Date)localObject).getMonth() == localDate.getMonth()) && (((Date)localObject).getYear() == localDate.getYear())) {
              localArrayList.add(localMemoryDayInfo);
            }
          }
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      while (i < localArrayList.size())
      {
        paramArrayList = (IntimateInfo.MemoryDayInfo)localArrayList.get(i);
        localObject = new afgz(this, paramContext);
        if (localObject != null)
        {
          ((afgz)localObject).a(paramArrayList);
          ((afgz)localObject).a(this.jdField_a_of_type_Afhb);
          if (((afgz)localObject).a() != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((afgz)localObject).a());
          }
        }
        i += 1;
        continue;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgx
 * JD-Core Version:    0.7.0.1
 */