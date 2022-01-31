package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_userinfo
  extends JceStruct
{
  static ArrayList<String> cache_luckyMoneyPics;
  static s_user cache_user = new s_user();
  public String action_desc = "";
  public int actiontype = 5;
  public ArrayList<String> luckyMoneyPics;
  public s_user user;
  
  static
  {
    cache_luckyMoneyPics = new ArrayList();
    cache_luckyMoneyPics.add("");
  }
  
  public cell_userinfo() {}
  
  public cell_userinfo(s_user params_user, String paramString, int paramInt)
  {
    this.user = params_user;
    this.action_desc = paramString;
    this.actiontype = paramInt;
    this.luckyMoneyPics = this.luckyMoneyPics;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.action_desc = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.luckyMoneyPics = ((ArrayList)paramJceInputStream.read(cache_luckyMoneyPics, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    if (this.action_desc != null) {
      paramJceOutputStream.write(this.action_desc, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.luckyMoneyPics != null) {
      paramJceOutputStream.write(this.luckyMoneyPics, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_userinfo
 * JD-Core Version:    0.7.0.1
 */