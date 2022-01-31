import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class acyp
  implements Runnable
{
  acyp(acyo paramacyo) {}
  
  public void run()
  {
    if (QfileLocalFileDelAppTabView.a(this.a.a) != null)
    {
      Iterator localIterator = QfileLocalFileDelAppTabView.b(this.a.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)QfileLocalFileDelAppTabView.c(this.a.a).get(str)).size() == 0) {
          localIterator.remove();
        }
      }
    }
    QfileLocalFileDelAppTabView.d(this.a.a).clear();
    QfileLocalFileDelAppTabView.f(this.a.a).putAll(QfileLocalFileDelAppTabView.e(this.a.a));
    this.a.a.i();
    this.a.a.setSelect(0);
    QfileLocalFileDelAppTabView.g(this.a.a).clear();
    this.a.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyp
 * JD-Core Version:    0.7.0.1
 */