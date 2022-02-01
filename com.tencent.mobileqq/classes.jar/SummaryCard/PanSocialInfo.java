package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PanSocialInfo
  extends JceStruct
{
  public String strLevelType = "";
  public long uCharm = 0L;
  public long uCharmLevel = 0L;
  public long uCharmRank = 0L;
  public long uChatflag = 0L;
  public long uChatupCount = 0L;
  public long uCurLevelCharm = 0L;
  public long uNextLevelCharm = 0L;
  
  public PanSocialInfo() {}
  
  public PanSocialInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, String paramString)
  {
    this.uCharmRank = paramLong1;
    this.uChatflag = paramLong2;
    this.uChatupCount = paramLong3;
    this.uCharm = paramLong4;
    this.uCharmLevel = paramLong5;
    this.uNextLevelCharm = paramLong6;
    this.uCurLevelCharm = paramLong7;
    this.strLevelType = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCharmRank = paramJceInputStream.read(this.uCharmRank, 0, false);
    this.uChatflag = paramJceInputStream.read(this.uChatflag, 1, false);
    this.uChatupCount = paramJceInputStream.read(this.uChatupCount, 2, false);
    this.uCharm = paramJceInputStream.read(this.uCharm, 3, false);
    this.uCharmLevel = paramJceInputStream.read(this.uCharmLevel, 4, false);
    this.uNextLevelCharm = paramJceInputStream.read(this.uNextLevelCharm, 5, false);
    this.uCurLevelCharm = paramJceInputStream.read(this.uCurLevelCharm, 6, false);
    this.strLevelType = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCharmRank, 0);
    paramJceOutputStream.write(this.uChatflag, 1);
    paramJceOutputStream.write(this.uChatupCount, 2);
    paramJceOutputStream.write(this.uCharm, 3);
    paramJceOutputStream.write(this.uCharmLevel, 4);
    paramJceOutputStream.write(this.uNextLevelCharm, 5);
    paramJceOutputStream.write(this.uCurLevelCharm, 6);
    String str = this.strLevelType;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.PanSocialInfo
 * JD-Core Version:    0.7.0.1
 */