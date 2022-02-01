package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class cell_interest
  extends JceStruct
{
  static ArrayList<s_user> cache_users = new ArrayList();
  public String desc = "";
  public int is_interested;
  public int num;
  public ArrayList<s_user> users;
  
  static
  {
    s_user locals_user = new s_user();
    cache_users.add(locals_user);
  }
  
  public cell_interest() {}
  
  public cell_interest(int paramInt1, ArrayList<s_user> paramArrayList, String paramString, int paramInt2)
  {
    this.num = paramInt1;
    this.users = paramArrayList;
    this.desc = paramString;
    this.is_interested = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.users = ((ArrayList)paramJceInputStream.read(cache_users, 1, false));
    this.desc = paramJceInputStream.readString(2, false);
    this.is_interested = paramJceInputStream.read(this.is_interested, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    Object localObject = this.users;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.is_interested, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_interest
 * JD-Core Version:    0.7.0.1
 */