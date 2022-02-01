package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetWatchWordShareRsp
  extends JceStruct
{
  public String detailurl = "";
  public String errmsg = "";
  public String itemmsg = "";
  public String itemname = "";
  public String itemtype = "";
  public int portrait = 0;
  public int ret = 0;
  public String sharemsg = "";
  public String shareuinnick = "";
  public String thumbnailurl = "";
  
  public GetWatchWordShareRsp() {}
  
  public GetWatchWordShareRsp(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2)
  {
    this.ret = paramInt1;
    this.errmsg = paramString1;
    this.itemname = paramString2;
    this.itemtype = paramString3;
    this.shareuinnick = paramString4;
    this.sharemsg = paramString5;
    this.thumbnailurl = paramString6;
    this.detailurl = paramString7;
    this.itemmsg = paramString8;
    this.portrait = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.itemname = paramJceInputStream.readString(2, false);
    this.itemtype = paramJceInputStream.readString(3, false);
    this.shareuinnick = paramJceInputStream.readString(4, false);
    this.sharemsg = paramJceInputStream.readString(5, false);
    this.thumbnailurl = paramJceInputStream.readString(6, false);
    this.detailurl = paramJceInputStream.readString(7, false);
    this.itemmsg = paramJceInputStream.readString(8, false);
    this.portrait = paramJceInputStream.read(this.portrait, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    String str = this.errmsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.itemname;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.itemtype;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.shareuinnick;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.sharemsg;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.thumbnailurl;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.detailurl;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.itemmsg;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.portrait, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetWatchWordShareRsp
 * JD-Core Version:    0.7.0.1
 */