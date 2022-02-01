package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EctFragmentation
  extends JceStruct
{
  public int iSelfIndex = 0;
  public int iTotalNum = 0;
  
  public EctFragmentation() {}
  
  public EctFragmentation(int paramInt1, int paramInt2)
  {
    this.iTotalNum = paramInt1;
    this.iSelfIndex = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 0, true);
    this.iSelfIndex = paramJceInputStream.read(this.iSelfIndex, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTotalNum, 0);
    paramJceOutputStream.write(this.iSelfIndex, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NeighborComm.EctFragmentation
 * JD-Core Version:    0.7.0.1
 */