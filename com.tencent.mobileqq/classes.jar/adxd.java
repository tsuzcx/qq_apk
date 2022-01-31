import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class adxd
  extends alox
{
  public adxd(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_Akhm == null) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean1);
      this.a.jdField_a_of_type_JavaUtilMap = atwd.a().a(this.a.app, this.a.jdField_a_of_type_JavaUtilList);
    } while (this.a.jdField_a_of_type_JavaUtilMap == null);
    this.a.jdField_a_of_type_Akhm.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_Akhm.notifyDataSetChanged();
    this.a.b();
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if (this.a.jdField_a_of_type_Akhm == null) {
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
      this.a.jdField_a_of_type_Akhm.a(this.a.jdField_a_of_type_JavaUtilMap);
      this.a.jdField_a_of_type_Akhm.notifyDataSetChanged();
      this.a.b();
      return;
    }
    this.a.jdField_a_of_type_Akhm.notifyDataSetChanged();
    this.a.b();
    QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131721089), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxd
 * JD-Core Version:    0.7.0.1
 */