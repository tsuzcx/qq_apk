package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_comment_essence
  extends JceStruct
{
  static ArrayList<s_commment> cache_commments = new ArrayList();
  public ArrayList<s_commment> commments = null;
  public int displayflag = 0;
  public int num = 0;
  
  static
  {
    s_commment locals_commment = new s_commment();
    cache_commments.add(locals_commment);
  }
  
  public cell_comment_essence() {}
  
  public cell_comment_essence(int paramInt1, ArrayList<s_commment> paramArrayList, int paramInt2)
  {
    this.num = paramInt1;
    this.commments = paramArrayList;
    this.displayflag = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.commments = ((ArrayList)paramJceInputStream.read(cache_commments, 1, false));
    this.displayflag = paramJceInputStream.read(this.displayflag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    ArrayList localArrayList = this.commments;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    paramJceOutputStream.write(this.displayflag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_comment_essence
 * JD-Core Version:    0.7.0.1
 */