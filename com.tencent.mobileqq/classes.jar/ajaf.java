import java.util.Comparator;

public class ajaf
  implements Comparator<ajac>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public ajaf(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(ajac paramajac1, ajac paramajac2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramajac1.c.compareToIgnoreCase(paramajac2.c);
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
            if (paramajac1.jdField_b_of_type_Long == paramajac2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramajac1.jdField_b_of_type_Long <= paramajac2.jdField_b_of_type_Long) {
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
          if (paramajac1.a == paramajac2.a) {
            return 0;
          }
          if (paramajac1.a <= paramajac2.a) {
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
        if (paramajac1.e != paramajac2.e) {
          break;
        }
        j = paramajac1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramajac2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramajac1.e >= paramajac2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramajac1.m == paramajac2.m) {
        return paramajac1.c.compareToIgnoreCase(paramajac2.c);
      }
      return paramajac2.m - paramajac1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajaf
 * JD-Core Version:    0.7.0.1
 */