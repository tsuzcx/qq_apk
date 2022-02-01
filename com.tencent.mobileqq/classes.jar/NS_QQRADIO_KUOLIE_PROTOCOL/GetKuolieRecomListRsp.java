package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetKuolieRecomListRsp
  extends JceStruct
{
  static CommonInfo cache_commInfo = new CommonInfo();
  static Map<String, String> cache_dc_report;
  static DefaultInfo cache_info;
  static ArrayList<SimpleKuolieRoomInfo> cache_roomList;
  static SimpleKuolieRoomInfo cache_userRoom = new SimpleKuolieRoomInfo();
  public CommonInfo commInfo = null;
  public Map<String, String> dc_report = null;
  public int favNum = 0;
  public DefaultInfo info = null;
  public ArrayList<SimpleKuolieRoomInfo> roomList = null;
  public String userId = "";
  public SimpleKuolieRoomInfo userRoom = null;
  
  static
  {
    cache_roomList = new ArrayList();
    SimpleKuolieRoomInfo localSimpleKuolieRoomInfo = new SimpleKuolieRoomInfo();
    cache_roomList.add(localSimpleKuolieRoomInfo);
    cache_info = new DefaultInfo();
    cache_dc_report = new HashMap();
    cache_dc_report.put("", "");
  }
  
  public GetKuolieRecomListRsp() {}
  
  public GetKuolieRecomListRsp(CommonInfo paramCommonInfo, String paramString, int paramInt, SimpleKuolieRoomInfo paramSimpleKuolieRoomInfo, ArrayList<SimpleKuolieRoomInfo> paramArrayList, DefaultInfo paramDefaultInfo, Map<String, String> paramMap)
  {
    this.commInfo = paramCommonInfo;
    this.userId = paramString;
    this.favNum = paramInt;
    this.userRoom = paramSimpleKuolieRoomInfo;
    this.roomList = paramArrayList;
    this.info = paramDefaultInfo;
    this.dc_report = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commInfo = ((CommonInfo)paramJceInputStream.read(cache_commInfo, 0, false));
    this.userId = paramJceInputStream.readString(1, false);
    this.favNum = paramJceInputStream.read(this.favNum, 2, false);
    this.userRoom = ((SimpleKuolieRoomInfo)paramJceInputStream.read(cache_userRoom, 3, false));
    this.roomList = ((ArrayList)paramJceInputStream.read(cache_roomList, 4, false));
    this.info = ((DefaultInfo)paramJceInputStream.read(cache_info, 5, false));
    this.dc_report = ((Map)paramJceInputStream.read(cache_dc_report, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commInfo != null) {
      paramJceOutputStream.write(this.commInfo, 0);
    }
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 1);
    }
    paramJceOutputStream.write(this.favNum, 2);
    if (this.userRoom != null) {
      paramJceOutputStream.write(this.userRoom, 3);
    }
    if (this.roomList != null) {
      paramJceOutputStream.write(this.roomList, 4);
    }
    if (this.info != null) {
      paramJceOutputStream.write(this.info, 5);
    }
    if (this.dc_report != null) {
      paramJceOutputStream.write(this.dc_report, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieRecomListRsp
 * JD-Core Version:    0.7.0.1
 */