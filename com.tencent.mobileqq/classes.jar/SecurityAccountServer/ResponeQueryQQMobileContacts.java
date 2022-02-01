package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryQQMobileContacts
  extends JceStruct
{
  static ArrayList<MobileContactsDetailInfo> cache_alreadyBindContacts;
  static ArrayList<MobileContactsDetailInfo> cache_noBindContacts;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public ArrayList<MobileContactsDetailInfo> alreadyBindContacts = null;
  public long nextFlag = 0L;
  public ArrayList<MobileContactsDetailInfo> noBindContacts = null;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_alreadyBindContacts = new ArrayList();
    MobileContactsDetailInfo localMobileContactsDetailInfo = new MobileContactsDetailInfo();
    cache_alreadyBindContacts.add(localMobileContactsDetailInfo);
    cache_noBindContacts = new ArrayList();
    localMobileContactsDetailInfo = new MobileContactsDetailInfo();
    cache_noBindContacts.add(localMobileContactsDetailInfo);
  }
  
  public ResponeQueryQQMobileContacts() {}
  
  public ResponeQueryQQMobileContacts(long paramLong1, long paramLong2, byte[] paramArrayOfByte, ArrayList<MobileContactsDetailInfo> paramArrayList1, ArrayList<MobileContactsDetailInfo> paramArrayList2)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindContacts = paramArrayList1;
    this.noBindContacts = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.alreadyBindContacts = ((ArrayList)paramJceInputStream.read(cache_alreadyBindContacts, 3, true));
    this.noBindContacts = ((ArrayList)paramJceInputStream.read(cache_noBindContacts, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.alreadyBindContacts, 3);
    paramJceOutputStream.write(this.noBindContacts, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryQQMobileContacts
 * JD-Core Version:    0.7.0.1
 */