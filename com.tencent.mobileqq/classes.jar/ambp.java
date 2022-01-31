public class ambp
  implements alpg
{
  public void a(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      a(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambp
 * JD-Core Version:    0.7.0.1
 */