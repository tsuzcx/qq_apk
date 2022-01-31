import java.util.Comparator;

public class aclb
  implements Comparator<acky>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public aclb(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(acky paramacky1, acky paramacky2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramacky1.c.compareToIgnoreCase(paramacky2.c);
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
            if (paramacky1.jdField_b_of_type_Long == paramacky2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramacky1.jdField_b_of_type_Long <= paramacky2.jdField_b_of_type_Long) {
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
          if (paramacky1.a == paramacky2.a) {
            return 0;
          }
          if (paramacky1.a <= paramacky2.a) {
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
        if (paramacky1.d != paramacky2.d) {
          break;
        }
        j = paramacky1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramacky2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramacky1.d >= paramacky2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramacky1.l == paramacky2.l) {
        return paramacky1.c.compareToIgnoreCase(paramacky2.c);
      }
      return paramacky2.l - paramacky1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclb
 * JD-Core Version:    0.7.0.1
 */