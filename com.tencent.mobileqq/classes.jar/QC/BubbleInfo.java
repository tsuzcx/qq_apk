package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BubbleInfo
  extends JceStruct
{
  static ItemBase cache_item = new ItemBase();
  public String btn = "";
  public int feeType = 0;
  public ItemBase item = null;
  public int month = 0;
  public String msg = "";
  public String name = "";
  public String payUrl = "";
  public String strPicUrl = "";
  public String title = "";
  public String type = "";
  
  public BubbleInfo() {}
  
  public BubbleInfo(ItemBase paramItemBase, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.item = paramItemBase;
    this.feeType = paramInt1;
    this.name = paramString1;
    this.payUrl = paramString2;
    this.type = paramString3;
    this.month = paramInt2;
    this.msg = paramString4;
    this.btn = paramString5;
    this.title = paramString6;
    this.strPicUrl = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item = ((ItemBase)paramJceInputStream.read(cache_item, 0, false));
    this.feeType = paramJceInputStream.read(this.feeType, 1, false);
    this.name = paramJceInputStream.readString(2, false);
    this.payUrl = paramJceInputStream.readString(3, false);
    this.type = paramJceInputStream.readString(4, false);
    this.month = paramJceInputStream.read(this.month, 5, false);
    this.msg = paramJceInputStream.readString(6, false);
    this.btn = paramJceInputStream.readString(7, false);
    this.title = paramJceInputStream.readString(8, false);
    this.strPicUrl = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.item != null) {
      paramJceOutputStream.write(this.item, 0);
    }
    paramJceOutputStream.write(this.feeType, 1);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 2);
    }
    if (this.payUrl != null) {
      paramJceOutputStream.write(this.payUrl, 3);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 4);
    }
    paramJceOutputStream.write(this.month, 5);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 6);
    }
    if (this.btn != null) {
      paramJceOutputStream.write(this.btn, 7);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 8);
    }
    if (this.strPicUrl != null) {
      paramJceOutputStream.write(this.strPicUrl, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.BubbleInfo
 * JD-Core Version:    0.7.0.1
 */