package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class MiniAppMidasPay$StWxpayUnifiedOrderRsp
  extends MessageMicro<StWxpayUnifiedOrderRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "body" }, new Object[] { null, localByteStringMicro }, StWxpayUnifiedOrderRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayUnifiedOrderRsp
 * JD-Core Version:    0.7.0.1
 */