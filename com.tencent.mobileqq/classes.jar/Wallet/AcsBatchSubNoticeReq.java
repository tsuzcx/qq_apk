package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AcsBatchSubNoticeReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  static ArrayList<String> cache_msg_id_list = new ArrayList();
  public String domain = "";
  public AcsHead head = null;
  public ArrayList<String> msg_id_list = null;
  public long uin = 0L;
  
  static
  {
    cache_msg_id_list.add("");
  }
  
  public AcsBatchSubNoticeReq() {}
  
  public AcsBatchSubNoticeReq(AcsHead paramAcsHead, long paramLong, ArrayList<String> paramArrayList, String paramString)
  {
    this.head = paramAcsHead;
    this.uin = paramLong;
    this.msg_id_list = paramArrayList;
    this.domain = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((AcsHead)paramJceInputStream.read(cache_head, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.msg_id_list = ((ArrayList)paramJceInputStream.read(cache_msg_id_list, 2, false));
    this.domain = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.head != null) {
      paramJceOutputStream.write(this.head, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    if (this.msg_id_list != null) {
      paramJceOutputStream.write(this.msg_id_list, 2);
    }
    if (this.domain != null) {
      paramJceOutputStream.write(this.domain, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsBatchSubNoticeReq
 * JD-Core Version:    0.7.0.1
 */