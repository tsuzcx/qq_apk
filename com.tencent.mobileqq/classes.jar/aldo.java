import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aldo
{
  int jdField_a_of_type_Int = 0;
  aldr jdField_a_of_type_Aldr;
  HashMap<String, PreloadManager.PathResult> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<DownloadParam> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public aldo(List<DownloadParam> paramList, aldr paramaldr)
  {
    this.jdField_a_of_type_JavaUtilList = paramaldr;
    Object localObject;
    this.jdField_a_of_type_Aldr = localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a(localDownloadParam, new aldp(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldo
 * JD-Core Version:    0.7.0.1
 */