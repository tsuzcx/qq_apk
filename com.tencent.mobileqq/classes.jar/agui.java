import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;

public class agui
  implements Runnable
{
  public agui(VipProfileCardBaseActivity paramVipProfileCardBaseActivity, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = new SSummaryCardSetReq(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardBaseActivity.app.getCurrentAccountUin()), 0L, "7.6.8", 109L, this.jdField_a_of_type_Long, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null, null);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardBaseActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardBaseActivity.app.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agui
 * JD-Core Version:    0.7.0.1
 */