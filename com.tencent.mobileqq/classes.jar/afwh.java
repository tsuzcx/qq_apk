import java.util.Comparator;

public class afwh
  implements Comparator<afwe>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public afwh(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(afwe paramafwe1, afwe paramafwe2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramafwe1.c.compareToIgnoreCase(paramafwe2.c);
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
            if (paramafwe1.jdField_b_of_type_Long == paramafwe2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramafwe1.jdField_b_of_type_Long <= paramafwe2.jdField_b_of_type_Long) {
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
          if (paramafwe1.a == paramafwe2.a) {
            return 0;
          }
          if (paramafwe1.a <= paramafwe2.a) {
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
        if (paramafwe1.e != paramafwe2.e) {
          break;
        }
        j = paramafwe1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramafwe2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramafwe1.e >= paramafwe2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramafwe1.m == paramafwe2.m) {
        return paramafwe1.c.compareToIgnoreCase(paramafwe2.c);
      }
      return paramafwe2.m - paramafwe1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwh
 * JD-Core Version:    0.7.0.1
 */