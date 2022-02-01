package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileCommitRsp
  extends JceStruct
{
  static byte[] cache_biz_rsp;
  static Map<Integer, DumpBussinessRsp> cache_dumpRsp;
  static stResult cache_result = new stResult();
  public byte[] biz_rsp = null;
  public Map<Integer, DumpBussinessRsp> dumpRsp = null;
  public stResult result = null;
  public String session = "";
  
  static
  {
    cache_biz_rsp = (byte[])new byte[1];
    ((byte[])cache_biz_rsp)[0] = 0;
    cache_dumpRsp = new HashMap();
    DumpBussinessRsp localDumpBussinessRsp = new DumpBussinessRsp();
    cache_dumpRsp.put(Integer.valueOf(0), localDumpBussinessRsp);
  }
  
  public FileCommitRsp() {}
  
  public FileCommitRsp(stResult paramstResult, String paramString, byte[] paramArrayOfByte, Map<Integer, DumpBussinessRsp> paramMap)
  {
    this.result = paramstResult;
    this.session = paramString;
    this.biz_rsp = paramArrayOfByte;
    this.dumpRsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = ((stResult)paramJceInputStream.read(cache_result, 1, true));
    this.session = paramJceInputStream.readString(2, false);
    this.biz_rsp = ((byte[])paramJceInputStream.read(cache_biz_rsp, 3, false));
    this.dumpRsp = ((Map)paramJceInputStream.read(cache_dumpRsp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    Object localObject = this.session;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.biz_rsp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
    localObject = this.dumpRsp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.FileCommitRsp
 * JD-Core Version:    0.7.0.1
 */