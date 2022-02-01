package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetKuolieFriendRecomRsp
  extends JceStruct
{
  static CommonInfo cache_commInfo = new CommonInfo();
  static SimpleKuolieRoomInfo cache_roomInfo = new SimpleKuolieRoomInfo();
  static ArrayList<User> cache_userList = new ArrayList();
  public CommonInfo commInfo = null;
  public SimpleKuolieRoomInfo roomInfo = null;
  public ArrayList<User> userList = null;
  
  static
  {
    User localUser = new User();
    cache_userList.add(localUser);
  }
  
  public GetKuolieFriendRecomRsp() {}
  
  public GetKuolieFriendRecomRsp(CommonInfo paramCommonInfo, SimpleKuolieRoomInfo paramSimpleKuolieRoomInfo, ArrayList<User> paramArrayList)
  {
    this.commInfo = paramCommonInfo;
    this.roomInfo = paramSimpleKuolieRoomInfo;
    this.userList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commInfo = ((CommonInfo)paramJceInputStream.read(cache_commInfo, 0, false));
    this.roomInfo = ((SimpleKuolieRoomInfo)paramJceInputStream.read(cache_roomInfo, 1, false));
    this.userList = ((ArrayList)paramJceInputStream.read(cache_userList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.commInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.roomInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.userList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieFriendRecomRsp
 * JD-Core Version:    0.7.0.1
 */