package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_friendreq
  extends JceStruct
{
  static ArrayList cache_datalist;
  static ArrayList cache_datalistnew;
  static ArrayList cache_datalistold;
  static Map cache_msglist;
  public int allnum;
  public ArrayList datalist;
  public ArrayList datalistnew;
  public ArrayList datalistold;
  public Map msglist;
  
  public s_friendreq() {}
  
  public s_friendreq(int paramInt, ArrayList paramArrayList1, Map paramMap, ArrayList paramArrayList2, ArrayList paramArrayList3)
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
    if (this.datalist != null) {
      paramJceOutputStream.write(this.datalist, 1);
    }
    if (this.msglist != null) {
      paramJceOutputStream.write(this.msglist, 2);
    }
    if (this.datalistnew != null) {
      paramJceOutputStream.write(this.datalistnew, 3);
    }
    if (this.datalistold != null) {
      paramJceOutputStream.write(this.datalistold, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_friendreq
 * JD-Core Version:    0.7.0.1
 */