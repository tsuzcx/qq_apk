package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportLBSInfo
  extends JceStruct
{
  public String data_id = "";
  public String dev = "";
  public int iLat = 0;
  public int iLon = 0;
  public int idx = 0;
  public String lang = "";
  public String os = "";
  public String os_ver = "";
  public String other = "";
  public int ref = 0;
  public String ref_ver = "";
  public String request_id = "";
  public long time = 0L;
  
  public ReportLBSInfo() {}
  
  public ReportLBSInfo(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.request_id = paramString1;
    this.time = paramLong;
    this.data_id = paramString2;
    this.idx = paramInt1;
    this.ref = paramInt2;
    this.ref_ver = paramString3;
    this.iLat = paramInt3;
    this.iLon = paramInt4;
    this.dev = paramString4;
    this.os = paramString5;
    this.os_ver = paramString6;
    this.lang = paramString7;
    this.other = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.request_id = paramJceInputStream.readString(0, false);
    this.time = paramJceInputStream.read(this.time, 1, false);
    this.data_id = paramJceInputStream.readString(2, false);
    this.idx = paramJceInputStream.read(this.idx, 3, false);
    this.ref = paramJceInputStream.read(this.ref, 4, false);
    this.ref_ver = paramJceInputStream.readString(5, false);
    this.iLat = paramJceInputStream.read(this.iLat, 6, false);
    this.iLon = paramJceInputStream.read(this.iLon, 7, false);
    this.dev = paramJceInputStream.readString(8, false);
    this.os = paramJceInputStream.readString(9, false);
    this.os_ver = paramJceInputStream.readString(10, false);
    this.lang = paramJceInputStream.readString(11, false);
    this.other = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.request_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.time, 1);
    str = this.data_id;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.idx, 3);
    paramJceOutputStream.write(this.ref, 4);
    str = this.ref_ver;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.iLat, 6);
    paramJceOutputStream.write(this.iLon, 7);
    str = this.dev;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.os;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.os_ver;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.lang;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.other;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.ReportLBSInfo
 * JD-Core Version:    0.7.0.1
 */