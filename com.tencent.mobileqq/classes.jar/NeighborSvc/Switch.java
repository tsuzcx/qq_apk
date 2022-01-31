package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Switch
  extends JceStruct
{
  static int cache_type;
  public byte is_open;
  public int type;
  
  public Switch() {}
  
  public Switch(int paramInt, byte paramByte)
  {
    this.type = paramInt;
    this.is_open = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.is_open = paramJceInputStream.read(this.is_open, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.is_open, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborSvc.Switch
 * JD-Core Version:    0.7.0.1
 */