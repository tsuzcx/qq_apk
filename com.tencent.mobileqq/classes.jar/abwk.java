import android.support.annotation.NonNull;

public class abwk
{
  protected int a;
  protected boolean a;
  @NonNull
  protected byte[] a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  
  public abwk()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 1536;
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_Int];
  }
  
  protected long a()
  {
    boolean bool = false;
    long l = 0L;
    int i = 0;
    while ((i == 0) && (b())) {
      if (Character.isDigit(this.jdField_a_of_type_Int))
      {
        l = l * 10L + (this.jdField_a_of_type_Int - 48);
        bool = true;
      }
      else
      {
        i = 1;
      }
    }
    a(bool);
    return l;
  }
  
  protected void a(char paramChar)
  {
    boolean bool = false;
    while ((!bool) && (b())) {
      if (this.jdField_a_of_type_Int == paramChar) {
        bool = true;
      }
    }
    a(bool);
  }
  
  protected boolean a()
  {
    b();
    this.jdField_c_of_type_Boolean = true;
    return !this.jdField_b_of_type_Boolean;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean &= paramBoolean;
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean b()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      return !this.jdField_b_of_type_Boolean;
    }
    if (this.jdField_c_of_type_Int >= this.jdField_b_of_type_Int) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_ArrayOfByte[this.jdField_c_of_type_Int] != -1)
    {
      i = this.jdField_a_of_type_ArrayOfByte[this.jdField_c_of_type_Int] & 0xFF;
      label63:
      this.jdField_a_of_type_Int = i;
      this.jdField_c_of_type_Int += 1;
      if (this.jdField_a_of_type_Int != -1) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      return false;
      i = -1;
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwk
 * JD-Core Version:    0.7.0.1
 */