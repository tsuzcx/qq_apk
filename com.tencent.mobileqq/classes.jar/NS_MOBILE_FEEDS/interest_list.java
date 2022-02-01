package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class interest_list
  extends JceStruct
{
  static ArrayList<Long> cache_uinlist = new ArrayList();
  static ArrayList<s_user> cache_users;
  public int allcount;
  public ArrayList<Long> uinlist;
  public ArrayList<s_user> users;
  
  static
  {
    cache_uinlist.add(Long.valueOf(0L));
    cache_users = new ArrayList();
    s_user locals_user = new s_user();
    cache_users.add(locals_user);
  }
  
  public interest_list() {}
  
  public interest_list(ArrayList<Long> paramArrayList, int paramInt, ArrayList<s_user> paramArrayList1)
  {
    this.uinlist = paramArrayList;
    this.allcount = paramInt;
    this.users = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uinlist = ((ArrayList)paramJceInputStream.read(cache_uinlist, 0, false));
    this.allcount = paramJceInputStream.read(this.allcount, 1, false);
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.uinlist;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
    paramJceOutputStream.write(this.allcount, 1);
    localArrayList = this.users;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.interest_list
 * JD-Core Version:    0.7.0.1
 */