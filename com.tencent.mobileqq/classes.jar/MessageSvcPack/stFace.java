package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFace
  extends JceStruct
{
  public long index;
  
  public stFace() {}
  
  public stFace(long paramLong)
  {
    this.index = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.stFace
 * JD-Core Version:    0.7.0.1
 */