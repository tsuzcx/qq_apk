import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementItem;

public class agme
{
  public int a;
  public String a;
  public int b;
  
  public static agme a(oidb_0xcf4.LoveAchievementItem paramLoveAchievementItem)
  {
    Object localObject;
    if ((paramLoveAchievementItem == null) || (!paramLoveAchievementItem.has())) {
      localObject = null;
    }
    agme localagme;
    do
    {
      return localObject;
      localagme = new agme();
      if (paramLoveAchievementItem.uint32_achievement_id.has()) {
        localagme.jdField_a_of_type_Int = paramLoveAchievementItem.uint32_achievement_id.get();
      }
      if (paramLoveAchievementItem.str_achievement_backurl.has()) {
        localagme.jdField_a_of_type_JavaLangString = paramLoveAchievementItem.str_achievement_backurl.get();
      }
      localObject = localagme;
    } while (!paramLoveAchievementItem.clockState.has());
    localagme.b = paramLoveAchievementItem.clockState.get();
    return localagme;
  }
  
  public String toString()
  {
    return "LoveAchievementItem{id=" + this.jdField_a_of_type_Int + ", backUrl=" + this.jdField_a_of_type_JavaLangString + ", clockStatus=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agme
 * JD-Core Version:    0.7.0.1
 */