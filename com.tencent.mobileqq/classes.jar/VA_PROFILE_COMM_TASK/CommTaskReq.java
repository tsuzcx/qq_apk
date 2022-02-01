package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommTaskReq
  extends JceStruct
{
  static CommHeader cache_stHeader = new CommHeader();
  static byte[] cache_vTaskData = (byte[])new byte[1];
  public CommHeader stHeader = null;
  public byte[] vTaskData = null;
  
  static
  {
    ((byte[])cache_vTaskData)[0] = 0;
  }
  
  public CommTaskReq() {}
  
  public CommTaskReq(CommHeader paramCommHeader, byte[] paramArrayOfByte)
  {
    this.stHeader = paramCommHeader;
    this.vTaskData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stHeader = ((CommHeader)paramJceInputStream.read(cache_stHeader, 0, false));
    this.vTaskData = ((byte[])paramJceInputStream.read(cache_vTaskData, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stHeader;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.vTaskData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VA_PROFILE_COMM_TASK.CommTaskReq
 * JD-Core Version:    0.7.0.1
 */