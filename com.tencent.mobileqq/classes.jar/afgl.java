import java.util.Comparator;

public class afgl
  implements Comparator<afgi>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public afgl(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(afgi paramafgi1, afgi paramafgi2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramafgi1.c.compareToIgnoreCase(paramafgi2.c);
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
            if (paramafgi1.jdField_b_of_type_Long == paramafgi2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramafgi1.jdField_b_of_type_Long <= paramafgi2.jdField_b_of_type_Long) {
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
          if (paramafgi1.a == paramafgi2.a) {
            return 0;
          }
          if (paramafgi1.a <= paramafgi2.a) {
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
        if (paramafgi1.e != paramafgi2.e) {
          break;
        }
        j = paramafgi1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramafgi2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramafgi1.e >= paramafgi2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramafgi1.m == paramafgi2.m) {
        return paramafgi1.c.compareToIgnoreCase(paramafgi2.c);
      }
      return paramafgi2.m - paramafgi1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgl
 * JD-Core Version:    0.7.0.1
 */