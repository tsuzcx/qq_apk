package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCommentJumpText
  extends JceStruct
{
  public String h5_url = "";
  public int index = 0;
  public String schema_url = "";
  public String text = "";
  
  public stCommentJumpText() {}
  
  public stCommentJumpText(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.text = paramString1;
    this.index = paramInt;
    this.h5_url = paramString2;
    this.schema_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text = paramJceInputStream.readString(0, false);
    this.index = paramJceInputStream.read(this.index, 1, false);
    this.h5_url = paramJceInputStream.readString(2, false);
    this.schema_url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.text;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.index, 1);
    str = this.h5_url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.schema_url;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stCommentJumpText
 * JD-Core Version:    0.7.0.1
 */