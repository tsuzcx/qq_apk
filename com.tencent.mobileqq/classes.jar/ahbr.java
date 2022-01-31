import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ahbr
{
  int jdField_a_of_type_Int = 0;
  ahbu jdField_a_of_type_Ahbu;
  HashMap<String, PreloadManager.PathResult> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<DownloadParam> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public ahbr(List<DownloadParam> paramList, ahbu paramahbu)
  {
    this.jdField_a_of_type_JavaUtilList = paramahbu;
    Object localObject;
    this.jdField_a_of_type_Ahbu = localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a(localDownloadParam, new ahbs(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbr
 * JD-Core Version:    0.7.0.1
 */