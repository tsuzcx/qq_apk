package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class FileControlRsp
  extends JceStruct
{
  static byte[] cache_biz_rsp;
  static Map<Integer, DumpBussinessRsp> cache_dumpRsp;
  static ArrayList<stOffset> cache_offset_list;
  static stResult cache_result = new stResult();
  public byte[] biz_rsp = null;
  public Map<Integer, DumpBussinessRsp> dumpRsp = null;
  public long offset = 0L;
  public ArrayList<stOffset> offset_list = null;
  public String redirect_ip = "";
  public stResult result = null;
  public String session = "";
  public long slice_size = 0L;
  public int thread_num = 1;
  
  static
  {
    cache_biz_rsp = (byte[])new byte[1];
    ((byte[])cache_biz_rsp)[0] = 0;
    cache_offset_list = new ArrayList();
    Object localObject = new stOffset();
    cache_offset_list.add(localObject);
    cache_dumpRsp = new HashMap();
    localObject = new DumpBussinessRsp();
    cache_dumpRsp.put(Integer.valueOf(0), localObject);
  }
  
  public FileControlRsp() {}
  
  public FileControlRsp(stResult paramstResult, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, ArrayList<stOffset> paramArrayList, String paramString2, int paramInt, Map<Integer, DumpBussinessRsp> paramMap)
  {
    this.result = paramstResult;
    this.session = paramString1;
    this.offset = paramLong1;
    this.slice_size = paramLong2;
    this.biz_rsp = paramArrayOfByte;
    this.offset_list = paramArrayList;
    this.redirect_ip = paramString2;
    this.thread_num = paramInt;
    this.dumpRsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = ((stResult)paramJceInputStream.read(cache_result, 1, true));
    this.session = paramJceInputStream.readString(2, false);
    this.offset = paramJceInputStream.read(this.offset, 3, false);
    this.slice_size = paramJceInputStream.read(this.slice_size, 4, false);
    this.biz_rsp = ((byte[])paramJceInputStream.read(cache_biz_rsp, 5, false));
    this.offset_list = ((ArrayList)paramJceInputStream.read(cache_offset_list, 6, false));
    this.redirect_ip = paramJceInputStream.readString(7, false);
    this.thread_num = paramJceInputStream.read(this.thread_num, 8, false);
    this.dumpRsp = ((Map)paramJceInputStream.read(cache_dumpRsp, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    Object localObject = this.session;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.offset, 3);
    paramJceOutputStream.write(this.slice_size, 4);
    localObject = this.biz_rsp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
    localObject = this.offset_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    localObject = this.redirect_ip;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.thread_num, 8);
    localObject = this.dumpRsp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.FileControlRsp
 * JD-Core Version:    0.7.0.1
 */