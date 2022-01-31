package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespLastGameInfo
  extends JceStruct
{
  static ArrayList cache_stGameLogoInfo;
  public boolean bNative = true;
  public boolean bShowGameLogo = true;
  public byte iResult;
  public byte iVersion = 1;
  public String sLogoUrl = "";
  public String sProfileUrl = "";
  public ArrayList stGameLogoInfo;
  
  public RespLastGameInfo() {}
  
  public RespLastGameInfo(byte paramByte1, byte paramByte2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, ArrayList paramArrayList, String paramString2)
  {
    this.iVersion = paramByte1;
    this.iResult = paramByte2;
    this.bShowGameLogo = paramBoolean1;
    this.bNative = paramBoolean2;
    this.sLogoUrl = paramString1;
    this.stGameLogoInfo = paramArrayList;
    this.sProfileUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersion = paramJceInputStream.read(this.iVersion, 0, true);
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.bShowGameLogo = paramJceInputStream.read(this.bShowGameLogo, 2, true);
    this.bNative = paramJceInputStream.read(this.bNative, 3, true);
    this.sLogoUrl = paramJceInputStream.readString(4, true);
    if (cache_stGameLogoInfo == null)
    {
      cache_stGameLogoInfo = new ArrayList();
      GameLogoUrl localGameLogoUrl = new GameLogoUrl();
      cache_stGameLogoInfo.add(localGameLogoUrl);
    }
    this.stGameLogoInfo = ((ArrayList)paramJceInputStream.read(cache_stGameLogoInfo, 5, true));
    this.sProfileUrl = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 0);
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.bShowGameLogo, 2);
    paramJceOutputStream.write(this.bNative, 3);
    paramJceOutputStream.write(this.sLogoUrl, 4);
    paramJceOutputStream.write(this.stGameLogoInfo, 5);
    if (this.sProfileUrl != null) {
      paramJceOutputStream.write(this.sProfileUrl, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     GameCenter.RespLastGameInfo
 * JD-Core Version:    0.7.0.1
 */