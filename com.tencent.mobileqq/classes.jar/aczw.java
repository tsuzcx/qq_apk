import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class aczw
  implements Runnable
{
  aczw(aczv paramaczv) {}
  
  public void run()
  {
    if (this.a.a.b != null)
    {
      Iterator localIterator = this.a.a.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)this.a.a.b.get(str)).size() == 0) {
          localIterator.remove();
        }
      }
    }
    this.a.a.a.putAll(this.a.a.b);
    this.a.a.i();
    this.a.a.setSelect(0);
    this.a.a.b.clear();
    this.a.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczw
 * JD-Core Version:    0.7.0.1
 */