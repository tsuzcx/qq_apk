package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetRichSigReq
  extends JceStruct
{
  static int cache_eSourceID;
  static byte[] cache_vbSignature;
  public int eSourceID;
  public byte[] vbSignature;
  
  public SetRichSigReq() {}
  
  public SetRichSigReq(byte[] paramArrayOfByte, int paramInt)
  {
    this.vbSignature = paramArrayOfByte;
    this.eSourceID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vbSignature == null)
    {
      cache_vbSignature = (byte[])new byte[1];
      ((byte[])cache_vbSignature)[0] = 0;
    }
    this.vbSignature = ((byte[])paramJceInputStream.read(cache_vbSignature, 1, false));
    this.eSourceID = paramJceInputStream.read(this.eSourceID, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vbSignature != null) {
      paramJceOutputStream.write(this.vbSignature, 1);
    }
    paramJceOutputStream.write(this.eSourceID, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.SetRichSigReq
 * JD-Core Version:    0.7.0.1
 */