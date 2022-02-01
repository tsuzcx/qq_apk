import java.util.ArrayList;

public class alsh
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
      alsh localalsh = (alsh)super.clone();
      localObject = localalsh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsh
 * JD-Core Version:    0.7.0.1
 */