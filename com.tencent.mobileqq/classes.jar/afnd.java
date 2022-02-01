import java.util.Comparator;

public class afnd
  implements Comparator<afna>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public afnd(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(afna paramafna1, afna paramafna2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramafna1.c.compareToIgnoreCase(paramafna2.c);
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
            if (paramafna1.jdField_b_of_type_Long == paramafna2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramafna1.jdField_b_of_type_Long <= paramafna2.jdField_b_of_type_Long) {
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
          if (paramafna1.a == paramafna2.a) {
            return 0;
          }
          if (paramafna1.a <= paramafna2.a) {
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
        if (paramafna1.e != paramafna2.e) {
          break;
        }
        j = paramafna1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramafna2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramafna1.e >= paramafna2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramafna1.m == paramafna2.m) {
        return paramafna1.c.compareToIgnoreCase(paramafna2.c);
      }
      return paramafna2.m - paramafna1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnd
 * JD-Core Version:    0.7.0.1
 */