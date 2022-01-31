import android.support.annotation.NonNull;

class ajxq
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
  
  ajxq(ajxp paramajxp) {}
  
  public int a(@NonNull ajxq paramajxq)
  {
    int i = -1;
    if ((this.f != null) && (paramajxq.f != null)) {
      i = this.f.compareTo(paramajxq.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (paramajxq.f == null);
      return 1;
    } while (paramajxq.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxq
 * JD-Core Version:    0.7.0.1
 */