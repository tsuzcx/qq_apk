package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CKV_LikeUserInfo
  extends JceStruct
{
  public long iLstQueryTime;
  public long iUin;
  public boolean isFriend = true;
  public String sNickName = "";
  
  public CKV_LikeUserInfo() {}
  
  public CKV_LikeUserInfo(long paramLong1, String paramString, boolean paramBoolean, long paramLong2)
  {
    this.iUin = paramLong1;
    this.sNickName = paramString;
    this.isFriend = paramBoolean;
    this.iLstQueryTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.sNickName = paramJceInputStream.readString(1, false);
    this.isFriend = paramJceInputStream.read(this.isFriend, 2, false);
    this.iLstQueryTime = paramJceInputStream.read(this.iLstQueryTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.sNickName != null) {
      paramJceOutputStream.write(this.sNickName, 1);
    }
    paramJceOutputStream.write(this.isFriend, 2);
    paramJceOutputStream.write(this.iLstQueryTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.CKV_LikeUserInfo
 * JD-Core Version:    0.7.0.1
 */