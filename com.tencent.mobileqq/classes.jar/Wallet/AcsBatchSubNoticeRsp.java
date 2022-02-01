package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AcsBatchSubNoticeRsp
  extends JceStruct
{
  static ArrayList<AcsMsg> cache_msgs = new ArrayList();
  static ArrayList<String> cache_retry_msgs;
  public String err_str = "";
  public ArrayList<AcsMsg> msgs = null;
  public int ret_code = 0;
  public ArrayList<String> retry_msgs = null;
  public int succeed_count = 0;
  
  static
  {
    AcsMsg localAcsMsg = new AcsMsg();
    cache_msgs.add(localAcsMsg);
    cache_retry_msgs = new ArrayList();
    cache_retry_msgs.add("");
  }
  
  public AcsBatchSubNoticeRsp() {}
  
  public AcsBatchSubNoticeRsp(int paramInt1, String paramString, int paramInt2, ArrayList<AcsMsg> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.ret_code = paramInt1;
    this.err_str = paramString;
    this.succeed_count = paramInt2;
    this.msgs = paramArrayList;
    this.retry_msgs = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.succeed_count = paramJceInputStream.read(this.succeed_count, 2, false);
    this.msgs = ((ArrayList)paramJceInputStream.read(cache_msgs, 3, false));
    this.retry_msgs = ((ArrayList)paramJceInputStream.read(cache_retry_msgs, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    paramJceOutputStream.write(this.succeed_count, 2);
    if (this.msgs != null) {
      paramJceOutputStream.write(this.msgs, 3);
    }
    if (this.retry_msgs != null) {
      paramJceOutputStream.write(this.retry_msgs, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsBatchSubNoticeRsp
 * JD-Core Version:    0.7.0.1
 */