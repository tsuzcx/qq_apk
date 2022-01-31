import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class acfx
  extends ajxl
{
  public acfx(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_Aiqd == null) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean1);
      this.a.jdField_a_of_type_JavaUtilMap = asfb.a().a(this.a.app, this.a.jdField_a_of_type_JavaUtilList);
    } while (this.a.jdField_a_of_type_JavaUtilMap == null);
    this.a.jdField_a_of_type_Aiqd.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_Aiqd.notifyDataSetChanged();
    this.a.b();
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if (this.a.jdField_a_of_type_Aiqd == null) {
      return;
    }
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Integer localInteger = (Integer)paramMap.get(str);
        if (localInteger != null) {
          this.a.jdField_a_of_type_JavaUtilMap.put(str, localInteger);
        }
      }
      this.a.jdField_a_of_type_Aiqd.a(this.a.jdField_a_of_type_JavaUtilMap);
      this.a.jdField_a_of_type_Aiqd.notifyDataSetChanged();
      this.a.b();
      return;
    }
    this.a.jdField_a_of_type_Aiqd.notifyDataSetChanged();
    this.a.b();
    bcpw.a(this.a.app.getApp(), 1, this.a.getString(2131720538), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfx
 * JD-Core Version:    0.7.0.1
 */