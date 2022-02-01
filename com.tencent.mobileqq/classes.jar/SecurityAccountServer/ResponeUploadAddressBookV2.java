package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeUploadAddressBookV2
  extends JceStruct
{
  static ArrayList<MobileContactsFriendInfo> cache_BindFriendContacts;
  static ArrayList<MobileContactsNotFriendInfo> cache_BindNotFriendContacts;
  static byte[] cache_sessionSid;
  public ArrayList<MobileContactsFriendInfo> BindFriendContacts = null;
  public ArrayList<MobileContactsNotFriendInfo> BindNotFriendContacts = null;
  public long MaxsignTimeStamp = 0L;
  public long nextFlag = 0L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  
  public ResponeUploadAddressBookV2() {}
  
  public ResponeUploadAddressBookV2(long paramLong1, byte[] paramArrayOfByte, ArrayList<MobileContactsFriendInfo> paramArrayList, ArrayList<MobileContactsNotFriendInfo> paramArrayList1, long paramLong2, long paramLong3)
  {
    this.nextFlag = paramLong1;
    this.sessionSid = paramArrayOfByte;
    this.BindFriendContacts = paramArrayList;
    this.BindNotFriendContacts = paramArrayList1;
    this.MaxsignTimeStamp = paramLong2;
    this.timeStamp = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 1, true));
    Object localObject;
    if (cache_BindFriendContacts == null)
    {
      cache_BindFriendContacts = new ArrayList();
      localObject = new MobileContactsFriendInfo();
      cache_BindFriendContacts.add(localObject);
    }
    this.BindFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindFriendContacts, 2, true));
    if (cache_BindNotFriendContacts == null)
    {
      cache_BindNotFriendContacts = new ArrayList();
      localObject = new MobileContactsNotFriendInfo();
      cache_BindNotFriendContacts.add(localObject);
    }
    this.BindNotFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindNotFriendContacts, 3, true));
    this.MaxsignTimeStamp = paramJceInputStream.read(this.MaxsignTimeStamp, 4, false);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.sessionSid, 1);
    paramJceOutputStream.write(this.BindFriendContacts, 2);
    paramJceOutputStream.write(this.BindNotFriendContacts, 3);
    paramJceOutputStream.write(this.MaxsignTimeStamp, 4);
    paramJceOutputStream.write(this.timeStamp, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponeUploadAddressBookV2
 * JD-Core Version:    0.7.0.1
 */