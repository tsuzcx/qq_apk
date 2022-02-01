package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FriendGroup
  extends JceStruct
{
  static ArrayList<Long> cache_vNewGroupID;
  static ArrayList<Long> cache_vOldGroupID;
  public long dwFuin = 0L;
  public ArrayList<Long> vNewGroupID = null;
  public ArrayList<Long> vOldGroupID = null;
  
  public FriendGroup() {}
  
  public FriendGroup(long paramLong, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2)
  {
    this.dwFuin = paramLong;
    this.vOldGroupID = paramArrayList1;
    this.vNewGroupID = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwFuin = paramJceInputStream.read(this.dwFuin, 0, false);
    ArrayList localArrayList = cache_vOldGroupID;
    Long localLong = Long.valueOf(0L);
    if (localArrayList == null)
    {
      cache_vOldGroupID = new ArrayList();
      cache_vOldGroupID.add(localLong);
    }
    this.vOldGroupID = ((ArrayList)paramJceInputStream.read(cache_vOldGroupID, 1, false));
    if (cache_vNewGroupID == null)
    {
      cache_vNewGroupID = new ArrayList();
      cache_vNewGroupID.add(localLong);
    }
    this.vNewGroupID = ((ArrayList)paramJceInputStream.read(cache_vNewGroupID, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwFuin, 0);
    ArrayList localArrayList = this.vOldGroupID;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    localArrayList = this.vNewGroupID;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     IMMsgBodyPack.FriendGroup
 * JD-Core Version:    0.7.0.1
 */