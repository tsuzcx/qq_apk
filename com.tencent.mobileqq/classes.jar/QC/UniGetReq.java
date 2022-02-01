package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniGetReq
  extends JceStruct
{
  static ArrayList<Integer> cache_appidList;
  static LoginInfo cache_stLogin = new LoginInfo();
  public ArrayList<Integer> appidList;
  public int oidbType;
  public LoginInfo stLogin;
  
  static
  {
    cache_appidList = new ArrayList();
    cache_appidList.add(Integer.valueOf(0));
  }
  
  public UniGetReq() {}
  
  public UniGetReq(LoginInfo paramLoginInfo, ArrayList<Integer> paramArrayList, int paramInt)
  {
    this.stLogin = paramLoginInfo;
    this.appidList = paramArrayList;
    this.oidbType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.appidList = ((ArrayList)paramJceInputStream.read(cache_appidList, 1, true));
    this.oidbType = paramJceInputStream.read(this.oidbType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    paramJceOutputStream.write(this.appidList, 1);
    paramJceOutputStream.write(this.oidbType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniGetReq
 * JD-Core Version:    0.7.0.1
 */