package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_read_space
  extends JceStruct
{
  static ArrayList<s_user> cache_detailreadspace;
  public int allnum;
  public ArrayList<s_user> detailreadspace;
  public int unreadnum;
  
  public s_read_space() {}
  
  public s_read_space(int paramInt1, int paramInt2, ArrayList<s_user> paramArrayList)
  {
    this.allnum = paramInt1;
    this.unreadnum = paramInt2;
    this.detailreadspace = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.allnum = paramJceInputStream.read(this.allnum, 0, false);
    this.unreadnum = paramJceInputStream.read(this.unreadnum, 1, false);
    if (cache_detailreadspace == null)
    {
      cache_detailreadspace = new ArrayList();
      s_user locals_user = new s_user();
      cache_detailreadspace.add(locals_user);
    }
    this.detailreadspace = ((ArrayList)paramJceInputStream.read(cache_detailreadspace, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.allnum, 0);
    paramJceOutputStream.write(this.unreadnum, 1);
    ArrayList localArrayList = this.detailreadspace;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_read_space
 * JD-Core Version:    0.7.0.1
 */