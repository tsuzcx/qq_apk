package MWIFI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CSGet3rdCloudCheck
  extends JceStruct
{
  static ArrayList<String> cache_vecDns;
  static WifiInfo cache_wifiInfo = new WifiInfo();
  public String imei = "";
  public String mac = "";
  public int networkType = 0;
  public int operType = 0;
  public ArrayList<String> vecDns = null;
  public String vid = "";
  public WifiInfo wifiInfo = null;
  
  static
  {
    cache_vecDns = new ArrayList();
    cache_vecDns.add("");
  }
  
  public JceStruct newInit()
  {
    return new CSGet3rdCloudCheck();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.networkType = paramJceInputStream.read(this.networkType, 0, false);
    this.operType = paramJceInputStream.read(this.operType, 1, false);
    this.wifiInfo = ((WifiInfo)paramJceInputStream.read(cache_wifiInfo, 2, false));
    this.vecDns = ((ArrayList)paramJceInputStream.read(cache_vecDns, 3, false));
    this.vid = paramJceInputStream.readString(4, false);
    this.mac = paramJceInputStream.readString(5, false);
    this.imei = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.networkType;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.operType;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    Object localObject = this.wifiInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.vecDns;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.vid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.mac;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.imei;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MWIFI.CSGet3rdCloudCheck
 * JD-Core Version:    0.7.0.1
 */