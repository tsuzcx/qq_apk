public class alyr
  implements alkr
{
  protected void a(boolean paramBoolean, azyv paramazyv) {}
  
  protected void b(boolean paramBoolean, azyv paramazyv) {}
  
  protected void c(boolean paramBoolean, azyv paramazyv) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (azyv)paramObject);
      return;
    case 1: 
      c(paramBoolean, (azyv)paramObject);
      return;
    }
    a(paramBoolean, (azyv)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyr
 * JD-Core Version:    0.7.0.1
 */