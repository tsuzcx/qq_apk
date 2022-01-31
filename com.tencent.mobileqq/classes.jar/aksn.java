import java.util.ArrayList;

public class aksn
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
      aksn localaksn = (aksn)super.clone();
      localObject = localaksn;
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
 * Qualified Name:     aksn
 * JD-Core Version:    0.7.0.1
 */