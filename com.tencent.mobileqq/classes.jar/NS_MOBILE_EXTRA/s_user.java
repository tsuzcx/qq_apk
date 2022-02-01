package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_user
  extends JceStruct
{
  public boolean isSuperLike = false;
  public String nickname = "";
  public long uin = 0L;
  
  public s_user() {}
  
  public s_user(long paramLong, String paramString, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.nickname = paramString;
    this.isSuperLike = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.isSuperLike = paramJceInputStream.read(this.isSuperLike, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    paramJceOutputStream.write(this.isSuperLike, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_user
 * JD-Core Version:    0.7.0.1
 */