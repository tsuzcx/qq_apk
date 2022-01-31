import android.content.res.Resources;
import com.tencent.mobileqq.utils.AudioHelper;

public abstract class aark
{
  final String c;
  public int g = 1;
  
  aark(String paramString)
  {
    this.c = (paramString + "_" + AudioHelper.a());
  }
  
  abstract void a();
  
  final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g = 20;
      return;
    }
    this.g = 36;
  }
  
  public final boolean a()
  {
    return (this.g != 20) && (this.g != 2);
  }
  
  abstract boolean a(Resources paramResources);
  
  public final void b()
  {
    this.g = 2;
  }
  
  public final boolean b()
  {
    return (this.g & 0x2) == 2;
  }
  
  public final void c()
  {
    this.g = 1;
    a();
  }
  
  public final boolean c()
  {
    return (this.g & 0x14) == 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aark
 * JD-Core Version:    0.7.0.1
 */