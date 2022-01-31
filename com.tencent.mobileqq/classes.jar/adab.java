import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class adab
  implements Runnable
{
  public adab(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, int paramInt, Context paramContext) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap;
    Iterator localIterator;
    String str;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      localMap = FileCategoryUtil.c(this.jdField_a_of_type_AndroidContentContext);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("QQfile_recv") != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    if ((this.jdField_a_of_type_Int & 0x2) > 0)
    {
      localMap = FileCategoryUtil.b(this.jdField_a_of_type_AndroidContentContext);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("QQfile_recv") != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adab
 * JD-Core Version:    0.7.0.1
 */