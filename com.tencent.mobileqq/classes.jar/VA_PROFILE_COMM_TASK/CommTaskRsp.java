package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommTaskRsp
  extends JceStruct
{
  static byte[] cache_vTaskData = (byte[])new byte[1];
  public long iRetCode = 0L;
  public String sRetMsg = "";
  public byte[] vTaskData = null;
  
  static
  {
    ((byte[])cache_vTaskData)[0] = 0;
  }
  
  public CommTaskRsp() {}
  
  public CommTaskRsp(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    this.iRetCode = paramLong;
    this.sRetMsg = paramString;
    this.vTaskData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 0, false);
    this.sRetMsg = paramJceInputStream.readString(1, false);
    this.vTaskData = ((byte[])paramJceInputStream.read(cache_vTaskData, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRetCode, 0);
    Object localObject = this.sRetMsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.vTaskData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VA_PROFILE_COMM_TASK.CommTaskRsp
 * JD-Core Version:    0.7.0.1
 */