import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class agvw
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  @Deprecated
  public boolean c;
  public String d;
  public String e;
  public String f;
  
  public agvw() {}
  
  public agvw(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public agvw(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
    this.e = paramString5;
  }
  
  public agvw(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString5);
    this.f = paramString6;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long < NetConnInfoCenter.getServerTime();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof agvw))
    {
      paramObject = (agvw)paramObject;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label24;
      }
    }
    label24:
    while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvw
 * JD-Core Version:    0.7.0.1
 */