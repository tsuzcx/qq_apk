import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;

public class acwj
  implements appk
{
  public acwj(EmosmActivity paramEmosmActivity) {}
  
  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.a.getItem(paramInt1);
      this.a.a.a(localEmoticonPackage);
      this.a.a.b(true);
      this.a.a.a(localEmoticonPackage, paramInt2);
      aprn.a().a(localEmoticonPackage, paramInt1, paramInt2);
      this.a.d = true;
      azqs.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
      if (this.a.b == 1) {
        azqs.b(this.a.app, "dc00898", "", "", "0X800AB10", "0X800AB10", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    azqs.b(this.a.app, "dc00898", "", "", "0X800AB18", "0X800AB18", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwj
 * JD-Core Version:    0.7.0.1
 */