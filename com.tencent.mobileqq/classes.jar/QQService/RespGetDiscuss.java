package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RespGetDiscuss
  extends JceStruct
  implements Cloneable
{
  static ArrayList<DiscussInfo> cache_DiscussList;
  static ArrayList<DiscussInfo> cache_FavoriteDiscussList;
  public ArrayList<DiscussInfo> DiscussList = null;
  public ArrayList<DiscussInfo> FavoriteDiscussList = null;
  
  public RespGetDiscuss() {}
  
  public RespGetDiscuss(ArrayList<DiscussInfo> paramArrayList1, ArrayList<DiscussInfo> paramArrayList2)
  {
    this.DiscussList = paramArrayList1;
    this.FavoriteDiscussList = paramArrayList2;
  }
  
  public String className()
  {
    return "QQService.RespGetDiscuss";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.DiscussList, "DiscussList");
    paramStringBuilder.display(this.FavoriteDiscussList, "FavoriteDiscussList");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.DiscussList, true);
    paramStringBuilder.displaySimple(this.FavoriteDiscussList, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (RespGetDiscuss)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.DiscussList, paramObject.DiscussList))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.FavoriteDiscussList, paramObject.FavoriteDiscussList)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "QQService.RespGetDiscuss";
  }
  
  public ArrayList<DiscussInfo> getDiscussList()
  {
    return this.DiscussList;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    DiscussInfo localDiscussInfo;
    if (cache_DiscussList == null)
    {
      cache_DiscussList = new ArrayList();
      localDiscussInfo = new DiscussInfo();
      cache_DiscussList.add(localDiscussInfo);
    }
    this.DiscussList = ((ArrayList)paramJceInputStream.read(cache_DiscussList, 0, true));
    if (cache_FavoriteDiscussList == null)
    {
      cache_FavoriteDiscussList = new ArrayList();
      localDiscussInfo = new DiscussInfo();
      cache_FavoriteDiscussList.add(localDiscussInfo);
    }
    this.FavoriteDiscussList = ((ArrayList)paramJceInputStream.read(cache_FavoriteDiscussList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussList, 0);
    ArrayList localArrayList = this.FavoriteDiscussList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespGetDiscuss
 * JD-Core Version:    0.7.0.1
 */