import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.List;
import java.util.Map;

class akxi
  implements aldq
{
  akxi(akxg paramakxg, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    List localList = (List)akxg.a(this.jdField_a_of_type_Akxg).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip")) {
      akxg.a(this.jdField_a_of_type_Akxg, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, paramPathResult.folderPath, localList);
    }
    while (!paramPathResult.url.endsWith(".png")) {
      return;
    }
    akxg.a(this.jdField_a_of_type_Akxg, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxi
 * JD-Core Version:    0.7.0.1
 */