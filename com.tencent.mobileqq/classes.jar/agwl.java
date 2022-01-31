import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.List;
import java.util.Map;

class agwl
  implements ahbr
{
  agwl(agwj paramagwj, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    List localList = (List)agwj.a(this.jdField_a_of_type_Agwj).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip")) {
      agwj.a(this.jdField_a_of_type_Agwj, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, paramPathResult.folderPath, localList);
    }
    while (!paramPathResult.url.endsWith(".png")) {
      return;
    }
    agwj.a(this.jdField_a_of_type_Agwj, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwl
 * JD-Core Version:    0.7.0.1
 */