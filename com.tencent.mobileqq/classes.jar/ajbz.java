import android.support.annotation.NonNull;

class ajbz
  implements Comparable
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  String d;
  String e;
  String f;
  
  ajbz(ajby paramajby) {}
  
  public int a(@NonNull ajbz paramajbz)
  {
    int i = -1;
    if ((this.f != null) && (paramajbz.f != null)) {
      i = this.f.compareTo(paramajbz.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (paramajbz.f == null);
      return 1;
    } while (paramajbz.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbz
 * JD-Core Version:    0.7.0.1
 */