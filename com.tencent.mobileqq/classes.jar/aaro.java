import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aaro
  implements arok<List<EmoticonPackage>>
{
  public aaro(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.a.jdField_a_of_type_Ancr != null) {
      this.a.jdField_a_of_type_Ancr.a();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.a.b == 1)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.a.b == 2)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.a.jdField_a_of_type_Ancr != null) {
      this.a.jdField_a_of_type_Ancr.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaro
 * JD-Core Version:    0.7.0.1
 */