package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CLIENT$StSmartMatchMusicReq
  extends MessageMicro<StSmartMatchMusicReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cameraType = PBField.initUInt32(0);
  public final PBUInt32Field dataType = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBDoubleField fLat = PBField.initDouble(0.0D);
  public final PBDoubleField fLon = PBField.initDouble(0.0D);
  public final PBRepeatField<ByteStringMicro> vecPicBuff = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField videoBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field videoDuration = PBField.initUInt32(0);
  public final PBDoubleField videoLat = PBField.initDouble(0.0D);
  public final PBDoubleField videoLon = PBField.initDouble(0.0D);
  public final PBUInt64Field videoTime = PBField.initUInt64(0L);
  public final PBUInt32Field videoType = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 49, 57, 64, 72, 81, 89, 96 }, new String[] { "extInfo", "videoBuff", "videoDuration", "dataType", "vecPicBuff", "fLat", "fLon", "videoType", "cameraType", "videoLat", "videoLon", "videoTime" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L) }, StSmartMatchMusicReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicReq
 * JD-Core Version:    0.7.0.1
 */