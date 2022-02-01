package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusinessCheckItem
  extends JceStruct
{
  public int appid = 0;
  public String errmsg = "";
  public int itemid = 0;
  public int ret = 0;
  public String strAID = "";
  public String txRuleID = "";
  public String url = "";
  
  public UniBusinessCheckItem() {}
  
  public UniBusinessCheckItem(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.appid = paramInt1;
    this.itemid = paramInt2;
    this.ret = paramInt3;
    this.errmsg = paramString1;
    this.url = paramString2;
    this.txRuleID = paramString3;
    this.strAID = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.itemid = paramJceInputStream.read(this.itemid, 1, false);
    this.ret = paramJceInputStream.read(this.ret, 2, false);
    this.errmsg = paramJceInputStream.readString(3, false);
    this.url = paramJceInputStream.readString(4, false);
    this.txRuleID = paramJceInputStream.readString(5, false);
    this.strAID = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.itemid, 1);
    paramJceOutputStream.write(this.ret, 2);
    String str = this.errmsg;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.txRuleID;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.strAID;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusinessCheckItem
 * JD-Core Version:    0.7.0.1
 */