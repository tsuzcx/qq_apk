import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequest;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoResponse;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

public class ajlb
  implements Runnable
{
  public long a;
  public TroopFileProtoReqMgr.ProtoResponse a;
  public NewIntent a;
  public boolean a;
  long b;
  public boolean b;
  public long c;
  public boolean c = false;
  
  public ajlb(TroopFileProtoReqMgr paramTroopFileProtoReqMgr)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_MqqAppNewIntent.getIntExtra("key_runnable_index", 0);
    TroopFileTransferUtil.Log.c("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.a, "cookie<" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_b_of_type_Long + "> sendToMsf. scheduleIndex:" + i + " timeOut:" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("timeout", this.jdField_a_of_type_Long);
    MessageObserver.StatictisInfo localStatictisInfo = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    localStatictisInfo.c += 1;
    TroopFileProtoReqMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr).put(this.jdField_a_of_type_MqqAppNewIntent, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr.a(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlb
 * JD-Core Version:    0.7.0.1
 */