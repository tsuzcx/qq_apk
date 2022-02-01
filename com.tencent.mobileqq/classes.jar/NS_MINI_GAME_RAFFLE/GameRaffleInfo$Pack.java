package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameRaffleInfo$Pack
  extends MessageMicro<Pack>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField business_cover = PBField.initString("");
  public final PBUInt32Field business_id = PBField.initUInt32(0);
  public final PBStringField business_logo = PBField.initString("");
  public final PBStringField business_name = PBField.initString("");
  public final PBStringField business_name_pic = PBField.initString("");
  public final PBStringField business_video = PBField.initString("");
  public final PBStringField business_video_cover = PBField.initString("");
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBUInt32Field money = PBField.initUInt32(0);
  public final PBUInt32Field mtime = PBField.initUInt32(0);
  public final PBStringField order = PBField.initString("");
  public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBStringField req_id = PBField.initString("");
  public final PBUInt64Field send_uin = PBField.initUInt64(0L);
  public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
  public final PBStringField wishing = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66, 72, 82, 88, 96, 106, 112, 122, 130, 138, 146, 154, 162, 170 }, new String[] { "pack_id", "state", "type", "ctime", "money", "business_id", "signature", "url", "mtime", "order", "uin", "send_uin", "wishing", "promotion_id", "req_id", "business_name", "business_logo", "business_cover", "business_video_cover", "business_video", "business_name_pic" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, "", Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", "", "", "", "", "", "" }, Pack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_GAME_RAFFLE.GameRaffleInfo.Pack
 * JD-Core Version:    0.7.0.1
 */