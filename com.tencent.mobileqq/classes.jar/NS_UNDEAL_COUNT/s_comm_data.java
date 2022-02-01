package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_comm_data
  extends JceStruct
{
  static byte[] cache_vecData;
  public int iHasDataFlag;
  public String strAttachInfo = "";
  public byte[] vecData;
  
  public s_comm_data() {}
  
  public s_comm_data(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.iHasDataFlag = paramInt;
    this.strAttachInfo = paramString;
    this.vecData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iHasDataFlag = paramJceInputStream.read(this.iHasDataFlag, 0, false);
    this.strAttachInfo = paramJceInputStream.readString(1, false);
    if (cache_vecData == null)
    {
      cache_vecData = (byte[])new byte[1];
      ((byte[])cache_vecData)[0] = 0;
    }
    this.vecData = ((byte[])paramJceInputStream.read(cache_vecData, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iHasDataFlag, 0);
    Object localObject = this.strAttachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.vecData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.s_comm_data
 * JD-Core Version:    0.7.0.1
 */