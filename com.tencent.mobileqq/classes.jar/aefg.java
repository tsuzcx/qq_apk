import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import tencent.im.oidb.cmd0x72d.cmd0x72d.ReqBody;

public class aefg
  implements Runnable
{
  public aefg(TroopAssistantManager paramTroopAssistantManager, QQAppInterface paramQQAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqManagersTroopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    cmd0x72d.ReqBody localReqBody = new cmd0x72d.ReqBody();
    localReqBody.rpt_uint64_groupcode.set(localList);
    ProtoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x72d_0", 1837, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefg
 * JD-Core Version:    0.7.0.1
 */