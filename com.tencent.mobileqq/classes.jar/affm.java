import android.support.annotation.IntRange;

public abstract interface affm
{
  public abstract void a();
  
  public abstract boolean a(@IntRange(from=0L, to=3L) int paramInt);
  
  public abstract boolean a(@IntRange(from=0L, to=3L) int paramInt, String paramString1, String paramString2);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affm
 * JD-Core Version:    0.7.0.1
 */