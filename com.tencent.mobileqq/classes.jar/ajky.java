import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.UUID;

public class ajky
  implements ProxyListener
{
  public ajky(TroopFileDataBaseProxy paramTroopFileDataBaseProxy, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void a(String paramString)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish. table:" + paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish[up]. table:" + paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish[del]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajky
 * JD-Core Version:    0.7.0.1
 */