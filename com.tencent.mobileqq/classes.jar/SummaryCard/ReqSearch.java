package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqSearch
  extends JceStruct
{
  static ArrayList cache_vvReqServices;
  public int shVersion;
  public String strCountryCode = "";
  public String strKeyword = "";
  public ArrayList vvReqServices;
  
  public ReqSearch() {}
  
  public ReqSearch(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList)
  {
    this.strKeyword = paramString1;
    this.strCountryCode = paramString2;
    this.shVersion = paramInt;
    this.vvReqServices = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strKeyword = paramJceInputStream.readString(0, true);
    this.strCountryCode = paramJceInputStream.readString(1, true);
    this.shVersion = paramJceInputStream.read(this.shVersion, 2, false);
    if (cache_vvReqServices == null)
    {
      cache_vvReqServices = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_vvReqServices.add(arrayOfByte);
    }
    this.vvReqServices = ((ArrayList)paramJceInputStream.read(cache_vvReqServices, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strKeyword, 0);
    paramJceOutputStream.write(this.strCountryCode, 1);
    paramJceOutputStream.write(this.shVersion, 2);
    if (this.vvReqServices != null) {
      paramJceOutputStream.write(this.vvReqServices, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SummaryCard.ReqSearch
 * JD-Core Version:    0.7.0.1
 */