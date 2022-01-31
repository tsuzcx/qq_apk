import java.util.Comparator;

public class ahyt
  implements Comparator<ahyq>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public ahyt(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(ahyq paramahyq1, ahyq paramahyq2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramahyq1.c.compareToIgnoreCase(paramahyq2.c);
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
            if (paramahyq1.jdField_b_of_type_Long == paramahyq2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramahyq1.jdField_b_of_type_Long <= paramahyq2.jdField_b_of_type_Long) {
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
          if (paramahyq1.a == paramahyq2.a) {
            return 0;
          }
          if (paramahyq1.a <= paramahyq2.a) {
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
        if (paramahyq1.d != paramahyq2.d) {
          break;
        }
        j = paramahyq1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramahyq2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramahyq1.d >= paramahyq2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramahyq1.l == paramahyq2.l) {
        return paramahyq1.c.compareToIgnoreCase(paramahyq2.c);
      }
      return paramahyq2.l - paramahyq1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyt
 * JD-Core Version:    0.7.0.1
 */