import java.util.Comparator;

public class agav
  implements Comparator<agas>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public agav(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(agas paramagas1, agas paramagas2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramagas1.c.compareToIgnoreCase(paramagas2.c);
    }
    label89:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if (this.jdField_a_of_type_Int != 2) {
              break label89;
            }
            if (paramagas1.jdField_b_of_type_Long == paramagas2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramagas1.jdField_b_of_type_Long <= paramagas2.jdField_b_of_type_Long) {
              break;
            }
          } while (this.jdField_a_of_type_Boolean);
          return 1;
          if (this.jdField_a_of_type_Boolean) {}
          for (i = j;; i = -1) {
            return i;
          }
          if (this.jdField_a_of_type_Int != 3) {
            break label149;
          }
          if (paramagas1.a == paramagas2.a) {
            return 0;
          }
          if (paramagas1.a <= paramagas2.a) {
            break;
          }
        } while (this.jdField_a_of_type_Boolean);
        return 1;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = k;; i = -1) {
          return i;
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label208;
        }
        if (paramagas1.d != paramagas2.d) {
          break;
        }
        j = paramagas1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramagas2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramagas1.d >= paramagas2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramagas1.l == paramagas2.l) {
        return paramagas1.c.compareToIgnoreCase(paramagas2.c);
      }
      return paramagas2.l - paramagas1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agav
 * JD-Core Version:    0.7.0.1
 */