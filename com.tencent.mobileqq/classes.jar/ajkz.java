import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.UUID;

public class ajkz
  implements ProxyListener
{
  public ajkz(TroopFileDataBaseProxy paramTroopFileDataBaseProxy, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void a(String paramString)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish[add]. table:" + paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish. table:" + paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish[del]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkz
 * JD-Core Version:    0.7.0.1
 */