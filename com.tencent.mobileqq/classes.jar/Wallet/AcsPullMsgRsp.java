package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class AcsPullMsgRsp
  extends JceStruct
{
  static ArrayList<AcsMsg> cache_msgs = new ArrayList();
  public String all_url = "";
  public String err_str = "";
  public ArrayList<AcsMsg> msgs = null;
  public int ret_code = 0;
  public String sub_url = "";
  
  static
  {
    AcsMsg localAcsMsg = new AcsMsg();
    cache_msgs.add(localAcsMsg);
  }
  
  public AcsPullMsgRsp() {}
  
  public AcsPullMsgRsp(int paramInt, String paramString1, ArrayList<AcsMsg> paramArrayList, String paramString2, String paramString3)
  {
    this.ret_code = paramInt;
    this.err_str = paramString1;
    this.msgs = paramArrayList;
    this.all_url = paramString2;
    this.sub_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.msgs = ((ArrayList)paramJceInputStream.read(cache_msgs, 2, false));
    this.all_url = paramJceInputStream.readString(3, false);
    this.sub_url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    Object localObject = this.err_str;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.msgs;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.all_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.sub_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsPullMsgRsp
 * JD-Core Version:    0.7.0.1
 */