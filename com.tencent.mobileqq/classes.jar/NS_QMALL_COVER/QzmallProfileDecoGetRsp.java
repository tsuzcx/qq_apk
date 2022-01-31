package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallProfileDecoGetRsp
  extends JceStruct
{
  static byte[] cache_vecBuff = (byte[])new byte[1];
  public byte[] vecBuff;
  
  static
  {
    ((byte[])cache_vecBuff)[0] = 0;
  }
  
  public QzmallProfileDecoGetRsp() {}
  
  public QzmallProfileDecoGetRsp(byte[] paramArrayOfByte)
  {
    this.vecBuff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecBuff = ((byte[])paramJceInputStream.read(cache_vecBuff, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecBuff != null) {
      paramJceOutputStream.write(this.vecBuff, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallProfileDecoGetRsp
 * JD-Core Version:    0.7.0.1
 */