package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RedInfoSyncRsp
  extends JceStruct
{
  public int result = 0;
  
  public RedInfoSyncRsp() {}
  
  public RedInfoSyncRsp(int paramInt)
  {
    this.result = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.RedInfoSyncRsp
 * JD-Core Version:    0.7.0.1
 */