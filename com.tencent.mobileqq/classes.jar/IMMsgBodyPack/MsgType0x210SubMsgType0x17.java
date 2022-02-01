package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0x17
  extends JceStruct
{
  static AddGroup cache_stAddGroup;
  static DelGroup cache_stDelGroup;
  static ModFriendGroup cache_stModFriendGroup;
  static ModGroupName cache_stModGroupName;
  static ModGroupSort cache_stModGroupSort;
  public long dwOpType = 0L;
  public AddGroup stAddGroup = null;
  public DelGroup stDelGroup = null;
  public ModFriendGroup stModFriendGroup = null;
  public ModGroupName stModGroupName = null;
  public ModGroupSort stModGroupSort = null;
  
  public MsgType0x210SubMsgType0x17() {}
  
  public MsgType0x210SubMsgType0x17(long paramLong, AddGroup paramAddGroup, DelGroup paramDelGroup, ModGroupName paramModGroupName, ModGroupSort paramModGroupSort, ModFriendGroup paramModFriendGroup)
  {
    this.dwOpType = paramLong;
    this.stAddGroup = paramAddGroup;
    this.stDelGroup = paramDelGroup;
    this.stModGroupName = paramModGroupName;
    this.stModGroupSort = paramModGroupSort;
    this.stModFriendGroup = paramModFriendGroup;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwOpType = paramJceInputStream.read(this.dwOpType, 0, false);
    if (cache_stAddGroup == null) {
      cache_stAddGroup = new AddGroup();
    }
    this.stAddGroup = ((AddGroup)paramJceInputStream.read(cache_stAddGroup, 1, false));
    if (cache_stDelGroup == null) {
      cache_stDelGroup = new DelGroup();
    }
    this.stDelGroup = ((DelGroup)paramJceInputStream.read(cache_stDelGroup, 2, false));
    if (cache_stModGroupName == null) {
      cache_stModGroupName = new ModGroupName();
    }
    this.stModGroupName = ((ModGroupName)paramJceInputStream.read(cache_stModGroupName, 3, false));
    if (cache_stModGroupSort == null) {
      cache_stModGroupSort = new ModGroupSort();
    }
    this.stModGroupSort = ((ModGroupSort)paramJceInputStream.read(cache_stModGroupSort, 4, false));
    if (cache_stModFriendGroup == null) {
      cache_stModFriendGroup = new ModFriendGroup();
    }
    this.stModFriendGroup = ((ModFriendGroup)paramJceInputStream.read(cache_stModFriendGroup, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwOpType, 0);
    Object localObject = this.stAddGroup;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stDelGroup;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stModGroupName;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stModGroupSort;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stModFriendGroup;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x17
 * JD-Core Version:    0.7.0.1
 */