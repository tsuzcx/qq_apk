package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FileControlRsp
  extends JceStruct
{
  static byte[] cache_biz_rsp;
  static ArrayList<stOffset> cache_offset_list;
  static stResult cache_result = new stResult();
  public byte[] biz_rsp = null;
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
    stOffset localstOffset = new stOffset();
    cache_offset_list.add(localstOffset);
  }
  
  public FileControlRsp() {}
  
  public FileControlRsp(stResult paramstResult, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, ArrayList<stOffset> paramArrayList, String paramString2, int paramInt)
  {
    this.result = paramstResult;
    this.session = paramString1;
    this.offset = paramLong1;
    this.slice_size = paramLong2;
    this.biz_rsp = paramArrayOfByte;
    this.offset_list = paramArrayList;
    this.redirect_ip = paramString2;
    this.thread_num = paramInt;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    if (this.session != null) {
      paramJceOutputStream.write(this.session, 2);
    }
    paramJceOutputStream.write(this.offset, 3);
    paramJceOutputStream.write(this.slice_size, 4);
    if (this.biz_rsp != null) {
      paramJceOutputStream.write(this.biz_rsp, 5);
    }
    if (this.offset_list != null) {
      paramJceOutputStream.write(this.offset_list, 6);
    }
    if (this.redirect_ip != null) {
      paramJceOutputStream.write(this.redirect_ip, 7);
    }
    paramJceOutputStream.write(this.thread_num, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileControlRsp
 * JD-Core Version:    0.7.0.1
 */