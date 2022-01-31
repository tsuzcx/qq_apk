package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserCntlData
  extends JceStruct
{
  public long lLastPos;
  public int nVersion;
  
  public UserCntlData() {}
  
  public UserCntlData(int paramInt, long paramLong)
  {
    this.nVersion = paramInt;
    this.lLastPos = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nVersion = paramJceInputStream.read(this.nVersion, 0, false);
    this.lLastPos = paramJceInputStream.read(this.lLastPos, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nVersion, 0);
    paramJceOutputStream.write(this.lLastPos, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PersonalState.UserCntlData
 * JD-Core Version:    0.7.0.1
 */