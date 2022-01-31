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
  public long dwOpType;
  public AddGroup stAddGroup;
  public DelGroup stDelGroup;
  public ModFriendGroup stModFriendGroup;
  public ModGroupName stModGroupName;
  public ModGroupSort stModGroupSort;
  
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
    if (this.stAddGroup != null) {
      paramJceOutputStream.write(this.stAddGroup, 1);
    }
    if (this.stDelGroup != null) {
      paramJceOutputStream.write(this.stDelGroup, 2);
    }
    if (this.stModGroupName != null) {
      paramJceOutputStream.write(this.stModGroupName, 3);
    }
    if (this.stModGroupSort != null) {
      paramJceOutputStream.write(this.stModGroupSort, 4);
    }
    if (this.stModFriendGroup != null) {
      paramJceOutputStream.write(this.stModFriendGroup, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x17
 * JD-Core Version:    0.7.0.1
 */