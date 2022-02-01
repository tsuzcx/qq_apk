import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class akbh
{
  int jdField_a_of_type_Int = 0;
  akbk jdField_a_of_type_Akbk;
  HashMap<String, PreloadManager.PathResult> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<DownloadParam> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public akbh(List<DownloadParam> paramList, akbk paramakbk)
  {
    this.jdField_a_of_type_JavaUtilList = paramakbk;
    Object localObject;
    this.jdField_a_of_type_Akbk = localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a(localDownloadParam, new akbi(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbh
 * JD-Core Version:    0.7.0.1
 */