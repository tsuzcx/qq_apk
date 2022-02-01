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
    Integer localInteger = Integer.valueOf(0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localInteger);
    cache_mAppidItems.put(localInteger, localArrayList);
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
    Object localObject = this.stLogin;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.mAppidItems;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiGetSimpleItemReq
 * JD-Core Version:    0.7.0.1
 */