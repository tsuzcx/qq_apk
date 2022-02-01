package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiExtraInfo
  extends JceStruct
{
  public String faceHashId = "";
  public String headurl = "";
  public int isOnShelf = 0;
  public String mallname = "";
  public String mallurl = "";
  public long sourceId = 0L;
  public String strxyjson = "";
  
  public UniBusiExtraInfo() {}
  
  public UniBusiExtraInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    this.isOnShelf = paramInt;
    this.strxyjson = paramString1;
    this.mallurl = paramString2;
    this.mallname = paramString3;
    this.faceHashId = paramString4;
    this.headurl = paramString5;
    this.sourceId = paramLong;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isOnShelf, 1);
    String str = this.strxyjson;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.mallurl;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.mallname;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.faceHashId;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.headurl;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.sourceId, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiExtraInfo
 * JD-Core Version:    0.7.0.1
 */