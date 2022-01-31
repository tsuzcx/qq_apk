import java.util.Comparator;

public class acap
  implements Comparator<acam>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public acap(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(acam paramacam1, acam paramacam2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramacam1.c.compareToIgnoreCase(paramacam2.c);
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
            if (paramacam1.jdField_b_of_type_Long == paramacam2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramacam1.jdField_b_of_type_Long <= paramacam2.jdField_b_of_type_Long) {
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
          if (paramacam1.a == paramacam2.a) {
            return 0;
          }
          if (paramacam1.a <= paramacam2.a) {
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
        if (paramacam1.d != paramacam2.d) {
          break;
        }
        j = paramacam1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramacam2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramacam1.d >= paramacam2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramacam1.l == paramacam2.l) {
        return paramacam1.c.compareToIgnoreCase(paramacam2.c);
      }
      return paramacam2.l - paramacam1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acap
 * JD-Core Version:    0.7.0.1
 */