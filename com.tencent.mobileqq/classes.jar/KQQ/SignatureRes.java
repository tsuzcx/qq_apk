package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SignatureRes
  extends JceStruct
{
  public long dwSeq = 0L;
  public String strLongNick = "";
  public long uin = 0L;
  
  public SignatureRes() {}
  
  public SignatureRes(long paramLong1, long paramLong2, String paramString)
  {
    this.uin = paramLong1;
    this.dwSeq = paramLong2;
    this.strLongNick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.dwSeq = paramJceInputStream.read(this.dwSeq, 1, true);
    this.strLongNick = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.dwSeq, 1);
    paramJceOutputStream.write(this.strLongNick, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.SignatureRes
 * JD-Core Version:    0.7.0.1
 */