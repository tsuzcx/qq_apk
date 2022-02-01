package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class cell_title
  extends JceStruct
{
  static ArrayList<s_user> cache_talk_user_list;
  static s_user cache_user;
  static ArrayList<s_user> cache_userlist = new ArrayList();
  public int actiontype;
  public int relation;
  public String relation_type = "";
  public int status;
  public ArrayList<s_user> talk_user_list;
  public String title = "";
  public String titleurl = "";
  public s_user user;
  public int useractiontype = 5;
  public ArrayList<s_user> userlist;
  public int usernum;
  
  static
  {
    s_user locals_user = new s_user();
    cache_userlist.add(locals_user);
    cache_user = new s_user();
    cache_talk_user_list = new ArrayList();
    locals_user = new s_user();
    cache_talk_user_list.add(locals_user);
  }
  
  public cell_title() {}
  
  public cell_title(String paramString1, String paramString2, ArrayList<s_user> paramArrayList1, int paramInt1, int paramInt2, s_user params_user, int paramInt3, String paramString3, int paramInt4, ArrayList<s_user> paramArrayList2, int paramInt5)
  {
    this.title = paramString1;
    this.titleurl = paramString2;
    this.userlist = paramArrayList1;
    this.usernum = paramInt1;
    this.actiontype = paramInt2;
    this.user = params_user;
    this.useractiontype = paramInt3;
    this.relation_type = paramString3;
    this.status = paramInt4;
    this.talk_user_list = paramArrayList2;
    this.relation = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.titleurl = paramJceInputStream.readString(1, false);
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.usernum = paramJceInputStream.read(this.usernum, 3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.user = ((s_user)paramJceInputStream.read(cache_user, 5, false));
    this.useractiontype = paramJceInputStream.read(this.useractiontype, 6, false);
    this.relation_type = paramJceInputStream.readString(7, false);
    this.status = paramJceInputStream.read(this.status, 8, false);
    this.talk_user_list = ((ArrayList)paramJceInputStream.read(cache_talk_user_list, 9, false));
    this.relation = paramJceInputStream.read(this.relation, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.titleurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.userlist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    paramJceOutputStream.write(this.usernum, 3);
    paramJceOutputStream.write(this.actiontype, 4);
    localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.useractiontype, 6);
    localObject = this.relation_type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.status, 8);
    localObject = this.talk_user_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    paramJceOutputStream.write(this.relation, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_title
 * JD-Core Version:    0.7.0.1
 */