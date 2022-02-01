package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiSimpleItemDetail
  extends JceStruct
{
  static UniBusiCommItemAidInfo cache_stAidInfo = new UniBusiCommItemAidInfo();
  static UniBusiSimpleFontItem cache_stFontItem = new UniBusiSimpleFontItem();
  static UniBusiSimpleSigItem cache_stSigItem = new UniBusiSimpleSigItem();
  public int appId = 0;
  public int feeType = 0;
  public String image = "";
  public String itemBgColor = "";
  public int itemId = 0;
  public String name = "";
  public UniBusiCommItemAidInfo stAidInfo = null;
  public UniBusiSimpleFontItem stFontItem = null;
  public UniBusiSimpleSigItem stSigItem = null;
  
  public UniBusiSimpleItemDetail() {}
  
  public UniBusiSimpleItemDetail(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, UniBusiCommItemAidInfo paramUniBusiCommItemAidInfo, UniBusiSimpleSigItem paramUniBusiSimpleSigItem, UniBusiSimpleFontItem paramUniBusiSimpleFontItem)
  {
    this.appId = paramInt1;
    this.itemId = paramInt2;
    this.name = paramString1;
    this.feeType = paramInt3;
    this.image = paramString2;
    this.itemBgColor = paramString3;
    this.stAidInfo = paramUniBusiCommItemAidInfo;
    this.stSigItem = paramUniBusiSimpleSigItem;
    this.stFontItem = paramUniBusiSimpleFontItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appId = paramJceInputStream.read(this.appId, 0, false);
    this.itemId = paramJceInputStream.read(this.itemId, 1, false);
    this.name = paramJceInputStream.readString(2, false);
    this.feeType = paramJceInputStream.read(this.feeType, 3, false);
    this.image = paramJceInputStream.readString(4, false);
    this.itemBgColor = paramJceInputStream.readString(5, false);
    this.stAidInfo = ((UniBusiCommItemAidInfo)paramJceInputStream.read(cache_stAidInfo, 6, false));
    this.stSigItem = ((UniBusiSimpleSigItem)paramJceInputStream.read(cache_stSigItem, 7, false));
    this.stFontItem = ((UniBusiSimpleFontItem)paramJceInputStream.read(cache_stFontItem, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.itemId, 1);
    Object localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.feeType, 3);
    localObject = this.image;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.itemBgColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.stAidInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.stSigItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.stFontItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiSimpleItemDetail
 * JD-Core Version:    0.7.0.1
 */