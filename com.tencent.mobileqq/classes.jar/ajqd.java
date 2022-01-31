import android.support.annotation.NonNull;

class ajqd
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
  
  ajqd(ajqc paramajqc) {}
  
  public int a(@NonNull ajqd paramajqd)
  {
    int i = -1;
    if ((this.f != null) && (paramajqd.f != null)) {
      i = this.f.compareTo(paramajqd.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (paramajqd.f == null);
      return 1;
    } while (paramajqd.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqd
 * JD-Core Version:    0.7.0.1
 */