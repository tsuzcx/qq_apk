package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetKuolieFavListRsp
  extends JceStruct
{
  static CommonInfo cache_commInfo = new CommonInfo();
  static ArrayList<SimpleKuolieRoomInfo> cache_roomList = new ArrayList();
  public CommonInfo commInfo = null;
  public ArrayList<SimpleKuolieRoomInfo> roomList = null;
  
  static
  {
    SimpleKuolieRoomInfo localSimpleKuolieRoomInfo = new SimpleKuolieRoomInfo();
    cache_roomList.add(localSimpleKuolieRoomInfo);
  }
  
  public GetKuolieFavListRsp() {}
  
  public GetKuolieFavListRsp(CommonInfo paramCommonInfo, ArrayList<SimpleKuolieRoomInfo> paramArrayList)
  {
    this.commInfo = paramCommonInfo;
    this.roomList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commInfo = ((CommonInfo)paramJceInputStream.read(cache_commInfo, 0, false));
    this.roomList = ((ArrayList)paramJceInputStream.read(cache_roomList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.commInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.roomList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieFavListRsp
 * JD-Core Version:    0.7.0.1
 */