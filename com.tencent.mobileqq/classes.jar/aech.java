import java.util.Comparator;

public class aech
  implements Comparator<aece>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public aech(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(aece paramaece1, aece paramaece2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramaece1.c.compareToIgnoreCase(paramaece2.c);
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
            if (paramaece1.jdField_b_of_type_Long == paramaece2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramaece1.jdField_b_of_type_Long <= paramaece2.jdField_b_of_type_Long) {
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
          if (paramaece1.a == paramaece2.a) {
            return 0;
          }
          if (paramaece1.a <= paramaece2.a) {
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
        if (paramaece1.d != paramaece2.d) {
          break;
        }
        j = paramaece1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramaece2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramaece1.d >= paramaece2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramaece1.l == paramaece2.l) {
        return paramaece1.c.compareToIgnoreCase(paramaece2.c);
      }
      return paramaece2.l - paramaece1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aech
 * JD-Core Version:    0.7.0.1
 */