package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileControlReq
  extends JceStruct
{
  static byte[] cache_biz_req;
  static int cache_check_type;
  static stEnvironment cache_env;
  static int cache_model;
  static AuthToken cache_token = new AuthToken();
  public String appid = "";
  public int asy_upload = 0;
  public byte[] biz_req = null;
  public int check_type = 0;
  public String checksum = "";
  public stEnvironment env = null;
  public long file_len = 0L;
  public int model = 0;
  public boolean need_ip_redirect = false;
  public String session = "";
  public AuthToken token = null;
  public String uin = "";
  
  static
  {
    cache_check_type = 0;
    cache_env = new stEnvironment();
    cache_model = 0;
    cache_biz_req = (byte[])new byte[1];
    ((byte[])cache_biz_req)[0] = 0;
  }
  
  public FileControlReq() {}
  
  public FileControlReq(String paramString1, AuthToken paramAuthToken, String paramString2, String paramString3, int paramInt1, long paramLong, stEnvironment paramstEnvironment, int paramInt2, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.uin = paramString1;
    this.token = paramAuthToken;
    this.appid = paramString2;
    this.checksum = paramString3;
    this.check_type = paramInt1;
    this.file_len = paramLong;
    this.env = paramstEnvironment;
    this.model = paramInt2;
    this.biz_req = paramArrayOfByte;
    this.session = paramString4;
    this.need_ip_redirect = paramBoolean;
    this.asy_upload = paramInt3;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.token, 1);
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.checksum, 3);
    paramJceOutputStream.write(this.check_type, 4);
    paramJceOutputStream.write(this.file_len, 5);
    if (this.env != null) {
      paramJceOutputStream.write(this.env, 6);
    }
    paramJceOutputStream.write(this.model, 7);
    if (this.biz_req != null) {
      paramJceOutputStream.write(this.biz_req, 8);
    }
    if (this.session != null) {
      paramJceOutputStream.write(this.session, 9);
    }
    paramJceOutputStream.write(this.need_ip_redirect, 10);
    paramJceOutputStream.write(this.asy_upload, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileControlReq
 * JD-Core Version:    0.7.0.1
 */