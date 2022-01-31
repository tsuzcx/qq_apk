package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class interest_list
  extends JceStruct
{
  static ArrayList cache_uinlist = new ArrayList();
  static ArrayList cache_users;
  public int allcount;
  public ArrayList uinlist;
  public ArrayList users;
  
  static
  {
    cache_uinlist.add(Long.valueOf(0L));
    cache_users = new ArrayList();
    s_user locals_user = new s_user();
    cache_users.add(locals_user);
  }
  
  public interest_list() {}
  
  public interest_list(ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2)
  {
    this.uinlist = paramArrayList1;
    this.allcount = paramInt;
    this.users = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uinlist = ((ArrayList)paramJceInputStream.read(cache_uinlist, 0, false));
    this.allcount = paramJceInputStream.read(this.allcount, 1, false);
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uinlist != null) {
      paramJceOutputStream.write(this.uinlist, 0);
    }
    paramJceOutputStream.write(this.allcount, 1);
    if (this.users != null) {
      paramJceOutputStream.write(this.users, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.interest_list
 * JD-Core Version:    0.7.0.1
 */