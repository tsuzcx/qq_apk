package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AccessReq
  extends JceStruct
{
  static byte[] cache_body = (byte[])new byte[1];
  public byte[] body = null;
  public int gray = 0;
  public String imei = "";
  public String manufacture = "";
  public String mode = "";
  public int platform = 1;
  public String qimei = "";
  public String rom = "";
  
  static
  {
    ((byte[])cache_body)[0] = 0;
  }
  
  public AccessReq() {}
  
  public AccessReq(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this.imei = paramString1;
    this.mode = paramString2;
    this.manufacture = paramString3;
    this.rom = paramString4;
    this.gray = paramInt1;
    this.body = paramArrayOfByte;
    this.platform = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.mode = paramJceInputStream.readString(1, false);
    this.manufacture = paramJceInputStream.readString(2, false);
    this.rom = paramJceInputStream.readString(3, false);
    this.gray = paramJceInputStream.read(this.gray, 4, false);
    this.body = ((byte[])paramJceInputStream.read(cache_body, 5, false));
    this.qimei = paramJceInputStream.readString(6, false);
    this.platform = paramJceInputStream.read(this.platform, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.imei;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.mode;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.manufacture;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.rom;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.gray, 4);
    localObject = this.body;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
    localObject = this.qimei;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.platform, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MAAccessClient.AccessReq
 * JD-Core Version:    0.7.0.1
 */