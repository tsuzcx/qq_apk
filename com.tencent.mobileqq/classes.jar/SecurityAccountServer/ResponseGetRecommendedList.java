package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ResponseGetRecommendedList
  extends JceStruct
{
  static ArrayList<MobileContactsDetailInfo> cache_alreadyBindContacts;
  static ArrayList<MobileContactsDetailInfo> cache_assistBindContacts;
  static ArrayList<CircleFriendInfo> cache_circleInfo;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  static int cache_type = 0;
  public long ConfigVersion = 0L;
  public long ForcePopSwitch = 0L;
  public String MobileUniqueNo = "";
  public long PopCloseCount = 0L;
  public long PopWindowsCount = 0L;
  public long PopWindowsTime = 0L;
  public ArrayList<MobileContactsDetailInfo> alreadyBindContacts = null;
  public ArrayList<MobileContactsDetailInfo> assistBindContacts = null;
  public long bindingTime = 0L;
  public ArrayList<CircleFriendInfo> circleInfo = null;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  public long nextFlag = 0L;
  public long originBinder = 1L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  public int type = 0;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_alreadyBindContacts = new ArrayList();
    Object localObject = new MobileContactsDetailInfo();
    cache_alreadyBindContacts.add(localObject);
    cache_circleInfo = new ArrayList();
    localObject = new CircleFriendInfo();
    cache_circleInfo.add(localObject);
    cache_assistBindContacts = new ArrayList();
    localObject = new MobileContactsDetailInfo();
    cache_assistBindContacts.add(localObject);
  }
  
  public ResponseGetRecommendedList() {}
  
  public ResponseGetRecommendedList(long paramLong1, long paramLong2, byte[] paramArrayOfByte, ArrayList<MobileContactsDetailInfo> paramArrayList1, ArrayList<CircleFriendInfo> paramArrayList, ArrayList<MobileContactsDetailInfo> paramArrayList2, String paramString1, String paramString2, String paramString3, long paramLong3, int paramInt, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindContacts = paramArrayList1;
    this.circleInfo = paramArrayList;
    this.assistBindContacts = paramArrayList2;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.MobileUniqueNo = paramString3;
    this.lastUsedFlag = paramLong3;
    this.type = paramInt;
    this.originBinder = paramLong4;
    this.bindingTime = paramLong5;
    this.ConfigVersion = paramLong6;
    this.PopWindowsCount = paramLong7;
    this.PopWindowsTime = paramLong8;
    this.PopCloseCount = paramLong9;
    this.ForcePopSwitch = paramLong10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.alreadyBindContacts = ((ArrayList)paramJceInputStream.read(cache_alreadyBindContacts, 3, true));
    this.circleInfo = ((ArrayList)paramJceInputStream.read(cache_circleInfo, 4, false));
    this.assistBindContacts = ((ArrayList)paramJceInputStream.read(cache_assistBindContacts, 5, false));
    this.nationCode = paramJceInputStream.readString(6, false);
    this.mobileNo = paramJceInputStream.readString(7, false);
    this.MobileUniqueNo = paramJceInputStream.readString(8, false);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 9, false);
    this.type = paramJceInputStream.read(this.type, 10, false);
    this.originBinder = paramJceInputStream.read(this.originBinder, 11, false);
    this.bindingTime = paramJceInputStream.read(this.bindingTime, 12, false);
    this.ConfigVersion = paramJceInputStream.read(this.ConfigVersion, 13, false);
    this.PopWindowsCount = paramJceInputStream.read(this.PopWindowsCount, 14, false);
    this.PopWindowsTime = paramJceInputStream.read(this.PopWindowsTime, 15, false);
    this.PopCloseCount = paramJceInputStream.read(this.PopCloseCount, 16, false);
    this.ForcePopSwitch = paramJceInputStream.read(this.ForcePopSwitch, 17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.alreadyBindContacts, 3);
    Object localObject = this.circleInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.assistBindContacts;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    localObject = this.nationCode;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.mobileNo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.MobileUniqueNo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.lastUsedFlag, 9);
    paramJceOutputStream.write(this.type, 10);
    paramJceOutputStream.write(this.originBinder, 11);
    paramJceOutputStream.write(this.bindingTime, 12);
    paramJceOutputStream.write(this.ConfigVersion, 13);
    paramJceOutputStream.write(this.PopWindowsCount, 14);
    paramJceOutputStream.write(this.PopWindowsTime, 15);
    paramJceOutputStream.write(this.PopCloseCount, 16);
    paramJceOutputStream.write(this.ForcePopSwitch, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.ResponseGetRecommendedList
 * JD-Core Version:    0.7.0.1
 */