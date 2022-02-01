package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CheckSinglePkgSigRsp
  extends JceStruct
{
  static ArrayList<NoCheckMarket> cache_vtMarket = new ArrayList();
  public String pageUrl = "";
  public String pkgSig = "";
  public int ret = 0;
  public int sigVersionCode = 0;
  public String tmastUrl = "";
  public ArrayList<NoCheckMarket> vtMarket = null;
  
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
    Object localObject = this.vtMarket;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.pkgSig;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.sigVersionCode, 3);
    localObject = this.tmastUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.pageUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MAAccessClient.CheckSinglePkgSigRsp
 * JD-Core Version:    0.7.0.1
 */