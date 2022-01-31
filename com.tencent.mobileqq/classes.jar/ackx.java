import java.util.Comparator;

public class ackx
  implements Comparator<acku>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public ackx(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(acku paramacku1, acku paramacku2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramacku1.c.compareToIgnoreCase(paramacku2.c);
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
            if (paramacku1.jdField_b_of_type_Long == paramacku2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramacku1.jdField_b_of_type_Long <= paramacku2.jdField_b_of_type_Long) {
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
          if (paramacku1.a == paramacku2.a) {
            return 0;
          }
          if (paramacku1.a <= paramacku2.a) {
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
        if (paramacku1.d != paramacku2.d) {
          break;
        }
        j = paramacku1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramacku2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramacku1.d >= paramacku2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramacku1.l == paramacku2.l) {
        return paramacku1.c.compareToIgnoreCase(paramacku2.c);
      }
      return paramacku2.l - paramacku1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackx
 * JD-Core Version:    0.7.0.1
 */