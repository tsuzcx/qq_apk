package MessageSvcPack;

import QQService.InstanceInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RequestPushStatus
  extends JceStruct
{
  static ArrayList<InstanceInfo> cache_vecInstanceList = new ArrayList();
  public byte cDataLine = 0;
  public byte cPrintable = 0;
  public byte cStatus = 0;
  public byte cViewFile = 0;
  public long lUin = 0L;
  public long nClientType = 0L;
  public long nInstanceId = 0L;
  public long nPCVer = 0L;
  public ArrayList<InstanceInfo> vecInstanceList = null;
  
  static
  {
    InstanceInfo localInstanceInfo = new InstanceInfo();
    cache_vecInstanceList.add(localInstanceInfo);
  }
  
  public RequestPushStatus() {}
  
  public RequestPushStatus(long paramLong1, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, long paramLong2, long paramLong3, long paramLong4, ArrayList<InstanceInfo> paramArrayList)
  {
    this.lUin = paramLong1;
    this.cStatus = paramByte1;
    this.cDataLine = paramByte2;
    this.cPrintable = paramByte3;
    this.cViewFile = paramByte4;
    this.nPCVer = paramLong2;
    this.nClientType = paramLong3;
    this.nInstanceId = paramLong4;
    this.vecInstanceList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.cDataLine = paramJceInputStream.read(this.cDataLine, 2, false);
    this.cPrintable = paramJceInputStream.read(this.cPrintable, 3, false);
    this.cViewFile = paramJceInputStream.read(this.cViewFile, 4, false);
    this.nPCVer = paramJceInputStream.read(this.nPCVer, 5, false);
    this.nClientType = paramJceInputStream.read(this.nClientType, 6, false);
    this.nInstanceId = paramJceInputStream.read(this.nInstanceId, 7, false);
    this.vecInstanceList = ((ArrayList)paramJceInputStream.read(cache_vecInstanceList, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.cDataLine, 2);
    paramJceOutputStream.write(this.cPrintable, 3);
    paramJceOutputStream.write(this.cViewFile, 4);
    paramJceOutputStream.write(this.nPCVer, 5);
    paramJceOutputStream.write(this.nClientType, 6);
    paramJceOutputStream.write(this.nInstanceId, 7);
    ArrayList localArrayList = this.vecInstanceList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.RequestPushStatus
 * JD-Core Version:    0.7.0.1
 */