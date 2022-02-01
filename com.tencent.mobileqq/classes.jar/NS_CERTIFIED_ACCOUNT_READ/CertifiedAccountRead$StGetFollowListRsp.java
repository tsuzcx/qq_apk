package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.PublicAccountInfo;

public final class CertifiedAccountRead$StGetFollowListRsp
  extends MessageMicro<StGetFollowListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_cmd0xcf8.PublicAccountInfo> account_list = PBField.initRepeatMessage(oidb_cmd0xcf8.PublicAccountInfo.class);
  public final PBStringField attach_info = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field has_next = PBField.initUInt32(0);
  public final PBUInt32Field refresh = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "extInfo", "seq", "attach_info", "refresh", "has_next", "account_list" }, new Object[] { null, localInteger, "", localInteger, localInteger, null }, StGetFollowListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListRsp
 * JD-Core Version:    0.7.0.1
 */