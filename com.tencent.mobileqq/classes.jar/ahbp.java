import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ahbp
{
  int jdField_a_of_type_Int = 0;
  ahbs jdField_a_of_type_Ahbs;
  HashMap<String, PreloadManager.PathResult> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<DownloadParam> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public ahbp(List<DownloadParam> paramList, ahbs paramahbs)
  {
    this.jdField_a_of_type_JavaUtilList = paramahbs;
    Object localObject;
    this.jdField_a_of_type_Ahbs = localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a(localDownloadParam, new ahbq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbp
 * JD-Core Version:    0.7.0.1
 */