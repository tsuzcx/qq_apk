package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class DownloadChooseReq
  extends JceStruct
{
  static ArrayList<ResInfo> cache_vecResInfo = new ArrayList();
  public int iActId = 1001;
  public int iPlatForm = 1;
  public long iUin = 0L;
  public ArrayList<ResInfo> vecResInfo = null;
  
  static
  {
    ResInfo localResInfo = new ResInfo();
    cache_vecResInfo.add(localResInfo);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iActId = paramJceInputStream.read(this.iActId, 0, false);
    this.iPlatForm = paramJceInputStream.read(this.iPlatForm, 1, false);
    this.iUin = paramJceInputStream.read(this.iUin, 2, false);
    this.vecResInfo = ((ArrayList)paramJceInputStream.read(cache_vecResInfo, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iActId, 0);
    paramJceOutputStream.write(this.iPlatForm, 1);
    paramJceOutputStream.write(this.iUin, 2);
    if (this.vecResInfo != null) {
      paramJceOutputStream.write(this.vecResInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.DownloadChooseReq
 * JD-Core Version:    0.7.0.1
 */