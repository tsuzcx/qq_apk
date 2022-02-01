package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UniCheckReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  static ArrayList<UniBusinessItem> cache_uniBusinessItemList = new ArrayList();
  public LoginInfo stLogin = null;
  public ArrayList<UniBusinessItem> uniBusinessItemList = null;
  
  static
  {
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    cache_uniBusinessItemList.add(localUniBusinessItem);
  }
  
  public UniCheckReq() {}
  
  public UniCheckReq(LoginInfo paramLoginInfo, ArrayList<UniBusinessItem> paramArrayList)
  {
    this.stLogin = paramLoginInfo;
    this.uniBusinessItemList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.uniBusinessItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusinessItemList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stLogin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.uniBusinessItemList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniCheckReq
 * JD-Core Version:    0.7.0.1
 */