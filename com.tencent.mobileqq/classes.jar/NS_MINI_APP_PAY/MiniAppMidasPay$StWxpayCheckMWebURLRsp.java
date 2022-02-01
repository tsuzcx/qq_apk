package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MiniAppMidasPay$StWxpayCheckMWebURLRsp
  extends MessageMicro<StWxpayCheckMWebURLRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "is_valid" }, new Object[] { null, Integer.valueOf(0) }, StWxpayCheckMWebURLRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field is_valid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayCheckMWebURLRsp
 * JD-Core Version:    0.7.0.1
 */