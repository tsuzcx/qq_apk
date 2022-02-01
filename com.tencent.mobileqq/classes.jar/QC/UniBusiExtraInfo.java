package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiExtraInfo
  extends JceStruct
{
  public String faceHashId = "";
  public String headurl = "";
  public int isOnShelf;
  public int isShow;
  public int limitFree;
  public String mallname = "";
  public String mallurl = "";
  public int price;
  public String productIcon = "";
  public String productName = "";
  public long sourceId;
  public String strxyjson = "";
  public int svipLevel;
  public int svipMonth;
  public int validDay;
  
  public UniBusiExtraInfo() {}
  
  public UniBusiExtraInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.isOnShelf = paramInt1;
    this.strxyjson = paramString1;
    this.mallurl = paramString2;
    this.mallname = paramString3;
    this.faceHashId = paramString4;
    this.headurl = paramString5;
    this.sourceId = paramLong;
    this.productName = paramString6;
    this.productIcon = paramString7;
    this.price = paramInt2;
    this.validDay = paramInt3;
    this.svipLevel = paramInt4;
    this.svipMonth = paramInt5;
    this.isShow = paramInt6;
    this.limitFree = paramInt7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isOnShelf = paramJceInputStream.read(this.isOnShelf, 1, false);
    this.strxyjson = paramJceInputStream.readString(2, false);
    this.mallurl = paramJceInputStream.readString(3, false);
    this.mallname = paramJceInputStream.readString(4, false);
    this.faceHashId = paramJceInputStream.readString(5, false);
    this.headurl = paramJceInputStream.readString(6, false);
    this.sourceId = paramJceInputStream.read(this.sourceId, 7, false);
    this.productName = paramJceInputStream.readString(8, false);
    this.productIcon = paramJceInputStream.readString(9, false);
    this.price = paramJceInputStream.read(this.price, 10, false);
    this.validDay = paramJceInputStream.read(this.validDay, 11, false);
    this.svipLevel = paramJceInputStream.read(this.svipLevel, 12, false);
    this.svipMonth = paramJceInputStream.read(this.svipMonth, 13, false);
    this.isShow = paramJceInputStream.read(this.isShow, 14, false);
    this.limitFree = paramJceInputStream.read(this.limitFree, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isOnShelf, 1);
    if (this.strxyjson != null) {
      paramJceOutputStream.write(this.strxyjson, 2);
    }
    if (this.mallurl != null) {
      paramJceOutputStream.write(this.mallurl, 3);
    }
    if (this.mallname != null) {
      paramJceOutputStream.write(this.mallname, 4);
    }
    if (this.faceHashId != null) {
      paramJceOutputStream.write(this.faceHashId, 5);
    }
    if (this.headurl != null) {
      paramJceOutputStream.write(this.headurl, 6);
    }
    paramJceOutputStream.write(this.sourceId, 7);
    if (this.productName != null) {
      paramJceOutputStream.write(this.productName, 8);
    }
    if (this.productIcon != null) {
      paramJceOutputStream.write(this.productIcon, 9);
    }
    paramJceOutputStream.write(this.price, 10);
    paramJceOutputStream.write(this.validDay, 11);
    paramJceOutputStream.write(this.svipLevel, 12);
    paramJceOutputStream.write(this.svipMonth, 13);
    paramJceOutputStream.write(this.isShow, 14);
    paramJceOutputStream.write(this.limitFree, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiExtraInfo
 * JD-Core Version:    0.7.0.1
 */