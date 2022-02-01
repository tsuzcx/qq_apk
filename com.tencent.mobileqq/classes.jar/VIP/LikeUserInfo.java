package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LikeUserInfo
  extends JceStruct
{
  public long iLikeNum = 0L;
  public long iUin = 0L;
  public boolean isFriend = true;
  public String sNickName = "";
  
  public LikeUserInfo() {}
  
  public LikeUserInfo(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    this.iUin = paramLong1;
    this.sNickName = paramString;
    this.iLikeNum = paramLong2;
    this.isFriend = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.sNickName = paramJceInputStream.readString(1, false);
    this.iLikeNum = paramJceInputStream.read(this.iLikeNum, 2, false);
    this.isFriend = paramJceInputStream.read(this.isFriend, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.sNickName != null) {
      paramJceOutputStream.write(this.sNickName, 1);
    }
    paramJceOutputStream.write(this.iLikeNum, 2);
    paramJceOutputStream.write(this.isFriend, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.LikeUserInfo
 * JD-Core Version:    0.7.0.1
 */