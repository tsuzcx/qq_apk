package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class s_friendreq
  extends JceStruct
{
  static ArrayList<s_user> cache_datalist;
  static ArrayList<s_user> cache_datalistnew;
  static ArrayList<s_user> cache_datalistold;
  static Map<Long, String> cache_msglist;
  public int allnum;
  public ArrayList<s_user> datalist;
  public ArrayList<s_user> datalistnew;
  public ArrayList<s_user> datalistold;
  public Map<Long, String> msglist;
  
  public s_friendreq() {}
  
  public s_friendreq(int paramInt, ArrayList<s_user> paramArrayList1, Map<Long, String> paramMap, ArrayList<s_user> paramArrayList2, ArrayList<s_user> paramArrayList3)
  {
    this.allnum = paramInt;
    this.datalist = paramArrayList1;
    this.msglist = paramMap;
    this.datalistnew = paramArrayList2;
    this.datalistold = paramArrayList3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.allnum = paramJceInputStream.read(this.allnum, 0, false);
    s_user locals_user;
    if (cache_datalist == null)
    {
      cache_datalist = new ArrayList();
      locals_user = new s_user();
      cache_datalist.add(locals_user);
    }
    this.datalist = ((ArrayList)paramJceInputStream.read(cache_datalist, 1, false));
    if (cache_msglist == null)
    {
      cache_msglist = new HashMap();
      cache_msglist.put(Long.valueOf(0L), "");
    }
    this.msglist = ((Map)paramJceInputStream.read(cache_msglist, 2, false));
    if (cache_datalistnew == null)
    {
      cache_datalistnew = new ArrayList();
      locals_user = new s_user();
      cache_datalistnew.add(locals_user);
    }
    this.datalistnew = ((ArrayList)paramJceInputStream.read(cache_datalistnew, 3, false));
    if (cache_datalistold == null)
    {
      cache_datalistold = new ArrayList();
      locals_user = new s_user();
      cache_datalistold.add(locals_user);
    }
    this.datalistold = ((ArrayList)paramJceInputStream.read(cache_datalistold, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.allnum, 0);
    Object localObject = this.datalist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.msglist;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.datalistnew;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.datalistold;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_friendreq
 * JD-Core Version:    0.7.0.1
 */