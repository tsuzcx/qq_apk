import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Map;

public class alsl
{
  public float a;
  public int a;
  public String a;
  public Map<String, String> a;
  public float b;
  public String b;
  public float c;
  public String c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r;
  public float s;
  public float t;
  
  public alsl(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.g = paramFloat7;
    this.h = paramFloat8;
    this.i = paramFloat9;
    this.j = paramFloat10;
    this.k = paramFloat11;
    this.l = paramFloat12;
    this.m = paramFloat13;
    this.n = paramFloat14;
    this.o = paramFloat15;
    this.p = paramFloat16;
    this.q = paramFloat17;
    this.r = paramFloat18;
    this.s = paramFloat19;
    this.t = paramFloat20;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localObject = this.jdField_c_of_type_JavaLangString.split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          String[] arrayOfString = localObject[i1].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            this.jdField_a_of_type_JavaUtilMap.put(arrayOfString[0], arrayOfString[1]);
          }
          i1 += 1;
        }
      }
      localObject = (String)this.jdField_a_of_type_JavaUtilMap.get("bubbleID");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloSkeletonBounding", 1, "parse bubbleID exception=", localException);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20, String paramString)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.g = paramFloat7;
    this.h = paramFloat8;
    this.i = paramFloat9;
    this.j = paramFloat10;
    this.k = paramFloat11;
    this.l = paramFloat12;
    this.m = paramFloat13;
    this.n = paramFloat14;
    this.o = paramFloat15;
    this.p = paramFloat16;
    this.q = paramFloat17;
    this.r = paramFloat18;
    this.s = paramFloat19;
    this.t = paramFloat20;
    this.jdField_c_of_type_JavaLangString = paramString;
    a();
  }
  
  public String toString()
  {
    return "ApolloSkeletonBounding{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", x=" + this.jdField_a_of_type_Float + ", y=" + this.jdField_b_of_type_Float + ", width=" + this.jdField_c_of_type_Float + ", height=" + this.d + ", bubbleX=" + this.e + ", bubbleY=" + this.f + ", bubbleWidth=" + this.g + ", bubbleHeight=" + this.h + ", giftX=" + this.i + ", giftY=" + this.j + ", giftWidth=" + this.k + ", giftHeight=" + this.l + ", brand1X=" + this.m + ", brand1Y=" + this.n + ", brand1Width=" + this.o + ", brand1Height=" + this.p + ", brand2X=" + this.q + ", brand2Y=" + this.r + ", brand2Width=" + this.s + ", brand2Height=" + this.t + ", extendString='" + this.jdField_b_of_type_JavaLangString + '\'' + ", extraInfoString='" + this.jdField_c_of_type_JavaLangString + '\'' + ", extraInfoMap=" + this.jdField_a_of_type_JavaUtilMap + ", brandMode=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsl
 * JD-Core Version:    0.7.0.1
 */