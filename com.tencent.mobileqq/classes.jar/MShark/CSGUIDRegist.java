package MShark;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSGUIDRegist
  extends JceStruct
{
  public String build_brand = "";
  public String build_version_incremental = "";
  public String build_version_release = "";
  public int buildno = 0;
  public String channelid = "";
  public String imei = "";
  public String imsi = "";
  public boolean isbuildin = false;
  public String lc = "";
  public String mac = "";
  public String pkgname = "";
  public int platform = 0;
  public int product = 0;
  public int subplatform = 0;
  public String ua = "";
  
  public JceStruct newInit()
  {
    return new CSGUIDRegist();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, true);
    this.imsi = paramJceInputStream.readString(1, false);
    this.mac = paramJceInputStream.readString(2, false);
    this.lc = paramJceInputStream.readString(3, false);
    this.buildno = paramJceInputStream.read(this.buildno, 4, false);
    this.channelid = paramJceInputStream.readString(5, false);
    this.pkgname = paramJceInputStream.readString(6, false);
    this.build_brand = paramJceInputStream.readString(7, false);
    this.build_version_incremental = paramJceInputStream.readString(8, false);
    this.build_version_release = paramJceInputStream.readString(9, false);
    this.product = paramJceInputStream.read(this.product, 10, false);
    this.platform = paramJceInputStream.read(this.platform, 11, false);
    this.subplatform = paramJceInputStream.read(this.subplatform, 12, false);
    this.isbuildin = paramJceInputStream.read(this.isbuildin, 13, false);
    this.ua = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    String str = this.imsi;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.mac;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.lc;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    int i = this.buildno;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    str = this.channelid;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.pkgname;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.build_brand;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.build_version_incremental;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.build_version_release;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    i = this.product;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    i = this.platform;
    if (i != 0) {
      paramJceOutputStream.write(i, 11);
    }
    i = this.subplatform;
    if (i != 0) {
      paramJceOutputStream.write(i, 12);
    }
    paramJceOutputStream.write(this.isbuildin, 13);
    str = this.ua;
    if (str != null) {
      paramJceOutputStream.write(str, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MShark.CSGUIDRegist
 * JD-Core Version:    0.7.0.1
 */