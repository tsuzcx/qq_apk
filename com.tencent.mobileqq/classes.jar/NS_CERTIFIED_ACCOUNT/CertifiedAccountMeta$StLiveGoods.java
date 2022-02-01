package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountMeta$StLiveGoods
  extends MessageMicro<StLiveGoods>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field curPrice = PBField.initInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField goodsId = PBField.initString("");
  public final PBStringField imgUrl = PBField.initString("");
  public final PBInt32Field inventory = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBInt32Field orgPrice = PBField.initInt32(0);
  public final PBStringField saleTip = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66 }, new String[] { "goodsId", "imgUrl", "name", "desc", "curPrice", "orgPrice", "inventory", "saleTip" }, new Object[] { "", "", "", "", localInteger, localInteger, localInteger, "" }, StLiveGoods.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLiveGoods
 * JD-Core Version:    0.7.0.1
 */