import java.util.Calendar;

class adzt
  implements aqxz
{
  final int jdField_a_of_type_Int;
  
  public adzt(adzq paramadzq, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_Int;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, adzq.a(this.jdField_a_of_type_Adzq) + adzq.d(this.jdField_a_of_type_Adzq));
    localCalendar.set(2, adzq.b(this.jdField_a_of_type_Adzq));
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return adzq.d(this.jdField_a_of_type_Adzq, paramInt2) + anzj.a(2131698936);
    case 1: 
      return adzq.e(this.jdField_a_of_type_Adzq, paramInt2) + anzj.a(2131698933);
    }
    return adzq.f(this.jdField_a_of_type_Adzq, paramInt2) + anzj.a(2131698934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzt
 * JD-Core Version:    0.7.0.1
 */