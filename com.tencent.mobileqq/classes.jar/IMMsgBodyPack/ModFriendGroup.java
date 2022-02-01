package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ModFriendGroup
  extends JceStruct
{
  static ArrayList<FriendGroup> cache_vMsgFrdGroup;
  public ArrayList<FriendGroup> vMsgFrdGroup = null;
  
  public ModFriendGroup() {}
  
  public ModFriendGroup(ArrayList<FriendGroup> paramArrayList)
  {
    this.vMsgFrdGroup = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vMsgFrdGroup == null)
    {
      cache_vMsgFrdGroup = new ArrayList();
      FriendGroup localFriendGroup = new FriendGroup();
      cache_vMsgFrdGroup.add(localFriendGroup);
    }
    this.vMsgFrdGroup = ((ArrayList)paramJceInputStream.read(cache_vMsgFrdGroup, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vMsgFrdGroup != null) {
      paramJceOutputStream.write(this.vMsgFrdGroup, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.ModFriendGroup
 * JD-Core Version:    0.7.0.1
 */