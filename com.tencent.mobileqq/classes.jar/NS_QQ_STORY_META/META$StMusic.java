package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META$StMusic
  extends MessageMicro<StMusic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 120, 130, 136, 146, 154, 162, 168, 178, 186, 194, 200 }, new String[] { "uiSongId", "strSongMid", "strSongName", "strLanguage", "iTrySize", "iTryBegin", "iTryEnd", "iPlayTime", "strPlayUrl", "iSize", "copyright", "strFormat", "strLyric", "iType", "iStartPos", "strLabel", "uiAlbumId", "strAlbumMid", "strAlbumName", "strAlbumPic", "uiSingerId", "strSingerMid", "strSingerName", "strSingerPic", "iFrom" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), "", "", "", Integer.valueOf(0) }, StMusic.class);
  public final PBInt32Field copyright = PBField.initInt32(0);
  public final PBInt32Field iFrom = PBField.initInt32(0);
  public final PBInt32Field iPlayTime = PBField.initInt32(0);
  public final PBInt32Field iSize = PBField.initInt32(0);
  public final PBUInt64Field iStartPos = PBField.initUInt64(0L);
  public final PBInt32Field iTryBegin = PBField.initInt32(0);
  public final PBInt32Field iTryEnd = PBField.initInt32(0);
  public final PBInt32Field iTrySize = PBField.initInt32(0);
  public final PBInt32Field iType = PBField.initInt32(0);
  public final PBStringField strAlbumMid = PBField.initString("");
  public final PBStringField strAlbumName = PBField.initString("");
  public final PBStringField strAlbumPic = PBField.initString("");
  public final PBStringField strFormat = PBField.initString("");
  public final PBStringField strLabel = PBField.initString("");
  public final PBStringField strLanguage = PBField.initString("");
  public final PBStringField strLyric = PBField.initString("");
  public final PBStringField strPlayUrl = PBField.initString("");
  public final PBStringField strSingerMid = PBField.initString("");
  public final PBStringField strSingerName = PBField.initString("");
  public final PBStringField strSingerPic = PBField.initString("");
  public final PBStringField strSongMid = PBField.initString("");
  public final PBStringField strSongName = PBField.initString("");
  public final PBUInt64Field uiAlbumId = PBField.initUInt64(0L);
  public final PBUInt64Field uiSingerId = PBField.initUInt64(0L);
  public final PBUInt64Field uiSongId = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StMusic
 * JD-Core Version:    0.7.0.1
 */