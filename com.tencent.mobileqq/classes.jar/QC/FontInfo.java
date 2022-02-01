package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FontInfo
  extends JceStruct
{
  static ItemBase cache_item = new ItemBase();
  public String btn = "";
  public int engine = 0;
  public int feeType = 0;
  public ItemBase item = null;
  public int linkBubbleID = 0;
  public int month = 0;
  public String msg = "";
  public String name = "";
  public String payUrl = "";
  public String strPicUrl = "";
  public String title = "";
  public String type = "";
  
  public FontInfo() {}
  
  public FontInfo(ItemBase paramItemBase, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, int paramInt4, String paramString7)
  {
    this.item = paramItemBase;
    this.linkBubbleID = paramInt1;
    this.feeType = paramInt2;
    this.name = paramString1;
    this.payUrl = paramString2;
    this.type = paramString3;
    this.month = paramInt3;
    this.msg = paramString4;
    this.btn = paramString5;
    this.title = paramString6;
    this.engine = paramInt4;
    this.strPicUrl = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item = ((ItemBase)paramJceInputStream.read(cache_item, 0, false));
    this.linkBubbleID = paramJceInputStream.read(this.linkBubbleID, 1, false);
    this.feeType = paramJceInputStream.read(this.feeType, 2, false);
    this.name = paramJceInputStream.readString(3, false);
    this.payUrl = paramJceInputStream.readString(4, false);
    this.type = paramJceInputStream.readString(5, false);
    this.month = paramJceInputStream.read(this.month, 6, false);
    this.msg = paramJceInputStream.readString(7, false);
    this.btn = paramJceInputStream.readString(8, false);
    this.title = paramJceInputStream.readString(9, false);
    this.engine = paramJceInputStream.read(this.engine, 10, false);
    this.strPicUrl = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.item != null) {
      paramJceOutputStream.write(this.item, 0);
    }
    paramJceOutputStream.write(this.linkBubbleID, 1);
    paramJceOutputStream.write(this.feeType, 2);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 3);
    }
    if (this.payUrl != null) {
      paramJceOutputStream.write(this.payUrl, 4);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 5);
    }
    paramJceOutputStream.write(this.month, 6);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 7);
    }
    if (this.btn != null) {
      paramJceOutputStream.write(this.btn, 8);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 9);
    }
    paramJceOutputStream.write(this.engine, 10);
    if (this.strPicUrl != null) {
      paramJceOutputStream.write(this.strPicUrl, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.FontInfo
 * JD-Core Version:    0.7.0.1
 */