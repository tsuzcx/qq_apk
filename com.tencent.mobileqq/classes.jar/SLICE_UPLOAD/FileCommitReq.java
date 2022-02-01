package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileCommitReq
  extends JceStruct
{
  static byte[] cache_biz_req = (byte[])new byte[1];
  static Map<Integer, DumpBussinessReq> cache_dumpReq;
  public String appid = "";
  public byte[] biz_req = null;
  public Map<Integer, DumpBussinessReq> dumpReq = null;
  public String session = "";
  public String uin = "";
  
  static
  {
    ((byte[])cache_biz_req)[0] = 0;
    cache_dumpReq = new HashMap();
    DumpBussinessReq localDumpBussinessReq = new DumpBussinessReq();
    cache_dumpReq.put(Integer.valueOf(0), localDumpBussinessReq);
  }
  
  public FileCommitReq() {}
  
  public FileCommitReq(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, Map<Integer, DumpBussinessReq> paramMap)
  {
    this.uin = paramString1;
    this.session = paramString2;
    this.biz_req = paramArrayOfByte;
    this.appid = paramString3;
    this.dumpReq = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.session = paramJceInputStream.readString(1, true);
    this.biz_req = ((byte[])paramJceInputStream.read(cache_biz_req, 2, false));
    this.appid = paramJceInputStream.readString(3, false);
    this.dumpReq = ((Map)paramJceInputStream.read(cache_dumpReq, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.session, 1);
    Object localObject = this.biz_req;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
    localObject = this.appid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.dumpReq;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.FileCommitReq
 * JD-Core Version:    0.7.0.1
 */