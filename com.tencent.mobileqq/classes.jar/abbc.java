import android.view.View;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.Iterator;
import java.util.List;

public class abbc
  implements askq<List<EmoticonPackage>>
{
  public abbc(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      this.a.g.setVisibility(8);
    }
    do
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramList.next();
        if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
          this.a.c = true;
        }
      }
    } while (this.a.c);
    this.a.g.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abbc
 * JD-Core Version:    0.7.0.1
 */