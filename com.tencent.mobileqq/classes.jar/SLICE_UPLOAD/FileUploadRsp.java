package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileUploadRsp
  extends JceStruct
{
  static byte[] cache_biz_rsp;
  static Map<Integer, DumpBussinessRsp> cache_dumpRsp;
  static stResult cache_result = new stResult();
  public byte[] biz_rsp = null;
  public Map<Integer, DumpBussinessRsp> dumpRsp = null;
  public long offset = 0L;
  public long receive_time = 0L;
  public long response_time = 0L;
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
  
  public FileUploadRsp() {}
  
  public FileUploadRsp(stResult paramstResult, String paramString, long paramLong1, byte[] paramArrayOfByte, long paramLong2, long paramLong3, Map<Integer, DumpBussinessRsp> paramMap)
  {
    this.result = paramstResult;
    this.session = paramString;
    this.offset = paramLong1;
    this.biz_rsp = paramArrayOfByte;
    this.receive_time = paramLong2;
    this.response_time = paramLong3;
    this.dumpRsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = ((stResult)paramJceInputStream.read(cache_result, 1, true));
    this.session = paramJceInputStream.readString(2, false);
    this.offset = paramJceInputStream.read(this.offset, 3, false);
    this.biz_rsp = ((byte[])paramJceInputStream.read(cache_biz_rsp, 4, false));
    this.receive_time = paramJceInputStream.read(this.receive_time, 5, false);
    this.response_time = paramJceInputStream.read(this.response_time, 6, false);
    this.dumpRsp = ((Map)paramJceInputStream.read(cache_dumpRsp, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    if (this.session != null) {
      paramJceOutputStream.write(this.session, 2);
    }
    paramJceOutputStream.write(this.offset, 3);
    if (this.biz_rsp != null) {
      paramJceOutputStream.write(this.biz_rsp, 4);
    }
    paramJceOutputStream.write(this.receive_time, 5);
    paramJceOutputStream.write(this.response_time, 6);
    if (this.dumpRsp != null) {
      paramJceOutputStream.write(this.dumpRsp, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileUploadRsp
 * JD-Core Version:    0.7.0.1
 */