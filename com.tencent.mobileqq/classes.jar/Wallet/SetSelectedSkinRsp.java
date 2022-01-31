package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetSelectedSkinRsp
  extends JceStruct
{
  public int ret;
  
  public SetSelectedSkinRsp() {}
  
  public SetSelectedSkinRsp(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.SetSelectedSkinRsp
 * JD-Core Version:    0.7.0.1
 */