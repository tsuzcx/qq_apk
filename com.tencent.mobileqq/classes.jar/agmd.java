import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementItem;

public class agmd
{
  public int a;
  public ArrayList<agme> a;
  public int b;
  
  public static agmd a(oidb_0xcf4.LoveAchievementInfo paramLoveAchievementInfo)
  {
    if (paramLoveAchievementInfo == null) {
      return null;
    }
    agmd localagmd = new agmd();
    if (paramLoveAchievementInfo.uint32_total_count.has()) {
      localagmd.jdField_a_of_type_Int = paramLoveAchievementInfo.uint32_total_count.get();
    }
    if (paramLoveAchievementInfo.uint32_completed_count.has()) {
      localagmd.b = paramLoveAchievementInfo.uint32_completed_count.get();
    }
    if (paramLoveAchievementInfo.rpt_life_ach_item.has())
    {
      paramLoveAchievementInfo = paramLoveAchievementInfo.rpt_life_ach_item.get().iterator();
      while (paramLoveAchievementInfo.hasNext())
      {
        oidb_0xcf4.LoveAchievementItem localLoveAchievementItem = (oidb_0xcf4.LoveAchievementItem)paramLoveAchievementInfo.next();
        agme localagme = agme.a(localLoveAchievementItem);
        if (localLoveAchievementItem != null)
        {
          if (localagmd.jdField_a_of_type_JavaUtilArrayList == null) {
            localagmd.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          localagmd.jdField_a_of_type_JavaUtilArrayList.add(localagme);
        }
      }
    }
    return localagmd;
  }
  
  public String toString()
  {
    return "LoveAchievementInfo{totalCount=" + this.jdField_a_of_type_Int + ", completedCount=" + this.b + ", achievements=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmd
 * JD-Core Version:    0.7.0.1
 */