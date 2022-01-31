import android.text.TextUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ahky
  implements Runnable
{
  public ahky(PtvTemplateManager paramPtvTemplateManager, File paramFile, Runnable paramRunnable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, String.format("双人挂件加载 start, rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    Object localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return;
      ??? = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager, (String)localObject1);
      if ((??? == null) || (((List)???).isEmpty())) {
        continue;
      }
      localObject1 = new ArrayList();
      int i = UITools.a();
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "cur version:" + i);
      }
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, String.format("the pandent[%s], platform[%s]", new Object[] { localPtvTemplateInfo.id, Integer.valueOf(localPtvTemplateInfo.platform) }));
        }
        if ((localPtvTemplateInfo.platform == 0) || (i >= localPtvTemplateInfo.platform))
        {
          localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
          ((List)localObject1).add(localPtvTemplateInfo);
        }
        else if (QLog.isDevelopLevel())
        {
          QLog.d("PtvTemplateManager", 4, String.format("双人挂件加载, platform不符合, %s", new Object[] { localPtvTemplateInfo }));
        }
      }
      boolean bool;
      if (QLog.isDevelopLevel())
      {
        i = ((List)localObject1).size();
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          break label373;
        }
        bool = true;
        QLog.d("PtvTemplateManager", 2, String.format("双人挂件加载 size[%s], onInitFinishSink[%s], mVersion[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.f }));
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.c.clear();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.c.addAll((Collection)localObject1);
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          continue;
        }
        this.jdField_a_of_type_JavaLangRunnable.run();
        return;
        label373:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahky
 * JD-Core Version:    0.7.0.1
 */