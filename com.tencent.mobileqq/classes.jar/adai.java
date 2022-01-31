import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class adai
  implements Runnable
{
  public adai(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, Context paramContext) {}
  
  public void run()
  {
    HashMap localHashMap = (HashMap)FileCategoryUtil.a(this.jdField_a_of_type_AndroidContentContext);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      FileCategoryUtil.a(true, FMSettings.a().b(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      Object localObject1 = FMSettings.a().a();
      if (localObject1 != null) {
        FileCategoryUtil.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      }
      FileCategoryUtil.a(localHashMap);
      if (localHashMap != null)
      {
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if ("QQfile_recv".equalsIgnoreCase((String)localObject2) != true)
          {
            localObject2 = (List)localHashMap.get(localObject2);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.a.addAll((Collection)localObject2);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adai
 * JD-Core Version:    0.7.0.1
 */