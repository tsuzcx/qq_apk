package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class FunnySpace
  extends JceStruct
{
  static ArrayList<FunnySpaceAction> cache_Actions = new ArrayList();
  public ArrayList<FunnySpaceAction> Actions = null;
  public long TotalCount = 0L;
  public String host_message = "";
  public boolean is_block = false;
  public boolean is_show = false;
  public boolean is_show_cmshowar = true;
  public long uFirePowerCount = 0L;
  public long uFirePowerLevel = 0L;
  
  static
  {
    FunnySpaceAction localFunnySpaceAction = new FunnySpaceAction();
    cache_Actions.add(localFunnySpaceAction);
  }
  
  public FunnySpace() {}
  
  public FunnySpace(ArrayList<FunnySpaceAction> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, long paramLong2, String paramString, long paramLong3)
  {
    this.Actions = paramArrayList;
    this.is_block = paramBoolean1;
    this.is_show = paramBoolean2;
    this.TotalCount = paramLong1;
    this.is_show_cmshowar = paramBoolean3;
    this.uFirePowerCount = paramLong2;
    this.host_message = paramString;
    this.uFirePowerLevel = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Actions = ((ArrayList)paramJceInputStream.read(cache_Actions, 0, false));
    this.is_block = paramJceInputStream.read(this.is_block, 1, false);
    this.is_show = paramJceInputStream.read(this.is_show, 2, false);
    this.TotalCount = paramJceInputStream.read(this.TotalCount, 3, false);
    this.is_show_cmshowar = paramJceInputStream.read(this.is_show_cmshowar, 4, false);
    this.uFirePowerCount = paramJceInputStream.read(this.uFirePowerCount, 5, false);
    this.host_message = paramJceInputStream.readString(6, false);
    this.uFirePowerLevel = paramJceInputStream.read(this.uFirePowerLevel, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.Actions;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.is_block, 1);
    paramJceOutputStream.write(this.is_show, 2);
    paramJceOutputStream.write(this.TotalCount, 3);
    paramJceOutputStream.write(this.is_show_cmshowar, 4);
    paramJceOutputStream.write(this.uFirePowerCount, 5);
    localObject = this.host_message;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.uFirePowerLevel, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.FunnySpace
 * JD-Core Version:    0.7.0.1
 */