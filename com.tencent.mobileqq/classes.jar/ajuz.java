import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.List;
import java.util.Map;

class ajuz
  implements akbj
{
  ajuz(ajux paramajux, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    List localList = (List)ajux.a(this.jdField_a_of_type_Ajux).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip")) {
      ajux.a(this.jdField_a_of_type_Ajux, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, paramPathResult.folderPath, localList);
    }
    while (!paramPathResult.url.endsWith(".png")) {
      return;
    }
    ajux.a(this.jdField_a_of_type_Ajux, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuz
 * JD-Core Version:    0.7.0.1
 */