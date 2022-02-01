package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stEnvironment
  extends JceStruct
{
  static int cache_entrance;
  static int cache_net;
  public long client_ip = 0L;
  public String device = "";
  public String deviceInfo = "";
  public int entrance = 0;
  public int net = 0;
  public String operators = "";
  public String qua = "";
  public String refer = "";
  public int source = 0;
  
  public stEnvironment() {}
  
  public stEnvironment(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong, String paramString4, int paramInt2, int paramInt3, String paramString5)
  {
    this.qua = paramString1;
    this.device = paramString2;
    this.net = paramInt1;
    this.operators = paramString3;
    this.client_ip = paramLong;
    this.refer = paramString4;
    this.entrance = paramInt2;
    this.source = paramInt3;
    this.deviceInfo = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qua = paramJceInputStream.readString(1, true);
    this.device = paramJceInputStream.readString(2, true);
    this.net = paramJceInputStream.read(this.net, 3, true);
    this.operators = paramJceInputStream.readString(4, true);
    this.client_ip = paramJceInputStream.read(this.client_ip, 5, true);
    this.refer = paramJceInputStream.readString(6, true);
    this.entrance = paramJceInputStream.read(this.entrance, 7, true);
    this.source = paramJceInputStream.read(this.source, 8, false);
    this.deviceInfo = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qua, 1);
    paramJceOutputStream.write(this.device, 2);
    paramJceOutputStream.write(this.net, 3);
    paramJceOutputStream.write(this.operators, 4);
    paramJceOutputStream.write(this.client_ip, 5);
    paramJceOutputStream.write(this.refer, 6);
    paramJceOutputStream.write(this.entrance, 7);
    paramJceOutputStream.write(this.source, 8);
    String str = this.deviceInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.stEnvironment
 * JD-Core Version:    0.7.0.1
 */