package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FunnySpace
  extends JceStruct
{
  static ArrayList<FunnySpaceAction> cache_Actions = new ArrayList();
  public ArrayList<FunnySpaceAction> Actions;
  public long TotalCount;
  public boolean is_block;
  public boolean is_show;
  
  static
  {
    FunnySpaceAction localFunnySpaceAction = new FunnySpaceAction();
    cache_Actions.add(localFunnySpaceAction);
  }
  
  public FunnySpace() {}
  
  public FunnySpace(ArrayList<FunnySpaceAction> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.Actions = paramArrayList;
    this.is_block = paramBoolean1;
    this.is_show = paramBoolean2;
    this.TotalCount = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Actions = ((ArrayList)paramJceInputStream.read(cache_Actions, 0, false));
    this.is_block = paramJceInputStream.read(this.is_block, 1, false);
    this.is_show = paramJceInputStream.read(this.is_show, 2, false);
    this.TotalCount = paramJceInputStream.read(this.TotalCount, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.Actions != null) {
      paramJceOutputStream.write(this.Actions, 0);
    }
    paramJceOutputStream.write(this.is_block, 1);
    paramJceOutputStream.write(this.is_show, 2);
    paramJceOutputStream.write(this.TotalCount, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.FunnySpace
 * JD-Core Version:    0.7.0.1
 */