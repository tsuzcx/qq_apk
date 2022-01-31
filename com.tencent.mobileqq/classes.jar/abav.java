import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;

public class abav
  implements antt
{
  public abav(EmosmActivity paramEmosmActivity) {}
  
  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.a.getItem(paramInt1);
      this.a.a.a(localEmoticonPackage);
      this.a.a.b(true);
      this.a.a.a(localEmoticonPackage, paramInt2);
      anvw.a().a(localEmoticonPackage, paramInt1, paramInt2);
      this.a.d = true;
      axqy.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
      if (this.a.b == 1) {
        axqy.b(this.a.app, "dc00898", "", "", "0X800AB10", "0X800AB10", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    axqy.b(this.a.app, "dc00898", "", "", "0X800AB18", "0X800AB18", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abav
 * JD-Core Version:    0.7.0.1
 */