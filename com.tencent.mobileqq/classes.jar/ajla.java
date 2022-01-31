import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.UUID;

public class ajla
  implements ProxyListener
{
  public ajla(TroopFileDataBaseProxy paramTroopFileDataBaseProxy, UUID paramUUID) {}
  
  public void a(String paramString)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    TroopFileTransferUtil.Log.d("TroopFileDataBaseProxy", TroopFileTransferUtil.Log.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajla
 * JD-Core Version:    0.7.0.1
 */