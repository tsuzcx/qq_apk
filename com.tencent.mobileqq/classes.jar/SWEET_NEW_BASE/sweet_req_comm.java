package SWEET_NEW_BASE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_req_comm
  extends JceStruct
{
  static int cache_pf = 0;
  static int cache_src = 0;
  public long loveuin;
  public long opuin;
  public int pf;
  public String qua = "";
  public int src;
  public long uin;
  
  public sweet_req_comm() {}
  
  public sweet_req_comm(long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt1, int paramInt2)
  {
    this.opuin = paramLong1;
    this.uin = paramLong2;
    this.loveuin = paramLong3;
    this.qua = paramString;
    this.src = paramInt1;
    this.pf = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opuin = paramJceInputStream.read(this.opuin, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.loveuin = paramJceInputStream.read(this.loveuin, 2, false);
    this.qua = paramJceInputStream.readString(3, false);
    this.src = paramJceInputStream.read(this.src, 4, false);
    this.pf = paramJceInputStream.read(this.pf, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opuin, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.loveuin, 2);
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 3);
    }
    paramJceOutputStream.write(this.src, 4);
    paramJceOutputStream.write(this.pf, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SWEET_NEW_BASE.sweet_req_comm
 * JD-Core Version:    0.7.0.1
 */