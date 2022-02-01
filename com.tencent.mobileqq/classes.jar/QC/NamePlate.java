package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NamePlate
  extends JceStruct
{
  public int isgray = 0;
  public int issetpendant = 0;
  public int pendantid = 0;
  public int viptypeid = 0;
  
  public NamePlate() {}
  
  public NamePlate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.viptypeid = paramInt1;
    this.isgray = paramInt2;
    this.issetpendant = paramInt3;
    this.pendantid = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.viptypeid = paramJceInputStream.read(this.viptypeid, 0, false);
    this.isgray = paramJceInputStream.read(this.isgray, 1, false);
    this.issetpendant = paramJceInputStream.read(this.issetpendant, 2, false);
    this.pendantid = paramJceInputStream.read(this.pendantid, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.viptypeid, 0);
    paramJceOutputStream.write(this.isgray, 1);
    paramJceOutputStream.write(this.issetpendant, 2);
    paramJceOutputStream.write(this.pendantid, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.NamePlate
 * JD-Core Version:    0.7.0.1
 */