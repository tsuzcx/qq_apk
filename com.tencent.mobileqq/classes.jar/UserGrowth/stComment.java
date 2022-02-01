package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stComment
  extends JceStruct
{
  public int count = 0;
  
  public stComment() {}
  
  public stComment(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.count = paramJceInputStream.read(this.count, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.count, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stComment
 * JD-Core Version:    0.7.0.1
 */