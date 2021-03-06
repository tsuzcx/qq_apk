package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileControlReq
  extends JceStruct
{
  static byte[] cache_biz_req;
  static int cache_check_type;
  static Map<Integer, DumpBussinessReq> cache_dumpReq;
  static stEnvironment cache_env;
  static Map<String, String> cache_extend_info;
  static int cache_model;
  static AuthToken cache_token = new AuthToken();
  public String appid = "";
  public int asy_upload = 0;
  public byte[] biz_req = null;
  public int check_type = 0;
  public String checksum = "";
  public Map<Integer, DumpBussinessReq> dumpReq = null;
  public stEnvironment env = null;
  public Map<String, String> extend_info = null;
  public long file_len = 0L;
  public int model = 0;
  public boolean need_ip_redirect = false;
  public String session = "";
  public long slice_size = 0L;
  public AuthToken token = null;
  public String uin = "";
  
  static
  {
    cache_check_type = 0;
    cache_env = new stEnvironment();
    cache_model = 0;
    cache_biz_req = (byte[])new byte[1];
    ((byte[])cache_biz_req)[0] = 0;
    cache_dumpReq = new HashMap();
    DumpBussinessReq localDumpBussinessReq = new DumpBussinessReq();
    cache_dumpReq.put(Integer.valueOf(0), localDumpBussinessReq);
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public FileControlReq() {}
  
  public FileControlReq(String paramString1, AuthToken paramAuthToken, String paramString2, String paramString3, int paramInt1, long paramLong1, stEnvironment paramstEnvironment, int paramInt2, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean, int paramInt3, Map<Integer, DumpBussinessReq> paramMap, long paramLong2, Map<String, String> paramMap1)
  {
    this.uin = paramString1;
    this.token = paramAuthToken;
    this.appid = paramString2;
    this.checksum = paramString3;
    this.check_type = paramInt1;
    this.file_len = paramLong1;
    this.env = paramstEnvironment;
    this.model = paramInt2;
    this.biz_req = paramArrayOfByte;
    this.session = paramString4;
    this.need_ip_redirect = paramBoolean;
    this.asy_upload = paramInt3;
    this.dumpReq = paramMap;
    this.slice_size = paramLong2;
    this.extend_info = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.token = ((AuthToken)paramJceInputStream.read(cache_token, 1, true));
    this.appid = paramJceInputStream.readString(2, true);
    this.checksum = paramJceInputStream.readString(3, true);
    this.check_type = paramJceInputStream.read(this.check_type, 4, true);
    this.file_len = paramJceInputStream.read(this.file_len, 5, true);
    this.env = ((stEnvironment)paramJceInputStream.read(cache_env, 6, false));
    this.model = paramJceInputStream.read(this.model, 7, false);
    this.biz_req = ((byte[])paramJceInputStream.read(cache_biz_req, 8, false));
    this.session = paramJceInputStream.readString(9, false);
    this.need_ip_redirect = paramJceInputStream.read(this.need_ip_redirect, 10, false);
    this.asy_upload = paramJceInputStream.read(this.asy_upload, 11, false);
    this.dumpReq = ((Map)paramJceInputStream.read(cache_dumpReq, 12, false));
    this.slice_size = paramJceInputStream.read(this.slice_size, 13, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.token, 1);
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.checksum, 3);
    paramJceOutputStream.write(this.check_type, 4);
    paramJceOutputStream.write(this.file_len, 5);
    Object localObject = this.env;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    paramJceOutputStream.write(this.model, 7);
    localObject = this.biz_req;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 8);
    }
    localObject = this.session;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.need_ip_redirect, 10);
    paramJceOutputStream.write(this.asy_upload, 11);
    localObject = this.dumpReq;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 12);
    }
    paramJceOutputStream.write(this.slice_size, 13);
    localObject = this.extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.FileControlReq
 * JD-Core Version:    0.7.0.1
 */