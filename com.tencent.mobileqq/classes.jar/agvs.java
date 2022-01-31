import android.os.SystemClock;

public abstract class agvs
{
  private long jdField_a_of_type_Long;
  private agvr jdField_a_of_type_Agvr;
  private long b;
  
  public agvs(long paramLong)
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
    if (this.jdField_a_of_type_Agvr != null) {
      this.jdField_a_of_type_Agvr.a(paramLong);
    }
    this.b = paramLong;
    this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() + 1000L * paramLong);
  }
  
  public abstract void b();
  
  public abstract void b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvs
 * JD-Core Version:    0.7.0.1
 */