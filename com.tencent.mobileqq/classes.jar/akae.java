import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.Iterator;
import java.util.List;

public class akae
  extends akac
{
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public akae(boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((paramAppInfo != null) && (paramAppInfo.missions != null)) {
      this.jdField_a_of_type_JavaUtilList = paramAppInfo.missions.get();
    }
  }
  
  public String a()
  {
    String str = String.format("&hasRedDot=%b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("_");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return str + String.format("&missions=%s", new Object[] { localStringBuilder.toString() });
    }
    return str;
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("need_fill_red_point_info=1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akae
 * JD-Core Version:    0.7.0.1
 */