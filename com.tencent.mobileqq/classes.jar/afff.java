import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class afff
  extends osp
{
  public afff(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void f(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.c.clear();
        this.a.c.addAll(paramList);
      }
      ClassificationSearchActivity.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afff
 * JD-Core Version:    0.7.0.1
 */