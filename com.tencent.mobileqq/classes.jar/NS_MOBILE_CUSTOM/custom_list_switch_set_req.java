package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class custom_list_switch_set_req
  extends JceStruct
{
  public int iAvatar;
  public int iCover;
  public int iCustomNavi;
  public int iCustomVip;
  public int iFacade;
  public int iFeedSkin;
  public int iFloat;
  public int iSetItemBits;
  public int iVisitorSkin;
  public String strTraceInfo = "";
  
  public custom_list_switch_set_req() {}
  
  public custom_list_switch_set_req(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, int paramInt8, int paramInt9)
  {
    this.iSetItemBits = paramInt1;
    this.iFeedSkin = paramInt2;
    this.iFacade = paramInt3;
    this.iAvatar = paramInt4;
    this.iFloat = paramInt5;
    this.iCover = paramInt6;
    this.strTraceInfo = paramString;
    this.iVisitorSkin = paramInt7;
    this.iCustomVip = paramInt8;
    this.iCustomNavi = paramInt9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSetItemBits = paramJceInputStream.read(this.iSetItemBits, 0, false);
    this.iFeedSkin = paramJceInputStream.read(this.iFeedSkin, 1, false);
    this.iFacade = paramJceInputStream.read(this.iFacade, 2, false);
    this.iAvatar = paramJceInputStream.read(this.iAvatar, 3, false);
    this.iFloat = paramJceInputStream.read(this.iFloat, 4, false);
    this.iCover = paramJceInputStream.read(this.iCover, 5, false);
    this.strTraceInfo = paramJceInputStream.readString(6, false);
    this.iVisitorSkin = paramJceInputStream.read(this.iVisitorSkin, 7, false);
    this.iCustomVip = paramJceInputStream.read(this.iCustomVip, 8, false);
    this.iCustomNavi = paramJceInputStream.read(this.iCustomNavi, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSetItemBits, 0);
    paramJceOutputStream.write(this.iFeedSkin, 1);
    paramJceOutputStream.write(this.iFacade, 2);
    paramJceOutputStream.write(this.iAvatar, 3);
    paramJceOutputStream.write(this.iFloat, 4);
    paramJceOutputStream.write(this.iCover, 5);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 6);
    }
    paramJceOutputStream.write(this.iVisitorSkin, 7);
    paramJceOutputStream.write(this.iCustomVip, 8);
    paramJceOutputStream.write(this.iCustomNavi, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch_set_req
 * JD-Core Version:    0.7.0.1
 */