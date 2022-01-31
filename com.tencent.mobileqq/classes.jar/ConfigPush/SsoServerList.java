package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SsoServerList
  extends JceStruct
{
  static ArrayList cache_v2G3GList;
  static ArrayList cache_vHttp_2G3GList;
  static ArrayList cache_vHttp_WifiList;
  static ArrayList cache_vWifiList;
  public byte bTestSpeed;
  public byte bUseNewList;
  public int iMultiConn = 1;
  public int iReconnect;
  public ArrayList v2G3GList;
  public ArrayList vHttp_2G3GList;
  public ArrayList vHttp_WifiList;
  public ArrayList vWifiList;
  
  public SsoServerList() {}
  
  public SsoServerList(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    this.v2G3GList = paramArrayList1;
    this.vWifiList = paramArrayList2;
    this.iReconnect = paramInt1;
    this.bTestSpeed = paramByte1;
    this.bUseNewList = paramByte2;
    this.iMultiConn = paramInt2;
    this.vHttp_2G3GList = paramArrayList3;
    this.vHttp_WifiList = paramArrayList4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    SsoServerListInfo localSsoServerListInfo;
    if (cache_v2G3GList == null)
    {
      cache_v2G3GList = new ArrayList();
      localSsoServerListInfo = new SsoServerListInfo();
      cache_v2G3GList.add(localSsoServerListInfo);
    }
    this.v2G3GList = ((ArrayList)paramJceInputStream.read(cache_v2G3GList, 1, true));
    if (cache_vWifiList == null)
    {
      cache_vWifiList = new ArrayList();
      localSsoServerListInfo = new SsoServerListInfo();
      cache_vWifiList.add(localSsoServerListInfo);
    }
    this.vWifiList = ((ArrayList)paramJceInputStream.read(cache_vWifiList, 3, true));
    this.iReconnect = paramJceInputStream.read(this.iReconnect, 4, true);
    this.bTestSpeed = paramJceInputStream.read(this.bTestSpeed, 5, false);
    this.bUseNewList = paramJceInputStream.read(this.bUseNewList, 6, false);
    this.iMultiConn = paramJceInputStream.read(this.iMultiConn, 7, false);
    if (cache_vHttp_2G3GList == null)
    {
      cache_vHttp_2G3GList = new ArrayList();
      localSsoServerListInfo = new SsoServerListInfo();
      cache_vHttp_2G3GList.add(localSsoServerListInfo);
    }
    this.vHttp_2G3GList = ((ArrayList)paramJceInputStream.read(cache_vHttp_2G3GList, 8, false));
    if (cache_vHttp_WifiList == null)
    {
      cache_vHttp_WifiList = new ArrayList();
      localSsoServerListInfo = new SsoServerListInfo();
      cache_vHttp_WifiList.add(localSsoServerListInfo);
    }
    this.vHttp_WifiList = ((ArrayList)paramJceInputStream.read(cache_vHttp_WifiList, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.v2G3GList, 1);
    paramJceOutputStream.write(this.vWifiList, 3);
    paramJceOutputStream.write(this.iReconnect, 4);
    paramJceOutputStream.write(this.bTestSpeed, 5);
    paramJceOutputStream.write(this.bUseNewList, 6);
    paramJceOutputStream.write(this.iMultiConn, 7);
    if (this.vHttp_2G3GList != null) {
      paramJceOutputStream.write(this.vHttp_2G3GList, 8);
    }
    if (this.vHttp_WifiList != null) {
      paramJceOutputStream.write(this.vHttp_WifiList, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ConfigPush.SsoServerList
 * JD-Core Version:    0.7.0.1
 */