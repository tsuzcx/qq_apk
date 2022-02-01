package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class AcsAckMsgReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  static ArrayList<String> cache_msg_id_list = new ArrayList();
  public AcsHead head = null;
  public ArrayList<String> msg_id_list = null;
  public long uin = 0L;
  
  static
  {
    cache_msg_id_list.add("");
  }
  
  public AcsAckMsgReq() {}
  
  public AcsAckMsgReq(AcsHead paramAcsHead, long paramLong, ArrayList<String> paramArrayList)
  {
    this.head = paramAcsHead;
    this.uin = paramLong;
    this.msg_id_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((AcsHead)paramJceInputStream.read(cache_head, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.msg_id_list = ((ArrayList)paramJceInputStream.read(cache_msg_id_list, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.head;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    localObject = this.msg_id_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsAckMsgReq
 * JD-Core Version:    0.7.0.1
 */