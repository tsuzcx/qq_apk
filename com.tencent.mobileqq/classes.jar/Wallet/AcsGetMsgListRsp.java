package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AcsGetMsgListRsp
  extends JceStruct
{
  static ArrayList<AcsMsg> cache_data_list = new ArrayList();
  public ArrayList<AcsMsg> data_list = null;
  public String err_str = "";
  public int ret_code = 0;
  public int total = 0;
  
  static
  {
    AcsMsg localAcsMsg = new AcsMsg();
    cache_data_list.add(localAcsMsg);
  }
  
  public AcsGetMsgListRsp() {}
  
  public AcsGetMsgListRsp(int paramInt1, String paramString, ArrayList<AcsMsg> paramArrayList, int paramInt2)
  {
    this.ret_code = paramInt1;
    this.err_str = paramString;
    this.data_list = paramArrayList;
    this.total = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.data_list = ((ArrayList)paramJceInputStream.read(cache_data_list, 2, false));
    this.total = paramJceInputStream.read(this.total, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    if (this.data_list != null) {
      paramJceOutputStream.write(this.data_list, 2);
    }
    paramJceOutputStream.write(this.total, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsGetMsgListRsp
 * JD-Core Version:    0.7.0.1
 */