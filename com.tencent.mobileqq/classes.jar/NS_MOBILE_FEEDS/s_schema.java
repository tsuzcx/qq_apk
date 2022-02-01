package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_schema
  extends JceStruct
{
  public int actiontype;
  public String actionurl = "";
  public String appid = "";
  public String downloadurl = "";
  public String postparams = "";
  public String schemapageurl = "";
  public byte usepost;
  public boolean yingyongbao = false;
  
  public s_schema() {}
  
  public s_schema(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte paramByte, String paramString5, boolean paramBoolean)
  {
    this.actiontype = paramInt;
    this.actionurl = paramString1;
    this.downloadurl = paramString2;
    this.appid = paramString3;
    this.postparams = paramString4;
    this.usepost = paramByte;
    this.schemapageurl = paramString5;
    this.yingyongbao = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.actiontype = paramJceInputStream.read(this.actiontype, 0, false);
    this.actionurl = paramJceInputStream.readString(1, false);
    this.downloadurl = paramJceInputStream.readString(2, false);
    this.appid = paramJceInputStream.readString(3, false);
    this.postparams = paramJceInputStream.readString(4, false);
    this.usepost = paramJceInputStream.read(this.usepost, 5, false);
    this.schemapageurl = paramJceInputStream.readString(6, false);
    this.yingyongbao = paramJceInputStream.read(this.yingyongbao, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.actiontype, 0);
    String str = this.actionurl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.downloadurl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.postparams;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.usepost, 5);
    str = this.schemapageurl;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.yingyongbao, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_schema
 * JD-Core Version:    0.7.0.1
 */