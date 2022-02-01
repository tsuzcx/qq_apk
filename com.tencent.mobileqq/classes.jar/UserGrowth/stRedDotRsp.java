package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stRedDotRsp
  extends JceStruct
{
  static ArrayList<stRedDotMenu> cache_menu;
  static stNewsRedDot cache_newsReddot;
  static ArrayList<stNotificationRedDot> cache_notificationReddot = new ArrayList();
  static int cache_reddotAction;
  static stSimpleMetaPerson cache_user;
  public ArrayList<stRedDotMenu> menu = null;
  public stNewsRedDot newsReddot = null;
  public ArrayList<stNotificationRedDot> notificationReddot = null;
  public int reddotAction = 0;
  public stSimpleMetaPerson user = null;
  
  static
  {
    Object localObject = new stNotificationRedDot();
    cache_notificationReddot.add(localObject);
    cache_newsReddot = new stNewsRedDot();
    cache_user = new stSimpleMetaPerson();
    cache_menu = new ArrayList();
    localObject = new stRedDotMenu();
    cache_menu.add(localObject);
  }
  
  public stRedDotRsp() {}
  
  public stRedDotRsp(int paramInt, ArrayList<stNotificationRedDot> paramArrayList, stNewsRedDot paramstNewsRedDot, stSimpleMetaPerson paramstSimpleMetaPerson, ArrayList<stRedDotMenu> paramArrayList1)
  {
    this.reddotAction = paramInt;
    this.notificationReddot = paramArrayList;
    this.newsReddot = paramstNewsRedDot;
    this.user = paramstSimpleMetaPerson;
    this.menu = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reddotAction = paramJceInputStream.read(this.reddotAction, 0, false);
    this.notificationReddot = ((ArrayList)paramJceInputStream.read(cache_notificationReddot, 1, false));
    this.newsReddot = ((stNewsRedDot)paramJceInputStream.read(cache_newsReddot, 2, false));
    this.user = ((stSimpleMetaPerson)paramJceInputStream.read(cache_user, 3, false));
    this.menu = ((ArrayList)paramJceInputStream.read(cache_menu, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reddotAction, 0);
    Object localObject = this.notificationReddot;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.newsReddot;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.menu;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stRedDotRsp
 * JD-Core Version:    0.7.0.1
 */