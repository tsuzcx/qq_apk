package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NotBindContactNotFriendInfo
  extends JceStruct
{
  static byte[] cache_MobileNoMask = (byte[])new byte[1];
  public byte[] MobileNoMask = null;
  public int age = 0;
  public String contactsInfoEncrypt = "";
  public boolean isNew = false;
  public String nickname = "";
  public int sameFriend = 0;
  public int sex = 0;
  public long uAbiFlag = 0L;
  
  static
  {
    ((byte[])cache_MobileNoMask)[0] = 0;
  }
  
  public NotBindContactNotFriendInfo() {}
  
  public NotBindContactNotFriendInfo(String paramString1, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2)
  {
    this.contactsInfoEncrypt = paramString1;
    this.MobileNoMask = paramArrayOfByte;
    this.uAbiFlag = paramLong;
    this.sex = paramInt1;
    this.age = paramInt2;
    this.sameFriend = paramInt3;
    this.isNew = paramBoolean;
    this.nickname = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contactsInfoEncrypt = paramJceInputStream.readString(0, true);
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 1, true));
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 2, false);
    this.sex = paramJceInputStream.read(this.sex, 3, false);
    this.age = paramJceInputStream.read(this.age, 4, false);
    this.sameFriend = paramJceInputStream.read(this.sameFriend, 5, false);
    this.isNew = paramJceInputStream.read(this.isNew, 6, false);
    this.nickname = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contactsInfoEncrypt, 0);
    paramJceOutputStream.write(this.MobileNoMask, 1);
    paramJceOutputStream.write(this.uAbiFlag, 2);
    paramJceOutputStream.write(this.sex, 3);
    paramJceOutputStream.write(this.age, 4);
    paramJceOutputStream.write(this.sameFriend, 5);
    paramJceOutputStream.write(this.isNew, 6);
    String str = this.nickname;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.NotBindContactNotFriendInfo
 * JD-Core Version:    0.7.0.1
 */