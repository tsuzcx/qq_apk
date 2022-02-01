package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpUploadResp
  extends JceStruct
{
  static VerifyCode cache_stVerifyCode;
  static byte[] cache_vFileKey;
  static byte[] cache_vSig;
  public int iReplyCode = 0;
  public long lFromMID = 0L;
  public long lToMID = 0L;
  public int sessionID = 0;
  public VerifyCode stVerifyCode = null;
  public String strResult = "";
  public int uFromPos = 0;
  public int uSeq = 0;
  public byte[] vFileKey = null;
  public byte[] vSig = null;
  
  public HttpUploadResp() {}
  
  public HttpUploadResp(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte1, VerifyCode paramVerifyCode, byte[] paramArrayOfByte2)
  {
    this.lFromMID = paramLong1;
    this.lToMID = paramLong2;
    this.sessionID = paramInt1;
    this.uSeq = paramInt2;
    this.iReplyCode = paramInt3;
    this.strResult = paramString;
    this.uFromPos = paramInt4;
    this.vFileKey = paramArrayOfByte1;
    this.stVerifyCode = paramVerifyCode;
    this.vSig = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 0, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 1, true);
    this.sessionID = paramJceInputStream.read(this.sessionID, 2, true);
    this.uSeq = paramJceInputStream.read(this.uSeq, 3, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 4, true);
    this.strResult = paramJceInputStream.readString(5, true);
    this.uFromPos = paramJceInputStream.read(this.uFromPos, 6, false);
    if (cache_vFileKey == null)
    {
      cache_vFileKey = (byte[])new byte[1];
      ((byte[])cache_vFileKey)[0] = 0;
    }
    this.vFileKey = ((byte[])paramJceInputStream.read(cache_vFileKey, 7, false));
    if (cache_stVerifyCode == null) {
      cache_stVerifyCode = new VerifyCode();
    }
    this.stVerifyCode = ((VerifyCode)paramJceInputStream.read(cache_stVerifyCode, 8, false));
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromMID, 0);
    paramJceOutputStream.write(this.lToMID, 1);
    paramJceOutputStream.write(this.sessionID, 2);
    paramJceOutputStream.write(this.uSeq, 3);
    paramJceOutputStream.write(this.iReplyCode, 4);
    paramJceOutputStream.write(this.strResult, 5);
    paramJceOutputStream.write(this.uFromPos, 6);
    Object localObject = this.vFileKey;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 7);
    }
    localObject = this.stVerifyCode;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.vSig;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQFS.HttpUploadResp
 * JD-Core Version:    0.7.0.1
 */