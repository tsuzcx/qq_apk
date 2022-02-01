package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class WeishiInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<WeishiFeed> cache_vecWeishiFeeds = new ArrayList();
  public String strSchema = "";
  public ArrayList<WeishiFeed> vecWeishiFeeds = null;
  
  static
  {
    WeishiFeed localWeishiFeed = new WeishiFeed();
    cache_vecWeishiFeeds.add(localWeishiFeed);
  }
  
  public WeishiInfo() {}
  
  public WeishiInfo(ArrayList<WeishiFeed> paramArrayList, String paramString)
  {
    this.vecWeishiFeeds = paramArrayList;
    this.strSchema = paramString;
  }
  
  public String className()
  {
    return "SummaryCard.WeishiInfo";
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
    paramStringBuilder.display(this.vecWeishiFeeds, "vecWeishiFeeds");
    paramStringBuilder.display(this.strSchema, "strSchema");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vecWeishiFeeds, true);
    paramStringBuilder.displaySimple(this.strSchema, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (WeishiInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.vecWeishiFeeds, paramObject.vecWeishiFeeds))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strSchema, paramObject.strSchema)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "SummaryCard.WeishiInfo";
  }
  
  public String getStrSchema()
  {
    return this.strSchema;
  }
  
  public ArrayList<WeishiFeed> getVecWeishiFeeds()
  {
    return this.vecWeishiFeeds;
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
    this.vecWeishiFeeds = ((ArrayList)paramJceInputStream.read(cache_vecWeishiFeeds, 0, false));
    this.strSchema = paramJceInputStream.readString(1, false);
  }
  
  public void setStrSchema(String paramString)
  {
    this.strSchema = paramString;
  }
  
  public void setVecWeishiFeeds(ArrayList<WeishiFeed> paramArrayList)
  {
    this.vecWeishiFeeds = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vecWeishiFeeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.strSchema;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.WeishiInfo
 * JD-Core Version:    0.7.0.1
 */