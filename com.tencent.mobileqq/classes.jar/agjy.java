import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.List;
import java.util.Map;

class agjy
  implements agpe
{
  agjy(agjw paramagjw, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    List localList = (List)agjw.a(this.jdField_a_of_type_Agjw).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip")) {
      agjw.a(this.jdField_a_of_type_Agjw, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, paramPathResult.folderPath, localList);
    }
    while (!paramPathResult.url.endsWith(".png")) {
      return;
    }
    agjw.a(this.jdField_a_of_type_Agjw, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agjy
 * JD-Core Version:    0.7.0.1
 */