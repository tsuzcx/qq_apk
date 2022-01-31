package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpUploadReq
  extends JceStruct
{
  static DefineAvatarInfo cache_AvatarInfo;
  static byte[] cache_v10MMd5;
  static byte[] cache_vEncryptUsrInfo;
  static byte[] cache_vFileData;
  public DefineAvatarInfo AvatarInfo;
  public byte ifUpQQAvatar;
  public String strFileName = "";
  public int uFileSize;
  public int uFromPos;
  public int uLength;
  public byte[] v10MMd5;
  public byte[] vEncryptUsrInfo;
  public byte[] vFileData;
  
  public HttpUploadReq() {}
  
  public HttpUploadReq(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, byte[] paramArrayOfByte3, byte paramByte, DefineAvatarInfo paramDefineAvatarInfo, String paramString)
  {
    this.vEncryptUsrInfo = paramArrayOfByte1;
    this.uFileSize = paramInt1;
    this.v10MMd5 = paramArrayOfByte2;
    this.uFromPos = paramInt2;
    this.uLength = paramInt3;
    this.vFileData = paramArrayOfByte3;
    this.ifUpQQAvatar = paramByte;
    this.AvatarInfo = paramDefineAvatarInfo;
    this.strFileName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vEncryptUsrInfo == null)
    {
      cache_vEncryptUsrInfo = (byte[])new byte[1];
      ((byte[])cache_vEncryptUsrInfo)[0] = 0;
    }
    this.vEncryptUsrInfo = ((byte[])paramJceInputStream.read(cache_vEncryptUsrInfo, 0, true));
    this.uFileSize = paramJceInputStream.read(this.uFileSize, 1, true);
    if (cache_v10MMd5 == null)
    {
      cache_v10MMd5 = (byte[])new byte[1];
      ((byte[])cache_v10MMd5)[0] = 0;
    }
    this.v10MMd5 = ((byte[])paramJceInputStream.read(cache_v10MMd5, 2, true));
    this.uFromPos = paramJceInputStream.read(this.uFromPos, 3, true);
    this.uLength = paramJceInputStream.read(this.uLength, 4, true);
    if (cache_vFileData == null)
    {
      cache_vFileData = (byte[])new byte[1];
      ((byte[])cache_vFileData)[0] = 0;
    }
    this.vFileData = ((byte[])paramJceInputStream.read(cache_vFileData, 5, true));
    this.ifUpQQAvatar = paramJceInputStream.read(this.ifUpQQAvatar, 6, false);
    if (cache_AvatarInfo == null) {
      cache_AvatarInfo = new DefineAvatarInfo();
    }
    this.AvatarInfo = ((DefineAvatarInfo)paramJceInputStream.read(cache_AvatarInfo, 7, false));
    this.strFileName = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vEncryptUsrInfo, 0);
    paramJceOutputStream.write(this.uFileSize, 1);
    paramJceOutputStream.write(this.v10MMd5, 2);
    paramJceOutputStream.write(this.uFromPos, 3);
    paramJceOutputStream.write(this.uLength, 4);
    paramJceOutputStream.write(this.vFileData, 5);
    paramJceOutputStream.write(this.ifUpQQAvatar, 6);
    if (this.AvatarInfo != null) {
      paramJceOutputStream.write(this.AvatarInfo, 7);
    }
    if (this.strFileName != null) {
      paramJceOutputStream.write(this.strFileName, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     KQQFS.HttpUploadReq
 * JD-Core Version:    0.7.0.1
 */