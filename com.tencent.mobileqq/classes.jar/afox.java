import java.util.Comparator;

public class afox
  implements Comparator<afou>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public afox(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(afou paramafou1, afou paramafou2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramafou1.c.compareToIgnoreCase(paramafou2.c);
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
            if (paramafou1.jdField_b_of_type_Long == paramafou2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramafou1.jdField_b_of_type_Long <= paramafou2.jdField_b_of_type_Long) {
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
          if (paramafou1.a == paramafou2.a) {
            return 0;
          }
          if (paramafou1.a <= paramafou2.a) {
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
        if (paramafou1.d != paramafou2.d) {
          break;
        }
        j = paramafou1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramafou2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramafou1.d >= paramafou2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramafou1.l == paramafou2.l) {
        return paramafou1.c.compareToIgnoreCase(paramafou2.c);
      }
      return paramafou2.l - paramafou1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afox
 * JD-Core Version:    0.7.0.1
 */