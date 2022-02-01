package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPlusRecomInfo
  extends JceStruct
{
  public int status = 0;
  public String strMinProgramJson = "";
  
  public stPlusRecomInfo() {}
  
  public stPlusRecomInfo(int paramInt, String paramString)
  {
    this.status = paramInt;
    this.strMinProgramJson = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
    this.strMinProgramJson = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    if (this.strMinProgramJson != null) {
      paramJceOutputStream.write(this.strMinProgramJson, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.stPlusRecomInfo
 * JD-Core Version:    0.7.0.1
 */