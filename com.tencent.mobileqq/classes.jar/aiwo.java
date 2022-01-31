import java.util.ArrayList;

public class aiwo
  implements Cloneable
{
  public int a;
  public long a;
  public ArrayList<String> a;
  public int b;
  public int c;
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      aiwo localaiwo = (aiwo)super.clone();
      localObject = localaiwo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.a != null) {
      localObject.a = ((ArrayList)this.a.clone());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwo
 * JD-Core Version:    0.7.0.1
 */