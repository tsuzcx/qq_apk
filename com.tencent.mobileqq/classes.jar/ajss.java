public class ajss
  implements ajfe
{
  protected void a(boolean paramBoolean, axau paramaxau) {}
  
  protected void b(boolean paramBoolean, axau paramaxau) {}
  
  protected void c(boolean paramBoolean, axau paramaxau) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (axau)paramObject);
      return;
    case 1: 
      c(paramBoolean, (axau)paramObject);
      return;
    }
    a(paramBoolean, (axau)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajss
 * JD-Core Version:    0.7.0.1
 */