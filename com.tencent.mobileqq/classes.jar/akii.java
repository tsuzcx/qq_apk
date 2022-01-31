import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyTextInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public final class akii
  implements Runnable
{
  public akii(int paramInt, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString3, long paramLong3, String paramString4) {}
  
  public void run()
  {
    UniPacket localUniPacket = null;
    Object localObject = localUniPacket;
    if (this.jdField_a_of_type_Int > 0)
    {
      localObject = localUniPacket;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject = new cardDiyTextInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
      }
    }
    localObject = new SSummaryCardSetReq(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), 0L, "7.6.8", 109L, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Long, (cardDiyTextInfo)localObject, this.d);
    localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akii
 * JD-Core Version:    0.7.0.1
 */