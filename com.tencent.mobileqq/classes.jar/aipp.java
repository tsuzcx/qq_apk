import android.os.SystemClock;

public abstract class aipp
{
  private long jdField_a_of_type_Long;
  private aipo jdField_a_of_type_Aipo;
  private long b;
  
  public aipp(long paramLong)
  {
    a(paramLong);
  }
  
  public final void a()
  {
    long l = this.jdField_a_of_type_Long - SystemClock.elapsedRealtime();
    if (l > 1000L)
    {
      b(l);
      return;
    }
    b();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aipo != null) {
      this.jdField_a_of_type_Aipo.a(paramLong);
    }
    this.b = paramLong;
    this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() + 1000L * paramLong);
  }
  
  public abstract void b();
  
  public abstract void b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipp
 * JD-Core Version:    0.7.0.1
 */