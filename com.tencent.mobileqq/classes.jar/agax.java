import java.util.Comparator;

public class agax
  implements Comparator<agau>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public agax(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(agau paramagau1, agau paramagau2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramagau1.c.compareToIgnoreCase(paramagau2.c);
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
            if (paramagau1.jdField_b_of_type_Long == paramagau2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramagau1.jdField_b_of_type_Long <= paramagau2.jdField_b_of_type_Long) {
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
          if (paramagau1.a == paramagau2.a) {
            return 0;
          }
          if (paramagau1.a <= paramagau2.a) {
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
        if (paramagau1.d != paramagau2.d) {
          break;
        }
        j = paramagau1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramagau2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramagau1.d >= paramagau2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramagau1.l == paramagau2.l) {
        return paramagau1.c.compareToIgnoreCase(paramagau2.c);
      }
      return paramagau2.l - paramagau1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agax
 * JD-Core Version:    0.7.0.1
 */