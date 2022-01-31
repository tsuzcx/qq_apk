import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class ajzx
  implements ajtd
{
  private List<String> a = new ArrayList();
  
  public List<String> a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (!this.a.isEmpty())) {
      return this.a;
    }
    return null;
  }
  
  public void a()
  {
    if (this.a.isEmpty()) {
      this.a.add("100066");
    }
  }
  
  public void b()
  {
    if (!this.a.isEmpty()) {
      this.a.remove("100066");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzx
 * JD-Core Version:    0.7.0.1
 */