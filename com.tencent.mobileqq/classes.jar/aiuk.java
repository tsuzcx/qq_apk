import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aiuk
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
  
  public aiuk() {}
  
  public aiuk(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
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
  
  public aiuk(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
    this.e = paramString5;
  }
  
  public aiuk(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString5);
    this.f = paramString6;
  }
  
  public int a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("passwdredinfo", 2, "[getWordChainSubChannel] " + this.f);
      }
      int i = new JSONObject(this.f).optInt("key_sub_channel");
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, QLog.getStackTraceString(localThrowable));
    }
    return -1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long < NetConnInfoCenter.getServerTime();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof aiuk))
    {
      paramObject = (aiuk)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuk
 * JD-Core Version:    0.7.0.1
 */