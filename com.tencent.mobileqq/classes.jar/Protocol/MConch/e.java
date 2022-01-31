package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<c> bx = new ArrayList();
  public long bt = 0L;
  public long bu = 0L;
  public ArrayList<c> bw = null;
  
  static
  {
    c localc = new c();
    bx.add(localc);
  }
  
  public JceStruct newInit()
  {
    return new e();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bt = paramJceInputStream.read(this.bt, 0, false);
    this.bu = paramJceInputStream.read(this.bu, 1, false);
    this.bw = ((ArrayList)paramJceInputStream.read(bx, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bt != 0L) {
      paramJceOutputStream.write(this.bt, 0);
    }
    if (this.bu != 0L) {
      paramJceOutputStream.write(this.bu, 1);
    }
    if (this.bw != null) {
      paramJceOutputStream.write(this.bw, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Protocol.MConch.e
 * JD-Core Version:    0.7.0.1
 */