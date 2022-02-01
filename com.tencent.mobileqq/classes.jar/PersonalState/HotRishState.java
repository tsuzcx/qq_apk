package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HotRishState
  extends JceStruct
{
  public int iActId = 0;
  public int iDataId = 0;
  
  public HotRishState() {}
  
  public HotRishState(int paramInt1, int paramInt2)
  {
    this.iActId = paramInt1;
    this.iDataId = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iActId = paramJceInputStream.read(this.iActId, 0, true);
    this.iDataId = paramJceInputStream.read(this.iDataId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iActId, 0);
    paramJceOutputStream.write(this.iDataId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PersonalState.HotRishState
 * JD-Core Version:    0.7.0.1
 */