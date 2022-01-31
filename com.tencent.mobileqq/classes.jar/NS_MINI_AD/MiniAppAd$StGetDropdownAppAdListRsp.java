package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetDropdownAppAdListRsp
  extends MessageMicro<StGetDropdownAppAdListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "vecAppAdInfo", "gdt_cookie" }, new Object[] { null, null, "" }, StGetDropdownAppAdListRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField gdt_cookie = PBField.initString("");
  public final PBRepeatMessageField<MiniAppAd.StAppAdInfo> vecAppAdInfo = PBField.initRepeatMessage(MiniAppAd.StAppAdInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetDropdownAppAdListRsp
 * JD-Core Version:    0.7.0.1
 */