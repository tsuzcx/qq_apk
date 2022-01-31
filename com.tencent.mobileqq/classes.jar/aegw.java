import java.util.Comparator;

public class aegw
  implements Comparator<aegt>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public aegw(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(aegt paramaegt1, aegt paramaegt2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramaegt1.c.compareToIgnoreCase(paramaegt2.c);
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
            if (paramaegt1.jdField_b_of_type_Long == paramaegt2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramaegt1.jdField_b_of_type_Long <= paramaegt2.jdField_b_of_type_Long) {
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
          if (paramaegt1.a == paramaegt2.a) {
            return 0;
          }
          if (paramaegt1.a <= paramaegt2.a) {
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
        if (paramaegt1.d != paramaegt2.d) {
          break;
        }
        j = paramaegt1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramaegt2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramaegt1.d >= paramaegt2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramaegt1.l == paramaegt2.l) {
        return paramaegt1.c.compareToIgnoreCase(paramaegt2.c);
      }
      return paramaegt2.l - paramaegt1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegw
 * JD-Core Version:    0.7.0.1
 */