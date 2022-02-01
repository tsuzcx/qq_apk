package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class j
  extends JceStruct
{
  public String bD = "";
  public String bE = "";
  public int bF = 0;
  public int bG = 0;
  public int bgColor = 0;
  public int type = 0;
  
  public JceStruct newInit()
  {
    return new j();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bD = paramJceInputStream.readString(0, false);
    this.bE = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.bF = paramJceInputStream.read(this.bF, 3, false);
    this.bG = paramJceInputStream.read(this.bG, 4, false);
    this.bgColor = paramJceInputStream.read(this.bgColor, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.bD;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.bE;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.type;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.bF;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    i = this.bG;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    i = this.bgColor;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Protocol.MConch.j
 * JD-Core Version:    0.7.0.1
 */