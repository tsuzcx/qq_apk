import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;

public class aarg
  implements andg
{
  public aarg(EmosmActivity paramEmosmActivity) {}
  
  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.a.getItem(paramInt1);
      this.a.a.a(localEmoticonPackage);
      this.a.a.b(true);
      this.a.a.a(localEmoticonPackage, paramInt2);
      anfi.a().a(localEmoticonPackage, paramInt1, paramInt2);
      this.a.c = true;
      awqx.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarg
 * JD-Core Version:    0.7.0.1
 */