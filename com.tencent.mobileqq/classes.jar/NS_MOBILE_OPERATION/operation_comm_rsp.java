package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_comm_rsp
  extends JceStruct
{
  static byte[] cache_message = (byte[])new byte[1];
  public byte[] message = null;
  public String msg = "";
  public int ret = 0;
  
  static
  {
    ((byte[])cache_message)[0] = 0;
  }
  
  public operation_comm_rsp() {}
  
  public operation_comm_rsp(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.message = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.message = ((byte[])paramJceInputStream.read(cache_message, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.message;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_comm_rsp
 * JD-Core Version:    0.7.0.1
 */