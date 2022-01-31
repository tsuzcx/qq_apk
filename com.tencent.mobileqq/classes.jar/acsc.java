import android.content.SharedPreferences;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class acsc
  implements Runnable
{
  public acsc(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void run()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("手机相册", new ArrayList());
    localLinkedHashMap.put("已下载图片", new ArrayList());
    for (;;)
    {
      try
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          FileInfo localFileInfo = (FileInfo)localIterator.next();
          Object localObject3 = localFileInfo.a();
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            break label281;
          }
          Object localObject1 = localObject3;
          if (((String)localObject3).equalsIgnoreCase("QQfile_recv")) {
            break label281;
          }
          localObject3 = localObject1;
          if (localObject1.equalsIgnoreCase("camera") == true) {
            localObject3 = "手机相册";
          }
          if (!localLinkedHashMap.containsKey(localObject3)) {
            localLinkedHashMap.put(localObject3, new ArrayList());
          }
          ((List)localLinkedHashMap.get(localObject3)).add(localFileInfo);
          continue;
        }
        int i;
        int j;
        localObject2 = localLinkedHashMap.keySet().iterator();
      }
      catch (Exception localException)
      {
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getSharedPreferences("LAST_CHOOSE_", 0);
        i = ((SharedPreferences)localObject2).getInt("GROUP", -1);
        j = ((SharedPreferences)localObject2).getInt("CHILD", -1);
        QfileLocalFilePicTabView.a(this.a, new acsd(this, localLinkedHashMap, i, j));
        return;
      }
      while (((Iterator)localObject2).hasNext()) {
        if (((List)localLinkedHashMap.get((String)((Iterator)localObject2).next())).size() == 0) {
          ((Iterator)localObject2).remove();
        }
      }
      continue;
      label281:
      Object localObject2 = "已下载图片";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsc
 * JD-Core Version:    0.7.0.1
 */