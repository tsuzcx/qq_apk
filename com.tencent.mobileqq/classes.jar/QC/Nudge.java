package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Nudge
  extends JceStruct
{
  public String customtext = "";
  public int effectid;
  public int ischangecustomtext;
  public int ischangeswitch;
  public int isclose;
  
  public Nudge() {}
  
  public Nudge(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.effectid = paramInt1;
    this.ischangeswitch = paramInt2;
    this.isclose = paramInt3;
    this.ischangecustomtext = paramInt4;
    this.customtext = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.effectid = paramJceInputStream.read(this.effectid, 0, false);
    this.ischangeswitch = paramJceInputStream.read(this.ischangeswitch, 1, false);
    this.isclose = paramJceInputStream.read(this.isclose, 2, false);
    this.ischangecustomtext = paramJceInputStream.read(this.ischangecustomtext, 3, false);
    this.customtext = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.effectid, 0);
    paramJceOutputStream.write(this.ischangeswitch, 1);
    paramJceOutputStream.write(this.isclose, 2);
    paramJceOutputStream.write(this.ischangecustomtext, 3);
    if (this.customtext != null) {
      paramJceOutputStream.write(this.customtext, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.Nudge
 * JD-Core Version:    0.7.0.1
 */