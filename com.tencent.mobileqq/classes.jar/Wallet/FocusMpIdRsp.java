package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FocusMpIdRsp
  extends JceStruct
{
  public int err_code;
  
  public FocusMpIdRsp() {}
  
  public FocusMpIdRsp(int paramInt)
  {
    this.err_code = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.err_code = paramJceInputStream.read(this.err_code, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.err_code, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.FocusMpIdRsp
 * JD-Core Version:    0.7.0.1
 */