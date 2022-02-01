package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUpsInfoReq
  extends JceStruct
{
  static Map<String, byte[]> cache_mapExt;
  static byte[] cache_vBusiNessData = (byte[])new byte[1];
  public byte bNotifyWns = 0;
  public int iAppid = 0;
  public int iBatUploadNum = 0;
  public long iBatchId = 0L;
  public int iCurUpload = 0;
  public int iKeppRaw = 0;
  public long iPicHight = 0L;
  public long iPicWidth = 0L;
  public int iType = 0;
  public Map<String, byte[]> mapExt = null;
  public String sBusinessId = "";
  public String sFileId = "";
  public String sWnsCmd = "";
  public byte[] vBusiNessData = null;
  
  static
  {
    ((byte[])cache_vBusiNessData)[0] = 0;
    cache_mapExt = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_mapExt.put("", arrayOfByte);
  }
  
  public UploadUpsInfoReq() {}
  
  public UploadUpsInfoReq(String paramString1, String paramString2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, byte paramByte, int paramInt4, int paramInt5, long paramLong1, String paramString3, long paramLong2, long paramLong3, Map<String, byte[]> paramMap)
  {
    this.sBusinessId = paramString1;
    this.sFileId = paramString2;
    this.iType = paramInt1;
    this.vBusiNessData = paramArrayOfByte;
    this.iKeppRaw = paramInt2;
    this.iAppid = paramInt3;
    this.bNotifyWns = paramByte;
    this.iBatUploadNum = paramInt4;
    this.iCurUpload = paramInt5;
    this.iBatchId = paramLong1;
    this.sWnsCmd = paramString3;
    this.iPicWidth = paramLong2;
    this.iPicHight = paramLong3;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sBusinessId = paramJceInputStream.readString(0, true);
    this.sFileId = paramJceInputStream.readString(1, false);
    this.iType = paramJceInputStream.read(this.iType, 2, true);
    this.vBusiNessData = ((byte[])paramJceInputStream.read(cache_vBusiNessData, 3, false));
    this.iKeppRaw = paramJceInputStream.read(this.iKeppRaw, 4, false);
    this.iAppid = paramJceInputStream.read(this.iAppid, 5, false);
    this.bNotifyWns = paramJceInputStream.read(this.bNotifyWns, 6, false);
    this.iBatUploadNum = paramJceInputStream.read(this.iBatUploadNum, 7, false);
    this.iCurUpload = paramJceInputStream.read(this.iCurUpload, 8, false);
    this.iBatchId = paramJceInputStream.read(this.iBatchId, 9, false);
    this.sWnsCmd = paramJceInputStream.readString(10, false);
    this.iPicWidth = paramJceInputStream.read(this.iPicWidth, 11, false);
    this.iPicHight = paramJceInputStream.read(this.iPicHight, 12, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sBusinessId, 0);
    Object localObject = this.sFileId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.iType, 2);
    localObject = this.vBusiNessData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
    paramJceOutputStream.write(this.iKeppRaw, 4);
    paramJceOutputStream.write(this.iAppid, 5);
    paramJceOutputStream.write(this.bNotifyWns, 6);
    paramJceOutputStream.write(this.iBatUploadNum, 7);
    paramJceOutputStream.write(this.iCurUpload, 8);
    paramJceOutputStream.write(this.iBatchId, 9);
    localObject = this.sWnsCmd;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.iPicWidth, 11);
    paramJceOutputStream.write(this.iPicHight, 12);
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FileUpload.UploadUpsInfoReq
 * JD-Core Version:    0.7.0.1
 */