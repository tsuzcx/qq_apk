package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSummaryCardOidbInfo
  extends JceStruct
{
  public String bgurl = "";
  public long styleid;
  public String version = "";
  
  public SSummaryCardOidbInfo() {}
  
  public SSummaryCardOidbInfo(long paramLong, String paramString1, String paramString2)
  {
    this.styleid = paramLong;
    this.bgurl = paramString1;
    this.version = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.styleid = paramJceInputStream.read(this.styleid, 1, false);
    this.bgurl = paramJceInputStream.readString(2, false);
    this.version = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.styleid, 1);
    if (this.bgurl != null) {
      paramJceOutputStream.write(this.bgurl, 2);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardOidbInfo
 * JD-Core Version:    0.7.0.1
 */