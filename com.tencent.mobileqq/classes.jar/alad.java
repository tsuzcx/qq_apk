import android.text.TextUtils;

public class alad
  implements Comparable<alad>
{
  public int a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public short b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e = -1;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g = 0;
  public String g;
  public int h;
  
  public int a(alad paramalad)
  {
    if (paramalad == null) {}
    do
    {
      return -1;
      if (this.jdField_a_of_type_Boolean == paramalad.jdField_a_of_type_Boolean) {
        return -(int)(this.c - paramalad.c);
      }
    } while (this.jdField_a_of_type_Boolean);
    return 0;
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_Long == this.b) || ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.jdField_a_of_type_Long))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alad
 * JD-Core Version:    0.7.0.1
 */