package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSplitBlock
  extends JceStruct
{
  public int style = 0;
  public String text = "";
  public String tips = "";
  
  public stSplitBlock() {}
  
  public stSplitBlock(String paramString1, String paramString2, int paramInt)
  {
    this.text = paramString1;
    this.tips = paramString2;
    this.style = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text = paramJceInputStream.readString(0, false);
    this.tips = paramJceInputStream.readString(1, false);
    this.style = paramJceInputStream.read(this.style, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.text;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.tips;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.style, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSplitBlock
 * JD-Core Version:    0.7.0.1
 */