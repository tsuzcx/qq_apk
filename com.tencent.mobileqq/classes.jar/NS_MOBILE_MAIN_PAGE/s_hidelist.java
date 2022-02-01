package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_hidelist
  extends JceStruct
{
  static ArrayList<s_user> cache_datalist;
  public int allnum;
  public ArrayList<s_user> datalist;
  
  public s_hidelist() {}
  
  public s_hidelist(int paramInt, ArrayList<s_user> paramArrayList)
  {
    this.allnum = paramInt;
    this.datalist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.allnum = paramJceInputStream.read(this.allnum, 0, false);
    if (cache_datalist == null)
    {
      cache_datalist = new ArrayList();
      s_user locals_user = new s_user();
      cache_datalist.add(locals_user);
    }
    this.datalist = ((ArrayList)paramJceInputStream.read(cache_datalist, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.allnum, 0);
    ArrayList localArrayList = this.datalist;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_hidelist
 * JD-Core Version:    0.7.0.1
 */