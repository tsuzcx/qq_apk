import java.util.Comparator;

public class akff
  implements Comparator<akfc>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public akff(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(akfc paramakfc1, akfc paramakfc2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramakfc1.c.compareToIgnoreCase(paramakfc2.c);
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
            if (paramakfc1.jdField_b_of_type_Long == paramakfc2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramakfc1.jdField_b_of_type_Long <= paramakfc2.jdField_b_of_type_Long) {
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
          if (paramakfc1.a == paramakfc2.a) {
            return 0;
          }
          if (paramakfc1.a <= paramakfc2.a) {
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
        if (paramakfc1.e != paramakfc2.e) {
          break;
        }
        j = paramakfc1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramakfc2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramakfc1.e >= paramakfc2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramakfc1.m == paramakfc2.m) {
        return paramakfc1.c.compareToIgnoreCase(paramakfc2.c);
      }
      return paramakfc2.m - paramakfc1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akff
 * JD-Core Version:    0.7.0.1
 */