package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CheckSinglePkgSigRsp
  extends JceStruct
{
  static ArrayList<NoCheckMarket> cache_vtMarket = new ArrayList();
  public String pageUrl = "";
  public String pkgSig = "";
  public int ret;
  public int sigVersionCode;
  public String tmastUrl = "";
  public ArrayList<NoCheckMarket> vtMarket;
  
  static
  {
    NoCheckMarket localNoCheckMarket = new NoCheckMarket();
    cache_vtMarket.add(localNoCheckMarket);
  }
  
  public CheckSinglePkgSigRsp() {}
  
  public CheckSinglePkgSigRsp(int paramInt1, ArrayList<NoCheckMarket> paramArrayList, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    this.ret = paramInt1;
    this.vtMarket = paramArrayList;
    this.pkgSig = paramString1;
    this.sigVersionCode = paramInt2;
    this.tmastUrl = paramString2;
    this.pageUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.vtMarket = ((ArrayList)paramJceInputStream.read(cache_vtMarket, 1, false));
    this.pkgSig = paramJceInputStream.readString(2, false);
    this.sigVersionCode = paramJceInputStream.read(this.sigVersionCode, 3, false);
    this.tmastUrl = paramJceInputStream.readString(4, false);
    this.pageUrl = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.vtMarket != null) {
      paramJceOutputStream.write(this.vtMarket, 1);
    }
    if (this.pkgSig != null) {
      paramJceOutputStream.write(this.pkgSig, 2);
    }
    paramJceOutputStream.write(this.sigVersionCode, 3);
    if (this.tmastUrl != null) {
      paramJceOutputStream.write(this.tmastUrl, 4);
    }
    if (this.pageUrl != null) {
      paramJceOutputStream.write(this.pageUrl, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MAAccessClient.CheckSinglePkgSigRsp
 * JD-Core Version:    0.7.0.1
 */