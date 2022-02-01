package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WEISHI$stMetaFeed
  extends MessageMicro<stMetaFeed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 58, 210, 218 }, new String[] { "id", "wording", "type", "poster_id", "images", "video_url", "material_thumburl" }, new Object[] { "", "", Integer.valueOf(0), "", null, "", "" }, stMetaFeed.class);
  public final PBStringField id = PBField.initString("");
  public final PBRepeatMessageField<WEISHI.stMetaUgcImage> images = PBField.initRepeatMessage(WEISHI.stMetaUgcImage.class);
  public final PBStringField material_thumburl = PBField.initString("");
  public final PBStringField poster_id = PBField.initString("");
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBStringField video_url = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     WEISHI_USER_GROWTH.WEISHI.stMetaFeed
 * JD-Core Version:    0.7.0.1
 */