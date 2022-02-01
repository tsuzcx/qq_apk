package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProfFriendInfoReq
  extends JceStruct
{
  static ArrayList<Short> cache_vFieldIdList;
  public byte cDataCode = 0;
  public long uFriendUin = 0L;
  public ArrayList<Short> vFieldIdList = null;
  
  public ProfFriendInfoReq() {}
  
  public ProfFriendInfoReq(long paramLong, byte paramByte, ArrayList<Short> paramArrayList)
  {
    this.uFriendUin = paramLong;
    this.cDataCode = paramByte;
    this.vFieldIdList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFriendUin = paramJceInputStream.read(this.uFriendUin, 0, true);
    this.cDataCode = paramJceInputStream.read(this.cDataCode, 1, true);
    if (cache_vFieldIdList == null)
    {
      cache_vFieldIdList = new ArrayList();
      cache_vFieldIdList.add(Short.valueOf((short)0));
    }
    this.vFieldIdList = ((ArrayList)paramJceInputStream.read(cache_vFieldIdList, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFriendUin, 0);
    paramJceOutputStream.write(this.cDataCode, 1);
    paramJceOutputStream.write(this.vFieldIdList, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.ProfFriendInfoReq
 * JD-Core Version:    0.7.0.1
 */