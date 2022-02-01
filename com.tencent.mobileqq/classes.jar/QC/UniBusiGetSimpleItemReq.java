package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class UniBusiGetSimpleItemReq
  extends JceStruct
{
  static Map<Integer, ArrayList<Integer>> cache_mAppidItems;
  static LoginInfo cache_stLogin = new LoginInfo();
  public Map<Integer, ArrayList<Integer>> mAppidItems = null;
  public LoginInfo stLogin = null;
  
  static
  {
    cache_mAppidItems = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    cache_mAppidItems.put(Integer.valueOf(0), localArrayList);
  }
  
  public UniBusiGetSimpleItemReq() {}
  
  public UniBusiGetSimpleItemReq(LoginInfo paramLoginInfo, Map<Integer, ArrayList<Integer>> paramMap)
  {
    this.stLogin = paramLoginInfo;
    this.mAppidItems = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, false));
    this.mAppidItems = ((Map)paramJceInputStream.read(cache_mAppidItems, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLogin != null) {
      paramJceOutputStream.write(this.stLogin, 0);
    }
    if (this.mAppidItems != null) {
      paramJceOutputStream.write(this.mAppidItems, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiGetSimpleItemReq
 * JD-Core Version:    0.7.0.1
 */