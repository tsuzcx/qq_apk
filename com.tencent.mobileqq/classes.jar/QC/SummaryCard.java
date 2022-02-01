package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SummaryCard
  extends JceStruct
{
  public int bgid = 0;
  public int color = 0;
  public int styleid = 0;
  public String url = "";
  
  public SummaryCard() {}
  
  public SummaryCard(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.styleid = paramInt1;
    this.bgid = paramInt2;
    this.url = paramString;
    this.color = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.styleid = paramJceInputStream.read(this.styleid, 0, false);
    this.bgid = paramJceInputStream.read(this.bgid, 1, false);
    this.url = paramJceInputStream.readString(2, false);
    this.color = paramJceInputStream.read(this.color, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.styleid, 0);
    paramJceOutputStream.write(this.bgid, 1);
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.color, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.SummaryCard
 * JD-Core Version:    0.7.0.1
 */