package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MobileContactsNotFriendInfo
  extends JceStruct
{
  static byte[] cache_MobileNoMask = (byte[])new byte[1];
  static int cache_conType;
  static int cache_eNetworkType;
  static byte[] cache_personalSign;
  public byte[] MobileNoMask;
  public int accountAbi = 0;
  public int age;
  public long bindingDate;
  public int conType = 0;
  public String contactsInfoEncrypt = "";
  public byte detalStatusFlag;
  public int eNetworkType = 0;
  public int iTermType;
  public boolean isHide;
  public boolean isNew;
  public long isRecommend;
  public boolean isUpdateSign = true;
  public String nickname = "";
  public long originBinder;
  public byte[] personalSign;
  public long richTime;
  public int sameFriend;
  public int sex;
  public String strTermDesc = "";
  public long uAbiFlag;
  
  static
  {
    ((byte[])cache_MobileNoMask)[0] = 0;
    cache_conType = 0;
    cache_eNetworkType = 0;
    cache_personalSign = (byte[])new byte[1];
    ((byte[])cache_personalSign)[0] = 0;
  }
  
  public MobileContactsNotFriendInfo() {}
  
  public MobileContactsNotFriendInfo(long paramLong1, long paramLong2, String paramString1, String paramString2, byte[] paramArrayOfByte1, long paramLong3, int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, String paramString3, long paramLong4, byte[] paramArrayOfByte2, boolean paramBoolean1, long paramLong5, boolean paramBoolean2, boolean paramBoolean3, int paramInt5, int paramInt6, int paramInt7)
  {
    this.bindingDate = paramLong1;
    this.isRecommend = paramLong2;
    this.nickname = paramString1;
    this.contactsInfoEncrypt = paramString2;
    this.MobileNoMask = paramArrayOfByte1;
    this.originBinder = paramLong3;
    this.accountAbi = paramInt1;
    this.conType = paramInt2;
    this.detalStatusFlag = paramByte;
    this.iTermType = paramInt3;
    this.eNetworkType = paramInt4;
    this.strTermDesc = paramString3;
    this.uAbiFlag = paramLong4;
    this.personalSign = paramArrayOfByte2;
    this.isUpdateSign = paramBoolean1;
    this.richTime = paramLong5;
    this.isNew = paramBoolean2;
    this.isHide = paramBoolean3;
    this.sex = paramInt5;
    this.age = paramInt6;
    this.sameFriend = paramInt7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bindingDate = paramJceInputStream.read(this.bindingDate, 0, false);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 1, false);
    this.nickname = paramJceInputStream.readString(2, false);
    this.contactsInfoEncrypt = paramJceInputStream.readString(3, true);
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 4, true));
    this.originBinder = paramJceInputStream.read(this.originBinder, 5, false);
    this.accountAbi = paramJceInputStream.read(this.accountAbi, 6, false);
    this.conType = paramJceInputStream.read(this.conType, 7, false);
    this.detalStatusFlag = paramJceInputStream.read(this.detalStatusFlag, 8, false);
    this.iTermType = paramJceInputStream.read(this.iTermType, 9, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 10, false);
    this.strTermDesc = paramJceInputStream.readString(11, false);
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 12, false);
    this.personalSign = ((byte[])paramJceInputStream.read(cache_personalSign, 13, false));
    this.isUpdateSign = paramJceInputStream.read(this.isUpdateSign, 14, false);
    this.richTime = paramJceInputStream.read(this.richTime, 15, false);
    this.isNew = paramJceInputStream.read(this.isNew, 16, false);
    this.isHide = paramJceInputStream.read(this.isHide, 17, false);
    this.sex = paramJceInputStream.read(this.sex, 18, false);
    this.age = paramJceInputStream.read(this.age, 19, false);
    this.sameFriend = paramJceInputStream.read(this.sameFriend, 20, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bindingDate, 0);
    paramJceOutputStream.write(this.isRecommend, 1);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 2);
    }
    paramJceOutputStream.write(this.contactsInfoEncrypt, 3);
    paramJceOutputStream.write(this.MobileNoMask, 4);
    paramJceOutputStream.write(this.originBinder, 5);
    paramJceOutputStream.write(this.accountAbi, 6);
    paramJceOutputStream.write(this.conType, 7);
    paramJceOutputStream.write(this.detalStatusFlag, 8);
    paramJceOutputStream.write(this.iTermType, 9);
    paramJceOutputStream.write(this.eNetworkType, 10);
    if (this.strTermDesc != null) {
      paramJceOutputStream.write(this.strTermDesc, 11);
    }
    paramJceOutputStream.write(this.uAbiFlag, 12);
    if (this.personalSign != null) {
      paramJceOutputStream.write(this.personalSign, 13);
    }
    paramJceOutputStream.write(this.isUpdateSign, 14);
    paramJceOutputStream.write(this.richTime, 15);
    paramJceOutputStream.write(this.isNew, 16);
    paramJceOutputStream.write(this.isHide, 17);
    paramJceOutputStream.write(this.sex, 18);
    paramJceOutputStream.write(this.age, 19);
    paramJceOutputStream.write(this.sameFriend, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SecurityAccountServer.MobileContactsNotFriendInfo
 * JD-Core Version:    0.7.0.1
 */